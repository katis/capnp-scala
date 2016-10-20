package org.capnproto.compiler

import java.nio.file.Paths

import CapnpSchema._
import org.capnproto.runtime.{MessageReader, Text}

import scala.collection.mutable

sealed trait Leaf {
  import Leaf._

  override def toString: String = this match {
    case Reader => "Reader"
    case Builder => "Builder"
    case Owned => "Owned"
    case Client => "Client"
    case Pipeline => "Pipeline"
    case Module => ""
    case List => "List"
    case ListBuilder => "List.Builder"
    case ListReader => "List.Reader"
  }
}

object Leaf {
  object Reader extends Leaf
  object Builder extends Leaf
  object Owned extends Leaf
  object Client extends Leaf
  object Pipeline extends Leaf
  object Module extends Leaf
  object List extends Leaf
  object ListBuilder extends Leaf
  object ListReader extends Leaf
}

class Generator(message: MessageReader) {
  val request = message.getRoot(CodeGeneratorRequest)
  private val nodeMap = mutable.HashMap[Long, Node.Reader]()
  private val scopeMap = mutable.HashMap[Long, Seq[String]]()

  for (node <- request.nodes) {
    nodeMap(node.id) = node
  }

  for (requestedFile <- request.requestedfiles) {
    val id = requestedFile.id
    val imports = requestedFile.imports
    for (imp <- imports) {
      val importPath = imp.name
      val path = Paths.get(importPath.toString).toString
      val rootName = moduleName(s"""${path.toString.replace("-", "_")}""") // TODO: how does this work
      populateScope(Seq(rootName), imp.id)
    }

    val rootName = requestedFile.filename
    populateScope(Seq(), id)
  }

  def structTypePreamble(nodeId: Long, data: Int, pointers: Int) = Seq(Indent(Branch(
    Line(s"val typeId: Long = ${nodeId}L"), // TODO: Add as a Struct abstract method
    Line(s"override val structSize: org.capnproto.runtime.StructSize = new org.capnproto.runtime.StructSize($data, $pointers)"),
    BlankLine,
    Line("override type Reader = ReaderImpl"),
    Line("override type Builder = BuilderImpl"),
    BlankLine,
    Line("override val Builder: (org.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)"),
    Line("override val Reader: (org.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)"),
    BlankLine)
  ))

