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

    class BuilderImpl(_segment: SegmentBuilder,
                      _ptr: Int,
                      _elementCount: Int,
                      _step: Int,
                      _structDataSize: Int,
                      _structPointerCount: Short)
        extends BuilderBase(_segment, _ptr, _elementCount, _step, _structDataSize, _structPointerCount)
          with Iterable[struct.Builder] {

      builder =>

      def apply(idx: Int): struct.Builder = _getStructElement(struct, idx)

      override def iterator: Iterator[struct.Builder] = new Iterator[struct.Builder] {
        private var idx: Int = 0

        def next(): struct.Builder = {
          val i = idx
          idx += 1
          _getStructElement(struct, i)
        }

        def hasNext(): Boolean = idx < builder.size

        def remove() {
          throw new UnsupportedOperationException()
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
        extends ReaderBase(_segment, _ptr, _elementCount, _step, _structDataSize, _structPointerCount, _nestingLimit)
        with Iterable[struct.Reader] {

      reader =>

      def apply(idx: Int): struct.Reader = _getStructElement(struct, idx)

      override def iterator: Iterator[struct.Reader] = new Iterator[struct.Reader] {
        private var idx: Int = 0

        def next(): struct.Reader = {
          val i = idx
          idx += 1
          _getStructElement(struct, i)
        }

        def hasNext(): Boolean = idx < reader.size

        def remove() {
          throw new UnsupportedOperationException()
        }
      }
    }
  }

  abstract class BuilderBase(_segment: SegmentBuilder,
                             _data: Int,
                             _pointers: Int,
                             _dataSize: Int,
                             _pointerCount: Short) extends StructBuilder(_segment, _data, _pointers, _dataSize, _pointerCount) {
    def asReader: Reader = Reader(_segment, _data, _pointers, _dataSize, _pointerCount, 0x7fffffff)
  }

  abstract class ReaderBase(_segment: SegmentReader,
                            _data: Int,
                            _pointers: Int,
                            _dataSize: Int,
                            _pointerCount: Short,
                            _nestingLimit: Int) extends StructReader(_segment, _data, _pointers, _dataSize, _pointerCount, _nestingLimit) {

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

