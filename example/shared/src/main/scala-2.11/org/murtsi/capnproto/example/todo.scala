package org.murtsi.capnproto.example


object ClientMessage extends org.murtsi.capnproto.runtime.Struct { 
    val typeId: Long = -57167328279103122L
    override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(2, 1)

    override type Reader = ReaderImpl
    override type Builder = BuilderImpl

    override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
        private[ClientMessage] def initial: org.murtsi.capnproto.example.ClientMessage.Initial.Reader = {
            org.murtsi.capnproto.example.ClientMessage.Initial.Reader(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit)
        }
        private[ClientMessage] def added: Option[org.murtsi.capnproto.example.Todo.Reader] = {
            _getPointerFieldOption(org.murtsi.capnproto.example.Todo, 0)
        }
        private[ClientMessage] def removed: Option[org.murtsi.capnproto.example.Todo.Reader] = {
            _getPointerFieldOption(org.murtsi.capnproto.example.Todo, 0)
        }
        private[ClientMessage] def modified: Option[org.murtsi.capnproto.example.Todo.Reader] = {
            _getPointerFieldOption(org.murtsi.capnproto.example.Todo, 0)
        }
        private[ClientMessage] def addFailed: Option[org.murtsi.capnproto.example.Todo.Reader] = {
            _getPointerFieldOption(org.murtsi.capnproto.example.Todo, 0)
        }
        private[ClientMessage] def removalFailed: Option[org.murtsi.capnproto.example.Todo.Reader] = {
            _getPointerFieldOption(org.murtsi.capnproto.example.Todo, 0)
        }
        private[ClientMessage] def modifyFailed: Option[org.murtsi.capnproto.example.Todo.Reader] = {
            _getPointerFieldOption(org.murtsi.capnproto.example.Todo, 0)
        }
        private[ClientMessage] def _whichIndex: Short = _getShortField(4)
    }
    class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        private[ClientMessage] def initial: org.murtsi.capnproto.example.ClientMessage.Initial.Builder = {
            org.murtsi.capnproto.example.ClientMessage.Initial.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
        }
        def initInitial(): org.murtsi.capnproto.example.ClientMessage.Initial.Builder = {
            _setShortField(4, 0)
            _setLongField(0, 0)
            _clearPointerField(0)
            org.murtsi.capnproto.example.ClientMessage.Initial.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
        }
        private[ClientMessage] def added: Option[org.murtsi.capnproto.example.Todo.Builder] = {
            _getPointerFieldOption(org.murtsi.capnproto.example.Todo, 0)
        }
        def added_=(value: org.murtsi.capnproto.example.Todo.Reader): Unit = {
            _setShortField(4, 1)
            _setPointerField(org.murtsi.capnproto.example.Todo)(0, value)
        }
        def initAdded(): org.murtsi.capnproto.example.Todo.Builder = {
            _setShortField(4, 1)
            _initPointerField(org.murtsi.capnproto.example.Todo, 0, 0)
        }
        private[ClientMessage] def removed: Option[org.murtsi.capnproto.example.Todo.Builder] = {
            _getPointerFieldOption(org.murtsi.capnproto.example.Todo, 0)
        }
        def removed_=(value: org.murtsi.capnproto.example.Todo.Reader): Unit = {
            _setShortField(4, 2)
            _setPointerField(org.murtsi.capnproto.example.Todo)(0, value)
        }
        def initRemoved(): org.murtsi.capnproto.example.Todo.Builder = {
            _setShortField(4, 2)
            _initPointerField(org.murtsi.capnproto.example.Todo, 0, 0)
        }
        private[ClientMessage] def modified: Option[org.murtsi.capnproto.example.Todo.Builder] = {
            _getPointerFieldOption(org.murtsi.capnproto.example.Todo, 0)
        }
        def modified_=(value: org.murtsi.capnproto.example.Todo.Reader): Unit = {
            _setShortField(4, 3)
            _setPointerField(org.murtsi.capnproto.example.Todo)(0, value)
        }
        def initModified(): org.murtsi.capnproto.example.Todo.Builder = {
            _setShortField(4, 3)
            _initPointerField(org.murtsi.capnproto.example.Todo, 0, 0)
        }
        private[ClientMessage] def addFailed: Option[org.murtsi.capnproto.example.Todo.Builder] = {
            _getPointerFieldOption(org.murtsi.capnproto.example.Todo, 0)
        }
        def addFailed_=(value: org.murtsi.capnproto.example.Todo.Reader): Unit = {
            _setShortField(4, 4)
            _setPointerField(org.murtsi.capnproto.example.Todo)(0, value)
        }
        def initAddFailed(): org.murtsi.capnproto.example.Todo.Builder = {
            _setShortField(4, 4)
            _initPointerField(org.murtsi.capnproto.example.Todo, 0, 0)
        }
        private[ClientMessage] def removalFailed: Option[org.murtsi.capnproto.example.Todo.Builder] = {
            _getPointerFieldOption(org.murtsi.capnproto.example.Todo, 0)
        }
        def removalFailed_=(value: org.murtsi.capnproto.example.Todo.Reader): Unit = {
            _setShortField(4, 5)
            _setPointerField(org.murtsi.capnproto.example.Todo)(0, value)
        }
        def initRemovalFailed(): org.murtsi.capnproto.example.Todo.Builder = {
            _setShortField(4, 5)
            _initPointerField(org.murtsi.capnproto.example.Todo, 0, 0)
        }
        private[ClientMessage] def modifyFailed: Option[org.murtsi.capnproto.example.Todo.Builder] = {
            _getPointerFieldOption(org.murtsi.capnproto.example.Todo, 0)
        }
        def modifyFailed_=(value: org.murtsi.capnproto.example.Todo.Reader): Unit = {
            _setShortField(4, 6)
            _setPointerField(org.murtsi.capnproto.example.Todo)(0, value)
        }
        def initModifyFailed(): org.murtsi.capnproto.example.Todo.Builder = {
            _setShortField(4, 6)
            _initPointerField(org.murtsi.capnproto.example.Todo, 0, 0)
        }
        private[ClientMessage] def _whichIndex: Short = _getShortField(4)
    }
    object Added {
        def unapply(value: Reader): Option[org.murtsi.capnproto.example.Todo.Reader] = {
            if (value._whichIndex == 1) value.added else None
        }
        def unapply(value: Builder): Option[org.murtsi.capnproto.example.Todo.Builder] = {
            if (value._whichIndex == 1) value.added else None
        }
    }
    object Removed {
        def unapply(value: Reader): Option[org.murtsi.capnproto.example.Todo.Reader] = {
            if (value._whichIndex == 2) value.removed else None
        }
        def unapply(value: Builder): Option[org.murtsi.capnproto.example.Todo.Builder] = {
            if (value._whichIndex == 2) value.removed else None
        }
    }
    object Modified {
        def unapply(value: Reader): Option[org.murtsi.capnproto.example.Todo.Reader] = {
            if (value._whichIndex == 3) value.modified else None
        }
        def unapply(value: Builder): Option[org.murtsi.capnproto.example.Todo.Builder] = {
            if (value._whichIndex == 3) value.modified else None
        }
    }
    object AddFailed {
        def unapply(value: Reader): Option[org.murtsi.capnproto.example.Todo.Reader] = {
            if (value._whichIndex == 4) value.addFailed else None
        }
        def unapply(value: Builder): Option[org.murtsi.capnproto.example.Todo.Builder] = {
            if (value._whichIndex == 4) value.addFailed else None
        }
    }
    object RemovalFailed {
        def unapply(value: Reader): Option[org.murtsi.capnproto.example.Todo.Reader] = {
            if (value._whichIndex == 5) value.removalFailed else None
        }
        def unapply(value: Builder): Option[org.murtsi.capnproto.example.Todo.Builder] = {
            if (value._whichIndex == 5) value.removalFailed else None
        }
    }
    object ModifyFailed {
        def unapply(value: Reader): Option[org.murtsi.capnproto.example.Todo.Reader] = {
            if (value._whichIndex == 6) value.modifyFailed else None
        }
        def unapply(value: Builder): Option[org.murtsi.capnproto.example.Todo.Builder] = {
            if (value._whichIndex == 6) value.modifyFailed else None
        }
    }

    object Initial extends org.murtsi.capnproto.runtime.Struct { 
        val typeId: Long = -8025231674297101893L
        override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(2, 1)

        override type Reader = ReaderImpl
        override type Builder = BuilderImpl

        override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
        override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

        def unapply(value: org.murtsi.capnproto.example.ClientMessage.Reader): Option[Reader] = {
            if (value._whichIndex == 0) Some(value.initial) else None
        }
        def unapply(value: org.murtsi.capnproto.example.ClientMessage.Builder): Option[Builder] = {
            if (value._whichIndex == 0) Some(value.initial) else None
        }
        class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
            def clientId: Long = {
                this._getLongField(0)
            }
            def todos: Option[org.murtsi.capnproto.example.Todo.List.Reader] = {
                _getPointerFieldOption(org.murtsi.capnproto.example.Todo.List, 0)
            }
        }
        class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
            def clientId: Long = {
                this._getLongField(0)
            }
            def clientId_=(value: Long): Unit = {
                _setLongField(0, value)
            }
            def todos: Option[org.murtsi.capnproto.example.Todo.List.Builder] = {
                _getPointerFieldOption(org.murtsi.capnproto.example.Todo.List, 0)
            }
            def todos_=(value: org.murtsi.capnproto.example.Todo.List.Reader): Unit = {
                _setPointerField(org.murtsi.capnproto.example.Todo.List)(0, value)
            }
            def initTodos(size: Int): org.murtsi.capnproto.example.Todo.List.Builder = {
                _initPointerField(org.murtsi.capnproto.example.Todo.List, 0, size)
            }
        }
    }
}

