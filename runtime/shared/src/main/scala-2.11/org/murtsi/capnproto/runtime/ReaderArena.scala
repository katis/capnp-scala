package org.murtsi.capnproto.runtime

import java.nio.ByteBuffer

import scala.collection.mutable

class ReaderArena(segmentSlices: Array[ByteBuffer], traversalLimitInWords: Long)
    extends Arena {

  var limit: Long = traversalLimitInWords

  val segments = new mutable.ArrayBuffer[SegmentReader]()

  for (ii <- segmentSlices.indices) {
    segments += new SegmentReader(segmentSlices(ii), this)
  }

  def tryGetSegment(id: Int): SegmentReader = segments(id)

  def checkReadLimit(numBytes: Int) {
    if (numBytes > limit) {
      throw new DecodeException("Read limit exceeded.")
    } else {
      limit -= numBytes
    }
  }
}
