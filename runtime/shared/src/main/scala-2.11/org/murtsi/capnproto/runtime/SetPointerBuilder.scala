package org.murtsi.capnproto.runtime

trait SetPointerBuilder[Builder, Reader] {

  def setPointerBuilder(segment: SegmentBuilder, pointer: Int, value: Reader): Unit
}

trait SetPointerBuilderTF {
  type Builder
  type Reader

  def setPointerBuilder(segment: SegmentBuilder, pointer: Int, value: Reader): Unit
}
