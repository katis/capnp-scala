// GENERATED CAP'N PROTO FILE, DO NOT EDIT
package org.katis.capnproto.compiler

import org.katis.capnproto.runtime.implicits._

object SimpleGeneric {
  // START GenericMap#Entry implicits
  implicit def GenericMap$Entry$$HasTypeId[Key <: org.katis.capnproto.runtime.PointerFamily : org.katis.capnproto.runtime.FromPointer : org.katis.capnproto.runtime.SetPointerBuilder, Value <: org.katis.capnproto.runtime.PointerFamily : org.katis.capnproto.runtime.FromPointer : org.katis.capnproto.runtime.SetPointerBuilder] = new org.katis.capnproto.runtime.HasTypeId[GenericMap[Key, Value]#Entry] {
    def typeId: Long = -4562728721940766169L
  }
  implicit def GenericMap$Entry$$HasStructSize[Key <: org.katis.capnproto.runtime.PointerFamily : org.katis.capnproto.runtime.FromPointer : org.katis.capnproto.runtime.SetPointerBuilder, Value <: org.katis.capnproto.runtime.PointerFamily : org.katis.capnproto.runtime.FromPointer : org.katis.capnproto.runtime.SetPointerBuilder] = new org.katis.capnproto.runtime.HasStructSize[GenericMap[Key, Value]#Entry] {
    val structSize = new org.katis.capnproto.runtime.StructSize(0, 2)
  }
  implicit def GenericMap$Entry$$StructFromSegment[Key <: org.katis.capnproto.runtime.PointerFamily : org.katis.capnproto.runtime.FromPointer : org.katis.capnproto.runtime.SetPointerBuilder, Value <: org.katis.capnproto.runtime.PointerFamily : org.katis.capnproto.runtime.FromPointer : org.katis.capnproto.runtime.SetPointerBuilder] = new org.katis.capnproto.runtime.StructFromSegment[GenericMap[Key, Value]#Entry] {
    def readerFromSegment(segment: org.katis.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): GenericMap[Key, Value]#Entry#Reader = {
      GenericMap[Key, Value].Entry.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.katis.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): GenericMap[Key, Value]#Entry#Builder = {
      GenericMap[Key, Value].Entry.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END GenericMap#Entry implicits
  // START GenericMap implicits
  implicit def GenericMap$$HasTypeId[Key <: org.katis.capnproto.runtime.PointerFamily : org.katis.capnproto.runtime.FromPointer : org.katis.capnproto.runtime.SetPointerBuilder, Value <: org.katis.capnproto.runtime.PointerFamily : org.katis.capnproto.runtime.FromPointer : org.katis.capnproto.runtime.SetPointerBuilder] = new org.katis.capnproto.runtime.HasTypeId[GenericMap[Key, Value]] {
    def typeId: Long = -4648576583519501999L
  }
  implicit def GenericMap$$HasStructSize[Key <: org.katis.capnproto.runtime.PointerFamily : org.katis.capnproto.runtime.FromPointer : org.katis.capnproto.runtime.SetPointerBuilder, Value <: org.katis.capnproto.runtime.PointerFamily : org.katis.capnproto.runtime.FromPointer : org.katis.capnproto.runtime.SetPointerBuilder] = new org.katis.capnproto.runtime.HasStructSize[GenericMap[Key, Value]] {
    val structSize = new org.katis.capnproto.runtime.StructSize(0, 1)
  }
  implicit def GenericMap$$StructFromSegment[Key <: org.katis.capnproto.runtime.PointerFamily : org.katis.capnproto.runtime.FromPointer : org.katis.capnproto.runtime.SetPointerBuilder, Value <: org.katis.capnproto.runtime.PointerFamily : org.katis.capnproto.runtime.FromPointer : org.katis.capnproto.runtime.SetPointerBuilder] = new org.katis.capnproto.runtime.StructFromSegment[GenericMap[Key, Value]] {
    def readerFromSegment(segment: org.katis.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): GenericMap[Key, Value]#Reader = {
      GenericMap[Key, Value].Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.katis.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): GenericMap[Key, Value]#Builder = {
      GenericMap[Key, Value].Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END GenericMap implicits
  // START User implicits
  implicit val User$$HasTypeId = new org.katis.capnproto.runtime.HasTypeId[User] {
    def typeId: Long = -6754264410935672481L
  }
  implicit val User$$HasStructSize = new org.katis.capnproto.runtime.HasStructSize[User] {
    val structSize = new org.katis.capnproto.runtime.StructSize(1, 1)
  }
  implicit val User$$StructFromSegment = new org.katis.capnproto.runtime.StructFromSegment[User] {
    def readerFromSegment(segment: org.katis.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): User#Reader = {
      User.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.katis.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): User#Builder = {
      User.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END User implicits

  object GenericMap {
    def apply[Key <: org.katis.capnproto.runtime.PointerFamily : org.katis.capnproto.runtime.FromPointer : org.katis.capnproto.runtime.SetPointerBuilder, Value <: org.katis.capnproto.runtime.PointerFamily : org.katis.capnproto.runtime.FromPointer : org.katis.capnproto.runtime.SetPointerBuilder]: GenericMap[Key, Value] = new GenericMap[Key, Value]
  }
  sealed class GenericMap[Key <: org.katis.capnproto.runtime.PointerFamily : org.katis.capnproto.runtime.FromPointer : org.katis.capnproto.runtime.SetPointerBuilder, Value <: org.katis.capnproto.runtime.PointerFamily : org.katis.capnproto.runtime.FromPointer : org.katis.capnproto.runtime.SetPointerBuilder] private() extends org.katis.capnproto.runtime.Struct { 
    val typeId: Long = -4648576583519501999L
    override val structSize: org.katis.capnproto.runtime.StructSize = new org.katis.capnproto.runtime.StructSize(0, 1)

