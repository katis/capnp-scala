package org.katis.capnproto.runtime

import org.katis.capnproto.runtime

object PrimitiveList {
  object Void extends Void
  class Void private() extends List[runtime.Void, runtime.Void](ElementSize.VOID.toByte) {
    type Reader = ReaderImpl
    type Builder = BuilderImpl

    def Reader(segment: SegmentReader,
               ptr: scala.Int,
               elementCount: scala.Int,
               step: scala.Int,
               structDataSize: scala.Int,
               structPointerCount: scala.Short,
               nestingLimit: scala.Int): Reader = {
      new ReaderImpl(segment,
                     ptr,
                     elementCount,
                     step,
                     structDataSize,
                     structPointerCount,
                     nestingLimit)
    }

    def Builder(segment: SegmentBuilder,
                ptr: scala.Int,
                elementCount: scala.Int,
                step: scala.Int,
                structDataSize: scala.Int,
                structPointerCount: scala.Short): Builder = {
      new BuilderImpl(segment,
                      ptr,
                      elementCount,
                      step,
                      structDataSize,
                      structPointerCount)
    }

    class ReaderImpl(segment: SegmentReader,
                     ptr: scala.Int,
                     elementCount: scala.Int,
                     step: scala.Int,
                     structDataSize: scala.Int,
                     structPointerCount: scala.Short,
                     nestingLimit: scala.Int)
        extends ReaderBase(segment,
                           ptr,
                           elementCount,
                           step,
                           structDataSize,
                           structPointerCount,
                           nestingLimit) {

      def apply(idx: scala.Int): runtime.Void = runtime.Void

      def get(idx: scala.Int): runtime.Void = runtime.Void
    }

    class BuilderImpl(segment: SegmentBuilder,
                      ptr: scala.Int,
                      elementCount: scala.Int,
                      step: scala.Int,
                      structDataSize: scala.Int,
                      structPointerCount: scala.Short)
        extends BuilderBase(segment,
                            ptr,
                            elementCount,
                            step,
                            structDataSize,
                            structPointerCount) {
      override def apply(idx: scala.Int): runtime.Void = runtime.Void

      def get(idx: scala.Int): runtime.Void = runtime.Void

      def update(idx: scala.Int, elem: runtime.Void): Unit = ()
    }
  }

  object Boolean extends Boolean
  class Boolean private() extends List[scala.Boolean, scala.Boolean](ElementSize.BIT.toByte) {
    type Reader = ReaderImpl
    type Builder = BuilderImpl

    def Reader(segment: SegmentReader,
               ptr: scala.Int,
               elementCount: scala.Int,
               step: scala.Int,
               structDataSize: scala.Int,
               structPointerCount: scala.Short,
               nestingLimit: scala.Int): Reader = {
      new ReaderImpl(segment,
                     ptr,
                     elementCount,
                     step,
                     structDataSize,
                     structPointerCount,
                     nestingLimit)
    }

    def Builder(segment: SegmentBuilder,
                ptr: scala.Int,
                elementCount: scala.Int,
                step: scala.Int,
                structDataSize: scala.Int,
                structPointerCount: scala.Short): Builder = {
      new BuilderImpl(segment,
                      ptr,
                      elementCount,
                      step,
                      structDataSize,
                      structPointerCount)
    }

    class ReaderImpl(segment: SegmentReader,
                     ptr: scala.Int,
                     elementCount: scala.Int,
                     step: scala.Int,
                     structDataSize: scala.Int,
                     structPointerCount: scala.Short,
                     nestingLimit: scala.Int)
        extends ReaderBase(segment,
                           ptr,
                           elementCount,
                           step,
                           structDataSize,
                           structPointerCount,
                           nestingLimit) {

      def apply(idx: scala.Int): scala.Boolean = get(idx)

      def get(idx: scala.Int): scala.Boolean = _getBooleanElement(idx)
    }

    class BuilderImpl(segment: SegmentBuilder,
                      ptr: scala.Int,
                      elementCount: scala.Int,
                      step: scala.Int,
                      structDataSize: scala.Int,
                      structPointerCount: scala.Short)
        extends BuilderBase(segment,
                            ptr,
                            elementCount,
                            step,
                            structDataSize,
                            structPointerCount) {

      def apply(idx: scala.Int): scala.Boolean = get(idx)

      def get(idx: scala.Int): scala.Boolean = _getBooleanElement(idx)

      def update(idx: scala.Int, value: scala.Boolean) {
        _setBooleanElement(idx, value)
      }
    }
  }

