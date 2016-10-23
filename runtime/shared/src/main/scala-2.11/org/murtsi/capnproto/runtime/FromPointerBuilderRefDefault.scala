package org.murtsi.capnproto.runtime

trait FromPointerBuilderRefDefault {
  type Builder

  def fromPointerBuilderRefDefault(segment: SegmentBuilder,
      pointer: Int,
      defaultSegment: SegmentReader,
      defaultOffset: Int): Builder
}
