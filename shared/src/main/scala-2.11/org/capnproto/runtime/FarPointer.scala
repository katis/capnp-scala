package org.capnproto.runtime

import java.nio.ByteBuffer

object FarPointer {

  def getSegmentId(ref: Long): Int = WirePointer.upper32Bits(ref)

  def positionInSegment(ref: Long): Int = WirePointer.offsetAndKind(ref) >>> 3

  def isDoubleFar(ref: Long): Boolean = {
    ((WirePointer.offsetAndKind(ref) >>> 2) & 1) != 0
  }

  def setSegmentId(buffer: ByteBuffer, offset: Int, segmentId: Int) {
    buffer.putInt(8 * offset + 4, segmentId)
  }

  def set(buffer: ByteBuffer, 
      offset: Int, 
      isDoubleFar: Boolean, 
      pos: Int) {
    val idf = if (isDoubleFar) 1 else 0
    WirePointer.setOffsetAndKind(buffer, offset, (pos << 3) | (idf << 2) | WirePointer.FAR)
  }
}
