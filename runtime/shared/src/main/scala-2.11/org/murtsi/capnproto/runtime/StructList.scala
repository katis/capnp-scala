package org.murtsi.capnproto.runtime

object StructList {
  def apply[S <: Struct : StructFromSegment : HasStructSize : SetPointerBuilder]: StructList[S] = new StructList[S]
}

class StructList[S <: Struct : StructFromSegment : HasStructSize : SetPointerBuilder] extends org.murtsi.capnproto.runtime.List[S#Builder, S#Reader](ElementSize.INLINE_COMPOSITE) {
  override type Builder = BuilderImpl
  override type Reader = ReaderImpl

  class BuilderImpl(_segment: SegmentBuilder,
                    _ptr: Int,
                    _elementCount: Int,
                    _step: Int,
                    _structDataSize: Int,
                    _structPointerCount: Short)
      extends BuilderBase(_segment, _ptr, _elementCount, _step, _structDataSize, _structPointerCount) {

    builder =>

    def apply(idx: Int): S#Builder = _getStructElement[S](idx)

    def update(idx: Int, value: S#Reader): Unit = _setPointerElement[S](idx, value)

    override def foreach[U](fn: (S#Builder) => U): Unit = {
      for (i <- 0 until builder.size) {
        val el = _getStructElement[S](i)
        fn(el)
      }
    }
  }

  class ReaderImpl(_segment: SegmentReader,
                   _ptr: Int,
                   _elementCount: Int,
                   _step: Int,
                   _structDataSize: Int,
                   _structPointerCount: Short,
                   _nestingLimit: Int)
      extends ReaderBase(_segment, _ptr, _elementCount, _step, _structDataSize, _structPointerCount, _nestingLimit) {

    reader =>

    def apply(idx: Int): S#Reader = _getStructElement[S](idx)

    override def foreach[U](fn: (S#Reader) => U): Unit = {
      for (i <- 0 until reader.size) {
        val el = _getStructElement[S](i)
        fn(el)
      }
    }
  }
}
