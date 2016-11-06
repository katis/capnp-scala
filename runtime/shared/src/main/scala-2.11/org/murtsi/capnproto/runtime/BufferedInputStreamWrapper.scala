package org.murtsi.capnproto.runtime

import java.nio.ByteBuffer
import java.nio.channels.ReadableByteChannel

import BufferedInputStreamWrapper._

object BufferedInputStreamWrapper {

  def readAtLeast(reader: ReadableByteChannel, buf: ByteBuffer, minBytes: Int): Int = {
    var numRead = 0
    while (numRead < minBytes) {
      val res = reader.read(buf)
      if (res < 0) {
        throw new Error("premature EOF")
      }
      numRead += res
    }
    numRead
  }
}

class BufferedInputStreamWrapper(chan: ReadableByteChannel) extends BufferedInputStream {

  private val inner = chan

  private val buf = ByteBuffer.allocate(8192)

  this.buf.limit(0)

  def read(dst: ByteBuffer): Int = {
    var numBytes = dst.remaining()
    if (numBytes < this.buf.remaining()) {
      val slice = this.buf.slice()
      slice.limit(numBytes)
      dst.put(slice)
      this.buf.position(this.buf.position() + numBytes)
      numBytes
    } else {
      val fromFirstBuffer = this.buf.remaining()
      val slice = this.buf.slice()
      slice.limit(fromFirstBuffer)
      dst.put(slice)
      numBytes -= fromFirstBuffer
      if (numBytes <= this.buf.capacity()) {
        this.buf.clear()
        val n = readAtLeast(this.inner, this.buf, numBytes)
        this.buf.rewind()
        val slice = this.buf.slice()
        slice.limit(numBytes)
        dst.put(slice)
        this.buf.limit(n)
        this.buf.position(numBytes)
        fromFirstBuffer + numBytes
      } else {
        this.buf.clear()
        this.buf.limit(0)
        fromFirstBuffer + readAtLeast(this.inner, dst, numBytes)
      }
    }
  }

  def getReadBuffer(): ByteBuffer = {
    if (this.buf.remaining() == 0) {
      this.buf.clear()
      val n = readAtLeast(this.inner, this.buf, 1)
      this.buf.rewind()
      this.buf.limit(n)
    }
    this.buf
  }

  def close() {
    this.inner.close()
  }

  def isOpen(): Boolean = this.inner.isOpen
}
