package org.murtsi.capnproto.runtime

abstract class Enum(val index: Short)

trait EnumModule[T <: Enum] {
  def apply(value: Short): Option[T]
  def enumValues: Seq[T]

  object List extends org.murtsi.capnproto.runtime.List[T, T](ElementSize.TWO_BYTES.toByte) {
    override type Builder = List.BuilderImpl
    override type Reader = List.ReaderImpl

    private def clampOrdinal[A](values: Seq[A], ordinal: Short): A = {
      var index = ordinal
      if (ordinal < 0 || ordinal >= values.size) {
        index = (values.size - 1).toShort
      }
      values(index)
    }

    override def Builder(segment: SegmentBuilder, ptr: Int, elementCount: Int, step: Int, structDataSize: Int, structPointerCount: Short): Builder =
      new BuilderImpl(segment, ptr, elementCount, step, structDataSize, structPointerCount)

    override def Reader(segment: SegmentReader, ptr: Int, elementCount: Int, step: Int, structDataSize: Int, structPointerCount: Short, nestingLimit: Int): Reader =
      new ReaderImpl(segment, ptr, elementCount, step, structDataSize, structPointerCount, nestingLimit)

    class ReaderImpl(segment: SegmentReader,
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

      reader =>

      def apply(idx: Int): T = clampOrdinal(enumValues, _getShortElement(idx))
    }

    class BuilderImpl(segment: SegmentBuilder,
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

      builder =>

      def update(index: Int, value: T) {
        _setShortElement(index, value.index)
      }

      override def apply(idx: Int): T = clampOrdinal(enumValues, _getShortElement(idx))
    }
  }
}
