package org.capnproto.compiler

import java.nio.channels.Channels

import org.capnproto.runtime.Serialize
import org.capnproto.compiler.CapnpSchema.CodeGeneratorRequest

sealed trait FormattedText {
  def lines(indent: Int = 0): Seq[String]

  def stringify() =
    lines()
      .foldLeft(new StringBuilder)((a, b) => a.append(b))
      .toString()
}

case class Indent(text: FormattedText) extends FormattedText {
  override def lines(indent: Int): Seq[String] = text.lines(indent+1)
}
case class Branch(texts: FormattedText*) extends FormattedText {
  override def lines(indent: Int): Seq[String] = {
    for (text <- texts;
         line <- text.lines(indent))
      yield line
  }
}
case class Line(line: String) extends FormattedText {
  override def lines(indent: Int): Seq[String] =
    Seq(" " * (indent * 4) + line)
}
object BlankLine extends FormattedText {
  override def lines(indent: Int): Seq[String] = Seq("")
}

object Compiler {
  def main(args: Array[String]): Unit = {
    val chan = Channels.newChannel(System.in)
    val messageReader = Serialize.read(chan)

    val request = messageReader.getRoot(CodeGeneratorRequest)

    for (node <- request.nodes) {
      node match {
        case n if n.isStruct => procStruct(n.displayname.toString, n.struct)
        case n => println(s"Node(${n.which}): '${n.displayname}'")
      }
    }
  }

  def procStruct(displayName: String, struct: CapnpSchema.Node.Struct.Reader): Unit = {
    println(s"Node(STRUCT): $displayName")
    for (field <- struct.fields) {
      val (name, t) = field match {
        case f if field.isSlot => (field.name.toString, slotType(field.slot, "Reader"))
        case f if field.isGroup => (field.name.toString, field.group.capnpTypeid.toString)
      }

      println(s"  $name: $t")
    }
  }

  def slotType(field: CapnpSchema.Field.Slot.Reader, suffix: String): String = {
    import CapnpSchema.Type.Which._

    field.capnpType.which match {
      case VOID => "org.capnproto.runtime.Void."+suffix
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
      case TEXT => "org.capnproto.runtime.Text."+suffix
      case DATA => "org.capnproto.runtime.Data."+suffix
      case LIST => "org.capnproto.runtime.List."+suffix
      case ENUM => "org.capnproto.runtime.Enum."+suffix
      case STRUCT => "org.capnproto.runtime.Struct."+suffix
      case INTERFACE => "org.capnproto.runtime.Struct."+suffix
      case ANY_POINTER => "org.capnproto.runtime.AnyPointer."+suffix
    }
  }
}
