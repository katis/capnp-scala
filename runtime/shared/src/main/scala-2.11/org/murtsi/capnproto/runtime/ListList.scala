package org.murtsi.capnproto.runtime

object ListList {
  def apply[L <: PointerFamily : ListFromSegment : FromPointer]: ListList[L] = new ListList[L]
}

class ListList[L <: PointerFamily : ListFromSegment : FromPointer]
  extends List[L#Builder, L#Reader](ElementSize.POINTER) {
  type Builder = BuilderImpl
  type Reader = ReaderImpl

  def Reader(segment: SegmentReader,
             ptr: Int,
             elementCount: Int,
             step: Int,
             structDataSize: Int,
             structPointerCount: Short,
             nestingLimit: Int): Reader = {
    new ReaderImpl(segment, ptr, elementCount, step, structDataSize, structPointerCount, nestingLimit)
  }

  def Builder(segment: SegmentBuilder,
                       ptr: Int,
                       elementCount: Int,
                       step: Int,
                       structDataSize: Int,
                       structPointerCount: Short): Builder = {
    new BuilderImpl(segment, ptr, elementCount, step, structDataSize, structPointerCount)
  }

  class ReaderImpl(segment: SegmentReader,
                  ptr: Int,
                  elementCount: Int,
                  step: Int,
                  structDataSize: Int,
                  structPointerCount: Short,
                  nestingLimit: Int) extends ReaderBase(segment, ptr, elementCount, step, structDataSize, structPointerCount, nestingLimit) {

    override def apply(idx: Int): L#Reader = _getPointerElement[L](idx)
  }

  class BuilderImpl(segment: SegmentBuilder,
                   ptr: Int,
                   elementCount: Int,
                   step: Int,
                   structDataSize: Int,
                   structPointerCount: Short) extends BuilderBase(segment, ptr, elementCount, step, structDataSize, structPointerCount) {

    def init(index: Int, size: Int): L#Builder = {
      _initPointerElement[L](index, size)
    }

    def apply(idx: Int): L#Builder = _getPointerElement[L](idx)
  }
}
