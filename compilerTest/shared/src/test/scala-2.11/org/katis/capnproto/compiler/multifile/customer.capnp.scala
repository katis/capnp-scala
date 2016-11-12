// GENERATED CAP'N PROTO FILE, DO NOT EDIT
package org.katis.capnproto.compiler.multifile

import org.katis.capnproto.runtime.implicits._

object customer {
  // START Customer implicits
  implicit val Customer$$HasTypeId = new org.katis.capnproto.runtime.HasTypeId[Customer] {
    def typeId: Long = -1898055877036248516L
  }
  implicit val Customer$$HasStructSize = new org.katis.capnproto.runtime.HasStructSize[Customer] {
    val structSize = new org.katis.capnproto.runtime.StructSize(0, 2)
  }
  implicit val Customer$$StructFromSegment = new org.katis.capnproto.runtime.StructFromSegment[Customer] {
    def readerFromSegment(segment: org.katis.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): Customer#Reader = {
      Customer.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.katis.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): Customer#Builder = {
      Customer.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END Customer implicits

  object Customer extends Customer
  sealed class Customer private() extends org.katis.capnproto.runtime.Struct { 
    val typeId: Long = -1898055877036248516L
    override val structSize: org.katis.capnproto.runtime.StructSize = new org.katis.capnproto.runtime.StructSize(0, 2)

    override type Reader = ReaderImpl
    override type Builder = BuilderImpl

    override val Builder: (org.katis.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (org.katis.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    class ReaderImpl(_segment: org.katis.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
      def id: org.katis.capnproto.compiler.multifile.util.uuid.UUID#Reader = {
        _getPointerField[org.katis.capnproto.compiler.multifile.util.uuid.UUID](0)
      }
      def name: org.katis.capnproto.runtime.Text#Reader = {
        _getPointerField[org.katis.capnproto.runtime.Text](1)
      }
      object has {
        def id: Boolean = {
          _pointerFieldIsNull(0)
        }
        def name: Boolean = {
          _pointerFieldIsNull(1)
        }
      }
    }
    class BuilderImpl(_segment: org.katis.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
      def id: org.katis.capnproto.compiler.multifile.util.uuid.UUID#Builder = {
        _getPointerField[org.katis.capnproto.compiler.multifile.util.uuid.UUID](0)
      }
      def id_=(value: org.katis.capnproto.compiler.multifile.util.uuid.UUID#Reader): Unit = {
        _setPointerField[org.katis.capnproto.compiler.multifile.util.uuid.UUID](0, value)
      }
      def name: org.katis.capnproto.runtime.Text#Builder = {
        _getPointerField[org.katis.capnproto.runtime.Text](1)
      }
      def name_=(value: org.katis.capnproto.runtime.Text#Reader): Unit = {
        _setPointerField[org.katis.capnproto.runtime.Text](1, value)
      }
      def name_=(value: String): Unit = {
        _setPointerField[org.katis.capnproto.runtime.Text](1, org.katis.capnproto.runtime.Text.Reader(value))
      }
      object has {
        def id: Boolean = {
          _pointerFieldIsNull(0)
        }
        def name: Boolean = {
          _pointerFieldIsNull(1)
        }
      }
      object init {
        def id(): org.katis.capnproto.compiler.multifile.util.uuid.UUID#Builder = {
          _initPointerField[org.katis.capnproto.compiler.multifile.util.uuid.UUID](0, 0)
        }
        def name(size: Int): org.katis.capnproto.runtime.Text#Builder = {
          _initPointerField[org.katis.capnproto.runtime.Text](1, size)
        }
      }
    }
  }
}
