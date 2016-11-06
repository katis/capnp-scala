package org.murtsi.capnproto.runtime

import implicits._

object TextList extends List[Text#Builder, Text#Reader](ElementSize.POINTER) {
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

    def apply(idx: Int): Text#Reader = _getPointerElement[Text](idx)
  }

  class BuilderImpl(segment: SegmentBuilder,
                ptr: Int,
                elementCount: Int,
                step: Int,
                structDataSize: Int,
                structPointerCount: Short) extends BuilderBase(segment, ptr, elementCount, step, structDataSize,
    structPointerCount) {
    override def apply(idx: Int): Text#Builder = _getPointerElement[Text](idx)

    def update(idx: Int, element: Text.Reader): Unit = _setPointerElement[Text](idx, element)
  }
}