  def generateNode(nodeId: Long, nodeName: String, parentNodeId: Option[Long] = None, groupDiscriminant: Option[Short] = None): FormattedText = {
    val output = mutable.ArrayBuffer[FormattedText]()
    val nestedOutput = mutable.ArrayBuffer[FormattedText]()

    val nodeReader = nodeMap(nodeId)
    val nestedNodes = nodeReader.nestednodes
    for (nestedNode <- nestedNodes) {
      val id = nestedNode.id
      nestedOutput += generateNode(id, scopeMap(id).last)
    }

    import Node.Which._
    nodeReader.which match {
      case FILE => output += Branch(nestedOutput:_*)
      case CONST =>
        val const = nodeReader.const
        val styledName = scopeMap(nodeId).last.capitalize
        import Type.{Which => T}
        import Value.{Which => V}
        val (typ: String, contents: String) = (const.capnpType.which, const.value.which) match {
          case (T.VOID, V.VOID) => ("Unit", "()")
          case (T.INT8, V.INT8) => ("Byte", const.value.int8.toString)
          case (T.INT16, V.INT16) => ("Short", const.value.int16.toString)
          case (T.INT32, V.INT32) => ("Int", const.value.int32.toString)
          case (T.INT64, V.INT64) => ("Long", const.value.int64.toString)
          case (T.UINT8, V.UINT8) => ("Byte", const.value.uint8.toString)
          case (T.UINT16, V.UINT16) => ("Short", const.value.uint16.toString)
          case (T.UINT32, V.UINT32) => ("Int", const.value.uint32.toString)
          case (T.UINT64, V.UINT64) => ("Long", const.value.uint64.toString)
          case (T.FLOAT32, V.FLOAT32) => ("Float", const.value.float32.toString)
          case (T.FLOAT64, V.FLOAT64) => ("Double", const.value.float64.toString)
          case (t, v) => throw new UnsupportedOperationException(s"$t constants are not implemented")
        }
        output += Line(s"val $styledName: $typ = $contents")
      case STRUCT =>
        val struct = nodeReader.struct
        val params = parametersTexts(nodeReader)
        output += BlankLine

        val isGeneric = nodeReader.isgeneric
        if (isGeneric) {
          // TODO: Implement generic structs
          output += Line(s"object $nodeName extends org.capnproto.runtime.Struct { ")
        } else {
          output += Line(s"object $nodeName extends org.capnproto.runtime.Struct { ")
        }

        val unionFields = mutable.ArrayBuffer[Field.Reader]()
        val builderMembers, readerMembers = mutable.ArrayBuffer[FormattedText]()
        var extractors: Option[FormattedText] = None

        val dataSize = struct.datawordcount
        val pointerSize = struct.pointercount
        val discriminantCount = struct.discriminantcount
        val discriminantOffset = struct.discriminantoffset

        output ++= structTypePreamble(nodeId, dataSize, pointerSize)

        (struct.isgroup, groupDiscriminant) match {
          case (true, Some(discriminant)) =>
            val parent = scopeMap(nodeId).dropRight(1).mkString(".")
            val fieldName = {
              val n = nodeName.toLowerCase.head + nodeName.tail
              // TODO: remove this silly hack for getting a proper field name for the group
              if (n.endsWith("_") && keywords.contains(nodeName.substring(0, nodeName.length-1))) {
                n.substring(0, n.length - 1)
              } else {
                n
              }
            }
            output ++= Seq("Reader", "Builder")
                .map(leaf =>
                  Indent(Branch(
                    Line(s"def unapply(value: $parent.$leaf): Option[$leaf] = {"),
                    Indent(Line(s"if (value._whichIndex == $discriminant) Some(value.$fieldName) else None")),
                  Line("}")))
                )
          case _ =>
        }

        val fields = struct.fields
        for (field <- fields) {
          val name = field.name
          val styledName = name.toString

          val discriminantValue = field.discriminantvalue
          val isUnionField = discriminantValue != Field.NO_DISCRIMINANT

          val getterAccessLevel = if (isUnionField) s"private[$nodeName] " else ""
          if (isUnionField) {
            unionFields += field
          }

          val (ty, get) = getterText(field, isReader = true)

          if (!(isUnionField && field.isSlot && field.slot.capnpType.which == Type.Which.VOID)) {
            val (tyB, getB) = getterText(field, isReader = false)

            readerMembers += Branch(
              Line(s"${getterAccessLevel}def ${methodName(styledName)}: $ty = {"),
              Indent(get),
              Line("}")
            )
            builderMembers += Branch(
              Line(s"${getterAccessLevel}def ${methodName(styledName)}: $tyB = {"),
              Indent(getB),
              Line("}")
            )
          }

          builderMembers += generateSetter(discriminantOffset, styledName, field)

          field.which match {
            case Field.Which.GROUP=>
              val groupDiscriminant = if (discriminantCount > 0) Some(discriminantValue) else None
              val id = field.group.capnpTypeid
              val text = generateNode(id, scopeMap(id).last, groupDiscriminant = groupDiscriminant)
              nestedOutput += text
            case _ =>
          }
        }

        if (discriminantCount > 0) {
          val readerResult = generateUnionExtractors(discriminantOffset, unionFields, isReader = true, params)
          val whichIndexDef = Line(s"private[$nodeName] def _whichIndex: Short = _getShortField($discriminantOffset)")
          readerMembers += whichIndexDef
          builderMembers += whichIndexDef
          extractors = Some(Indent(Branch(readerResult.extractors:_*)))
        }

        output += Indent(Branch(
          Line("class ReaderImpl(_segment: org.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {"),
          Indent(Branch(readerMembers:_*)),
          Line("}")
        ))
        output += Indent(Branch(
          Line("class BuilderImpl(_segment: org.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {"),
          Indent(Branch(builderMembers:_*)),
          Line("}")
        ))

        extractors.foreach(output.+=)

        output += Branch(Indent(Branch(nestedOutput:_*)))
        output += Line("}")
      case ENUM =>
        val enumReader = nodeReader.enum
        val names = scopeMap(nodeId)
        val enumClassName = moduleName(names.last.capitalize)
        output += BlankLine
        val members, enumerantValues = mutable.ArrayBuffer[FormattedText]()
        val enumerants = enumReader.enumerants

        val enumerantsSize = enumerants.size
        for (i <- 0 until enumerantsSize) {
          val enumerant = enumerants(i)

          val enumerantName = moduleName(enumerant.name.toString.capitalize)
          members += Line(s"object $enumerantName extends $enumClassName($i)")

          if (i < enumerantsSize - 1) {
            enumerantValues += Line(s"$enumClassName.$enumerantName,")
          } else {
            enumerantValues += Line(s"$enumClassName.$enumerantName")
          }
        }

        output += Branch(
          Line(s"sealed class $enumClassName(index: Short) extends org.capnproto.runtime.Enum(index)"),
          Line(s"object $enumClassName extends org.capnproto.runtime.EnumModule[$enumClassName] {"),
          Indent(Branch(
            Branch(
              Line(s"override val enumValues: Seq[$enumClassName] = Array("),
              Indent(Branch(enumerantValues:_*)),
              Line(")"),
              Line(s"val _wrappedValues: Seq[Option[$enumClassName]] = enumValues.map(Some(_))"),
              Line(s"def apply(value: Short): Option[$enumClassName] = if (value >= 0 && value < _wrappedValues.length) _wrappedValues(value) else None")
            ),
            Branch(members:_*)
          )),
          Line("}")
        )
    }

    Branch(output:_*)
  }

