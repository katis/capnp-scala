package org.capnproto.compiler

import scala.collection.JavaConversions._
import org.capnproto.schema.CapnpSchema._
import treehugger.forest._
import definitions._
import org.capnproto.StructReader
import treehuggerDSL._

import languageFeature.implicitConversions

/*

class SchemaParser() {
  object schemaLoader {
    def scopeNode(id: Long): Option[Node.Reader] = {

    }
  }


  def name(n: Node.Reader, t: Type.Reader, suffix: String = ""): Tree = {
    import Type.Which._

    val e = javaFullName(t.getEnum)

    val i: Ident = null
    val b: Ident = null
    val c: Tree = (i DOT (b.symbol)).tree

    REF(t.which match {
      case VOID => "org.capnproto.Void"
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
      case TEXT => s"org.capnproto.Text.$suffix"
      case DATA => s"org.capnproto.Data.$suffix"
      case ENUM => javaFullName(n)
    })
  }

  def javaFullName(node: Node.Reader): String = {
    if (node.getScopeId == 0) {
      val (className, pkg) = node.getAnnotations.foldLeft(("", ""))((t, a) => a.getId match {
        case 0 => t.copy(_1 = a.getValue.getText.toString())
        case 1 => t.copy(_2 = a.getValue.getText.toString())
        case _ => t
      })

      s"$className.$pkg"
    } else {

    }
  }

  implicit class Compose[T](val v: T) extends AnyVal {
    def |>[R](fn: (T) => R): R = fn(v)
  }
}

*/
