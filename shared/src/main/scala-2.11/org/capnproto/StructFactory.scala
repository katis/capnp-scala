package org.capnproto

trait Struct extends PointerFactoryTF
  with FromPointerBuilderRefDefaultTF
  with StructBuilder.FactoryTF
  with SetPointerBuilderTF
  with FromPointerReaderRefDefaultTF
  with StructReader.FactoryTF {

  type B <: StructBuilder
  type R <: StructReader

  abstract class Builder(segment: SegmentBuilder,
                         data: Int,
                         pointers: Int,
                         dataSize: Int,
                         pointerCount: Short) extends StructBuilder(segment, data, pointers, dataSize, pointerCount) {

    def asReader: R = Reader(segment, data, pointers, dataSize, pointerCount, 134217727)
  }

  abstract class Reader(segment: SegmentReader,
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
                                  nestingLimit: Int): R = {
    WireHelpers.readStructPointerTF(this, segment, pointer, defaultSegment, defaultOffset, nestingLimit)
  }

  def asReader(builder: Builder): R = builder.asReader()
}

object Date extends Struct {
  type B = Builder
  type R = Reader

  val Builder = new Builder(_, _, _, _, _)
  val Reader = new Reader(_, _, _, _, _, _)
  val structSize = new StructSize(2, 2)

  class Builder(segment: SegmentBuilder,
                data: Int,
                pointers: Int,
                dataSize: Int,
                pointerCount: Short) extends super.Builder(segment, data, pointers, dataSize, pointerCount) {
  }

  class Reader(segment: SegmentReader,
               data: Int,
               pointers: Int,
               dataSize: Int,
               pointerCount: Short,
               nestingLimit: Int) extends super.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit) {

  }


  def fromPointerReader(segment: SegmentReader, pointer: Int, nestingLimit: Int): Reader = {
    null
  }

  def fromPointerBuilderRefDefault(segment: SegmentBuilder,
                                   pointer: Int,
                                   defaultSegment: SegmentReader,
                                   defaultOffset: Int): Builder = {
    null
  }

  def fromPointerBuilder(segment: SegmentBuilder, pointer: Int): Builder = {
    null
  }

  def initFromPointerBuilder(segment: SegmentBuilder, pointer: Int, elementCount: Int): Builder = {
    null
  }

  def setPointerBuilder(segment: SegmentBuilder, pointer: Int, value: Reader) {
    null
  }
}

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
