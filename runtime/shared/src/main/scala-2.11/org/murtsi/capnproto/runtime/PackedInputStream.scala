package org.murtsi.capnproto.runtime

import java.nio.channels.ReadableByteChannel
import java.nio.ByteBuffer

class PackedInputStream(input: BufferedInputStream) extends ReadableByteChannel {

  val inner = input

  def read(outBuf: ByteBuffer): Int = {
    val len = outBuf.remaining()
    if (len == 0) {
      return 0
    }
    if (len % 8 != 0) {
      throw new Error("PackedInputStream reads must be word-aligned")
    }
    val outPtr = outBuf.position()
    val outEnd = outPtr + len
    var inBuf = this.inner.getReadBuffer
    while (true) {
      var tag: Byte = 0
      if (inBuf.remaining() < 10) {
        if (outBuf.remaining() == 0) {
          return len
        }
        if (inBuf.remaining() == 0) {
          inBuf = this.inner.getReadBuffer
          //continue
        }
        tag = inBuf.get
        for (i <- 0.until(8)) {
          if ((tag & (1 << i)) != 0) {
            if (inBuf.remaining() == 0) {
              inBuf = this.inner.getReadBuffer
            }
            outBuf.put(inBuf.get)
          } else {
            outBuf.put(0.toByte)
          }
        }
        if (inBuf.remaining() == 0 && (tag == 0 || tag == 0xff.toByte)) {
          inBuf = this.inner.getReadBuffer
        }
      } else {
        tag = inBuf.get
        for (n <- 0.until(8)) {
          val isNonzero = (tag & (1 << n)) != 0
          outBuf.put((inBuf.get & (if (isNonzero) -1 else 0)).toByte)
          inBuf.position(inBuf.position() + (if (isNonzero) 0 else -1))
        }
      }
      if (tag == 0) {
        if (inBuf.remaining() == 0) {
          throw new Error("Should always have non-empty buffer here.")
        }
        val runLength = (0xff & inBuf.get.toInt) * 8
        if (runLength > outEnd - outPtr) {
          throw new Error("Packed input did not end cleanly on a segment boundary")
        }
        for (i <- 0 until runLength) {
          outBuf.put(0.toByte)
        }
      } else if (tag == 0xff.toByte) {
        var runLength = (0xff & inBuf.get.toInt) * 8
        if (inBuf.remaining() >= runLength) {
          val slice = inBuf.slice()
          slice.limit(runLength)
          outBuf.put(slice)
          inBuf.position(inBuf.position() + runLength)
        } else {
          runLength -= inBuf.remaining()
          outBuf.put(inBuf)
          val slice = outBuf.slice()
          slice.limit(runLength)
          this.inner.read(slice)
          outBuf.position(outBuf.position() + runLength)
          if (outBuf.remaining() == 0) {
            return len
          } else {
            inBuf = this.inner.getReadBuffer
            //continue
          }
        }
      }
      if (outBuf.remaining() == 0) {
        len
      }
    }
    throw new Error("Should never happen")
  }

  def close() {
    inner.close()
  }

  def isOpen(): Boolean = inner.isOpen
}
