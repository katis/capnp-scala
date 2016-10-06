package org.capnproto

trait SetPointerBuilder[Builder, Reader] {

  def setPointerBuilder(segment: SegmentBuilder, pointer: Int, value: Reader): Unit
}

trait SetPointerBuilderTF {
  type B
  type R

  def setPointerBuilder(segment: SegmentBuilder, pointer: Int, value: R): Unit
}