  def generatePipelineGetter(field: Field.Reader): FormattedText = {
    Line("PIPELINED_GETTER")
  }

  def groupType(group: Field.Group.Reader, isReader: Boolean): String = {
    val module = scopeMap(group.capnpTypeid).mkString(".")
    val suffix = if (isReader) "Reader" else "Builder"
    s"$module.$suffix"
  }

  def getterText(field: Field.Reader, isReader: Boolean): (String, FormattedText) = {
    import Field.Which._

    field.which match {
      case GROUP =>
        val group = field.group
        val t = groupType(group, isReader)
        if (isReader)
          (t, Line(s"$t(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit)"))
        else
          (t, Line(s"$t(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)"))
      case SLOT =>
        val regField = field.slot
        val offset = regField.offset
        val moduleString = if (isReader) "Reader" else "Builder"
        val module = if (isReader) "" else ""
        val member = moduleString
        val leaf = if (isReader) Leaf.Reader else Leaf.Builder

        val rawType = regField.capnpType
        val typ = typeString(rawType, leaf)
        val default = regField.defaultvalue.which
        val defaultVal = regField.defaultvalue

        val resultType = rawType.which match {
          case Type.Which.STRUCT | Type.Which.TEXT | Type.Which.DATA | Type.Which.ENUM =>
            s"Option[$typ]"
          case Type.Which.LIST =>
            val listType = typeString(rawType, leaf)
            s"Option[$listType]"
          case Type.Which.ANY_POINTER if rawType.isParameter => typ
          case Type.Which.ANY_POINTER => s"Option[$typ]"
          case Type.Which.INTERFACE => ???
          case _ if rawType.isPrimitive => typ
          case _ => typ
        }

        def primitiveCase[T](typ: String, offset: Long, default: T, zero: T): FormattedText = {
          if (default == zero) {
            Line(s"this._get${typ}Field($offset)")
          } else {
            Line(s"this._get${typ}Field($offset, $default)")
          }
        }

        import Type.{Which => WTyp}
        import Value.{Which => WVal}
        val getterCode = (rawType.which, default) match {
          case (WTyp.VOID, WVal.VOID) => Line("org.capnproto.runtime.Void")
          case (WTyp.BOOL, WVal.BOOL) =>
            if (defaultVal.bool) Line(s"_getBooleanField($offset, true)")
            else Line(s"_getBooleanField($offset)")
          case (WTyp.INT8, WVal.INT8) => primitiveCase(typ, offset, defaultVal.int8, 0)
          case (WTyp.INT16, WVal.INT16) => primitiveCase(typ, offset, defaultVal.int16, 0)
          case (WTyp.INT32, WVal.INT32) => primitiveCase(typ, offset, defaultVal.int32, 0)
          case (WTyp.INT64, WVal.INT64) => primitiveCase(typ, offset, defaultVal.int64, 0)
          case (WTyp.UINT8, WVal.UINT8) => primitiveCase(typ, offset, defaultVal.uint8, 0)
          case (WTyp.UINT16, WVal.UINT16) => primitiveCase(typ, offset, defaultVal.uint16, 0)
          case (WTyp.UINT32, WVal.UINT32) => primitiveCase(typ, offset, defaultVal.uint32, 0)
          case (WTyp.UINT64, WVal.UINT64) => primitiveCase(typ, offset, defaultVal.uint64, 0)
          case (WTyp.FLOAT32, WVal.FLOAT32) => primitiveCase(typ, offset, defaultVal.float32, 0)
          case (WTyp.FLOAT64, WVal.FLOAT64) => primitiveCase(typ, offset, defaultVal.float64, 0)
          case (WTyp.TEXT, WVal.TEXT) => Line(s"_getPointerFieldOption(org.capnproto.runtime.Text, $offset)")
          case (WTyp.DATA, WVal.DATA) => Line(s"_getPointerFieldOption(org.capnproto.runtime.Data, $offset)")
          case (WTyp.LIST, WVal.LIST) =>
            Line(s"_getPointerFieldOption(${typeString(rawType, Leaf.Module)}, $offset)")
          case (WTyp.ENUM, WVal.ENUM) =>
            val module = typeString(rawType, Leaf.Module)
            Line(s"$module(_getShortField($offset))")
          case (WTyp.STRUCT, WVal.STRUCT) =>
            val module = typeString(rawType, Leaf.Module)
            Line(s"_getPointerFieldOption($module, $offset)")
          case (WTyp.ANY_POINTER, WVal.ANY_POINTER) => Line(s"_getPointerFieldOption(org.capnproto.runtime.AnyPointer, $offset)")
          case (WTyp.INTERFACE, WVal.INTERFACE) => ???
          case _ => throw new Error(s"Default value was of wrong type (expected ${rawType.which}, got $default)")
        }

        (resultType, getterCode)
    }
  }

