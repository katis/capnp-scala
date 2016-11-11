package org.murtsi.capnproto.runtime

import implicits._

object DataList extends DataList
sealed class DataList private() extends List[Data#Builder, Data#Reader](ElementSize.POINTER.toByte) {
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
    nestingLimit) {

    def apply(idx: Int): Data.Reader = _getPointerElement[Data](idx)

    def get(idx: Int): DataReader = _getPointerElement[Data](idx)
  }

  class BuilderImpl(segment: SegmentBuilder,
      ptr: Int, 
      elementCount: Int, 
      step: Int, 
      structDataSize: Int, 
      structPointerCount: Short) extends BuilderBase(segment, ptr, elementCount, step, structDataSize,
    structPointerCount) {

    def apply(idx: Int): Data.Builder = _getPointerElement[Data](idx)

    def get(idx: Int): Data.Builder = _getPointerElement[Data](idx)

    def update(index: Int, value: Data.Reader) {
      _setPointerElement[Data](index, value)
    }
  }
}
