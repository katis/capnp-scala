package org.murtsi.capnproto.runtime

trait FromPointerReader {
  type Reader

  def fromPointerReader(segment: SegmentReader, pointer: Int, nestingLimit: Int): Reader
}
