package org.capnproto.runtime

class NotInSchema(message: String, throwable: Throwable = null) extends Exception(message, throwable)
