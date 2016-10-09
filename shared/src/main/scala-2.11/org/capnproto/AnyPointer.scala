package org.capnproto

object AnyPointer extends PointerFactoryTF {
  type Builder = BuilderImpl
  type Reader = ReaderImpl

  def fromPointerReader(segment: SegmentReader, pointer: Int, nestingLimit: Int): Reader = {
    new Reader(segment, pointer, nestingLimit)
  }

  def fromPointerBuilder(segment: SegmentBuilder, pointer: Int): Builder = new Builder(segment, pointer)

  def initFromPointerBuilder(segment: SegmentBuilder, pointer: Int, elementCount: Int): Builder = {
    val result = new Builder(segment, pointer)
    result.clear()
    result
  }

  class ReaderImpl(val segment: SegmentReader, val pointer: Int, val nestingLimit: Int) {

    def isNull(): Boolean = {
      WirePointer.isNull(this.segment.buffer.getLong(this.pointer * Constants.BYTES_PER_WORD))
    }

    def getAs(factory: FromPointerReaderTF): factory.Reader = {
      factory.fromPointerReader(this.segment, this.pointer, this.nestingLimit)
    }
  }

  class BuilderImpl(val segment: SegmentBuilder, val pointer: Int) {

    def isNull(): Boolean = {
      WirePointer.isNull(this.segment.buffer.getLong(this.pointer * Constants.BYTES_PER_WORD))
    }

    def getAs(factory: FromPointerBuilderTF): factory.Builder = {
      factory.fromPointerBuilder(this.segment, this.pointer)
    }

    def initAs(factory: FromPointerBuilderTF): factory.Builder = {
      factory.initFromPointerBuilder(this.segment, this.pointer, 0)
    }

    def initAs(factory: FromPointerBuilderTF, elementCount: Int): factory.Builder = {
      factory.initFromPointerBuilder(this.segment, this.pointer, elementCount)
    }

    def setAs(factory: SetPointerBuilderTF)(reader: factory.Reader) {
      factory.setPointerBuilder(this.segment, this.pointer, reader)
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
