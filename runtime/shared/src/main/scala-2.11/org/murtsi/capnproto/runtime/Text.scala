package org.murtsi.capnproto.runtime

import java.nio.ByteBuffer

object Text
    extends FromPointerReaderBlobDefault
    with FromPointerBuilderBlobDefault
    with PointerFactory
    with SetPointerBuilder {

  type Reader = ReaderImpl
  type Builder = BuilderImpl

  def Reader(value: String): Reader = new ReaderImpl(value)
  def Reader(byte: Array[Byte]): Reader = new ReaderImpl(byte)

  def fromPointerReaderBlobDefault(segment: SegmentReader,
                                   pointer: Int,
                                   defaultBuffer: java.nio.ByteBuffer,
                                   defaultOffset: Int,
                                   defaultSize: Int): Reader = {
    WireHelpers.readTextPointer(segment,
                                pointer,
                                defaultBuffer,
                                defaultOffset,
                                defaultSize)
  }

  def fromPointerReader(segment: SegmentReader,
                        pointer: Int,
                        nestingLimit: Int): Reader = {
    WireHelpers.readTextPointer(segment, pointer, null, 0, 0)
  }

  def fromPointerBuilderBlobDefault(segment: SegmentBuilder,
                                    pointer: Int,
                                    defaultBuffer: java.nio.ByteBuffer,
                                    defaultOffset: Int,
                                    defaultSize: Int): Builder = {
    WireHelpers.getWritableTextPointer(pointer,
                                       segment,
                                       defaultBuffer,
                                       defaultOffset,
                                       defaultSize)
  }

  def fromPointerBuilder(segment: SegmentBuilder, pointer: Int): Builder = {
    WireHelpers.getWritableTextPointer(pointer, segment, null, 0, 0)
  }

  def initFromPointerBuilder(segment: SegmentBuilder,
                             pointer: Int,
                             size: Int): Builder = {
    WireHelpers.initTextPointer(pointer, segment, size)
  }

  def setPointerBuilder(segment: SegmentBuilder, pointer: Int, value: Reader) {
    WireHelpers.setTextPointer(pointer, segment, value)
  }

  class ReaderImpl(val buffer: ByteBuffer = ByteBuffer.allocate(0),
                   _offset: Int = 0,
                   val size: Int = 0) {
    val offset = _offset * 8

    def this(bytes: Array[Byte]) {
      this(ByteBuffer.wrap(bytes), 0, bytes.length)
    }

    def this(value: String) {
      this(value.getBytes("UTF-8"))
    }

    def asByteBuffer(): ByteBuffer = {
      val dup = this.buffer.asReadOnlyBuffer()
      dup.position(this.offset)
      val result = dup.slice()
      result.limit(this.size)
      result
    }

    override def toString: String = {
      val bytes = Array.ofDim[Byte](this.size)
      val dup = this.buffer.duplicate()
      dup.position(this.offset)
      dup.get(bytes, 0, this.size)
      new String(bytes, "UTF-8")
    }
  }

  class BuilderImpl(val buffer: ByteBuffer = ByteBuffer.allocate(0),
                    val offset: Int = 0,
                    val size: Int = 0) {
    def asByteBuffer(): ByteBuffer = {
      val dup = this.buffer.duplicate()
      dup.position(this.offset)
      val result = dup.slice()
      result.limit(this.size)
      result
    }

    override def toString: String = {
      val bytes = Array.ofDim[Byte](this.size)
      val dup = this.buffer.duplicate()
      dup.position(this.offset)
      dup.get(bytes, 0, this.size)
      new String(bytes, "UTF-8")
    }
  }

}
