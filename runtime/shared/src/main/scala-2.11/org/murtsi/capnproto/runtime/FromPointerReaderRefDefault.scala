package org.murtsi.capnproto.runtime

trait FromPointerReaderRefDefault[T] {

  def fromPointerReaderRefDefault(segment: SegmentReader, 
      pointer: Int, 
      defaultSegment: SegmentReader, 
      defaultOffset: Int, 
      nestingLimit: Int): T
}

trait FromPointerReaderRefDefaultTF {
  type Reader

  def fromPointerReaderRefDefault(segment: SegmentReader,
      pointer: Int,
      defaultSegment: SegmentReader,
      defaultOffset: Int,
      nestingLimit: Int): Reader
}
