package org.murtsi.capnproto.runtime

object TextList extends List[Text.Builder, Text.Reader](ElementSize.POINTER) {
  type Builder = BuilderImpl
  type Reader = ReaderImpl

  class ReaderImpl(segment: SegmentReader,
               ptr: Int,
               elementCount: Int,
               step: Int,
               structDataSize: Int,
               structPointerCount: Short,
               nestingLimit: Int) extends ReaderBase(segment, ptr, elementCount, step, structDataSize, structPointerCount,
    nestingLimit) {

    def apply(idx: Int): Text.Reader = _getPointerElement(Text, idx)

    override def iterator: Iterator[Text.Reader] = new Iterator[Text.Reader] {
      var idx: Int = 0

      def next(): Text.Reader = {
        _getPointerElement(Text, {
          idx += 1
          idx - 1
        })
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
    structPointerCount) with Iterable[Text.Builder] {

    override def iterator: Iterator[Text.Builder] = new Iterator[Text.Builder] {
      var idx: Int = 0

      def next(): Text.Builder = {
        _getPointerElement(Text, {
          idx += 1
          idx - 1
        })
      }

      def hasNext: Boolean = this.idx < size

      def remove() {
        throw new UnsupportedOperationException()
      }
    }

    override def apply(idx: Int): Text.Builder = _getPointerElement(Text, idx)

    def update(idx: Int, element: Text.Reader): Unit = _setPointerElement(Text)(idx, element)
  }

  override def Builder(segment: SegmentBuilder, ptr: Int, elementCount: Int, step: Int, structDataSize: Int, structPointerCount: Short): BuilderImpl =
    new BuilderImpl(segment, ptr, elementCount, step, structDataSize, structPointerCount)

  override def Reader(segment: SegmentReader, ptr: Int, elementCount: Int, step: Int, structDataSize: Int, structPointerCount: Short, nestingLimit: Int): ReaderImpl =
    new ReaderImpl(segment, ptr, elementCount, step, structDataSize, structPointerCount, nestingLimit)
}
