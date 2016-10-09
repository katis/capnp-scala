package org.capnproto.runtime

trait Struct
  extends PointerFactoryTF
    with FromPointerBuilderRefDefaultTF
    with StructBuilder.FactoryTF
    with SetPointerBuilderTF
    with FromPointerReaderRefDefaultTF
    with StructReader.FactoryTF {

  struct =>

  type Builder <: BuilderBase
  type Reader <: ReaderBase

  object List extends List[struct.Builder, struct.Reader](ElementSize.INLINE_COMPOSITE) {
    override type Builder = BuilderImpl
    override type Reader = ReaderImpl

    override def Builder(segment: SegmentBuilder, ptr: Int, elementCount: Int, step: Int, structDataSize: Int, structPointerCount: Short): Builder =
      new BuilderImpl(segment, ptr, elementCount, step, structDataSize, structPointerCount)

    override def setPointerBuilder(segment: SegmentBuilder, pointer: Int, value: Reader): Unit = ???

    override def Reader(segment: SegmentReader, ptr: Int, elementCount: Int, step: Int, structDataSize: Int, structPointerCount: Short, nestingLimit: Int): Reader =
      new ReaderImpl(segment, ptr, elementCount, step, structDataSize, structPointerCount, nestingLimit)

    class BuilderImpl(segment: SegmentBuilder,
                      ptr: Int,
                      elementCount: Int,
                      step: Int,
                      structDataSize: Int,
                      structPointerCount: Short) extends BuilderBase(segment, ptr, elementCount, step, structDataSize, structPointerCount) {

      def apply(idx: Int): struct.Builder = _getStructElement(struct, idx)

      def iterator(): Iterator[struct.Builder] = new Iterator[struct.Builder] {
        private var idx: Int = 0

        def next(): struct.Builder = _getStructElement(struct, {idx += 1; idx - 1})

        def hasNext(): Boolean = idx < size

        def remove() {
          throw new UnsupportedOperationException()
        }
      }
    }

    class ReaderImpl(segment: SegmentReader,
                  ptr: Int,
                  elementCount: Int,
                  step: Int,
                  structDataSize: Int,
                  structPointerCount: Short,
                  nestingLimit: Int) extends ReaderBase(segment, ptr, elementCount, step, structDataSize, structPointerCount, nestingLimit) {

      def apply(idx: Int): struct.Reader = _getStructElement(struct, idx)

      def iterator(): Iterator[struct.Reader] = new Iterator[struct.Reader] {
        private var idx: Int = 0

        def next(): struct.Reader = _getStructElement(struct, {idx += 1; idx - 1})

        def hasNext(): Boolean = idx < size

        def remove() {
          throw new UnsupportedOperationException()
        }
      }
    }
  }

  abstract class BuilderBase(segment: SegmentBuilder,
                             data: Int,
                             pointers: Int,
                             dataSize: Int,
                             pointerCount: Short) extends StructBuilder(segment, data, pointers, dataSize, pointerCount) {

    def asReader: Reader = Reader(segment, data, pointers, dataSize, pointerCount, 0x7fffffff)
  }

  abstract class ReaderBase(segment: SegmentReader,
                            data: Int,
                            pointers: Int,
                            dataSize: Int,
                            pointerCount: Short,
                            nestingLimit: Int) extends StructReader(segment, data, pointers, dataSize, pointerCount, nestingLimit) {

  }

  override def fromPointerReaderRefDefault(segment: SegmentReader,
                                  pointer: Int,
                                  defaultSegment: SegmentReader,
                                  defaultOffset: Int,
                                  nestingLimit: Int): Reader = {
    WireHelpers.readStructPointerTF(this, segment, pointer, defaultSegment, defaultOffset, nestingLimit)
  }


  def fromPointerReader(segment: SegmentReader, pointer: Int, nestingLimit: Int): Reader = {
    fromPointerReaderRefDefault(segment, pointer, null, 0, nestingLimit)
  }

  def fromPointerBuilderRefDefault(segment: SegmentBuilder,
                                   pointer: Int,
                                   defaultSegment: SegmentReader,
                                   defaultOffset: Int): Builder = {
    WireHelpers.getWritableStructPointer(this, pointer, segment, this.structSize, defaultSegment, defaultOffset)
  }

  def fromPointerBuilder(segment: SegmentBuilder, pointer: Int): Builder = {
    WireHelpers.getWritableStructPointer(this, pointer, segment, this.structSize, null, 0)
  }

  def initFromPointerBuilder(segment: SegmentBuilder, pointer: Int, elementCount: Int): Builder = {
    WireHelpers.initStructPointer(this, pointer, segment, this.structSize)
  }

  def setPointerBuilder(segment: SegmentBuilder, pointer: Int, value: Reader) {
    WireHelpers.setStructPointer(segment, pointer, value.asInstanceOf[StructReader])
  }

  def asReader(builder: BuilderBase): Reader = builder.asReader
}


/*
trait StructFactory[Builder, Reader <: StructReader]
  extends PointerFactory[Builder, Reader]
    with FromPointerBuilderRefDefault[Builder]
    with StructBuilder.Factory[Builder]
    with SetPointerBuilder[Builder, Reader]
    with FromPointerReaderRefDefault[Reader]
    with StructReader.Factory[Reader] {

  def fromPointerReaderRefDefault(segment: SegmentReader,
                                  pointer: Int,
                                  defaultSegment: SegmentReader,
                                  defaultOffset: Int,
                                  nestingLimit: Int): Reader = {
    WireHelpers.readStructPointer(this, segment, pointer, defaultSegment, defaultOffset, nestingLimit)
  }

  def fromPointerReader(segment: SegmentReader, pointer: Int, nestingLimit: Int): Reader = {
    fromPointerReaderRefDefault(segment, pointer, null, 0, nestingLimit)
  }

  def fromPointerBuilderRefDefault(segment: SegmentBuilder,
                                   pointer: Int,
                                   defaultSegment: SegmentReader,
                                   defaultOffset: Int): Builder = {
    WireHelpers.getWritableStructPointer(this, pointer, segment, this.structSize, defaultSegment, defaultOffset)
  }

  def fromPointerBuilder(segment: SegmentBuilder, pointer: Int): Builder = {
    WireHelpers.getWritableStructPointer(this, pointer, segment, this.structSize, null, 0)
  }

  def initFromPointerBuilder(segment: SegmentBuilder, pointer: Int, elementCount: Int): Builder = {
    WireHelpers.initStructPointer(this, pointer, segment, this.structSize)
  }

  def setPointerBuilder(segment: SegmentBuilder, pointer: Int, value: Reader) {
    WireHelpers.setStructPointer(segment, pointer, value)
  }

  def asReader(builder: Builder): Reader
}
*/