  def generateSetter(discriminantOffset: Int, styledName: String, field: Field.Reader): FormattedText = {
    val initterInterior, setterInterior = mutable.ArrayBuffer[FormattedText]()
    var setterParam = "value"
    val initterParams = mutable.ArrayBuffer[String]()
    var textSetterInterior: Option[FormattedText] = None

    val discriminantValue = field.discriminantvalue
    if (discriminantValue != Field.NO_DISCRIMINANT) {
      val doStr = java.lang.Long.toUnsignedString(discriminantOffset.toLong)
      val dvStr = java.lang.Long.toUnsignedString(discriminantValue.toLong)
      setterInterior += Line(s"_setShortField($doStr, $dvStr)")
      initterInterior += Line(s"_setShortField($doStr, $dvStr)")
    }

    var setterGenericParam = ""
    var returnResult = false
    val result = mutable.ArrayBuffer[FormattedText]()

    val (maybeReaderType, maybeBuilderType) = field.which match {
      case Field.Which.GROUP =>
        val group = field.group
        val scope = scopeMap(group.capnpTypeid)
        val module = scope.mkString(".")
        initterInterior ++= Seq(
          zeroFieldsOfGroup(group.capnpTypeid),
          Line(s"$module.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)"))
        (None, Some(s"$module.Builder"))
      case Field.Which.SLOT =>
        val regField = field.slot
        val offset = regField.offset
        val typ = regField.capnpType
        typ.which match {
          case Type.Which.VOID =>
            setterParam = "_value"
            (Some("Unit"), None)
          case Type.Which.BOOL =>
            primitiveDefault(regField.defaultvalue) match {
              case None => setterInterior += Line(s"_setBooleanField($offset, value)")
              case Some(s) => setterInterior += Line(s"_setBooleanField($offset, value, $s)")
            }
            (Some("Boolean"), None)
          case _ if typ.isPrimitive =>
            val tstr = typeString(typ, Leaf.Reader)
            primitiveDefault(regField.defaultvalue) match {
              case None =>
                setterInterior += Line(s"_set${tstr}Field($offset, value)")
              case Some(s) =>
                setterInterior += Line(s"_set${tstr}Field($offset, value, $s)")
            }
            (Some(tstr), None)
          case Type.Which.TEXT =>
            setterInterior += Line(s"""_setPointerField(org.capnproto.runtime.Text)($offset, value)""")
            initterInterior += Line(s"_initPointerField(org.capnproto.runtime.Text, $offset, size)")
            textSetterInterior = Some(Line(s"_setPointerField(org.capnproto.runtime.Text)($offset, org.capnproto.runtime.Text.Reader(value))"))
            initterParams += "size: Int"
            (Some("org.capnproto.runtime.Text.Reader"), Some("org.capnproto.runtime.Text.Builder"))
          case Type.Which.ANY_POINTER =>
            initterInterior += Line(s"_initPointerField(org.capnproto.runtime.AnyPointer, $offset, size)")
            initterParams += "size: Int = 0"
            (Some("org.capnproto.runtime.AnyPointer.Reader"), Some("org.capnproto.runtime.AnyPointer.Builder"))
          case Type.Which.DATA =>
            setterInterior += Line(s"""_setPointerField(org.capnproto.runtime.Data)($offset, value)""")
            initterInterior += Line(s"_initPointerField(org.capnproto.runtime.Data, $offset, size)")
            initterParams += "size: Int"
            (Some("org.capnproto.runtime.Data.Reader"), Some("org.capnproto.runtime.Data.Builder"))
          case Type.Which.LIST =>
            val elementFactory = typeString(typ, Leaf.Module)
            setterInterior += Line(s"""_setPointerField($elementFactory)($offset, value)""")
            initterInterior += Line(s"_initPointerField($elementFactory, $offset, size)")
            initterParams += "size: Int"
            (Some(s"$elementFactory.Reader"), Some(s"$elementFactory.Builder"))
          case Type.Which.ENUM =>
            val ty = typeString(typ, Leaf.Builder)
            setterInterior += Line(s"_setShortField(value.index, $offset)")
            (Some(ty), None)
          case Type.Which.STRUCT =>
            returnResult = true
            initterInterior += Line(s"_initPointerField(${typeString(typ, Leaf.Module)}, $offset, 0)")
            if (typ.isBranded) {
              setterInterior += Line(s"_setPointerField(${typeString(typ, Leaf.Module)})($offset, value)")
              (Some(typeString(typ, Leaf.Reader)), Some(typeString(typ, Leaf.Builder)))
            } else {
              setterInterior += Line(s"_setPointerField(${typeString(typ, Leaf.Module)})($offset, value)")
              (Some(typeString(regField.capnpType, Leaf.Reader)), Some(typeString(regField.capnpType, Leaf.Builder)))
            }
          case Type.Which.INTERFACE => ???
          case _ => throw new Error("Unrecognized type")
        }
    }

    maybeReaderType match {
      case Some(readerType) =>
        val retType = "Unit"
        result ++= Seq(
          Line(s"def ${styledName}_=($setterParam: $readerType): $retType = {"),
          Indent(Branch(setterInterior:_*)),
          Line(s"}")
        )

        textSetterInterior.foreach(interior => {
          result ++= Seq(
            Line(s"def ${styledName}_=($setterParam: String): $retType = {"),
            Indent(Branch(interior)),
            Line(s"}")
          )
        })
      case None =>
    }

    maybeBuilderType match {
      case Some(builderType) =>
        val args = initterParams.mkString(", ")
        result ++= Seq(
          Line(s"def init${styledName.capitalize}($args): $builderType = {"),
          Indent(Branch(initterInterior:_*)),
          Line(s"}")
        )
      case None =>
    }

    Branch(result:_*)
  }

