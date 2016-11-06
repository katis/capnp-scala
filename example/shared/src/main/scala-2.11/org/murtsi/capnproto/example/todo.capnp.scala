// GENERATED CAP'N PROTO FILE, DO NOT EDIT
package org.murtsi.capnproto.example

import org.murtsi.capnproto.runtime.implicits._

object todo {
  // START ClientMessage implicits
  implicit val ClientMessage$$HasTypeId = new org.murtsi.capnproto.runtime.HasTypeId[ClientMessage] {
    def typeId: Long = -57167328279103122L
  }
  implicit val ClientMessage$$HasStructSize = new org.murtsi.capnproto.runtime.HasStructSize[ClientMessage] {
    val structSize = new org.murtsi.capnproto.runtime.StructSize(2, 1)
  }
  implicit val ClientMessage$$StructFromSegment = new org.murtsi.capnproto.runtime.StructFromSegment[ClientMessage] {
    def readerFromSegment(segment: org.murtsi.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): ClientMessage#Reader = {
      ClientMessage.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.murtsi.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): ClientMessage#Builder = {
      ClientMessage.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END ClientMessage implicits
  // START ClientMessage#Initial implicits
  implicit val ClientMessage$Initial$$HasTypeId = new org.murtsi.capnproto.runtime.HasTypeId[ClientMessage#Initial] {
    def typeId: Long = -8025231674297101893L
  }
  implicit val ClientMessage$Initial$$HasStructSize = new org.murtsi.capnproto.runtime.HasStructSize[ClientMessage#Initial] {
    val structSize = new org.murtsi.capnproto.runtime.StructSize(2, 1)
  }
  implicit val ClientMessage$Initial$$StructFromSegment = new org.murtsi.capnproto.runtime.StructFromSegment[ClientMessage#Initial] {
    def readerFromSegment(segment: org.murtsi.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): ClientMessage#Initial#Reader = {
      ClientMessage.Initial.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.murtsi.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): ClientMessage#Initial#Builder = {
      ClientMessage.Initial.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END ClientMessage#Initial implicits
  // START ServerMessage implicits
  implicit val ServerMessage$$HasTypeId = new org.murtsi.capnproto.runtime.HasTypeId[ServerMessage] {
    def typeId: Long = -212057696756897572L
  }
  implicit val ServerMessage$$HasStructSize = new org.murtsi.capnproto.runtime.HasStructSize[ServerMessage] {
    val structSize = new org.murtsi.capnproto.runtime.StructSize(2, 1)
  }
  implicit val ServerMessage$$StructFromSegment = new org.murtsi.capnproto.runtime.StructFromSegment[ServerMessage] {
    def readerFromSegment(segment: org.murtsi.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): ServerMessage#Reader = {
      ServerMessage.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.murtsi.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): ServerMessage#Builder = {
      ServerMessage.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END ServerMessage implicits
  // START Todo implicits
  implicit val Todo$$HasTypeId = new org.murtsi.capnproto.runtime.HasTypeId[Todo] {
    def typeId: Long = -9191580955837035021L
  }
  implicit val Todo$$HasStructSize = new org.murtsi.capnproto.runtime.HasStructSize[Todo] {
    val structSize = new org.murtsi.capnproto.runtime.StructSize(1, 2)
  }
  implicit val Todo$$StructFromSegment = new org.murtsi.capnproto.runtime.StructFromSegment[Todo] {
    def readerFromSegment(segment: org.murtsi.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): Todo#Reader = {
      Todo.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.murtsi.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): Todo#Builder = {
      Todo.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END Todo implicits

  object ClientMessage extends ClientMessage
  sealed class ClientMessage private() extends org.murtsi.capnproto.runtime.Struct { 
    val typeId: Long = -57167328279103122L
    override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(2, 1)

    override type Reader = ReaderImpl
    override type Builder = BuilderImpl

