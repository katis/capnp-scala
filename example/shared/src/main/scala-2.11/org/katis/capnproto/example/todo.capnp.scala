// GENERATED CAP'N PROTO FILE, DO NOT EDIT
package org.katis.capnproto.example

import org.katis.capnproto.runtime.implicits._

object todo {
  // START ClientMessage implicits
  implicit val ClientMessage$$HasTypeId = new org.katis.capnproto.runtime.HasTypeId[ClientMessage] {
    def typeId: Long = -57167328279103122L
  }
  implicit val ClientMessage$$HasStructSize = new org.katis.capnproto.runtime.HasStructSize[ClientMessage] {
    val structSize = new org.katis.capnproto.runtime.StructSize(2, 1)
  }
  implicit val ClientMessage$$StructFromSegment = new org.katis.capnproto.runtime.StructFromSegment[ClientMessage] {
    def readerFromSegment(segment: org.katis.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): ClientMessage#Reader = {
      ClientMessage.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.katis.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): ClientMessage#Builder = {
      ClientMessage.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END ClientMessage implicits
  // START ClientMessage#Initial implicits
  implicit val ClientMessage$Initial$$HasTypeId = new org.katis.capnproto.runtime.HasTypeId[ClientMessage#Initial] {
    def typeId: Long = -8025231674297101893L
  }
  implicit val ClientMessage$Initial$$HasStructSize = new org.katis.capnproto.runtime.HasStructSize[ClientMessage#Initial] {
    val structSize = new org.katis.capnproto.runtime.StructSize(2, 1)
  }
  implicit val ClientMessage$Initial$$StructFromSegment = new org.katis.capnproto.runtime.StructFromSegment[ClientMessage#Initial] {
    def readerFromSegment(segment: org.katis.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): ClientMessage#Initial#Reader = {
      ClientMessage.Initial.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.katis.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): ClientMessage#Initial#Builder = {
      ClientMessage.Initial.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END ClientMessage#Initial implicits
  // START ServerMessage implicits
  implicit val ServerMessage$$HasTypeId = new org.katis.capnproto.runtime.HasTypeId[ServerMessage] {
    def typeId: Long = -212057696756897572L
  }
  implicit val ServerMessage$$HasStructSize = new org.katis.capnproto.runtime.HasStructSize[ServerMessage] {
    val structSize = new org.katis.capnproto.runtime.StructSize(2, 1)
  }
  implicit val ServerMessage$$StructFromSegment = new org.katis.capnproto.runtime.StructFromSegment[ServerMessage] {
    def readerFromSegment(segment: org.katis.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): ServerMessage#Reader = {
      ServerMessage.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.katis.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): ServerMessage#Builder = {
      ServerMessage.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END ServerMessage implicits
  // START Todo implicits
  implicit val Todo$$HasTypeId = new org.katis.capnproto.runtime.HasTypeId[Todo] {
    def typeId: Long = -9191580955837035021L
  }
  implicit val Todo$$HasStructSize = new org.katis.capnproto.runtime.HasStructSize[Todo] {
    val structSize = new org.katis.capnproto.runtime.StructSize(1, 2)
  }
  implicit val Todo$$StructFromSegment = new org.katis.capnproto.runtime.StructFromSegment[Todo] {
    def readerFromSegment(segment: org.katis.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): Todo#Reader = {
      Todo.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.katis.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): Todo#Builder = {
      Todo.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END Todo implicits

  object ClientMessage extends ClientMessage
  sealed class ClientMessage private() extends org.katis.capnproto.runtime.Struct { 
    val typeId: Long = -57167328279103122L
    override val structSize: org.katis.capnproto.runtime.StructSize = new org.katis.capnproto.runtime.StructSize(2, 1)

    override type Reader = ReaderImpl
    override type Builder = BuilderImpl