  case class UnionResult(extractors: Seq[FormattedText])

  def generateUnionExtractors(discriminantOffset: Int, fields: Seq[Field.Reader], isReader: Boolean, params: TypeParameterTexts): UnionResult = {
    def hasExtractorObject(field: Field.Reader): Boolean = {
      field.isSlot && (field.slot.capnpType.which match {
        case Type.Which.STRUCT | Type.Which.ENUM => false
        case _ => true
      })
    }

    val extractors = mutable.ArrayBuffer[FormattedText]()

    for (field <- fields.filter(hasExtractorObject)) {
      val dvalue = java.lang.Short.toUnsignedLong(field.discriminantvalue)
      val fieldName = field.name
      val enumerantName = moduleName(fieldName.toString.capitalize)

      val (ty, _) = getterText(field, isReader = true)
      val (tyB, _) = getterText(field, isReader = false)

      val extractor = if (field.slot.capnpType.which == Type.Which.VOID) {
            Branch(
              Line(s"object $enumerantName {"),
              Indent(Branch(
                Line(s"def unapply(value: Reader): Boolean = value._whichIndex == $dvalue"),
                Line(s"def unapply(value: Builder): Boolean = value._whichIndex == $dvalue")
              )),
              Line("}")
            )
          } else {
            val wrappedInOption = field.slot.capnpType.isPrimitive || field.isGroup
            val fieldGetter = if (wrappedInOption) s"Some(value.$fieldName)" else s"value.$fieldName"
            val unapplyType = if (wrappedInOption) s"Option[$ty]" else ty
            val unapplyTypeB = if (wrappedInOption) s"Option[$tyB]" else tyB
            Branch(
              Line(s"object $enumerantName {"),
              Indent(Branch(
                Branch(
                  Line(s"def unapply(value: Reader): $unapplyType = {"),
                  Indent(Branch(
                    Line(s"if (value._whichIndex == $dvalue) $fieldGetter else None")
                  )),
                  Line("}")
                ),
                Branch(
                  Line(s"def unapply(value: Builder): $unapplyTypeB = {"),
                  Indent(Branch(
                    Line(s"if (value._whichIndex == $dvalue) $fieldGetter else None")
                  )),
                  Line("}")
                )
              )),
              Line("}")
            )
          }
          extractors += extractor
      }

    UnionResult(extractors)
  }

