package org.murtsi.capnproto.runtime

import java.nio.ByteBuffer

object Text extends Text
sealed class Text private() extends PointerFamily {

  type Reader = TextReader
  type Builder = TextBuilder

  def Reader(value: String): Reader = new TextReader(value)
  def Reader(byte: Array[Byte]): Reader = new TextReader(byte)
}

class TextReader(private[runtime] val buffer: ByteBuffer = ByteBuffer.allocate(0),
                 _offset: Int = 0,
                 val size: Int = 0) {
  private[runtime] val offset = _offset * 8

  def this(bytes: Array[Byte]) {
    this(ByteBuffer.wrap(bytes), 0, bytes.length)
  }

  def this(value: String) {
    this(value.getBytes("UTF-8"))
  }

  def asByteBuffer(): ByteBuffer = {
    val dup = this.buffer.asReadOnlyBuffer()
    dup.position(this.offset)
    val result = dup.slice()
    result.limit(this.size)
    result
  }

  override def toString: String = {
    val bytes = Array.ofDim[Byte](this.size)
    val dup = this.buffer.duplicate()
    dup.position(this.offset)
    dup.get(bytes, 0, this.size)
    new String(bytes, "UTF-8")
  }
}

class TextBuilder(val buffer: ByteBuffer = ByteBuffer.allocate(0),
                  val offset: Int = 0,
                  val size: Int = 0) {
  def asByteBuffer(): ByteBuffer = {
    val dup = this.buffer.duplicate()
    dup.position(this.offset)
    val result = dup.slice()
    result.limit(this.size)
    result
  }

  override def toString: String = {
    val bytes = Array.ofDim[Byte](this.size)
    val dup = this.buffer.duplicate()
    dup.position(this.offset)
    dup.get(bytes, 0, this.size)
    new String(bytes, "UTF-8")
  }
}

