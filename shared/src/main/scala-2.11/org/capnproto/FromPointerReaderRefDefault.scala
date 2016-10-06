package org.capnproto

trait FromPointerReaderRefDefault[T] {

  def fromPointerReaderRefDefault(segment: SegmentReader, 
      pointer: Int, 
      defaultSegment: SegmentReader, 
      defaultOffset: Int, 
      nestingLimit: Int): T
}

trait FromPointerReaderRefDefaultTF {
  type R

  def fromPointerReaderRefDefault(segment: SegmentReader,
      pointer: Int,
      defaultSegment: SegmentReader,
      defaultOffset: Int,
      nestingLimit: Int): R
}