object ServerMessage extends org.murtsi.capnproto.runtime.Struct { 
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
        private[ServerMessage] def add: Option[org.murtsi.capnproto.example.Todo.Reader] = {
            _getPointerFieldOption(org.murtsi.capnproto.example.Todo, 0)
        }
        private[ServerMessage] def remove: Option[org.murtsi.capnproto.example.Todo.Reader] = {
            _getPointerFieldOption(org.murtsi.capnproto.example.Todo, 0)
        }
        private[ServerMessage] def modify: Option[org.murtsi.capnproto.example.Todo.Reader] = {
            _getPointerFieldOption(org.murtsi.capnproto.example.Todo, 0)
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
        private[ServerMessage] def add: Option[org.murtsi.capnproto.example.Todo.Builder] = {
            _getPointerFieldOption(org.murtsi.capnproto.example.Todo, 0)
        }
        def add_=(value: org.murtsi.capnproto.example.Todo.Reader): Unit = {
            _setShortField(4, 0)
            _setPointerField(org.murtsi.capnproto.example.Todo)(0, value)
        }
        def initAdd(): org.murtsi.capnproto.example.Todo.Builder = {
            _setShortField(4, 0)
            _initPointerField(org.murtsi.capnproto.example.Todo, 0, 0)
        }
        private[ServerMessage] def remove: Option[org.murtsi.capnproto.example.Todo.Builder] = {
            _getPointerFieldOption(org.murtsi.capnproto.example.Todo, 0)
        }
        def remove_=(value: org.murtsi.capnproto.example.Todo.Reader): Unit = {
            _setShortField(4, 1)
            _setPointerField(org.murtsi.capnproto.example.Todo)(0, value)
        }
        def initRemove(): org.murtsi.capnproto.example.Todo.Builder = {
            _setShortField(4, 1)
            _initPointerField(org.murtsi.capnproto.example.Todo, 0, 0)
        }
        private[ServerMessage] def modify: Option[org.murtsi.capnproto.example.Todo.Builder] = {
            _getPointerFieldOption(org.murtsi.capnproto.example.Todo, 0)
        }
        def modify_=(value: org.murtsi.capnproto.example.Todo.Reader): Unit = {
            _setShortField(4, 2)
            _setPointerField(org.murtsi.capnproto.example.Todo)(0, value)
        }
        def initModify(): org.murtsi.capnproto.example.Todo.Builder = {
            _setShortField(4, 2)
            _initPointerField(org.murtsi.capnproto.example.Todo, 0, 0)
        }
        private[ServerMessage] def _whichIndex: Short = _getShortField(4)
    }
    object Add {
        def unapply(value: Reader): Option[org.murtsi.capnproto.example.Todo.Reader] = {
            if (value._whichIndex == 0) value.add else None
        }
        def unapply(value: Builder): Option[org.murtsi.capnproto.example.Todo.Builder] = {
            if (value._whichIndex == 0) value.add else None
        }
    }
    object Remove {
        def unapply(value: Reader): Option[org.murtsi.capnproto.example.Todo.Reader] = {
            if (value._whichIndex == 1) value.remove else None
        }
        def unapply(value: Builder): Option[org.murtsi.capnproto.example.Todo.Builder] = {
            if (value._whichIndex == 1) value.remove else None
        }
    }
    object Modify {
        def unapply(value: Reader): Option[org.murtsi.capnproto.example.Todo.Reader] = {
            if (value._whichIndex == 2) value.modify else None
        }
        def unapply(value: Builder): Option[org.murtsi.capnproto.example.Todo.Builder] = {
            if (value._whichIndex == 2) value.modify else None
        }
    }
}

