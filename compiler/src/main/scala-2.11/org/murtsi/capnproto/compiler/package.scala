package org.murtsi.capnproto

import org.murtsi.capnproto.runtime.{HasStructSize, HasTypeId}

import org.murtsi.capnproto.compiler.schema._

package object compiler {
  val PackageNameAnnotationId = 0xee44ce11f43e05d7L
  val ModuleAnnotationId = 0xfd7b105ce99a1686L

  val reservedClasses = Seq(
    "List",
    "Reader",
    "Builder",
    "ReaderImpl",
    "BuilderImpl",
    "ReaderBase",
    "BuilderBase"
  )

  val keywords = Seq(
    "case",
    "catch",
    "class",
    "def",
    "do",
    "else",
    "extends",
    "false",
    "final",
    "for",
    "if",
    "implicit",
    "import",
    "match",
    "new",
    "null",
    "object",
    "compiler",
    "print",
    "printf",
    "println",
    "private",
    "protected",
    "this",
    "throw",
    "to",
    "trait",
    "true",
    "try",
    "type",
    "until",
    "val",
    "var",
    "while",
    "with",
    "yield"
  ) ++ reservedClasses

  def booleanMatch[A, B](value: A)(fn: PartialFunction[A, B]): Boolean = fn.isDefinedAt(value)

  case class TypeParameterTexts(expandedList: Seq[String],
                                params: String)

  implicit class TypeInfo(val typ: Type#Reader) extends AnyVal {
    def isParameter: Boolean = {
      typ match {
        case Type.AnyPointer(ptr) =>
          ptr match {
            case Type.AnyPointer.Parameter(_) => true
            case _ => false
          }
        case _ => false
      }
    }

    def isBranded: Boolean = {
      typ match {
        case Type.Struct(struct) =>
          struct.brand.scopes.size > 0
        case _ => false
      }
    }

    def isPrimitive: Boolean = {
      import Type._
      typ match {
        case Int8() | Int16() | Int32() | Int64() | Uint8() | Uint16() | Uint32() | Uint64() | Float32() | Float64() | Void() | Bool() => true
        case _ => false
      }
    }
  }
}
