package org.capnproto

trait FromPointerBuilder[T] {

  def fromPointerBuilder(segment: SegmentBuilder, pointer: Int): T

  def initFromPointerBuilder(segment: SegmentBuilder, pointer: Int, elementCount: Int): T
}

trait FromPointerBuilderTF {
  type B

  def fromPointerBuilder(segment: SegmentBuilder, pointer: Int): B

  def initFromPointerBuilder(segment: SegmentBuilder, pointer: Int, elementCount: Int): B
}