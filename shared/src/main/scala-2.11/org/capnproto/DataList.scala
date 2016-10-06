package org.capnproto

object DataList {

  class Factory() extends ListFactory[Builder, Reader](ElementSize.POINTER.toByte) {

    def constructReader(segment: SegmentReader, 
        ptr: Int, 
        elementCount: Int, 
        step: Int, 
        structDataSize: Int, 
        structPointerCount: Short, 
        nestingLimit: Int): Reader = {
      new Reader(segment, ptr, elementCount, step, structDataSize, structPointerCount, nestingLimit)
    }

    def constructBuilder(segment: SegmentBuilder, 
        ptr: Int, 
        elementCount: Int, 
        step: Int, 
        structDataSize: Int, 
        structPointerCount: Short): Builder = {
      new Builder(segment, ptr, elementCount, step, structDataSize, structPointerCount)
    }
  }

  val factory = new Factory()

  class Reader(segment: SegmentReader, 
      ptr: Int, 
      elementCount: Int, 
      step: Int, 
      structDataSize: Int, 
      structPointerCount: Short, 
      nestingLimit: Int) extends ListReader(segment, ptr, elementCount, step, structDataSize, structPointerCount, 
    nestingLimit) with java.lang.Iterable[Data.Reader] {

    def get(index: Int): Data.Reader = _getPointerElement(Data.factory, index)

    class Iterator(var list: Reader) extends java.util.Iterator[Data.Reader] {

      var idx: Int = 0

      def next(): Data.Reader = {
        this.list._getPointerElement(Data.factory, {idx += 1; idx - 1})
      }

      def hasNext(): Boolean = idx < list.size

      def remove() {
        throw new UnsupportedOperationException()
      }
    }

    def iterator(): java.util.Iterator[Data.Reader] = new Iterator(this)
  }

  class Builder(segment: SegmentBuilder, 
      ptr: Int, 
      elementCount: Int, 
      step: Int, 
      structDataSize: Int, 
      structPointerCount: Short) extends ListBuilder(segment, ptr, elementCount, step, structDataSize, 
    structPointerCount) with java.lang.Iterable[Data.Builder] {

    def get(index: Int): Data.Builder = _getPointerElement(Data.factory, index)

    def set(index: Int, value: Data.Reader) {
      _setPointerElement(Data.factory, index, value)
    }

    class Iterator(var list: Builder) extends java.util.Iterator[Data.Builder] {

      var idx: Int = 0

      def next(): Data.Builder = {
        this.list._getPointerElement(Data.factory, {idx += 1; idx - 1})
      }

      def hasNext(): Boolean = this.idx < this.list.size

      def remove() {
        throw new UnsupportedOperationException()
      }
    }

    def iterator(): java.util.Iterator[Data.Builder] = new Iterator(this)
  }
}
