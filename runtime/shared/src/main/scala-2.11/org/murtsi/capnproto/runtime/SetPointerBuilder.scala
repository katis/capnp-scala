package org.murtsi.capnproto.runtime

trait SetPointerBuilder {
  type Builder
  type Reader

  def setPointerBuilder(segment: SegmentBuilder, pointer: Int, value: Reader): Unit
}
