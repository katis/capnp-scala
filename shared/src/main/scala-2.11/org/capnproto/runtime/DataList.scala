package org.capnproto.runtime

object DataList extends List[Data.Builder, Data.Reader](ElementSize.POINTER.toByte) {
  type Builder = BuilderImpl
  type Reader = ReaderImpl

    def Reader(segment: SegmentReader,
               ptr: Int,
               elementCount: Int,
               step: Int,
               structDataSize: Int,
               structPointerCount: Short,
               nestingLimit: Int): Reader = {
      new Reader(segment, ptr, elementCount, step, structDataSize, structPointerCount, nestingLimit)
    }

    def Builder(segment: SegmentBuilder,
        ptr: Int, 
        elementCount: Int, 
        step: Int, 
        structDataSize: Int, 
        structPointerCount: Short): Builder = {
      new Builder(segment, ptr, elementCount, step, structDataSize, structPointerCount)
    }

  class ReaderImpl(segment: SegmentReader,
      ptr: Int, 
      elementCount: Int, 
      step: Int, 
      structDataSize: Int, 
      structPointerCount: Short, 
      nestingLimit: Int) extends ReaderBase(segment, ptr, elementCount, step, structDataSize, structPointerCount,
    nestingLimit) with Iterable[Data.Reader] {

    override def size: Int = super[ReaderBase].size()

    def apply(idx: Int): Data.Reader = _getPointerElement(Data, idx)

    def iterator(): Iterator[Data.Reader] = new Iterator[Data.Reader] {
      var idx: Int = 0

      def next(): Data.Reader = {
        _getPointerElement(Data, {idx += 1; idx - 1})
      }

      def hasNext: Boolean = idx < size

      def remove() {
        throw new UnsupportedOperationException()
      }
    }
  }

  class BuilderImpl(segment: SegmentBuilder,
      ptr: Int, 
      elementCount: Int, 
      step: Int, 
      structDataSize: Int, 
      structPointerCount: Short) extends BuilderBase(segment, ptr, elementCount, step, structDataSize,
    structPointerCount) with Iterable[Data.Builder] {

    override def size: Int = super[BuilderBase].size()

    def apply(idx: Int): Data.Builder = _getPointerElement(Data, idx)

    def set(index: Int, value: Data.Reader) {
      _setPointerElement(Data)(index, value)
    }

    def iterator(): Iterator[Data.Builder] = new Iterator[Data.Builder] {
      var idx: Int = 0

      def next(): Data.Builder = {
        _getPointerElement(Data, {
          idx += 1; idx - 1
        })
      }

      def hasNext(): Boolean = this.idx < size

      def remove() {
        throw new UnsupportedOperationException()
      }
    }
  }
}
