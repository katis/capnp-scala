package org.capnproto

trait FromPointerReaderBlobDefault[T] {

  def fromPointerReaderBlobDefault(segment: SegmentReader, 
      pointer: Int, 
      defaultBuffer: java.nio.ByteBuffer, 
      defaultOffset: Int, 
      defaultSize: Int): T
}
