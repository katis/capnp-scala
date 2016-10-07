package org.capnproto

trait Struct extends PointerFactoryTF
  with FromPointerBuilderRefDefaultTF
  with StructBuilder.FactoryTF
  with SetPointerBuilderTF
  with FromPointerReaderRefDefaultTF
  with StructReader.FactoryTF {

  type Builder <: StructBuilder
  type Reader <: StructReader

  abstract class BuilderBase(segment: SegmentBuilder,
                             data: Int,
                             pointers: Int,
                             dataSize: Int,
                             pointerCount: Short) extends StructBuilder(segment, data, pointers, dataSize, pointerCount) {

    def asReader: Reader = Reader(segment, data, pointers, dataSize, pointerCount, 134217727)
  }

  abstract class ReaderBase(segment: SegmentReader,
                            data: Int,
                            pointers: Int,
                            dataSize: Int,
                            pointerCount: Short,
                            nestingLimit: Int) extends StructReader(segment, data, pointers, dataSize, pointerCount, nestingLimit) {

  }

  override def fromPointerReaderRefDefault(segment: SegmentReader,
                                  pointer: Int,
                                  defaultSegment: SegmentReader,
                                  defaultOffset: Int,
                                  nestingLimit: Int): Reader = {
    WireHelpers.readStructPointerTF(this, segment, pointer, defaultSegment, defaultOffset, nestingLimit)
  }


  def fromPointerReader(segment: SegmentReader, pointer: Int, nestingLimit: Int): Reader = {
    fromPointerReaderRefDefault(segment, pointer, null, 0, nestingLimit)
  }

  def fromPointerBuilderRefDefault(segment: SegmentBuilder,
                                   pointer: Int,
                                   defaultSegment: SegmentReader,
                                   defaultOffset: Int): Builder = {
    WireHelpers.getWritableStructPointer(this, pointer, segment, this.structSize, defaultSegment, defaultOffset)
  }

  def fromPointerBuilder(segment: SegmentBuilder, pointer: Int): Builder = {
    WireHelpers.getWritableStructPointer(this, pointer, segment, this.structSize, null, 0)
  }

  def initFromPointerBuilder(segment: SegmentBuilder, pointer: Int, elementCount: Int): Builder = {
    WireHelpers.initStructPointer(this, pointer, segment, this.structSize)
  }

  def setPointerBuilder(segment: SegmentBuilder, pointer: Int, value: Reader) {
    WireHelpers.setStructPointer(segment, pointer, value)
  }

  def asReader(builder: BuilderBase): Reader = builder.asReader
}

object Date extends Struct {
  type Builder = BuilderImpl
  type Reader = ReaderImpl

  val Builder = new BuilderImpl(_, _, _, _, _)
  val Reader = new ReaderImpl(_, _, _, _, _, _)
  val structSize = new StructSize(2, 2)

  class BuilderImpl(segment: SegmentBuilder,
                    data: Int,
                    pointers: Int,
                    dataSize: Int,
                    pointerCount: Short) extends super.BuilderBase(segment, data, pointers, dataSize, pointerCount) {
  }

  class ReaderImpl(segment: SegmentReader,
                   data: Int,
                   pointers: Int,
                   dataSize: Int,
                   pointerCount: Short,
                   nestingLimit: Int) extends super.ReaderBase(segment, data, pointers, dataSize, pointerCount, nestingLimit) {

  }
}

/*
trait StructFactory[Builder, Reader <: StructReader]
  extends PointerFactory[Builder, Reader]
    with FromPointerBuilderRefDefault[Builder]
    with StructBuilder.Factory[Builder]
    with SetPointerBuilder[Builder, Reader]
    with FromPointerReaderRefDefault[Reader]
    with StructReader.Factory[Reader] {

  def fromPointerReaderRefDefault(segment: SegmentReader,
                                  pointer: Int,
                                  defaultSegment: SegmentReader,
                                  defaultOffset: Int,
                                  nestingLimit: Int): Reader = {
    WireHelpers.readStructPointer(this, segment, pointer, defaultSegment, defaultOffset, nestingLimit)
  }

  def fromPointerReader(segment: SegmentReader, pointer: Int, nestingLimit: Int): Reader = {
    fromPointerReaderRefDefault(segment, pointer, null, 0, nestingLimit)
  }

  def fromPointerBuilderRefDefault(segment: SegmentBuilder,
                                   pointer: Int,
                                   defaultSegment: SegmentReader,
                                   defaultOffset: Int): Builder = {
    WireHelpers.getWritableStructPointer(this, pointer, segment, this.structSize, defaultSegment, defaultOffset)
  }

  def fromPointerBuilder(segment: SegmentBuilder, pointer: Int): Builder = {
    WireHelpers.getWritableStructPointer(this, pointer, segment, this.structSize, null, 0)
  }

  def initFromPointerBuilder(segment: SegmentBuilder, pointer: Int, elementCount: Int): Builder = {
    WireHelpers.initStructPointer(this, pointer, segment, this.structSize)
  }

  def setPointerBuilder(segment: SegmentBuilder, pointer: Int, value: Reader) {
    WireHelpers.setStructPointer(segment, pointer, value)
  }

  def asReader(builder: Builder): Reader
}
*/
