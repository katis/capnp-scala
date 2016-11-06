package org.murtsi.capnproto.runtime

trait StructReaderFromSegment[T] {
  def readerFromSegment(segment: SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): T
}

trait StructBuilderFromSegment[T] {
  def builderFromSegment(segment: SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): T
}

trait HasStructSize[T] {
  def structSize: StructSize
}

trait HasTypeId[T] {
  def typeId: Long
}

trait StructFromSegment[T <: Struct] extends StructReaderFromSegment[T#Reader] with StructBuilderFromSegment[T#Builder]

trait Struct
  extends PointerFamily
    with StructBuilder.Factory
    with StructReader.Factory
    {

  struct =>

  def typeId: Long
  def structSize: StructSize

  type Builder <: BuilderBase
  type Reader <: ReaderBase

  abstract class BuilderBase(_segment: SegmentBuilder,
                             _data: Int,
                             _pointers: Int,
                             _dataSize: Int,
                             _pointerCount: Short) extends StructBuilder(_segment, _data, _pointers, _dataSize, _pointerCount) {
    def asReader: Reader = Reader(_segment, _data, _pointers, _dataSize, _pointerCount, 0x7fffffff)
  }

  abstract class ReaderBase(_segment: SegmentReader,
                            _data: Int,
                            _pointers: Int,
                            _dataSize: Int,
                            _pointerCount: Short,
                            _nestingLimit: Int) extends StructReader(_segment, _data, _pointers, _dataSize, _pointerCount, _nestingLimit) {

  }

  /*
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
  */

  def asReader(builder: BuilderBase): Reader = builder.asReader
}

