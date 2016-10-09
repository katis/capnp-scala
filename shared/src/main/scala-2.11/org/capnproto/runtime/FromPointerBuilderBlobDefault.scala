package org.capnproto.runtime

trait FromPointerBuilderBlobDefault {
  type Builder

  def fromPointerBuilderBlobDefault(segment: SegmentBuilder, 
      pointer: Int, 
      defaultBuffer: java.nio.ByteBuffer, 
      defaultOffset: Int, 
      defaultSize: Int): Builder
}
