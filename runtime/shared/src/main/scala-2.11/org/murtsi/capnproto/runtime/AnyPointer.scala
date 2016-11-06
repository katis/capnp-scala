package org.murtsi.capnproto.runtime

object AnyPointer extends AnyPointer
sealed class AnyPointer private() extends PointerFamily {
  type Builder = BuilderImpl
  type Reader = ReaderImpl

  class ReaderImpl(val segment: SegmentReader, val pointer: Int, val nestingLimit: Int) {
    def isNull: Boolean = {
      WirePointer.isNull(this.segment.buffer.getLong(this.pointer * Constants.BYTES_PER_WORD))
    }

    def getAs[T <: PointerFamily : FromPointer]: T#Reader = {
      val factory = implicitly[FromPointer[T]]
      factory.fromPointerReader(this.segment, this.pointer, this.nestingLimit)
    }
  }

  class BuilderImpl(val segment: SegmentBuilder, val pointer: Int) {

    def isNull: Boolean = {
      WirePointer.isNull(this.segment.buffer.getLong(this.pointer * Constants.BYTES_PER_WORD))
    }

    def getAs[T <: PointerFamily : FromPointer]: T#Builder = {
      val factory = implicitly[FromPointer[T]]
      factory.fromPointerBuilder(this.segment, this.pointer)
    }

    def initAs[T <: PointerFamily : FromPointer]: T#Builder = {
      val factory = implicitly[FromPointer[T]]
      factory.initFromPointerBuilder(this.segment, this.pointer, 0)
    }

    def initAs[T <: PointerFamily : FromPointer](elementCount: Int): T#Builder = {
      val factory = implicitly[FromPointer[T]]
      factory.initFromPointerBuilder(this.segment, this.pointer, elementCount)
    }

    def setAs[T <: PointerFamily : SetPointerBuilder](reader: T#Reader) {
      implicitly[SetPointerBuilder[T]].setPointerBuilder(this.segment, this.pointer, reader)
    }

    def asReader(): Reader = {
      new Reader(segment, pointer, 0x7fffffff)
    }

    def clear() {
      WireHelpers.zeroObject(this.segment, this.pointer)
      this.segment.buffer.putLong(this.pointer * 8, 0L)
    }
  }
}

