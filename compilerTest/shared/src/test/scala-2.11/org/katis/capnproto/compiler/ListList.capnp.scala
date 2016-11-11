// GENERATED CAP'N PROTO FILE, DO NOT EDIT
package org.katis.capnproto.compiler

import org.katis.capnproto.runtime.implicits._

object contents {
  // START Contents implicits
  implicit val Contents$$HasTypeId = new org.katis.capnproto.runtime.HasTypeId[Contents] {
    def typeId: Long = -3160189064124843233L
  }
  implicit val Contents$$HasStructSize = new org.katis.capnproto.runtime.HasStructSize[Contents] {
    val structSize = new org.katis.capnproto.runtime.StructSize(0, 1)
  }
  implicit val Contents$$StructFromSegment = new org.katis.capnproto.runtime.StructFromSegment[Contents] {
    def readerFromSegment(segment: org.katis.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): Contents#Reader = {
      Contents.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.katis.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): Contents#Builder = {
      Contents.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END Contents implicits

  object Contents extends Contents
  sealed class Contents private() extends org.katis.capnproto.runtime.Struct { 
    val typeId: Long = -3160189064124843233L
    override val structSize: org.katis.capnproto.runtime.StructSize = new org.katis.capnproto.runtime.StructSize(0, 1)

    override type Reader = ReaderImpl
    override type Builder = BuilderImpl

    override val Builder: (org.katis.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (org.katis.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    class ReaderImpl(_segment: org.katis.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
      def entries: org.katis.capnproto.runtime.ListList[org.katis.capnproto.runtime.TextList]#Reader = {
        _getPointerField[org.katis.capnproto.runtime.ListList[org.katis.capnproto.runtime.TextList]](0)
      }
      object has {
        def entries: Boolean = {
          _pointerFieldIsNull(0)
        }
      }
    }
    class BuilderImpl(_segment: org.katis.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
      def entries: org.katis.capnproto.runtime.ListList[org.katis.capnproto.runtime.TextList]#Builder = {
        _getPointerField[org.katis.capnproto.runtime.ListList[org.katis.capnproto.runtime.TextList]](0)
      }
      def entries_=(value: org.katis.capnproto.runtime.ListList[org.katis.capnproto.runtime.TextList]#Reader): Unit = {
        _setPointerField[org.katis.capnproto.runtime.ListList[org.katis.capnproto.runtime.TextList]](0, value)
      }
      object has {
        def entries: Boolean = {
          _pointerFieldIsNull(0)
        }
      }
      object init {
        def entries(size: Int): org.katis.capnproto.runtime.ListList[org.katis.capnproto.runtime.TextList]#Builder = {
          _initPointerField[org.katis.capnproto.runtime.ListList[org.katis.capnproto.runtime.TextList]](0, size)
        }
      }
    }
  }
}
