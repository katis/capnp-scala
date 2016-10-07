package org.capnproto

trait FromPointerBuilderRefDefault[T] {

  def fromPointerBuilderRefDefault(segment: SegmentBuilder, 
      pointer: Int, 
      defaultSegment: SegmentReader, 
      defaultOffset: Int): T
}

trait FromPointerBuilderRefDefaultTF {
  type Builder

  def fromPointerBuilderRefDefault(segment: SegmentBuilder,
      pointer: Int,
      defaultSegment: SegmentReader,
      defaultOffset: Int): Builder
}
