package org.murtsi.capnproto.compiler

import org.murtsi.capnproto.compiler.schema._
import org.murtsi.capnproto.runtime.{MessageReader, Text}
import org.murtsi.capnproto.runtime.implicits._

import scala.annotation.tailrec
import scala.collection.immutable.HashMap
import scala.collection.mutable

sealed trait Leaf {
  import Leaf._

  override def toString: String = this match {
    case Reader => "Reader"
    case Builder => "Builder"
    case Client => "Client"
    case Pipeline => "Pipeline"
    case Module => ""
  }
}

object Leaf {
  object Reader extends Leaf
  object Builder extends Leaf
  object Client extends Leaf
  object Pipeline extends Leaf
  object Module extends Leaf
}

class NodeTypeTree {
  private case class Entry(name: String, parent: Option[Long], genericArgs: Vector[String])
  private val entries = new mutable.HashMap[Long, Entry]

  def add(nodeId: Long, name: String, parent: Option[Long] = None, genericArgs: Vector[String] = Vector.empty): Unit = {
    entries(nodeId) = Entry(name, parent, genericArgs)
  }

  def allGenericParams(nodeId: Long): Seq[String] = {
    def buildGenericParams(id: Long, acc: Seq[String]): Seq[String] = {
      entries.get(id) match {
        case Some(Entry(_, Some(parent), genericArgs)) =>
          buildGenericParams(parent, genericArgs ++ acc)
        case Some(Entry(_, _, genericArgs)) =>
          genericArgs ++ acc
        case None =>
          acc
      }
    }

    buildGenericParams(nodeId, Seq())
  }

  def fullType(nodeId: Long, withGenericParams: Boolean = true, typeSeparator: String = "."): String = {
    def nextPart(name: String, genericArgs: Vector[String], prev: String): String = {
      val ga = if (!withGenericParams || genericArgs.isEmpty) "" else s"[${genericArgs.mkString(", ")}]"
      if (prev.isEmpty) s"$name$ga" else s"$name$ga$typeSeparator$prev"
    }

    def buildFullType(id: Long, prev: String): String = {
      entries.get(id) match {
        case Some(Entry(name, Some(parent), genericArgs)) =>
          val s = nextPart(name, genericArgs, prev)
          buildFullType(parent, s)
        case Some(Entry(name, None, genericArgs)) =>
          nextPart(name, genericArgs, prev)
        case None =>
          prev
      }
    }

    buildFullType(nodeId, "")
  }
}

