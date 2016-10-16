package org.capnproto.runtime

object NotInSchema {
  def which(index: Short): NotInSchema = new NotInSchema(s"Invalid union member with index $index")
}

class NotInSchema(message: String, throwable: Throwable = null) extends Exception(message, throwable)