    override type Reader = ReaderImpl
    override type Builder = BuilderImpl

    override val Builder: (org.katis.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (org.katis.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    class ReaderImpl(_segment: org.katis.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
      def entries: org.katis.capnproto.runtime.StructList[org.katis.capnproto.compiler.SimpleGeneric.GenericMap[Key, Value]#Entry]#Reader = {
        _getPointerField[org.katis.capnproto.runtime.StructList[org.katis.capnproto.compiler.SimpleGeneric.GenericMap[Key, Value]#Entry]](0)
      }
      object has {
        def entries: Boolean = {
          _pointerFieldIsNull(0)
        }
      }
    }
    class BuilderImpl(_segment: org.katis.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
      def entries: org.katis.capnproto.runtime.StructList[org.katis.capnproto.compiler.SimpleGeneric.GenericMap[Key, Value]#Entry]#Builder = {
        _getPointerField[org.katis.capnproto.runtime.StructList[org.katis.capnproto.compiler.SimpleGeneric.GenericMap[Key, Value]#Entry]](0)
      }
      def entries_=(value: org.katis.capnproto.runtime.StructList[org.katis.capnproto.compiler.SimpleGeneric.GenericMap[Key, Value]#Entry]#Reader): Unit = {
        _setPointerField[org.katis.capnproto.runtime.StructList[org.katis.capnproto.compiler.SimpleGeneric.GenericMap[Key, Value]#Entry]](0, value)
      }
      object has {
        def entries: Boolean = {
          _pointerFieldIsNull(0)
        }
      }
      object init {
        def entries(size: Int): org.katis.capnproto.runtime.StructList[org.katis.capnproto.compiler.SimpleGeneric.GenericMap[Key, Value]#Entry]#Builder = {
          _initPointerField[org.katis.capnproto.runtime.StructList[org.katis.capnproto.compiler.SimpleGeneric.GenericMap[Key, Value]#Entry]](0, size)
        }
      }
    }

    object Entry extends Entry
    sealed class Entry private() extends org.katis.capnproto.runtime.Struct { 
      val typeId: Long = -4562728721940766169L
      override val structSize: org.katis.capnproto.runtime.StructSize = new org.katis.capnproto.runtime.StructSize(0, 2)

      override type Reader = ReaderImpl
      override type Builder = BuilderImpl

      override val Builder: (org.katis.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (org.katis.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      class ReaderImpl(_segment: org.katis.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
        def key: Key#Reader = {
          _getPointerField[Key](0)
        }
        def value: Value#Reader = {
          _getPointerField[Value](1)
        }
        object has {
          def key: Boolean = {
            _pointerFieldIsNull(0)
          }
          def value: Boolean = {
            _pointerFieldIsNull(1)
          }
        }
      }
      class BuilderImpl(_segment: org.katis.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        def key: Key#Builder = {
          _getPointerField[Key](0)
        }
        def key_=(value: Key#Reader): Unit = {
          _setPointerField[Key](0, value)
        }
        def value: Value#Builder = {
          _getPointerField[Value](1)
        }
        def value_=(value: Value#Reader): Unit = {
          _setPointerField[Value](1, value)
        }
        object has {
          def key: Boolean = {
            _pointerFieldIsNull(0)
          }
          def value: Boolean = {
            _pointerFieldIsNull(1)
          }
        }
        object init {
          def key(size: Int = 0): Key#Builder = {
            _initPointerField[Key](1, size)
          }
          def value(size: Int = 0): Value#Builder = {
            _initPointerField[Value](1, size)
          }
        }
      }
    }
  }

  object User extends User
  sealed class User private() extends org.katis.capnproto.runtime.Struct { 
    val typeId: Long = -6754264410935672481L
    override val structSize: org.katis.capnproto.runtime.StructSize = new org.katis.capnproto.runtime.StructSize(1, 1)

    override type Reader = ReaderImpl
    override type Builder = BuilderImpl

    override val Builder: (org.katis.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (org.katis.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    class ReaderImpl(_segment: org.katis.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
      def name: org.katis.capnproto.runtime.Text#Reader = {
        _getPointerField[org.katis.capnproto.runtime.Text](0)
      }
      def age: Byte = {
        this._getByteField(0)
      }
      object has {
        def name: Boolean = {
          _pointerFieldIsNull(0)
        }
      }
    }
    class BuilderImpl(_segment: org.katis.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
      def name: org.katis.capnproto.runtime.Text#Builder = {
        _getPointerField[org.katis.capnproto.runtime.Text](0)
      }
      def name_=(value: org.katis.capnproto.runtime.Text#Reader): Unit = {
        _setPointerField[org.katis.capnproto.runtime.Text](0, value)
      }
      def name_=(value: String): Unit = {
        _setPointerField[org.katis.capnproto.runtime.Text](0, org.katis.capnproto.runtime.Text.Reader(value))
      }
      def age: Byte = {
        this._getByteField(0)
      }
      def age_=(value: Byte): Unit = {
        _setByteField(0, value)
      }
      object has {
        def name: Boolean = {
          _pointerFieldIsNull(0)
        }
      }
      object init {
        def name(size: Int): org.katis.capnproto.runtime.Text#Builder = {
          _initPointerField[org.katis.capnproto.runtime.Text](0, size)
        }
      }
    }
  }
}
