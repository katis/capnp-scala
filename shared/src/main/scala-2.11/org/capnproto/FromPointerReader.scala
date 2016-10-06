package org.capnproto

trait FromPointerReader[T] {

  def fromPointerReader(segment: SegmentReader, pointer: Int, nestingLimit: Int): T
}

trait FromPointerReaderTF {
  type R

  def fromPointerReader(segment: SegmentReader, pointer: Int, nestingLimit: Int): R
}