    override val Builder: (org.katis.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (org.katis.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    class ReaderImpl(_segment: org.katis.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
      private[ClientMessage] def initial: ClientMessage#Initial#Reader = {
        ClientMessage.Initial.Reader(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit)
      }
      private[ClientMessage] def added: org.katis.capnproto.example.todo.Todo#Reader = {
        _getPointerField[org.katis.capnproto.example.todo.Todo](0)
      }
      private[ClientMessage] def removed: org.katis.capnproto.example.todo.Todo#Reader = {
        _getPointerField[org.katis.capnproto.example.todo.Todo](0)
      }
      private[ClientMessage] def modified: org.katis.capnproto.example.todo.Todo#Reader = {
        _getPointerField[org.katis.capnproto.example.todo.Todo](0)
      }
      private[ClientMessage] def addFailed: org.katis.capnproto.example.todo.Todo#Reader = {
        _getPointerField[org.katis.capnproto.example.todo.Todo](0)
      }
      private[ClientMessage] def removalFailed: org.katis.capnproto.example.todo.Todo#Reader = {
        _getPointerField[org.katis.capnproto.example.todo.Todo](0)
      }
      private[ClientMessage] def modifyFailed: org.katis.capnproto.example.todo.Todo#Reader = {
        _getPointerField[org.katis.capnproto.example.todo.Todo](0)
      }
      private[ClientMessage] def _whichIndex: Short = _getShortField(4)
      object has {
        def added: Boolean = {
          if (_getShortField(4) != 1) false
          else _pointerFieldIsNull(0)
        }
        def removed: Boolean = {
          if (_getShortField(4) != 2) false
          else _pointerFieldIsNull(0)
        }
        def modified: Boolean = {
          if (_getShortField(4) != 3) false
          else _pointerFieldIsNull(0)
        }
        def addFailed: Boolean = {
          if (_getShortField(4) != 4) false
          else _pointerFieldIsNull(0)
        }
        def removalFailed: Boolean = {
          if (_getShortField(4) != 5) false
          else _pointerFieldIsNull(0)
        }
        def modifyFailed: Boolean = {
          if (_getShortField(4) != 6) false
          else _pointerFieldIsNull(0)
        }
      }
    }
    class BuilderImpl(_segment: org.katis.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
      private[ClientMessage] def initial: ClientMessage#Initial#Builder = {
        ClientMessage.Initial.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }
      private[ClientMessage] def added: org.katis.capnproto.example.todo.Todo#Builder = {
        _getPointerField[org.katis.capnproto.example.todo.Todo](0)
      }
      def added_=(value: org.katis.capnproto.example.todo.Todo#Reader): Unit = {
        _setShortField(4, 1)
        _setPointerField[org.katis.capnproto.example.todo.Todo](0, value)
      }
      private[ClientMessage] def removed: org.katis.capnproto.example.todo.Todo#Builder = {
        _getPointerField[org.katis.capnproto.example.todo.Todo](0)
      }
      def removed_=(value: org.katis.capnproto.example.todo.Todo#Reader): Unit = {
        _setShortField(4, 2)
        _setPointerField[org.katis.capnproto.example.todo.Todo](0, value)
      }
      private[ClientMessage] def modified: org.katis.capnproto.example.todo.Todo#Builder = {
        _getPointerField[org.katis.capnproto.example.todo.Todo](0)
      }
      def modified_=(value: org.katis.capnproto.example.todo.Todo#Reader): Unit = {
        _setShortField(4, 3)
        _setPointerField[org.katis.capnproto.example.todo.Todo](0, value)
      }
      private[ClientMessage] def addFailed: org.katis.capnproto.example.todo.Todo#Builder = {
        _getPointerField[org.katis.capnproto.example.todo.Todo](0)
      }
      def addFailed_=(value: org.katis.capnproto.example.todo.Todo#Reader): Unit = {
        _setShortField(4, 4)
        _setPointerField[org.katis.capnproto.example.todo.Todo](0, value)
      }
      private[ClientMessage] def removalFailed: org.katis.capnproto.example.todo.Todo#Builder = {
        _getPointerField[org.katis.capnproto.example.todo.Todo](0)
      }
      def removalFailed_=(value: org.katis.capnproto.example.todo.Todo#Reader): Unit = {
        _setShortField(4, 5)
        _setPointerField[org.katis.capnproto.example.todo.Todo](0, value)
      }
      private[ClientMessage] def modifyFailed: org.katis.capnproto.example.todo.Todo#Builder = {
        _getPointerField[org.katis.capnproto.example.todo.Todo](0)
      }
      def modifyFailed_=(value: org.katis.capnproto.example.todo.Todo#Reader): Unit = {
        _setShortField(4, 6)
        _setPointerField[org.katis.capnproto.example.todo.Todo](0, value)
      }
      private[ClientMessage] def _whichIndex: Short = _getShortField(4)
      object has {
        def added: Boolean = {
          if (_getShortField(4) != 1) false
          else _pointerFieldIsNull(0)
        }
        def removed: Boolean = {
          if (_getShortField(4) != 2) false
          else _pointerFieldIsNull(0)
        }
        def modified: Boolean = {
          if (_getShortField(4) != 3) false
          else _pointerFieldIsNull(0)
        }
        def addFailed: Boolean = {
          if (_getShortField(4) != 4) false
          else _pointerFieldIsNull(0)
        }
        def removalFailed: Boolean = {
          if (_getShortField(4) != 5) false
          else _pointerFieldIsNull(0)
        }
        def modifyFailed: Boolean = {
          if (_getShortField(4) != 6) false
          else _pointerFieldIsNull(0)
        }
      }
      object init {
        def initial(): org.katis.capnproto.example.todo.ClientMessage.Initial#Builder = {
          _setShortField(4, 0)
          _setLongField(0, 0)
          _clearPointerField(0)
          org.katis.capnproto.example.todo.ClientMessage.Initial.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
        }
        def added(): org.katis.capnproto.example.todo.Todo#Builder = {
          _setShortField(4, 1)
          _initPointerField[org.katis.capnproto.example.todo.Todo](0, 0)
        }
        def removed(): org.katis.capnproto.example.todo.Todo#Builder = {
          _setShortField(4, 2)
          _initPointerField[org.katis.capnproto.example.todo.Todo](0, 0)
        }
        def modified(): org.katis.capnproto.example.todo.Todo#Builder = {
          _setShortField(4, 3)
          _initPointerField[org.katis.capnproto.example.todo.Todo](0, 0)
        }
        def addFailed(): org.katis.capnproto.example.todo.Todo#Builder = {
          _setShortField(4, 4)
          _initPointerField[org.katis.capnproto.example.todo.Todo](0, 0)
        }
        def removalFailed(): org.katis.capnproto.example.todo.Todo#Builder = {
          _setShortField(4, 5)
          _initPointerField[org.katis.capnproto.example.todo.Todo](0, 0)
        }
        def modifyFailed(): org.katis.capnproto.example.todo.Todo#Builder = {
          _setShortField(4, 6)
          _initPointerField[org.katis.capnproto.example.todo.Todo](0, 0)
        }
      }
    }
    object Added {
      def unapply(value: ClientMessage#Reader): Option[org.katis.capnproto.example.todo.Todo#Reader] = {
        if (value._whichIndex == 1) Some(value.added) else None
      }
      def unapply(value: ClientMessage#Builder): Option[org.katis.capnproto.example.todo.Todo#Builder] = {
        if (value._whichIndex == 1) Some(value.added) else None
      }
    }
    object Removed {
      def unapply(value: ClientMessage#Reader): Option[org.katis.capnproto.example.todo.Todo#Reader] = {
        if (value._whichIndex == 2) Some(value.removed) else None
      }
      def unapply(value: ClientMessage#Builder): Option[org.katis.capnproto.example.todo.Todo#Builder] = {
        if (value._whichIndex == 2) Some(value.removed) else None
      }
    }
    object Modified {
      def unapply(value: ClientMessage#Reader): Option[org.katis.capnproto.example.todo.Todo#Reader] = {
        if (value._whichIndex == 3) Some(value.modified) else None
      }
      def unapply(value: ClientMessage#Builder): Option[org.katis.capnproto.example.todo.Todo#Builder] = {
        if (value._whichIndex == 3) Some(value.modified) else None
      }
    }
    object AddFailed {
      def unapply(value: ClientMessage#Reader): Option[org.katis.capnproto.example.todo.Todo#Reader] = {
        if (value._whichIndex == 4) Some(value.addFailed) else None
      }
      def unapply(value: ClientMessage#Builder): Option[org.katis.capnproto.example.todo.Todo#Builder] = {
        if (value._whichIndex == 4) Some(value.addFailed) else None
      }
    }
    object RemovalFailed {
      def unapply(value: ClientMessage#Reader): Option[org.katis.capnproto.example.todo.Todo#Reader] = {
        if (value._whichIndex == 5) Some(value.removalFailed) else None
      }
      def unapply(value: ClientMessage#Builder): Option[org.katis.capnproto.example.todo.Todo#Builder] = {
        if (value._whichIndex == 5) Some(value.removalFailed) else None
      }
    }
    object ModifyFailed {
      def unapply(value: ClientMessage#Reader): Option[org.katis.capnproto.example.todo.Todo#Reader] = {
        if (value._whichIndex == 6) Some(value.modifyFailed) else None
      }
      def unapply(value: ClientMessage#Builder): Option[org.katis.capnproto.example.todo.Todo#Builder] = {
        if (value._whichIndex == 6) Some(value.modifyFailed) else None
      }
    }

    object Initial extends Initial
    sealed class Initial private() extends org.katis.capnproto.runtime.Struct { 
      val typeId: Long = -8025231674297101893L
      override val structSize: org.katis.capnproto.runtime.StructSize = new org.katis.capnproto.runtime.StructSize(2, 1)

      override type Reader = ReaderImpl
      override type Builder = BuilderImpl

      override val Builder: (org.katis.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (org.katis.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def unapply(value: ClientMessage#Reader): Option[ClientMessage#Initial#Reader] = {
        if (value._whichIndex == 0) Some(value.initial) else None
      }
      def unapply(value: ClientMessage#Builder): Option[ClientMessage#Initial#Builder] = {
        if (value._whichIndex == 0) Some(value.initial) else None
      }
      class ReaderImpl(_segment: org.katis.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
        def clientId: Long = {
          this._getLongField(0)
        }
        def todos: org.katis.capnproto.runtime.StructList[org.katis.capnproto.example.todo.Todo]#Reader = {
          _getPointerField[org.katis.capnproto.runtime.StructList[org.katis.capnproto.example.todo.Todo]](0)
        }
        object has {
          def todos: Boolean = {
            _pointerFieldIsNull(0)
          }
        }
      }
      class BuilderImpl(_segment: org.katis.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        def clientId: Long = {
          this._getLongField(0)
        }
        def clientId_=(value: Long): Unit = {
          _setLongField(0, value)
        }
        def todos: org.katis.capnproto.runtime.StructList[org.katis.capnproto.example.todo.Todo]#Builder = {
          _getPointerField[org.katis.capnproto.runtime.StructList[org.katis.capnproto.example.todo.Todo]](0)
        }
        def todos_=(value: org.katis.capnproto.runtime.StructList[org.katis.capnproto.example.todo.Todo]#Reader): Unit = {
          _setPointerField[org.katis.capnproto.runtime.StructList[org.katis.capnproto.example.todo.Todo]](0, value)
        }
        object has {
          def todos: Boolean = {
            _pointerFieldIsNull(0)
          }
        }
        object init {
          def todos(size: Int): org.katis.capnproto.runtime.StructList[org.katis.capnproto.example.todo.Todo]#Builder = {
            _initPointerField[org.katis.capnproto.runtime.StructList[org.katis.capnproto.example.todo.Todo]](0, size)
          }
        }
      }
    }
  }

  object ServerMessage extends ServerMessage
  sealed class ServerMessage private() extends org.katis.capnproto.runtime.Struct { 
    val typeId: Long = -212057696756897572L
    override val structSize: org.katis.capnproto.runtime.StructSize = new org.katis.capnproto.runtime.StructSize(2, 1)

    override type Reader = ReaderImpl
    override type Builder = BuilderImpl

    override val Builder: (org.katis.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (org.katis.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    class ReaderImpl(_segment: org.katis.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
      def clientId: Long = {
        this._getLongField(0)
      }
      private[ServerMessage] def add: org.katis.capnproto.example.todo.Todo#Reader = {
        _getPointerField[org.katis.capnproto.example.todo.Todo](0)
      }
      private[ServerMessage] def remove: org.katis.capnproto.example.todo.Todo#Reader = {
        _getPointerField[org.katis.capnproto.example.todo.Todo](0)
      }
      private[ServerMessage] def modify: org.katis.capnproto.example.todo.Todo#Reader = {
        _getPointerField[org.katis.capnproto.example.todo.Todo](0)
      }
      private[ServerMessage] def _whichIndex: Short = _getShortField(4)
      object has {
        def add: Boolean = {
          if (_getShortField(4) != 0) false
          else _pointerFieldIsNull(0)
        }
        def remove: Boolean = {
          if (_getShortField(4) != 1) false
          else _pointerFieldIsNull(0)
        }
        def modify: Boolean = {
          if (_getShortField(4) != 2) false
          else _pointerFieldIsNull(0)
        }
      }
    }
    class BuilderImpl(_segment: org.katis.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
      def clientId: Long = {
        this._getLongField(0)
      }
      def clientId_=(value: Long): Unit = {
        _setLongField(0, value)
      }
      private[ServerMessage] def add: org.katis.capnproto.example.todo.Todo#Builder = {
        _getPointerField[org.katis.capnproto.example.todo.Todo](0)
      }
      def add_=(value: org.katis.capnproto.example.todo.Todo#Reader): Unit = {
        _setShortField(4, 0)
        _setPointerField[org.katis.capnproto.example.todo.Todo](0, value)
      }
      private[ServerMessage] def remove: org.katis.capnproto.example.todo.Todo#Builder = {
        _getPointerField[org.katis.capnproto.example.todo.Todo](0)
      }
      def remove_=(value: org.katis.capnproto.example.todo.Todo#Reader): Unit = {
        _setShortField(4, 1)
        _setPointerField[org.katis.capnproto.example.todo.Todo](0, value)
      }
      private[ServerMessage] def modify: org.katis.capnproto.example.todo.Todo#Builder = {
        _getPointerField[org.katis.capnproto.example.todo.Todo](0)
      }
      def modify_=(value: org.katis.capnproto.example.todo.Todo#Reader): Unit = {
        _setShortField(4, 2)
        _setPointerField[org.katis.capnproto.example.todo.Todo](0, value)
      }
      private[ServerMessage] def _whichIndex: Short = _getShortField(4)
      object has {
        def add: Boolean = {
          if (_getShortField(4) != 0) false
          else _pointerFieldIsNull(0)
        }
        def remove: Boolean = {
          if (_getShortField(4) != 1) false
          else _pointerFieldIsNull(0)
        }
        def modify: Boolean = {
          if (_getShortField(4) != 2) false
          else _pointerFieldIsNull(0)
        }
      }
      object init {
        def add(): org.katis.capnproto.example.todo.Todo#Builder = {
          _setShortField(4, 0)
          _initPointerField[org.katis.capnproto.example.todo.Todo](0, 0)
        }
        def remove(): org.katis.capnproto.example.todo.Todo#Builder = {
          _setShortField(4, 1)
          _initPointerField[org.katis.capnproto.example.todo.Todo](0, 0)
        }
        def modify(): org.katis.capnproto.example.todo.Todo#Builder = {
          _setShortField(4, 2)
          _initPointerField[org.katis.capnproto.example.todo.Todo](0, 0)
        }
      }
    }
    object Add {
      def unapply(value: ServerMessage#Reader): Option[org.katis.capnproto.example.todo.Todo#Reader] = {
        if (value._whichIndex == 0) Some(value.add) else None
      }
      def unapply(value: ServerMessage#Builder): Option[org.katis.capnproto.example.todo.Todo#Builder] = {
        if (value._whichIndex == 0) Some(value.add) else None
      }
    }
    object Remove {
      def unapply(value: ServerMessage#Reader): Option[org.katis.capnproto.example.todo.Todo#Reader] = {
        if (value._whichIndex == 1) Some(value.remove) else None
      }
      def unapply(value: ServerMessage#Builder): Option[org.katis.capnproto.example.todo.Todo#Builder] = {
        if (value._whichIndex == 1) Some(value.remove) else None
      }
    }
    object Modify {
      def unapply(value: ServerMessage#Reader): Option[org.katis.capnproto.example.todo.Todo#Reader] = {
        if (value._whichIndex == 2) Some(value.modify) else None
      }
      def unapply(value: ServerMessage#Builder): Option[org.katis.capnproto.example.todo.Todo#Builder] = {
        if (value._whichIndex == 2) Some(value.modify) else None
      }
    }
  }

  object Todo extends Todo
  sealed class Todo private() extends org.katis.capnproto.runtime.Struct { 
    val typeId: Long = -9191580955837035021L
    override val structSize: org.katis.capnproto.runtime.StructSize = new org.katis.capnproto.runtime.StructSize(1, 2)

    override type Reader = ReaderImpl
    override type Builder = BuilderImpl

    override val Builder: (org.katis.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (org.katis.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    class ReaderImpl(_segment: org.katis.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
      def id: Long = {
        this._getLongField(0)
      }
      def contents: org.katis.capnproto.runtime.Text#Reader = {
        _getPointerField[org.katis.capnproto.runtime.Text](0)
      }
      def created: org.katis.capnproto.runtime.Text#Reader = {
        _getPointerField[org.katis.capnproto.runtime.Text](1)
      }
      object has {
        def contents: Boolean = {
          _pointerFieldIsNull(0)
        }
        def created: Boolean = {
          _pointerFieldIsNull(1)
        }
      }
    }
    class BuilderImpl(_segment: org.katis.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
      def id: Long = {
        this._getLongField(0)
      }
      def id_=(value: Long): Unit = {
        _setLongField(0, value)
      }
      def contents: org.katis.capnproto.runtime.Text#Builder = {
        _getPointerField[org.katis.capnproto.runtime.Text](0)
      }
      def contents_=(value: org.katis.capnproto.runtime.Text#Reader): Unit = {
        _setPointerField[org.katis.capnproto.runtime.Text](0, value)
      }
      def contents_=(value: String): Unit = {
        _setPointerField[org.katis.capnproto.runtime.Text](0, org.katis.capnproto.runtime.Text.Reader(value))
      }
      def created: org.katis.capnproto.runtime.Text#Builder = {
        _getPointerField[org.katis.capnproto.runtime.Text](1)
      }
      def created_=(value: org.katis.capnproto.runtime.Text#Reader): Unit = {
        _setPointerField[org.katis.capnproto.runtime.Text](1, value)
      }
      def created_=(value: String): Unit = {
        _setPointerField[org.katis.capnproto.runtime.Text](1, org.katis.capnproto.runtime.Text.Reader(value))
      }
      object has {
        def contents: Boolean = {
          _pointerFieldIsNull(0)
        }
        def created: Boolean = {
          _pointerFieldIsNull(1)
        }
      }
      object init {
        def contents(size: Int): org.katis.capnproto.runtime.Text#Builder = {
          _initPointerField[org.katis.capnproto.runtime.Text](0, size)
        }
        def created(size: Int): org.katis.capnproto.runtime.Text#Builder = {
          _initPointerField[org.katis.capnproto.runtime.Text](1, size)
        }
      }
    }
  }
}
