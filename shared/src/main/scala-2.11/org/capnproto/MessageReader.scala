package org.capnproto

import java.nio.ByteBuffer

//remove if not needed
import scala.collection.JavaConversions._

class MessageReader(segmentSlices: Array[ByteBuffer], options: ReaderOptions) {

  val arena = new ReaderArena(segmentSlices, options.traversalLimitInWords)

  val nestingLimit = options.nestingLimit

  def getRoot[T](factory: FromPointerReader[T]): T = {
    val segment = this.arena.tryGetSegment(0)
    val any = new AnyPointer.Reader(segment, 0, this.nestingLimit)
    any.getAs(factory)
  }
}
