package org.capnproto

import java.nio.ByteBuffer

object Data {

  object factory
    extends FromPointerReaderBlobDefault[Data.Reader]
      with PointerFactory[Data.Builder, Data.Reader]
      with FromPointerBuilderBlobDefault[Data.Builder]
      with SetPointerBuilder[Data.Builder, Data.Reader] {

    def fromPointerReaderBlobDefault(segment: SegmentReader,
                                     pointer: Int,
                                     defaultBuffer: java.nio.ByteBuffer,
                                     defaultOffset: Int,
                                     defaultSize: Int): Reader = {
      WireHelpers.readDataPointer(segment, pointer, defaultBuffer, defaultOffset, defaultSize)
    }

    def fromPointerReader(segment: SegmentReader, pointer: Int, nestingLimit: Int): Reader = {
      WireHelpers.readDataPointer(segment, pointer, null, 0, 0)
    }

    def fromPointerBuilderBlobDefault(segment: SegmentBuilder,
                                      pointer: Int,
                                      defaultBuffer: java.nio.ByteBuffer,
                                      defaultOffset: Int,
                                      defaultSize: Int): Builder = {
      WireHelpers.getWritableDataPointer(pointer, segment, defaultBuffer, defaultOffset, defaultSize)
    }

    def fromPointerBuilder(segment: SegmentBuilder, pointer: Int): Builder = {
      WireHelpers.getWritableDataPointer(pointer, segment, null, 0, 0)
    }

    def initFromPointerBuilder(segment: SegmentBuilder, pointer: Int, size: Int): Builder = {
      WireHelpers.initDataPointer(pointer, segment, size)
    }

    def setPointerBuilder(segment: SegmentBuilder, pointer: Int, value: Reader) {
      WireHelpers.setDataPointer(pointer, segment, value)
    }
  }

  class Reader(val buffer: ByteBuffer = ByteBuffer.allocate(0), val offset: Int = 0, val size: Int = 0) {
    def this(bytes: Array[Byte]) {
      this(ByteBuffer.wrap(bytes), 0, bytes.length)
    }

    def asByteBuffer(): ByteBuffer = {
      val dup = this.buffer.asReadOnlyBuffer()
      dup.position(this.offset)
      val result = dup.slice()
      result.limit(this.size)
      result
    }

    def toArray(): Array[Byte] = {
      val dup = this.buffer.duplicate()
      val result = Array.ofDim[Byte](this.size)
      dup.position(this.offset)
      dup.get(result, 0, this.size)
      result
    }
  }

  class Builder(val buffer: ByteBuffer = ByteBuffer.allocate(0), val offset: Int = 0, val size: Int = 0) {
    def asByteBuffer(): ByteBuffer = {
      val dup = this.buffer.duplicate()
      dup.position(this.offset)
      val result = dup.slice()
      result.limit(this.size)
      result
    }

    def toArray(): Array[Byte] = {
      val dup = this.buffer.duplicate()
      val result = Array.ofDim[Byte](this.size)
      dup.position(this.offset)
      dup.get(result, 0, this.size)
      result
    }
  }

}
