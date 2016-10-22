package org.murtsi.capnproto.runtime

trait FromPointerReaderBlobDefault {
  type Reader

  def fromPointerReaderBlobDefault(segment: SegmentReader, 
      pointer: Int, 
      defaultBuffer: java.nio.ByteBuffer, 
      defaultOffset: Int, 
      defaultSize: Int): Reader
}
