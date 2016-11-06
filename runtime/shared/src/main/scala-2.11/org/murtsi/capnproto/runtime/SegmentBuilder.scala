package org.murtsi.capnproto.runtime

import java.nio.ByteBuffer

import SegmentBuilder._

object SegmentBuilder {

  val FAILED_ALLOCATION = -1
}

class SegmentBuilder(buf: ByteBuffer, _arena: Arena) extends SegmentReader(buf, _arena) {

  var pos: Int = 0

  var id: Int = 0

  private def capacity(): Int = {
    this.buffer.rewind()
    this.buffer.remaining() / 8
  }

  def currentSize(): Int = this.pos

  def allocate(amount: Int): Int = {
    assert(amount >= 0, "tried to allocate a negative number of words")
    if (amount > this.capacity() - this.currentSize()) {
      FAILED_ALLOCATION
    } else {
      val result = this.pos
      this.pos += amount
      result
    }
  }

  override def arena: BuilderArena = {
    super.arena.asInstanceOf[BuilderArena]
  }

  def isWritable: Boolean = true

  def put(index: Int, value: Long) {
    buffer.putLong(index * Constants.BYTES_PER_WORD, value)
  }
}
