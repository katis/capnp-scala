package org.murtsi.capnproto.runtime

class EnumList[T <: Enumeration#Value](val values: Array[T])
    extends List[T, T](ElementSize.TWO_BYTES.toByte) {
  type Builder = BuilderImpl
  type Reader = ReaderImpl

  def Reader(segment: SegmentReader,
             ptr: Int,
             elementCount: Int,
             step: Int,
             structDataSize: Int,
             structPointerCount: Short,
             nestingLimit: Int): Reader = {
    new ReaderImpl(values,
                  segment,
                  ptr,
                  elementCount,
                  step,
                  structDataSize,
                  structPointerCount,
                  nestingLimit)
  }

  def Builder(segment: SegmentBuilder,
                       ptr: Int,
                       elementCount: Int,
                       step: Int,
                       structDataSize: Int,
                       structPointerCount: Short): Builder = {
    new BuilderImpl(values,
                   segment,
                   ptr,
                   elementCount,
                   step,
                   structDataSize,
                   structPointerCount)
  }

  def clampOrdinal[A](values: Array[A], ordinal: Short): A = {
    var index = ordinal
    if (ordinal < 0 || ordinal >= values.length) {
      index = (values.length - 1).toShort
    }
    values(index)
  }

  class ReaderImpl(val values: Array[T],
                   segment: SegmentReader,
                   ptr: Int,
                   elementCount: Int,
                   step: Int,
                   structDataSize: Int,
                   structPointerCount: Short,
                   nestingLimit: Int)
      extends ReaderBase(segment,
                         ptr,
                         elementCount,
                         step,
                         structDataSize,
                         structPointerCount,
                         nestingLimit) {

    def apply(idx: Int): T =  clampOrdinal(this.values, _getShortElement(idx))
  }

  class BuilderImpl(val values: Array[T],
                    segment: SegmentBuilder,
                    ptr: Int,
                    elementCount: Int,
                    step: Int,
                    structDataSize: Int,
                    structPointerCount: Short)
      extends BuilderBase(segment,
                          ptr,
                          elementCount,
                          step,
                          structDataSize,
                          structPointerCount) {

    def update(index: Int, value: T) {
      _setShortElement(index, value.id.toShort)
    }

    override def apply(idx: Int): T = clampOrdinal(this.values, _getShortElement(idx))
  }
}
