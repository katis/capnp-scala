package org.murtsi.capnproto.runtime

import java.nio.ByteBuffer

object SegmentReader {

  val EMPTY = new SegmentReader(ByteBuffer.allocate(8), null)
}

class SegmentReader(val buffer: ByteBuffer, _arena: Arena) {
  def arena: Arena = _arena

  def get(index: Int): Long = {
    buffer.getLong(index * Constants.BYTES_PER_WORD)
  }
}
