// GENERATED CAP'N PROTO FILE, DO NOT EDIT
package org.murtsi.capnproto.compiler

import org.murtsi.capnproto.runtime.implicits._

object contents {
  // START Contents implicits
  implicit val Contents$$HasTypeId = new org.murtsi.capnproto.runtime.HasTypeId[Contents] {
    def typeId: Long = -3160189064124843233L
  }
  implicit val Contents$$HasStructSize = new org.murtsi.capnproto.runtime.HasStructSize[Contents] {
    val structSize = new org.murtsi.capnproto.runtime.StructSize(0, 1)
  }
  implicit val Contents$$StructFromSegment = new org.murtsi.capnproto.runtime.StructFromSegment[Contents] {
    def readerFromSegment(segment: org.murtsi.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): Contents#Reader = {
      Contents.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.murtsi.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): Contents#Builder = {
      Contents.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END Contents implicits

  object Contents extends Contents
  sealed class Contents private() extends org.murtsi.capnproto.runtime.Struct { 
    val typeId: Long = -3160189064124843233L
    override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(0, 1)

    override type Reader = ReaderImpl
    override type Builder = BuilderImpl

    override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
      def entries: org.murtsi.capnproto.runtime.ListList[org.murtsi.capnproto.runtime.TextList]#Reader = {
        _getPointerField[org.murtsi.capnproto.runtime.ListList[org.murtsi.capnproto.runtime.TextList]](0)
      }
      object has {
        def entries: Boolean = {
          _pointerFieldIsNull(0)
        }
      }
    }
    class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
      def entries: org.murtsi.capnproto.runtime.ListList[org.murtsi.capnproto.runtime.TextList]#Builder = {
        _getPointerField[org.murtsi.capnproto.runtime.ListList[org.murtsi.capnproto.runtime.TextList]](0)
      }
      def entries_=(value: org.murtsi.capnproto.runtime.ListList[org.murtsi.capnproto.runtime.TextList]#Reader): Unit = {
        _setPointerField[org.murtsi.capnproto.runtime.ListList[org.murtsi.capnproto.runtime.TextList]](0, value)
      }
      object has {
        def entries: Boolean = {
          _pointerFieldIsNull(0)
        }
      }
      object init {
        def entries(size: Int): org.murtsi.capnproto.runtime.ListList[org.murtsi.capnproto.runtime.TextList]#Builder = {
          _initPointerField[org.murtsi.capnproto.runtime.ListList[org.murtsi.capnproto.runtime.TextList]](0, size)
        }
      }
    }
  }
}