  def primitiveDefault(value: Value.Reader): Option[String] = {
    import Value.Which._

    value.which match {
      case BOOL => if (value.bool) Some("true") else None
      case INT8 =>
        val v = value.int8
        if (v == 0) None else Some(v.toString)
      case INT16 =>
        val v = value.int16
        if (v == 0) None else Some(v.toString)
      case INT32 =>
        val v = value.int32
        if (v == 0) None else Some(v.toString)
      case INT64 =>
        val v = value.int64
        if (v == 0) None else Some(v.toString)
     case UINT8 =>
        val v = value.uint8
        if (v == 0) None else Some(v.toString)
      case UINT16 =>
        val v = value.uint16
        if (v == 0) None else Some(v.toString)
      case UINT32 =>
        val v = value.uint32
        if (v == 0) None else Some(v.toString)
      case UINT64 =>
        val v = value.uint64
        if (v == 0) None else Some(v.toString)
     case FLOAT32 =>
        val v = value.float32
        if (v == 0.0) None else Some(v.toString)
      case FLOAT64 =>
        val v = value.float64
        if (v == 0.0) None else Some(v.toString)
      case _ => throw new Error(s"Expected a primitive value, got ${value.which}")
    }
  }

  def zeroFieldsOfGroup(nodeId: Long): FormattedText = {
    val node = nodeMap(nodeId)
    node.which match {
      case Node.Which.STRUCT =>
        val st = node.struct
        val result = mutable.ArrayBuffer[FormattedText]()
        if (st.discriminantcount != 0) {
          result += Line(s"_setShortField(${st.discriminantoffset}, 0)")
        }
        val fields = st.fields
        for (field <- fields) {
          field.which match {
            case Field.Which.GROUP => result += zeroFieldsOfGroup(field.group.capnpTypeid)
            case Field.Which.SLOT =>
              val slot = field.slot
              val typ = slot.capnpType.which
              typ match {
                case Type.Which.VOID =>
                case Type.Which.BOOL =>
                  val line = Line(s"_setBooleanField(${slot.offset}, false)")
                  if (result.contains(line)) {
                    result += line
                  }
                case Type.Which.INT8 | Type.Which.INT16 | Type.Which.INT32 | Type.Which.INT64
                    | Type.Which.UINT8 | Type.Which.UINT16 | Type.Which.UINT32 | Type.Which.UINT64
                    | Type.Which.FLOAT32 | Type.Which.FLOAT64 =>
                  val line = Line(s"_set${typeString(slot.capnpType, Leaf.Module)}Field(${slot.offset}, 0)")
                  if (!result.contains(line)) result += line
                case Type.Which.ENUM =>
                  val line = Line(s"_setShortField(${slot.offset}, 0)")
                  if (!result.contains(line)) result += line
                case Type.Which.STRUCT | Type.Which.LIST | Type.Which.TEXT | Type.Which.DATA
                     | Type.Which.ANY_POINTER | Type.Which.INTERFACE =>
                  val line = Line(s"_clearPointerField(${slot.offset})")
                  if (!result.contains(line)) result += line
              }
          }
        }
        Branch(result:_*)
      case _ => throw new Error("Expected a struct")
    }
  }

