package org.capnproto

package object compiler {
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
    "until",
    "val",
    "var",
    "while",
    "with",
    "yield"
  )

  implicit class NodeInfo(val nodeReader: CapnpSchema.Node.Reader) extends AnyVal {
    def parametersTexts(): Unit = {

    }
  }

  implicit class TypeInfo(val typ: CapnpSchema.Type.Reader) extends AnyVal {
    def isParameter: Boolean = {
      typ.which match {
        case CapnpSchema.Type.AnyPointer.Which.PARAMETER => true
        case _ => false
      }
    }

    def isBranded: Boolean = {
      typ.which match {
        case CapnpSchema.Type.Which.STRUCT =>
          val struct = typ.struct
          val brand = struct.brand
          brand.scopes.size > 0
        case _ => false
      }
    }

    def isPrimitive: Boolean = {
      import CapnpSchema.Type.Which._
      typ.which match {
        case INT8 | INT16 | INT32 | INT64 | UINT8 | UINT16 | UINT32 | UINT64 | FLOAT32 | FLOAT64 | VOID | BOOL => true
        case _ => false
      }
    }
  }

}
