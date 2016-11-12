// GENERATED CAP'N PROTO FILE, DO NOT EDIT
package org.katis.capnproto.compiler.multifile

import org.katis.capnproto.runtime.implicits._

object order {
  // START Order implicits
  implicit val Order$$HasTypeId = new org.katis.capnproto.runtime.HasTypeId[Order] {
    def typeId: Long = -7521475027206739292L
  }
  implicit val Order$$HasStructSize = new org.katis.capnproto.runtime.HasStructSize[Order] {
    val structSize = new org.katis.capnproto.runtime.StructSize(0, 3)
  }
  implicit val Order$$StructFromSegment = new org.katis.capnproto.runtime.StructFromSegment[Order] {
    def readerFromSegment(segment: org.katis.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): Order#Reader = {
      Order.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.katis.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): Order#Builder = {
      Order.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END Order implicits
  // START Item implicits
  implicit val Item$$HasTypeId = new org.katis.capnproto.runtime.HasTypeId[Item] {
    def typeId: Long = -1770797472075033903L
  }
  implicit val Item$$HasStructSize = new org.katis.capnproto.runtime.HasStructSize[Item] {
    val structSize = new org.katis.capnproto.runtime.StructSize(0, 2)
  }
  implicit val Item$$StructFromSegment = new org.katis.capnproto.runtime.StructFromSegment[Item] {
    def readerFromSegment(segment: org.katis.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): Item#Reader = {
      Item.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.katis.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): Item#Builder = {
      Item.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END Item implicits

  object Order extends Order
  sealed class Order private() extends org.katis.capnproto.runtime.Struct { 
    val typeId: Long = -7521475027206739292L
    override val structSize: org.katis.capnproto.runtime.StructSize = new org.katis.capnproto.runtime.StructSize(0, 3)

    override type Reader = ReaderImpl
    override type Builder = BuilderImpl

    override val Builder: (org.katis.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (org.katis.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    class ReaderImpl(_segment: org.katis.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
      def id: org.katis.capnproto.compiler.multifile.util.uuid.UUID#Reader = {
        _getPointerField[org.katis.capnproto.compiler.multifile.util.uuid.UUID](0)
      }
      def customer: org.katis.capnproto.compiler.multifile.customer.Customer#Reader = {
        _getPointerField[org.katis.capnproto.compiler.multifile.customer.Customer](1)
      }
      def items: org.katis.capnproto.runtime.StructList[org.katis.capnproto.compiler.multifile.order.Item]#Reader = {
        _getPointerField[org.katis.capnproto.runtime.StructList[org.katis.capnproto.compiler.multifile.order.Item]](2)
      }
      object has {
        def id: Boolean = {
          _pointerFieldIsNull(0)
        }
        def customer: Boolean = {
          _pointerFieldIsNull(1)
        }
        def items: Boolean = {
          _pointerFieldIsNull(2)
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
      def customer: org.katis.capnproto.compiler.multifile.customer.Customer#Builder = {
        _getPointerField[org.katis.capnproto.compiler.multifile.customer.Customer](1)
      }
      def customer_=(value: org.katis.capnproto.compiler.multifile.customer.Customer#Reader): Unit = {
        _setPointerField[org.katis.capnproto.compiler.multifile.customer.Customer](1, value)
      }
      def items: org.katis.capnproto.runtime.StructList[org.katis.capnproto.compiler.multifile.order.Item]#Builder = {
        _getPointerField[org.katis.capnproto.runtime.StructList[org.katis.capnproto.compiler.multifile.order.Item]](2)
      }
      def items_=(value: org.katis.capnproto.runtime.StructList[org.katis.capnproto.compiler.multifile.order.Item]#Reader): Unit = {
        _setPointerField[org.katis.capnproto.runtime.StructList[org.katis.capnproto.compiler.multifile.order.Item]](2, value)
      }
      object has {
        def id: Boolean = {
          _pointerFieldIsNull(0)
        }
        def customer: Boolean = {
          _pointerFieldIsNull(1)
        }
        def items: Boolean = {
          _pointerFieldIsNull(2)
        }
      }
      object init {
        def id(): org.katis.capnproto.compiler.multifile.util.uuid.UUID#Builder = {
          _initPointerField[org.katis.capnproto.compiler.multifile.util.uuid.UUID](0, 0)
        }
        def customer(): org.katis.capnproto.compiler.multifile.customer.Customer#Builder = {
          _initPointerField[org.katis.capnproto.compiler.multifile.customer.Customer](1, 0)
        }
        def items(size: Int): org.katis.capnproto.runtime.StructList[org.katis.capnproto.compiler.multifile.order.Item]#Builder = {
          _initPointerField[org.katis.capnproto.runtime.StructList[org.katis.capnproto.compiler.multifile.order.Item]](2, size)
        }
      }
    }
  }

  object Item extends Item
  sealed class Item private() extends org.katis.capnproto.runtime.Struct { 
    val typeId: Long = -1770797472075033903L
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
