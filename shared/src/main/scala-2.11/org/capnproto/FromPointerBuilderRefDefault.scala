package org.capnproto

trait FromPointerBuilderRefDefault[T] {

  def fromPointerBuilderRefDefault(segment: SegmentBuilder, 
      pointer: Int, 
      defaultSegment: SegmentReader, 
      defaultOffset: Int): T
}

trait FromPointerBuilderRefDefaultTF {
  type B

  def fromPointerBuilderRefDefault(segment: SegmentBuilder,
      pointer: Int,
      defaultSegment: SegmentReader,
      defaultOffset: Int): B
}
