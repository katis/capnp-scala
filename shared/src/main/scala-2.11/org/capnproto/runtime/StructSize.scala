package org.capnproto.runtime

class StructSize(val data: Short, val pointers: Short) {

  def total(): Int = this.data.toInt + this.pointers.toInt
}
