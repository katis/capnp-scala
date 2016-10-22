package org.murtsi.capnproto.runtime

object GeneratedClassSupport {

  def decodeRawBytes(s: String): SegmentReader = {
    val buffer = java.nio.ByteBuffer.wrap(s.getBytes("ISO_8859-1")).asReadOnlyBuffer()
    buffer.order(java.nio.ByteOrder.LITTLE_ENDIAN)
    new SegmentReader(buffer, new ReaderArena(Array.ofDim[java.nio.ByteBuffer](0), 0x7fffffffffffffffL))
  }
}