object Todo extends org.murtsi.capnproto.runtime.Struct { 
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
        def contents: Option[org.murtsi.capnproto.runtime.Text.Reader] = {
            _getPointerFieldOption(org.murtsi.capnproto.runtime.Text, 0)
        }
        def created: Option[org.murtsi.capnproto.runtime.Text.Reader] = {
            _getPointerFieldOption(org.murtsi.capnproto.runtime.Text, 1)
        }
    }
    class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        def id: Long = {
            this._getLongField(0)
        }
        def id_=(value: Long): Unit = {
            _setLongField(0, value)
        }
        def contents: Option[org.murtsi.capnproto.runtime.Text.Builder] = {
            _getPointerFieldOption(org.murtsi.capnproto.runtime.Text, 0)
        }
        def contents_=(value: org.murtsi.capnproto.runtime.Text.Reader): Unit = {
            _setPointerField(org.murtsi.capnproto.runtime.Text)(0, value)
        }
        def contents_=(value: String): Unit = {
            _setPointerField(org.murtsi.capnproto.runtime.Text)(0, org.murtsi.capnproto.runtime.Text.Reader(value))
        }
        def initContents(size: Int): org.murtsi.capnproto.runtime.Text.Builder = {
            _initPointerField(org.murtsi.capnproto.runtime.Text, 0, size)
        }
        def created: Option[org.murtsi.capnproto.runtime.Text.Builder] = {
            _getPointerFieldOption(org.murtsi.capnproto.runtime.Text, 1)
        }
        def created_=(value: org.murtsi.capnproto.runtime.Text.Reader): Unit = {
            _setPointerField(org.murtsi.capnproto.runtime.Text)(1, value)
        }
        def created_=(value: String): Unit = {
            _setPointerField(org.murtsi.capnproto.runtime.Text)(1, org.murtsi.capnproto.runtime.Text.Reader(value))
        }
        def initCreated(size: Int): org.murtsi.capnproto.runtime.Text.Builder = {
            _initPointerField(org.murtsi.capnproto.runtime.Text, 1, size)
        }
    }
}