  object Byte extends Byte
  class Byte private() extends List[scala.Byte, scala.Byte](ElementSize.BYTE.toByte) {
    type Builder = BuilderImpl
    type Reader = ReaderImpl

    def Reader(segment: SegmentReader,
               ptr: scala.Int,
               elementCount: scala.Int,
               step: scala.Int,
               structDataSize: scala.Int,
               structPointerCount: scala.Short,
               nestingLimit: scala.Int): Reader = {
      new ReaderImpl(segment,
                     ptr,
                     elementCount,
                     step,
                     structDataSize,
                     structPointerCount,
                     nestingLimit)
    }

    def Builder(segment: SegmentBuilder,
                ptr: scala.Int,
                elementCount: scala.Int,
                step: scala.Int,
                structDataSize: scala.Int,
                structPointerCount: scala.Short): Builder = {
      new BuilderImpl(segment,
                      ptr,
                      elementCount,
                      step,
                      structDataSize,
                      structPointerCount)
    }

    class ReaderImpl(segment: SegmentReader,
                     ptr: scala.Int,
                     elementCount: scala.Int,
                     step: scala.Int,
                     structDataSize: scala.Int,
                     structPointerCount: scala.Short,
                     nestingLimit: scala.Int)
        extends ReaderBase(segment,
                           ptr,
                           elementCount,
                           step,
                           structDataSize,
                           structPointerCount,
                           nestingLimit) {

      def apply(idx: scala.Int): scala.Byte = get(idx)

      def get(idx: scala.Int): scala.Byte = _getByteElement(idx)
    }

    class BuilderImpl(segment: SegmentBuilder,
                      ptr: scala.Int,
                      elementCount: scala.Int,
                      step: scala.Int,
                      structDataSize: scala.Int,
                      structPointerCount: scala.Short)
        extends BuilderBase(segment,
                            ptr,
                            elementCount,
                            step,
                            structDataSize,
                            structPointerCount) {

      def apply(idx: scala.Int): scala.Byte = get(idx)

      def get(idx: scala.Int): scala.Byte = _getByteElement(idx)

      def update(idx: scala.Int, value: scala.Byte) {
        _setByteElement(idx, value)
      }
    }
  }

  object Short extends Short
  class Short private() extends List[scala.Short, scala.Short](ElementSize.TWO_BYTES.toByte) {
    type Builder = BuilderImpl
    type Reader = ReaderImpl

    def Reader(segment: SegmentReader,
               ptr: scala.Int,
               elementCount: scala.Int,
               step: scala.Int,
               structDataSize: scala.Int,
               structPointerCount: scala.Short,
               nestingLimit: scala.Int): Reader = {
      new ReaderImpl(segment,
                     ptr,
                     elementCount,
                     step,
                     structDataSize,
                     structPointerCount,
                     nestingLimit)
    }

    def Builder(segment: SegmentBuilder,
                ptr: scala.Int,
                elementCount: scala.Int,
                step: scala.Int,
                structDataSize: scala.Int,
                structPointerCount: scala.Short): Builder = {
      new BuilderImpl(segment,
                      ptr,
                      elementCount,
                      step,
                      structDataSize,
                      structPointerCount)
    }

    class ReaderImpl(segment: SegmentReader,
                     ptr: scala.Int,
                     elementCount: scala.Int,
                     step: scala.Int,
                     structDataSize: scala.Int,
                     structPointerCount: scala.Short,
                     nestingLimit: scala.Int)
        extends ReaderBase(segment,
                           ptr,
                           elementCount,
                           step,
                           structDataSize,
                           structPointerCount,
                           nestingLimit) {

      def apply(idx: scala.Int): scala.Short = get(idx)

      def get(idx: scala.Int): scala.Short = _getShortElement(idx)
    }

    class BuilderImpl(segment: SegmentBuilder,
                      ptr: scala.Int,
                      elementCount: scala.Int,
                      step: scala.Int,
                      structDataSize: scala.Int,
                      structPointerCount: scala.Short)
        extends BuilderBase(segment,
                            ptr,
                            elementCount,
                            step,
                            structDataSize,
                            structPointerCount) {

      def apply(idx: scala.Int): scala.Short = get(idx)

      def get(idx: scala.Int): scala.Short = _getShortElement(idx)

      def update(idx: scala.Int, value: scala.Short) {
        _setShortElement(idx, value)
      }
    }
  }

