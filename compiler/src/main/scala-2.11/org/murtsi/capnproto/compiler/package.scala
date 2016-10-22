package org.murtsi.capnproto

package object compiler {
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
    "package",
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

  implicit class TypeInfo(val typ: Type.Reader) extends AnyVal {
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
          (for (brand <- struct.brand;
               scopes <- brand.scopes)
            yield scopes.size > 0).getOrElse(false)
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
