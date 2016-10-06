package org.capnproto

object PrimitiveList {

  object Void {

    object factory extends ListFactory[Void.Builder, Void.Reader](ElementSize.VOID.toByte) {
      def constructReader(segment: SegmentReader,
                          ptr: Int,
                          elementCount: Int,
                          step: Int,
                          structDataSize: Int,
                          structPointerCount: Short,
                          nestingLimit: Int): Reader = {
        new Reader(segment, ptr, elementCount, step, structDataSize, structPointerCount, nestingLimit)
      }

      def constructBuilder(segment: SegmentBuilder,
                           ptr: Int,
                           elementCount: Int,
                           step: Int,
                           structDataSize: Int,
                           structPointerCount: Short): Builder = {
        new Builder(segment, ptr, elementCount, step, structDataSize, structPointerCount)
      }
    }

    class Reader(segment: SegmentReader,
                 ptr: Int,
                 elementCount: Int,
                 step: Int,
                 structDataSize: Int,
                 structPointerCount: Short,
                 nestingLimit: Int) extends ListReader(segment, ptr, elementCount, step, structDataSize, structPointerCount,
      nestingLimit) {

      def get(index: Int): org.capnproto.Void.type = org.capnproto.Void.VOID
    }

    class Builder(segment: SegmentBuilder,
                  ptr: Int,
                  elementCount: Int,
                  step: Int,
                  structDataSize: Int,
                  structPointerCount: Short) extends ListBuilder(segment, ptr, elementCount, step, structDataSize,
      structPointerCount)

  }

  object Boolean {

    object factory extends ListFactory[Boolean.Builder, Boolean.Reader](ElementSize.BIT.toByte) {
      def constructReader(segment: SegmentReader,
                          ptr: Int,
                          elementCount: Int,
                          step: Int,
                          structDataSize: Int,
                          structPointerCount: Short,
                          nestingLimit: Int): Reader = {
        new Reader(segment, ptr, elementCount, step, structDataSize, structPointerCount, nestingLimit)
      }

      def constructBuilder(segment: SegmentBuilder,
                           ptr: Int,
                           elementCount: Int,
                           step: Int,
                           structDataSize: Int,
                           structPointerCount: Short): Builder = {
        new Builder(segment, ptr, elementCount, step, structDataSize, structPointerCount)
      }
    }

    class Reader(segment: SegmentReader,
                 ptr: Int,
                 elementCount: Int,
                 step: Int,
                 structDataSize: Int,
                 structPointerCount: Short,
                 nestingLimit: Int) extends ListReader(segment, ptr, elementCount, step, structDataSize, structPointerCount,
      nestingLimit) {

      def get(index: Int): Boolean = _getBooleanElement(index)
    }

    class Builder(segment: SegmentBuilder,
                  ptr: Int,
                  elementCount: Int,
                  step: Int,
                  structDataSize: Int,
                  structPointerCount: Short) extends ListBuilder(segment, ptr, elementCount, step, structDataSize,
      structPointerCount) {

      def get(index: Int): Boolean = _getBooleanElement(index)

      def set(index: Int, value: Boolean) {
        _setBooleanElement(index, value)
      }
    }

  }

  object Byte {

    object factory extends ListFactory[Byte.Builder, Byte.Reader](ElementSize.BYTE.toByte) {
      def constructReader(segment: SegmentReader,
                          ptr: Int,
                          elementCount: Int,
                          step: Int,
                          structDataSize: Int,
                          structPointerCount: Short,
                          nestingLimit: Int): Reader = {
        new Reader(segment, ptr, elementCount, step, structDataSize, structPointerCount, nestingLimit)
      }

      def constructBuilder(segment: SegmentBuilder,
                           ptr: Int,
                           elementCount: Int,
                           step: Int,
                           structDataSize: Int,
                           structPointerCount: Short): Builder = {
        new Builder(segment, ptr, elementCount, step, structDataSize, structPointerCount)
      }
    }

    class Reader(segment: SegmentReader,
                 ptr: Int,
                 elementCount: Int,
                 step: Int,
                 structDataSize: Int,
                 structPointerCount: Short,
                 nestingLimit: Int) extends ListReader(segment, ptr, elementCount, step, structDataSize, structPointerCount,
      nestingLimit) {

      def get(index: Int): Byte = _getByteElement(index)
    }

