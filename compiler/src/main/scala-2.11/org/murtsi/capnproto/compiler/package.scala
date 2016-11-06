package org.murtsi.capnproto

import org.murtsi.capnproto.runtime.{HasStructSize, HasTypeId}

import org.murtsi.capnproto.compiler.schema._

package object compiler {
  val PackageNameAnnotationId = 0xee44ce11f43e05d7L
  val ModuleAnnotationId = 0xfd7b105ce99a1686L

  val reservedClasses = Seq(
    "List",
    "Reader",
    "Builder",
    "ReaderImpl",
    "BuilderImpl",
    "ReaderBase",
    "BuilderBase"
  )

  val keywords = Seq(
    "case",
    "catch",
    "class",
    "def",
    "do",
    "else",
    "extends",
    "false",
    "final",
    "for",
    "if",
    "implicit",
    "import",
    "match",
    "new",
    "null",
    "object",
    "compiler",
    "print",
    "printf",
    "println",
    "private",
    "protected",
    "this",
    "throw",
    "to",
    "trait",
    "true",
    "try",
    "type",
    "until",
    "val",
    "var",
    "while",
    "with",
    "yield"
  ) ++ reservedClasses

  def booleanMatch[A, B](value: A)(fn: PartialFunction[A, B]): Boolean = fn.isDefinedAt(value)

  case class TypeParameterTexts(expandedList: Seq[String],
                                params: String)

  implicit class TypeInfo(val typ: Type#Reader) extends AnyVal {
    def isParameter: Boolean = {
      typ match {
        case Type.AnyPointer(ptr) =>
          ptr match {
            case Type.AnyPointer.Parameter(_) => true
            case _ => false
          }
        case _ => false
      }
    }

    def isBranded: Boolean = {
      typ match {
        case Type.Struct(struct) =>
          (for (brand <- struct.brand;
               scopes <- brand.scopes)
            yield scopes.size > 0).getOrElse(false)
        case _ => false
      }
    }

    def isPrimitive: Boolean = {
      import Type._
      typ match {
        case Int8() | Int16() | Int32() | Int64() | Uint8() | Uint16() | Uint32() | Uint64() | Float32() | Float64() | Void() | Bool() => true
        case _ => false
      }
    }
  }

  /*
  object Node extends org.murtsi.capnproto.runtime.Struct {
    val typeId: Long = -1836717350928014313L
    override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(5, 6)

    override type Reader = ReaderImpl
    override type Builder = BuilderImpl

    override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
      def id: Long = {
        this._getLongField(0)
      }

      def displayName: Option[org.murtsi.capnproto.runtime.Text.Reader] = {
        _getPointerFieldOption(org.murtsi.capnproto.runtime.Text, 0)
      }

      def displayNamePrefixLength: Int = {
        this._getIntField(2)
      }

      def scopeId: Long = {
        this._getLongField(2)
      }

      def nestedNodes: Option[org.murtsi.capnproto.compiler.Node.NestedNode.List.Reader] = {
        _getPointerFieldOption(org.murtsi.capnproto.compiler.Node.NestedNode.List, 1)
      }

      def annotations: Option[org.murtsi.capnproto.compiler.Annotation.List.Reader] = {
        _getPointerFieldOption(org.murtsi.capnproto.compiler.Annotation.List, 2)
      }

      private[Node] def struct: org.murtsi.capnproto.compiler.Node.Struct.Reader = {
        org.murtsi.capnproto.compiler.Node.Struct.Reader(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit)
      }

      private[Node] def enum: org.murtsi.capnproto.compiler.Node.Enum.Reader = {
        org.murtsi.capnproto.compiler.Node.Enum.Reader(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit)
      }

      private[Node] def interface: org.murtsi.capnproto.compiler.Node.Interface.Reader = {
        org.murtsi.capnproto.compiler.Node.Interface.Reader(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit)
      }

      private[Node] def const: org.murtsi.capnproto.compiler.Node.Const.Reader = {
        org.murtsi.capnproto.compiler.Node.Const.Reader(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit)
      }

      private[Node] def annotation: org.murtsi.capnproto.compiler.Node.Annotation.Reader = {
        org.murtsi.capnproto.compiler.Node.Annotation.Reader(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit)
      }

      def parameters: Option[org.murtsi.capnproto.compiler.Node.Parameter.List.Reader] = {
        _getPointerFieldOption(org.murtsi.capnproto.compiler.Node.Parameter.List, 5)
      }

      def isGeneric: Boolean = {
        _getBooleanField(288)
      }

      private[Node] def _whichIndex: Short = _getShortField(6)
    }

    class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
      def id: Long = {
        this._getLongField(0)
      }

      def id_=(value: Long): Unit = {
        _setLongField(0, value)
      }

      def displayName: Option[org.murtsi.capnproto.runtime.Text.Builder] = {
        _getPointerFieldOption(org.murtsi.capnproto.runtime.Text, 0)
      }

      def displayName_=(value: org.murtsi.capnproto.runtime.Text.Reader): Unit = {
        _setPointerField(org.murtsi.capnproto.runtime.Text)(0, value)
      }

      def displayName_=(value: String): Unit = {
        _setPointerField(org.murtsi.capnproto.runtime.Text)(0, org.murtsi.capnproto.runtime.Text.Reader(value))
      }

      def initDisplayName(size: Int): org.murtsi.capnproto.runtime.Text.Builder = {
        _initPointerField(org.murtsi.capnproto.runtime.Text, 0, size)
      }

      def displayNamePrefixLength: Int = {
        this._getIntField(2)
      }

      def displayNamePrefixLength_=(value: Int): Unit = {
        _setIntField(2, value)
      }

      def scopeId: Long = {
        this._getLongField(2)
      }

      def scopeId_=(value: Long): Unit = {
        _setLongField(2, value)
      }

      def nestedNodes: Option[org.murtsi.capnproto.compiler.Node.NestedNode.List.Builder] = {
        _getPointerFieldOption(org.murtsi.capnproto.compiler.Node.NestedNode.List, 1)
      }

      def nestedNodes_=(value: org.murtsi.capnproto.compiler.Node.NestedNode.List.Reader): Unit = {
        _setPointerField(org.murtsi.capnproto.compiler.Node.NestedNode.List)(1, value)
      }

      def initNestedNodes(size: Int): org.murtsi.capnproto.compiler.Node.NestedNode.List.Builder = {
        _initPointerField(org.murtsi.capnproto.compiler.Node.NestedNode.List, 1, size)
      }

      def annotations: Option[org.murtsi.capnproto.compiler.Annotation.List.Builder] = {
        _getPointerFieldOption(org.murtsi.capnproto.compiler.Annotation.List, 2)
      }

      def annotations_=(value: org.murtsi.capnproto.compiler.Annotation.List.Reader): Unit = {
        _setPointerField(org.murtsi.capnproto.compiler.Annotation.List)(2, value)
      }

      def initAnnotations(size: Int): org.murtsi.capnproto.compiler.Annotation.List.Builder = {
        _initPointerField(org.murtsi.capnproto.compiler.Annotation.List, 2, size)
      }

      def file_=(_value: Unit): Unit = {
        _setShortField(6, 0)
      }

      private[Node] def struct: org.murtsi.capnproto.compiler.Node.Struct.Builder = {
        org.murtsi.capnproto.compiler.Node.Struct.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }

      def initStruct(): org.murtsi.capnproto.compiler.Node.Struct.Builder = {
        _setShortField(6, 1)
        _setShortField(7, 0)
        _setShortField(12, 0)
        _setShortField(13, 0)
        _setBooleanField(224, false)
        _setShortField(15, 0)
        _setIntField(8, 0)
        _clearPointerField(3)
        org.murtsi.capnproto.compiler.Node.Struct.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }

      private[Node] def enum: org.murtsi.capnproto.compiler.Node.Enum.Builder = {
        org.murtsi.capnproto.compiler.Node.Enum.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }

      def initEnum(): org.murtsi.capnproto.compiler.Node.Enum.Builder = {
        _setShortField(6, 2)
        _clearPointerField(3)
        org.murtsi.capnproto.compiler.Node.Enum.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }

      private[Node] def interface: org.murtsi.capnproto.compiler.Node.Interface.Builder = {
        org.murtsi.capnproto.compiler.Node.Interface.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }

      def initInterface(): org.murtsi.capnproto.compiler.Node.Interface.Builder = {
        _setShortField(6, 3)
        _clearPointerField(3)
        _clearPointerField(4)
        org.murtsi.capnproto.compiler.Node.Interface.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }

      private[Node] def const: org.murtsi.capnproto.compiler.Node.Const.Builder = {
        org.murtsi.capnproto.compiler.Node.Const.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }

      def initConst(): org.murtsi.capnproto.compiler.Node.Const.Builder = {
        _setShortField(6, 4)
        _clearPointerField(3)
        _clearPointerField(4)
        org.murtsi.capnproto.compiler.Node.Const.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }

      private[Node] def annotation: org.murtsi.capnproto.compiler.Node.Annotation.Builder = {
        org.murtsi.capnproto.compiler.Node.Annotation.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }

      def initAnnotation(): org.murtsi.capnproto.compiler.Node.Annotation.Builder = {
        _setShortField(6, 5)
        _clearPointerField(3)
        _setBooleanField(112, false)
        _setBooleanField(113, false)
        _setBooleanField(114, false)
        _setBooleanField(115, false)
        _setBooleanField(116, false)
        _setBooleanField(117, false)
        _setBooleanField(118, false)
        _setBooleanField(119, false)
        _setBooleanField(120, false)
        _setBooleanField(121, false)
        _setBooleanField(122, false)
        _setBooleanField(123, false)
        org.murtsi.capnproto.compiler.Node.Annotation.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }

      def parameters: Option[org.murtsi.capnproto.compiler.Node.Parameter.List.Builder] = {
        _getPointerFieldOption(org.murtsi.capnproto.compiler.Node.Parameter.List, 5)
      }

      def parameters_=(value: org.murtsi.capnproto.compiler.Node.Parameter.List.Reader): Unit = {
        _setPointerField(org.murtsi.capnproto.compiler.Node.Parameter.List)(5, value)
      }

      def initParameters(size: Int): org.murtsi.capnproto.compiler.Node.Parameter.List.Builder = {
        _initPointerField(org.murtsi.capnproto.compiler.Node.Parameter.List, 5, size)
      }

      def isGeneric: Boolean = {
        _getBooleanField(288)
      }

      def isGeneric_=(value: Boolean): Unit = {
        _setBooleanField(288, value)
      }

      private[Node] def _whichIndex: Short = _getShortField(6)
    }

    object File {
      def unapply(value: Reader): Boolean = value._whichIndex == 0

      def unapply(value: Builder): Boolean = value._whichIndex == 0
    }

    object Parameter extends org.murtsi.capnproto.runtime.Struct {
      val typeId: Long = -5092977661570997327L
      override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(0, 1)

      override type Reader = ReaderImpl
      override type Builder = BuilderImpl

      override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
        def name: Option[org.murtsi.capnproto.runtime.Text.Reader] = {
          _getPointerFieldOption(org.murtsi.capnproto.runtime.Text, 0)
        }
      }

      class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        def name: Option[org.murtsi.capnproto.runtime.Text.Builder] = {
          _getPointerFieldOption(org.murtsi.capnproto.runtime.Text, 0)
        }

        def name_=(value: org.murtsi.capnproto.runtime.Text.Reader): Unit = {
          _setPointerField(org.murtsi.capnproto.runtime.Text)(0, value)
        }

        def name_=(value: String): Unit = {
          _setPointerField(org.murtsi.capnproto.runtime.Text)(0, org.murtsi.capnproto.runtime.Text.Reader(value))
        }

        def initName(size: Int): org.murtsi.capnproto.runtime.Text.Builder = {
          _initPointerField(org.murtsi.capnproto.runtime.Text, 0, size)
        }
      }

    }

    object NestedNode extends org.murtsi.capnproto.runtime.Struct {
      val typeId: Long = -2396102210895232446L
      override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(1, 1)

      override type Reader = ReaderImpl
      override type Builder = BuilderImpl

      override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
        def name: Option[org.murtsi.capnproto.runtime.Text.Reader] = {
          _getPointerFieldOption(org.murtsi.capnproto.runtime.Text, 0)
        }

        def id: Long = {
          this._getLongField(0)
        }
      }

      class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        def name: Option[org.murtsi.capnproto.runtime.Text.Builder] = {
          _getPointerFieldOption(org.murtsi.capnproto.runtime.Text, 0)
        }

        def name_=(value: org.murtsi.capnproto.runtime.Text.Reader): Unit = {
          _setPointerField(org.murtsi.capnproto.runtime.Text)(0, value)
        }

        def name_=(value: String): Unit = {
          _setPointerField(org.murtsi.capnproto.runtime.Text)(0, org.murtsi.capnproto.runtime.Text.Reader(value))
        }

        def initName(size: Int): org.murtsi.capnproto.runtime.Text.Builder = {
          _initPointerField(org.murtsi.capnproto.runtime.Text, 0, size)
        }

        def id: Long = {
          this._getLongField(0)
        }

        def id_=(value: Long): Unit = {
          _setLongField(0, value)
        }
      }

    }

    object Struct extends org.murtsi.capnproto.runtime.Struct {
      val typeId: Long = -7016412939225971659L
      override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(5, 6)

      override type Reader = ReaderImpl
      override type Builder = BuilderImpl

      override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def unapply(value: org.murtsi.capnproto.compiler.Node.Reader): Option[Reader] = {
        if (value._whichIndex == 1) Some(value.struct) else None
      }

      def unapply(value: org.murtsi.capnproto.compiler.Node.Builder): Option[Builder] = {
        if (value._whichIndex == 1) Some(value.struct) else None
      }

      class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
        def dataWordCount: Short = {
          this._getShortField(7)
        }

        def pointerCount: Short = {
          this._getShortField(12)
        }

        def preferredListEncoding: Option[org.murtsi.capnproto.compiler.ElementSize] = {
          org.murtsi.capnproto.compiler.ElementSize(_getShortField(13))
        }

        def isGroup: Boolean = {
          _getBooleanField(224)
        }

        def discriminantCount: Short = {
          this._getShortField(15)
        }

        def discriminantOffset: Int = {
          this._getIntField(8)
        }

        def fields: Option[org.murtsi.capnproto.compiler.Field.List.Reader] = {
          _getPointerFieldOption(org.murtsi.capnproto.compiler.Field.List, 3)
        }
      }

      class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        def dataWordCount: Short = {
          this._getShortField(7)
        }

        def dataWordCount_=(value: Short): Unit = {
          _setShortField(7, value)
        }

        def pointerCount: Short = {
          this._getShortField(12)
        }

        def pointerCount_=(value: Short): Unit = {
          _setShortField(12, value)
        }

        def preferredListEncoding: Option[org.murtsi.capnproto.compiler.ElementSize] = {
          org.murtsi.capnproto.compiler.ElementSize(_getShortField(13))
        }

        def preferredListEncoding_=(value: org.murtsi.capnproto.compiler.ElementSize): Unit = {
          _setShortField(value.index, 13)
        }

        def isGroup: Boolean = {
          _getBooleanField(224)
        }

        def isGroup_=(value: Boolean): Unit = {
          _setBooleanField(224, value)
        }

        def discriminantCount: Short = {
          this._getShortField(15)
        }

        def discriminantCount_=(value: Short): Unit = {
          _setShortField(15, value)
        }

        def discriminantOffset: Int = {
          this._getIntField(8)
        }

        def discriminantOffset_=(value: Int): Unit = {
          _setIntField(8, value)
        }

        def fields: Option[org.murtsi.capnproto.compiler.Field.List.Builder] = {
          _getPointerFieldOption(org.murtsi.capnproto.compiler.Field.List, 3)
        }

        def fields_=(value: org.murtsi.capnproto.compiler.Field.List.Reader): Unit = {
          _setPointerField(org.murtsi.capnproto.compiler.Field.List)(3, value)
        }

        def initFields(size: Int): org.murtsi.capnproto.compiler.Field.List.Builder = {
          _initPointerField(org.murtsi.capnproto.compiler.Field.List, 3, size)
        }
      }

    }

    object Enum extends org.murtsi.capnproto.runtime.Struct {
      val typeId: Long = -5383293358930922088L
      override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(5, 6)

      override type Reader = ReaderImpl
      override type Builder = BuilderImpl

      override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def unapply(value: org.murtsi.capnproto.compiler.Node.Reader): Option[Reader] = {
        if (value._whichIndex == 2) Some(value.enum) else None
      }

      def unapply(value: org.murtsi.capnproto.compiler.Node.Builder): Option[Builder] = {
        if (value._whichIndex == 2) Some(value.enum) else None
      }

      class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
        def enumerants: Option[org.murtsi.capnproto.compiler.Enumerant.List.Reader] = {
          _getPointerFieldOption(org.murtsi.capnproto.compiler.Enumerant.List, 3)
        }
      }

      class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        def enumerants: Option[org.murtsi.capnproto.compiler.Enumerant.List.Builder] = {
          _getPointerFieldOption(org.murtsi.capnproto.compiler.Enumerant.List, 3)
        }

        def enumerants_=(value: org.murtsi.capnproto.compiler.Enumerant.List.Reader): Unit = {
          _setPointerField(org.murtsi.capnproto.compiler.Enumerant.List)(3, value)
        }

        def initEnumerants(size: Int): org.murtsi.capnproto.compiler.Enumerant.List.Builder = {
          _initPointerField(org.murtsi.capnproto.compiler.Enumerant.List, 3, size)
        }
      }

    }

    object Interface extends org.murtsi.capnproto.runtime.Struct {
      val typeId: Long = -1718312580255964785L
      override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(5, 6)

      override type Reader = ReaderImpl
      override type Builder = BuilderImpl

      override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def unapply(value: org.murtsi.capnproto.compiler.Node.Reader): Option[Reader] = {
        if (value._whichIndex == 3) Some(value.interface) else None
      }

      def unapply(value: org.murtsi.capnproto.compiler.Node.Builder): Option[Builder] = {
        if (value._whichIndex == 3) Some(value.interface) else None
      }

      class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
        def methods: Option[org.murtsi.capnproto.compiler.Method.List.Reader] = {
          _getPointerFieldOption(org.murtsi.capnproto.compiler.Method.List, 3)
        }

        def superclasses: Option[org.murtsi.capnproto.compiler.Superclass.List.Reader] = {
          _getPointerFieldOption(org.murtsi.capnproto.compiler.Superclass.List, 4)
        }
      }

      class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        def methods: Option[org.murtsi.capnproto.compiler.Method.List.Builder] = {
          _getPointerFieldOption(org.murtsi.capnproto.compiler.Method.List, 3)
        }

        def methods_=(value: org.murtsi.capnproto.compiler.Method.List.Reader): Unit = {
          _setPointerField(org.murtsi.capnproto.compiler.Method.List)(3, value)
        }

        def initMethods(size: Int): org.murtsi.capnproto.compiler.Method.List.Builder = {
          _initPointerField(org.murtsi.capnproto.compiler.Method.List, 3, size)
        }

        def superclasses: Option[org.murtsi.capnproto.compiler.Superclass.List.Builder] = {
          _getPointerFieldOption(org.murtsi.capnproto.compiler.Superclass.List, 4)
        }

        def superclasses_=(value: org.murtsi.capnproto.compiler.Superclass.List.Reader): Unit = {
          _setPointerField(org.murtsi.capnproto.compiler.Superclass.List)(4, value)
        }

        def initSuperclasses(size: Int): org.murtsi.capnproto.compiler.Superclass.List.Builder = {
          _initPointerField(org.murtsi.capnproto.compiler.Superclass.List, 4, size)
        }
      }

    }

    object Const extends org.murtsi.capnproto.runtime.Struct {
      val typeId: Long = -5653524222009568224L
      override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(5, 6)

      override type Reader = ReaderImpl
      override type Builder = BuilderImpl

      override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def unapply(value: org.murtsi.capnproto.compiler.Node.Reader): Option[Reader] = {
        if (value._whichIndex == 4) Some(value.const) else None
      }

      def unapply(value: org.murtsi.capnproto.compiler.Node.Builder): Option[Builder] = {
        if (value._whichIndex == 4) Some(value.const) else None
      }

      class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
        def `type`: Option[org.murtsi.capnproto.compiler.Type.Reader] = {
          _getPointerFieldOption(org.murtsi.capnproto.compiler.Type, 3)
        }

        def value: Option[org.murtsi.capnproto.compiler.Value.Reader] = {
          _getPointerFieldOption(org.murtsi.capnproto.compiler.Value, 4)
        }
      }

      class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        def `type`: Option[org.murtsi.capnproto.compiler.Type.Builder] = {
          _getPointerFieldOption(org.murtsi.capnproto.compiler.Type, 3)
        }

        def type_=(value: org.murtsi.capnproto.compiler.Type.Reader): Unit = {
          _setPointerField(org.murtsi.capnproto.compiler.Type)(3, value)
        }

        def initType(): org.murtsi.capnproto.compiler.Type.Builder = {
          _initPointerField(org.murtsi.capnproto.compiler.Type, 3, 0)
        }

        def value: Option[org.murtsi.capnproto.compiler.Value.Builder] = {
          _getPointerFieldOption(org.murtsi.capnproto.compiler.Value, 4)
        }

        def value_=(value: org.murtsi.capnproto.compiler.Value.Reader): Unit = {
          _setPointerField(org.murtsi.capnproto.compiler.Value)(4, value)
        }

        def initValue(): org.murtsi.capnproto.compiler.Value.Builder = {
          _initPointerField(org.murtsi.capnproto.compiler.Value, 4, 0)
        }
      }

    }

    object Annotation extends org.murtsi.capnproto.runtime.Struct {
      val typeId: Long = -1434931031872765296L
      override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(5, 6)

      override type Reader = ReaderImpl
      override type Builder = BuilderImpl

      override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def unapply(value: org.murtsi.capnproto.compiler.Node.Reader): Option[Reader] = {
        if (value._whichIndex == 5) Some(value.annotation) else None
      }

      def unapply(value: org.murtsi.capnproto.compiler.Node.Builder): Option[Builder] = {
        if (value._whichIndex == 5) Some(value.annotation) else None
      }

      class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
        def `type`: Option[org.murtsi.capnproto.compiler.Type.Reader] = {
          _getPointerFieldOption(org.murtsi.capnproto.compiler.Type, 3)
        }

        def targetsFile: Boolean = {
          _getBooleanField(112)
        }

        def targetsConst: Boolean = {
          _getBooleanField(113)
        }

        def targetsEnum: Boolean = {
          _getBooleanField(114)
        }

        def targetsEnumerant: Boolean = {
          _getBooleanField(115)
        }

        def targetsStruct: Boolean = {
          _getBooleanField(116)
        }

        def targetsField: Boolean = {
          _getBooleanField(117)
        }

        def targetsUnion: Boolean = {
          _getBooleanField(118)
        }

        def targetsGroup: Boolean = {
          _getBooleanField(119)
        }

        def targetsInterface: Boolean = {
          _getBooleanField(120)
        }

        def targetsMethod: Boolean = {
          _getBooleanField(121)
        }

        def targetsParam: Boolean = {
          _getBooleanField(122)
        }

        def targetsAnnotation: Boolean = {
          _getBooleanField(123)
        }
      }

      class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        def `type`: Option[org.murtsi.capnproto.compiler.Type.Builder] = {
          _getPointerFieldOption(org.murtsi.capnproto.compiler.Type, 3)
        }

        def type_=(value: org.murtsi.capnproto.compiler.Type.Reader): Unit = {
          _setPointerField(org.murtsi.capnproto.compiler.Type)(3, value)
        }

        def initType(): org.murtsi.capnproto.compiler.Type.Builder = {
          _initPointerField(org.murtsi.capnproto.compiler.Type, 3, 0)
        }

        def targetsFile: Boolean = {
          _getBooleanField(112)
        }

        def targetsFile_=(value: Boolean): Unit = {
          _setBooleanField(112, value)
        }

        def targetsConst: Boolean = {
          _getBooleanField(113)
        }

        def targetsConst_=(value: Boolean): Unit = {
          _setBooleanField(113, value)
        }

        def targetsEnum: Boolean = {
          _getBooleanField(114)
        }

        def targetsEnum_=(value: Boolean): Unit = {
          _setBooleanField(114, value)
        }

        def targetsEnumerant: Boolean = {
          _getBooleanField(115)
        }

        def targetsEnumerant_=(value: Boolean): Unit = {
          _setBooleanField(115, value)
        }

        def targetsStruct: Boolean = {
          _getBooleanField(116)
        }

        def targetsStruct_=(value: Boolean): Unit = {
          _setBooleanField(116, value)
        }

        def targetsField: Boolean = {
          _getBooleanField(117)
        }

        def targetsField_=(value: Boolean): Unit = {
          _setBooleanField(117, value)
        }

        def targetsUnion: Boolean = {
          _getBooleanField(118)
        }

        def targetsUnion_=(value: Boolean): Unit = {
          _setBooleanField(118, value)
        }

        def targetsGroup: Boolean = {
          _getBooleanField(119)
        }

        def targetsGroup_=(value: Boolean): Unit = {
          _setBooleanField(119, value)
        }

        def targetsInterface: Boolean = {
          _getBooleanField(120)
        }

        def targetsInterface_=(value: Boolean): Unit = {
          _setBooleanField(120, value)
        }

        def targetsMethod: Boolean = {
          _getBooleanField(121)
        }

        def targetsMethod_=(value: Boolean): Unit = {
          _setBooleanField(121, value)
        }

        def targetsParam: Boolean = {
          _getBooleanField(122)
        }

        def targetsParam_=(value: Boolean): Unit = {
          _setBooleanField(122, value)
        }

        def targetsAnnotation: Boolean = {
          _getBooleanField(123)
        }

        def targetsAnnotation_=(value: Boolean): Unit = {
          _setBooleanField(123, value)
        }
      }

    }

  }

  object Field extends org.murtsi.capnproto.runtime.Struct {
    val typeId: Long = -7301090755067841441L
    override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(3, 4)

    override type Reader = ReaderImpl
    override type Builder = BuilderImpl

    override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
      def name: Option[org.murtsi.capnproto.runtime.Text.Reader] = {
        _getPointerFieldOption(org.murtsi.capnproto.runtime.Text, 0)
      }

      def codeOrder: Short = {
        this._getShortField(0)
      }

      def annotations: Option[org.murtsi.capnproto.compiler.Annotation.List.Reader] = {
        _getPointerFieldOption(org.murtsi.capnproto.compiler.Annotation.List, 1)
      }

      def discriminantValue: Short = {
        this._getShortField(1, -1)
      }

      private[Field] def slot: org.murtsi.capnproto.compiler.Field.Slot.Reader = {
        org.murtsi.capnproto.compiler.Field.Slot.Reader(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit)
      }

      private[Field] def group: org.murtsi.capnproto.compiler.Field.Group.Reader = {
        org.murtsi.capnproto.compiler.Field.Group.Reader(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit)
      }

      def ordinal: org.murtsi.capnproto.compiler.Field.Ordinal.Reader = {
        org.murtsi.capnproto.compiler.Field.Ordinal.Reader(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit)
      }

      private[Field] def _whichIndex: Short = _getShortField(4)
    }

    class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
      def name: Option[org.murtsi.capnproto.runtime.Text.Builder] = {
        _getPointerFieldOption(org.murtsi.capnproto.runtime.Text, 0)
      }

      def name_=(value: org.murtsi.capnproto.runtime.Text.Reader): Unit = {
        _setPointerField(org.murtsi.capnproto.runtime.Text)(0, value)
      }

      def name_=(value: String): Unit = {
        _setPointerField(org.murtsi.capnproto.runtime.Text)(0, org.murtsi.capnproto.runtime.Text.Reader(value))
      }

      def initName(size: Int): org.murtsi.capnproto.runtime.Text.Builder = {
        _initPointerField(org.murtsi.capnproto.runtime.Text, 0, size)
      }

      def codeOrder: Short = {
        this._getShortField(0)
      }

      def codeOrder_=(value: Short): Unit = {
        _setShortField(0, value)
      }

      def annotations: Option[org.murtsi.capnproto.compiler.Annotation.List.Builder] = {
        _getPointerFieldOption(org.murtsi.capnproto.compiler.Annotation.List, 1)
      }

      def annotations_=(value: org.murtsi.capnproto.compiler.Annotation.List.Reader): Unit = {
        _setPointerField(org.murtsi.capnproto.compiler.Annotation.List)(1, value)
      }

      def initAnnotations(size: Int): org.murtsi.capnproto.compiler.Annotation.List.Builder = {
        _initPointerField(org.murtsi.capnproto.compiler.Annotation.List, 1, size)
      }

      def discriminantValue: Short = {
        this._getShortField(1, -1)
      }

      def discriminantValue_=(value: Short): Unit = {
        _setShortField(1, value, -1)
      }

      private[Field] def slot: org.murtsi.capnproto.compiler.Field.Slot.Builder = {
        org.murtsi.capnproto.compiler.Field.Slot.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }

      def initSlot(): org.murtsi.capnproto.compiler.Field.Slot.Builder = {
        _setShortField(4, 0)
        _setIntField(1, 0)
        _clearPointerField(2)
        _clearPointerField(3)
        _setBooleanField(128, false)
        org.murtsi.capnproto.compiler.Field.Slot.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }

      private[Field] def group: org.murtsi.capnproto.compiler.Field.Group.Builder = {
        org.murtsi.capnproto.compiler.Field.Group.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }

      def initGroup(): org.murtsi.capnproto.compiler.Field.Group.Builder = {
        _setShortField(4, 1)
        _setLongField(2, 0)
        org.murtsi.capnproto.compiler.Field.Group.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }

      def ordinal: org.murtsi.capnproto.compiler.Field.Ordinal.Builder = {
        org.murtsi.capnproto.compiler.Field.Ordinal.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }

      def initOrdinal(): org.murtsi.capnproto.compiler.Field.Ordinal.Builder = {
        _setShortField(5, 0)
        _setShortField(6, 0)
        org.murtsi.capnproto.compiler.Field.Ordinal.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }

      private[Field] def _whichIndex: Short = _getShortField(4)
    }

    val NoDiscriminant: Short = -1

    object Slot extends org.murtsi.capnproto.runtime.Struct {
      val typeId: Long = -4313598213782997905L
      override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(3, 4)

      override type Reader = ReaderImpl
      override type Builder = BuilderImpl

      override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def unapply(value: org.murtsi.capnproto.compiler.Field.Reader): Option[Reader] = {
        if (value._whichIndex == 0) Some(value.slot) else None
      }

      def unapply(value: org.murtsi.capnproto.compiler.Field.Builder): Option[Builder] = {
        if (value._whichIndex == 0) Some(value.slot) else None
      }

      class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
        def offset: Int = {
          this._getIntField(1)
        }

        def `type`: Option[org.murtsi.capnproto.compiler.Type.Reader] = {
          _getPointerFieldOption(org.murtsi.capnproto.compiler.Type, 2)
        }

        def defaultValue: Option[org.murtsi.capnproto.compiler.Value.Reader] = {
          _getPointerFieldOption(org.murtsi.capnproto.compiler.Value, 3)
        }

        def hadExplicitDefault: Boolean = {
          _getBooleanField(128)
        }
      }

      class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        def offset: Int = {
          this._getIntField(1)
        }

        def offset_=(value: Int): Unit = {
          _setIntField(1, value)
        }

        def `type`: Option[org.murtsi.capnproto.compiler.Type.Builder] = {
          _getPointerFieldOption(org.murtsi.capnproto.compiler.Type, 2)
        }

        def type_=(value: org.murtsi.capnproto.compiler.Type.Reader): Unit = {
          _setPointerField(org.murtsi.capnproto.compiler.Type)(2, value)
        }

        def initType(): org.murtsi.capnproto.compiler.Type.Builder = {
          _initPointerField(org.murtsi.capnproto.compiler.Type, 2, 0)
        }

        def defaultValue: Option[org.murtsi.capnproto.compiler.Value.Builder] = {
          _getPointerFieldOption(org.murtsi.capnproto.compiler.Value, 3)
        }

        def defaultValue_=(value: org.murtsi.capnproto.compiler.Value.Reader): Unit = {
          _setPointerField(org.murtsi.capnproto.compiler.Value)(3, value)
        }

        def initDefaultValue(): org.murtsi.capnproto.compiler.Value.Builder = {
          _initPointerField(org.murtsi.capnproto.compiler.Value, 3, 0)
        }

        def hadExplicitDefault: Boolean = {
          _getBooleanField(128)
        }

        def hadExplicitDefault_=(value: Boolean): Unit = {
          _setBooleanField(128, value)
        }
      }

    }

    object Group extends org.murtsi.capnproto.runtime.Struct {
      val typeId: Long = -3819952041676301039L
      override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(3, 4)

      override type Reader = ReaderImpl
      override type Builder = BuilderImpl

      override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def unapply(value: org.murtsi.capnproto.compiler.Field.Reader): Option[Reader] = {
        if (value._whichIndex == 1) Some(value.group) else None
      }

      def unapply(value: org.murtsi.capnproto.compiler.Field.Builder): Option[Builder] = {
        if (value._whichIndex == 1) Some(value.group) else None
      }

      class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
        def typeId: Long = {
          this._getLongField(2)
        }
      }

      class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        def typeId: Long = {
          this._getLongField(2)
        }

        def typeId_=(value: Long): Unit = {
          _setLongField(2, value)
        }
      }

    }

    object Ordinal extends org.murtsi.capnproto.runtime.Struct {
      val typeId: Long = -4931206560496546842L
      override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(3, 4)

      override type Reader = ReaderImpl
      override type Builder = BuilderImpl

      override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def unapply(value: org.murtsi.capnproto.compiler.Field.Reader): Option[Reader] = {
        if (value._whichIndex == -1) Some(value.ordinal) else None
      }

      def unapply(value: org.murtsi.capnproto.compiler.Field.Builder): Option[Builder] = {
        if (value._whichIndex == -1) Some(value.ordinal) else None
      }

      class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
        private[Ordinal] def explicit: Short = {
          this._getShortField(6)
        }

        private[Ordinal] def _whichIndex: Short = _getShortField(5)
      }

      class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        def implicit_=(_value: Unit): Unit = {
          _setShortField(5, 0)
        }

        private[Ordinal] def explicit: Short = {
          this._getShortField(6)
        }

        def explicit_=(value: Short): Unit = {
          _setShortField(5, 1)
          _setShortField(6, value)
        }

        private[Ordinal] def _whichIndex: Short = _getShortField(5)
      }

      object Implicit {
        def unapply(value: Reader): Boolean = value._whichIndex == 0

        def unapply(value: Builder): Boolean = value._whichIndex == 0
      }

      object Explicit {
        def unapply(value: Reader): Option[Short] = {
          if (value._whichIndex == 1) Some(value.explicit) else None
        }

        def unapply(value: Builder): Option[Short] = {
          if (value._whichIndex == 1) Some(value.explicit) else None
        }
      }

    }

  }

  object Enumerant extends org.murtsi.capnproto.runtime.Struct {
    val typeId: Long = -7527066474740671923L
    override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(1, 2)

    override type Reader = ReaderImpl
    override type Builder = BuilderImpl

    override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
      def name: Option[org.murtsi.capnproto.runtime.Text.Reader] = {
        _getPointerFieldOption(org.murtsi.capnproto.runtime.Text, 0)
      }

      def codeOrder: Short = {
        this._getShortField(0)
      }

      def annotations: Option[org.murtsi.capnproto.compiler.Annotation.List.Reader] = {
        _getPointerFieldOption(org.murtsi.capnproto.compiler.Annotation.List, 1)
      }
    }

    class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
      def name: Option[org.murtsi.capnproto.runtime.Text.Builder] = {
        _getPointerFieldOption(org.murtsi.capnproto.runtime.Text, 0)
      }

      def name_=(value: org.murtsi.capnproto.runtime.Text.Reader): Unit = {
        _setPointerField(org.murtsi.capnproto.runtime.Text)(0, value)
      }

      def name_=(value: String): Unit = {
        _setPointerField(org.murtsi.capnproto.runtime.Text)(0, org.murtsi.capnproto.runtime.Text.Reader(value))
      }

      def initName(size: Int): org.murtsi.capnproto.runtime.Text.Builder = {
        _initPointerField(org.murtsi.capnproto.runtime.Text, 0, size)
      }

      def codeOrder: Short = {
        this._getShortField(0)
      }

      def codeOrder_=(value: Short): Unit = {
        _setShortField(0, value)
      }

      def annotations: Option[org.murtsi.capnproto.compiler.Annotation.List.Builder] = {
        _getPointerFieldOption(org.murtsi.capnproto.compiler.Annotation.List, 1)
      }

      def annotations_=(value: org.murtsi.capnproto.compiler.Annotation.List.Reader): Unit = {
        _setPointerField(org.murtsi.capnproto.compiler.Annotation.List)(1, value)
      }

      def initAnnotations(size: Int): org.murtsi.capnproto.compiler.Annotation.List.Builder = {
        _initPointerField(org.murtsi.capnproto.compiler.Annotation.List, 1, size)
      }
    }

  }

  object Superclass extends org.murtsi.capnproto.runtime.Struct {
    val typeId: Long = -6226742573199468552L
    override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(1, 1)

    override type Reader = ReaderImpl
    override type Builder = BuilderImpl

    override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
      def id: Long = {
        this._getLongField(0)
      }

      def brand: Option[org.murtsi.capnproto.compiler.Brand.Reader] = {
        _getPointerFieldOption(org.murtsi.capnproto.compiler.Brand, 0)
      }
    }

    class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
      def id: Long = {
        this._getLongField(0)
      }

      def id_=(value: Long): Unit = {
        _setLongField(0, value)
      }

      def brand: Option[org.murtsi.capnproto.compiler.Brand.Builder] = {
        _getPointerFieldOption(org.murtsi.capnproto.compiler.Brand, 0)
      }

      def brand_=(value: org.murtsi.capnproto.compiler.Brand.Reader): Unit = {
        _setPointerField(org.murtsi.capnproto.compiler.Brand)(0, value)
      }

      def initBrand(): org.murtsi.capnproto.compiler.Brand.Builder = {
        _initPointerField(org.murtsi.capnproto.compiler.Brand, 0, 0)
      }
    }

  }

  object Method extends org.murtsi.capnproto.runtime.Struct {
    val typeId: Long = -7709937290030396032L
    override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(3, 5)

    override type Reader = ReaderImpl
    override type Builder = BuilderImpl

    override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
      def name: Option[org.murtsi.capnproto.runtime.Text.Reader] = {
        _getPointerFieldOption(org.murtsi.capnproto.runtime.Text, 0)
      }

      def codeOrder: Short = {
        this._getShortField(0)
      }

      def paramStructType: Long = {
        this._getLongField(1)
      }

      def resultStructType: Long = {
        this._getLongField(2)
      }

      def annotations: Option[org.murtsi.capnproto.compiler.Annotation.List.Reader] = {
        _getPointerFieldOption(org.murtsi.capnproto.compiler.Annotation.List, 1)
      }

      def paramBrand: Option[org.murtsi.capnproto.compiler.Brand.Reader] = {
        _getPointerFieldOption(org.murtsi.capnproto.compiler.Brand, 2)
      }

      def resultBrand: Option[org.murtsi.capnproto.compiler.Brand.Reader] = {
        _getPointerFieldOption(org.murtsi.capnproto.compiler.Brand, 3)
      }

      def implicitParameters: Option[org.murtsi.capnproto.compiler.Node.Parameter.List.Reader] = {
        _getPointerFieldOption(org.murtsi.capnproto.compiler.Node.Parameter.List, 4)
      }
    }

    class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
      def name: Option[org.murtsi.capnproto.runtime.Text.Builder] = {
        _getPointerFieldOption(org.murtsi.capnproto.runtime.Text, 0)
      }

      def name_=(value: org.murtsi.capnproto.runtime.Text.Reader): Unit = {
        _setPointerField(org.murtsi.capnproto.runtime.Text)(0, value)
      }

      def name_=(value: String): Unit = {
        _setPointerField(org.murtsi.capnproto.runtime.Text)(0, org.murtsi.capnproto.runtime.Text.Reader(value))
      }

      def initName(size: Int): org.murtsi.capnproto.runtime.Text.Builder = {
        _initPointerField(org.murtsi.capnproto.runtime.Text, 0, size)
      }

      def codeOrder: Short = {
        this._getShortField(0)
      }

      def codeOrder_=(value: Short): Unit = {
        _setShortField(0, value)
      }

      def paramStructType: Long = {
        this._getLongField(1)
      }

      def paramStructType_=(value: Long): Unit = {
        _setLongField(1, value)
      }

      def resultStructType: Long = {
        this._getLongField(2)
      }

      def resultStructType_=(value: Long): Unit = {
        _setLongField(2, value)
      }

      def annotations: Option[org.murtsi.capnproto.compiler.Annotation.List.Builder] = {
        _getPointerFieldOption(org.murtsi.capnproto.compiler.Annotation.List, 1)
      }

      def annotations_=(value: org.murtsi.capnproto.compiler.Annotation.List.Reader): Unit = {
        _setPointerField(org.murtsi.capnproto.compiler.Annotation.List)(1, value)
      }

      def initAnnotations(size: Int): org.murtsi.capnproto.compiler.Annotation.List.Builder = {
        _initPointerField(org.murtsi.capnproto.compiler.Annotation.List, 1, size)
      }

      def paramBrand: Option[org.murtsi.capnproto.compiler.Brand.Builder] = {
        _getPointerFieldOption(org.murtsi.capnproto.compiler.Brand, 2)
      }

      def paramBrand_=(value: org.murtsi.capnproto.compiler.Brand.Reader): Unit = {
        _setPointerField(org.murtsi.capnproto.compiler.Brand)(2, value)
      }

      def initParamBrand(): org.murtsi.capnproto.compiler.Brand.Builder = {
        _initPointerField(org.murtsi.capnproto.compiler.Brand, 2, 0)
      }

      def resultBrand: Option[org.murtsi.capnproto.compiler.Brand.Builder] = {
        _getPointerFieldOption(org.murtsi.capnproto.compiler.Brand, 3)
      }

      def resultBrand_=(value: org.murtsi.capnproto.compiler.Brand.Reader): Unit = {
        _setPointerField(org.murtsi.capnproto.compiler.Brand)(3, value)
      }

      def initResultBrand(): org.murtsi.capnproto.compiler.Brand.Builder = {
        _initPointerField(org.murtsi.capnproto.compiler.Brand, 3, 0)
      }

      def implicitParameters: Option[org.murtsi.capnproto.compiler.Node.Parameter.List.Builder] = {
        _getPointerFieldOption(org.murtsi.capnproto.compiler.Node.Parameter.List, 4)
      }

      def implicitParameters_=(value: org.murtsi.capnproto.compiler.Node.Parameter.List.Reader): Unit = {
        _setPointerField(org.murtsi.capnproto.compiler.Node.Parameter.List)(4, value)
      }

      def initImplicitParameters(size: Int): org.murtsi.capnproto.compiler.Node.Parameter.List.Builder = {
        _initPointerField(org.murtsi.capnproto.compiler.Node.Parameter.List, 4, size)
      }
    }

  }

  object Type extends org.murtsi.capnproto.runtime.Struct {
    val typeId: Long = -3426261928404988832L
    override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(2, 1)

    override type Reader = ReaderImpl
    override type Builder = BuilderImpl

    override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
      private[Type] def list: org.murtsi.capnproto.compiler.Type.List_.Reader = {
        org.murtsi.capnproto.compiler.Type.List_.Reader(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit)
      }

      private[Type] def enum: org.murtsi.capnproto.compiler.Type.Enum.Reader = {
        org.murtsi.capnproto.compiler.Type.Enum.Reader(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit)
      }

      private[Type] def struct: org.murtsi.capnproto.compiler.Type.Struct.Reader = {
        org.murtsi.capnproto.compiler.Type.Struct.Reader(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit)
      }

      private[Type] def interface: org.murtsi.capnproto.compiler.Type.Interface.Reader = {
        org.murtsi.capnproto.compiler.Type.Interface.Reader(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit)
      }

      private[Type] def anyPointer: org.murtsi.capnproto.compiler.Type.AnyPointer.Reader = {
        org.murtsi.capnproto.compiler.Type.AnyPointer.Reader(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit)
      }

      private[Type] def _whichIndex: Short = _getShortField(0)
    }

    class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
      def void_=(_value: Unit): Unit = {
        _setShortField(0, 0)
      }

      def bool_=(_value: Unit): Unit = {
        _setShortField(0, 1)
      }

      def int8_=(_value: Unit): Unit = {
        _setShortField(0, 2)
      }

      def int16_=(_value: Unit): Unit = {
        _setShortField(0, 3)
      }

      def int32_=(_value: Unit): Unit = {
        _setShortField(0, 4)
      }

      def int64_=(_value: Unit): Unit = {
        _setShortField(0, 5)
      }

      def uint8_=(_value: Unit): Unit = {
        _setShortField(0, 6)
      }

      def uint16_=(_value: Unit): Unit = {
        _setShortField(0, 7)
      }

      def uint32_=(_value: Unit): Unit = {
        _setShortField(0, 8)
      }

      def uint64_=(_value: Unit): Unit = {
        _setShortField(0, 9)
      }

      def float32_=(_value: Unit): Unit = {
        _setShortField(0, 10)
      }

      def float64_=(_value: Unit): Unit = {
        _setShortField(0, 11)
      }

      def text_=(_value: Unit): Unit = {
        _setShortField(0, 12)
      }

      def data_=(_value: Unit): Unit = {
        _setShortField(0, 13)
      }

      private[Type] def list: org.murtsi.capnproto.compiler.Type.List_.Builder = {
        org.murtsi.capnproto.compiler.Type.List_.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }

      def initList(): org.murtsi.capnproto.compiler.Type.List_.Builder = {
        _setShortField(0, 14)
        _clearPointerField(0)
        org.murtsi.capnproto.compiler.Type.List_.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }

      private[Type] def enum: org.murtsi.capnproto.compiler.Type.Enum.Builder = {
        org.murtsi.capnproto.compiler.Type.Enum.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }

      def initEnum(): org.murtsi.capnproto.compiler.Type.Enum.Builder = {
        _setShortField(0, 15)
        _setLongField(1, 0)
        _clearPointerField(0)
        org.murtsi.capnproto.compiler.Type.Enum.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }

      private[Type] def struct: org.murtsi.capnproto.compiler.Type.Struct.Builder = {
        org.murtsi.capnproto.compiler.Type.Struct.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }

      def initStruct(): org.murtsi.capnproto.compiler.Type.Struct.Builder = {
        _setShortField(0, 16)
        _setLongField(1, 0)
        _clearPointerField(0)
        org.murtsi.capnproto.compiler.Type.Struct.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }

      private[Type] def interface: org.murtsi.capnproto.compiler.Type.Interface.Builder = {
        org.murtsi.capnproto.compiler.Type.Interface.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }

      def initInterface(): org.murtsi.capnproto.compiler.Type.Interface.Builder = {
        _setShortField(0, 17)
        _setLongField(1, 0)
        _clearPointerField(0)
        org.murtsi.capnproto.compiler.Type.Interface.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }

      private[Type] def anyPointer: org.murtsi.capnproto.compiler.Type.AnyPointer.Builder = {
        org.murtsi.capnproto.compiler.Type.AnyPointer.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }

      def initAnyPointer(): org.murtsi.capnproto.compiler.Type.AnyPointer.Builder = {
        _setShortField(0, 18)
        _setShortField(2, 0)
        _setShortField(1, 0)
        _setLongField(1, 0)
        _setShortField(1, 0)
        _setShortField(1, 0)
        org.murtsi.capnproto.compiler.Type.AnyPointer.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }

      private[Type] def _whichIndex: Short = _getShortField(0)
    }

    object Void {
      def unapply(value: Reader): Boolean = value._whichIndex == 0

      def unapply(value: Builder): Boolean = value._whichIndex == 0
    }

    object Bool {
      def unapply(value: Reader): Boolean = value._whichIndex == 1

      def unapply(value: Builder): Boolean = value._whichIndex == 1
    }

    object Int8 {
      def unapply(value: Reader): Boolean = value._whichIndex == 2

      def unapply(value: Builder): Boolean = value._whichIndex == 2
    }

    object Int16 {
      def unapply(value: Reader): Boolean = value._whichIndex == 3

      def unapply(value: Builder): Boolean = value._whichIndex == 3
    }

    object Int32 {
      def unapply(value: Reader): Boolean = value._whichIndex == 4

      def unapply(value: Builder): Boolean = value._whichIndex == 4
    }

    object Int64 {
      def unapply(value: Reader): Boolean = value._whichIndex == 5

      def unapply(value: Builder): Boolean = value._whichIndex == 5
    }

    object Uint8 {
      def unapply(value: Reader): Boolean = value._whichIndex == 6

      def unapply(value: Builder): Boolean = value._whichIndex == 6
    }

    object Uint16 {
      def unapply(value: Reader): Boolean = value._whichIndex == 7

      def unapply(value: Builder): Boolean = value._whichIndex == 7
    }

    object Uint32 {
      def unapply(value: Reader): Boolean = value._whichIndex == 8

      def unapply(value: Builder): Boolean = value._whichIndex == 8
    }

    object Uint64 {
      def unapply(value: Reader): Boolean = value._whichIndex == 9

      def unapply(value: Builder): Boolean = value._whichIndex == 9
    }

    object Float32 {
      def unapply(value: Reader): Boolean = value._whichIndex == 10

      def unapply(value: Builder): Boolean = value._whichIndex == 10
    }

    object Float64 {
      def unapply(value: Reader): Boolean = value._whichIndex == 11

      def unapply(value: Builder): Boolean = value._whichIndex == 11
    }

    object Text {
      def unapply(value: Reader): Boolean = value._whichIndex == 12

      def unapply(value: Builder): Boolean = value._whichIndex == 12
    }

    object Data {
      def unapply(value: Reader): Boolean = value._whichIndex == 13

      def unapply(value: Builder): Boolean = value._whichIndex == 13
    }

    object List_ extends org.murtsi.capnproto.runtime.Struct {
      val typeId: Long = -8653885327718421865L
      override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(2, 1)

      override type Reader = ReaderImpl
      override type Builder = BuilderImpl

      override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def unapply(value: org.murtsi.capnproto.compiler.Type.Reader): Option[Reader] = {
        if (value._whichIndex == 14) Some(value.list) else None
      }

      def unapply(value: org.murtsi.capnproto.compiler.Type.Builder): Option[Builder] = {
        if (value._whichIndex == 14) Some(value.list) else None
      }

      class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
        def elementType: Option[org.murtsi.capnproto.compiler.Type.Reader] = {
          _getPointerFieldOption(org.murtsi.capnproto.compiler.Type, 0)
        }
      }

      class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        def elementType: Option[org.murtsi.capnproto.compiler.Type.Builder] = {
          _getPointerFieldOption(org.murtsi.capnproto.compiler.Type, 0)
        }

        def elementType_=(value: org.murtsi.capnproto.compiler.Type.Reader): Unit = {
          _setPointerField(org.murtsi.capnproto.compiler.Type)(0, value)
        }

        def initElementType(): org.murtsi.capnproto.compiler.Type.Builder = {
          _initPointerField(org.murtsi.capnproto.compiler.Type, 0, 0)
        }
      }

    }

    object Enum extends org.murtsi.capnproto.runtime.Struct {
      val typeId: Long = -7057571138871785559L
      override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(2, 1)

      override type Reader = ReaderImpl
      override type Builder = BuilderImpl

      override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def unapply(value: org.murtsi.capnproto.compiler.Type.Reader): Option[Reader] = {
        if (value._whichIndex == 15) Some(value.enum) else None
      }

      def unapply(value: org.murtsi.capnproto.compiler.Type.Builder): Option[Builder] = {
        if (value._whichIndex == 15) Some(value.enum) else None
      }

      class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
        def typeId: Long = {
          this._getLongField(1)
        }

        def brand: Option[org.murtsi.capnproto.compiler.Brand.Reader] = {
          _getPointerFieldOption(org.murtsi.capnproto.compiler.Brand, 0)
        }
      }

      class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        def typeId: Long = {
          this._getLongField(1)
        }

        def typeId_=(value: Long): Unit = {
          _setLongField(1, value)
        }

        def brand: Option[org.murtsi.capnproto.compiler.Brand.Builder] = {
          _getPointerFieldOption(org.murtsi.capnproto.compiler.Brand, 0)
        }

        def brand_=(value: org.murtsi.capnproto.compiler.Brand.Reader): Unit = {
          _setPointerField(org.murtsi.capnproto.compiler.Brand)(0, value)
        }

        def initBrand(): org.murtsi.capnproto.compiler.Brand.Builder = {
          _initPointerField(org.murtsi.capnproto.compiler.Brand, 0, 0)
        }
      }

    }

    object Struct extends org.murtsi.capnproto.runtime.Struct {
      val typeId: Long = -6036389888414398765L
      override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(2, 1)

      override type Reader = ReaderImpl
      override type Builder = BuilderImpl

      override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def unapply(value: org.murtsi.capnproto.compiler.Type.Reader): Option[Reader] = {
        if (value._whichIndex == 16) Some(value.struct) else None
      }

      def unapply(value: org.murtsi.capnproto.compiler.Type.Builder): Option[Builder] = {
        if (value._whichIndex == 16) Some(value.struct) else None
      }

      class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
        def typeId: Long = {
          this._getLongField(1)
        }

        def brand: Option[org.murtsi.capnproto.compiler.Brand.Reader] = {
          _getPointerFieldOption(org.murtsi.capnproto.compiler.Brand, 0)
        }
      }

      class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        def typeId: Long = {
          this._getLongField(1)
        }

        def typeId_=(value: Long): Unit = {
          _setLongField(1, value)
        }

        def brand: Option[org.murtsi.capnproto.compiler.Brand.Builder] = {
          _getPointerFieldOption(org.murtsi.capnproto.compiler.Brand, 0)
        }

        def brand_=(value: org.murtsi.capnproto.compiler.Brand.Reader): Unit = {
          _setPointerField(org.murtsi.capnproto.compiler.Brand)(0, value)
        }

        def initBrand(): org.murtsi.capnproto.compiler.Brand.Builder = {
          _initPointerField(org.murtsi.capnproto.compiler.Brand, 0, 0)
        }
      }

    }

    object Interface extends org.murtsi.capnproto.runtime.Struct {
      val typeId: Long = -1329746708477047617L
      override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(2, 1)

      override type Reader = ReaderImpl
      override type Builder = BuilderImpl

      override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def unapply(value: org.murtsi.capnproto.compiler.Type.Reader): Option[Reader] = {
        if (value._whichIndex == 17) Some(value.interface) else None
      }

      def unapply(value: org.murtsi.capnproto.compiler.Type.Builder): Option[Builder] = {
        if (value._whichIndex == 17) Some(value.interface) else None
      }

      class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
        def typeId: Long = {
          this._getLongField(1)
        }

        def brand: Option[org.murtsi.capnproto.compiler.Brand.Reader] = {
          _getPointerFieldOption(org.murtsi.capnproto.compiler.Brand, 0)
        }
      }

      class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        def typeId: Long = {
          this._getLongField(1)
        }

        def typeId_=(value: Long): Unit = {
          _setLongField(1, value)
        }

        def brand: Option[org.murtsi.capnproto.compiler.Brand.Builder] = {
          _getPointerFieldOption(org.murtsi.capnproto.compiler.Brand, 0)
        }

        def brand_=(value: org.murtsi.capnproto.compiler.Brand.Reader): Unit = {
          _setPointerField(org.murtsi.capnproto.compiler.Brand)(0, value)
        }

        def initBrand(): org.murtsi.capnproto.compiler.Brand.Builder = {
          _initPointerField(org.murtsi.capnproto.compiler.Brand, 0, 0)
        }
      }

    }

    object AnyPointer extends org.murtsi.capnproto.runtime.Struct {
      val typeId: Long = -4443012238990751247L
      override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(3, 1)

      override type Reader = ReaderImpl
      override type Builder = BuilderImpl

      override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def unapply(value: org.murtsi.capnproto.compiler.Type.Reader): Option[Reader] = {
        if (value._whichIndex == 18) Some(value.anyPointer) else None
      }

      def unapply(value: org.murtsi.capnproto.compiler.Type.Builder): Option[Builder] = {
        if (value._whichIndex == 18) Some(value.anyPointer) else None
      }

      class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
        private[AnyPointer] def parameter: org.murtsi.capnproto.compiler.Type.AnyPointer.Parameter.Reader = {
          org.murtsi.capnproto.compiler.Type.AnyPointer.Parameter.Reader(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit)
        }

        private[AnyPointer] def implicitMethodParameter: org.murtsi.capnproto.compiler.Type.AnyPointer.ImplicitMethodParameter.Reader = {
          org.murtsi.capnproto.compiler.Type.AnyPointer.ImplicitMethodParameter.Reader(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit)
        }

        private[AnyPointer] def _whichIndex: Short = _getShortField(4)
      }

      class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        private[AnyPointer] def parameter: org.murtsi.capnproto.compiler.Type.AnyPointer.Parameter.Builder = {
          org.murtsi.capnproto.compiler.Type.AnyPointer.Parameter.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
        }

        def initParameter(): org.murtsi.capnproto.compiler.Type.AnyPointer.Parameter.Builder = {
          _setShortField(4, 1)
          _setLongField(5, 0)
          _setShortField(2, 0)
          org.murtsi.capnproto.compiler.Type.AnyPointer.Parameter.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
        }

        private[AnyPointer] def implicitMethodParameter: org.murtsi.capnproto.compiler.Type.AnyPointer.ImplicitMethodParameter.Builder = {
          org.murtsi.capnproto.compiler.Type.AnyPointer.ImplicitMethodParameter.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
        }

        def initImplicitMethodParameter(): org.murtsi.capnproto.compiler.Type.AnyPointer.ImplicitMethodParameter.Builder = {
          _setShortField(4, 2)
          _setShortField(5, 0)
          org.murtsi.capnproto.compiler.Type.AnyPointer.ImplicitMethodParameter.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
        }

        private[AnyPointer] def _whichIndex: Short = _getShortField(4)
      }

      object Unconstrained {
        def unapply(value: org.murtsi.capnproto.compiler.Type.AnyPointer.Reader): Boolean = {
          value._whichIndex == 0
        }

        def unapply(value: org.murtsi.capnproto.compiler.Type.AnyPointer.Builder): Boolean = {
          value._whichIndex == 0
        }
      }

      object Parameter extends org.murtsi.capnproto.runtime.Struct {
        val typeId: Long = -7074601801531438459L
        override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(2, 1)

        override type Reader = ReaderImpl
        override type Builder = BuilderImpl

        override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
        override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

        def unapply(value: org.murtsi.capnproto.compiler.Type.AnyPointer.Reader): Option[Reader] = {
          if (value._whichIndex == 1) Some(value.parameter) else None
        }

        def unapply(value: org.murtsi.capnproto.compiler.Type.AnyPointer.Builder): Option[Builder] = {
          if (value._whichIndex == 1) Some(value.parameter) else None
        }

        class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
          def scopeId: Long = {
            this._getLongField(2)
          }

          def parameterIndex: Short = {
            this._getShortField(5)
          }
        }

        class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
          def scopeId: Long = {
            this._getLongField(2)
          }

          def scopeId_=(value: Long): Unit = {
            _setLongField(2, value)
          }

          def parameterIndex: Short = {
            this._getShortField(5)
          }

          def parameterIndex_=(value: Short): Unit = {
            _setShortField(5, value)
          }
        }

      }

      object ImplicitMethodParameter extends org.murtsi.capnproto.runtime.Struct {
        val typeId: Long = -4976537983867493772L
        override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(2, 1)

        override type Reader = ReaderImpl
        override type Builder = BuilderImpl

        override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
        override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

        def unapply(value: org.murtsi.capnproto.compiler.Type.AnyPointer.Reader): Option[Reader] = {
          if (value._whichIndex == 2) Some(value.implicitMethodParameter) else None
        }

        def unapply(value: org.murtsi.capnproto.compiler.Type.AnyPointer.Builder): Option[Builder] = {
          if (value._whichIndex == 2) Some(value.implicitMethodParameter) else None
        }

        class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
          def parameterIndex: Short = {
            this._getShortField(5)
          }
        }

        class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
          def parameterIndex: Short = {
            this._getShortField(5)
          }

          def parameterIndex_=(value: Short): Unit = {
            _setShortField(5, value)
          }
        }

      }

    }

  }

  object Brand extends org.murtsi.capnproto.runtime.Struct {
    val typeId: Long = -8055719342561213909L
    override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(0, 1)

    override type Reader = ReaderImpl
    override type Builder = BuilderImpl

    override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
      def scopes: Option[org.murtsi.capnproto.compiler.Brand.Scope.List.Reader] = {
        _getPointerFieldOption(org.murtsi.capnproto.compiler.Brand.Scope.List, 0)
      }
    }

    class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
      def scopes: Option[org.murtsi.capnproto.compiler.Brand.Scope.List.Builder] = {
        _getPointerFieldOption(org.murtsi.capnproto.compiler.Brand.Scope.List, 0)
      }

      def scopes_=(value: org.murtsi.capnproto.compiler.Brand.Scope.List.Reader): Unit = {
        _setPointerField(org.murtsi.capnproto.compiler.Brand.Scope.List)(0, value)
      }

      def initScopes(size: Int): org.murtsi.capnproto.compiler.Brand.Scope.List.Builder = {
        _initPointerField(org.murtsi.capnproto.compiler.Brand.Scope.List, 0, size)
      }
    }

    object Scope extends org.murtsi.capnproto.runtime.Struct {
      val typeId: Long = -6064320624553923639L
      override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(2, 1)

      override type Reader = ReaderImpl
      override type Builder = BuilderImpl

      override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
        def scopeId: Long = {
          this._getLongField(0)
        }

        private[Scope] def bind: Option[org.murtsi.capnproto.compiler.Brand.Binding.List.Reader] = {
          _getPointerFieldOption(org.murtsi.capnproto.compiler.Brand.Binding.List, 0)
        }

        private[Scope] def _whichIndex: Short = _getShortField(4)
      }

      class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        def scopeId: Long = {
          this._getLongField(0)
        }

        def scopeId_=(value: Long): Unit = {
          _setLongField(0, value)
        }

        private[Scope] def bind: Option[org.murtsi.capnproto.compiler.Brand.Binding.List.Builder] = {
          _getPointerFieldOption(org.murtsi.capnproto.compiler.Brand.Binding.List, 0)
        }

        def bind_=(value: org.murtsi.capnproto.compiler.Brand.Binding.List.Reader): Unit = {
          _setShortField(4, 0)
          _setPointerField(org.murtsi.capnproto.compiler.Brand.Binding.List)(0, value)
        }

        def initBind(size: Int): org.murtsi.capnproto.compiler.Brand.Binding.List.Builder = {
          _setShortField(4, 0)
          _initPointerField(org.murtsi.capnproto.compiler.Brand.Binding.List, 0, size)
        }

        def inherit_=(_value: Unit): Unit = {
          _setShortField(4, 1)
        }

        private[Scope] def _whichIndex: Short = _getShortField(4)
      }

      object Bind {
        def unapply(value: Reader): Option[org.murtsi.capnproto.compiler.Brand.Binding.List.Reader] = {
          if (value._whichIndex == 0) value.bind else None
        }

        def unapply(value: Builder): Option[org.murtsi.capnproto.compiler.Brand.Binding.List.Builder] = {
          if (value._whichIndex == 0) value.bind else None
        }
      }

      object Inherit {
        def unapply(value: Reader): Boolean = value._whichIndex == 1

        def unapply(value: Builder): Boolean = value._whichIndex == 1
      }

    }

    object Binding extends org.murtsi.capnproto.runtime.Struct {
      val typeId: Long = -4007133746529638404L
      override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(1, 1)

      override type Reader = ReaderImpl
      override type Builder = BuilderImpl

      override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
        private[Binding] def `type`: Option[org.murtsi.capnproto.compiler.Type.Reader] = {
          _getPointerFieldOption(org.murtsi.capnproto.compiler.Type, 0)
        }

        private[Binding] def _whichIndex: Short = _getShortField(0)
      }

      class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        def unbound_=(_value: Unit): Unit = {
          _setShortField(0, 0)
        }

        private[Binding] def `type`: Option[org.murtsi.capnproto.compiler.Type.Builder] = {
          _getPointerFieldOption(org.murtsi.capnproto.compiler.Type, 0)
        }

        def type_=(value: org.murtsi.capnproto.compiler.Type.Reader): Unit = {
          _setShortField(0, 1)
          _setPointerField(org.murtsi.capnproto.compiler.Type)(0, value)
        }

        def initType(): org.murtsi.capnproto.compiler.Type.Builder = {
          _setShortField(0, 1)
          _initPointerField(org.murtsi.capnproto.compiler.Type, 0, 0)
        }

        private[Binding] def _whichIndex: Short = _getShortField(0)
      }

      object Unbound {
        def unapply(value: Reader): Boolean = value._whichIndex == 0

        def unapply(value: Builder): Boolean = value._whichIndex == 0
      }

      object Type {
        def unapply(value: Reader): Option[org.murtsi.capnproto.compiler.Type.Reader] = {
          if (value._whichIndex == 1) value.`type` else None
        }

        def unapply(value: Builder): Option[org.murtsi.capnproto.compiler.Type.Builder] = {
          if (value._whichIndex == 1) value.`type` else None
        }
      }

    }

  }

  object Value extends org.murtsi.capnproto.runtime.Struct {
    val typeId: Long = -3592785279591641957L
    override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(2, 1)

    override type Reader = ReaderImpl
    override type Builder = BuilderImpl

    override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
      private[Value] def bool: Boolean = {
        _getBooleanField(16)
      }

      private[Value] def int8: Byte = {
        this._getByteField(2)
      }

      private[Value] def int16: Short = {
        this._getShortField(1)
      }

      private[Value] def int32: Int = {
        this._getIntField(1)
      }

      private[Value] def int64: Long = {
        this._getLongField(1)
      }

      private[Value] def uint8: Byte = {
        this._getByteField(2)
      }

      private[Value] def uint16: Short = {
        this._getShortField(1)
      }

      private[Value] def uint32: Int = {
        this._getIntField(1)
      }

      private[Value] def uint64: Long = {
        this._getLongField(1)
      }

      private[Value] def float32: Float = {
        this._getFloatField(1)
      }

      private[Value] def float64: Double = {
        this._getDoubleField(1)
      }

      private[Value] def text: Option[org.murtsi.capnproto.runtime.Text.Reader] = {
        _getPointerFieldOption(org.murtsi.capnproto.runtime.Text, 0)
      }

      private[Value] def data: Option[org.murtsi.capnproto.runtime.Data.Reader] = {
        _getPointerFieldOption(org.murtsi.capnproto.runtime.Data, 0)
      }

      private[Value] def list: Option[org.murtsi.capnproto.runtime.AnyPointer.Reader] = {
        _getPointerFieldOption(org.murtsi.capnproto.runtime.AnyPointer, 0)
      }

      private[Value] def enum: Short = {
        this._getShortField(1)
      }

      private[Value] def struct: Option[org.murtsi.capnproto.runtime.AnyPointer.Reader] = {
        _getPointerFieldOption(org.murtsi.capnproto.runtime.AnyPointer, 0)
      }

      private[Value] def anyPointer: Option[org.murtsi.capnproto.runtime.AnyPointer.Reader] = {
        _getPointerFieldOption(org.murtsi.capnproto.runtime.AnyPointer, 0)
      }

      private[Value] def _whichIndex: Short = _getShortField(0)
    }

    class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
      def void_=(_value: Unit): Unit = {
        _setShortField(0, 0)
      }

      private[Value] def bool: Boolean = {
        _getBooleanField(16)
      }

      def bool_=(value: Boolean): Unit = {
        _setShortField(0, 1)
        _setBooleanField(16, value)
      }

      private[Value] def int8: Byte = {
        this._getByteField(2)
      }

      def int8_=(value: Byte): Unit = {
        _setShortField(0, 2)
        _setByteField(2, value)
      }

      private[Value] def int16: Short = {
        this._getShortField(1)
      }

      def int16_=(value: Short): Unit = {
        _setShortField(0, 3)
        _setShortField(1, value)
      }

      private[Value] def int32: Int = {
        this._getIntField(1)
      }

      def int32_=(value: Int): Unit = {
        _setShortField(0, 4)
        _setIntField(1, value)
      }

      private[Value] def int64: Long = {
        this._getLongField(1)
      }

      def int64_=(value: Long): Unit = {
        _setShortField(0, 5)
        _setLongField(1, value)
      }

      private[Value] def uint8: Byte = {
        this._getByteField(2)
      }

      def uint8_=(value: Byte): Unit = {
        _setShortField(0, 6)
        _setByteField(2, value)
      }

      private[Value] def uint16: Short = {
        this._getShortField(1)
      }

      def uint16_=(value: Short): Unit = {
        _setShortField(0, 7)
        _setShortField(1, value)
      }

      private[Value] def uint32: Int = {
        this._getIntField(1)
      }

      def uint32_=(value: Int): Unit = {
        _setShortField(0, 8)
        _setIntField(1, value)
      }

      private[Value] def uint64: Long = {
        this._getLongField(1)
      }

      def uint64_=(value: Long): Unit = {
        _setShortField(0, 9)
        _setLongField(1, value)
      }

      private[Value] def float32: Float = {
        this._getFloatField(1)
      }

      def float32_=(value: Float): Unit = {
        _setShortField(0, 10)
        _setFloatField(1, value)
      }

      private[Value] def float64: Double = {
        this._getDoubleField(1)
      }

      def float64_=(value: Double): Unit = {
        _setShortField(0, 11)
        _setDoubleField(1, value)
      }

      private[Value] def text: Option[org.murtsi.capnproto.runtime.Text.Builder] = {
        _getPointerFieldOption(org.murtsi.capnproto.runtime.Text, 0)
      }

      def text_=(value: org.murtsi.capnproto.runtime.Text.Reader): Unit = {
        _setShortField(0, 12)
        _setPointerField(org.murtsi.capnproto.runtime.Text)(0, value)
      }

      def text_=(value: String): Unit = {
        _setPointerField(org.murtsi.capnproto.runtime.Text)(0, org.murtsi.capnproto.runtime.Text.Reader(value))
      }

      def initText(size: Int): org.murtsi.capnproto.runtime.Text.Builder = {
        _setShortField(0, 12)
        _initPointerField(org.murtsi.capnproto.runtime.Text, 0, size)
      }

      private[Value] def data: Option[org.murtsi.capnproto.runtime.Data.Builder] = {
        _getPointerFieldOption(org.murtsi.capnproto.runtime.Data, 0)
      }

      def data_=(value: org.murtsi.capnproto.runtime.Data.Reader): Unit = {
        _setShortField(0, 13)
        _setPointerField(org.murtsi.capnproto.runtime.Data)(0, value)
      }

      def initData(size: Int): org.murtsi.capnproto.runtime.Data.Builder = {
        _setShortField(0, 13)
        _initPointerField(org.murtsi.capnproto.runtime.Data, 0, size)
      }

      private[Value] def list: Option[org.murtsi.capnproto.runtime.AnyPointer.Builder] = {
        _getPointerFieldOption(org.murtsi.capnproto.runtime.AnyPointer, 0)
      }

      def list_=(value: org.murtsi.capnproto.runtime.AnyPointer.Reader): Unit = {
        _setShortField(0, 14)
      }

      def initList(size: Int = 0): org.murtsi.capnproto.runtime.AnyPointer.Builder = {
        _setShortField(0, 14)
        _initPointerField(org.murtsi.capnproto.runtime.AnyPointer, 0, size)
      }

      private[Value] def enum: Short = {
        this._getShortField(1)
      }

      def enum_=(value: Short): Unit = {
        _setShortField(0, 15)
        _setShortField(1, value)
      }

      private[Value] def struct: Option[org.murtsi.capnproto.runtime.AnyPointer.Builder] = {
        _getPointerFieldOption(org.murtsi.capnproto.runtime.AnyPointer, 0)
      }

      def struct_=(value: org.murtsi.capnproto.runtime.AnyPointer.Reader): Unit = {
        _setShortField(0, 16)
      }

      def initStruct(size: Int = 0): org.murtsi.capnproto.runtime.AnyPointer.Builder = {
        _setShortField(0, 16)
        _initPointerField(org.murtsi.capnproto.runtime.AnyPointer, 0, size)
      }

      def interface_=(_value: Unit): Unit = {
        _setShortField(0, 17)
      }

      private[Value] def anyPointer: Option[org.murtsi.capnproto.runtime.AnyPointer.Builder] = {
        _getPointerFieldOption(org.murtsi.capnproto.runtime.AnyPointer, 0)
      }

      def anyPointer_=(value: org.murtsi.capnproto.runtime.AnyPointer.Reader): Unit = {
        _setShortField(0, 18)
      }

      def initAnyPointer(size: Int = 0): org.murtsi.capnproto.runtime.AnyPointer.Builder = {
        _setShortField(0, 18)
        _initPointerField(org.murtsi.capnproto.runtime.AnyPointer, 0, size)
      }

      private[Value] def _whichIndex: Short = _getShortField(0)
    }

    object Void {
      def unapply(value: Reader): Boolean = value._whichIndex == 0

      def unapply(value: Builder): Boolean = value._whichIndex == 0
    }

    object Bool {
      def unapply(value: Reader): Option[Boolean] = {
        if (value._whichIndex == 1) Some(value.bool) else None
      }

      def unapply(value: Builder): Option[Boolean] = {
        if (value._whichIndex == 1) Some(value.bool) else None
      }
    }

    object Int8 {
      def unapply(value: Reader): Option[Byte] = {
        if (value._whichIndex == 2) Some(value.int8) else None
      }

      def unapply(value: Builder): Option[Byte] = {
        if (value._whichIndex == 2) Some(value.int8) else None
      }
    }

    object Int16 {
      def unapply(value: Reader): Option[Short] = {
        if (value._whichIndex == 3) Some(value.int16) else None
      }

      def unapply(value: Builder): Option[Short] = {
        if (value._whichIndex == 3) Some(value.int16) else None
      }
    }

    object Int32 {
      def unapply(value: Reader): Option[Int] = {
        if (value._whichIndex == 4) Some(value.int32) else None
      }

      def unapply(value: Builder): Option[Int] = {
        if (value._whichIndex == 4) Some(value.int32) else None
      }
    }

    object Int64 {
      def unapply(value: Reader): Option[Long] = {
        if (value._whichIndex == 5) Some(value.int64) else None
      }

      def unapply(value: Builder): Option[Long] = {
        if (value._whichIndex == 5) Some(value.int64) else None
      }
    }

    object Uint8 {
      def unapply(value: Reader): Option[Byte] = {
        if (value._whichIndex == 6) Some(value.uint8) else None
      }

      def unapply(value: Builder): Option[Byte] = {
        if (value._whichIndex == 6) Some(value.uint8) else None
      }
    }

    object Uint16 {
      def unapply(value: Reader): Option[Short] = {
        if (value._whichIndex == 7) Some(value.uint16) else None
      }

      def unapply(value: Builder): Option[Short] = {
        if (value._whichIndex == 7) Some(value.uint16) else None
      }
    }

    object Uint32 {
      def unapply(value: Reader): Option[Int] = {
        if (value._whichIndex == 8) Some(value.uint32) else None
      }

      def unapply(value: Builder): Option[Int] = {
        if (value._whichIndex == 8) Some(value.uint32) else None
      }
    }

    object Uint64 {
      def unapply(value: Reader): Option[Long] = {
        if (value._whichIndex == 9) Some(value.uint64) else None
      }

      def unapply(value: Builder): Option[Long] = {
        if (value._whichIndex == 9) Some(value.uint64) else None
      }
    }

    object Float32 {
      def unapply(value: Reader): Option[Float] = {
        if (value._whichIndex == 10) Some(value.float32) else None
      }

      def unapply(value: Builder): Option[Float] = {
        if (value._whichIndex == 10) Some(value.float32) else None
      }
    }

    object Float64 {
      def unapply(value: Reader): Option[Double] = {
        if (value._whichIndex == 11) Some(value.float64) else None
      }

      def unapply(value: Builder): Option[Double] = {
        if (value._whichIndex == 11) Some(value.float64) else None
      }
    }

    object Text {
      def unapply(value: Reader): Option[org.murtsi.capnproto.runtime.Text.Reader] = {
        if (value._whichIndex == 12) value.text else None
      }

      def unapply(value: Builder): Option[org.murtsi.capnproto.runtime.Text.Builder] = {
        if (value._whichIndex == 12) value.text else None
      }
    }

    object Data {
      def unapply(value: Reader): Option[org.murtsi.capnproto.runtime.Data.Reader] = {
        if (value._whichIndex == 13) value.data else None
      }

      def unapply(value: Builder): Option[org.murtsi.capnproto.runtime.Data.Builder] = {
        if (value._whichIndex == 13) value.data else None
      }
    }

    object List_ {
      def unapply(value: Reader): Option[org.murtsi.capnproto.runtime.AnyPointer.Reader] = {
        if (value._whichIndex == 14) value.list else None
      }

      def unapply(value: Builder): Option[org.murtsi.capnproto.runtime.AnyPointer.Builder] = {
        if (value._whichIndex == 14) value.list else None
      }
    }

    object Enum {
      def unapply(value: Reader): Option[Short] = {
        if (value._whichIndex == 15) Some(value.enum) else None
      }

      def unapply(value: Builder): Option[Short] = {
        if (value._whichIndex == 15) Some(value.enum) else None
      }
    }

    object Struct {
      def unapply(value: Reader): Option[org.murtsi.capnproto.runtime.AnyPointer.Reader] = {
        if (value._whichIndex == 16) value.struct else None
      }

      def unapply(value: Builder): Option[org.murtsi.capnproto.runtime.AnyPointer.Builder] = {
        if (value._whichIndex == 16) value.struct else None
      }
    }

    object Interface {
      def unapply(value: Reader): Boolean = value._whichIndex == 17

      def unapply(value: Builder): Boolean = value._whichIndex == 17
    }

    object AnyPointer {
      def unapply(value: Reader): Option[org.murtsi.capnproto.runtime.AnyPointer.Reader] = {
        if (value._whichIndex == 18) value.anyPointer else None
      }

      def unapply(value: Builder): Option[org.murtsi.capnproto.runtime.AnyPointer.Builder] = {
        if (value._whichIndex == 18) value.anyPointer else None
      }
    }

  }

  object Annotation extends org.murtsi.capnproto.runtime.Struct {
    val typeId: Long = -1024405029288315582L
    override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(1, 2)

    override type Reader = ReaderImpl
    override type Builder = BuilderImpl

    override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
      def id: Long = {
        this._getLongField(0)
      }

      def value: Option[org.murtsi.capnproto.compiler.Value.Reader] = {
        _getPointerFieldOption(org.murtsi.capnproto.compiler.Value, 0)
      }

      def brand: Option[org.murtsi.capnproto.compiler.Brand.Reader] = {
        _getPointerFieldOption(org.murtsi.capnproto.compiler.Brand, 1)
      }
    }

    class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
      def id: Long = {
        this._getLongField(0)
      }

      def id_=(value: Long): Unit = {
        _setLongField(0, value)
      }

      def value: Option[org.murtsi.capnproto.compiler.Value.Builder] = {
        _getPointerFieldOption(org.murtsi.capnproto.compiler.Value, 0)
      }

      def value_=(value: org.murtsi.capnproto.compiler.Value.Reader): Unit = {
        _setPointerField(org.murtsi.capnproto.compiler.Value)(0, value)
      }

      def initValue(): org.murtsi.capnproto.compiler.Value.Builder = {
        _initPointerField(org.murtsi.capnproto.compiler.Value, 0, 0)
      }

      def brand: Option[org.murtsi.capnproto.compiler.Brand.Builder] = {
        _getPointerFieldOption(org.murtsi.capnproto.compiler.Brand, 1)
      }

      def brand_=(value: org.murtsi.capnproto.compiler.Brand.Reader): Unit = {
        _setPointerField(org.murtsi.capnproto.compiler.Brand)(1, value)
      }

      def initBrand(): org.murtsi.capnproto.compiler.Brand.Builder = {
        _initPointerField(org.murtsi.capnproto.compiler.Brand, 1, 0)
      }
    }

  }

  sealed class ElementSize(index: Short) extends org.murtsi.capnproto.runtime.Enum(index)

  object ElementSize extends org.murtsi.capnproto.runtime.EnumModule[ElementSize] {
    override val enumValues: Seq[ElementSize] = Array(
      ElementSize.Empty,
      ElementSize.Bit,
      ElementSize.Byte,
      ElementSize.TwoBytes,
      ElementSize.FourBytes,
      ElementSize.EightBytes,
      ElementSize.Pointer,
      ElementSize.InlineComposite
    )
    val _wrappedValues: Seq[Option[ElementSize]] = enumValues.map(Some(_))

    def apply(value: Short): Option[ElementSize] = if (value >= 0 && value < _wrappedValues.length) _wrappedValues(value) else None

    object Empty extends ElementSize(0)

    object Bit extends ElementSize(1)

    object Byte extends ElementSize(2)

    object TwoBytes extends ElementSize(3)

    object FourBytes extends ElementSize(4)

    object EightBytes extends ElementSize(5)

    object Pointer extends ElementSize(6)

    object InlineComposite extends ElementSize(7)

  }

  object CodeGeneratorRequest extends org.murtsi.capnproto.runtime.Struct {
    val typeId: Long = -4628215019123058738L
    override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(0, 2)

    override type Reader = ReaderImpl
    override type Builder = BuilderImpl

    override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
      def nodes: Option[org.murtsi.capnproto.compiler.Node.List.Reader] = {
        _getPointerFieldOption(org.murtsi.capnproto.compiler.Node.List, 0)
      }

      def requestedFiles: Option[org.murtsi.capnproto.compiler.CodeGeneratorRequest.RequestedFile.List.Reader] = {
        _getPointerFieldOption(org.murtsi.capnproto.compiler.CodeGeneratorRequest.RequestedFile.List, 1)
      }
    }

    class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
      def nodes: Option[org.murtsi.capnproto.compiler.Node.List.Builder] = {
        _getPointerFieldOption(org.murtsi.capnproto.compiler.Node.List, 0)
      }

      def nodes_=(value: org.murtsi.capnproto.compiler.Node.List.Reader): Unit = {
        _setPointerField(org.murtsi.capnproto.compiler.Node.List)(0, value)
      }

      def initNodes(size: Int): org.murtsi.capnproto.compiler.Node.List.Builder = {
        _initPointerField(org.murtsi.capnproto.compiler.Node.List, 0, size)
      }

      def requestedFiles: Option[org.murtsi.capnproto.compiler.CodeGeneratorRequest.RequestedFile.List.Builder] = {
        _getPointerFieldOption(org.murtsi.capnproto.compiler.CodeGeneratorRequest.RequestedFile.List, 1)
      }

      def requestedFiles_=(value: org.murtsi.capnproto.compiler.CodeGeneratorRequest.RequestedFile.List.Reader): Unit = {
        _setPointerField(org.murtsi.capnproto.compiler.CodeGeneratorRequest.RequestedFile.List)(1, value)
      }

      def initRequestedFiles(size: Int): org.murtsi.capnproto.compiler.CodeGeneratorRequest.RequestedFile.List.Builder = {
        _initPointerField(org.murtsi.capnproto.compiler.CodeGeneratorRequest.RequestedFile.List, 1, size)
      }
    }

    object RequestedFile extends org.murtsi.capnproto.runtime.Struct {
      val typeId: Long = -3464940813450936222L
      override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(1, 2)

      override type Reader = ReaderImpl
      override type Builder = BuilderImpl

      override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
        def id: Long = {
          this._getLongField(0)
        }

        def filename: Option[org.murtsi.capnproto.runtime.Text.Reader] = {
          _getPointerFieldOption(org.murtsi.capnproto.runtime.Text, 0)
        }

        def imports: Option[org.murtsi.capnproto.compiler.CodeGeneratorRequest.RequestedFile.Import.List.Reader] = {
          _getPointerFieldOption(org.murtsi.capnproto.compiler.CodeGeneratorRequest.RequestedFile.Import.List, 1)
        }
      }

      class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        def id: Long = {
          this._getLongField(0)
        }

        def id_=(value: Long): Unit = {
          _setLongField(0, value)
        }

        def filename: Option[org.murtsi.capnproto.runtime.Text.Builder] = {
          _getPointerFieldOption(org.murtsi.capnproto.runtime.Text, 0)
        }

        def filename_=(value: org.murtsi.capnproto.runtime.Text.Reader): Unit = {
          _setPointerField(org.murtsi.capnproto.runtime.Text)(0, value)
        }

        def filename_=(value: String): Unit = {
          _setPointerField(org.murtsi.capnproto.runtime.Text)(0, org.murtsi.capnproto.runtime.Text.Reader(value))
        }

        def initFilename(size: Int): org.murtsi.capnproto.runtime.Text.Builder = {
          _initPointerField(org.murtsi.capnproto.runtime.Text, 0, size)
        }

        def imports: Option[org.murtsi.capnproto.compiler.CodeGeneratorRequest.RequestedFile.Import.List.Builder] = {
          _getPointerFieldOption(org.murtsi.capnproto.compiler.CodeGeneratorRequest.RequestedFile.Import.List, 1)
        }

        def imports_=(value: org.murtsi.capnproto.compiler.CodeGeneratorRequest.RequestedFile.Import.List.Reader): Unit = {
          _setPointerField(org.murtsi.capnproto.compiler.CodeGeneratorRequest.RequestedFile.Import.List)(1, value)
        }

        def initImports(size: Int): org.murtsi.capnproto.compiler.CodeGeneratorRequest.RequestedFile.Import.List.Builder = {
          _initPointerField(org.murtsi.capnproto.compiler.CodeGeneratorRequest.RequestedFile.Import.List, 1, size)
        }
      }

      object Import extends org.murtsi.capnproto.runtime.Struct {
        val typeId: Long = -5886132613052934171L
        override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(1, 1)

        override type Reader = ReaderImpl
        override type Builder = BuilderImpl

        override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
        override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

        class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
          def id: Long = {
            this._getLongField(0)
          }

          def name: Option[org.murtsi.capnproto.runtime.Text.Reader] = {
            _getPointerFieldOption(org.murtsi.capnproto.runtime.Text, 0)
          }
        }

        class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
          def id: Long = {
            this._getLongField(0)
          }

          def id_=(value: Long): Unit = {
            _setLongField(0, value)

            def name: Option[org.murtsi.capnproto.runtime.Text.Builder] = {
              _getPointerFieldOption(org.murtsi.capnproto.runtime.Text, 0)
            }

            /*
            def name_=(value: org.murtsi.capnproto.runtime.Text.Reader): Unit = {
              _setPointerField(org.murtsi.capnproto.runtime.Text)(0, value)
            }

            def name_=(value: String): Unit = {
              _setPointerField(org.murtsi.capnproto.runtime.Text)(0, org.murtsi.capnproto.runtime.Text.Reader(value))
            }
            */

            def initName(size: Int): org.murtsi.capnproto.runtime.Text.Builder = {
              _initPointerField(org.murtsi.capnproto.runtime.Text, 0, size)
            }
          }

        }

      }

    }
  }
  */
}
