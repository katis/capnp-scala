package org.murtsi.capnproto.runtime

import java.nio.ByteBuffer

object Data extends Data
class Data private() extends PointerFamily {
  data =>

  type Builder = DataBuilder
  type Reader = DataReader
}

class DataReader(val buffer: ByteBuffer = ByteBuffer.allocate(0),
                 val offset: Int = 0,
                 val size: Int = 0) {
  def this(bytes: Array[Byte]) {
    this(ByteBuffer.wrap(bytes), 0, bytes.length)
  }

  def asByteBuffer(): ByteBuffer = {
    val dup = this.buffer.asReadOnlyBuffer()
    dup.position(this.offset)
    val result = dup.slice()
    result.limit(this.size)
    result
  }

  def toArray: Array[Byte] = {
    val dup = this.buffer.duplicate()
    val result = Array.ofDim[Byte](this.size)
    dup.position(this.offset)
    dup.get(result, 0, this.size)
    result
  }
}

class DataBuilder(val buffer: ByteBuffer = ByteBuffer.allocate(0),
                  val offset: Int = 0,
                  val size: Int = 0) {
  def asByteBuffer(): ByteBuffer = {
    val dup = this.buffer.duplicate()
    dup.position(this.offset)
    val result = dup.slice()
    result.limit(this.size)
    result
  }

  def toArray: Array[Byte] = {
    val dup = this.buffer.duplicate()
    val result = Array.ofDim[Byte](this.size)
    dup.position(this.offset)
    dup.get(result, 0, this.size)
    result
  }
}
