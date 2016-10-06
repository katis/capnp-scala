package org.capnproto

abstract class ListFactory[Builder, Reader <: ListReader](val elementSize: Byte)
    extends ListBuilder.Factory[Builder] with FromPointerBuilderRefDefault[Builder] with SetPointerBuilder[Builder, Reader] with ListReader.Factory[Reader] with PointerFactory[Builder, Reader] with FromPointerReaderRefDefault[Reader] {

  val factory = this

  def fromPointerReaderRefDefault(segment: SegmentReader, 
      pointer: Int, 
      defaultSegment: SegmentReader, 
      defaultOffset: Int, 
      nestingLimit: Int): Reader = {
    WireHelpers.readListPointer(this, segment, pointer, defaultSegment, defaultOffset, this.elementSize, 
      nestingLimit)
  }

  def fromPointerReader(segment: SegmentReader, pointer: Int, nestingLimit: Int): Reader = {
    fromPointerReaderRefDefault(segment, pointer, null, 0, nestingLimit)
  }

  def fromPointerBuilderRefDefault(segment: SegmentBuilder, 
      pointer: Int, 
      defaultSegment: SegmentReader, 
      defaultOffset: Int): Builder = {
    WireHelpers.getWritableListPointer(this, pointer, segment, this.elementSize, defaultSegment, defaultOffset)
  }

  def fromPointerBuilder(segment: SegmentBuilder, pointer: Int): Builder = {
    WireHelpers.getWritableListPointer(this, pointer, segment, this.elementSize, null, 0)
  }

  def initFromPointerBuilder(segment: SegmentBuilder, pointer: Int, elementCount: Int): Builder = {
    WireHelpers.initListPointer(this, pointer, segment, elementCount, this.elementSize)
  }

  def setPointerBuilder(segment: SegmentBuilder, pointer: Int, value: Reader) {
    WireHelpers.setListPointer(segment, pointer, value)
  }
}
