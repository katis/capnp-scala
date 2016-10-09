package org.capnproto.runtime

trait FromPointerBuilder[T] {

  def fromPointerBuilder(segment: SegmentBuilder, pointer: Int): T

  def initFromPointerBuilder(segment: SegmentBuilder, pointer: Int, elementCount: Int): T
}

trait FromPointerBuilderTF {
  type Builder

  def fromPointerBuilder(segment: SegmentBuilder, pointer: Int): Builder

  def initFromPointerBuilder(segment: SegmentBuilder, pointer: Int, elementCount: Int): Builder
}