    override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
      private[ClientMessage] def initial: ClientMessage#Initial#Reader = {
        ClientMessage.Initial.Reader(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit)
      }
      private[ClientMessage] def added: Option[org.murtsi.capnproto.example.todo.Todo#Reader] = {
        _getPointerFieldOption[org.murtsi.capnproto.example.todo.Todo](0)
      }
      private[ClientMessage] def removed: Option[org.murtsi.capnproto.example.todo.Todo#Reader] = {
        _getPointerFieldOption[org.murtsi.capnproto.example.todo.Todo](0)
      }
      private[ClientMessage] def modified: Option[org.murtsi.capnproto.example.todo.Todo#Reader] = {
        _getPointerFieldOption[org.murtsi.capnproto.example.todo.Todo](0)
      }
      private[ClientMessage] def addFailed: Option[org.murtsi.capnproto.example.todo.Todo#Reader] = {
        _getPointerFieldOption[org.murtsi.capnproto.example.todo.Todo](0)
      }
      private[ClientMessage] def removalFailed: Option[org.murtsi.capnproto.example.todo.Todo#Reader] = {
        _getPointerFieldOption[org.murtsi.capnproto.example.todo.Todo](0)
      }
      private[ClientMessage] def modifyFailed: Option[org.murtsi.capnproto.example.todo.Todo#Reader] = {
        _getPointerFieldOption[org.murtsi.capnproto.example.todo.Todo](0)
      }
      private[ClientMessage] def _whichIndex: Short = _getShortField(4)
    }
    class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
      private[ClientMessage] def initial: ClientMessage#Initial#Builder = {
        ClientMessage.Initial.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }
      def initInitial(): org.murtsi.capnproto.example.todo.ClientMessage.Initial#Builder = {
        _setShortField(4, 0)
        _setLongField(0, 0)
        _clearPointerField(0)
        org.murtsi.capnproto.example.todo.ClientMessage.Initial.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }
      private[ClientMessage] def added: Option[org.murtsi.capnproto.example.todo.Todo#Builder] = {
        _getPointerFieldOption[org.murtsi.capnproto.example.todo.Todo](0)
      }
      def added_=(value: org.murtsi.capnproto.example.todo.Todo#Reader): Unit = {
        _setShortField(4, 1)
        _setPointerField[org.murtsi.capnproto.example.todo.Todo](0, value)
      }
      def initAdded(): org.murtsi.capnproto.example.todo.Todo#Builder = {
        _setShortField(4, 1)
        _initPointerField[org.murtsi.capnproto.example.todo.Todo](0, 0)
      }
      private[ClientMessage] def removed: Option[org.murtsi.capnproto.example.todo.Todo#Builder] = {
        _getPointerFieldOption[org.murtsi.capnproto.example.todo.Todo](0)
      }
      def removed_=(value: org.murtsi.capnproto.example.todo.Todo#Reader): Unit = {
        _setShortField(4, 2)
        _setPointerField[org.murtsi.capnproto.example.todo.Todo](0, value)
      }
      def initRemoved(): org.murtsi.capnproto.example.todo.Todo#Builder = {
        _setShortField(4, 2)
        _initPointerField[org.murtsi.capnproto.example.todo.Todo](0, 0)
      }
      private[ClientMessage] def modified: Option[org.murtsi.capnproto.example.todo.Todo#Builder] = {
        _getPointerFieldOption[org.murtsi.capnproto.example.todo.Todo](0)
      }
      def modified_=(value: org.murtsi.capnproto.example.todo.Todo#Reader): Unit = {
        _setShortField(4, 3)
        _setPointerField[org.murtsi.capnproto.example.todo.Todo](0, value)
      }
      def initModified(): org.murtsi.capnproto.example.todo.Todo#Builder = {
        _setShortField(4, 3)
        _initPointerField[org.murtsi.capnproto.example.todo.Todo](0, 0)
      }
      private[ClientMessage] def addFailed: Option[org.murtsi.capnproto.example.todo.Todo#Builder] = {
        _getPointerFieldOption[org.murtsi.capnproto.example.todo.Todo](0)
      }
      def addFailed_=(value: org.murtsi.capnproto.example.todo.Todo#Reader): Unit = {
        _setShortField(4, 4)
        _setPointerField[org.murtsi.capnproto.example.todo.Todo](0, value)
      }
      def initAddFailed(): org.murtsi.capnproto.example.todo.Todo#Builder = {
        _setShortField(4, 4)
        _initPointerField[org.murtsi.capnproto.example.todo.Todo](0, 0)
      }
      private[ClientMessage] def removalFailed: Option[org.murtsi.capnproto.example.todo.Todo#Builder] = {
        _getPointerFieldOption[org.murtsi.capnproto.example.todo.Todo](0)
      }
      def removalFailed_=(value: org.murtsi.capnproto.example.todo.Todo#Reader): Unit = {
        _setShortField(4, 5)
        _setPointerField[org.murtsi.capnproto.example.todo.Todo](0, value)
      }
      def initRemovalFailed(): org.murtsi.capnproto.example.todo.Todo#Builder = {
        _setShortField(4, 5)
        _initPointerField[org.murtsi.capnproto.example.todo.Todo](0, 0)
      }
      private[ClientMessage] def modifyFailed: Option[org.murtsi.capnproto.example.todo.Todo#Builder] = {
        _getPointerFieldOption[org.murtsi.capnproto.example.todo.Todo](0)
      }
      def modifyFailed_=(value: org.murtsi.capnproto.example.todo.Todo#Reader): Unit = {
        _setShortField(4, 6)
        _setPointerField[org.murtsi.capnproto.example.todo.Todo](0, value)
      }
      def initModifyFailed(): org.murtsi.capnproto.example.todo.Todo#Builder = {
        _setShortField(4, 6)
        _initPointerField[org.murtsi.capnproto.example.todo.Todo](0, 0)
      }
      private[ClientMessage] def _whichIndex: Short = _getShortField(4)
    }
    object Added {
      def unapply(value: ClientMessage#Reader): Option[org.murtsi.capnproto.example.todo.Todo#Reader] = {
        if (value._whichIndex == 1) value.added else None
      }
      def unapply(value: ClientMessage#Builder): Option[org.murtsi.capnproto.example.todo.Todo#Builder] = {
        if (value._whichIndex == 1) value.added else None
      }
    }
    object Removed {
      def unapply(value: ClientMessage#Reader): Option[org.murtsi.capnproto.example.todo.Todo#Reader] = {
        if (value._whichIndex == 2) value.removed else None
      }
      def unapply(value: ClientMessage#Builder): Option[org.murtsi.capnproto.example.todo.Todo#Builder] = {
        if (value._whichIndex == 2) value.removed else None
      }
    }
    object Modified {
      def unapply(value: ClientMessage#Reader): Option[org.murtsi.capnproto.example.todo.Todo#Reader] = {
        if (value._whichIndex == 3) value.modified else None
      }
      def unapply(value: ClientMessage#Builder): Option[org.murtsi.capnproto.example.todo.Todo#Builder] = {
        if (value._whichIndex == 3) value.modified else None
      }
    }
    object AddFailed {
      def unapply(value: ClientMessage#Reader): Option[org.murtsi.capnproto.example.todo.Todo#Reader] = {
        if (value._whichIndex == 4) value.addFailed else None
      }
      def unapply(value: ClientMessage#Builder): Option[org.murtsi.capnproto.example.todo.Todo#Builder] = {
        if (value._whichIndex == 4) value.addFailed else None
      }
    }
    object RemovalFailed {
      def unapply(value: ClientMessage#Reader): Option[org.murtsi.capnproto.example.todo.Todo#Reader] = {
        if (value._whichIndex == 5) value.removalFailed else None
      }
      def unapply(value: ClientMessage#Builder): Option[org.murtsi.capnproto.example.todo.Todo#Builder] = {
        if (value._whichIndex == 5) value.removalFailed else None
      }
    }
    object ModifyFailed {
      def unapply(value: ClientMessage#Reader): Option[org.murtsi.capnproto.example.todo.Todo#Reader] = {
        if (value._whichIndex == 6) value.modifyFailed else None
      }
      def unapply(value: ClientMessage#Builder): Option[org.murtsi.capnproto.example.todo.Todo#Builder] = {
        if (value._whichIndex == 6) value.modifyFailed else None
      }
    }

    object Initial extends Initial
    sealed class Initial private() extends org.murtsi.capnproto.runtime.Struct { 
      val typeId: Long = -8025231674297101893L
      override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(2, 1)

      override type Reader = ReaderImpl
      override type Builder = BuilderImpl

      override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def unapply(value: ClientMessage#Reader): Option[ClientMessage#Initial#Reader] = {
        if (value._whichIndex == 0) Some(value.initial) else None
      }
      def unapply(value: ClientMessage#Builder): Option[ClientMessage#Initial#Builder] = {
        if (value._whichIndex == 0) Some(value.initial) else None
      }
      class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
        def clientId: Long = {
          this._getLongField(0)
        }
        def todos: Option[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.example.todo.Todo]#Reader] = {
          _getPointerFieldOption[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.example.todo.Todo]](0)
        }
      }
      class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        def clientId: Long = {
          this._getLongField(0)
        }
        def clientId_=(value: Long): Unit = {
          _setLongField(0, value)
        }
        def todos: Option[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.example.todo.Todo]#Builder] = {
          _getPointerFieldOption[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.example.todo.Todo]](0)
        }
        def todos_=(value: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.example.todo.Todo]#Reader): Unit = {
          _setPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.example.todo.Todo]](0, value)
        }
        def initTodos(size: Int): org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.example.todo.Todo]#Builder = {
          _initPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.example.todo.Todo]](0, size)
        }
      }
    }
  }

  object ServerMessage extends ServerMessage
  sealed class ServerMessage private() extends org.murtsi.capnproto.runtime.Struct { 
    val typeId: Long = -212057696756897572L
    override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(2, 1)

    override type Reader = ReaderImpl
    override type Builder = BuilderImpl

    override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
      def clientId: Long = {
        this._getLongField(0)
      }
      private[ServerMessage] def add: Option[org.murtsi.capnproto.example.todo.Todo#Reader] = {
        _getPointerFieldOption[org.murtsi.capnproto.example.todo.Todo](0)
      }
      private[ServerMessage] def remove: Option[org.murtsi.capnproto.example.todo.Todo#Reader] = {
        _getPointerFieldOption[org.murtsi.capnproto.example.todo.Todo](0)
      }
      private[ServerMessage] def modify: Option[org.murtsi.capnproto.example.todo.Todo#Reader] = {
        _getPointerFieldOption[org.murtsi.capnproto.example.todo.Todo](0)
      }
      private[ServerMessage] def _whichIndex: Short = _getShortField(4)
    }
    class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
      def clientId: Long = {
        this._getLongField(0)
      }
      def clientId_=(value: Long): Unit = {
        _setLongField(0, value)
      }
      private[ServerMessage] def add: Option[org.murtsi.capnproto.example.todo.Todo#Builder] = {
        _getPointerFieldOption[org.murtsi.capnproto.example.todo.Todo](0)
      }
      def add_=(value: org.murtsi.capnproto.example.todo.Todo#Reader): Unit = {
        _setShortField(4, 0)
        _setPointerField[org.murtsi.capnproto.example.todo.Todo](0, value)
      }
      def initAdd(): org.murtsi.capnproto.example.todo.Todo#Builder = {
        _setShortField(4, 0)
        _initPointerField[org.murtsi.capnproto.example.todo.Todo](0, 0)
      }
      private[ServerMessage] def remove: Option[org.murtsi.capnproto.example.todo.Todo#Builder] = {
        _getPointerFieldOption[org.murtsi.capnproto.example.todo.Todo](0)
      }
      def remove_=(value: org.murtsi.capnproto.example.todo.Todo#Reader): Unit = {
        _setShortField(4, 1)
        _setPointerField[org.murtsi.capnproto.example.todo.Todo](0, value)
      }
      def initRemove(): org.murtsi.capnproto.example.todo.Todo#Builder = {
        _setShortField(4, 1)
        _initPointerField[org.murtsi.capnproto.example.todo.Todo](0, 0)
      }
      private[ServerMessage] def modify: Option[org.murtsi.capnproto.example.todo.Todo#Builder] = {
        _getPointerFieldOption[org.murtsi.capnproto.example.todo.Todo](0)
      }
      def modify_=(value: org.murtsi.capnproto.example.todo.Todo#Reader): Unit = {
        _setShortField(4, 2)
        _setPointerField[org.murtsi.capnproto.example.todo.Todo](0, value)
      }
      def initModify(): org.murtsi.capnproto.example.todo.Todo#Builder = {
        _setShortField(4, 2)
        _initPointerField[org.murtsi.capnproto.example.todo.Todo](0, 0)
      }
      private[ServerMessage] def _whichIndex: Short = _getShortField(4)
    }
    object Add {
      def unapply(value: ServerMessage#Reader): Option[org.murtsi.capnproto.example.todo.Todo#Reader] = {
        if (value._whichIndex == 0) value.add else None
      }
      def unapply(value: ServerMessage#Builder): Option[org.murtsi.capnproto.example.todo.Todo#Builder] = {
        if (value._whichIndex == 0) value.add else None
      }
    }
    object Remove {
      def unapply(value: ServerMessage#Reader): Option[org.murtsi.capnproto.example.todo.Todo#Reader] = {
        if (value._whichIndex == 1) value.remove else None
      }
      def unapply(value: ServerMessage#Builder): Option[org.murtsi.capnproto.example.todo.Todo#Builder] = {
        if (value._whichIndex == 1) value.remove else None
      }
    }
    object Modify {
      def unapply(value: ServerMessage#Reader): Option[org.murtsi.capnproto.example.todo.Todo#Reader] = {
        if (value._whichIndex == 2) value.modify else None
      }
      def unapply(value: ServerMessage#Builder): Option[org.murtsi.capnproto.example.todo.Todo#Builder] = {
        if (value._whichIndex == 2) value.modify else None
      }
    }
  }

  object Todo extends Todo
  sealed class Todo private() extends org.murtsi.capnproto.runtime.Struct { 
    val typeId: Long = -9191580955837035021L
    override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(1, 2)

    override type Reader = ReaderImpl
    override type Builder = BuilderImpl

    override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
      def id: Long = {
        this._getLongField(0)
      }
      def contents: Option[org.murtsi.capnproto.runtime.Text#Reader] = {
        _getPointerFieldOption[org.murtsi.capnproto.runtime.Text](0)
      }
      def created: Option[org.murtsi.capnproto.runtime.Text#Reader] = {
        _getPointerFieldOption[org.murtsi.capnproto.runtime.Text](1)
      }
    }
    class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
      def id: Long = {
        this._getLongField(0)
      }
      def id_=(value: Long): Unit = {
        _setLongField(0, value)
      }
      def contents: Option[org.murtsi.capnproto.runtime.Text#Builder] = {
        _getPointerFieldOption[org.murtsi.capnproto.runtime.Text](0)
      }
      def contents_=(value: org.murtsi.capnproto.runtime.Text#Reader): Unit = {
        _setPointerField[org.murtsi.capnproto.runtime.Text](0, value)
      }
      def contents_=(value: String): Unit = {
        _setPointerField[org.murtsi.capnproto.runtime.Text](0, org.murtsi.capnproto.runtime.Text.Reader(value))
      }
      def initContents(size: Int): org.murtsi.capnproto.runtime.Text#Builder = {
        _initPointerField[org.murtsi.capnproto.runtime.Text](0, size)
      }
      def created: Option[org.murtsi.capnproto.runtime.Text#Builder] = {
        _getPointerFieldOption[org.murtsi.capnproto.runtime.Text](1)
      }
      def created_=(value: org.murtsi.capnproto.runtime.Text#Reader): Unit = {
        _setPointerField[org.murtsi.capnproto.runtime.Text](1, value)
      }
      def created_=(value: String): Unit = {
        _setPointerField[org.murtsi.capnproto.runtime.Text](1, org.murtsi.capnproto.runtime.Text.Reader(value))
      }
      def initCreated(size: Int): org.murtsi.capnproto.runtime.Text#Builder = {
        _initPointerField[org.murtsi.capnproto.runtime.Text](1, size)
      }
    }
  }
}
