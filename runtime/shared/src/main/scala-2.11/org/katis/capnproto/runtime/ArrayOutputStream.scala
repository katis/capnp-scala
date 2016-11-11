package org.katis.capnproto.runtime

import java.io.IOException
import java.nio.ByteBuffer

class ArrayOutputStream(buffer: ByteBuffer) extends BufferedOutputStream {

  val buf = buffer.duplicate()

  def write(src: ByteBuffer): Int = {
    val available = this.buf.remaining()
    val size = src.remaining()
    if (available < size) {
      throw new IOException("backing buffer was not large enough")
    }
    this.buf.put(src)
    size
  }

  def writeBuffer: ByteBuffer = this.buf

  def close() {}

  def isOpen: Boolean = true

  def flush() {}
}
