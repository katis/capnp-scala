package org.capnproto

class ListList[ElementBuilder, ElementReader <: ListReader](factory: List[ElementBuilder, ElementReader])
  extends List[List[ElementBuilder, ElementReader]#Builder, List[ElementBuilder, ElementReader]#Reader](ElementSize.POINTER.toByte) {

  type ListT = List[ElementBuilder, ElementReader]
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

    override def apply(idx: Int): ListT#Reader = _getPointerElement(factory, idx)
  }

  class BuilderImpl(segment: SegmentBuilder,
                   ptr: Int,
                   elementCount: Int,
                   step: Int,
                   structDataSize: Int,
                   structPointerCount: Short) extends BuilderBase(segment, ptr, elementCount, step, structDataSize, structPointerCount) {

    def init(index: Int, size: Int): ListT#Builder = {
      _initPointerElement(factory, index, size)
    }

    def apply(idx: Int): ListT#Builder = _getPointerElement(factory, idx)
  }
}


