package org.capnproto

object TextList {

  object factory extends ListFactory[TextList.Builder, TextList.Reader](ElementSize.POINTER.toByte) {

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

  class Reader(segment: SegmentReader,
               ptr: Int,
               elementCount: Int,
               step: Int,
               structDataSize: Int,
               structPointerCount: Short,
               nestingLimit: Int) extends ListReader(segment, ptr, elementCount, step, structDataSize, structPointerCount,
    nestingLimit) with java.lang.Iterable[Text.Reader] {

    def get(index: Int): Text.Reader = _getPointerElement(Text.factory, index)

    class Iterator(var list: Reader) extends java.util.Iterator[Text.Reader] {

      var idx: Int = 0

      def next(): Text.Reader = {
        this.list._getPointerElement(Text.factory, {
          idx += 1;
          idx - 1
        })
      }

      def hasNext(): Boolean = idx < list.size

      def remove() {
        throw new UnsupportedOperationException()
      }
    }

    def iterator(): java.util.Iterator[Text.Reader] = new Iterator(this)
  }

  class Builder(segment: SegmentBuilder,
                ptr: Int,
                elementCount: Int,
                step: Int,
                structDataSize: Int,
                structPointerCount: Short) extends ListBuilder(segment, ptr, elementCount, step, structDataSize,
    structPointerCount) with java.lang.Iterable[Text.Builder] {

    def get(index: Int): Text.Builder = _getPointerElement(Text.factory, index)

    def set(index: Int, value: Text.Reader) {
      _setPointerElement(Text.factory, index, value)
    }

    class Iterator(var list: Builder) extends java.util.Iterator[Text.Builder] {

      var idx: Int = 0

      def next(): Text.Builder = {
        this.list._getPointerElement(Text.factory, {
          idx += 1
          idx - 1
        })
      }

      def hasNext(): Boolean = this.idx < this.list.size

      def remove() {
        throw new UnsupportedOperationException()
      }
    }

    def iterator(): java.util.Iterator[Text.Builder] = new Iterator(this)
  }

}
