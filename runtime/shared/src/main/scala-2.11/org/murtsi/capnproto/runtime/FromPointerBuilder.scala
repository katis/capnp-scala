package org.murtsi.capnproto.runtime

trait FromPointerBuilder {
  type Builder

  def fromPointerBuilder(segment: SegmentBuilder, pointer: Int): Builder

  def initFromPointerBuilder(segment: SegmentBuilder, pointer: Int, elementCount: Int): Builder
}