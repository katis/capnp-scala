package org.capnproto.runtime

import java.nio.ByteBuffer

class ArrayInputStream(buffer: ByteBuffer) extends BufferedInputStream {

  val buf = buffer.asReadOnlyBuffer()

  def read(dst: ByteBuffer): Int = {
    val size = dst.remaining()
    val slice = this.buf.slice()
    slice.limit(size)
    dst.put(slice)
    this.buf.position(this.buf.position() + size)
    size
  }

  def getReadBuffer(): ByteBuffer = this.buf

  def close() {
    return
  }

  def isOpen(): Boolean = true
}
