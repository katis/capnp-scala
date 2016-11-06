package org.murtsi.capnproto.runtime

trait HasElementSize[T] {
  def elementSize: Byte
}

trait ListFromSegment[T <: PointerFamily] extends ListReader.Factory[T#Reader] with ListBuilder.Factory[T#Builder]

abstract class List[ElementBuilder, ElementReader](val elementSize: Byte) extends PointerFamily {

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
                          structPointerCount) with Traversable[ElementBuilder] {

    builder =>

    override def size: Int = super[ListBuilder].size()

    def apply(idx: Int): ElementBuilder

    override def foreach[U](f: (ElementBuilder) => U): Unit = {
      for (i <- 0 until size) {
        f(apply(i))
      }
    }
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
                         nestingLimit) with Traversable[ElementReader] {

    def apply(idx: Int): ElementReader

    override def size: Int = super[ListReader].size

    override def foreach[U](f: (ElementReader) => U): Unit = {
      for (i <- 0 until size) {
        f(apply(i))
      }
    }
  }

  /*
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
  */
}

