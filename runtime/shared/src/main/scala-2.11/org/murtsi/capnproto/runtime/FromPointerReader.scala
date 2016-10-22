package org.murtsi.capnproto.runtime

trait FromPointerReader[T] {

  def fromPointerReader(segment: SegmentReader, pointer: Int, nestingLimit: Int): T
}

trait FromPointerReaderTF {
  type Reader

  def fromPointerReader(segment: SegmentReader, pointer: Int, nestingLimit: Int): Reader
}
