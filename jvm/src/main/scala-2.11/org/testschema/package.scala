package org {
  package object testschema {
    object Date {
      val STRUCT_SIZE = new org.capnproto.StructSize(320, 9)
      val factory = new Factory
      val listFactory: org.capnproto.StructList.Factory[Builder, Reader] = new org.capnproto.StructList.Factory[Builder, Reader](factory)
      final class Factory extends org.capnproto.StructFactory[Builder, Reader] {
        override def constructReader(segment: org.capnproto.SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): Reader = {
          new Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
        }
        override def constructBuilder(segment: org.capnproto.SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short): Builder = {
          new Builder(segment, data, pointers, dataSize, pointerCount)
        }
        override def structSize: org.capnproto.StructSize = STRUCT_SIZE
        override def asReader(builder: Builder): Reader = builder.asReader
      }
      class Reader(segment: org.capnproto.SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends org.capnproto.StructReader(segment, data, pointers, dataSize, pointerCount, nestingLimit) {
        def year: Short = _getShortField(0)
        def month: Byte = _getByteField(2)
        def day: Byte = _getByteField(3)
        def week: Byte = _getByteField(4)
      }
      class Builder(segment: org.capnproto.SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends org.capnproto.StructBuilder(segment, data, pointers, dataSize, pointerCount) {
        def year: Short = _getShortField(0)
        def year_=(value: Short): Unit = _setShortField(0, value)
        def month: Byte = _getByteField(2)
        def month_=(value: Byte): Unit = _setByteField(2, value)
        def day: Byte = _getByteField(3)
        def day_=(value: Byte): Unit = _setByteField(3, value)
        def week: Byte = _getByteField(4)
        def week_=(value: Byte): Unit = _setByteField(4, value)
        def asReader: Reader = new Reader(segment, data, pointers, dataSize, pointerCount, 134217727)
      }
    }
  }
}