  private def populateScope(scopeNames: Seq[String], nodeId: Long): Unit = {
    import Node.Which._

    scopeMap(nodeId) = scopeNames

    val nodeReader = nodeMap.get(nodeId) match {
      case Some(n) => n
      case _ => return
    }

    val nestedNodes = nodeReader.nestednodes
    for (nestedNode <- nestedNodes) {
      val nScopeNames = mutable.ArrayBuffer(scopeNames:_*)
      val nestedNodeId = nestedNode.id
      nodeMap.get(nestedNodeId) match {
        case None =>
        case Some(nNodeReader) =>
          nNodeReader.which match {
            case ENUM =>
              nScopeNames += moduleName(nestedNode.name.toString)
              populateScope(nScopeNames, nestedNodeId)
            case _ =>
              populateScope(scopeNames :+ moduleName(nestedNode.name), nestedNodeId)
          }
      }
    }

    nodeReader.which match {
      case STRUCT =>
        val struct = nodeReader.struct
        val fields = struct.fields
        for (field <- fields) {
          import Field.Which._

          field.which match {
            case GROUP =>
              val name = moduleName(field.name.toString.capitalize)
              populateScope(scopeNames :+ name, field.group.capnpTypeid)
            case _ =>
          }
        }
      case _ =>
    }
  }

  def parametersTexts(node: Node.Reader, parentNodeId: Option[Long] = None): TypeParameterTexts = {
    if (node.isgeneric) {
      val params = getTypeParameters(node.id, parentNodeId)
      val typeParameters = params.map(_.toString).mkString(",")
      TypeParameterTexts(expandedList = params, params = typeParameters)
    } else {
      TypeParameterTexts(expandedList = Seq(), params = "")
    }
  }

  def getTypeParameters(nodeId: Long, _parentScopeId: Option[Long] = None): Seq[String] = {
    var parentScopeId = _parentScopeId
    var currentNodeId = nodeId
    val accumulator = mutable.ArrayBuffer[Seq[String]]()

    var run = true
    while (run) {
      nodeMap.get(currentNodeId) match {
        case None => run = false
        case Some(currentNode) =>
          val params = currentNode.parameters.map(_.name.toString).toSeq
          accumulator += params

          currentNodeId = currentNode.scopeid
          (currentNodeId, parentScopeId) match {
            case (0, Some(id)) => currentNodeId = id
            case _ => ()
          }

          parentScopeId = None
      }
    }

    accumulator.reverse.flatten
  }

  def moduleName(name: Text.Reader): String = {
    val nameStr = name.toString
    moduleName(nameStr)
  }

  def moduleName(name: String): String = {
    if (keywords.contains(name)) name+"_" else name
  }

  def methodName(name: String): String = if (keywords.contains(name)) s"`$name`" else name