class Generator(message: MessageReader) {
  val request = message.getRoot[CodeGeneratorRequest]
  private val nodeMap = mutable.HashMap[Long, Node#Reader]()
  private val scopeMap = mutable.HashMap[Long, Seq[String]]()
  private val nodeTypes = new NodeTypeTree()
  private val implicits = mutable.ArrayBuffer[FormattedText]()

  for (node <- request.nodes) {
    nodeMap(node.id) = node
  }

  private def annotationText(node: Node#Reader, annotationId: Long): Option[String] = {
    node.annotations
        .find(ann => ann.id == annotationId)
        .map(_.value)
        .map{
          case Value.Text(text) => text.toString
        }
  }

  private def nodePackageName(nodeId: Long): Option[String] = {
    val node = nodeMap(nodeId)
    annotationText(node, PackageNameAnnotationId)
  }

  private def nodeModuleName(nodeId: Long): Option[String] = {
    val node = nodeMap(nodeId)
    annotationText(node, ModuleAnnotationId)
  }

  for (requestedFile <- request.requestedFiles) {
    val id = requestedFile.id
    val packageName = nodePackageName(id).get
    val module = nodeModuleName(id).get
    val imports = requestedFile.imports

    for (imp <- imports) {
      // TODO: Implement properly
      val importPath = imp.name.toString
      val rootName = moduleName(importPath.replace("-", "_"))
      populateScope(Seq(rootName), imp.id)
    }

    populateScope(Seq(s"$packageName.$module"), id)
  }

  def structTypePreamble(nodeId: Long, data: Int, pointers: Int) = Seq(Indent(Branch(
    Line(s"val typeId: Long = ${nodeId}L"),
    Line(s"override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize($data, $pointers)"),
    BlankLine,
    Line("override type Reader = ReaderImpl"),
    Line("override type Builder = BuilderImpl"),
    BlankLine,
    Line("override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)"),
    Line("override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)"),
    BlankLine)
  ))

  def generateOutput(nodeId: Long): Seq[String] = {
    val packageName = nodePackageName(nodeId).get
    val moduleName = nodeModuleName(nodeId).get

    val nodesText = generateNode(nodeId, moduleName)

    val schema = Branch(
      Line(s"object $moduleName {"),
      Indent(Branch(implicits :+ nodesText:_*
      )),
      Line("}")
    )
    val lines = Vector("// GENERATED CAP'N PROTO FILE, DO NOT EDIT",
        s"package $packageName",
        "",
        "import org.murtsi.capnproto.runtime.implicits._",
        "") ++
        schema.lines()

    implicits.clear()

    lines
  }

  def genericParamWithConstraints(paramName: String): String = {
    s"$paramName <: org.murtsi.capnproto.runtime.PointerFamily : org.murtsi.capnproto.runtime.FromPointer : org.murtsi.capnproto.runtime.SetPointerBuilder"
  }

  def generateHaser(discriminantOffset: Int, styledName: String, field: Field#Reader, isReader: Boolean): Option[FormattedText] = {
    val result = mutable.ArrayBuffer[FormattedText]()
    val interior = mutable.ArrayBuffer[FormattedText]()

    val discriminantValue = field.discriminantValue
    var branches = false
    if (discriminantValue != Field.NoDiscriminant) {
      interior += Line(s"if (_getShortField($discriminantOffset) != $discriminantValue) false")
      branches = true
    }
    field match {
      case Field.Group(_) =>
      case Field.Slot(regField) =>
        regField.`type` match {
          case Type.Text() | Type.Data() | Type._List(_) | Type.Struct(_) | Type.AnyPointer(_) =>
            val prefix = if (branches) "else " else ""
            interior += Line(s"${prefix}_pointerFieldIsNull(${regField.offset})")
            result ++= Vector(
              Line(s"def $styledName: Boolean = {"),
              Indent(Branch(interior:_*)),
              Line("}")
            )
          case _ =>
        }
    }

    if (result.nonEmpty) Some(Branch(result:_*)) else None
  }

  def generateNode(nodeId: Long, nodeName: String, parentNodeId: Option[Long] = None, groupDiscriminant: Option[Short] = None): FormattedText = {
    val output = mutable.ArrayBuffer[FormattedText]()
    val nestedOutput = mutable.ArrayBuffer[FormattedText]()

    val nodeReader = nodeMap(nodeId)
    for (nestedNode <- nodeReader.nestedNodes) {
      val id = nestedNode.id
      nestedOutput += generateNode(id, scopeMap(id).last)
    }
    import Node._
    nodeReader match {
      case File() => output += Branch(nestedOutput:_*)
      case Node.Const(const) =>
        val styledName = scopeMap(nodeId).last.capitalize
        val (typ: String, contents: String) = (const.`type`, const.value) match {
          case (Type.Void(), Value.Void()) => ("Unit", "()")
          case (Type.Int8(), Value.Int8(b)) => ("Byte", b.toString)
          case (Type.Int16(), Value.Int16(s)) => ("Short", s.toString)
          case (Type.Int32(), Value.Int32(i)) => ("Int", i.toString)
          case (Type.Int64(), Value.Int64(l)) => ("Long", l.toString)
          case (Type.Uint8(), Value.Uint8(b)) => ("Byte", b.toString)
          case (Type.Uint16(), Value.Uint16(s)) => ("Short", s.toString)
          case (Type.Uint32(), Value.Uint32(i)) => ("Int", i.toString)
          case (Type.Uint64(), Value.Uint64(l)) => ("Long", l.toString)
          case (Type.Float32(), Value.Float32(f)) => ("Float", f.toString)
          case (Type.Float64(), Value.Float64(d)) => ("Double", d.toString)
          case (t, v) => throw new UnsupportedOperationException(s"$t constants are not implemented")
        }
        output += Line(s"val $styledName: $typ = $contents")
      case Struct(struct) =>
        val params = parametersTexts(nodeReader)
        var genericParameterNames = Vector.empty[String]
        output += BlankLine

        val isGeneric = nodeReader.isGeneric
        val parameters = nodeReader.parameters
        if (isGeneric && parameters.nonEmpty) {
          genericParameterNames = parameters.map(_.name.toString).toVector
          val genericParamsDecls = genericParameterNames.map(genericParamWithConstraints).mkString(", ")
          val genericParams = genericParameterNames.mkString(", ")
          output ++= Seq(
            Line(s"object $nodeName {"),
            Indent(Branch(
              Line(s"def apply[$genericParamsDecls]: $nodeName[$genericParams] = new $nodeName[$genericParams]")
            )),
            Line("}")
          )
          output += Line(s"sealed class $nodeName[$genericParamsDecls] private() extends org.murtsi.capnproto.runtime.Struct { ")
        } else {
          output += Line(s"object $nodeName extends $nodeName")
          output += Line(s"sealed class $nodeName private() extends org.murtsi.capnproto.runtime.Struct { ")
        }

        val unionFields = mutable.ArrayBuffer[Field#Reader]()
        val builderMembers, readerMembers, readerHasers, builderHasers, initializers = mutable.ArrayBuffer[FormattedText]()
        var extractors: Option[FormattedText] = None

        val dataSize = struct.dataWordCount
        val pointerSize = struct.pointerCount
        val discriminantCount = struct.discriminantCount
        val discriminantOffset = struct.discriminantOffset

        output ++= structTypePreamble(nodeId, dataSize, pointerSize)

        implicits ++= {
          val name = nodeTypes.fullType(nodeId, withGenericParams = false, typeSeparator = "#")
          val implicitNamePrefix = nodeTypes.fullType(nodeId, withGenericParams = false, typeSeparator = "$")
          val fullPath = nodeTypes.fullType(nodeId)
          val fullType = nodeTypes.fullType(nodeId, typeSeparator = "#")

          val allGenericParams = nodeTypes.allGenericParams(nodeId)
          val define = if (allGenericParams.isEmpty) "val" else "def"
          val defParams = if (allGenericParams.isEmpty) ""
                          else s"[${allGenericParams.map(genericParamWithConstraints).mkString(", ")}]"

          Seq(
            Line(s"// START $name implicits"),
            Branch(
              Line(s"implicit $define $implicitNamePrefix$$$$HasTypeId$defParams = new org.murtsi.capnproto.runtime.HasTypeId[$fullType] {"),
              Indent(Line(s"def typeId: Long = ${nodeId}L")),
              Line("}")
            ),
            Branch(
              Line(s"implicit $define $implicitNamePrefix$$$$HasStructSize$defParams = new org.murtsi.capnproto.runtime.HasStructSize[$fullType] {"),
              Indent(Line(s"val structSize = new org.murtsi.capnproto.runtime.StructSize($dataSize, $pointerSize)")),
              Line("}")
            ),
            Line(s"implicit $define $implicitNamePrefix$$$$StructFromSegment$defParams = new org.murtsi.capnproto.runtime.StructFromSegment[$fullType] {"),
            Indent(Branch(
              Line(s"def readerFromSegment(segment: org.murtsi.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): $fullType#Reader = {"),
              Indent(Line(s"$fullPath.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)")),
              Line("}"),
              Line(s"def builderFromSegment(segment: org.murtsi.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): $fullType#Builder = {"),
              Indent(Line(s"$fullPath.Builder(segment, dataOffset, pointers, dataSize, pointerCount)")),
              Line("}")
            )),
            Line("}"),
            Line(s"// END $name implicits")
          )
        }

        (struct.isGroup, groupDiscriminant) match {
          case (true, Some(discriminant)) =>
            val self = nodeTypes.fullType(nodeId, typeSeparator = "#")
            val parent = nodeTypes.fullType(nodeMap(nodeId).scopeId, typeSeparator = "#")
            val fieldName = if (nodeName.startsWith("_") && keywords.contains(nodeName.substring(1))) {
              nodeName.substring(1).head.toLower + nodeName.substring(1).tail
            } else {
              nodeName.toLowerCase.head + nodeName.tail
            }
            output ++= Seq("Reader", "Builder")
                .map(leaf =>
                  Indent(Branch(
                    Line(s"def unapply(value: $parent#$leaf): Option[$self#$leaf] = {"),
                    Indent(Line(s"if (value._whichIndex == $discriminant) Some(value.$fieldName) else None")),
                  Line("}")))
                )
          case _ =>
        }

        val fields = struct.fields
        for (field <- fields) {
          val name = field.name
          val styledName = name.toString
          val escapedName = methodName(styledName)

          val discriminantValue = field.discriminantValue
          val isUnionField = discriminantValue != Field.NoDiscriminant

          val getterAccessLevel = if (isUnionField) s"private[$nodeName] " else ""
          if (isUnionField) {
            unionFields += field
          }

          def isVoid(t: Type#Reader): Boolean = t match {
            case Type.Void() => true
            case _ => false
          }

          (isUnionField, field) match {
            case (true, Field.Slot(slot)) if isVoid(slot.`type`) =>
            case _ =>
              val (ty, get) = getterText(field, isReader = true, returnsOption = !isUnionField)
              val (tyB, getB) = getterText(field, isReader = false, returnsOption = !isUnionField)

              readerMembers += Branch(
                Line(s"${getterAccessLevel}def $escapedName: $ty = {"),
                Indent(get),
                Line("}")
              )
              builderMembers += Branch(
                Line(s"${getterAccessLevel}def $escapedName: $tyB = {"),
                Indent(getB),
                Line("}")
              )
          }

          generateSetter(discriminantOffset, styledName, field).foreach(builderMembers += _)
          generateInitializer(discriminantOffset, escapedName, field).foreach(initializers += _)
          generateHaser(discriminantOffset, escapedName, field, isReader = true).foreach(readerHasers += _)
          generateHaser(discriminantOffset, escapedName, field, isReader = false).foreach(builderHasers += _)

          field match {
            case Field.Group(group) =>
              val groupDiscriminant = if (discriminantCount > 0) Some(discriminantValue) else None
              val id = group.typeId
              val text = generateNode(id, scopeMap(id).last, groupDiscriminant = groupDiscriminant)
              nestedOutput += text
            case _ =>
          }
        }

        if (discriminantCount > 0) {
          val parent = nodeTypes.fullType(nodeId, typeSeparator = "#")
          val readerResult = generateUnionExtractors(parent, discriminantOffset, unionFields, isReader = true, params)
          val whichIndexDef = Line(s"private[$nodeName] def _whichIndex: Short = _getShortField($discriminantOffset)")
          readerMembers += whichIndexDef
          builderMembers += whichIndexDef
          extractors = Some(Indent(Branch(readerResult.extractors:_*)))
        }

        if (readerHasers.nonEmpty) {
          readerMembers += Branch(
            Line("object has {"),
            Indent(Branch(readerHasers:_*)),
            Line("}")
          )
        }

        if (builderHasers.nonEmpty) {
          builderMembers += Branch(
            Line("object has {"),
            Indent(Branch(builderHasers:_*)),
            Line("}")
          )
        }

        if (initializers.nonEmpty) {
          builderMembers += Branch(
            Line("object init {"),
            Indent(Branch(initializers:_*)),
            Line("}")
          )
        }

        output += Indent(Branch(
          Line("class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {"),
          Indent(Branch(readerMembers:_*)),
          Line("}")
        ))
        output += Indent(Branch(
          Line("class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {"),
          Indent(Branch(builderMembers:_*)),
          Line("}")
        ))

        extractors.foreach(output.+=)

        output += Branch(Indent(Branch(nestedOutput:_*)))
        output += Line("}")
      case Enum(enumReader) =>
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

        val genericParamNames = nodeTypes.allGenericParams(nodeId)
        val enumModulePath = nodeTypes.fullType(nodeId, withGenericParams = true)
        val enumTypeName = nodeTypes.fullType(nodeId, withGenericParams = true, typeSeparator = "#")
        val enumTypePath = nodeTypes.fullType(nodeId, withGenericParams = true, typeSeparator = "#")
        val implicitPrefix = nodeTypes.fullType(nodeId, withGenericParams = false, typeSeparator = "$")
        val genericParams = if (genericParamNames.isEmpty) "" else s"[${genericParamNames.map(genericParamWithConstraints).mkString(", ")}]"
        val definition = if (genericParamNames.isEmpty) "val" else "def"
        implicits ++= Seq(
          Line(s"// START $enumTypeName implicits"),
          Branch(
            Line(s"implicit $definition $implicitPrefix$$$$EnumValues$genericParams = new org.murtsi.capnproto.runtime.HasEnumValues[$enumTypePath] {"),
            Indent(Line(s"val enumValues = $enumModulePath.enumValues")),
            Line("}")
          ),
          Branch(
            Line(s"implicit $definition $implicitPrefix$$$$FromShort$genericParams = new org.murtsi.capnproto.runtime.FromShort[$enumTypePath] {"),
            Indent(Line(s"def fromShort(short: Short) = $enumModulePath(short)")),
            Line("}")
          ),
          Line(s"// END $enumTypeName implicits")
        )

        output += Branch(
          Line(s"sealed class $enumClassName(index: Short) extends org.murtsi.capnproto.runtime.Enum(index)"),
          Line(s"object $enumClassName extends org.murtsi.capnproto.runtime.EnumModule[$enumClassName] {"),
          Indent(Branch(
            Branch(
              Line(s"override val enumValues: Seq[$enumClassName] = Vector("),
              Indent(Branch(enumerantValues:_*)),
              Line(")"),
              Line(s"def apply(value: Short): Option[$enumClassName] = enumValues.lift(value)")
            ),
            Branch(members:_*)
          )),
          Line("}")
        )
    }

    Branch(output:_*)
  }

  def generatePipelineGetter(field: Field#Reader): FormattedText = {
    Line("PIPELINED_GETTER")
  }

  def groupModule(group: Field#Group#Reader, isReader: Boolean): String = {
    val module = nodeTypes.fullType(group.typeId)
    val suffix = if (isReader) "Reader" else "Builder"
    s"$module.$suffix"
  }

  def groupType(group: Field#Group#Reader, isReader: Boolean): String = {
    val typ = nodeTypes.fullType(group.typeId, typeSeparator = "#")
    val suffix = if (isReader) "Reader" else "Builder"
    s"$typ#$suffix"
  }

  def getterText(field: Field#Reader, isReader: Boolean, returnsOption: Boolean = true): (String, FormattedText) = {
    import Field._

    def getPointerField(module: String, offset: Int) = s"_getPointerField[$module]($offset)"

    field match {
      case Group(group) =>
        val mod = groupModule(group, isReader)
        val t = groupType(group, isReader)
        if (isReader)
          (t, Line(s"$mod(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit)"))
        else
          (t, Line(s"$mod(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)"))
      case Slot(regField) =>
        val offset = regField.offset
        val module = if (isReader) "Reader" else "Builder"
        val moduleSuffix = if (isReader) "#Reader" else "#Builder"
        val member = module
        val leaf = if (isReader) Leaf.Reader else Leaf.Builder

        val rawType = regField.`type`
        val typ = typeString(rawType, Leaf.Module)
        val default = regField.defaultValue

        val resultType = rawType match {
          case Type.Enum(_) => typ
          case Type._List(_) => typeString(rawType, leaf)
          case Type.Interface(_) => ???
          case _ if rawType.isPrimitive => typ
          case _ => s"$typ$moduleSuffix"
        }

        def primitiveCase[T](typ: String, offset: Long, default: T, zero: T): FormattedText = {
          if (default == zero) {
            Line(s"this._get${typ}Field($offset)")
          } else {
            Line(s"this._get${typ}Field($offset, $default)")
          }
        }
        val getterCode = (rawType, default) match {
          case (Type.Void(), Value.Void()) => Line("org.murtsi.capnproto.runtime.Void")
          case (Type.Bool(), Value.Bool(bool)) =>
            if (bool) Line(s"_getBooleanField($offset, true)")
            else Line(s"_getBooleanField($offset)")
          case (Type.Int8(), Value.Int8(b)) => primitiveCase(typ, offset, b, 0)
          case (Type.Int16(), Value.Int16(s)) => primitiveCase(typ, offset, s, 0)
          case (Type.Int32(), Value.Int32(i)) => primitiveCase(typ, offset, i, 0)
          case (Type.Int64(), Value.Int64(l)) => primitiveCase(typ, offset, l, 0)
          case (Type.Uint8(), Value.Uint8(b)) => primitiveCase(typ, offset, b, 0)
          case (Type.Uint16(), Value.Uint16(s)) => primitiveCase(typ, offset, s, 0)
          case (Type.Uint32(), Value.Uint32(i)) => primitiveCase(typ, offset, i, 0)
          case (Type.Uint64(), Value.Uint64(l)) => primitiveCase(typ, offset, l, 0)
          case (Type.Float32(), Value.Float32(f)) => primitiveCase(typ, offset, f, 0)
          case (Type.Float64(), Value.Float64(d)) => primitiveCase(typ, offset, d, 0)
          case (Type.Text(), Value.Text(_)) => Line(getPointerField("org.murtsi.capnproto.runtime.Text", offset))
          case (Type.Data(), Value.Data(_)) => Line(getPointerField("org.murtsi.capnproto.runtime.Data", offset))
          case (Type._List(_), Value._List(_)) =>
            Line(getPointerField(typeString(rawType, Leaf.Module), offset))
          case (Type.Enum(_), Value.Enum(_)) =>
            val module = moduleString(rawType, Leaf.Module)
            Line(s"$module.enumValues(_getShortField($offset))")
          case (Type.Struct(_), Value.Struct(_)) =>
            val ts = typeString(rawType, Leaf.Module)
            Line(getPointerField(ts, offset))
          case (Type.AnyPointer(_), _) =>
            if (rawType.isParameter) {
              Line(getPointerField(typ, offset))
            } else {
              Line(getPointerField("org.murtsi.capnproto.runtime.AnyPointer", offset))
            }
          case (Type.Interface(_), Value.Interface()) => ???
          case _ => Line("") // throw new Error(s"Default value was of wrong type (expected ${typeString(rawType, Leaf.Module)}, got ${valueToString(default)})")
        }

        (resultType, getterCode)
    }
  }

  def valueToString(value: Value.Reader): String = {
    value match {
      case Value.Int8(b) => s"Int8($b)"
      case Value.Int16(s) => s"Int16($s)"
      case Value.Int32(i) => s"Int32($i)"
      case Value.Int64(l) => s"Int64($l)"
      case Value.Uint8(b) => s"Uint8($b)"
      case Value.Uint16(s) => s"Uint16($s)"
      case Value.Uint32(i) => s"UInt32($i)"
      case Value.Uint64(l) => s"UInt64($l)"
      case Value.Float32(f) => s"Float32($f)"
      case Value.Float64(d) => s"Float64($d)"
      case Value.Text(txt) => s"""Text("$txt")"""
      case Value.Data(data) => s"""Data(${data.toArray.mkString(", ")})"""
      case Value._List(list) => s"""List(is null = ${list.isNull})"""
      case Value.Enum(enum) => s"""Enum($enum)"""
      case Value.Struct(struct) => s"""Struct(is null = ${struct.isNull})"""
      case Value.AnyPointer(ptr) => s"""AnyPointer(is null = ${ptr.isNull})"""
      case Value.Interface() => s"""Interface"""
      case v => s"UNKNOWN_TYPE($v)"
    }
  }

  def generateInitializer(discriminantOffset: Int, styledName: String, field: Field#Reader): Option[FormattedText] = {
    val initterInterior, result = mutable.ArrayBuffer[FormattedText]()
    val initterParams = mutable.ArrayBuffer[String]()

    val discriminantValue = field.discriminantValue
    if (discriminantValue != Field.NoDiscriminant) {
      val doStr = java.lang.Long.toUnsignedString(discriminantOffset.toLong)
      val dvStr = java.lang.Long.toUnsignedString(discriminantValue.toLong)
      initterInterior += Line(s"_setShortField($doStr, $dvStr)")
    }

    val maybeBuilderType: Option[String] = field match {
      case Field.Group(group) =>
        val scope = scopeMap(group.typeId)
        val module = scope.mkString(".")
        initterInterior ++= Seq(
          zeroFieldsOfGroup(group.typeId),
          Line(s"$module.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)"))
        Some(s"$module#Builder")
      case Field.Slot(regField) =>
        val offset = regField.offset
        val typ = regField.`type`
        typ match {
          case _ if typ.isPrimitive => None
          case Type.Enum(_) => None
          case Type.Text() =>
            initterInterior += Line(s"_initPointerField[org.murtsi.capnproto.runtime.Text]($offset, size)")
            initterParams += "size: Int"
            Some("org.murtsi.capnproto.runtime.Text#Builder")
          case Type.AnyPointer(Type.AnyPointer.Parameter(parameter)) =>
            val struct = nodeMap(parameter.scopeId)
            val paramName = struct.parameters(parameter.parameterIndex).name.toString
            initterInterior += Line(s"_initPointerField[$paramName](1, size)")
            initterParams += "size: Int = 0"
            Some(s"$paramName#Builder")
          case Type.AnyPointer(Type.AnyPointer.Unconstrained()) =>
            initterInterior += Line(s"_initPointerField[org.murtsi.capnproto.runtime.AnyPointer]($offset, size)")
            initterParams += "size: Int = 0"
            Some("org.murtsi.capnproto.runtime.AnyPointer#Builder")
          case Type.Data() =>
            initterInterior += Line(s"_initPointerField[org.murtsi.capnproto.runtime.Data]($offset, size)")
            initterParams += "size: Int"
            Some("org.murtsi.capnproto.runtime.Data#Builder")
          case Type._List(_) =>
            val elementFactory = typeString(typ, Leaf.Module)
            initterInterior += Line(s"_initPointerField[$elementFactory]($offset, size)")
            initterParams += "size: Int"
            Some(s"$elementFactory#Builder")
          case Type.Struct(_) =>
            initterInterior += Line(s"_initPointerField[${typeString(typ, Leaf.Module)}]($offset, 0)")
            if (typ.isBranded) {
              Some(typeString(typ, Leaf.Builder))
            } else {
              val t = regField.`type`
              Some(typeString(t, Leaf.Builder))
            }
          case Type.Interface(_) => ???
          case _ => throw new Error("Unrecognized type")
        }
    }

    maybeBuilderType.map(builderType => {
      val args = initterParams.mkString(", ")
      result ++= Seq(
        Line(s"def $styledName($args): $builderType = {"),
        Indent(Branch(initterInterior:_*)),
        Line(s"}")
      )
      Branch(result:_*)
    })
  }

  def generateSetter(discriminantOffset: Int, styledName: String, field: Field#Reader): Option[FormattedText] = {
    val setterInterior, result = mutable.ArrayBuffer[FormattedText]()
    var setterParam = "value"
    var textSetterInterior: Option[FormattedText] = None

    val discriminantValue = field.discriminantValue
    if (discriminantValue != Field.NoDiscriminant) {
      val doStr = java.lang.Long.toUnsignedString(discriminantOffset.toLong)
      val dvStr = java.lang.Long.toUnsignedString(discriminantValue.toLong)
      setterInterior += Line(s"_setShortField($doStr, $dvStr)")
    }

    val maybeReaderType: Option[String] = field match {
      case Field.Group(group) =>
        val scope = scopeMap(group.typeId)
        val module = scope.mkString(".")
        None
      case Field.Slot(regField) =>
        val offset = regField.offset
        val typ = regField.`type`
        typ match {
          case Type.Void() =>
            setterParam = "_value"
            Some("Unit")
          case Type.Bool() =>
            primitiveDefault(regField.defaultValue) match {
              case None => setterInterior += Line(s"_setBooleanField($offset, value)")
              case Some(s) => setterInterior += Line(s"_setBooleanField($offset, value, $s)")
            }
            Some("Boolean")
          case _ if typ.isPrimitive =>
            val tstr = typeString(typ, Leaf.Reader)
            primitiveDefault(regField.defaultValue) match {
              case None =>
                setterInterior += Line(s"_set${tstr}Field($offset, value)")
              case Some(s) =>
                setterInterior += Line(s"_set${tstr}Field($offset, value, $s)")
            }
            Some(tstr)
          case Type.Text() =>
            setterInterior += Line(s"""_setPointerField[org.murtsi.capnproto.runtime.Text]($offset, value)""")
            textSetterInterior = Some(Line(s"_setPointerField[org.murtsi.capnproto.runtime.Text]($offset, org.murtsi.capnproto.runtime.Text.Reader(value))"))
            Some("org.murtsi.capnproto.runtime.Text#Reader")
          case Type.AnyPointer(Type.AnyPointer.Parameter(parameter)) =>
            val struct = nodeMap(parameter.scopeId)
            val paramName = struct.parameters(parameter.parameterIndex).name.toString
            setterInterior += Line(s"_setPointerField[$paramName]($offset, value)")
            Some(s"$paramName#Reader")
          case Type.AnyPointer(Type.AnyPointer.Unconstrained()) =>
            Some("org.murtsi.capnproto.runtime.AnyPointer#Reader")
          case Type.Data() =>
            setterInterior += Line(s"""_setPointerField[org.murtsi.capnproto.runtime.Data]($offset, value)""")
            Some("org.murtsi.capnproto.runtime.Data#Reader")
          case Type._List(_) =>
            val elementFactory = typeString(typ, Leaf.Module)
            setterInterior += Line(s"""_setPointerField[$elementFactory]($offset, value)""")
            Some(s"$elementFactory#Reader")
          case Type.Enum(_) =>
            val ty = typeString(typ, Leaf.Builder)
            setterInterior += Line(s"_setShortField(value.index, $offset)")
            Some(ty)
          case Type.Struct(_) =>
            if (typ.isBranded) {
              setterInterior += Line(s"_setPointerField[${typeString(typ, Leaf.Module)}]($offset, value)")
              Some(typeString(typ, Leaf.Reader))
            } else {
              setterInterior += Line(s"_setPointerField[${typeString(typ, Leaf.Module)}]($offset, value)")
              val t = regField.`type`
              Some(typeString(t, Leaf.Reader))
            }
          case Type.Interface(_) => ???
          case _ => throw new Error("Unrecognized type")
        }
    }

    maybeReaderType.map(readerType => {
      result ++= Seq(
        Line(s"def ${styledName}_=($setterParam: $readerType): Unit = {"),
        Indent(Branch(setterInterior:_*)),
        Line(s"}")
      )

      textSetterInterior.foreach(interior => {
        result ++= Seq(
          Line(s"def ${styledName}_=($setterParam: String): Unit = {"),
          Indent(Branch(interior)),
          Line(s"}")
        )
      })

      Branch(result:_*)
    })
  }

  case class UnionResult(extractors: Seq[FormattedText])

  def generateUnionExtractors(parentName: String, discriminantOffset: Int, fields: Seq[Field#Reader], isReader: Boolean, params: TypeParameterTexts): UnionResult = {
    def hasExtractorObject(field: Field#Reader): Boolean = {
      field match {
        case Field.Slot(slot) =>
          if (slot.has.`type`) {
            slot.`type` match {
              case Type.Struct(structType) =>
                nodeMap(structType.typeId) match {
                  case Node.Struct(struct) => !struct.isGroup
                  case _ => false
                }
              case Type.Enum(_) => false
              case _ => true
            }
          } else {
            true
          }
        case _ => true
      }
    }

    val extractors = mutable.ArrayBuffer[FormattedText]()

    for (field <- fields.filter(hasExtractorObject)) {
      val dvalue = java.lang.Short.toUnsignedLong(field.discriminantValue)
      val rawFieldName = field.name.toString
      val fieldName = methodName(rawFieldName)
      val enumerantName = moduleName(rawFieldName.capitalize)

      val (unapplyType, _) = getterText(field, isReader = true)
      val (unapplyTypeB, _) = getterText(field, isReader = false)

      field match {
        case Field.Slot(slot) => slot.`type` match {
          case Type.Void() =>
            extractors += Branch(
              Line(s"object $enumerantName {"),
              Indent(Branch(
                Line(s"def unapply(value: $parentName#Reader): Boolean = value._whichIndex == $dvalue"),
                Line(s"def unapply(value: $parentName#Builder): Boolean = value._whichIndex == $dvalue")
              )),
              Line("}")
            )
          case _ =>
            val fieldGetter = s"Some(value.$fieldName)"
            extractors += Branch(
              Line(s"object $enumerantName {"),
              Indent(Branch(
                Branch(
                  Line(s"def unapply(value: $parentName#Reader): Option[$unapplyType] = {"),
                  Indent(Branch(
                    Line(s"if (value._whichIndex == $dvalue) $fieldGetter else None")
                  )),
                  Line("}")
                ),
                Branch(
                  Line(s"def unapply(value: $parentName#Builder): Option[$unapplyTypeB] = {"),
                  Indent(Branch(
                    Line(s"if (value._whichIndex == $dvalue) $fieldGetter else None")
                  )),
                  Line("}")
                )
              )),
              Line("}")
            )
          }
        case _ =>
      }
    }

    UnionResult(extractors)
  }

  def primitiveDefault(value: Value#Reader): Option[String] = {
    import Value._
    value match {
      case Bool(b) => if (b) Some("true") else None
      case Int8(b) => if (b == 0) None else Some(b.toString)
      case Int16(s) => if (s == 0) None else Some(s.toString)
      case Int32(i) => if (i == 0) None else Some(i.toString)
      case Int64(l) => if (l == 0) None else Some(l.toString)
      case Uint8(b) => if (b == 0) None else Some(b.toString)
      case Uint16(s) => if (s == 0) None else Some(s.toString)
      case Uint32(i) => if (i == 0) None else Some(i.toString)
      case Uint64(l) => if (l == 0) None else Some(l.toString)
      case Float32(f) => if (f == 0.0) None else Some(f.toString)
      case Float64(d) => if (d == 0.0) None else Some(d.toString)
      case _ => throw new Error(s"Expected a primitive value")
    }
  }

  def zeroFieldsOfGroup(nodeId: Long): FormattedText = {
    val node = nodeMap(nodeId)
    node match {
      case Node.Struct(st) =>
        val result = mutable.ArrayBuffer[FormattedText]()
        if (st.discriminantCount != 0) {
          result += Line(s"_setShortField(${st.discriminantOffset}, 0)")
        }
        val fields = st.fields
        for (field <- fields) {
          field match {
            case Field.Group(group) => result += zeroFieldsOfGroup(group.typeId)
            case Field.Slot(slot) =>
              slot.`type` match {
                case Type.Void() =>
                case Type.Bool() =>
                  val line = Line(s"_setBooleanField(${slot.offset}, false)")
                  if (!result.contains(line)) {
                    result += line
                  }
                case Type.Int8() | Type.Int16() | Type.Int32() | Type.Int64()
                    | Type.Uint8() | Type.Uint16() | Type.Uint32() | Type.Uint64()
                    | Type.Float32() | Type.Float64()  =>
                  val line = Line(s"_set${typeString(slot.`type`, Leaf.Module)}Field(${slot.offset}, 0)")
                  if (!result.contains(line)) result += line
                case Type.Enum(_) =>
                  val line = Line(s"_setShortField(${slot.offset}, 0)")
                  if (!result.contains(line)) result += line
                case Type.Struct(_) | Type._List(_) | Type.Text() | Type.Data()
                     | Type.AnyPointer(_) | Type.Interface(_) =>
                  val line = Line(s"_clearPointerField(${slot.offset})")
                  if (!result.contains(line)) result += line
              }
          }
        }
        Branch(result:_*)
      case _ => throw new Error("Expected a struct")
    }
  }

  def populateScope(scopeNames: Seq[String], nodeId: Long): Unit = {

    scopeMap(nodeId) = scopeNames

    val nodeReader = nodeMap.get(nodeId) match {
      case Some(n) => n
      case _ => return
    }

    for (nestedNode <- nodeReader.nestedNodes) {
      val nScopeNames = mutable.ArrayBuffer(scopeNames:_*)
      val nestedNodeId = nestedNode.id
      nodeMap.get(nestedNodeId) match {
        case None =>
        case Some(nNodeReader) =>
          nNodeReader match {
            case Node.Enum(_) =>
              nScopeNames += moduleName(nestedNode.name.toString)
              populateScope(nScopeNames, nestedNodeId)
            case _ =>
              populateScope(scopeNames :+ moduleName(nestedNode.name), nestedNodeId)
          }
      }
    }

    nodeReader match {
      case Node.Struct(struct) =>
        val genericArgs = nodeReader.parameters.map(_.name.toString).toVector
        nodeTypes.add(nodeId, scopeNames.last, Some(nodeReader.scopeId), genericArgs)
        val fields = struct.fields
        for (field <- fields) {

          field match {
            case Field.Group(group) =>
              val name = moduleName(field.name.toString.capitalize)
              populateScope(scopeNames :+ name, group.typeId)
            case _ =>
          }
        }
      case Node.Enum(enum) =>
        nodeTypes.add(nodeId, scopeNames.last, Some(nodeReader.scopeId), Vector.empty)
      case _ =>
    }
  }

  def parametersTexts(node: Node#Reader, parentNodeId: Option[Long] = None): TypeParameterTexts = {
    if (node.isGeneric) {
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
          val params = currentNode.parameters.map(_.name.toString)
          accumulator += params.toSeq

          currentNodeId = currentNode.scopeId
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
    if (keywords.contains(name)) "_"+name else name
  }

  def methodName(name: String): String = if (keywords.contains(name)) s"`$name`" else name

  def doBranding(nodeId: Long, brand: Brand#Reader, leaf: Leaf, module: String, parentScopeId: Option[Long]): String = {
    val brandScopes = HashMap[Long, Brand#Scope#Reader](brand.scopes.map(s => (s.scopeId, s)).toSeq:_*)

    @tailrec
    def getPart(nodeId: Long, parentScopeId: Option[Long], acc: Seq[String]): Seq[String] = {
      nodeMap.get(nodeId) match {
        case Some(node) =>
          val mpart = scopeMap.get(node.id) match {
            case Some(scope) =>
              val modulePart = scope.last
              val params = node.parameters.toVector
              val arguments = brandScopes.get(nodeId) match {
                case None => params.map(_ => s"org.murtsi.capnproto.runtime.AnyPointer.$leaf")
                case Some(Brand.Scope.Inherit()) => params.map(_.name.toString)
                case Some(Brand.Scope.Bind(bindingsList)) =>
                  assert(bindingsList.size == params.size)
                  bindingsList.map {
                    case v if booleanMatch(v){case Brand.Binding.Unbound() =>} =>
                      s"org.murtsi.capnproto.runtime.AnyPointer.$leaf"
                    case Brand.Binding.Type(typ) =>
                      typeString(typ, Leaf.Module)
                  }
              }
              Some(if (arguments.isEmpty) modulePart else s"$modulePart[${arguments.mkString(", ")}]")
            case None => None
          }
          (node.scopeId, parentScopeId) match {
            case (v, Some(id)) if v == id => mpart ++: acc
            case (0, Some(id)) => getPart(id, Some(id), mpart ++: acc)
            case (0, None) => mpart ++: acc
            case (id, parent) => getPart(id, parent, mpart ++: acc)
          }
        case None => acc
        }
      }

    val moduleSuffix = leaf match {
      case Leaf.Module => ""
      case l => "#" + l
    }
    val parts = getPart(nodeId, parentScopeId, Seq())
    parts.head + "." + parts.tail.mkString("#") + moduleSuffix
  }

  def typeString(typ: Type#Reader, module: Leaf): String = {
    modulePath(typ, module, "#")
  }

  def moduleString(typ: Type#Reader, module: Leaf): String = {
    modulePath(typ, module, ".")
  }

  def modulePath(typ: Type#Reader, module: Leaf, separator: String): String = {
    val moduleSuffix = module match {
      case Leaf.Module => ""
      case leaf => s"#$leaf"
    }

    import Type._
    val path = typ match {
      case Void() => "org.murtsi.capnproto.runtime.Void"
      case Bool() => "Boolean"
      case Int8() => "Byte"
      case Int16() => "Short"
      case Int32() => "Int"
      case Int64() => "Long"
      case Uint8() => "Byte"
      case Uint16() => "Short"
      case Uint32() => "Int"
      case Uint64() => "Long"
      case Float32() => "Float"
      case Float64() => "Double"
      case Type.Text() => s"org.murtsi.capnproto.runtime.Text$moduleSuffix"
      case Data() => s"org.murtsi.capnproto.runtime.Data$moduleSuffix"
      case Struct(st) =>
        val moduleName = scopeMap(st.typeId).mkString(".")
        doBranding(st.typeId, st.brand, module, moduleName, None)
      case Interface(interface) =>
        doBranding(interface.typeId, interface.brand, module, scopeMap(interface.typeId).mkString("."), None)
      case _List(ot1) =>
        val elType = ot1.elementType
        listModulePath(elType, module, separator)
      case Enum(enum) =>
        nodeTypes.fullType(enum.typeId, typeSeparator = separator)
      case AnyPointer(anyPointer) =>
        val isParameter = typ.isParameter
        anyPointer match {
          case AnyPointer.Parameter(definition) =>
            val theStruct = nodeMap(definition.scopeId)
            val parameters = theStruct.parameters
            val parameter = parameters(definition.parameterIndex)
            val parameterName = parameter.name
            module match {
              case Leaf.Module => parameterName.toString
              case Leaf.Reader => s"$parameterName#Reader"
              case Leaf.Builder => s"$parameterName#Builder"
              case _ => ???
            }
          case _ =>
            module match {
              case Leaf.Reader => "org.murtsi.capnproto.runtime.AnyPointer#Reader"
              case Leaf.Builder => "org.murtsi.capnproto.runtime.AnyPointer#Builder"
              case Leaf.Module => "org.murtsi.capnproto.runtime.AnyPointer"
              case _ => ???
            }
        }
    }

    path
  }

  def listModulePath(elementType: Type#Reader, module: Leaf, separator: String): String = {
    val moduleSuffix = module match {
      case Leaf.Module => ""
      case m => s"$separator$m"
    }
    import Type._
    elementType match {
      case Struct(_) => s"org.murtsi.capnproto.runtime.StructList[${typeString(elementType, Leaf.Module)}]$moduleSuffix"
      case Enum(_) => s"org.murtsi.capnproto.runtime.EnumList[${typeString(elementType, Leaf.Module)}]$moduleSuffix"
      case Type.Text() => s"org.murtsi.capnproto.runtime.TextList$moduleSuffix"
      case AnyPointer(_) => s"org.murtsi.capnproto.runtime.AnyPointer${separator}List$moduleSuffix"
      case Data() => s"org.murtsi.capnproto.runtime.DataList$moduleSuffix"
      case _List(_) => s"org.murtsi.capnproto.runtime.ListList[${typeString(elementType, Leaf.Module)}]$moduleSuffix"
      case _ if elementType.isPrimitive => s"org.murtsi.capnproto.runtime.PrimitiveList$separator${typeString(elementType, Leaf.Module)}$moduleSuffix"
    }
  }
}
