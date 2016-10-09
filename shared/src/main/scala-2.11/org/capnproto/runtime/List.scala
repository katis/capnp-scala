package org.capnproto.runtime

abstract class List[ElementBuilder, ElementReader](val elementSize: Byte)
    extends ListBuilder.Factory
    with FromPointerBuilderRefDefaultTF
    with SetPointerBuilderTF
    with ListReader.Factory
    with PointerFactoryTF
    with FromPointerReaderRefDefaultTF {

  type Builder <: BuilderBase
  type Reader <: ReaderBase

  abstract class BuilderBase(
      segment: SegmentBuilder,
      ptr: Int,
      elementCount: Int,
      step: Int,
      structDataSize: Int,
      structPointerCount: Short
  ) extends ListBuilder(segment,
                          ptr,
                          elementCount,
                          step,
                          structDataSize,
                          structPointerCount) {

    def apply(idx: Int): ElementBuilder
  }

  abstract class ReaderBase(
      segment: SegmentReader,
      ptr: Int,
      elementCount: Int,
      step: Int,
      structDataSize: Int,
      structPointerCount: Short,
      nestingLimit: Int
  ) extends ListReader(segment,
                         ptr,
                         elementCount,
                         step,
                         structDataSize,
                         structPointerCount,
                         nestingLimit) {

    def apply(idx: Int): ElementReader
  }

  def fromPointerReaderRefDefault(segment: SegmentReader,
                                  pointer: Int,
                                  defaultSegment: SegmentReader,
                                  defaultOffset: Int,
                                  nestingLimit: Int): Reader = {
    WireHelpers.readListPointer(this,
                                segment,
                                pointer,
                                defaultSegment,
                                defaultOffset,
                                this.elementSize,
                                nestingLimit)
  }

  def fromPointerReader(segment: SegmentReader,
                        pointer: Int,
                        nestingLimit: Int): Reader = {
    fromPointerReaderRefDefault(segment, pointer, null, 0, nestingLimit)
  }

  def fromPointerBuilderRefDefault(segment: SegmentBuilder,
                                   pointer: Int,
                                   defaultSegment: SegmentReader,
                                   defaultOffset: Int): Builder = {
    WireHelpers.getWritableListPointer(this,
                                       pointer,
                                       segment,
                                       this.elementSize,
                                       defaultSegment,
                                       defaultOffset)
  }

  def fromPointerBuilder(segment: SegmentBuilder, pointer: Int): Builder = {
    WireHelpers.getWritableListPointer(this,
                                       pointer,
                                       segment,
                                       this.elementSize,
                                       null,
                                       0)
  }

  def initFromPointerBuilder(segment: SegmentBuilder,
                             pointer: Int,
                             elementCount: Int): Builder = {
    WireHelpers
      .initListPointer(this, pointer, segment, elementCount, this.elementSize)
  }

  def setPointerBuilder(segment: SegmentBuilder, pointer: Int, value: Reader) {
    WireHelpers.setListPointer(segment, pointer, value.asInstanceOf[ListReader])
  }
}
