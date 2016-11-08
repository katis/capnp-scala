package org.murtsi.capnproto.runtime

import java.nio.ByteBuffer

object implicits {
  implicit class String2Text(val s: String) extends AnyVal {
    def text: Text#Reader = Text.Reader(s)
  }

  // Struct & struct list implicits
  implicit def structFromPointer[S <: Struct : StructFromSegment : HasStructSize] = new FromPointer[S] with FromPointerRefDefault[S] {
    override def fromPointerBuilder(segment: SegmentBuilder, pointer: Int): S#Builder = {
      WireHelpers.getWritableStructPointer[S](pointer, segment, null, 0)
    }

    override def initFromPointerBuilder(segment: SegmentBuilder, pointer: Int, elementCount: Int): S#Builder = {
      WireHelpers.initStructPointer[S](pointer, segment)
    }

    override def fromPointerReader(segment: SegmentReader, pointer: Int, nestingLimit: Int): S#Reader = {
      fromPointerReaderRefDefault(segment, pointer, null, 0, nestingLimit)
    }

    override def fromPointerBuilderRefDefault(segment: SegmentBuilder, pointer: Int, defaultSegment: SegmentReader, defaultOffset: Int): S#Builder = {
      WireHelpers.getWritableStructPointer[S](pointer, segment, defaultSegment, defaultOffset)
    }

    override def fromPointerReaderRefDefault(segment: SegmentReader, pointer: Int, defaultSegment: SegmentReader, defaultOffset: Int, nestingLimit: Int): S#Reader = {
      WireHelpers.readStructPointer[S](segment, pointer, defaultSegment, defaultOffset, nestingLimit)
    }
  }

  implicit def structSetPointerBuilder[S <: Struct : HasStructSize] = new SetPointerBuilder[S] {
    override def setPointerBuilder(segment: SegmentBuilder, pointer: Int, value: S#Reader): Unit = {
      WireHelpers.setStructPointer(segment, pointer, value)
    }
  }

  implicit def structList$$ListFromSegment[S <: Struct : StructFromSegment : HasStructSize] = new ListFromSegment[StructList[S]] {
    override def Builder(segment: SegmentBuilder, ptr: Int, elementCount: Int, step: Int, structDataSize: Int, structPointerCount: Short): StructList[S]#Builder = {
      val sl = StructList[S]
      new sl.BuilderImpl(segment, ptr, elementCount, step, structDataSize, structPointerCount)
    }

    override def Reader(segment: SegmentReader, ptr: Int, elementCount: Int, step: Int, structDataSize: Int, structPointerCount: Short, nestingLimit: Int): StructList[S]#Reader = {
      val sl = StructList[S]
      new sl.Reader(segment, ptr, elementCount, step, structDataSize, structPointerCount, nestingLimit)
    }
  }

  implicit def structListHasElementSize[S <: Struct : StructFromSegment : HasStructSize] = new HasElementSize[StructList[S]] {
    override def elementSize: Byte = ElementSize.INLINE_COMPOSITE
  }

  implicit def structListFromPointer[S <: Struct : StructFromSegment : HasStructSize] = new FromPointer[StructList[S]] with FromPointerRefDefault[StructList[S]] {
    override def fromPointerBuilder(segment: SegmentBuilder, pointer: Int): StructList[S]#Builder = {
      WireHelpers.getWritableStructListPointer[StructList[S]](pointer, segment, implicitly[HasStructSize[S]].structSize, null, 0)
    }

    override def initFromPointerBuilder(segment: SegmentBuilder, pointer: Int, elementCount: Int): StructList[S]#Builder = {
      WireHelpers.initStructListPointer[StructList[S]](pointer, segment, elementCount, implicitly[HasStructSize[S]].structSize)
    }

    override def fromPointerReader(segment: SegmentReader, pointer: Int, nestingLimit: Int): StructList[S]#Reader = {
      fromPointerReaderRefDefault(segment, pointer, null, 0, nestingLimit)
    }

    def fromPointerReaderRefDefault(segment: SegmentReader,
                                    pointer: Int,
                                    defaultSegment: SegmentReader,
                                    defaultOffset: Int,
                                    nestingLimit: Int): StructList[S]#Reader = {
      WireHelpers.readListPointer[StructList[S]](segment,
        pointer,
        defaultSegment,
        defaultOffset,
        implicitly[HasElementSize[StructList[S]]].elementSize,
        nestingLimit)
    }

    def fromPointerBuilderRefDefault(segment: SegmentBuilder,
                                     pointer: Int,
                                     defaultSegment: SegmentReader,
                                     defaultOffset: Int): StructList[S]#Builder = {
      WireHelpers.getWritableListPointer[StructList[S]](
        pointer,
        segment,
        implicitly[HasElementSize[StructList[S]]].elementSize,
        defaultSegment,
        defaultOffset)
    }
  }

  implicit def structListSetPointerBuilder[S <: Struct : HasStructSize] = new SetPointerBuilder[StructList[S]] {
    override def setPointerBuilder(segment: SegmentBuilder, pointer: Int, value: StructList[S]#Reader): Unit = {
      WireHelpers.setListPointer(segment, pointer, value)
    }
  }

  // AnyPointer implicits

  implicit val anyPointerFromPointer = new FromPointer[AnyPointer] {
    override def fromPointerReader(segment: SegmentReader, pointer: Int, nestingLimit: Int): AnyPointer#Reader = {
      new AnyPointer.Reader(segment, pointer, nestingLimit)
    }

    override def fromPointerBuilder(segment: SegmentBuilder, pointer: Int): AnyPointer#Builder = {
      new AnyPointer.Builder(segment, pointer)
    }

    override def initFromPointerBuilder(segment: SegmentBuilder, pointer: Int, elementCount: Int): AnyPointer#Builder = {
      val result = new AnyPointer.Builder(segment, pointer)
      result.clear()
      result
    }
  }

  // Data implicits

  implicit val dataFromPointer = new FromPointer[Data] {
    override def fromPointerReader(segment: SegmentReader, pointer: Int, nestingLimit: Int): Data#Reader = {
      WireHelpers.readDataPointer(segment, pointer, null, 0, 0)
    }

    override def fromPointerBuilder(segment: SegmentBuilder, pointer: Int): Data#Builder = {
      WireHelpers.getWritableDataPointer(pointer, segment, null, 0, 0)
    }

    override def initFromPointerBuilder(segment: SegmentBuilder, pointer: Int, size: Int): Data#Builder = {
      WireHelpers.initDataPointer(pointer, segment, size)
    }
  }

  implicit val dataFromPointerBlobDefault = new FromPointerBlobDefault[Data] {
    override def fromPointerBuilderBlobDefault(segment: SegmentBuilder, pointer: Int, defaultBuffer: ByteBuffer, defaultOffset: Int, defaultSize: Int): DataBuilder = {
      WireHelpers.getWritableDataPointer(pointer, segment, defaultBuffer, defaultOffset, defaultSize)
    }

    override def fromPointerReaderBlobDefault(segment: SegmentReader, pointer: Int, defaultBuffer: ByteBuffer, defaultOffset: Int, defaultSize: Int): DataReader = {
      WireHelpers.readDataPointer(segment, pointer, defaultBuffer, defaultOffset, defaultSize)
    }
  }

  implicit val dataSetPointerBuilder = new SetPointerBuilder[Data] {
    override def setPointerBuilder(segment: SegmentBuilder, pointer: Int, value: DataReader): Unit = {
      WireHelpers.setDataPointer(pointer, segment, value)
    }
  }

  // PrimitiveList implicits

  implicit val primitiveListVoidHasElementSize = new HasElementSize[PrimitiveList.Void] {
    override def elementSize: Byte = ElementSize.VOID
  }

  implicit val primitiveListBooleanHasElementSize = new HasElementSize[PrimitiveList.Boolean] {
    override def elementSize: Byte = ElementSize.BIT
  }

  implicit val primitiveListByteHasElementSize = new HasElementSize[PrimitiveList.Byte] {
    override def elementSize: Byte = ElementSize.BYTE
  }

  implicit val primitiveListShortHasElementSize = new HasElementSize[PrimitiveList.Short] {
    override def elementSize: Byte = ElementSize.TWO_BYTES
  }

  implicit val primitiveListIntHasElementSize = new HasElementSize[PrimitiveList.Int] {
    override def elementSize: Byte = ElementSize.FOUR_BYTES
  }

  implicit val primitiveListLongHasElementSize = new HasElementSize[PrimitiveList.Long] {
    override def elementSize: Byte = ElementSize.EIGHT_BYTES
  }

  implicit val primitiveListFloatHasElementSize = new HasElementSize[PrimitiveList.Float] {
    override def elementSize: Byte = ElementSize.FOUR_BYTES
  }

  implicit val primitiveListDoubleHasElementSize = new HasElementSize[PrimitiveList.Double] {
    override def elementSize: Byte = ElementSize.EIGHT_BYTES
  }

  implicit val primitiveListVoidListFromSegment = new ListFromSegment[PrimitiveList.Void] {
    override def Reader(segment: SegmentReader, ptr: Int, elementCount: Int, step: Int, structDataSize: Int, structPointerCount: Short, nestingLimit: Int): PrimitiveList.Void#Reader = {
      new PrimitiveList.Void.ReaderImpl(segment, ptr, elementCount, step, structDataSize, structPointerCount, nestingLimit)
    }

    override def Builder(segment: SegmentBuilder, ptr: Int, elementCount: Int, step: Int, structDataSize: Int, structPointerCount: Short): PrimitiveList.Void#Builder = {
      new PrimitiveList.Void.BuilderImpl(segment, ptr, elementCount, step, structDataSize, structPointerCount)
    }
  }

  implicit val primitiveListBooleanListFromSegment = new ListFromSegment[PrimitiveList.Boolean] {
    override def Reader(segment: SegmentReader, ptr: Int, elementCount: Int, step: Int, structDataSize: Int, structPointerCount: Short, nestingLimit: Int): PrimitiveList.Boolean#Reader = {
      new PrimitiveList.Boolean.ReaderImpl(segment, ptr, elementCount, step, structDataSize, structPointerCount, nestingLimit)
    }

    override def Builder(segment: SegmentBuilder, ptr: Int, elementCount: Int, step: Int, structDataSize: Int, structPointerCount: Short): PrimitiveList.Boolean#Builder = {
      new PrimitiveList.Boolean.BuilderImpl(segment, ptr, elementCount, step, structDataSize, structPointerCount)
    }
  }

  implicit val primitiveListByteListFromSegment = new ListFromSegment[PrimitiveList.Byte] {
    override def Reader(segment: SegmentReader, ptr: Int, elementCount: Int, step: Int, structDataSize: Int, structPointerCount: Short, nestingLimit: Int): PrimitiveList.Byte#Reader = {
      new PrimitiveList.Byte.ReaderImpl(segment, ptr, elementCount, step, structDataSize, structPointerCount, nestingLimit)
    }

    override def Builder(segment: SegmentBuilder, ptr: Int, elementCount: Int, step: Int, structDataSize: Int, structPointerCount: Short): PrimitiveList.Byte#Builder = {
      new PrimitiveList.Byte.BuilderImpl(segment, ptr, elementCount, step, structDataSize, structPointerCount)
    }
  }

  implicit val primitiveListShortListFromSegment = new ListFromSegment[PrimitiveList.Short] {
    override def Reader(segment: SegmentReader, ptr: Int, elementCount: Int, step: Int, structDataSize: Int, structPointerCount: Short, nestingLimit: Int): PrimitiveList.Short#Reader = {
      new PrimitiveList.Short.ReaderImpl(segment, ptr, elementCount, step, structDataSize, structPointerCount, nestingLimit)
    }

    override def Builder(segment: SegmentBuilder, ptr: Int, elementCount: Int, step: Int, structDataSize: Int, structPointerCount: Short): PrimitiveList.Short#Builder = {
      new PrimitiveList.Short.BuilderImpl(segment, ptr, elementCount, step, structDataSize, structPointerCount)
    }
  }

  implicit val primitiveListIntListFromSegment = new ListFromSegment[PrimitiveList.Int] {
    override def Reader(segment: SegmentReader, ptr: Int, elementCount: Int, step: Int, structDataSize: Int, structPointerCount: Short, nestingLimit: Int): PrimitiveList.Int#Reader = {
      new PrimitiveList.Int.ReaderImpl(segment, ptr, elementCount, step, structDataSize, structPointerCount, nestingLimit)
    }

    override def Builder(segment: SegmentBuilder, ptr: Int, elementCount: Int, step: Int, structDataSize: Int, structPointerCount: Short): PrimitiveList.Int#Builder = {
      new PrimitiveList.Int.BuilderImpl(segment, ptr, elementCount, step, structDataSize, structPointerCount)
    }
  }

  implicit val primitiveListLongListFromSegment = new ListFromSegment[PrimitiveList.Long] {
    override def Reader(segment: SegmentReader, ptr: Int, elementCount: Int, step: Int, structDataSize: Int, structPointerCount: Short, nestingLimit: Int): PrimitiveList.Long#Reader = {
      new PrimitiveList.Long.ReaderImpl(segment, ptr, elementCount, step, structDataSize, structPointerCount, nestingLimit)
    }

    override def Builder(segment: SegmentBuilder, ptr: Int, elementCount: Int, step: Int, structDataSize: Int, structPointerCount: Short): PrimitiveList.Long#Builder = {
      new PrimitiveList.Long.BuilderImpl(segment, ptr, elementCount, step, structDataSize, structPointerCount)
    }
  }

  implicit val primitiveListFloatListFromSegment = new ListFromSegment[PrimitiveList.Float] {
    override def Reader(segment: SegmentReader, ptr: Int, elementCount: Int, step: Int, structDataSize: Int, structPointerCount: Short, nestingLimit: Int): PrimitiveList.Float#Reader = {
      new PrimitiveList.Float.ReaderImpl(segment, ptr, elementCount, step, structDataSize, structPointerCount, nestingLimit)
    }

    override def Builder(segment: SegmentBuilder, ptr: Int, elementCount: Int, step: Int, structDataSize: Int, structPointerCount: Short): PrimitiveList.Float#Builder = {
      new PrimitiveList.Float.BuilderImpl(segment, ptr, elementCount, step, structDataSize, structPointerCount)
    }
  }

  implicit val primitiveListDoubleListFromSegment = new ListFromSegment[PrimitiveList.Double] {
    override def Reader(segment: SegmentReader, ptr: Int, elementCount: Int, step: Int, structDataSize: Int, structPointerCount: Short, nestingLimit: Int): PrimitiveList.Double#Reader = {
      new PrimitiveList.Double.ReaderImpl(segment, ptr, elementCount, step, structDataSize, structPointerCount, nestingLimit)
    }

    override def Builder(segment: SegmentBuilder, ptr: Int, elementCount: Int, step: Int, structDataSize: Int, structPointerCount: Short): PrimitiveList.Double#Builder = {
      new PrimitiveList.Double.BuilderImpl(segment, ptr, elementCount, step, structDataSize, structPointerCount)
    }
  }

  // Text implicits

  implicit val textFromPointer = new FromPointer[Text] {
    override def fromPointerReader(segment: SegmentReader, pointer: Int, nestingLimit: Int): TextReader = {
      WireHelpers.readTextPointer(segment, pointer, null, 0, 0)
    }

    override def fromPointerBuilder(segment: SegmentBuilder, pointer: Int): TextBuilder = {
      WireHelpers.getWritableTextPointer(pointer, segment, null, 0, 0)
    }

    override def initFromPointerBuilder(segment: SegmentBuilder, pointer: Int, size: Int): TextBuilder = {
      WireHelpers.initTextPointer(pointer, segment, size)
    }
  }

  implicit val textFromPointerBlobDefault = new FromPointerBlobDefault[Text] {
    override def fromPointerBuilderBlobDefault(segment: SegmentBuilder, pointer: Int, defaultBuffer: ByteBuffer, defaultOffset: Int, defaultSize: Int): TextBuilder = {
      WireHelpers.getWritableTextPointer(pointer, segment, defaultBuffer, defaultOffset, defaultSize)
    }

    override def fromPointerReaderBlobDefault(segment: SegmentReader, pointer: Int, defaultBuffer: ByteBuffer, defaultOffset: Int, defaultSize: Int): TextReader = {
      WireHelpers.readTextPointer(segment, pointer, defaultBuffer, defaultOffset, defaultSize)
    }
  }

  implicit val textSetPointerBuilder = new SetPointerBuilder[Text] {
    override def setPointerBuilder(segment: SegmentBuilder, pointer: Int, value: TextReader): Unit = {
      WireHelpers.setTextPointer(pointer, segment, value)
    }
  }

  // List implicits

  implicit def listFromPointerAndFromPointerRefDefault[B, R, T <: List[B, R] : HasElementSize : ListFromSegment] = new FromPointer[T] with FromPointerRefDefault[T] {
    val elementSize = implicitly[HasElementSize[T]].elementSize
    override def fromPointerBuilderRefDefault(segment: SegmentBuilder, pointer: Int, defaultSegment: SegmentReader, defaultOffset: Int): T#Builder = {
      WireHelpers.getWritableListPointer[T](pointer, segment, elementSize, null, 0)
    }

    override def fromPointerBuilder(segment: SegmentBuilder, pointer: Int): T#Builder = {
      WireHelpers.getWritableListPointer[T](pointer, segment, elementSize, null, 0)
    }

    override def initFromPointerBuilder(segment: SegmentBuilder, pointer: Int, elementCount: Int): T#Builder = {
      WireHelpers.initListPointer[T](pointer, segment, elementCount, elementSize)
    }

    override def fromPointerReaderRefDefault(segment: SegmentReader, pointer: Int, defaultSegment: SegmentReader, defaultOffset: Int, nestingLimit: Int): T#Reader = {
      WireHelpers.readListPointer[T](segment, pointer, defaultSegment, defaultOffset, elementSize, nestingLimit)
    }

    override def fromPointerReader(segment: SegmentReader, pointer: Int, nestingLimit: Int): T#Reader = {
      fromPointerReaderRefDefault(segment, pointer, null, 0, nestingLimit)
    }
  }

  implicit def listSetPointerBuilder[B, R, T <: List[B, R] : HasElementSize : ListFromSegment] = new SetPointerBuilder[T] {
    override def setPointerBuilder(segment: SegmentBuilder, pointer: Int, value: T#Reader): Unit = {
      WireHelpers.setListPointer(segment, pointer, value)
    }
  }

  // Enum implicits

  implicit def enumListHasElementSize[T <: Enum : HasEnumValues] = new HasElementSize[EnumList[T]] {
    override def elementSize: Byte = ElementSize.TWO_BYTES
  }

  implicit def enumListFromSegment[T <: Enum : HasEnumValues] = new ListFromSegment[EnumList[T]] {
    val enumList = new EnumList[T]
    override def Reader(segment: SegmentReader, ptr: Int, elementCount: Int, step: Int, structDataSize: Int, structPointerCount: Short, nestingLimit: Int): EnumList[T]#Reader = {
      new enumList.Reader(segment, ptr, elementCount, step, structDataSize, structPointerCount, nestingLimit)
    }

    override def Builder(segment: SegmentBuilder, ptr: Int, elementCount: Int, step: Int, structDataSize: Int, structPointerCount: Short): EnumList[T]#Builder = {
      new enumList.Builder(segment, ptr, elementCount, step, structDataSize, structPointerCount)
    }
  }

  implicit def enumListFromPointer[T <: Enum : HasEnumValues] = new FromPointer[EnumList[T]] with FromPointerRefDefault[EnumList[T]] {
    override def fromPointerBuilderRefDefault(segment: SegmentBuilder, pointer: Int, defaultSegment: SegmentReader, defaultOffset: Int): EnumList[T]#Builder = {
      WireHelpers.getWritableListPointer[EnumList[T]](pointer, segment, ElementSize.TWO_BYTES, null, 0)
    }

    override def fromPointerBuilder(segment: SegmentBuilder, pointer: Int): EnumList[T]#Builder = {
      WireHelpers.getWritableListPointer[EnumList[T]](pointer, segment, ElementSize.TWO_BYTES, null, 0)
    }

    override def initFromPointerBuilder(segment: SegmentBuilder, pointer: Int, elementCount: Int): EnumList[T]#Builder = {
      WireHelpers.initListPointer[EnumList[T]](pointer, segment, elementCount, ElementSize.TWO_BYTES)
    }

    override def fromPointerReaderRefDefault(segment: SegmentReader, pointer: Int, defaultSegment: SegmentReader, defaultOffset: Int, nestingLimit: Int): EnumList[T]#Reader = {
      WireHelpers.readListPointer[EnumList[T]](segment, pointer, defaultSegment, defaultOffset, ElementSize.TWO_BYTES, nestingLimit)
    }

    override def fromPointerReader(segment: SegmentReader, pointer: Int, nestingLimit: Int): EnumList[T]#Reader = {
      fromPointerReaderRefDefault(segment, pointer, null, 0, nestingLimit)
    }
  }

  implicit def enumListSetPointerBuilder[T <: Enum : HasEnumValues] = new SetPointerBuilder[EnumList[T]] {
    override def setPointerBuilder(segment: SegmentBuilder, pointer: Int, value: EnumList[T]#Reader): Unit = {
      WireHelpers.setListPointer(segment, pointer, value)
    }
  }
}
