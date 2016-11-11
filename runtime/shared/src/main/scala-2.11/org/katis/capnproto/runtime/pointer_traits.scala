package org.katis.capnproto.runtime

trait PointerFamily {
  type Builder
  type Reader
}

trait FromPointerBuilder[Builder] {
  def fromPointerBuilder(segment: SegmentBuilder, pointer: Int): Builder
  def initFromPointerBuilder(segment: SegmentBuilder, pointer: Int, elementCount: Int): Builder
}

trait FromPointerReader[Reader] {
  def fromPointerReader(segment: SegmentReader, pointer: Int, nestingLimit: Int): Reader
}

trait FromPointerBuilderRefDefault[Builder] {
    def fromPointerBuilderRefDefault(segment: SegmentBuilder,
                                     pointer: Int,
                                     defaultSegment: SegmentReader,
                                     defaultOffset: Int): Builder
}

trait FromPointerReaderRefDefault[Reader] {
  def fromPointerReaderRefDefault(segment: SegmentReader,
                                  pointer: Int,
                                  defaultSegment: SegmentReader,
                                  defaultOffset: Int,
                                  nestingLimit: Int): Reader
}

trait FromPointerRefDefault[T <: PointerFamily] extends FromPointerBuilderRefDefault[T#Builder] with FromPointerReaderRefDefault[T#Reader]{}

trait FromPointerBuilderBlobDefault[Builder] {
  def fromPointerBuilderBlobDefault(segment: SegmentBuilder,
      pointer: Int,
      defaultBuffer: java.nio.ByteBuffer,
      defaultOffset: Int,
      defaultSize: Int): Builder
}

trait FromPointerReaderBlobDefault[Reader] {
  def fromPointerReaderBlobDefault(segment: SegmentReader,
      pointer: Int,
      defaultBuffer: java.nio.ByteBuffer,
      defaultOffset: Int,
      defaultSize: Int): Reader
}

trait FromPointerBlobDefault[T <: PointerFamily] extends FromPointerBuilderBlobDefault[T#Builder] with FromPointerReaderBlobDefault[T#Reader]

trait SetPointerBuilder[T <: PointerFamily] {
  def setPointerBuilder(segment: SegmentBuilder, pointer: Int, value: T#Reader): Unit
}

trait FromPointer[T <: PointerFamily] extends FromPointerBuilder[T#Builder] with FromPointerReader[T#Reader]
