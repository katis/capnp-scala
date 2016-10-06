package org.capnproto

trait FromPointerBuilderBlobDefault[T] {

  def fromPointerBuilderBlobDefault(segment: SegmentBuilder, 
      pointer: Int, 
      defaultBuffer: java.nio.ByteBuffer, 
      defaultOffset: Int, 
      defaultSize: Int): T
}
