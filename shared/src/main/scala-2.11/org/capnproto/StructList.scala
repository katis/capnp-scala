package org.capnproto

object StructList {
  class Factory[ElementBuilder <: StructBuilder, ElementReader <: StructReader](factory: StructFactory[ElementBuilder, ElementReader])
    extends ListFactory[Builder[ElementBuilder], Reader[ElementReader]](ElementSize.INLINE_COMPOSITE) {

    def constructReader(segment: SegmentReader,
        ptr: Int,
        elementCount: Int,
        step: Int,
        structDataSize: Int,
        structPointerCount: Short,
        nestingLimit: Int): Reader[ElementReader] = {
      new Reader[ElementReader](factory, segment, ptr, elementCount, step, structDataSize, structPointerCount,
        nestingLimit)
    }

    def constructBuilder(segment: SegmentBuilder,
        ptr: Int,
        elementCount: Int,
        step: Int,
        structDataSize: Int,
        structPointerCount: Short): Builder[ElementBuilder] = {
      new Builder[ElementBuilder](factory, segment, ptr, elementCount, step, structDataSize, structPointerCount)
    }

    override def fromPointerBuilderRefDefault(segment: SegmentBuilder,
          pointer: Int,
          defaultSegment: SegmentReader,
          defaultOffset: Int): Builder[ElementBuilder] = {
        WireHelpers.getWritableStructListPointer(this, pointer, segment, factory.structSize, defaultSegment,
        defaultOffset)
    }

    override def fromPointerBuilder(segment: SegmentBuilder, pointer: Int): Builder[ElementBuilder] = {
      WireHelpers.getWritableStructListPointer(this, pointer, segment, factory.structSize, null, 0)
    }

    override def initFromPointerBuilder(segment: SegmentBuilder, pointer: Int, elementCount: Int): Builder[ElementBuilder] = {
      WireHelpers.initStructListPointer(this, pointer, segment, elementCount, factory.structSize)
    }
  }

  class Reader[T](val factory: StructReader.Factory[T], 
      segment: SegmentReader, 
      ptr: Int, 
      elementCount: Int, 
      step: Int, 
      structDataSize: Int, 
      structPointerCount: Short, 
      nestingLimit: Int) extends ListReader(segment, ptr, elementCount, step, structDataSize, structPointerCount, 
    nestingLimit) with java.lang.Iterable[T] {

    def get(index: Int): T = _getStructElement(factory, index)

    class Iterator(var list: Reader[T]) extends java.util.Iterator[T] {

      var idx: Int = 0

      def next(): T = {
        list._getStructElement(factory, {idx += 1; idx - 1})
      }

      def hasNext(): Boolean = idx < list.size

      def remove() {
        throw new UnsupportedOperationException()
      }
    }

    def iterator(): java.util.Iterator[T] = new Iterator(this)
  }

  class Builder[T](val factory: StructBuilder.Factory[T], 
      segment: SegmentBuilder, 
      ptr: Int, 
      elementCount: Int, 
      step: Int, 
      structDataSize: Int, 
      structPointerCount: Short) extends ListBuilder(segment, ptr, elementCount, step, structDataSize, 
    structPointerCount) with java.lang.Iterable[T] {

    def get(index: Int): T = _getStructElement(factory, index)

    class Iterator(var list: Builder[T]) extends java.util.Iterator[T] {

      var idx: Int = 0

      def next(): T = {
        list._getStructElement(factory, {idx += 1; idx - 1})
      }

      def hasNext(): Boolean = idx < list.size

      def remove() {
        throw new UnsupportedOperationException()
      }
    }

    def iterator(): java.util.Iterator[T] = new Iterator(this)
  }
}



