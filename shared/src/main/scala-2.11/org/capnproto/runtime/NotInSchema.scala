package org.capnproto.runtime

object NotInSchema {
  def enumMember(enumIdx: Int) = new NotInSchema(s"Enum index $enumIdx not in schema")
}

class NotInSchema(message: String, throwable: Throwable = null) extends Exception(message, throwable)
