package org.murtsi.capnproto.runtime

import java.nio.ByteBuffer

class MessageReader(segmentSlices: Array[ByteBuffer], options: ReaderOptions) {

  val arena = new ReaderArena(segmentSlices, options.traversalLimitInWords)

  val nestingLimit = options.nestingLimit

  def getRoot[T <: PointerFamily : FromPointer]: T#Reader = {
    val segment = this.arena.tryGetSegment(0)
    val any = new AnyPointer.Reader(segment, 0, this.nestingLimit)
    any.getAs[T]
  }
}
