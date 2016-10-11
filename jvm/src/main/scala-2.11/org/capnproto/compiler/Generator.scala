package org.capnproto.compiler

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
  }
}

object Leaf {
  object Reader extends Leaf
  object Builder extends Leaf
  object Owned extends Leaf
  object Client extends Leaf
  object Pipeline extends Leaf
}

class Generator(message: MessageReader) {
  private val request = message.getRoot(CodeGeneratorRequest)
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
      val rootName = s"PLACEHOLDER" // TODO: how does this work

    }
  }

  val structTypePreamble = Seq(
    Line("override type Reader = ReaderImpl"),
    Line("override type Builder = BuilderImpl"),
    BlankLine,
    Line("override val Builder: (SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)"),
    Line("override val Reader: (SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)"))

  def generateNode(nodeId: Long, nodeName: String, parentNodeId: Long = null): FormattedText = {
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
      case FILE => output += Branch(nestedOutput)
      case STRUCT =>
        val struct = nodeReader.struct
        val params = nodeReader.parametersTexts()
        output += BlankLine

        val isGeneric = nodeReader.isgeneric
        if (isGeneric) {
          output += Line(s"object $nodeName extends org.capnproto.runtime.Struct { ")
        } else {
          output += Line(s"object $nodeName extends org.capnproto.runtime.Struct { ")
        }

        output ++= structTypePreamble

        val unionFields = mutable.ArrayBuffer[Field.Reader]()
        val pipelineImplInterior = mutable.ArrayBuffer[FormattedText]()
        val whichEnums = mutable.ArrayBuffer[FormattedText]()
        val readerMembers = mutable.ArrayBuffer[FormattedText]()

        val fields = struct.fields
        for (field <- fields) {
          val name = field.name
          val styledName = name.toString

          val discriminantValue = field.discriminantvalue
          val isUnionField = discriminantValue != Field.NO_DISCRIMINANT

          if (isUnionField) {
            unionFields += field
          } else {
            pipelineImplInterior += generatePipelineGetter(field)
            val (ty, get) = getterText(field, true)
            readerMembers += Branch(
              Line(s"def $styledName: $ty = {"),
              Indent(get),
              Line("}")
            )

          }
        }

    }

    Branch(output)
  }

  def getterText(field: Field.Reader, isReader: Boolean): (String, FormattedText) = {
    import Field.Which._

    field.which match {
      case GROUP =>
        val group = field.group
        val module = scopeMap(group.capnpTypeid).mkString(".")
        if (isReader) {
          (s"$module.Reader", Line(""))
        } else {
          (s"$module.Builder", Line(""))
        }
      case SLOT =>
        val regField = field.slot
        val offset = regField.offset
        val moduleString = if (isReader) "Reader" else "Builder"
        val module = if (isReader) "" else ""
        val member = moduleString

        val rawType = regField.capnpType
        val typ = typeString(rawType, module)
        val default = regField.defaultvalue.which
        val defaultVal = regField.defaultvalue

        val resultType = rawType.which match {
          case Type.Which.ENUM => s""
          case Type.Which.ANY_POINTER if rawType.isParameter => typ
          case Type.Which.INTERFACE => ???
          case _ if rawType.isPrimitive => typ
          case _ => typ
        }

        import Type.{Which => WTyp}
        import Value.{Which => WVal}
        val getterCode = (rawType.which, default) match {
          case (WTyp.VOID, WVal.VOID) => Line("org.capnproto.runtime.Void")
          case (WTyp.BOOL, WVal.BOOL) =>
            if (defaultVal.bool) Line(s"_getBooleanField($offset, true)")
            else Line(s"_getBooleanField($offset)")
        }
    }

  }

  def formattedText(): FormattedText = {

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
              nScopeNames += nestedNode.name.toString
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
              val name = moduleName(field.name)
              populateScope(scopeNames :+ name, field.group.capnpTypeid)
            case _ =>
          }
        }
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
    if (keywords.contains(nameStr)) nameStr+"_" else nameStr
  }

  def doBranding(nodeId: Long, brand: Brand.Reader, leaf: Leaf, module: String, _parentScopeId: Option[Long]): String = {
    var parentScopeId = _parentScopeId

    val scopes = brand.scopes
    val brandScopes = mutable.HashMap[Long, Brand.Scope.Reader](scopes.map(s => (s.scopeid, s)).toSeq:_*)
    var currentNodeId = nodeId
    val accumulator = mutable.ArrayBuffer[Seq[String]]()

    while (true) {
      nodeMap.get(currentNodeId) match {
        case None =>
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

    val arguments = if (accumulator.isEmpty) {
      ""
    } else {
      val argStr = accumulator.reverse.mkString(", ")
      s"[$argStr]"
    }

    s"$module.${leaf.toString}$arguments"
  }

  def typeString(typ: CapnpSchema.Type.Reader, module: Leaf): String = {
    import Type.Which._
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
      case TEXT => s"org.capnproto.runtime.Text.$module"
      case DATA => s"org.capnproto.runtime.Data.$module"
      case STRUCT =>
        val st = typ.struct
        doBranding(st.capnpTypeid, st.brand, module, scopeMap(st.capnpTypeid).mkString("."), None)
      case INTERFACE =>
        val interface = typ.interface
        doBranding(interface.capnpTypeid, interface.brand, module, scopeMap(interface.capnpTypeid).mkString("."), None)
      case LIST =>
        val ot1 = typ.list
        val elType = ot1.elementtype
        elType.which match {
          case STRUCT =>
            s"$module.List"
          case ENUM =>
            ???
          case LIST =>
            ???
          case TEXT => s"org.capnproto.runtime.Text.$module"
          case DATA => s"org.capnproto.runtime.Data.$module"
          case INTERFACE => ???
          case ANY_POINTER => ???
          case _ =>
            s"org.capnproto.runtime.PrimitiveList.$module"
        }
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
            }
        }
    }
  }
}
