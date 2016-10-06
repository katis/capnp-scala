package org.capnproto

import java.nio.ByteBuffer
import java.nio.channels.WritableByteChannel

class BufferedOutputStreamWrapper(w: WritableByteChannel) extends BufferedOutputStream {

  private val inner = w

  private val buf = ByteBuffer.allocate(8192)

  def write(src: ByteBuffer): Int = {
    val available = this.buf.remaining()
    val size = src.remaining()
    if (size <= available) {
      this.buf.put(src)
    } else if (size <= this.buf.capacity()) {
      val slice = src.slice()
      slice.limit(available)
      this.buf.put(slice)
      this.buf.rewind()
      while (this.buf.hasRemaining()) {
        this.inner.write(this.buf)
      }
      this.buf.rewind()
      src.position(src.position() + available)
      this.buf.put(src)
    } else {
      val pos = this.buf.position()
      this.buf.rewind()
      val slice = this.buf.slice()
      slice.limit(pos)
      while (slice.hasRemaining()) {
        this.inner.write(slice)
      }
      while (src.hasRemaining()) {
        this.inner.write(src)
      }
    }
    size
  }

  def writeBuffer(): ByteBuffer = this.buf

  def close() {
    this.inner.close()
  }

  def isOpen(): Boolean = this.inner.isOpen

  def flush() {
    val pos = this.buf.position()
    this.buf.rewind()
    this.buf.limit(pos)
    this.inner.write(this.buf)
    this.buf.clear()
  }
}