  def doBranding(nodeId: Long, brand: Brand.Reader, leaf: Leaf, module: String, _parentScopeId: Option[Long]): String = {
    var parentScopeId = _parentScopeId

    val scopes = brand.scopes
    val brandScopes = mutable.HashMap[Long, Brand.Scope.Reader](scopes.map(s => (s.scopeid, s)).toSeq:_*)
    var currentNodeId = nodeId
    val accumulator = mutable.ArrayBuffer[Seq[String]]()

    var run = true
    while (run) {
      nodeMap.get(currentNodeId) match {
        case None => run = false
        case Some(currentNode) =>
          val params = currentNode.parameters
          val arguments = mutable.ArrayBuffer[String]()
          brandScopes.get(currentNodeId) match {
            case None =>
              for (_ <- params) {
                arguments += "::capnp::any_pointer::Owned"
              }
            case Some(scope) =>
              scope.which match {
                case Brand.Scope.Which.INHERIT =>
                  arguments ++= params.map(_.name.toString)
                case Brand.Scope.Which.BIND =>
                  val bindingsList = scope.bind
                  assert(bindingsList.size == params.size)
                  arguments ++= bindingsList.map {
                    case v if v.which == Brand.Binding.Which.UNBOUND =>
                      "::capnp::any_pointer::Owned"
                    case t if t.which == Brand.Binding.Which.TYPE =>
                      typeString(t.capnpType, Leaf.Owned)
                  }
              }
          }

          accumulator += arguments
          currentNodeId = currentNode.scopeid
          (currentNodeId, parentScopeId) match {
            case (0, Some(id)) => currentNodeId = id
            case _ =>
          }

          parentScopeId = None
      }
    }

    val args = accumulator.reverse.flatten

    val arguments = if (args.isEmpty) {
      ""
    } else {
      val argStr = args.mkString(", ")
      s"[$argStr]"
    }

    leaf match {
      case Leaf.Module => s"$module$arguments"
      case l => s"$module.$l$arguments"
    }
  }

  def typeString(typ: CapnpSchema.Type.Reader, module: Leaf): String = {
    import Type.Which._
    val moduleSuffix = module match {
      case Leaf.Module => ""
      case leaf => s".$leaf"
    }

    typ.which match {
      case VOID => "org.capnproto.runtime.Void"
      case BOOL => "Boolean"
      case INT8 => "Byte"
      case INT16 => "Short"
      case INT32 => "Int"
      case INT64 => "Long"
      case UINT8 => "Byte"
      case UINT16 => "Short"
      case UINT32 => "Int"
      case UINT64 => "Long"
      case FLOAT32 => "Float"
      case FLOAT64 => "Double"
      case TEXT => s"org.capnproto.runtime.Text$moduleSuffix"
      case DATA => s"org.capnproto.runtime.Data$moduleSuffix"
      case STRUCT =>
        val st = typ.struct
        val moduleName = scopeMap(st.capnpTypeid).mkString(".")
        doBranding(st.capnpTypeid, st.brand, module, moduleName, None)
      case INTERFACE =>
        val interface = typ.interface
        doBranding(interface.capnpTypeid, interface.brand, module, scopeMap(interface.capnpTypeid).mkString("."), None)
      case LIST =>
        val ot1 = typ.list
        val elType = ot1.elementtype
        listTypeString(elType, module)
      case ENUM =>
        val enum = typ.enum
        val scope = scopeMap(enum.capnpTypeid)
        scope.mkString(".")
      case ANY_POINTER =>
        import Type.AnyPointer.Which._
        val pointer = typ.anypointer
        pointer.which match {
          case PARAMETER =>
            val definition = pointer.parameter
            val theStruct = nodeMap(definition.scopeid)
            val parameters = theStruct.parameters
            val parameter = parameters(definition.parameterindex)
            val parameterName = parameter.name
            module match {
              case Leaf.Owned => parameterName.toString
              case Leaf.Reader => s"$parameterName.Reader"
              case Leaf.Builder => s"$parameterName.Builder"
              case _ => ???
            }
          case _ =>
            module match {
              case Leaf.Reader => "org.capnproto.runtime.AnyPointer.Reader"
              case Leaf.Builder => "org.capnproto.runtime.AnyPointer.Builder"
              case Leaf.Module => "org.capnproto.runtime.AnyPointer"
            }
        }
    }
  }

  def listTypeString(elementType: Type.Reader, module: Leaf): String = {
    import Type.Which._
    val moduleSuffix = module match {
      case Leaf.Module => ""
      case m => s".$m"
    }
    elementType.which match {
      case STRUCT | ENUM => typeString(elementType, Leaf.Module) + s".List$moduleSuffix"
      case TEXT => s"org.capnproto.runtime.Text.List$moduleSuffix"
      case ANY_POINTER => s"org.capnproto.runtime.AnyPointer.List$moduleSuffix"
      case DATA => s"org.capnproto.runtime.Data.List$moduleSuffix"
      case _ if elementType.isPrimitive => s"org.capnproto.runtime.PrimitiveList.${typeString(elementType, Leaf.Module)}$moduleSuffix"
    }
  }
}