  object Int extends Int
  class Int private() extends List[scala.Int, scala.Int](ElementSize.FOUR_BYTES.toByte) {
    type Builder = BuilderImpl
    type Reader = ReaderImpl

    def Reader(segment: SegmentReader,
               ptr: scala.Int,
               elementCount: scala.Int,
               step: scala.Int,
               structDataSize: scala.Int,
               structPointerCount: scala.Short,
               nestingLimit: scala.Int): Reader = {
      new ReaderImpl(segment,
                     ptr,
                     elementCount,
                     step,
                     structDataSize,
                     structPointerCount,
                     nestingLimit)
    }

    def Builder(segment: SegmentBuilder,
                ptr: scala.Int,
                elementCount: scala.Int,
                step: scala.Int,
                structDataSize: scala.Int,
                structPointerCount: scala.Short): Builder = {
      new BuilderImpl(segment,
                      ptr,
                      elementCount,
                      step,
                      structDataSize,
                      structPointerCount)
    }

    class ReaderImpl(segment: SegmentReader,
                     ptr: scala.Int,
                     elementCount: scala.Int,
                     step: scala.Int,
                     structDataSize: scala.Int,
                     structPointerCount: scala.Short,
                     nestingLimit: scala.Int)
        extends ReaderBase(segment,
                           ptr,
                           elementCount,
                           step,
                           structDataSize,
                           structPointerCount,
                           nestingLimit) {

      def apply(idx: scala.Int): scala.Int = get(idx)

      def get(idx: scala.Int): scala.Int = _getIntElement(idx)
    }

    class BuilderImpl(segment: SegmentBuilder,
                      ptr: scala.Int,
                      elementCount: scala.Int,
                      step: scala.Int,
                      structDataSize: scala.Int,
                      structPointerCount: scala.Short)
        extends BuilderBase(segment,
                            ptr,
                            elementCount,
                            step,
                            structDataSize,
                            structPointerCount) {

      def apply(idx: scala.Int): scala.Int = get(idx)

      def get(idx: scala.Int): scala.Int = _getIntElement(idx)

      def update(idx: scala.Int, value: scala.Int) {
        _setIntElement(idx, value)
      }
    }
  }

  object Long extends Long
  class Long private() extends List[scala.Long, scala.Long](ElementSize.EIGHT_BYTES.toByte) {
    type Builder = BuilderImpl
    type Reader = ReaderImpl

    def Reader(segment: SegmentReader,
               ptr: scala.Int,
               elementCount: scala.Int,
               step: scala.Int,
               structDataSize: scala.Int,
               structPointerCount: scala.Short,
               nestingLimit: scala.Int): Reader = {
      new ReaderImpl(segment,
                     ptr,
                     elementCount,
                     step,
                     structDataSize,
                     structPointerCount,
                     nestingLimit)
    }

    def Builder(segment: SegmentBuilder,
                ptr: scala.Int,
                elementCount: scala.Int,
                step: scala.Int,
                structDataSize: scala.Int,
                structPointerCount: scala.Short): Builder = {
      new BuilderImpl(segment,
                      ptr,
                      elementCount,
                      step,
                      structDataSize,
                      structPointerCount)
    }

    class ReaderImpl(segment: SegmentReader,
                     ptr: scala.Int,
                     elementCount: scala.Int,
                     step: scala.Int,
                     structDataSize: scala.Int,
                     structPointerCount: scala.Short,
                     nestingLimit: scala.Int)
        extends ReaderBase(segment,
                           ptr,
                           elementCount,
                           step,
                           structDataSize,
                           structPointerCount,
                           nestingLimit) {

      def apply(idx: scala.Int): scala.Long = get(idx)

      def get(idx: scala.Int): scala.Long = _getLongElement(idx)
    }

    class BuilderImpl(segment: SegmentBuilder,
                      ptr: scala.Int,
                      elementCount: scala.Int,
                      step: scala.Int,
                      structDataSize: scala.Int,
                      structPointerCount: scala.Short)
        extends BuilderBase(segment,
                            ptr,
                            elementCount,
                            step,
                            structDataSize,
                            structPointerCount) {

      def apply(idx: scala.Int): scala.Long = get(idx)

      def get(idx: scala.Int): scala.Long = _getLongElement(idx)

      def update(idx: scala.Int, value: scala.Long) {
        _setLongElement(idx, value)
      }
    }
  }

