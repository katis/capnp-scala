package org.capnproto.runtime

object PrimitiveList {
  object Void extends List[Void, Void](ElementSize.VOID.toByte) {
    type Reader = ReaderImpl
    type Builder = BuilderImpl

    def Reader(segment: SegmentReader,
               ptr: Int,
               elementCount: Int,
               step: Int,
               structDataSize: Int,
               structPointerCount: Short,
               nestingLimit: Int): Reader = {
      new ReaderImpl(segment,
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
      new BuilderImpl(segment,
                      ptr,
                      elementCount,
                      step,
                      structDataSize,
                      structPointerCount)
    }

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

      def apply(idx: Int): org.capnproto.runtime.Void = org.capnproto.runtime.Void
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
      override def apply(idx: Int): org.capnproto.runtime.Void = org.capnproto.runtime.Void
    }
  }

  object Boolean extends List[Boolean, Boolean](ElementSize.BIT.toByte) {
    type Reader = ReaderImpl
    type Builder = BuilderImpl

    def Reader(segment: SegmentReader,
               ptr: Int,
               elementCount: Int,
               step: Int,
               structDataSize: Int,
               structPointerCount: Short,
               nestingLimit: Int): Reader = {
      new ReaderImpl(segment,
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
      new BuilderImpl(segment,
                      ptr,
                      elementCount,
                      step,
                      structDataSize,
                      structPointerCount)
    }

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

      def apply(idx: Int): Boolean = _getBooleanElement(idx)
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

      def apply(idx: Int): Boolean = _getBooleanElement(idx)

      def set(idx: Int, value: Boolean) {
        _setBooleanElement(idx, value)
      }
    }

  }

  object Byte extends List[Byte, Byte](ElementSize.BYTE.toByte) {
    type Builder = BuilderImpl
    type Reader = ReaderImpl

    def Reader(segment: SegmentReader,
               ptr: Int,
               elementCount: Int,
               step: Int,
               structDataSize: Int,
               structPointerCount: Short,
               nestingLimit: Int): Reader = {
      new ReaderImpl(segment,
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
      new BuilderImpl(segment,
                      ptr,
                      elementCount,
                      step,
                      structDataSize,
                      structPointerCount)
    }

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

      def apply(idx: Int): Byte = _getByteElement(idx)
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

      def apply(idx: Int): Byte = _getByteElement(idx)

      def set(idx: Int, value: Byte) {
        _setByteElement(idx, value)
      }
    }

  }

  object Short extends List[Short, Short](ElementSize.TWO_BYTES.toByte) {
    type Builder = BuilderImpl
    type Reader = ReaderImpl

    def Reader(segment: SegmentReader,
               ptr: Int,
               elementCount: Int,
               step: Int,
               structDataSize: Int,
               structPointerCount: Short,
               nestingLimit: Int): Reader = {
      new ReaderImpl(segment,
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
      new BuilderImpl(segment,
                      ptr,
                      elementCount,
                      step,
                      structDataSize,
                      structPointerCount)
    }

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

      def apply(idx: Int): Short = _getShortElement(idx)
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

      def apply(idx: Int): Short = _getShortElement(idx)

      def set(idx: Int, value: Short) {
        _setShortElement(idx, value)
      }
    }

  }

  object Int extends List[Int, Int](ElementSize.FOUR_BYTES.toByte) {
    type Builder = BuilderImpl
    type Reader = ReaderImpl

    def Reader(segment: SegmentReader,
               ptr: Int,
               elementCount: Int,
               step: Int,
               structDataSize: Int,
               structPointerCount: Short,
               nestingLimit: Int): Reader = {
      new ReaderImpl(segment,
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
      new BuilderImpl(segment,
                      ptr,
                      elementCount,
                      step,
                      structDataSize,
                      structPointerCount)
    }

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

      def apply(idx: Int): Int = _getIntElement(idx)
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

      def apply(idx: Int): Int = _getIntElement(idx)

      def set(idx: Int, value: Int) {
        _setIntElement(idx, value)
      }
    }

  }

  object Float extends List[Float, Float](ElementSize.FOUR_BYTES.toByte) {
    type Builder = BuilderImpl
    type Reader = ReaderImpl

    def Reader(segment: SegmentReader,
               ptr: Int,
               elementCount: Int,
               step: Int,
               structDataSize: Int,
               structPointerCount: Short,
               nestingLimit: Int): Reader = {
      new ReaderImpl(segment,
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
      new BuilderImpl(segment,
                      ptr,
                      elementCount,
                      step,
                      structDataSize,
                      structPointerCount)
    }

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

      def apply(idx: Int): Float = _getFloatElement(idx)
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

      def apply(idx: Int): Float = _getFloatElement(idx)

      def set(idx: Int, value: Float) {
        _setFloatElement(idx, value)
      }
    }

  }

  object Long extends List[Long, Long](ElementSize.EIGHT_BYTES.toByte) {
    type Builder = BuilderImpl
    type Reader = ReaderImpl

    def Reader(segment: SegmentReader,
               ptr: Int,
               elementCount: Int,
               step: Int,
               structDataSize: Int,
               structPointerCount: Short,
               nestingLimit: Int): Reader = {
      new ReaderImpl(segment,
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
      new BuilderImpl(segment,
                      ptr,
                      elementCount,
                      step,
                      structDataSize,
                      structPointerCount)
    }

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

      def apply(idx: Int): Long = _getLongElement(idx)
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

      def apply(idx: Int): Long = _getLongElement(idx)

      def set(idx: Int, value: Long) {
        _setLongElement(idx, value)
      }
    }
  }

  object Double extends List[Double, Double](ElementSize.EIGHT_BYTES.toByte) {
    type Builder = BuilderImpl
    type Reader = ReaderImpl

    def Reader(segment: SegmentReader,
               ptr: Int,
               elementCount: Int,
               step: Int,
               structDataSize: Int,
               structPointerCount: Short,
               nestingLimit: Int): Reader = {
      new ReaderImpl(segment,
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
      new BuilderImpl(segment,
                      ptr,
                      elementCount,
                      step,
                      structDataSize,
                      structPointerCount)
    }

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

      def apply(idx: Int): Double = _getDoubleElement(idx)
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

      def apply(idx: Int): Double = _getDoubleElement(idx)

      def set(idx: Int, value: Double) {
        _setDoubleElement(idx, value)
      }
    }
  }
}
