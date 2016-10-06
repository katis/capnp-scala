package org.capnproto

import java.nio.channels.Channels
import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}

import org.capnproto.schema.CapnpSchema

import scala.collection.JavaConversions._
import scala.collection.mutable.ArrayBuffer

package object compiler {
  def main(args: Array[String]): Unit = {
    val in = Channels.newChannel(System.in)

    val request = Serialize.read(in).getRoot(CapnpSchema.CodeGeneratorRequest.factory)

    def structName(node: CapnpSchema.Node.Reader) = node.getDisplayName.toString().substring(node.getDisplayNamePrefixLength)

    def findAnnotation(annotationId: Long)(node: CapnpSchema.Node.Reader): Option[CapnpSchema.Annotation.Reader] =
      node.getAnnotations.find(a => a.getId == annotationId)

    val scalaPackageAnnotationId = 0xee44ce11f43e05d7L
    val packageName = request.getNodes
      .find(_.getScopeId == 0)
      .flatMap(findAnnotation(scalaPackageAnnotationId))
      .map(_.getValue.getText.toString())

    packageName match {
      case Some(pkgName) =>
        val structs = request.getNodes
          .filter(_.isStruct)
          .map(n => struct.build(structName(n), n.getStruct))
          .toSeq

        val p = schemaPackage(pkgName, structs)

        val s = treehugger.forest.treeToString(p)
        println(s)
      case _ => System.err.println("Failed")
    }
  }
}

  /*
  def struct(name: String, reader: CapnpSchema.Node.Struct.Reader): Unit = {
    def structFactory(): Unit = {
      appendLine("object factory {")
      appendLine("override def constructReader(segment: org.capnproto.SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): Reader {")
      block {
        appendLine("new Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)")
      }
      appendLine("}")
    }

    appendLine(s"object $name {")
    block {
      appendLine(s"val STRUCT_SIZE = new org.capnproto.StructSize(${reader.data}.toShort, ${reader.pointers}.toShort)")

      reader.getFields.map(f => s"def ${f.getName}: ${fieldType(f.getSlot)} = _getField(${f.getSlot.getOffset},${f.getSlot.data})")
        .foreach(appendLine)
    }
    appendLine("}")
  }


  def fieldType(reader: CapnpSchema.Field.Slot.Reader): String = {
    reader.getType match {
      case t if t.isBool => "scala.Boolean"
      case t if t.isFloat32 => "scala.Float"
      case t if t.isFloat64 => "scala.Double"
      case t if t.isInt8 => "scala.Byte"
      case t if t.isUint8 => "scala.Byte"
      case t if t.isInt16 => "scala.Short"
      case t if t.isUint16 => "scala.Short"
      case t if t.isInt32 => "scala.Int"
      case t if t.isUint32 => "scala.Int"
      case t if t.isInt64 => "scala.Long"
      case t if t.isUint64 => "scala.Long"
      case t if t.isText => "org.capnproto.Text.Reader"
    }
  }
}

trait SchemaOutput {
  def append(s: String)

  def appendLine(s: String)

  def newLine()

  def block(v: Unit)

  var indent = 0
}

class StringSchemaOutput extends SchemaOutput {
  val sep = System.getProperty("line.separator")
  private val sb = new StringBuilder()

  override def append(s: String): Unit = {
    sb.append(s)
  }

  override def appendLine(s: String): Unit = {
    append(" " * indent)
    append(s)
    newLine()
  }

  override def newLine(): Unit = {
    append(sep)
  }

  override def block(v: => Unit): Unit = {
    indent += 1
    v
    indent -= 1
  }

  override def toString: String = sb.toString()
}
  */