  object Float extends Float
  class Float private() extends List[scala.Float, scala.Float](ElementSize.FOUR_BYTES.toByte) {
    type Builder = BuilderImpl
    type Reader = ReaderImpl

    def Reader(segment: SegmentReader,
               ptr: scala.Int,
               elementCount: scala.Int,
               step: scala.Int,
               structDataSize: scala.Int,
               structPointerCount: scala.Short,
               nestingLimit: scala.Int): Reader = {
      new ReaderImpl(segment,
                     ptr,
                     elementCount,
                     step,
                     structDataSize,
                     structPointerCount,
                     nestingLimit)
    }

    def Builder(segment: SegmentBuilder,
                ptr: scala.Int,
                elementCount: scala.Int,
                step: scala.Int,
                structDataSize: scala.Int,
                structPointerCount: scala.Short): Builder = {
      new BuilderImpl(segment,
                      ptr,
                      elementCount,
                      step,
                      structDataSize,
                      structPointerCount)
    }

    class ReaderImpl(segment: SegmentReader,
                     ptr: scala.Int,
                     elementCount: scala.Int,
                     step: scala.Int,
                     structDataSize: scala.Int,
                     structPointerCount: scala.Short,
                     nestingLimit: scala.Int)
        extends ReaderBase(segment,
                           ptr,
                           elementCount,
                           step,
                           structDataSize,
                           structPointerCount,
                           nestingLimit) {

      def apply(idx: scala.Int): scala.Float = get(idx)

      def get(idx: scala.Int): scala.Float = _getFloatElement(idx)
    }

    class BuilderImpl(segment: SegmentBuilder,
                      ptr: scala.Int,
                      elementCount: scala.Int,
                      step: scala.Int,
                      structDataSize: scala.Int,
                      structPointerCount: scala.Short)
        extends BuilderBase(segment,
                            ptr,
                            elementCount,
                            step,
                            structDataSize,
                            structPointerCount) {

      def apply(idx: scala.Int): scala.Float = get(idx)

      def get(idx: scala.Int): scala.Float = _getFloatElement(idx)

      def update(idx: scala.Int, value: scala.Float) {
        _setFloatElement(idx, value)
      }
    }
  }

  object Double extends Double
  class Double private() extends List[scala.Double, scala.Double](ElementSize.EIGHT_BYTES.toByte) {
    type Builder = BuilderImpl
    type Reader = ReaderImpl

    def Reader(segment: SegmentReader,
               ptr: scala.Int,
               elementCount: scala.Int,
               step: scala.Int,
               structDataSize: scala.Int,
               structPointerCount: scala.Short,
               nestingLimit: scala.Int): Reader = {
      new ReaderImpl(segment,
                     ptr,
                     elementCount,
                     step,
                     structDataSize,
                     structPointerCount,
                     nestingLimit)
    }

    def Builder(segment: SegmentBuilder,
                ptr: scala.Int,
                elementCount: scala.Int,
                step: scala.Int,
                structDataSize: scala.Int,
                structPointerCount: scala.Short): Builder = {
      new BuilderImpl(segment,
                      ptr,
                      elementCount,
                      step,
                      structDataSize,
                      structPointerCount)
    }

    class ReaderImpl(segment: SegmentReader,
                     ptr: scala.Int,
                     elementCount: scala.Int,
                     step: scala.Int,
                     structDataSize: scala.Int,
                     structPointerCount: scala.Short,
                     nestingLimit: scala.Int)
        extends ReaderBase(segment,
                           ptr,
                           elementCount,
                           step,
                           structDataSize,
                           structPointerCount,
                           nestingLimit) {

      def apply(idx: scala.Int): scala.Double = get(idx)

      def get(idx: scala.Int): scala.Double = _getDoubleElement(idx)
    }

    class BuilderImpl(segment: SegmentBuilder,
                      ptr: scala.Int,
                      elementCount: scala.Int,
                      step: scala.Int,
                      structDataSize: scala.Int,
                      structPointerCount: scala.Short)
        extends BuilderBase(segment,
                            ptr,
                            elementCount,
                            step,
                            structDataSize,
                            structPointerCount) {

      def apply(idx: scala.Int): scala.Double = get(idx)

      def get(idx: scala.Int): scala.Double = _getDoubleElement(idx)

      def update(idx: scala.Int, value: scala.Double) {
        _setDoubleElement(idx, value)
      }
    }
  }
}