    class Builder(segment: SegmentBuilder,
                  ptr: Int,
                  elementCount: Int,
                  step: Int,
                  structDataSize: Int,
                  structPointerCount: Short) extends ListBuilder(segment, ptr, elementCount, step, structDataSize,
      structPointerCount) {

      def get(index: Int): Byte = _getByteElement(index)

      def set(index: Int, value: Byte) {
        _setByteElement(index, value)
      }
    }

  }

  object Short {

    object factory extends ListFactory[Short.Builder, Short.Reader](ElementSize.TWO_BYTES.toByte) {
      def constructReader(segment: SegmentReader,
                          ptr: Int,
                          elementCount: Int,
                          step: Int,
                          structDataSize: Int,
                          structPointerCount: Short,
                          nestingLimit: Int): Reader = {
        new Reader(segment, ptr, elementCount, step, structDataSize, structPointerCount, nestingLimit)
      }

      def constructBuilder(segment: SegmentBuilder,
                           ptr: Int,
                           elementCount: Int,
                           step: Int,
                           structDataSize: Int,
                           structPointerCount: Short): Builder = {
        new Builder(segment, ptr, elementCount, step, structDataSize, structPointerCount)
      }
    }

    class Reader(segment: SegmentReader,
                 ptr: Int,
                 elementCount: Int,
                 step: Int,
                 structDataSize: Int,
                 structPointerCount: Short,
                 nestingLimit: Int) extends ListReader(segment, ptr, elementCount, step, structDataSize, structPointerCount,
      nestingLimit) {

      def get(index: Int): Short = _getShortElement(index)
    }

    class Builder(segment: SegmentBuilder,
                  ptr: Int,
                  elementCount: Int,
                  step: Int,
                  structDataSize: Int,
                  structPointerCount: Short) extends ListBuilder(segment, ptr, elementCount, step, structDataSize,
      structPointerCount) {

      def get(index: Int): Short = _getShortElement(index)

      def set(index: Int, value: Short) {
        _setShortElement(index, value)
      }
    }

  }

  object Int {

    object factory extends ListFactory[Int.Builder, Int.Reader](ElementSize.FOUR_BYTES.toByte) {
      def constructReader(segment: SegmentReader,
                          ptr: Int,
                          elementCount: Int,
                          step: Int,
                          structDataSize: Int,
                          structPointerCount: Short,
                          nestingLimit: Int): Reader = {
        new Reader(segment, ptr, elementCount, step, structDataSize, structPointerCount, nestingLimit)
      }

      def constructBuilder(segment: SegmentBuilder,
                           ptr: Int,
                           elementCount: Int,
                           step: Int,
                           structDataSize: Int,
                           structPointerCount: Short): Builder = {
        new Builder(segment, ptr, elementCount, step, structDataSize, structPointerCount)
      }
    }

    class Reader(segment: SegmentReader,
                 ptr: Int,
                 elementCount: Int,
                 step: Int,
                 structDataSize: Int,
                 structPointerCount: Short,
                 nestingLimit: Int) extends ListReader(segment, ptr, elementCount, step, structDataSize, structPointerCount,
      nestingLimit) {

      def get(index: Int): Int = _getIntElement(index)
    }

    class Builder(segment: SegmentBuilder,
                  ptr: Int,
                  elementCount: Int,
                  step: Int,
                  structDataSize: Int,
                  structPointerCount: Short) extends ListBuilder(segment, ptr, elementCount, step, structDataSize,
      structPointerCount) {

      def get(index: Int): Int = _getIntElement(index)

      def set(index: Int, value: Int) {
        _setIntElement(index, value)
      }
    }

  }

  object Float {

    object factory extends ListFactory[Float.Builder, Float.Reader](ElementSize.FOUR_BYTES.toByte) {
      def constructReader(segment: SegmentReader,
                          ptr: Int,
                          elementCount: Int,
                          step: Int,
                          structDataSize: Int,
                          structPointerCount: Short,
                          nestingLimit: Int): Reader = {
        new Reader(segment, ptr, elementCount, step, structDataSize, structPointerCount, nestingLimit)
      }

