package org.capnproto.runtime

import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.util

import BuilderArena._

object BuilderArena {

  object AllocationStrategy extends Enumeration {
    type AllocationStrategy = Value

    val FIXED_SIZE = Value

    val GROW_HEURISTICALLY = Value
  }

  val SUGGESTED_FIRST_SEGMENT_WORDS = 1024

  val SUGGESTED_ALLOCATION_STRATEGY = AllocationStrategy.GROW_HEURISTICALLY

  class AllocateResult(val segment: SegmentBuilder, val offset: Int)
}

class BuilderArena(firstSegmentSizeWords: Int, val allocationStrategy: AllocationStrategy.Value)
  extends Arena {

  val segments = new util.ArrayList[SegmentBuilder]()

  var nextSize: Int = firstSegmentSizeWords

  val segment0 = new SegmentBuilder(ByteBuffer.allocate(firstSegmentSizeWords * Constants.BYTES_PER_WORD),
    this)

  segment0.buffer.order(ByteOrder.LITTLE_ENDIAN)

  this.segments.add(segment0)

  def tryGetSegment(id: Int): SegmentReader = this.segments.get(id)

  def getSegment(id: Int): SegmentBuilder = this.segments.get(id)

  def checkReadLimit(numBytes: Int) {
  }

  def allocate(amount: Int): AllocateResult = {
    val len = this.segments.size
    val result = this.segments.get(len - 1).allocate(amount)
    if (result != SegmentBuilder.FAILED_ALLOCATION) {
      return new AllocateResult(this.segments.get(len - 1), result)
    }
    val size = Math.max(amount, this.nextSize)
    val newSegment = new SegmentBuilder(ByteBuffer.allocate(size * Constants.BYTES_PER_WORD), this)
    this.allocationStrategy match {
      case AllocationStrategy.GROW_HEURISTICALLY => this.nextSize += size
      case _ => //break
    }
    newSegment.buffer.order(ByteOrder.LITTLE_ENDIAN)
    newSegment.id = len
    this.segments.add(newSegment)
    new AllocateResult(newSegment, newSegment.allocate(amount))
  }

  def getSegmentsForOutput(): Array[ByteBuffer] = {
    val result = Array.ofDim[ByteBuffer](this.segments.size)
    for (ii <- 0 until this.segments.size) {
      val segment = segments.get(ii)
      segment.buffer.rewind()
      val slice = segment.buffer.slice()
      slice.limit(segment.currentSize() * Constants.BYTES_PER_WORD)
      slice.order(ByteOrder.LITTLE_ENDIAN)
      result(ii) = slice
    }
    result
  }
}
