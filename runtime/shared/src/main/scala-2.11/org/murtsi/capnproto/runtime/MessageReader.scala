package org.murtsi.capnproto.runtime

import java.nio.ByteBuffer

//remove if not needed
import scala.collection.JavaConversions._

class MessageReader(segmentSlices: Array[ByteBuffer], options: ReaderOptions) {

  val arena = new ReaderArena(segmentSlices, options.traversalLimitInWords)

  val nestingLimit = options.nestingLimit

  def getRoot(factory: FromPointerReader): factory.Reader = {
    val segment = this.arena.tryGetSegment(0)
    val any = new AnyPointer.Reader(segment, 0, this.nestingLimit)
    any.getAs(factory).asInstanceOf[factory.Reader] // TODO: find out a way to remove these casts
  }
}
