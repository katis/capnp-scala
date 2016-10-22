package org.murtsi.capnproto.runtime

import java.util.ArrayList
import java.nio.ByteBuffer
//remove if not needed
import scala.collection.JavaConversions._

class ReaderArena(segmentSlices: Array[ByteBuffer], traversalLimitInWords: Long)
    extends Arena {

  var limit: Long = traversalLimitInWords

  val segments = new ArrayList[SegmentReader]()

  for (ii <- segmentSlices.indices) {
    this.segments.add(new SegmentReader(segmentSlices(ii), this))
  }

  def tryGetSegment(id: Int): SegmentReader = segments.get(id)

  def checkReadLimit(numBytes: Int) {
    if (numBytes > limit) {
      throw new DecodeException("Read limit exceeded.")
    } else {
      limit -= numBytes
    }
  }
}
