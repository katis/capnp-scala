package org.capnproto

import java.nio.channels.WritableByteChannel
import java.nio.ByteBuffer

class PackedOutputStream(output: BufferedOutputStream) extends WritableByteChannel {

  val inner = output

  def write(inBuf: ByteBuffer): Int = {
    val length = inBuf.remaining()
    var out = this.inner.writeBuffer
    val slowBuffer = ByteBuffer.allocate(20)
    var inPtr = inBuf.position()
    val inEnd = inPtr + length
    while (inPtr < inEnd) {
      if (out.remaining() < 10) {
        if (out == slowBuffer) {
          val oldLimit = out.limit()
          out.limit(out.position())
          out.rewind()
          this.inner.write(out)
          out.limit(oldLimit)
        }
        out = slowBuffer
        out.rewind()
      }
      val tagPos = out.position()
      out.position(tagPos + 1)
      var curByte: Byte = 0
      curByte = inBuf.get(inPtr)
      val bit0 = if (curByte != 0) 1.toByte else 0.toByte
      out.put(curByte)
      out.position(out.position() + bit0 - 1)
      inPtr += 1
      curByte = inBuf.get(inPtr)
      val bit1 = if (curByte != 0) 1.toByte else 0.toByte
      out.put(curByte)
      out.position(out.position() + bit1 - 1)
      inPtr += 1
      curByte = inBuf.get(inPtr)
      val bit2 = if (curByte != 0) 1.toByte else 0.toByte
      out.put(curByte)
      out.position(out.position() + bit2 - 1)
      inPtr += 1
      curByte = inBuf.get(inPtr)
      val bit3 = if (curByte != 0) 1.toByte else 0.toByte
      out.put(curByte)
      out.position(out.position() + bit3 - 1)
      inPtr += 1
      curByte = inBuf.get(inPtr)
      val bit4 = if (curByte != 0) 1.toByte else 0.toByte
      out.put(curByte)
      out.position(out.position() + bit4 - 1)
      inPtr += 1
      curByte = inBuf.get(inPtr)
      val bit5 = if (curByte != 0) 1.toByte else 0.toByte
      out.put(curByte)
      out.position(out.position() + bit5 - 1)
      inPtr += 1
      curByte = inBuf.get(inPtr)
      val bit6 = if (curByte != 0) 1.toByte else 0.toByte
      out.put(curByte)
      out.position(out.position() + bit6 - 1)
      inPtr += 1
      curByte = inBuf.get(inPtr)
      val bit7 = if (curByte != 0) 1.toByte else 0.toByte
      out.put(curByte)
      out.position(out.position() + bit7 - 1)
      inPtr += 1
      val tag = ((bit0 << 0) | (bit1 << 1) | (bit2 << 2) | (bit3 << 3) | 
        (bit4 << 4) | 
        (bit5 << 5) | 
        (bit6 << 6) | 
        (bit7 << 7)).toByte
      out.put(tagPos, tag)
      if (tag == 0) {
        val runStart = inPtr
        var limit = inEnd
        if (limit - inPtr > 255 * 8) {
          limit = inPtr + 255 * 8
        }
        while (inPtr < limit && inBuf.getLong(inPtr) == 0) {
          inPtr += 8
        }
        out.put(((inPtr - runStart) / 8).toByte)
      } else if (tag == 0xff.toByte) {
        val runStart = inPtr
        var limit = inEnd
        if (limit - inPtr > 255 * 8) {
          limit = inPtr + 255 * 8
        }
        var run = true
        while (run && inPtr < limit) {
          var c: Byte = 0
          for (ii <- 0.until(8)) {
            c = (c + (if (inBuf.get(inPtr) == 0) 1 else 0).toByte).toByte
            inPtr += 1
          }
          if (c >= 2) {
            inPtr -= 8
            run = false
          }
        }
        val count = inPtr - runStart
        out.put((count / 8).toByte)
        if (count <= out.remaining()) {
          inBuf.position(runStart)
          val slice = inBuf.slice()
          slice.limit(count)
          out.put(slice)
        } else {
          if (out == slowBuffer) {
            val oldLimit = out.limit()
            out.limit(out.position())
            out.rewind()
            this.inner.write(out)
            out.limit(oldLimit)
          }
          inBuf.position(runStart)
          val slice = inBuf.slice()
          slice.limit(count)
          while (slice.hasRemaining) {
            this.inner.write(slice)
          }
          out = this.inner.writeBuffer
        }
      }
    }
    if (out == slowBuffer) {
      out.limit(out.position())
      out.rewind()
      this.inner.write(out)
    }
    inBuf.position(inPtr)
    length
  }

  def close() {
    this.inner.close()
  }

  def isOpen(): Boolean = this.inner.isOpen
}