      def constructBuilder(segment: SegmentBuilder,
                           ptr: Int,
                           elementCount: Int,
                           step: Int,
                           structDataSize: Int,
                           structPointerCount: Short): Builder = {
        new Builder(segment, ptr, elementCount, step, structDataSize, structPointerCount)
      }
    }

    class Reader(segment: SegmentReader,
                 ptr: Int,
                 elementCount: Int,
                 step: Int,
                 structDataSize: Int,
                 structPointerCount: Short,
                 nestingLimit: Int) extends ListReader(segment, ptr, elementCount, step, structDataSize, structPointerCount,
      nestingLimit) {

      def get(index: Int): Float = _getFloatElement(index)
    }

    class Builder(segment: SegmentBuilder,
                  ptr: Int,
                  elementCount: Int,
                  step: Int,
                  structDataSize: Int,
                  structPointerCount: Short) extends ListBuilder(segment, ptr, elementCount, step, structDataSize,
      structPointerCount) {

      def get(index: Int): Float = _getFloatElement(index)

      def set(index: Int, value: Float) {
        _setFloatElement(index, value)
      }
    }

  }

  object Long {

    object factory extends ListFactory[Long.Builder, Long.Reader](ElementSize.EIGHT_BYTES.toByte) {
      def constructReader(segment: SegmentReader,
                          ptr: Int,
                          elementCount: Int,
                          step: Int,
                          structDataSize: Int,
                          structPointerCount: Short,
                          nestingLimit: Int): Reader = {
        new Reader(segment, ptr, elementCount, step, structDataSize, structPointerCount, nestingLimit)
      }

      def constructBuilder(segment: SegmentBuilder,
                           ptr: Int,
                           elementCount: Int,
                           step: Int,
                           structDataSize: Int,
                           structPointerCount: Short): Builder = {
        new Builder(segment, ptr, elementCount, step, structDataSize, structPointerCount)
      }
    }

    class Reader(segment: SegmentReader,
                 ptr: Int,
                 elementCount: Int,
                 step: Int,
                 structDataSize: Int,
                 structPointerCount: Short,
                 nestingLimit: Int) extends ListReader(segment, ptr, elementCount, step, structDataSize, structPointerCount,
      nestingLimit) {

      def get(index: Int): Long = _getLongElement(index)
    }

    class Builder(segment: SegmentBuilder,
                  ptr: Int,
                  elementCount: Int,
                  step: Int,
                  structDataSize: Int,
                  structPointerCount: Short) extends ListBuilder(segment, ptr, elementCount, step, structDataSize,
      structPointerCount) {

      def get(index: Int): Long = _getLongElement(index)

      def set(index: Int, value: Long) {
        _setLongElement(index, value)
      }
    }

  }

  object Double {

    object factory extends ListFactory[Double.Builder, Double.Reader](ElementSize.EIGHT_BYTES.toByte) {
      def constructReader(segment: SegmentReader,
                          ptr: Int,
                          elementCount: Int,
                          step: Int,
                          structDataSize: Int,
                          structPointerCount: Short,
                          nestingLimit: Int): Reader = {
        new Reader(segment, ptr, elementCount, step, structDataSize, structPointerCount, nestingLimit)
      }

      def constructBuilder(segment: SegmentBuilder,
                           ptr: Int,
                           elementCount: Int,
                           step: Int,
                           structDataSize: Int,
                           structPointerCount: Short): Builder = {
        new Builder(segment, ptr, elementCount, step, structDataSize, structPointerCount)
      }
    }

    class Reader(segment: SegmentReader,
                 ptr: Int,
                 elementCount: Int,
                 step: Int,
                 structDataSize: Int,
                 structPointerCount: Short,
                 nestingLimit: Int) extends ListReader(segment, ptr, elementCount, step, structDataSize, structPointerCount,
      nestingLimit) {

      def get(index: Int): Double = _getDoubleElement(index)
    }

    class Builder(segment: SegmentBuilder,
                  ptr: Int,
                  elementCount: Int,
                  step: Int,
                  structDataSize: Int,
                  structPointerCount: Short) extends ListBuilder(segment, ptr, elementCount, step, structDataSize,
      structPointerCount) {

      def get(index: Int): Double = _getDoubleElement(index)

      def set(index: Int, value: Double) {
        _setDoubleElement(index, value)
      }
    }

  }

}
