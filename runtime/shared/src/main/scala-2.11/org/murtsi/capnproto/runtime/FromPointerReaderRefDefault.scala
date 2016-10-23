package org.murtsi.capnproto.runtime

trait FromPointerReaderRefDefault {
  type Reader

  def fromPointerReaderRefDefault(segment: SegmentReader,
      pointer: Int,
      defaultSegment: SegmentReader,
      defaultOffset: Int,
      nestingLimit: Int): Reader
}
