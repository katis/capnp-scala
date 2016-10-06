package org.capnproto

import ListList._

object ListList {
  class Reader[T](private val factory: FromPointerReader[T],
                  segment: SegmentReader,
                  ptr: Int,
                  elementCount: Int,
                  step: Int,
                  structDataSize: Int,
                  structPointerCount: Short,
                  nestingLimit: Int) extends ListReader(segment, ptr, elementCount, step, structDataSize, structPointerCount,
    nestingLimit) {

    def get(index: Int): T = _getPointerElement(this.factory, index)
  }

  class Builder[T](private val factory: ListFactory[T, _],
                   segment: SegmentBuilder,
                   ptr: Int,
                   elementCount: Int,
                   step: Int,
                   structDataSize: Int,
                   structPointerCount: Short) extends ListBuilder(segment, ptr, elementCount, step, structDataSize,
    structPointerCount) {

    def init(index: Int, size: Int): T = {
      _initPointerElement(this.factory, index, size)
    }

    def get(index: Int): T = _getPointerElement(this.factory, index)
  }

}

class ListList[ElementBuilder, ElementReader <: ListReader](factory: ListFactory[ElementBuilder, ElementReader])
  extends ListFactory[Builder[ElementBuilder], Reader[ElementReader]](ElementSize.POINTER.toByte) {

  def constructReader(segment: SegmentReader,
                      ptr: Int,
                      elementCount: Int,
                      step: Int,
                      structDataSize: Int,
                      structPointerCount: Short,
                      nestingLimit: Int): Reader[ElementReader] = {
    new Reader[ElementReader](factory, segment, ptr, elementCount, step, structDataSize, structPointerCount,
      nestingLimit)
  }

  def constructBuilder(segment: SegmentBuilder,
                       ptr: Int,
                       elementCount: Int,
                       step: Int,
                       structDataSize: Int,
                       structPointerCount: Short): Builder[ElementBuilder] = {
    new Builder[ElementBuilder](factory, segment, ptr, elementCount, step, structDataSize, structPointerCount)
  }
}

