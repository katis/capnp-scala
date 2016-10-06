package org.capnproto

import EnumList._

object EnumList {
  class Factory[T <: java.lang.Enum[_]](val values: Array[T]) extends ListFactory[Builder[T], Reader[T]](ElementSize.TWO_BYTES.toByte) {

    def constructReader(segment: SegmentReader,
        ptr: Int,
        elementCount: Int,
        step: Int,
        structDataSize: Int,
        structPointerCount: Short,
        nestingLimit: Int): Reader[T] = {
      new Reader[T](values, segment, ptr, elementCount, step, structDataSize, structPointerCount, nestingLimit)
    }

    def constructBuilder(segment: SegmentBuilder,
        ptr: Int,
        elementCount: Int,
        step: Int,
        structDataSize: Int,
        structPointerCount: Short): Builder[T] = {
      new Builder[T](values, segment, ptr, elementCount, step, structDataSize, structPointerCount)
    }
  }

  def clampOrdinal[T](values: Array[T], ordinal: Short): T = {
    var index = ordinal
    if (ordinal < 0 || ordinal >= values.length) {
      index = (values.length - 1).toShort
    }
    values(index)
  }


  class Reader[T <: java.lang.Enum[_]](val values: Array[T], 
      segment: SegmentReader, 
      ptr: Int, 
      elementCount: Int, 
      step: Int, 
      structDataSize: Int, 
      structPointerCount: Short, 
      nestingLimit: Int) extends ListReader(segment, ptr, elementCount, step, structDataSize, structPointerCount, 
    nestingLimit) {

    def get(index: Int): T = {
      clampOrdinal(this.values, _getShortElement(index))
    }
  }

  class Builder[T <: java.lang.Enum[_]](val values: Array[T], 
      segment: SegmentBuilder, 
      ptr: Int, 
      elementCount: Int, 
      step: Int, 
      structDataSize: Int, 
      structPointerCount: Short) extends ListBuilder(segment, ptr, elementCount, step, structDataSize, 
    structPointerCount) {

    def get(index: Int): T = {
      clampOrdinal(this.values, _getShortElement(index))
    }

    def set(index: Int, value: T) {
      _setShortElement(index, value.ordinal().toShort)
    }
  }
}

