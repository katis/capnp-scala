package org.capnproto.compiler

import org.capnproto._

object CapnpSchema {

  object Node extends org.capnproto.Struct {
    type Builder = BuilderImpl
    type Reader = ReaderImpl

    override val Builder: (SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    def structSize: StructSize = {
      Node.STRUCT_SIZE
    }

    val STRUCT_SIZE: StructSize = new StructSize(5.toShort, 6.toShort)

    final class BuilderImpl private[compiler](segment: SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends super.BuilderBase(segment, dataOffset, pointers, dataSize, pointerCount) {
      def which: CapnpSchema.Node.Which.Which = {
        _getShortField(6) match {
          case 0 =>
            Which.FILE
          case 1 =>
            Which.STRUCT
          case 2 =>
            Which.ENUM
          case 3 =>
            Which.INTERFACE
          case 4 =>
            Which.CONST
          case 5 =>
            Which.ANNOTATION
          case _ =>
            Which._NOT_IN_SCHEMA
        }
      }

      def id: Long = {
        _getLongField(0)
      }

      def id_=(value: Long) {
        _setLongField(0, value)
      }

      def hasDisplayName: Boolean = {
        !_pointerFieldIsNull(0)
      }

      def displayname: Text.Builder = {
        _getPointerField(org.capnproto.Text, 0, null, 0, 0)
      }

      def displayname_=(value: Text.Reader) {
        _setPointerField(org.capnproto.Text)(0, value)
      }

      def displayname_=(value: String) {
        _setPointerField(org.capnproto.Text)(0, org.capnproto.Text.Reader(value))
      }

      def initDisplayName(size: Int): Text.Builder = {
        _initPointerField(org.capnproto.Text, 0, size)
      }

      def displaynameprefixlength: Int = {
        _getIntField(2)
      }

      def displaynameprefixlength_=(value: Int) {
        _setIntField(2, value)
      }

      def scopeid: Long = {
        _getLongField(2)
      }

      def scopeid_=(value: Long) {
        _setLongField(2, value)
      }

      def hasNestedNodes: Boolean = {
        !_pointerFieldIsNull(1)
      }

      def nestednodes: CapnpSchema.Node.NestedNode.List.Builder = {
        _getPointerField(CapnpSchema.Node.NestedNode.List, 1, null, 0)
      }

      def nestednodes_=(value: CapnpSchema.Node.NestedNode.List.Reader) {
        _setPointerField(CapnpSchema.Node.NestedNode.List)(1, value)
      }

      def initNestedNodes(size: Int): CapnpSchema.Node.NestedNode.List.Builder = {
        _initPointerField(CapnpSchema.Node.NestedNode.List, 1, size)
      }

      def hasAnnotations: Boolean = {
        !_pointerFieldIsNull(2)
      }

      def annotations: CapnpSchema.Annotation.List.Builder = {
        _getPointerField(CapnpSchema.Annotation.List, 2, null, 0)
      }

      def annotations_=(value: CapnpSchema.Annotation.List.Reader) {
        _setPointerField(CapnpSchema.Annotation.List)(2, value)
      }

      def initAnnotations(size: Int): CapnpSchema.Annotation.List.Builder = {
        _initPointerField(CapnpSchema.Annotation.List, 2, size)
      }

      def isFile: Boolean = {
        which == Node.Which.FILE
      }

      def file: Void = {
        assert(which == Node.Which.FILE, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def file_=(value: Void) {
        _setShortField(6, Node.Which.FILE.id.toShort)
      }

      def isStruct: Boolean = {
        which == Node.Which.STRUCT
      }

      def struct: CapnpSchema.Node.Struct.Builder = {
        CapnpSchema.Node.Struct.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
      }

      def initStruct: CapnpSchema.Node.Struct.Builder = {
        _setShortField(6, Node.Which.STRUCT.id.toShort)
        _setShortField(7, 0.toShort)
        _setShortField(12, 0.toShort)
        _setShortField(13, 0.toShort)
        _setBooleanField(224, value = false)
        _setShortField(15, 0.toShort)
        _setIntField(8, 0)
        _clearPointerField(3)
        CapnpSchema.Node.Struct.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
      }

      def isEnum: Boolean = {
        which == Node.Which.ENUM
      }

      def enum: CapnpSchema.Node.Enum.Builder = {
        CapnpSchema.Node.Enum.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
      }

      def initEnum: CapnpSchema.Node.Enum.Builder = {
        _setShortField(6, Node.Which.ENUM.id.toShort)
        _clearPointerField(3)
        CapnpSchema.Node.Enum.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
      }

      def isInterface: Boolean = {
        which == Node.Which.INTERFACE
      }

      def interface: CapnpSchema.Node.Interface.Builder = {
        CapnpSchema.Node.Interface.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
      }

      def initInterface: CapnpSchema.Node.Interface.Builder = {
        _setShortField(6, Node.Which.INTERFACE.id.toShort)
        _clearPointerField(3)
        _clearPointerField(4)
        CapnpSchema.Node.Interface.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
      }

      def isConst: Boolean = {
        which == Node.Which.CONST
      }

      def const: CapnpSchema.Node.Const.Builder = {
        CapnpSchema.Node.Const.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
      }

      def initConst: CapnpSchema.Node.Const.Builder = {
        _setShortField(6, Node.Which.CONST.id.toShort)
        _clearPointerField(3)
        _clearPointerField(4)
        CapnpSchema.Node.Const.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
      }

      def isAnnotation: Boolean = {
        which == Node.Which.ANNOTATION
      }

      def annotation: CapnpSchema.Node.Annotation.Builder = {
        CapnpSchema.Node.Annotation.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
      }

      def initAnnotation: CapnpSchema.Node.Annotation.Builder = {
        _setShortField(6, Node.Which.ANNOTATION.id.toShort)
        _setBooleanField(112, value = false)
        _setBooleanField(113, value = false)
        _setBooleanField(114, value = false)
        _setBooleanField(115, value = false)
        _setBooleanField(116, value = false)
        _setBooleanField(117, value = false)
        _setBooleanField(118, value = false)
        _setBooleanField(119, value = false)
        _setBooleanField(120, value = false)
        _setBooleanField(121, value = false)
        _setBooleanField(122, value = false)
        _setBooleanField(123, value = false)
        _clearPointerField(3)
        CapnpSchema.Node.Annotation.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
      }

      def hasParameters: Boolean = {
        !_pointerFieldIsNull(5)
      }

      def parameters: CapnpSchema.Node.Parameter.List.Builder = {
        _getPointerField(CapnpSchema.Node.Parameter.List, 5, null, 0)
      }

      def parameters_=(value: CapnpSchema.Node.Parameter.List.Reader) {
        _setPointerField(CapnpSchema.Node.Parameter.List)(5, value)
      }

      def initParameters(size: Int): CapnpSchema.Node.Parameter.List.Builder = {
        _initPointerField(CapnpSchema.Node.Parameter.List, 5, size)
      }

      def isgeneric: Boolean = {
        _getBooleanField(288)
      }

      def isgeneric_=(value: Boolean) {
        _setBooleanField(288, value)
      }
    }

    final class ReaderImpl private[compiler](segment: SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends super.ReaderBase(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit) {
      def which: CapnpSchema.Node.Which.Which = {
        _getShortField(6) match {
          case 0 =>
            Which.FILE
          case 1 =>
            Which.STRUCT
          case 2 =>
            Which.ENUM
          case 3 =>
            Which.INTERFACE
          case 4 =>
            Which.CONST
          case 5 =>
            Which.ANNOTATION
          case _ =>
            Which._NOT_IN_SCHEMA
        }
      }

      def id: Long = {
        _getLongField(0)
      }

      def hasDisplayName: Boolean = {
        !_pointerFieldIsNull(0)
      }

      def displayname: Text.Reader = {
        _getPointerField(org.capnproto.Text, 0, null, 0, 0)
      }

      def displaynameprefixlength: Int = {
        _getIntField(2)
      }

      def scopeid: Long = {
        _getLongField(2)
      }

      def hasNestedNodes: Boolean = {
        !_pointerFieldIsNull(1)
      }

      def nestednodes: CapnpSchema.Node.NestedNode.List.Reader = {
        _getPointerField(CapnpSchema.Node.NestedNode.List, 1, null, 0)
      }

      def hasAnnotations: Boolean = {
        !_pointerFieldIsNull(2)
      }

      def annotations: CapnpSchema.Annotation.List.Reader = {
        _getPointerField(CapnpSchema.Annotation.List, 2, null, 0)
      }

      def isFile: Boolean = {
        which == Node.Which.FILE
      }

      def file: Void = {
        assert(which == Node.Which.FILE, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def isStruct: Boolean = {
        which == Node.Which.STRUCT
      }

      def struct: CapnpSchema.Node.Struct.Reader = {
        CapnpSchema.Node.Struct.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
      }

      def isEnum: Boolean = {
        which == Node.Which.ENUM
      }

      def enum: CapnpSchema.Node.Enum.Reader = {
        CapnpSchema.Node.Enum.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
      }

      def isInterface: Boolean = {
        which == Node.Which.INTERFACE
      }

      def interface: CapnpSchema.Node.Interface.Reader = {
        CapnpSchema.Node.Interface.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
      }

      def isConst: Boolean = {
        which == Node.Which.CONST
      }

      def const: CapnpSchema.Node.Const.Reader = {
        CapnpSchema.Node.Const.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
      }

      def isAnnotation: Boolean = {
        which == Node.Which.ANNOTATION
      }

      def annotation: CapnpSchema.Node.Annotation.Reader = {
        CapnpSchema.Node.Annotation.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
      }

      def hasParameters: Boolean = {
        !_pointerFieldIsNull(5)
      }

      def parameters: CapnpSchema.Node.Parameter.List.Reader = {
        _getPointerField(CapnpSchema.Node.Parameter.List, 5, null, 0)
      }

      def isgeneric: Boolean = {
        _getBooleanField(288)
      }
    }

    object Which extends Enumeration {
      type Which = Value
      val FILE, STRUCT, ENUM, INTERFACE, CONST, ANNOTATION, _NOT_IN_SCHEMA = Value
    }

    object Parameter extends org.capnproto.Struct {
      type Builder = BuilderImpl
      type Reader = ReaderImpl

      override def Builder: (SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)

      override def Reader: (SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      val STRUCT_SIZE: StructSize = new StructSize(0.toShort, 1.toShort)

      def structSize: StructSize = {
        Node.Parameter.STRUCT_SIZE
      }

      final class BuilderImpl private[compiler](segment: SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends super.BuilderBase(segment, dataOffset, pointers, dataSize, pointerCount) {

        def hasName: Boolean = {
          !_pointerFieldIsNull(0)
        }

        def name: Text.Builder = {
          _getPointerField(org.capnproto.Text, 0, null, 0, 0)
        }

        def name_=(value: Text.Reader) {
          _setPointerField(org.capnproto.Text)(0, value)
        }

        def name_=(value: String) {
          _setPointerField(org.capnproto.Text)(0, Text.Reader(value))
        }

        def initName(size: Int): Text.Builder = {
          _initPointerField(org.capnproto.Text, 0, size)
        }
      }

      final class ReaderImpl private[compiler](segment: SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends super.ReaderBase(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit) {
        def hasName: Boolean = {
          !_pointerFieldIsNull(0)
        }

        def name: Text.Reader = {
          _getPointerField(org.capnproto.Text, 0, null, 0, 0)
        }
      }

    }

    object NestedNode extends org.capnproto.Struct {
      type Builder = BuilderImpl
      type Reader = ReaderImpl

      override def Builder: (SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)

      override def Reader: (SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def constructReader(segment: SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): CapnpSchema.Node.NestedNode.Reader = {
        CapnpSchema.Node.NestedNode.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
      }

      def constructBuilder(segment: SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): CapnpSchema.Node.NestedNode.Builder = {
        CapnpSchema.Node.NestedNode.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
      }

      def structSize: StructSize = {
        Node.NestedNode.STRUCT_SIZE
      }

      val STRUCT_SIZE: StructSize = new StructSize(1.toShort, 1.toShort)

      final class BuilderImpl private[compiler](segment: SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends super.BuilderBase(segment, dataOffset, pointers, dataSize, pointerCount) {

        def hasName: Boolean = {
          !_pointerFieldIsNull(0)
        }

        def name: Text.Builder = {
          _getPointerField(org.capnproto.Text, 0, null, 0, 0)
        }

        def name_=(value: Text.Reader) {
          _setPointerField(org.capnproto.Text)(0, value)
        }

        def name_=(value: String) {
          _setPointerField(org.capnproto.Text)(0, new Text.Reader(value))
        }

        def initName(size: Int): Text.Builder = {
          _initPointerField(org.capnproto.Text, 0, size)
        }

        def id: Long = {
          _getLongField(0)
        }

        def id_=(value: Long) {
          _setLongField(0, value)
        }
      }

      final class ReaderImpl private[compiler](segment: SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends super.ReaderBase(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit) {
        def hasName: Boolean = {
          !_pointerFieldIsNull(0)
        }

        def name: Text.Reader = {
          _getPointerField(org.capnproto.Text, 0, null, 0, 0)
        }

        def id: Long = {
          _getLongField(0)
        }
      }

    }

    object Struct extends org.capnproto.Struct {
      type Builder = BuilderImpl
      type Reader = ReaderImpl

      override def Builder: (SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)

      override def Reader: (SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      val STRUCT_SIZE: StructSize = new StructSize(5.toShort, 6.toShort)

      def constructReader(segment: SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): CapnpSchema.Node.Struct.Reader = {
        CapnpSchema.Node.Struct.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
      }

      def constructBuilder(segment: SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): CapnpSchema.Node.Struct.Builder = {
        CapnpSchema.Node.Struct.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
      }

      def structSize: StructSize = {
        Node.Struct.STRUCT_SIZE
      }

      final class BuilderImpl private[compiler](segment: SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends super.BuilderBase(segment, dataOffset, pointers, dataSize, pointerCount) {

        def datawordcount: Short = {
          _getShortField(7)
        }

        def datawordcount_=(value: Short) {
          _setShortField(7, value)
        }

        def pointercount: Short = {
          _getShortField(12)
        }

        def pointercount_=(value: Short) {
          _setShortField(12, value)
        }

        def preferredlistencoding: CapnpSchema.ElementSize.ElementSize = {
          _getShortField(13) match {
            case 0 =>
              CapnpSchema.ElementSize.EMPTY
            case 1 =>
              CapnpSchema.ElementSize.BIT
            case 2 =>
              CapnpSchema.ElementSize.BYTE
            case 3 =>
              CapnpSchema.ElementSize.TWO_BYTES
            case 4 =>
              CapnpSchema.ElementSize.FOUR_BYTES
            case 5 =>
              CapnpSchema.ElementSize.EIGHT_BYTES
            case 6 =>
              CapnpSchema.ElementSize.POINTER
            case 7 =>
              CapnpSchema.ElementSize.INLINE_COMPOSITE
            case _ =>
              CapnpSchema.ElementSize._NOT_IN_SCHEMA
          }
        }

        def preferredlistencoding_=(value: CapnpSchema.ElementSize.ElementSize) {
          _setShortField(13, value.id.toShort)
        }

        def isgroup: Boolean = {
          _getBooleanField(224)
        }

        def isgroup_=(value: Boolean) {
          _setBooleanField(224, value)
        }

        def discriminantcount: Short = {
          _getShortField(15)
        }

        def discriminantcount_=(value: Short) {
          _setShortField(15, value)
        }

        def discriminantoffset: Int = {
          _getIntField(8)
        }

        def discriminantoffset_=(value: Int) {
          _setIntField(8, value)
        }

        def hasFields: Boolean = {
          !_pointerFieldIsNull(3)
        }

        def fields: CapnpSchema.Field.List.Builder = {
          _getPointerField(CapnpSchema.Field.List, 3, null, 0)
        }

        def fields_=(value: CapnpSchema.Field.List.Reader) {
          _setPointerField(CapnpSchema.Field.List)(3, value)
        }

        def initFields(size: Int): CapnpSchema.Field.List.Builder = {
          _initPointerField(CapnpSchema.Field.List, 3, size)
        }
      }

      final class ReaderImpl private[compiler](segment: SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends super.ReaderBase(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit) {
        def datawordcount: Short = {
          _getShortField(7)
        }

        def pointercount: Short = {
          _getShortField(12)
        }

        def preferredlistencoding: CapnpSchema.ElementSize.ElementSize = {
          _getShortField(13) match {
            case 0 =>
              CapnpSchema.ElementSize.EMPTY
            case 1 =>
              CapnpSchema.ElementSize.BIT
            case 2 =>
              CapnpSchema.ElementSize.BYTE
            case 3 =>
              CapnpSchema.ElementSize.TWO_BYTES
            case 4 =>
              CapnpSchema.ElementSize.FOUR_BYTES
            case 5 =>
              CapnpSchema.ElementSize.EIGHT_BYTES
            case 6 =>
              CapnpSchema.ElementSize.POINTER
            case 7 =>
              CapnpSchema.ElementSize.INLINE_COMPOSITE
            case _ =>
              CapnpSchema.ElementSize._NOT_IN_SCHEMA
          }
        }

        def isgroup: Boolean = {
          _getBooleanField(224)
        }

        def discriminantcount: Short = {
          _getShortField(15)
        }

        def discriminantoffset: Int = {
          _getIntField(8)
        }

        def hasFields: Boolean = {
          !_pointerFieldIsNull(3)
        }

        def fields: CapnpSchema.Field.List.Reader = {
          _getPointerField(CapnpSchema.Field.List, 3, null, 0)
        }
      }

    }

    object Enum extends org.capnproto.Struct {
      type Builder = BuilderImpl
      type Reader = ReaderImpl

      override def Builder: (SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)

      override def Reader: (SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def structSize: StructSize = {
        Node.Enum.STRUCT_SIZE
      }

      val STRUCT_SIZE: StructSize = new StructSize(5.toShort, 6.toShort)

      final class BuilderImpl private[compiler](segment: SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends super.BuilderBase(segment, dataOffset, pointers, dataSize, pointerCount) {

        def hasEnumerants: Boolean = {
          !_pointerFieldIsNull(3)
        }

        def enumerants: CapnpSchema.Enumerant.List.Builder = {
          _getPointerField(CapnpSchema.Enumerant.List, 3, null, 0)
        }

        def enumerants_=(value: CapnpSchema.Enumerant.List.Reader) {
          _setPointerField(CapnpSchema.Enumerant.List)(3, value)
        }

        def initEnumerants(size: Int): CapnpSchema.Enumerant.List.Builder = {
          _initPointerField(CapnpSchema.Enumerant.List, 3, size)
        }
      }

      final class ReaderImpl private[compiler](segment: SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends super.ReaderBase(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit) {
        def hasEnumerants: Boolean = {
          !_pointerFieldIsNull(3)
        }

        def enumerants: CapnpSchema.Enumerant.List.Reader = {
          _getPointerField(CapnpSchema.Enumerant.List, 3, null, 0)
        }
      }

    }

    object Interface extends org.capnproto.Struct {
      type Builder = BuilderImpl
      type Reader = ReaderImpl

      override def Builder: (SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)

      override def Reader: (SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def structSize: StructSize = {
        Node.Interface.STRUCT_SIZE
      }

      val STRUCT_SIZE: StructSize = new StructSize(5.toShort, 6.toShort)

      final class BuilderImpl private[compiler](segment: SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends super.BuilderBase(segment, dataOffset, pointers, dataSize, pointerCount) {

        def hasMethods: Boolean = {
          !_pointerFieldIsNull(3)
        }

        def methods: CapnpSchema.Method.List.Builder = {
          _getPointerField(CapnpSchema.Method.List, 3, null, 0)
        }

        def methods_=(value: CapnpSchema.Method.List.Reader) {
          _setPointerField(CapnpSchema.Method.List)(3, value)
        }

        def initMethods(size: Int): CapnpSchema.Method.List.Builder = {
          _initPointerField(CapnpSchema.Method.List, 3, size)
        }

        def hasSuperclasses: Boolean = {
          !_pointerFieldIsNull(4)
        }

        def superclasses: CapnpSchema.Superclass.List.Builder = {
          _getPointerField(CapnpSchema.Superclass.List, 4, null, 0)
        }

        def superclasses_=(value: CapnpSchema.Superclass.List.Reader) {
          _setPointerField(CapnpSchema.Superclass.List)(4, value)
        }

        def initSuperclasses(size: Int): CapnpSchema.Superclass.List.Builder = {
          _initPointerField(CapnpSchema.Superclass.List, 4, size)
        }
      }

      final class ReaderImpl private[compiler](segment: SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends super.ReaderBase(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit) {
        def hasMethods: Boolean = {
          !_pointerFieldIsNull(3)
        }

        def methods: CapnpSchema.Method.List.Reader = {
          _getPointerField(CapnpSchema.Method.List, 3, null, 0)
        }

        def hasSuperclasses: Boolean = {
          !_pointerFieldIsNull(4)
        }

        def superclasses: CapnpSchema.Superclass.List.Reader = {
          _getPointerField(CapnpSchema.Superclass.List, 4, null, 0)
        }
      }

    }

    object Const extends org.capnproto.Struct {
      type Builder = BuilderImpl
      type Reader = ReaderImpl

      override def Builder: (SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)

      override def Reader: (SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def structSize: StructSize = {
        Node.Const.STRUCT_SIZE
      }

      val STRUCT_SIZE: StructSize = new StructSize(5.toShort, 6.toShort)

      final class BuilderImpl private[compiler](segment: SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends super.BuilderBase(segment, dataOffset, pointers, dataSize, pointerCount) {

        def capnpType: CapnpSchema.Type.Builder = {
          _getPointerField(CapnpSchema.Type, 3, null, 0)
        }

        def capnpType_=(value: CapnpSchema.Type.Reader) {
          _setPointerField(CapnpSchema.Type)(3, value)
        }

        def initType: CapnpSchema.Type.Builder = {
          _initPointerField(CapnpSchema.Type, 3, 0)
        }

        def value: CapnpSchema.Value.Builder = {
          _getPointerField(CapnpSchema.Value, 4, null, 0)
        }

        def value_=(value: CapnpSchema.Value.Reader) {
          _setPointerField(CapnpSchema.Value)(4, value)
        }

        def initValue: CapnpSchema.Value.Builder = {
          _initPointerField(CapnpSchema.Value, 4, 0)
        }
      }

      final class ReaderImpl private[compiler](segment: SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends super.ReaderBase(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit) {
        def hasType: Boolean = {
          !_pointerFieldIsNull(3)
        }

        def capnpType: CapnpSchema.Type.Reader = {
          _getPointerField(CapnpSchema.Type, 3, null, 0)
        }

        def hasValue: Boolean = {
          !_pointerFieldIsNull(4)
        }

        def value: CapnpSchema.Value.Reader = {
          _getPointerField(CapnpSchema.Value, 4, null, 0)
        }
      }

    }

    object Annotation extends org.capnproto.Struct {
      type Builder = BuilderImpl
      type Reader = ReaderImpl

      override def Builder: (SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)

      override def Reader: (SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def structSize: StructSize = {
        Node.Annotation.STRUCT_SIZE
      }

      val STRUCT_SIZE: StructSize = new StructSize(5.toShort, 6.toShort)

      final class BuilderImpl private[compiler](segment: SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends super.BuilderBase(segment, dataOffset, pointers, dataSize, pointerCount) {

        def capnpType: CapnpSchema.Type.Builder = {
          _getPointerField(CapnpSchema.Type, 3, null, 0)
        }

        def capnpType_=(value: CapnpSchema.Type.Reader) {
          _setPointerField(CapnpSchema.Type)(3, value)
        }

        def initType: CapnpSchema.Type.Builder = {
          _initPointerField(CapnpSchema.Type, 3, 0)
        }

        def targetsfile: Boolean = {
          _getBooleanField(112)
        }

        def targetsfile_=(value: Boolean) {
          _setBooleanField(112, value)
        }

        def targetsconst: Boolean = {
          _getBooleanField(113)
        }

        def targetsconst_=(value: Boolean) {
          _setBooleanField(113, value)
        }

        def targetsenum: Boolean = {
          _getBooleanField(114)
        }

        def targetsenum_=(value: Boolean) {
          _setBooleanField(114, value)
        }

        def targetsenumerant: Boolean = {
          _getBooleanField(115)
        }

        def targetsenumerant_=(value: Boolean) {
          _setBooleanField(115, value)
        }

        def targetsstruct: Boolean = {
          _getBooleanField(116)
        }

        def targetsstruct_=(value: Boolean) {
          _setBooleanField(116, value)
        }

        def targetsfield: Boolean = {
          _getBooleanField(117)
        }

        def targetsfield_=(value: Boolean) {
          _setBooleanField(117, value)
        }

        def targetsunion: Boolean = {
          _getBooleanField(118)
        }

        def targetsunion_=(value: Boolean) {
          _setBooleanField(118, value)
        }

        def targetsgroup: Boolean = {
          _getBooleanField(119)
        }

        def targetsgroup_=(value: Boolean) {
          _setBooleanField(119, value)
        }

        def targetsinterface: Boolean = {
          _getBooleanField(120)
        }

        def targetsinterface_=(value: Boolean) {
          _setBooleanField(120, value)
        }

        def targetsmethod: Boolean = {
          _getBooleanField(121)
        }

        def targetsmethod_=(value: Boolean) {
          _setBooleanField(121, value)
        }

        def targetsparam: Boolean = {
          _getBooleanField(122)
        }

        def targetsparam_=(value: Boolean) {
          _setBooleanField(122, value)
        }

        def targetsannotation: Boolean = {
          _getBooleanField(123)
        }

        def targetsannotation_=(value: Boolean) {
          _setBooleanField(123, value)
        }
      }

      final class ReaderImpl private[compiler](segment: SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends super.ReaderBase(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit) {
        def hasType: Boolean = {
          !_pointerFieldIsNull(3)
        }

        def capnpType: CapnpSchema.Type.Reader = {
          _getPointerField(CapnpSchema.Type, 3, null, 0)
        }

        def targetsfile: Boolean = {
          _getBooleanField(112)
        }

        def targetsconst: Boolean = {
          _getBooleanField(113)
        }

        def targetsenum: Boolean = {
          _getBooleanField(114)
        }

        def targetsenumerant: Boolean = {
          _getBooleanField(115)
        }

        def targetsstruct: Boolean = {
          _getBooleanField(116)
        }

        def targetsfield: Boolean = {
          _getBooleanField(117)
        }

        def targetsunion: Boolean = {
          _getBooleanField(118)
        }

        def targetsgroup: Boolean = {
          _getBooleanField(119)
        }

        def targetsinterface: Boolean = {
          _getBooleanField(120)
        }

        def targetsmethod: Boolean = {
          _getBooleanField(121)
        }

        def targetsparam: Boolean = {
          _getBooleanField(122)
        }

        def targetsannotation: Boolean = {
          _getBooleanField(123)
        }
      }

    }

  }

  object Field extends org.capnproto.Struct {
    type Builder = BuilderImpl
    type Reader = ReaderImpl

    override val Builder: (SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    def structSize: StructSize = {
      Field.STRUCT_SIZE
    }

    val STRUCT_SIZE: StructSize = new StructSize(3.toShort, 4.toShort)

    final class BuilderImpl private[compiler](segment: SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends super.BuilderBase(segment, dataOffset, pointers, dataSize, pointerCount) {
      def which: CapnpSchema.Field.Which.Which = {
        _getShortField(4) match {
          case 0 =>
            Which.SLOT
          case 1 =>
            Which.GROUP
          case _ =>
            Which._NOT_IN_SCHEMA
        }
      }

      def hasName: Boolean = {
        !_pointerFieldIsNull(0)
      }

      def name: Text.Builder = {
        _getPointerField(org.capnproto.Text, 0, null, 0, 0)
      }

      def name_=(value: Text.Reader) {
        _setPointerField(org.capnproto.Text)(0, value)
      }

      def name_=(value: String) {
        _setPointerField(org.capnproto.Text)(0, new Text.Reader(value))
      }

      def initName(size: Int): Text.Builder = {
        _initPointerField(org.capnproto.Text, 0, size)
      }

      def codeorder: Short = {
        _getShortField(0)
      }

      def codeorder_=(value: Short) {
        _setShortField(0, value)
      }

      def hasAnnotations: Boolean = {
        !_pointerFieldIsNull(1)
      }

      def annotations: CapnpSchema.Annotation.List.Builder = {
        _getPointerField(CapnpSchema.Annotation.List, 1, null, 0)
      }

      def annotations_=(value: CapnpSchema.Annotation.List.Reader) {
        _setPointerField(CapnpSchema.Annotation.List)(1, value)
      }

      def initAnnotations(size: Int): CapnpSchema.Annotation.List.Builder = {
        _initPointerField(CapnpSchema.Annotation.List, 1, size)
      }

      def discriminantvalue: Short = {
        _getShortField(1, (-1).toShort)
      }

      def discriminantvalue_=(value: Short) {
        _setShortField(1, value, (-1).toShort)
      }

      def isSlot: Boolean = {
        which == Field.Which.SLOT
      }

      def slot: CapnpSchema.Field.Slot.Builder = {
        CapnpSchema.Field.Slot.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
      }

      def initSlot: CapnpSchema.Field.Slot.Builder = {
        _setShortField(4, Field.Which.SLOT.id.toShort)
        _setIntField(1, 0)
        _setBooleanField(128, value = false)
        _clearPointerField(2)
        _clearPointerField(3)
        CapnpSchema.Field.Slot.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
      }

      def isGroup: Boolean = {
        which == Field.Which.GROUP
      }

      def group: CapnpSchema.Field.Group.Builder = {
        CapnpSchema.Field.Group.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
      }

      def initGroup: CapnpSchema.Field.Group.Builder = {
        _setShortField(4, Field.Which.GROUP.id.toShort)
        _setLongField(2, 0L)
        CapnpSchema.Field.Group.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
      }

      def ordinal: CapnpSchema.Field.Ordinal.Builder = {
        CapnpSchema.Field.Ordinal.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
      }

      def initOrdinal: CapnpSchema.Field.Ordinal.Builder = {
        _setShortField(5, 0.toShort)
        _setShortField(6, 0.toShort)
        CapnpSchema.Field.Ordinal.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
      }
    }

    final class ReaderImpl private[compiler](segment: SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends super.ReaderBase(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit) {
      def which: CapnpSchema.Field.Which.Which = {
        _getShortField(4) match {
          case 0 =>
            Which.SLOT
          case 1 =>
            Which.GROUP
          case _ =>
            Which._NOT_IN_SCHEMA
        }
      }

      def hasName: Boolean = {
        !_pointerFieldIsNull(0)
      }

      def name: Text.Reader = {
        _getPointerField(org.capnproto.Text, 0, null, 0, 0)
      }

      def codeorder: Short = {
        _getShortField(0)
      }

      def hasAnnotations: Boolean = {
        !_pointerFieldIsNull(1)
      }

      def annotations: CapnpSchema.Annotation.List.Reader = {
        _getPointerField(CapnpSchema.Annotation.List, 1, null, 0)
      }

      def discriminantvalue: Short = {
        _getShortField(1, (-1).toShort)
      }

      def isSlot: Boolean = {
        which == Field.Which.SLOT
      }

      def slot: CapnpSchema.Field.Slot.Reader = {
        CapnpSchema.Field.Slot.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
      }

      def isGroup: Boolean = {
        which == Field.Which.GROUP
      }

      def group: CapnpSchema.Field.Group.Reader = {
        CapnpSchema.Field.Group.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
      }

      def ordinal: CapnpSchema.Field.Ordinal.Reader = {
        CapnpSchema.Field.Ordinal.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
      }
    }

    object Which extends Enumeration {
      type Which = Value
      val SLOT, GROUP, _NOT_IN_SCHEMA = Value
    }

    val NO_DISCRIMINANT: Short = -1

    object Slot extends org.capnproto.Struct {
      type Builder = BuilderImpl
      type Reader = ReaderImpl

      override def Builder: (SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)

      override def Reader: (SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def structSize: StructSize = {
        Field.Slot.STRUCT_SIZE
      }

      val STRUCT_SIZE: StructSize = new StructSize(3.toShort, 4.toShort)

      final class BuilderImpl private[compiler](segment: SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends super.BuilderBase(segment, dataOffset, pointers, dataSize, pointerCount) {

        def offset: Int = {
          _getIntField(1)
        }

        def offset_=(value: Int) {
          _setIntField(1, value)
        }

        def capnpType: CapnpSchema.Type.Builder = {
          _getPointerField(CapnpSchema.Type, 2, null, 0)
        }

        def capnpType_=(value: CapnpSchema.Type.Reader) {
          _setPointerField(CapnpSchema.Type)(2, value)
        }

        def initType: CapnpSchema.Type.Builder = {
          _initPointerField(CapnpSchema.Type, 2, 0)
        }

        def defaultvalue: CapnpSchema.Value.Builder = {
          _getPointerField(CapnpSchema.Value, 3, null, 0)
        }

        def defaultvalue_=(value: CapnpSchema.Value.Reader) {
          _setPointerField(CapnpSchema.Value)(3, value)
        }

        def initDefaultValue: CapnpSchema.Value.Builder = {
          _initPointerField(CapnpSchema.Value, 3, 0)
        }

        def hadexplicitdefault: Boolean = {
          _getBooleanField(128)
        }

        def hadexplicitdefault_=(value: Boolean) {
          _setBooleanField(128, value)
        }
      }

      final class ReaderImpl private[compiler](segment: SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends super.ReaderBase(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit) {
        def offset: Int = {
          _getIntField(1)
        }

        def hasType: Boolean = {
          !_pointerFieldIsNull(2)
        }

        def capnpType: CapnpSchema.Type.Reader = {
          _getPointerField(CapnpSchema.Type, 2, null, 0)
        }

        def hasDefaultValue: Boolean = {
          !_pointerFieldIsNull(3)
        }

        def defaultvalue: CapnpSchema.Value.Reader = {
          _getPointerField(CapnpSchema.Value, 3, null, 0)
        }

        def hadexplicitdefault: Boolean = {
          _getBooleanField(128)
        }
      }

    }

    object Group extends org.capnproto.Struct {
      type Builder = BuilderImpl
      type Reader = ReaderImpl

      override val Builder: (SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def structSize: StructSize = {
        Field.Group.STRUCT_SIZE
      }

      val STRUCT_SIZE: StructSize = new StructSize(3.toShort, 4.toShort)

      final class BuilderImpl private[compiler](segment: SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends super.BuilderBase(segment, dataOffset, pointers, dataSize, pointerCount) {

        def capnpTypeid: Long = {
          _getLongField(2)
        }

        def capnpTypeid_=(value: Long) {
          _setLongField(2, value)
        }
      }

      final class ReaderImpl private[compiler](segment: SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends super.ReaderBase(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit) {
        def capnpTypeid: Long = {
          _getLongField(2)
        }
      }

    }

    object Ordinal extends org.capnproto.Struct {
      type Builder = BuilderImpl
      type Reader = ReaderImpl

      override val Builder: (SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def structSize: StructSize = {
        Field.Ordinal.STRUCT_SIZE
      }

      val STRUCT_SIZE: StructSize = new StructSize(3.toShort, 4.toShort)

      final class BuilderImpl private[compiler](segment: SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends super.BuilderBase(segment, dataOffset, pointers, dataSize, pointerCount) {
        def which: CapnpSchema.Field.Ordinal.Which.Which = {
          _getShortField(5) match {
            case 0 =>
              Which.IMPLICIT
            case 1 =>
              Which.EXPLICIT
            case _ =>
              Which._NOT_IN_SCHEMA
          }
        }

        def isImplicitOrdinal: Boolean = {
          which == Field.Ordinal.Which.IMPLICIT
        }

        def implicitOrdinal: Void = {
          assert(which == Field.Ordinal.Which.IMPLICIT, "Must check which() before get()ing a union member.")
          org.capnproto.Void.VOID
        }

        def implicitOrdinal_=(value: Void) {
          _setShortField(5, Field.Ordinal.Which.IMPLICIT.id.toShort)
        }

        def isExplicitOrdinal: Boolean = {
          which == Field.Ordinal.Which.EXPLICIT
        }

        def explicitOrdinal: Short = {
          assert(which == Field.Ordinal.Which.EXPLICIT, "Must check which() before get()ing a union member.")
          _getShortField(6)
        }

        def explicit_=(value: Short) {
          _setShortField(5, Field.Ordinal.Which.EXPLICIT.id.toShort)
          _setShortField(6, value)
        }
      }

      final class ReaderImpl private[compiler](segment: SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends super.ReaderBase(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit) {
        def which: CapnpSchema.Field.Ordinal.Which.Which = {
          _getShortField(5) match {
            case 0 =>
              Which.IMPLICIT
            case 1 =>
              Which.EXPLICIT
            case _ =>
              Which._NOT_IN_SCHEMA
          }
        }

        def isImplicitOrdinal: Boolean = {
          which == Field.Ordinal.Which.IMPLICIT
        }

        def implicitOrdinal: Void = {
          assert(which == Field.Ordinal.Which.IMPLICIT, "Must check which() before get()ing a union member.")
          org.capnproto.Void.VOID
        }

        def isExplicitOrdinal: Boolean = {
          which == Field.Ordinal.Which.EXPLICIT
        }

        def explicitOrdinal: Short = {
          assert(which == Field.Ordinal.Which.EXPLICIT, "Must check which() before get()ing a union member.")
          _getShortField(6)
        }
      }

      object Which extends Enumeration {
        type Which = Value
        val IMPLICIT, EXPLICIT, _NOT_IN_SCHEMA = Value
      }

    }

  }

  object Enumerant extends org.capnproto.Struct {
    type Builder = BuilderImpl
    type Reader = ReaderImpl

    override val Builder: (SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    def structSize: StructSize = {
      Enumerant.STRUCT_SIZE
    }

    val STRUCT_SIZE: StructSize = new StructSize(1.toShort, 2.toShort)

    final class BuilderImpl private[compiler](segment: SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends super.BuilderBase(segment, dataOffset, pointers, dataSize, pointerCount) {

      def hasName: Boolean = {
        !_pointerFieldIsNull(0)
      }

      def name: Text.Builder = {
        _getPointerField(org.capnproto.Text, 0, null, 0, 0)
      }

      def name_=(value: Text.Reader) {
        _setPointerField(org.capnproto.Text)(0, value)
      }

      def name_=(value: String) {
        _setPointerField(org.capnproto.Text)(0, new Text.Reader(value))
      }

      def initName(size: Int): Text.Builder = {
        _initPointerField(org.capnproto.Text, 0, size)
      }

      def codeorder: Short = {
        _getShortField(0)
      }

      def codeorder_=(value: Short) {
        _setShortField(0, value)
      }

      def hasAnnotations: Boolean = {
        !_pointerFieldIsNull(1)
      }

      def annotations: CapnpSchema.Annotation.List.Builder = {
        _getPointerField(CapnpSchema.Annotation.List, 1, null, 0)
      }

      def annotations_=(value: CapnpSchema.Annotation.List.Reader) {
        _setPointerField(CapnpSchema.Annotation.List)(1, value)
      }

      def initAnnotations(size: Int): CapnpSchema.Annotation.List.Builder = {
        _initPointerField(CapnpSchema.Annotation.List, 1, size)
      }
    }

    final class ReaderImpl private[compiler](segment: SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends super.ReaderBase(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit) {
      def hasName: Boolean = {
        !_pointerFieldIsNull(0)
      }

      def name: Text.Reader = {
        _getPointerField(org.capnproto.Text, 0, null, 0, 0)
      }

      def codeorder: Short = {
        _getShortField(0)
      }

      def hasAnnotations: Boolean = {
        !_pointerFieldIsNull(1)
      }

      def annotations: CapnpSchema.Annotation.List.Reader = {
        _getPointerField(CapnpSchema.Annotation.List, 1, null, 0)
      }
    }

  }

  object Superclass extends org.capnproto.Struct {
    type Builder = BuilderImpl
    type Reader = ReaderImpl

    override val Builder: (SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    def structSize: StructSize = {
      Superclass.STRUCT_SIZE
    }

    val STRUCT_SIZE: StructSize = new StructSize(1.toShort, 1.toShort)

    final class BuilderImpl private[compiler](segment: SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends super.BuilderBase(segment, dataOffset, pointers, dataSize, pointerCount) {

      def id: Long = {
        _getLongField(0)
      }

      def id_=(value: Long) {
        _setLongField(0, value)
      }

      def brand: CapnpSchema.Brand.Builder = {
        _getPointerField(CapnpSchema.Brand, 0, null, 0)
      }

      def brand_=(value: CapnpSchema.Brand.Reader) {
        _setPointerField(CapnpSchema.Brand)(0, value)
      }

      def initBrand: CapnpSchema.Brand.Builder = {
        _initPointerField(CapnpSchema.Brand, 0, 0)
      }
    }

    final class ReaderImpl private[compiler](segment: SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends super.ReaderBase(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit) {
      def id: Long = {
        _getLongField(0)
      }

      def hasBrand: Boolean = {
        !_pointerFieldIsNull(0)
      }

      def brand: CapnpSchema.Brand.Reader = {
        _getPointerField(CapnpSchema.Brand, 0, null, 0)
      }
    }

  }

  object Method extends org.capnproto.Struct {
    type Builder = BuilderImpl
    type Reader = ReaderImpl

    override val Builder: (SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    def structSize: StructSize = {
      Method.STRUCT_SIZE
    }

    val STRUCT_SIZE: StructSize = new StructSize(3.toShort, 5.toShort)

    final class BuilderImpl private[compiler](segment: SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends super.BuilderBase(segment, dataOffset, pointers, dataSize, pointerCount) {

      def hasName: Boolean = {
        !_pointerFieldIsNull(0)
      }

      def name: Text.Builder = {
        _getPointerField(org.capnproto.Text, 0, null, 0, 0)
      }

      def name_=(value: Text.Reader) {
        _setPointerField(org.capnproto.Text)(0, value)
      }

      def name_=(value: String) {
        _setPointerField(org.capnproto.Text)(0, new Text.Reader(value))
      }

      def initName(size: Int): Text.Builder = {
        _initPointerField(org.capnproto.Text, 0, size)
      }

      def codeorder: Short = {
        _getShortField(0)
      }

      def codeorder_=(value: Short) {
        _setShortField(0, value)
      }

      def paramstructtype: Long = {
        _getLongField(1)
      }

      def paramstructtype_=(value: Long) {
        _setLongField(1, value)
      }

      def resultstructtype: Long = {
        _getLongField(2)
      }

      def resultstructtype_=(value: Long) {
        _setLongField(2, value)
      }

      def hasAnnotations: Boolean = {
        !_pointerFieldIsNull(1)
      }

      def annotations: CapnpSchema.Annotation.List.Builder = {
        _getPointerField(CapnpSchema.Annotation.List, 1, null, 0)
      }

      def annotations_=(value: CapnpSchema.Annotation.List.Reader) {
        _setPointerField(CapnpSchema.Annotation.List)(1, value)
      }

      def initAnnotations(size: Int): CapnpSchema.Annotation.List.Builder = {
        _initPointerField(CapnpSchema.Annotation.List, 1, size)
      }

      def parambrand: CapnpSchema.Brand.Builder = {
        _getPointerField(CapnpSchema.Brand, 2, null, 0)
      }

      def parambrand_=(value: CapnpSchema.Brand.Reader) {
        _setPointerField(CapnpSchema.Brand)(2, value)
      }

      def initParamBrand: CapnpSchema.Brand.Builder = {
        _initPointerField(CapnpSchema.Brand, 2, 0)
      }

      def resultbrand: CapnpSchema.Brand.Builder = {
        _getPointerField(CapnpSchema.Brand, 3, null, 0)
      }

      def resultbrand_=(value: CapnpSchema.Brand.Reader) {
        _setPointerField(CapnpSchema.Brand)(3, value)
      }

      def initResultBrand: CapnpSchema.Brand.Builder = {
        _initPointerField(CapnpSchema.Brand, 3, 0)
      }

      def hasImplicitParameters: Boolean = {
        !_pointerFieldIsNull(4)
      }

      def implicitparameters: CapnpSchema.Node.Parameter.List.Builder = {
        _getPointerField(CapnpSchema.Node.Parameter.List, 4, null, 0)
      }

      def implicitparameters_=(value: CapnpSchema.Node.Parameter.List.Reader) {
        _setPointerField(CapnpSchema.Node.Parameter.List)(4, value)
      }

      def initImplicitParameters(size: Int): CapnpSchema.Node.Parameter.List.Builder = {
        _initPointerField(CapnpSchema.Node.Parameter.List, 4, size)
      }
    }

    final class ReaderImpl private[compiler](segment: SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends super.ReaderBase(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit) {
      def hasName: Boolean = {
        !_pointerFieldIsNull(0)
      }

      def name: Text.Reader = {
        _getPointerField(org.capnproto.Text, 0, null, 0, 0)
      }

      def codeorder: Short = {
        _getShortField(0)
      }

      def paramstructtype: Long = {
        _getLongField(1)
      }

      def resultstructtype: Long = {
        _getLongField(2)
      }

      def hasAnnotations: Boolean = {
        !_pointerFieldIsNull(1)
      }

      def annotations: CapnpSchema.Annotation.List.Reader = {
        _getPointerField(CapnpSchema.Annotation.List, 1, null, 0)
      }

      def hasParamBrand: Boolean = {
        !_pointerFieldIsNull(2)
      }

      def parambrand: CapnpSchema.Brand.Reader = {
        _getPointerField(CapnpSchema.Brand, 2, null, 0)
      }

      def hasResultBrand: Boolean = {
        !_pointerFieldIsNull(3)
      }

      def resultbrand: CapnpSchema.Brand.Reader = {
        _getPointerField(CapnpSchema.Brand, 3, null, 0)
      }

      def hasImplicitParameters: Boolean = {
        !_pointerFieldIsNull(4)
      }

      def implicitparameters: CapnpSchema.Node.Parameter.List.Reader = {
        _getPointerField(CapnpSchema.Node.Parameter.List, 4, null, 0)
      }
    }

  }

  object Type extends org.capnproto.Struct {
    type Builder = BuilderImpl
    type Reader = ReaderImpl

    override val Builder: (SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    def structSize: StructSize = {
      Type.STRUCT_SIZE
    }

    val STRUCT_SIZE: StructSize = new StructSize(2.toShort, 1.toShort)

    final class BuilderImpl private[compiler](segment: SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends super.BuilderBase(segment, dataOffset, pointers, dataSize, pointerCount) {
      def which: CapnpSchema.Type.Which.Which = {
        _getShortField(0) match {
          case 0 =>
            Which.VOID
          case 1 =>
            Which.BOOL
          case 2 =>
            Which.INT8
          case 3 =>
            Which.INT16
          case 4 =>
            Which.INT32
          case 5 =>
            Which.INT64
          case 6 =>
            Which.UINT8
          case 7 =>
            Which.UINT16
          case 8 =>
            Which.UINT32
          case 9 =>
            Which.UINT64
          case 10 =>
            Which.FLOAT32
          case 11 =>
            Which.FLOAT64
          case 12 =>
            Which.TEXT
          case 13 =>
            Which.DATA
          case 14 =>
            Which.LIST
          case 15 =>
            Which.ENUM
          case 16 =>
            Which.STRUCT
          case 17 =>
            Which.INTERFACE
          case 18 =>
            Which.ANY_POINTER
          case _ =>
            Which._NOT_IN_SCHEMA
        }
      }

      def isVoid: Boolean = {
        which == Type.Which.VOID
      }

      def void: Void = {
        assert(which == Type.Which.VOID, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def void_=(value: Void) {
        _setShortField(0, Type.Which.VOID.id.toShort)
      }

      def isBool: Boolean = {
        which == Type.Which.BOOL
      }

      def bool: Void = {
        assert(which == Type.Which.BOOL, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def bool_=(value: Void) {
        _setShortField(0, Type.Which.BOOL.id.toShort)
      }

      def isInt8: Boolean = {
        which == Type.Which.INT8
      }

      def int8: Void = {
        assert(which == Type.Which.INT8, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def int8_=(value: Void) {
        _setShortField(0, Type.Which.INT8.id.toShort)
      }

      def isInt16: Boolean = {
        which == Type.Which.INT16
      }

      def int16: Void = {
        assert(which == Type.Which.INT16, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def int16_=(value: Void) {
        _setShortField(0, Type.Which.INT16.id.toShort)
      }

      def isInt32: Boolean = {
        which == Type.Which.INT32
      }

      def int32: Void = {
        assert(which == Type.Which.INT32, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def int32_=(value: Void) {
        _setShortField(0, Type.Which.INT32.id.toShort)
      }

      def isInt64: Boolean = {
        which == Type.Which.INT64
      }

      def int64: Void = {
        assert(which == Type.Which.INT64, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def int64_=(value: Void) {
        _setShortField(0, Type.Which.INT64.id.toShort)
      }

      def isUint8: Boolean = {
        which == Type.Which.UINT8
      }

      def uint8: Void = {
        assert(which == Type.Which.UINT8, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def uint8_=(value: Void) {
        _setShortField(0, Type.Which.UINT8.id.toShort)
      }

      def isUint16: Boolean = {
        which == Type.Which.UINT16
      }

      def uint16: Void = {
        assert(which == Type.Which.UINT16, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def uint16_=(value: Void) {
        _setShortField(0, Type.Which.UINT16.id.toShort)
      }

      def isUint32: Boolean = {
        which == Type.Which.UINT32
      }

      def uint32: Void = {
        assert(which == Type.Which.UINT32, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def uint32_=(value: Void) {
        _setShortField(0, Type.Which.UINT32.id.toShort)
      }

      def isUint64: Boolean = {
        which == Type.Which.UINT64
      }

      def uint64: Void = {
        assert(which == Type.Which.UINT64, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def uint64_=(value: Void) {
        _setShortField(0, Type.Which.UINT64.id.toShort)
      }

      def isFloat32: Boolean = {
        which == Type.Which.FLOAT32
      }

      def float32: Void = {
        assert(which == Type.Which.FLOAT32, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def float32_=(value: Void) {
        _setShortField(0, Type.Which.FLOAT32.id.toShort)
      }

      def isFloat64: Boolean = {
        which == Type.Which.FLOAT64
      }

      def float64: Void = {
        assert(which == Type.Which.FLOAT64, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def float64_=(value: Void) {
        _setShortField(0, Type.Which.FLOAT64.id.toShort)
      }

      def isText: Boolean = {
        which == Type.Which.TEXT
      }

      def text: Void = {
        assert(which == Type.Which.TEXT, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def text_=(value: Void) {
        _setShortField(0, Type.Which.TEXT.id.toShort)
      }

      def isData: Boolean = {
        which == Type.Which.DATA
      }

      def data: Void = {
        assert(which == Type.Which.DATA, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def data_=(value: Void) {
        _setShortField(0, Type.Which.DATA.id.toShort)
      }

      def isList: Boolean = {
        which == Type.Which.LIST
      }

      def list: CapnpSchema.Type.CList.Builder = {
        CapnpSchema.Type.CList.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
      }

      def initList: CapnpSchema.Type.CList.Builder = {
        _setShortField(0, Type.Which.LIST.id.toShort)
        _clearPointerField(0)
        CapnpSchema.Type.CList.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
      }

      def isEnum: Boolean = {
        which == Type.Which.ENUM
      }

      def enum: CapnpSchema.Type.Enum.Builder = {
        CapnpSchema.Type.Enum.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
      }

      def initEnum: CapnpSchema.Type.Enum.Builder = {
        _setShortField(0, Type.Which.ENUM.id.toShort)
        _setLongField(1, 0L)
        _clearPointerField(0)
        CapnpSchema.Type.Enum.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
      }

      def isStruct: Boolean = {
        which == Type.Which.STRUCT
      }

      def struct: CapnpSchema.Type.Struct.Builder = {
        CapnpSchema.Type.Struct.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
      }

      def initStruct: CapnpSchema.Type.Struct.Builder = {
        _setShortField(0, Type.Which.STRUCT.id.toShort)
        _setLongField(1, 0L)
        _clearPointerField(0)
        CapnpSchema.Type.Struct.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
      }

      def isInterface: Boolean = {
        which == Type.Which.INTERFACE
      }

      def interface: CapnpSchema.Type.Interface.Builder = {
        CapnpSchema.Type.Interface.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
      }

      def initInterface: CapnpSchema.Type.Interface.Builder = {
        _setShortField(0, Type.Which.INTERFACE.id.toShort)
        _setLongField(1, 0L)
        _clearPointerField(0)
        CapnpSchema.Type.Interface.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
      }

      def isAnyPointer: Boolean = {
        which == Type.Which.ANY_POINTER
      }

      def anypointer: CapnpSchema.Type.AnyPointer.Builder = {
        CapnpSchema.Type.AnyPointer.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
      }

      def initAnyPointer: CapnpSchema.Type.AnyPointer.Builder = {
        _setShortField(0, Type.Which.ANY_POINTER.id.toShort)
        _setShortField(1, 0.toShort)
        _setShortField(2, 0.toShort)
        _setLongField(1, 0L)
        CapnpSchema.Type.AnyPointer.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
      }
    }

    final class ReaderImpl private[compiler](segment: SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends super.ReaderBase(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit) {
      def which: CapnpSchema.Type.Which.Which = {
        _getShortField(0) match {
          case 0 =>
            Which.VOID
          case 1 =>
            Which.BOOL
          case 2 =>
            Which.INT8
          case 3 =>
            Which.INT16
          case 4 =>
            Which.INT32
          case 5 =>
            Which.INT64
          case 6 =>
            Which.UINT8
          case 7 =>
            Which.UINT16
          case 8 =>
            Which.UINT32
          case 9 =>
            Which.UINT64
          case 10 =>
            Which.FLOAT32
          case 11 =>
            Which.FLOAT64
          case 12 =>
            Which.TEXT
          case 13 =>
            Which.DATA
          case 14 =>
            Which.LIST
          case 15 =>
            Which.ENUM
          case 16 =>
            Which.STRUCT
          case 17 =>
            Which.INTERFACE
          case 18 =>
            Which.ANY_POINTER
          case _ =>
            Which._NOT_IN_SCHEMA
        }
      }

      def isVoid: Boolean = {
        which == Type.Which.VOID
      }

      def void: Void = {
        assert(which == Type.Which.VOID, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def isBool: Boolean = {
        which == Type.Which.BOOL
      }

      def bool: Void = {
        assert(which == Type.Which.BOOL, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def isInt8: Boolean = {
        which == Type.Which.INT8
      }

      def int8: Void = {
        assert(which == Type.Which.INT8, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def isInt16: Boolean = {
        which == Type.Which.INT16
      }

      def int16: Void = {
        assert(which == Type.Which.INT16, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def isInt32: Boolean = {
        which == Type.Which.INT32
      }

      def int32: Void = {
        assert(which == Type.Which.INT32, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def isInt64: Boolean = {
        which == Type.Which.INT64
      }

      def int64: Void = {
        assert(which == Type.Which.INT64, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def isUint8: Boolean = {
        which == Type.Which.UINT8
      }

      def uint8: Void = {
        assert(which == Type.Which.UINT8, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def isUint16: Boolean = {
        which == Type.Which.UINT16
      }

      def uint16: Void = {
        assert(which == Type.Which.UINT16, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def isUint32: Boolean = {
        which == Type.Which.UINT32
      }

      def uint32: Void = {
        assert(which == Type.Which.UINT32, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def isUint64: Boolean = {
        which == Type.Which.UINT64
      }

      def uint64: Void = {
        assert(which == Type.Which.UINT64, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def isFloat32: Boolean = {
        which == Type.Which.FLOAT32
      }

      def float32: Void = {
        assert(which == Type.Which.FLOAT32, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def isFloat64: Boolean = {
        which == Type.Which.FLOAT64
      }

      def float64: Void = {
        assert(which == Type.Which.FLOAT64, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def isText: Boolean = {
        which == Type.Which.TEXT
      }

      def text: Void = {
        assert(which == Type.Which.TEXT, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def isData: Boolean = {
        which == Type.Which.DATA
      }

      def data: Void = {
        assert(which == Type.Which.DATA, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def isList: Boolean = {
        which == Type.Which.LIST
      }

      def list: CapnpSchema.Type.CList.Reader = {
        CapnpSchema.Type.CList.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
      }

      def isEnum: Boolean = {
        which == Type.Which.ENUM
      }

      def enum: CapnpSchema.Type.Enum.Reader = {
        CapnpSchema.Type.Enum.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
      }

      def isStruct: Boolean = {
        which == Type.Which.STRUCT
      }

      def struct: CapnpSchema.Type.Struct.Reader = {
        CapnpSchema.Type.Struct.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
      }

      def isInterface: Boolean = {
        which == Type.Which.INTERFACE
      }

      def interface: CapnpSchema.Type.Interface.Reader = {
        CapnpSchema.Type.Interface.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
      }

      def isAnyPointer: Boolean = {
        which == Type.Which.ANY_POINTER
      }

      def anypointer: CapnpSchema.Type.AnyPointer.Reader = {
        CapnpSchema.Type.AnyPointer.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
      }
    }

    object Which extends Enumeration {
      type Which = Value
      val VOID, BOOL, INT8, INT16, INT32, INT64, UINT8, UINT16, UINT32, UINT64, FLOAT32, FLOAT64, TEXT, DATA, LIST, ENUM, STRUCT, INTERFACE, ANY_POINTER, _NOT_IN_SCHEMA = Value
    }

    object CList extends org.capnproto.Struct {
      type Builder = BuilderImpl
      type Reader = ReaderImpl

      override val Builder: (SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def structSize: StructSize = {
        Type.CList.STRUCT_SIZE
      }

      val STRUCT_SIZE: StructSize = new StructSize(2.toShort, 1.toShort)

      final class BuilderImpl private[compiler](segment: SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends super.BuilderBase(segment, dataOffset, pointers, dataSize, pointerCount) {

        def elementtype: CapnpSchema.Type.Builder = {
          _getPointerField(CapnpSchema.Type, 0, null, 0)
        }

        def elementtype_=(value: CapnpSchema.Type.Reader) {
          _setPointerField(CapnpSchema.Type)(0, value)
        }

        def initElementType: CapnpSchema.Type.Builder = {
          _initPointerField(CapnpSchema.Type, 0, 0)
        }
      }

      final class ReaderImpl private[compiler](segment: SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends super.ReaderBase(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit) {
        def hasElementType: Boolean = {
          !_pointerFieldIsNull(0)
        }

        def elementtype: CapnpSchema.Type.Reader = {
          _getPointerField(CapnpSchema.Type, 0, null, 0)
        }
      }

    }

    object Enum extends org.capnproto.Struct {
      type Builder = BuilderImpl
      type Reader = ReaderImpl

      override val Builder: (SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def structSize: StructSize = {
        Type.Enum.STRUCT_SIZE
      }

      val STRUCT_SIZE: StructSize = new StructSize(2.toShort, 1.toShort)

      final class BuilderImpl private[compiler](segment: SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends super.BuilderBase(segment, dataOffset, pointers, dataSize, pointerCount) {

        def capnpTypeid: Long = {
          _getLongField(1)
        }

        def capnpTypeid_=(value: Long) {
          _setLongField(1, value)
        }

        def brand: CapnpSchema.Brand.Builder = {
          _getPointerField(CapnpSchema.Brand, 0, null, 0)
        }

        def brand_=(value: CapnpSchema.Brand.Reader) {
          _setPointerField(CapnpSchema.Brand)(0, value)
        }

        def initBrand: CapnpSchema.Brand.Builder = {
          _initPointerField(CapnpSchema.Brand, 0, 0)
        }
      }

      final class ReaderImpl private[compiler](segment: SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends super.ReaderBase(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit) {
        def capnpTypeid: Long = {
          _getLongField(1)
        }

        def hasBrand: Boolean = {
          !_pointerFieldIsNull(0)
        }

        def brand: CapnpSchema.Brand.Reader = {
          _getPointerField(CapnpSchema.Brand, 0, null, 0)
        }
      }

    }

    object Struct extends org.capnproto.Struct {
      type Builder = BuilderImpl
      type Reader = ReaderImpl

      override val Builder: (SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def structSize: StructSize = {
        Type.Struct.STRUCT_SIZE
      }

      val STRUCT_SIZE: StructSize = new StructSize(2.toShort, 1.toShort)

      final class BuilderImpl private[compiler](segment: SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends super.BuilderBase(segment, dataOffset, pointers, dataSize, pointerCount) {

        def capnpTypeid: Long = {
          _getLongField(1)
        }

        def capnpTypeid_=(value: Long) {
          _setLongField(1, value)
        }

        def brand: CapnpSchema.Brand.Builder = {
          _getPointerField(CapnpSchema.Brand, 0, null, 0)
        }

        def brand_=(value: CapnpSchema.Brand.Reader) {
          _setPointerField(CapnpSchema.Brand)(0, value)
        }

        def initBrand: CapnpSchema.Brand.Builder = {
          _initPointerField(CapnpSchema.Brand, 0, 0)
        }
      }

      final class ReaderImpl private[compiler](segment: SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends super.ReaderBase(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit) {
        def capnpTypeid: Long = {
          _getLongField(1)
        }

        def hasBrand: Boolean = {
          !_pointerFieldIsNull(0)
        }

        def brand: CapnpSchema.Brand.Reader = {
          _getPointerField(CapnpSchema.Brand, 0, null, 0)
        }
      }

    }

    object Interface extends org.capnproto.Struct {
      type Builder = BuilderImpl
      type Reader = ReaderImpl

      override val Builder: (SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def structSize: StructSize = {
        Type.Interface.STRUCT_SIZE
      }

      val STRUCT_SIZE: StructSize = new StructSize(2.toShort, 1.toShort)

      final class BuilderImpl private[compiler](segment: SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends super.BuilderBase(segment, dataOffset, pointers, dataSize, pointerCount) {

        def capnpTypeid: Long = {
          _getLongField(1)
        }

        def capnpTypeid_=(value: Long) {
          _setLongField(1, value)
        }

        def brand: CapnpSchema.Brand.Builder = {
          _getPointerField(CapnpSchema.Brand, 0, null, 0)
        }

        def brand_=(value: CapnpSchema.Brand.Reader) {
          _setPointerField(CapnpSchema.Brand)(0, value)
        }

        def initBrand: CapnpSchema.Brand.Builder = {
          _initPointerField(CapnpSchema.Brand, 0, 0)
        }
      }

      final class ReaderImpl private[compiler](segment: SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends super.ReaderBase(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit) {
        def capnpTypeid: Long = {
          _getLongField(1)
        }

        def hasBrand: Boolean = {
          !_pointerFieldIsNull(0)
        }

        def brand: CapnpSchema.Brand.Reader = {
          _getPointerField(CapnpSchema.Brand, 0, null, 0)
        }
      }

    }

    object AnyPointer extends org.capnproto.Struct {
      type Builder = BuilderImpl
      type Reader = ReaderImpl

      override val Builder: (SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def structSize: StructSize = {
        Type.AnyPointer.STRUCT_SIZE
      }

      val STRUCT_SIZE: StructSize = new StructSize(2.toShort, 1.toShort)

      final class BuilderImpl private[compiler](segment: SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends super.BuilderBase(segment, dataOffset, pointers, dataSize, pointerCount) {
        def which: CapnpSchema.Type.AnyPointer.Which.Which = {
          _getShortField(2) match {
            case 0 =>
              Which.UNCONSTRAINED
            case 1 =>
              Which.PARAMETER
            case 2 =>
              Which.IMPLICIT_METHOD_PARAMETER
            case _ =>
              Which._NOT_IN_SCHEMA
          }
        }

        def isUnconstrained: Boolean = {
          which == Type.AnyPointer.Which.UNCONSTRAINED
        }

        def unconstrained: CapnpSchema.Type.AnyPointer.Unconstrained.Builder = {
          CapnpSchema.Type.AnyPointer.Unconstrained.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
        }

        def initUnconstrained: CapnpSchema.Type.AnyPointer.Unconstrained.Builder = {
          _setShortField(2, Type.AnyPointer.Which.UNCONSTRAINED.id.toShort)
          _setShortField(1, 0.toShort)
          CapnpSchema.Type.AnyPointer.Unconstrained.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
        }

        def isParameter: Boolean = {
          which == Type.AnyPointer.Which.PARAMETER
        }

        def parameter: CapnpSchema.Type.AnyPointer.Parameter.Builder = {
          CapnpSchema.Type.AnyPointer.Parameter.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
        }

        def initParameter: CapnpSchema.Type.AnyPointer.Parameter.Builder = {
          _setShortField(2, Type.AnyPointer.Which.PARAMETER.id.toShort)
          _setShortField(1, 0.toShort)
          _setLongField(1, 0L)
          CapnpSchema.Type.AnyPointer.Parameter.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
        }

        def isImplicitMethodParameter: Boolean = {
          which == Type.AnyPointer.Which.IMPLICIT_METHOD_PARAMETER
        }

        def implicitmethodparameter: CapnpSchema.Type.AnyPointer.ImplicitMethodParameter.Builder = {
          CapnpSchema.Type.AnyPointer.ImplicitMethodParameter.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
        }

        def initImplicitMethodParameter: CapnpSchema.Type.AnyPointer.ImplicitMethodParameter.Builder = {
          _setShortField(2, Type.AnyPointer.Which.IMPLICIT_METHOD_PARAMETER.id.toShort)
          _setShortField(1, 0.toShort)
          CapnpSchema.Type.AnyPointer.ImplicitMethodParameter.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
        }
      }

      final class ReaderImpl private[compiler](segment: SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends super.ReaderBase(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit) {
        def which: CapnpSchema.Type.AnyPointer.Which.Which = {
          _getShortField(2) match {
            case 0 =>
              Which.UNCONSTRAINED
            case 1 =>
              Which.PARAMETER
            case 2 =>
              Which.IMPLICIT_METHOD_PARAMETER
            case _ =>
              Which._NOT_IN_SCHEMA
          }
        }

        def isUnconstrained: Boolean = {
          which == Type.AnyPointer.Which.UNCONSTRAINED
        }

        def unconstrained: CapnpSchema.Type.AnyPointer.Unconstrained.Reader = {
          CapnpSchema.Type.AnyPointer.Unconstrained.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
        }

        def isParameter: Boolean = {
          which == Type.AnyPointer.Which.PARAMETER
        }

        def parameter: CapnpSchema.Type.AnyPointer.Parameter.Reader = {
          CapnpSchema.Type.AnyPointer.Parameter.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
        }

        def isImplicitMethodParameter: Boolean = {
          which == Type.AnyPointer.Which.IMPLICIT_METHOD_PARAMETER
        }

        def implicitmethodparameter: CapnpSchema.Type.AnyPointer.ImplicitMethodParameter.Reader = {
          CapnpSchema.Type.AnyPointer.ImplicitMethodParameter.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
        }
      }

      object Which extends Enumeration {
        type Which = Value
        val UNCONSTRAINED, PARAMETER, IMPLICIT_METHOD_PARAMETER, _NOT_IN_SCHEMA = Value
      }

      object Unconstrained extends org.capnproto.Struct {
        type Builder = BuilderImpl
        type Reader = ReaderImpl

        override val Builder: (SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
        override val Reader: (SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

        def structSize: StructSize = {
          Type.AnyPointer.Unconstrained.STRUCT_SIZE
        }

        val STRUCT_SIZE: StructSize = new StructSize(2.toShort, 1.toShort)

        final class BuilderImpl private[compiler](segment: SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends super.BuilderBase(segment, dataOffset, pointers, dataSize, pointerCount) {
          def which: CapnpSchema.Type.AnyPointer.Unconstrained.Which.Which = {
            _getShortField(1) match {
              case 0 =>
                Which.ANY_KIND
              case 1 =>
                Which.STRUCT
              case 2 =>
                Which.LIST
              case 3 =>
                Which.CAPABILITY
              case _ =>
                Which._NOT_IN_SCHEMA
            }
          }

          def isAnyKind: Boolean = {
            which == Type.AnyPointer.Unconstrained.Which.ANY_KIND
          }

          def anykind: Void = {
            assert(which == Type.AnyPointer.Unconstrained.Which.ANY_KIND, "Must check which() before get()ing a union member.")
            org.capnproto.Void.VOID
          }

          def anykind_=(value: Void) {
            _setShortField(1, Type.AnyPointer.Unconstrained.Which.ANY_KIND.id.toShort)
          }

          def isStruct: Boolean = {
            which == Type.AnyPointer.Unconstrained.Which.STRUCT
          }

          def struct: Void = {
            assert(which == Type.AnyPointer.Unconstrained.Which.STRUCT, "Must check which() before get()ing a union member.")
            org.capnproto.Void.VOID
          }

          def struct_=(value: Void) {
            _setShortField(1, Type.AnyPointer.Unconstrained.Which.STRUCT.id.toShort)
          }

          def isList: Boolean = {
            which == Type.AnyPointer.Unconstrained.Which.LIST
          }

          def list: Void = {
            assert(which == Type.AnyPointer.Unconstrained.Which.LIST, "Must check which() before get()ing a union member.")
            org.capnproto.Void.VOID
          }

          def list_=(value: Void) {
            _setShortField(1, Type.AnyPointer.Unconstrained.Which.LIST.id.toShort)
          }

          def isCapability: Boolean = {
            which == Type.AnyPointer.Unconstrained.Which.CAPABILITY
          }

          def capability: Void = {
            assert(which == Type.AnyPointer.Unconstrained.Which.CAPABILITY, "Must check which() before get()ing a union member.")
            org.capnproto.Void.VOID
          }

          def capability_=(value: Void) {
            _setShortField(1, Type.AnyPointer.Unconstrained.Which.CAPABILITY.id.toShort)
          }
        }

        final class ReaderImpl private[compiler](segment: SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends super.ReaderBase(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit) {
          def which: CapnpSchema.Type.AnyPointer.Unconstrained.Which.Which = {
            _getShortField(1) match {
              case 0 =>
                Which.ANY_KIND
              case 1 =>
                Which.STRUCT
              case 2 =>
                Which.LIST
              case 3 =>
                Which.CAPABILITY
              case _ =>
                Which._NOT_IN_SCHEMA
            }
          }

          def isAnyKind: Boolean = {
            which == Type.AnyPointer.Unconstrained.Which.ANY_KIND
          }

          def anykind: Void = {
            assert(which == Type.AnyPointer.Unconstrained.Which.ANY_KIND, "Must check which() before get()ing a union member.")
            org.capnproto.Void.VOID
          }

          def isStruct: Boolean = {
            which == Type.AnyPointer.Unconstrained.Which.STRUCT
          }

          def struct: Void = {
            assert(which == Type.AnyPointer.Unconstrained.Which.STRUCT, "Must check which() before get()ing a union member.")
            org.capnproto.Void.VOID
          }

          def isList: Boolean = {
            which == Type.AnyPointer.Unconstrained.Which.LIST
          }

          def list: Void = {
            assert(which == Type.AnyPointer.Unconstrained.Which.LIST, "Must check which() before get()ing a union member.")
            org.capnproto.Void.VOID
          }

          def isCapability: Boolean = {
            which == Type.AnyPointer.Unconstrained.Which.CAPABILITY
          }

          def capability: Void = {
            assert(which == Type.AnyPointer.Unconstrained.Which.CAPABILITY, "Must check which() before get()ing a union member.")
            org.capnproto.Void.VOID
          }
        }

        object Which extends Enumeration {
          type Which = Value
          val ANY_KIND, STRUCT, LIST, CAPABILITY, _NOT_IN_SCHEMA = Value
        }

      }

      object Parameter extends org.capnproto.Struct {
        type Builder = BuilderImpl
        type Reader = ReaderImpl

        override def Builder: (SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
        override def Reader: (SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

        def structSize: StructSize = {
          Type.AnyPointer.Parameter.STRUCT_SIZE
        }

        val STRUCT_SIZE: StructSize = new StructSize(2.toShort, 1.toShort)

        final class BuilderImpl private[compiler](segment: SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends super.BuilderBase(segment, dataOffset, pointers, dataSize, pointerCount) {

          def scopeid: Long = {
            _getLongField(1)
          }

          def scopeid_=(value: Long) {
            _setLongField(1, value)
          }

          def parameterindex: Short = {
            _getShortField(1)
          }

          def parameterindex_=(value: Short) {
            _setShortField(1, value)
          }
        }

        final class ReaderImpl private[compiler](segment: SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends super.ReaderBase(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit) {
          def scopeid: Long = {
            _getLongField(1)
          }

          def parameterindex: Short = {
            _getShortField(1)
          }
        }

      }

      object ImplicitMethodParameter extends org.capnproto.Struct {
        type Builder = BuilderImpl
        type Reader = ReaderImpl

        override val Builder: (SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
        override val Reader: (SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

        def structSize: StructSize = {
          Type.AnyPointer.ImplicitMethodParameter.STRUCT_SIZE
        }

        val STRUCT_SIZE: StructSize = new StructSize(2.toShort, 1.toShort)

        final class BuilderImpl private[compiler](segment: SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends super.BuilderBase(segment, dataOffset, pointers, dataSize, pointerCount) {

          def parameterindex: Short = {
            _getShortField(1)
          }

          def parameterindex_=(value: Short) {
            _setShortField(1, value)
          }
        }

        final class ReaderImpl private[compiler](segment: SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends super.ReaderBase(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit) {
          def parameterindex: Short = {
            _getShortField(1)
          }
        }

      }

    }

  }

  object Brand extends org.capnproto.Struct {
    type Builder = BuilderImpl
    type Reader = ReaderImpl

    override val Builder: (SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    def structSize: StructSize = {
      Brand.STRUCT_SIZE
    }

    val STRUCT_SIZE: StructSize = new StructSize(0.toShort, 1.toShort)

    final class BuilderImpl private[compiler](segment: SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends super.BuilderBase(segment, dataOffset, pointers, dataSize, pointerCount) {

      def hasScopes: Boolean = {
        !_pointerFieldIsNull(0)
      }

      def scopes: CapnpSchema.Brand.Scope.List.Builder = {
        _getPointerField(CapnpSchema.Brand.Scope.List, 0, null, 0)
      }

      def scopes_=(value: CapnpSchema.Brand.Scope.List.Reader) {
        _setPointerField(CapnpSchema.Brand.Scope.List)(0, value)
      }

      def initScopes(size: Int): CapnpSchema.Brand.Scope.List.Builder = {
        _initPointerField(CapnpSchema.Brand.Scope.List, 0, size)
      }
    }

    final class ReaderImpl private[compiler](segment: SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends super.ReaderBase(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit) {
      def hasScopes: Boolean = {
        !_pointerFieldIsNull(0)
      }

      def scopes: CapnpSchema.Brand.Scope.List.Reader = {
        _getPointerField(CapnpSchema.Brand.Scope.List, 0, null, 0)
      }
    }

    object Scope extends org.capnproto.Struct {
      type Builder = BuilderImpl
      type Reader = ReaderImpl

      override val Builder: (SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def structSize: StructSize = {
        Brand.Scope.STRUCT_SIZE
      }

      val STRUCT_SIZE: StructSize = new StructSize(2.toShort, 1.toShort)

      final class BuilderImpl private[compiler](segment: SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends super.BuilderBase(segment, dataOffset, pointers, dataSize, pointerCount) {
        def which: CapnpSchema.Brand.Scope.Which.Which = {
          _getShortField(4) match {
            case 0 =>
              Which.BIND
            case 1 =>
              Which.INHERIT
            case _ =>
              Which._NOT_IN_SCHEMA
          }
        }

        def scopeid: Long = {
          _getLongField(0)
        }

        def scopeid_=(value: Long) {
          _setLongField(0, value)
        }

        def isBind: Boolean = {
          which == Brand.Scope.Which.BIND
        }

        def hasBind: Boolean = {
          !_pointerFieldIsNull(0)
        }

        def bind: CapnpSchema.Brand.Binding.List.Builder = {
          _getPointerField(CapnpSchema.Brand.Binding.List, 0, null, 0)
        }

        def bind_=(value: CapnpSchema.Brand.Binding.List.Reader) {
          _setPointerField(CapnpSchema.Brand.Binding.List)(0, value)
        }

        def initBind(size: Int): CapnpSchema.Brand.Binding.List.Builder = {
          _initPointerField(CapnpSchema.Brand.Binding.List, 0, size)
        }

        def isInherit: Boolean = {
          which == Brand.Scope.Which.INHERIT
        }

        def inherit: Void = {
          assert(which == Brand.Scope.Which.INHERIT, "Must check which() before get()ing a union member.")
          org.capnproto.Void.VOID
        }

        def inherit_=(value: Void) {
          _setShortField(4, Brand.Scope.Which.INHERIT.id.toShort)
        }
      }

      final class ReaderImpl private[compiler](segment: SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends super.ReaderBase(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit) {
        def which: CapnpSchema.Brand.Scope.Which.Which = {
          _getShortField(4) match {
            case 0 =>
              Which.BIND
            case 1 =>
              Which.INHERIT
            case _ =>
              Which._NOT_IN_SCHEMA
          }
        }

        def scopeid: Long = {
          _getLongField(0)
        }

        def isBind: Boolean = {
          which == Brand.Scope.Which.BIND
        }

        def hasBind: Boolean = {
          !_pointerFieldIsNull(0)
        }

        def bind: CapnpSchema.Brand.Binding.List.Reader = {
          _getPointerField(CapnpSchema.Brand.Binding.List, 0, null, 0)
        }

        def isInherit: Boolean = {
          which == Brand.Scope.Which.INHERIT
        }

        def inherit: Void = {
          assert(which == Brand.Scope.Which.INHERIT, "Must check which() before get()ing a union member.")
          org.capnproto.Void.VOID
        }
      }

      object Which extends Enumeration {
        type Which = Value
        val BIND, INHERIT, _NOT_IN_SCHEMA = Value
      }

    }

    object Binding extends org.capnproto.Struct {
      type Builder = BuilderImpl
      type Reader = ReaderImpl

      override val Builder: (SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def structSize: StructSize = {
        Brand.Binding.STRUCT_SIZE
      }

      val STRUCT_SIZE: StructSize = new StructSize(1.toShort, 1.toShort)

      final class BuilderImpl private[compiler](segment: SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends super.BuilderBase(segment, dataOffset, pointers, dataSize, pointerCount) {
        def which: CapnpSchema.Brand.Binding.Which.Which = {
          _getShortField(0) match {
            case 0 =>
              Which.UNBOUND
            case 1 =>
              Which.TYPE
            case _ =>
              Which._NOT_IN_SCHEMA
          }
        }

        def isUnbound: Boolean = {
          which == Brand.Binding.Which.UNBOUND
        }

        def unbound: Void = {
          assert(which == Brand.Binding.Which.UNBOUND, "Must check which() before get()ing a union member.")
          org.capnproto.Void.VOID
        }

        def unbound_=(value: Void) {
          _setShortField(0, Brand.Binding.Which.UNBOUND.id.toShort)
        }

        def isType: Boolean = {
          which == Brand.Binding.Which.TYPE
        }

        def capnpType: CapnpSchema.Type.Builder = {
          assert(which == Brand.Binding.Which.TYPE, "Must check which() before get()ing a union member.")
          _getPointerField(CapnpSchema.Type, 0, null, 0)
        }

        def capnpType_=(value: CapnpSchema.Type.Reader) {
          _setShortField(0, Brand.Binding.Which.TYPE.id.toShort)
          _setPointerField(CapnpSchema.Type)(0, value)
        }

        def initType: CapnpSchema.Type.Builder = {
          _setShortField(0, Brand.Binding.Which.TYPE.id.toShort)
          _initPointerField(CapnpSchema.Type, 0, 0)
        }
      }

      final class ReaderImpl private[compiler](segment: SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends super.ReaderBase(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit) {
        def which: CapnpSchema.Brand.Binding.Which.Which = {
          _getShortField(0) match {
            case 0 =>
              Which.UNBOUND
            case 1 =>
              Which.TYPE
            case _ =>
              Which._NOT_IN_SCHEMA
          }
        }

        def isUnbound: Boolean = {
          which == Brand.Binding.Which.UNBOUND
        }

        def unbound: Void = {
          assert(which == Brand.Binding.Which.UNBOUND, "Must check which() before get()ing a union member.")
          org.capnproto.Void.VOID
        }

        def isType: Boolean = {
          which == Brand.Binding.Which.TYPE
        }

        def hasType: Boolean = {
          !_pointerFieldIsNull(0)
        }

        def capnpType: CapnpSchema.Type.Reader = {
          assert(which == Brand.Binding.Which.TYPE, "Must check which() before get()ing a union member.")
          _getPointerField(CapnpSchema.Type, 0, null, 0)
        }
      }

      object Which extends Enumeration {
        type Which = Value
        val UNBOUND, TYPE, _NOT_IN_SCHEMA = Value
      }

    }

  }

  object Value extends org.capnproto.Struct {
    type Builder = BuilderImpl
    type Reader = ReaderImpl

    override val Builder: (SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    def structSize: StructSize = {
      Value.STRUCT_SIZE
    }

    val STRUCT_SIZE: StructSize = new StructSize(2.toShort, 1.toShort)

    final class BuilderImpl private[compiler](segment: SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends super.BuilderBase(segment, dataOffset, pointers, dataSize, pointerCount) {
      def which: CapnpSchema.Value.Which.Which = {
        _getShortField(0) match {
          case 0 =>
            Which.VOID
          case 1 =>
            Which.BOOL
          case 2 =>
            Which.INT8
          case 3 =>
            Which.INT16
          case 4 =>
            Which.INT32
          case 5 =>
            Which.INT64
          case 6 =>
            Which.UINT8
          case 7 =>
            Which.UINT16
          case 8 =>
            Which.UINT32
          case 9 =>
            Which.UINT64
          case 10 =>
            Which.FLOAT32
          case 11 =>
            Which.FLOAT64
          case 12 =>
            Which.TEXT
          case 13 =>
            Which.DATA
          case 14 =>
            Which.LIST
          case 15 =>
            Which.ENUM
          case 16 =>
            Which.STRUCT
          case 17 =>
            Which.INTERFACE
          case 18 =>
            Which.ANY_POINTER
          case _ =>
            Which._NOT_IN_SCHEMA
        }
      }

      def isVoid: Boolean = {
        which == Value.Which.VOID
      }

      def void: Void = {
        assert(which == Value.Which.VOID, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def void_=(value: Void) {
        _setShortField(0, Value.Which.VOID.id.toShort)
      }

      def isBool: Boolean = {
        which == Value.Which.BOOL
      }

      def bool: Boolean = {
        assert(which == Value.Which.BOOL, "Must check which() before get()ing a union member.")
        _getBooleanField(16)
      }

      def bool_=(value: Boolean) {
        _setShortField(0, Value.Which.BOOL.id.toShort)
        _setBooleanField(16, value)
      }

      def isInt8: Boolean = {
        which == Value.Which.INT8
      }

      def int8: Byte = {
        assert(which == Value.Which.INT8, "Must check which() before get()ing a union member.")
        _getByteField(2)
      }

      def int8_=(value: Byte) {
        _setShortField(0, Value.Which.INT8.id.toShort)
        _setByteField(2, value)
      }

      def isInt16: Boolean = {
        which == Value.Which.INT16
      }

      def int16: Short = {
        assert(which == Value.Which.INT16, "Must check which() before get()ing a union member.")
        _getShortField(1)
      }

      def int16_=(value: Short) {
        _setShortField(0, Value.Which.INT16.id.toShort)
        _setShortField(1, value)
      }

      def isInt32: Boolean = {
        which == Value.Which.INT32
      }

      def int32: Int = {
        assert(which == Value.Which.INT32, "Must check which() before get()ing a union member.")
        _getIntField(1)
      }

      def int32_=(value: Int) {
        _setShortField(0, Value.Which.INT32.id.toShort)
        _setIntField(1, value)
      }

      def isInt64: Boolean = {
        which == Value.Which.INT64
      }

      def int64: Long = {
        assert(which == Value.Which.INT64, "Must check which() before get()ing a union member.")
        _getLongField(1)
      }

      def int64_=(value: Long) {
        _setShortField(0, Value.Which.INT64.id.toShort)
        _setLongField(1, value)
      }

      def isUint8: Boolean = {
        which == Value.Which.UINT8
      }

      def uint8: Byte = {
        assert(which == Value.Which.UINT8, "Must check which() before get()ing a union member.")
        _getByteField(2)
      }

      def uint8_=(value: Byte) {
        _setShortField(0, Value.Which.UINT8.id.toShort)
        _setByteField(2, value)
      }

      def isUint16: Boolean = {
        which == Value.Which.UINT16
      }

      def uint16: Short = {
        assert(which == Value.Which.UINT16, "Must check which() before get()ing a union member.")
        _getShortField(1)
      }

      def uint16_=(value: Short) {
        _setShortField(0, Value.Which.UINT16.id.toShort)
        _setShortField(1, value)
      }

      def isUint32: Boolean = {
        which == Value.Which.UINT32
      }

      def uint32: Int = {
        assert(which == Value.Which.UINT32, "Must check which() before get()ing a union member.")
        _getIntField(1)
      }

      def uint32_=(value: Int) {
        _setShortField(0, Value.Which.UINT32.id.toShort)
        _setIntField(1, value)
      }

      def isUint64: Boolean = {
        which == Value.Which.UINT64
      }

      def uint64: Long = {
        assert(which == Value.Which.UINT64, "Must check which() before get()ing a union member.")
        _getLongField(1)
      }

      def uint64_=(value: Long) {
        _setShortField(0, Value.Which.UINT64.id.toShort)
        _setLongField(1, value)
      }

      def isFloat32: Boolean = {
        which == Value.Which.FLOAT32
      }

      def float32: Float = {
        assert(which == Value.Which.FLOAT32, "Must check which() before get()ing a union member.")
        _getFloatField(1)
      }

      def float32_=(value: Float) {
        _setShortField(0, Value.Which.FLOAT32.id.toShort)
        _setFloatField(1, value)
      }

      def isFloat64: Boolean = {
        which == Value.Which.FLOAT64
      }

      def float64: Double = {
        assert(which == Value.Which.FLOAT64, "Must check which() before get()ing a union member.")
        _getDoubleField(1)
      }

      def float64_=(value: Double) {
        _setShortField(0, Value.Which.FLOAT64.id.toShort)
        _setDoubleField(1, value)
      }

      def isText: Boolean = {
        which == Value.Which.TEXT
      }

      def hasText: Boolean = {
        if (which != Value.Which.TEXT) return false
        !_pointerFieldIsNull(0)
      }

      def text: Text.Builder = {
        _getPointerField(org.capnproto.Text, 0, null, 0, 0)
      }

      def text_=(value: Text.Reader) {
        _setShortField(0, Value.Which.TEXT.id.toShort)
        _setPointerField(org.capnproto.Text)(0, value)
      }

      def text_=(value: String) {
        _setShortField(0, Value.Which.TEXT.id.toShort)
        _setPointerField(org.capnproto.Text)(0, new Text.Reader(value))
      }

      def initText(size: Int): Text.Builder = {
        _initPointerField(org.capnproto.Text, 0, size)
      }

      def isData: Boolean = {
        which == Value.Which.DATA
      }

      def hasData: Boolean = {
        if (which != Value.Which.DATA) return false
        !_pointerFieldIsNull(0)
      }

      def data: Data.Builder = {
        _getPointerField(org.capnproto.Data, 0, null, 0, 0)
      }

      def data_=(value: Data.Reader) {
        _setShortField(0, Value.Which.DATA.id.toShort)
        _setPointerField(org.capnproto.Data)(0, value)
      }

      def data_=(value: Array[Byte]) {
        _setShortField(0, Value.Which.DATA.id.toShort)
        _setPointerField(org.capnproto.Data)(0, new Data.Reader(value))
      }

      def initData(size: Int): Data.Builder = {
        _initPointerField(org.capnproto.Data, 0, size)
      }

      def isList: Boolean = {
        which == Value.Which.LIST
      }

      def hasList: Boolean = {
        !_pointerFieldIsNull(0)
      }

      def list: AnyPointer.Builder = {
        assert(which == Value.Which.LIST, "Must check which() before get()ing a union member.")
        _getPointerField(org.capnproto.AnyPointer, 0)
      }

      def initList: AnyPointer.Builder = {
        _setShortField(0, Value.Which.LIST.id.toShort)
        _initPointerField(org.capnproto.AnyPointer, 0, 0)
      }

      def initList(size: Int): AnyPointer.Builder = {
        _setShortField(0, Value.Which.LIST.id.toShort)
        _initPointerField(org.capnproto.AnyPointer, 0, size)
      }

      def isEnum: Boolean = {
        which == Value.Which.ENUM
      }

      def enum: Short = {
        assert(which == Value.Which.ENUM, "Must check which() before get()ing a union member.")
        _getShortField(1)
      }

      def enum_=(value: Short) {
        _setShortField(0, Value.Which.ENUM.id.toShort)
        _setShortField(1, value)
      }

      def isStruct: Boolean = {
        which == Value.Which.STRUCT
      }

      def hasStruct: Boolean = {
        !_pointerFieldIsNull(0)
      }

      def struct: AnyPointer.Builder = {
        assert(which == Value.Which.STRUCT, "Must check which() before get()ing a union member.")
        _getPointerField(org.capnproto.AnyPointer, 0)
      }

      def initStruct: AnyPointer.Builder = {
        _setShortField(0, Value.Which.STRUCT.id.toShort)
        _initPointerField(org.capnproto.AnyPointer, 0, 0)
      }

      def initStruct(size: Int): AnyPointer.Builder = {
        _setShortField(0, Value.Which.STRUCT.id.toShort)
        _initPointerField(org.capnproto.AnyPointer, 0, size)
      }

      def isInterface: Boolean = {
        which == Value.Which.INTERFACE
      }

      def interface: Void = {
        assert(which == Value.Which.INTERFACE, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def interface_=(value: Void) {
        _setShortField(0, Value.Which.INTERFACE.id.toShort)
      }

      def isAnyPointer: Boolean = {
        which == Value.Which.ANY_POINTER
      }

      def hasAnyPointer: Boolean = {
        !_pointerFieldIsNull(0)
      }

      def anypointer: AnyPointer.Builder = {
        assert(which == Value.Which.ANY_POINTER, "Must check which() before get()ing a union member.")
        _getPointerField(org.capnproto.AnyPointer, 0)
      }

      def initAnyPointer: AnyPointer.Builder = {
        _setShortField(0, Value.Which.ANY_POINTER.id.toShort)
        _initPointerField(org.capnproto.AnyPointer, 0, 0)
      }

      def initAnyPointer(size: Int): AnyPointer.Builder = {
        _setShortField(0, Value.Which.ANY_POINTER.id.toShort)
        _initPointerField(org.capnproto.AnyPointer, 0, size)
      }
    }

    final class ReaderImpl private[compiler](segment: SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends super.ReaderBase(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit) {
      def which: CapnpSchema.Value.Which.Which = {
        _getShortField(0) match {
          case 0 =>
            Which.VOID
          case 1 =>
            Which.BOOL
          case 2 =>
            Which.INT8
          case 3 =>
            Which.INT16
          case 4 =>
            Which.INT32
          case 5 =>
            Which.INT64
          case 6 =>
            Which.UINT8
          case 7 =>
            Which.UINT16
          case 8 =>
            Which.UINT32
          case 9 =>
            Which.UINT64
          case 10 =>
            Which.FLOAT32
          case 11 =>
            Which.FLOAT64
          case 12 =>
            Which.TEXT
          case 13 =>
            Which.DATA
          case 14 =>
            Which.LIST
          case 15 =>
            Which.ENUM
          case 16 =>
            Which.STRUCT
          case 17 =>
            Which.INTERFACE
          case 18 =>
            Which.ANY_POINTER
          case _ =>
            Which._NOT_IN_SCHEMA
        }
      }

      def isVoid: Boolean = {
        which == Value.Which.VOID
      }

      def void: Void = {
        assert(which == Value.Which.VOID, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def isBool: Boolean = {
        which == Value.Which.BOOL
      }

      def bool: Boolean = {
        assert(which == Value.Which.BOOL, "Must check which() before get()ing a union member.")
        _getBooleanField(16)
      }

      def isInt8: Boolean = {
        which == Value.Which.INT8
      }

      def int8: Byte = {
        assert(which == Value.Which.INT8, "Must check which() before get()ing a union member.")
        _getByteField(2)
      }

      def isInt16: Boolean = {
        which == Value.Which.INT16
      }

      def int16: Short = {
        assert(which == Value.Which.INT16, "Must check which() before get()ing a union member.")
        _getShortField(1)
      }

      def isInt32: Boolean = {
        which == Value.Which.INT32
      }

      def int32: Int = {
        assert(which == Value.Which.INT32, "Must check which() before get()ing a union member.")
        _getIntField(1)
      }

      def isInt64: Boolean = {
        which == Value.Which.INT64
      }

      def int64: Long = {
        assert(which == Value.Which.INT64, "Must check which() before get()ing a union member.")
        _getLongField(1)
      }

      def isUint8: Boolean = {
        which == Value.Which.UINT8
      }

      def uint8: Byte = {
        assert(which == Value.Which.UINT8, "Must check which() before get()ing a union member.")
        _getByteField(2)
      }

      def isUint16: Boolean = {
        which == Value.Which.UINT16
      }

      def uint16: Short = {
        assert(which == Value.Which.UINT16, "Must check which() before get()ing a union member.")
        _getShortField(1)
      }

      def isUint32: Boolean = {
        which == Value.Which.UINT32
      }

      def uint32: Int = {
        assert(which == Value.Which.UINT32, "Must check which() before get()ing a union member.")
        _getIntField(1)
      }

      def isUint64: Boolean = {
        which == Value.Which.UINT64
      }

      def uint64: Long = {
        assert(which == Value.Which.UINT64, "Must check which() before get()ing a union member.")
        _getLongField(1)
      }

      def isFloat32: Boolean = {
        which == Value.Which.FLOAT32
      }

      def float32: Float = {
        assert(which == Value.Which.FLOAT32, "Must check which() before get()ing a union member.")
        _getFloatField(1)
      }

      def isFloat64: Boolean = {
        which == Value.Which.FLOAT64
      }

      def float64: Double = {
        assert(which == Value.Which.FLOAT64, "Must check which() before get()ing a union member.")
        _getDoubleField(1)
      }

      def isText: Boolean = {
        which == Value.Which.TEXT
      }

      def hasText: Boolean = {
        if (which != Value.Which.TEXT) return false
        !_pointerFieldIsNull(0)
      }

      def text: Text.Reader = {
        _getPointerField(org.capnproto.Text, 0, null, 0, 0)
      }

      def isData: Boolean = {
        which == Value.Which.DATA
      }

      def hasData: Boolean = {
        if (which != Value.Which.DATA) return false
        !_pointerFieldIsNull(0)
      }

      def data: Data.Reader = {
        _getPointerField(org.capnproto.Data, 0, null, 0, 0)
      }

      def isList: Boolean = {
        which == Value.Which.LIST
      }

      def hasList: Boolean = {
        if (which != Value.Which.LIST) return false
        !_pointerFieldIsNull(0)
      }

      def list: AnyPointer.Reader = {
        assert(which == Value.Which.LIST, "Must check which() before get()ing a union member.")
        _getPointerField(org.capnproto.AnyPointer, 0)
      }

      def isEnum: Boolean = {
        which == Value.Which.ENUM
      }

      def enum: Short = {
        assert(which == Value.Which.ENUM, "Must check which() before get()ing a union member.")
        _getShortField(1)
      }

      def isStruct: Boolean = {
        which == Value.Which.STRUCT
      }

      def hasStruct: Boolean = {
        if (which != Value.Which.STRUCT) return false
        !_pointerFieldIsNull(0)
      }

      def struct: AnyPointer.Reader = {
        assert(which == Value.Which.STRUCT, "Must check which() before get()ing a union member.")
        _getPointerField(org.capnproto.AnyPointer, 0)
      }

      def isInterface: Boolean = {
        which == Value.Which.INTERFACE
      }

      def interface: Void = {
        assert(which == Value.Which.INTERFACE, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def isAnyPointer: Boolean = {
        which == Value.Which.ANY_POINTER
      }

      def hasAnyPointer: Boolean = {
        if (which != Value.Which.ANY_POINTER) return false
        !_pointerFieldIsNull(0)
      }

      def anypointer: AnyPointer.Reader = {
        assert(which == Value.Which.ANY_POINTER, "Must check which() before get()ing a union member.")
        _getPointerField(org.capnproto.AnyPointer, 0)
      }
    }

    object Which extends Enumeration {
      type Which = Value
      val VOID, BOOL, INT8, INT16, INT32, INT64, UINT8, UINT16, UINT32, UINT64, FLOAT32, FLOAT64, TEXT, DATA, LIST, ENUM, STRUCT, INTERFACE, ANY_POINTER, _NOT_IN_SCHEMA = Value
    }

  }

  object Annotation extends org.capnproto.Struct {
    type Builder = BuilderImpl
    type Reader = ReaderImpl

    override val Builder: (SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    def structSize: StructSize = {
      Annotation.STRUCT_SIZE
    }

    val STRUCT_SIZE: StructSize = new StructSize(1.toShort, 2.toShort)

    final class BuilderImpl private[compiler](segment: SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends super.BuilderBase(segment, dataOffset, pointers, dataSize, pointerCount) {

      def id: Long = {
        _getLongField(0)
      }

      def id_=(value: Long) {
        _setLongField(0, value)
      }

      def value: CapnpSchema.Value.Builder = {
        _getPointerField(CapnpSchema.Value, 0, null, 0)
      }

      def value_=(value: CapnpSchema.Value.Reader) {
        _setPointerField(CapnpSchema.Value)(0, value)
      }

      def initValue: CapnpSchema.Value.Builder = {
        _initPointerField(CapnpSchema.Value, 0, 0)
      }

      def brand: CapnpSchema.Brand.Builder = {
        _getPointerField(CapnpSchema.Brand, 1, null, 0)
      }

      def brand_=(value: CapnpSchema.Brand.Reader) {
        _setPointerField(CapnpSchema.Brand)(1, value)
      }

      def initBrand: CapnpSchema.Brand.Builder = {
        _initPointerField(CapnpSchema.Brand, 1, 0)
      }
    }

    final class ReaderImpl private[compiler](segment: SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends super.ReaderBase(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit) {
      def id: Long = {
        _getLongField(0)
      }

      def hasValue: Boolean = {
        !_pointerFieldIsNull(0)
      }

      def value: CapnpSchema.Value.Reader = {
        _getPointerField(CapnpSchema.Value, 0, null, 0)
      }

      def hasBrand: Boolean = {
        !_pointerFieldIsNull(1)
      }

      def brand: CapnpSchema.Brand.Reader = {
        _getPointerField(CapnpSchema.Brand, 1, null, 0)
      }
    }

  }

  object ElementSize extends Enumeration {
    type ElementSize = Value
    val EMPTY, BIT, BYTE, TWO_BYTES, FOUR_BYTES, EIGHT_BYTES, POINTER, INLINE_COMPOSITE, _NOT_IN_SCHEMA = Value
  }

  object CodeGeneratorRequest extends org.capnproto.Struct {
    type Builder = BuilderImpl
    type Reader = ReaderImpl

    override val Builder: (SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    def structSize: StructSize = {
      CodeGeneratorRequest.STRUCT_SIZE
    }

    val STRUCT_SIZE: StructSize = new StructSize(0.toShort, 2.toShort)

    final class BuilderImpl private[compiler](segment: SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends super.BuilderBase(segment, dataOffset, pointers, dataSize, pointerCount) {

      def hasNodes: Boolean = {
        !_pointerFieldIsNull(0)
      }

      def nodes: CapnpSchema.Node.List.Builder = {
        _getPointerField(CapnpSchema.Node.List, 0, null, 0)
      }

      def nodes_=(value: CapnpSchema.Node.List.Reader) {
        _setPointerField(CapnpSchema.Node.List)(0, value)
      }

      def initNodes(size: Int): CapnpSchema.Node.List.Builder = {
        _initPointerField(CapnpSchema.Node.List, 0, size)
      }

      def hasRequestedFiles: Boolean = {
        !_pointerFieldIsNull(1)
      }

      def requestedfiles: CapnpSchema.CodeGeneratorRequest.RequestedFile.List.Builder = {
        _getPointerField(CapnpSchema.CodeGeneratorRequest.RequestedFile.List, 1, null, 0)
      }

      def requestedfiles_=(value: CapnpSchema.CodeGeneratorRequest.RequestedFile.List.Reader) {
        _setPointerField(CapnpSchema.CodeGeneratorRequest.RequestedFile.List)(1, value)
      }

      def initRequestedFiles(size: Int): CapnpSchema.CodeGeneratorRequest.RequestedFile.List.Builder = {
        _initPointerField(CapnpSchema.CodeGeneratorRequest.RequestedFile.List, 1, size)
      }
    }

    final class ReaderImpl private[compiler](segment: SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends super.ReaderBase(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit) {
      def hasNodes: Boolean = {
        !_pointerFieldIsNull(0)
      }

      def nodes: CapnpSchema.Node.List.Reader = {
        _getPointerField(CapnpSchema.Node.List, 0, null, 0)
      }

      def hasRequestedFiles: Boolean = {
        !_pointerFieldIsNull(1)
      }

      def requestedfiles: CapnpSchema.CodeGeneratorRequest.RequestedFile.List.Reader = {
        _getPointerField(CapnpSchema.CodeGeneratorRequest.RequestedFile.List, 1, null, 0)
      }
    }

    object RequestedFile extends org.capnproto.Struct {
      type Builder = BuilderImpl
      type Reader = ReaderImpl

      override val Builder: (SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def structSize: StructSize = {
        CodeGeneratorRequest.RequestedFile.STRUCT_SIZE
      }

      val STRUCT_SIZE: StructSize = new StructSize(1.toShort, 2.toShort)

      final class BuilderImpl private[compiler](segment: SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends super.BuilderBase(segment, dataOffset, pointers, dataSize, pointerCount) {

        def id: Long = {
          _getLongField(0)
        }

        def id_=(value: Long) {
          _setLongField(0, value)
        }

        def hasFilename: Boolean = {
          !_pointerFieldIsNull(0)
        }

        def filename: Text.Builder = {
          _getPointerField(org.capnproto.Text, 0, null, 0, 0)
        }

        def filename_=(value: Text.Reader) {
          _setPointerField(org.capnproto.Text)(0, value)
        }

        def filename_=(value: String) {
          _setPointerField(org.capnproto.Text)(0, new Text.Reader(value))
        }

        def initFilename(size: Int): Text.Builder = {
          _initPointerField(org.capnproto.Text, 0, size)
        }

        def hasImports: Boolean = {
          !_pointerFieldIsNull(1)
        }

        def imports: CapnpSchema.CodeGeneratorRequest.RequestedFile.Import.List.Builder = {
          _getPointerField(CapnpSchema.CodeGeneratorRequest.RequestedFile.Import.List, 1, null, 0)
        }

        def imports_=(value: CapnpSchema.CodeGeneratorRequest.RequestedFile.Import.List.Reader) {
          _setPointerField(CapnpSchema.CodeGeneratorRequest.RequestedFile.Import.List)(1, value)
        }

        def initImports(size: Int): CapnpSchema.CodeGeneratorRequest.RequestedFile.Import.List.Builder = {
          _initPointerField(CapnpSchema.CodeGeneratorRequest.RequestedFile.Import.List, 1, size)
        }
      }

      final class ReaderImpl private[compiler](segment: SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends super.ReaderBase(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit) {
        def id: Long = {
          _getLongField(0)
        }

        def hasFilename: Boolean = {
          !_pointerFieldIsNull(0)
        }

        def filename: Text.Reader = {
          _getPointerField(org.capnproto.Text, 0, null, 0, 0)
        }

        def hasImports: Boolean = {
          !_pointerFieldIsNull(1)
        }

        def imports: CapnpSchema.CodeGeneratorRequest.RequestedFile.Import.List.Reader = {
          _getPointerField(CapnpSchema.CodeGeneratorRequest.RequestedFile.Import.List, 1, null, 0)
        }
      }

      object Import extends org.capnproto.Struct {
        type Builder = BuilderImpl
        type Reader = ReaderImpl

        override val Builder: (SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
        override val Reader: (SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

        def structSize: StructSize = {
          CodeGeneratorRequest.RequestedFile.Import.STRUCT_SIZE
        }

        val STRUCT_SIZE: StructSize = new StructSize(1.toShort, 1.toShort)

        final class BuilderImpl private[compiler](segment: SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends super.BuilderBase(segment, dataOffset, pointers, dataSize, pointerCount) {

          def id: Long = {
            _getLongField(0)
          }

          def id_=(value: Long) {
            _setLongField(0, value)
          }

          def hasName: Boolean = {
            !_pointerFieldIsNull(0)
          }

          def name: Text.Builder = {
            _getPointerField(org.capnproto.Text, 0, null, 0, 0)
          }

          def name_=(value: Text.Reader) {
            _setPointerField(org.capnproto.Text)(0, value)
          }

          def name_=(value: String) {
            _setPointerField(org.capnproto.Text)(0, new Text.Reader(value))
          }

          def initName(size: Int): Text.Builder = {
            _initPointerField(org.capnproto.Text, 0, size)
          }
        }

        final class ReaderImpl private[compiler](segment: SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends super.ReaderBase(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit) {
          def id: Long = {
            _getLongField(0)
          }

          def hasName: Boolean = {
            !_pointerFieldIsNull(0)
          }

          def name: Text.Reader = {
            _getPointerField(org.capnproto.Text, 0, null, 0, 0)
          }
        }

      }

    }

  }

  object Schemas {
    val b_e682ab4cf923a417: SegmentReader = org.capnproto.GeneratedClassSupport.decodeRawBytes("\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u0017\u00a4\u0023\u00f9\u004c\u00ab\u0082\u00e6" + "\r\u0000\u0000\u0000\u0001\u0000\u0005\u0000" + "\u00d9\u0072\u004c\u0062\u0009\u00c5\u003f\u00a9" + "\u0006\u0000\u0007\u0000\u0000\u0000\u0006\u0000" + "\u0006\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u0092\u0000\u0000\u0000" + "\u001d\u0000\u0000\u0000\u0027\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0039\u0000\u0000\u0000\u0017\u0003\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0063\u0068\u0065\u006d\u0061\u002e\u0063" + "\u0061\u0070\u006e\u0070\u003a\u004e\u006f\u0064" + "\u0065\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0008\u0000\u0000\u0000\u0001\u0000\u0001\u0000" + "\u00b1\u00a3\u000f\u00f1\u00cc\u001b\u0052\u00b9" + "\u0009\u0000\u0000\u0000\u0052\u0000\u0000\u0000" + "\u0042\u00c2\u000f\u00fa\u00bb\u0055\u00bf\u00de" + "\u0009\u0000\u0000\u0000\u005a\u0000\u0000\u0000" + "\u0050\u0061\u0072\u0061\u006d\u0065\u0074\u0065" + "\u0072\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u004e\u0065\u0073\u0074\u0065\u0064\u004e\u006f" + "\u0064\u0065\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0038\u0000\u0000\u0000\u0003\u0000\u0004\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0079\u0001\u0000\u0000\u001a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0074\u0001\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0080\u0001\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u007d\u0001\u0000\u0000\u0062\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u007c\u0001\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0088\u0001\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0002\u0000\u0000\u0000\u0002\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0002\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0085\u0001\u0000\u0000\u00c2\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0088\u0001\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0094\u0001\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0003\u0000\u0000\u0000\u0002\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0003\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0091\u0001\u0000\u0000\u0042\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u008c\u0001\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0098\u0001\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0006\u0000\u0000\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0004\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0095\u0001\u0000\u0000\u0062\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0094\u0001\u0000\u0000\u0003\u0000\u0001\u0000" + "\u00b0\u0001\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0007\u0000\u0000\u0000\u0002\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0005\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00ad\u0001\u0000\u0000\u0062\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00ac\u0001\u0000\u0000\u0003\u0000\u0001\u0000" + "\u00c8\u0001\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0008\u0000\u00ff\u00ff\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0006\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00c5\u0001\u0000\u0000\u002a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00c0\u0001\u0000\u0000\u0003\u0000\u0001\u0000" + "\u00cc\u0001\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0009\u0000\u00fe\u00ff\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0035\u0044\u00fb\u0037\u009b\u00b1\u00a0\u009e" + "\u00c9\u0001\u0000\u0000\u003a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\n\u0000\u00fd\u00ff\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0098\u00f5\u0033\u0043\u0036\u00b3\u004a\u00b5" + "\u00b1\u0001\u0000\u0000\u002a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000b\u0000\u00fc\u00ff\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u008f\u0021\u00c2\u00f0\u00cf\u0053\u0027\u00e8" + "\u0099\u0001\u0000\u0000\u0052\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000c\u0000\u00fb\u00ff\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0020\u0094\r\u007a\u00ac\u00a5\u008a\u00b1" + "\u0085\u0001\u0000\u0000\u0032\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\r\u0000\u00fa\u00ff\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0090\u0002\n\u0040\u00d4\u0019\u0016\u00ec" + "\u006d\u0001\u0000\u0000\u005a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0004\u0000\u0000\u0000\u0005\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0020\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0059\u0001\u0000\u0000\u005a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0058\u0001\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0074\u0001\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0005\u0000\u0000\u0000\u0020\u0001\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0021\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0071\u0001\u0000\u0000\u0052\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0070\u0001\u0000\u0000\u0003\u0000\u0001\u0000" + "\u007c\u0001\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0069\u0064\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0009\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0009\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0064\u0069\u0073\u0070\u006c\u0061\u0079\u004e" + "\u0061\u006d\u0065\u0000\u0000\u0000\u0000\u0000" + "\u000c\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000c\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0064\u0069\u0073\u0070\u006c\u0061\u0079\u004e" + "\u0061\u006d\u0065\u0050\u0072\u0065\u0066\u0069" + "\u0078\u004c\u0065\u006e\u0067\u0074\u0068\u0000" + "\u0008\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0008\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0063\u006f\u0070\u0065\u0049\u0064\u0000" + "\u0009\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0009\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u006e\u0065\u0073\u0074\u0065\u0064\u004e\u006f" + "\u0064\u0065\u0073\u0000\u0000\u0000\u0000\u0000" + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0042\u00c2\u000f\u00fa\u00bb\u0055\u00bf\u00de" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0061\u006e\u006e\u006f\u0074\u0061\u0074\u0069" + "\u006f\u006e\u0073\u0000\u0000\u0000\u0000\u0000" + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0042\u0075\u0025\u00ab\r\u0095\u00c8\u00f1" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0066\u0069\u006c\u0065\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0074\u0072\u0075\u0063\u0074\u0000\u0000" + "\u0065\u006e\u0075\u006d\u0000\u0000\u0000\u0000" + "\u0069\u006e\u0074\u0065\u0072\u0066\u0061\u0063" + "\u0065\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0063\u006f\u006e\u0073\u0074\u0000\u0000\u0000" + "\u0061\u006e\u006e\u006f\u0074\u0061\u0074\u0069" + "\u006f\u006e\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0070\u0061\u0072\u0061\u006d\u0065\u0074\u0065" + "\u0072\u0073\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00b1\u00a3\u000f\u00f1\u00cc\u001b\u0052\u00b9" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0069\u0073\u0047\u0065\u006e\u0065\u0072\u0069" + "\u0063\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "")
    val b_b9521bccf10fa3b1: SegmentReader = org.capnproto.GeneratedClassSupport.decodeRawBytes("\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u00b1\u00a3\u000f\u00f1\u00cc\u001b\u0052\u00b9" + "\u0012\u0000\u0000\u0000\u0001\u0000\u0000\u0000" + "\u0017\u00a4\u0023\u00f9\u004c\u00ab\u0082\u00e6" + "\u0001\u0000\u0007\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u00e2\u0000\u0000\u0000" + "\u0021\u0000\u0000\u0000\u0007\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u001d\u0000\u0000\u0000\u003f\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0063\u0068\u0065\u006d\u0061\u002e\u0063" + "\u0061\u0070\u006e\u0070\u003a\u004e\u006f\u0064" + "\u0065\u002e\u0050\u0061\u0072\u0061\u006d\u0065" + "\u0074\u0065\u0072\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0001\u0000\u0001\u0000" + "\u0004\u0000\u0000\u0000\u0003\u0000\u0004\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\r\u0000\u0000\u0000\u002a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0008\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0014\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u006e\u0061\u006d\u0065\u0000\u0000\u0000\u0000" + "\u000c\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000c\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "")
    val b_debf55bbfa0fc242: SegmentReader = org.capnproto.GeneratedClassSupport.decodeRawBytes("\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u0042\u00c2\u000f\u00fa\u00bb\u0055\u00bf\u00de" + "\u0012\u0000\u0000\u0000\u0001\u0000\u0001\u0000" + "\u0017\u00a4\u0023\u00f9\u004c\u00ab\u0082\u00e6" + "\u0001\u0000\u0007\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u00ea\u0000\u0000\u0000" + "\u0021\u0000\u0000\u0000\u0007\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u001d\u0000\u0000\u0000\u0077\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0063\u0068\u0065\u006d\u0061\u002e\u0063" + "\u0061\u0070\u006e\u0070\u003a\u004e\u006f\u0064" + "\u0065\u002e\u004e\u0065\u0073\u0074\u0065\u0064" + "\u004e\u006f\u0064\u0065\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0001\u0000\u0001\u0000" + "\u0008\u0000\u0000\u0000\u0003\u0000\u0004\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0029\u0000\u0000\u0000\u002a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0024\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0030\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u002d\u0000\u0000\u0000\u001a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0028\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0034\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u006e\u0061\u006d\u0065\u0000\u0000\u0000\u0000" + "\u000c\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000c\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0069\u0064\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0009\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0009\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "")
    val b_9ea0b19b37fb4435: SegmentReader = org.capnproto.GeneratedClassSupport.decodeRawBytes("\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u0035\u0044\u00fb\u0037\u009b\u00b1\u00a0\u009e" + "\u0012\u0000\u0000\u0000\u0001\u0000\u0005\u0000" + "\u0017\u00a4\u0023\u00f9\u004c\u00ab\u0082\u00e6" + "\u0006\u0000\u0007\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u00ca\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0019\u0000\u0000\u0000\u008f\u0001\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0063\u0068\u0065\u006d\u0061\u002e\u0063" + "\u0061\u0070\u006e\u0070\u003a\u004e\u006f\u0064" + "\u0065\u002e\u0073\u0074\u0072\u0075\u0063\u0074" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u001c\u0000\u0000\u0000\u0003\u0000\u0004\u0000" + "\u0000\u0000\u0000\u0000\u0007\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0007\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00b5\u0000\u0000\u0000\u0072\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00b4\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u00c0\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0001\u0000\u0000\u0000\u000c\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0008\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00bd\u0000\u0000\u0000\u006a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00bc\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u00c8\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0002\u0000\u0000\u0000\r\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0009\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00c5\u0000\u0000\u0000\u00b2\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00c8\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u00d4\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0003\u0000\u0000\u0000\u00e0\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\n\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00d1\u0000\u0000\u0000\u0042\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00cc\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u00d8\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0004\u0000\u0000\u0000\u000f\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u000b\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00d5\u0000\u0000\u0000\u0092\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00d8\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u00e4\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0005\u0000\u0000\u0000\u0008\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u000c\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00e1\u0000\u0000\u0000\u009a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00e4\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u00f0\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0006\u0000\u0000\u0000\u0003\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\r\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00ed\u0000\u0000\u0000\u003a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00e8\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0004\u0001\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0064\u0061\u0074\u0061\u0057\u006f\u0072\u0064" + "\u0043\u006f\u0075\u006e\u0074\u0000\u0000\u0000" + "\u0007\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0007\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0070\u006f\u0069\u006e\u0074\u0065\u0072\u0043" + "\u006f\u0075\u006e\u0074\u0000\u0000\u0000\u0000" + "\u0007\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0007\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0070\u0072\u0065\u0066\u0065\u0072\u0072\u0065" + "\u0064\u004c\u0069\u0073\u0074\u0045\u006e\u0063" + "\u006f\u0064\u0069\u006e\u0067\u0000\u0000\u0000" + "\u000f\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0026\u0019\u0052\u00ba\u007d\u008f\u0095\u00d1" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000f\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0069\u0073\u0047\u0072\u006f\u0075\u0070\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0064\u0069\u0073\u0063\u0072\u0069\u006d\u0069" + "\u006e\u0061\u006e\u0074\u0043\u006f\u0075\u006e" + "\u0074\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0007\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0007\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0064\u0069\u0073\u0063\u0072\u0069\u006d\u0069" + "\u006e\u0061\u006e\u0074\u004f\u0066\u0066\u0073" + "\u0065\u0074\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0008\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0008\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0066\u0069\u0065\u006c\u0064\u0073\u0000\u0000" + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u005f\u00f4\u004a\u001f\u00a4\u0050\u00ad\u009a" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "")
    val b_b54ab3364333f598: SegmentReader = org.capnproto.GeneratedClassSupport.decodeRawBytes("\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u0098\u00f5\u0033\u0043\u0036\u00b3\u004a\u00b5" + "\u0012\u0000\u0000\u0000\u0001\u0000\u0005\u0000" + "\u0017\u00a4\u0023\u00f9\u004c\u00ab\u0082\u00e6" + "\u0006\u0000\u0007\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u00ba\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u003f\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0063\u0068\u0065\u006d\u0061\u002e\u0063" + "\u0061\u0070\u006e\u0070\u003a\u004e\u006f\u0064" + "\u0065\u002e\u0065\u006e\u0075\u006d\u0000\u0000" + "\u0004\u0000\u0000\u0000\u0003\u0000\u0004\u0000" + "\u0000\u0000\u0000\u0000\u0003\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u000e\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\r\u0000\u0000\u0000\u005a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000c\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0028\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0065\u006e\u0075\u006d\u0065\u0072\u0061\u006e" + "\u0074\u0073\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u004d\u009a\u0054\u00dc\u00eb\u007c\u008a\u0097" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "")
    val b_e82753cff0c2218f: SegmentReader = org.capnproto.GeneratedClassSupport.decodeRawBytes("\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u008f\u0021\u00c2\u00f0\u00cf\u0053\u0027\u00e8" + "\u0012\u0000\u0000\u0000\u0001\u0000\u0005\u0000" + "\u0017\u00a4\u0023\u00f9\u004c\u00ab\u0082\u00e6" + "\u0006\u0000\u0007\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u00e2\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0019\u0000\u0000\u0000\u0077\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0063\u0068\u0065\u006d\u0061\u002e\u0063" + "\u0061\u0070\u006e\u0070\u003a\u004e\u006f\u0064" + "\u0065\u002e\u0069\u006e\u0074\u0065\u0072\u0066" + "\u0061\u0063\u0065\u0000\u0000\u0000\u0000\u0000" + "\u0008\u0000\u0000\u0000\u0003\u0000\u0004\u0000" + "\u0000\u0000\u0000\u0000\u0003\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u000f\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0029\u0000\u0000\u0000\u0042\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0024\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0040\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0001\u0000\u0000\u0000\u0004\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u001f\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u003d\u0000\u0000\u0000\u006a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u003c\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0058\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u006d\u0065\u0074\u0068\u006f\u0064\u0073\u0000" + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0080\u004d\u0033\u003b\u00e2\u00cc\u0000\u0095" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0075\u0070\u0065\u0072\u0063\u006c\u0061" + "\u0073\u0073\u0065\u0073\u0000\u0000\u0000\u0000" + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00f8\u00d7\u00a4\u00d0\u009e\u002a\u0096\u00a9" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "")
    val b_b18aa5ac7a0d9420: SegmentReader = org.capnproto.GeneratedClassSupport.decodeRawBytes("\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u0020\u0094\r\u007a\u00ac\u00a5\u008a\u00b1" + "\u0012\u0000\u0000\u0000\u0001\u0000\u0005\u0000" + "\u0017\u00a4\u0023\u00f9\u004c\u00ab\u0082\u00e6" + "\u0006\u0000\u0007\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u00c2\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u0077\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0063\u0068\u0065\u006d\u0061\u002e\u0063" + "\u0061\u0070\u006e\u0070\u003a\u004e\u006f\u0064" + "\u0065\u002e\u0063\u006f\u006e\u0073\u0074\u0000" + "\u0008\u0000\u0000\u0000\u0003\u0000\u0004\u0000" + "\u0000\u0000\u0000\u0000\u0003\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0010\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0029\u0000\u0000\u0000\u002a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0024\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0030\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0001\u0000\u0000\u0000\u0004\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0011\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u002d\u0000\u0000\u0000\u0032\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0028\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0034\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0074\u0079\u0070\u0065\u0000\u0000\u0000\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0060\u00cc\u00f9\u00e1\u00ed\u0078\u0073\u00d0" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0076\u0061\u006c\u0075\u0065\u0000\u0000\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u009b\u000c\u00b0\u00d7\u00d2\u00dc\u0023\u00ce" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "")
    val b_ec1619d4400a0290: SegmentReader = org.capnproto.GeneratedClassSupport.decodeRawBytes("\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u0090\u0002\n\u0040\u00d4\u0019\u0016\u00ec" + "\u0012\u0000\u0000\u0000\u0001\u0000\u0005\u0000" + "\u0017\u00a4\u0023\u00f9\u004c\u00ab\u0082\u00e6" + "\u0006\u0000\u0007\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u00ea\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0019\u0000\u0000\u0000\u00df\u0002\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0063\u0068\u0065\u006d\u0061\u002e\u0063" + "\u0061\u0070\u006e\u0070\u003a\u004e\u006f\u0064" + "\u0065\u002e\u0061\u006e\u006e\u006f\u0074\u0061" + "\u0074\u0069\u006f\u006e\u0000\u0000\u0000\u0000" + "\u0034\u0000\u0000\u0000\u0003\u0000\u0004\u0000" + "\u0000\u0000\u0000\u0000\u0003\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0012\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u005d\u0001\u0000\u0000\u002a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0058\u0001\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0064\u0001\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0001\u0000\u0000\u0000\u0070\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0013\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0061\u0001\u0000\u0000\u0062\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0060\u0001\u0000\u0000\u0003\u0000\u0001\u0000" + "\u006c\u0001\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0002\u0000\u0000\u0000\u0071\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0014\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0069\u0001\u0000\u0000\u006a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0068\u0001\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0074\u0001\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0003\u0000\u0000\u0000\u0072\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0015\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0071\u0001\u0000\u0000\u0062\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0070\u0001\u0000\u0000\u0003\u0000\u0001\u0000" + "\u007c\u0001\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0004\u0000\u0000\u0000\u0073\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0016\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0079\u0001\u0000\u0000\u008a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u007c\u0001\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0088\u0001\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0005\u0000\u0000\u0000\u0074\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0017\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0085\u0001\u0000\u0000\u0072\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0084\u0001\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0090\u0001\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0006\u0000\u0000\u0000\u0075\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0018\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u008d\u0001\u0000\u0000\u006a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u008c\u0001\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0098\u0001\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0007\u0000\u0000\u0000\u0076\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0019\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0095\u0001\u0000\u0000\u006a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0094\u0001\u0000\u0000\u0003\u0000\u0001\u0000" + "\u00a0\u0001\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0008\u0000\u0000\u0000\u0077\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u001a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u009d\u0001\u0000\u0000\u006a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u009c\u0001\u0000\u0000\u0003\u0000\u0001\u0000" + "\u00a8\u0001\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0009\u0000\u0000\u0000\u0078\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u001b\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00a5\u0001\u0000\u0000\u008a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00a8\u0001\u0000\u0000\u0003\u0000\u0001\u0000" + "\u00b4\u0001\u0000\u0000\u0002\u0000\u0001\u0000" + "\n\u0000\u0000\u0000\u0079\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u001c\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00b1\u0001\u0000\u0000\u0072\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00b0\u0001\u0000\u0000\u0003\u0000\u0001\u0000" + "\u00bc\u0001\u0000\u0000\u0002\u0000\u0001\u0000" + "\u000b\u0000\u0000\u0000\u007a\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u001d\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00b9\u0001\u0000\u0000\u006a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00b8\u0001\u0000\u0000\u0003\u0000\u0001\u0000" + "\u00c4\u0001\u0000\u0000\u0002\u0000\u0001\u0000" + "\u000c\u0000\u0000\u0000\u007b\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u001e\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00c1\u0001\u0000\u0000\u0092\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00c4\u0001\u0000\u0000\u0003\u0000\u0001\u0000" + "\u00d0\u0001\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0074\u0079\u0070\u0065\u0000\u0000\u0000\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0060\u00cc\u00f9\u00e1\u00ed\u0078\u0073\u00d0" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0074\u0061\u0072\u0067\u0065\u0074\u0073\u0046" + "\u0069\u006c\u0065\u0000\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0074\u0061\u0072\u0067\u0065\u0074\u0073\u0043" + "\u006f\u006e\u0073\u0074\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0074\u0061\u0072\u0067\u0065\u0074\u0073\u0045" + "\u006e\u0075\u006d\u0000\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0074\u0061\u0072\u0067\u0065\u0074\u0073\u0045" + "\u006e\u0075\u006d\u0065\u0072\u0061\u006e\u0074" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0074\u0061\u0072\u0067\u0065\u0074\u0073\u0053" + "\u0074\u0072\u0075\u0063\u0074\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0074\u0061\u0072\u0067\u0065\u0074\u0073\u0046" + "\u0069\u0065\u006c\u0064\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0074\u0061\u0072\u0067\u0065\u0074\u0073\u0055" + "\u006e\u0069\u006f\u006e\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0074\u0061\u0072\u0067\u0065\u0074\u0073\u0047" + "\u0072\u006f\u0075\u0070\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0074\u0061\u0072\u0067\u0065\u0074\u0073\u0049" + "\u006e\u0074\u0065\u0072\u0066\u0061\u0063\u0065" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0074\u0061\u0072\u0067\u0065\u0074\u0073\u004d" + "\u0065\u0074\u0068\u006f\u0064\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0074\u0061\u0072\u0067\u0065\u0074\u0073\u0050" + "\u0061\u0072\u0061\u006d\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0074\u0061\u0072\u0067\u0065\u0074\u0073\u0041" + "\u006e\u006e\u006f\u0074\u0061\u0074\u0069\u006f" + "\u006e\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "")
    val b_9aad50a41f4af45f: SegmentReader = org.capnproto.GeneratedClassSupport.decodeRawBytes("\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u005f\u00f4\u004a\u001f\u00a4\u0050\u00ad\u009a" + "\r\u0000\u0000\u0000\u0001\u0000\u0003\u0000" + "\u00d9\u0072\u004c\u0062\u0009\u00c5\u003f\u00a9" + "\u0004\u0000\u0007\u0000\u0000\u0000\u0002\u0000" + "\u0004\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u009a\u0000\u0000\u0000" + "\u001d\u0000\u0000\u0000\u0017\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0029\u0000\u0000\u0000\u008f\u0001\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0063\u0068\u0065\u006d\u0061\u002e\u0063" + "\u0061\u0070\u006e\u0070\u003a\u0046\u0069\u0065" + "\u006c\u0064\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0004\u0000\u0000\u0000\u0001\u0000\u0001\u0000" + "\u0012\u00c7\u00fe\u007c\u00be\u004c\u00b1\u0097" + "\u0001\u0000\u0000\u0000\u007a\u0000\u0000\u0000" + "\u006e\u006f\u0044\u0069\u0073\u0063\u0072\u0069" + "\u006d\u0069\u006e\u0061\u006e\u0074\u0000\u0000" + "\u001c\u0000\u0000\u0000\u0003\u0000\u0004\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00b5\u0000\u0000\u0000\u002a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00b0\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u00bc\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00b9\u0000\u0000\u0000\u0052\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00b8\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u00c4\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0002\u0000\u0000\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0002\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00c1\u0000\u0000\u0000\u0062\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00c0\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u00dc\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0003\u0000\u0000\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0003\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00d9\u0000\u0000\u0000\u0092\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00dc\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u00e8\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0004\u0000\u00ff\u00ff\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u006f\u0074\u00b4\u006b\u0047\u0005\u0023\u00c4" + "\u00e5\u0000\u0000\u0000\u002a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0005\u0000\u00fe\u00ff\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0011\u001d\u00db\u0068\u00db\u00cd\u00fc\u00ca" + "\u00cd\u0000\u0000\u0000\u0032\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0006\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00e6\u000b\u0087\u0087\u00c2\u00d5\u0090\u00bb" + "\u00b5\u0000\u0000\u0000\u0042\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u006e\u0061\u006d\u0065\u0000\u0000\u0000\u0000" + "\u000c\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000c\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0063\u006f\u0064\u0065\u004f\u0072\u0064\u0065" + "\u0072\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0007\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0007\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0061\u006e\u006e\u006f\u0074\u0061\u0074\u0069" + "\u006f\u006e\u0073\u0000\u0000\u0000\u0000\u0000" + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0042\u0075\u0025\u00ab\r\u0095\u00c8\u00f1" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0064\u0069\u0073\u0063\u0072\u0069\u006d\u0069" + "\u006e\u0061\u006e\u0074\u0056\u0061\u006c\u0075" + "\u0065\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0007\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0007\u0000\u00ff\u00ff\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u006c\u006f\u0074\u0000\u0000\u0000\u0000" + "\u0067\u0072\u006f\u0075\u0070\u0000\u0000\u0000" + "\u006f\u0072\u0064\u0069\u006e\u0061\u006c\u0000" + "")
    val b_97b14cbe7cfec712: SegmentReader = org.capnproto.GeneratedClassSupport.decodeRawBytes("\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u0012\u00c7\u00fe\u007c\u00be\u004c\u00b1\u0097" + "\u0013\u0000\u0000\u0000\u0004\u0000\u0000\u0000" + "\u005f\u00f4\u004a\u001f\u00a4\u0050\u00ad\u009a" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u0012\u0001\u0000\u0000" + "\u0025\u0000\u0000\u0000\u0007\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0020\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u002c\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0063\u0068\u0065\u006d\u0061\u002e\u0063" + "\u0061\u0070\u006e\u0070\u003a\u0046\u0069\u0065" + "\u006c\u0064\u002e\u006e\u006f\u0044\u0069\u0073" + "\u0063\u0072\u0069\u006d\u0069\u006e\u0061\u006e" + "\u0074\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0001\u0000\u0001\u0000" + "\u0007\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0007\u0000\u00ff\u00ff\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "")
    val b_c42305476bb4746f: SegmentReader = org.capnproto.GeneratedClassSupport.decodeRawBytes("\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u006f\u0074\u00b4\u006b\u0047\u0005\u0023\u00c4" + "\u0013\u0000\u0000\u0000\u0001\u0000\u0003\u0000" + "\u005f\u00f4\u004a\u001f\u00a4\u0050\u00ad\u009a" + "\u0004\u0000\u0007\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u00c2\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u00e7\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0063\u0068\u0065\u006d\u0061\u002e\u0063" + "\u0061\u0070\u006e\u0070\u003a\u0046\u0069\u0065" + "\u006c\u0064\u002e\u0073\u006c\u006f\u0074\u0000" + "\u0010\u0000\u0000\u0000\u0003\u0000\u0004\u0000" + "\u0000\u0000\u0000\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0004\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0061\u0000\u0000\u0000\u003a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\\\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0068\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0001\u0000\u0000\u0000\u0002\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0005\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0065\u0000\u0000\u0000\u002a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0060\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u006c\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0002\u0000\u0000\u0000\u0003\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0006\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0069\u0000\u0000\u0000\u006a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0068\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0074\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0003\u0000\u0000\u0000\u0080\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\n\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0071\u0000\u0000\u0000\u009a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0074\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0080\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u006f\u0066\u0066\u0073\u0065\u0074\u0000\u0000" + "\u0008\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0008\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0074\u0079\u0070\u0065\u0000\u0000\u0000\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0060\u00cc\u00f9\u00e1\u00ed\u0078\u0073\u00d0" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0064\u0065\u0066\u0061\u0075\u006c\u0074\u0056" + "\u0061\u006c\u0075\u0065\u0000\u0000\u0000\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u009b\u000c\u00b0\u00d7\u00d2\u00dc\u0023\u00ce" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0068\u0061\u0064\u0045\u0078\u0070\u006c\u0069" + "\u0063\u0069\u0074\u0044\u0065\u0066\u0061\u0075" + "\u006c\u0074\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "")
    val b_cafccddb68db1d11: SegmentReader = org.capnproto.GeneratedClassSupport.decodeRawBytes("\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u0011\u001d\u00db\u0068\u00db\u00cd\u00fc\u00ca" + "\u0013\u0000\u0000\u0000\u0001\u0000\u0003\u0000" + "\u005f\u00f4\u004a\u001f\u00a4\u0050\u00ad\u009a" + "\u0004\u0000\u0007\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u00ca\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0019\u0000\u0000\u0000\u003f\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0063\u0068\u0065\u006d\u0061\u002e\u0063" + "\u0061\u0070\u006e\u0070\u003a\u0046\u0069\u0065" + "\u006c\u0064\u002e\u0067\u0072\u006f\u0075\u0070" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0004\u0000\u0000\u0000\u0003\u0000\u0004\u0000" + "\u0000\u0000\u0000\u0000\u0002\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0007\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\r\u0000\u0000\u0000\u003a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0008\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0014\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0074\u0079\u0070\u0065\u0049\u0064\u0000\u0000" + "\u0009\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0009\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "")
    val b_bb90d5c287870be6: SegmentReader = org.capnproto.GeneratedClassSupport.decodeRawBytes("\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u00e6\u000b\u0087\u0087\u00c2\u00d5\u0090\u00bb" + "\u0013\u0000\u0000\u0000\u0001\u0000\u0003\u0000" + "\u005f\u00f4\u004a\u001f\u00a4\u0050\u00ad\u009a" + "\u0004\u0000\u0007\u0000\u0001\u0000\u0002\u0000" + "\u0005\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u00da\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0019\u0000\u0000\u0000\u0077\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0063\u0068\u0065\u006d\u0061\u002e\u0063" + "\u0061\u0070\u006e\u0070\u003a\u0046\u0069\u0065" + "\u006c\u0064\u002e\u006f\u0072\u0064\u0069\u006e" + "\u0061\u006c\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0008\u0000\u0000\u0000\u0003\u0000\u0004\u0000" + "\u0000\u0000\u00ff\u00ff\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0008\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0029\u0000\u0000\u0000\u004a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0028\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0034\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0001\u0000\u00fe\u00ff\u0006\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0009\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0031\u0000\u0000\u0000\u004a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0030\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u003c\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0069\u006d\u0070\u006c\u0069\u0063\u0069\u0074" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0065\u0078\u0070\u006c\u0069\u0063\u0069\u0074" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0007\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0007\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "")
    val b_978a7cebdc549a4d: SegmentReader = org.capnproto.GeneratedClassSupport.decodeRawBytes("\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u004d\u009a\u0054\u00dc\u00eb\u007c\u008a\u0097" + "\r\u0000\u0000\u0000\u0001\u0000\u0001\u0000" + "\u00d9\u0072\u004c\u0062\u0009\u00c5\u003f\u00a9" + "\u0002\u0000\u0007\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u00ba\u0000\u0000\u0000" + "\u001d\u0000\u0000\u0000\u0007\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0019\u0000\u0000\u0000\u00af\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0063\u0068\u0065\u006d\u0061\u002e\u0063" + "\u0061\u0070\u006e\u0070\u003a\u0045\u006e\u0075" + "\u006d\u0065\u0072\u0061\u006e\u0074\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0001\u0000\u0001\u0000" + "\u000c\u0000\u0000\u0000\u0003\u0000\u0004\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0045\u0000\u0000\u0000\u002a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0040\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u004c\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0049\u0000\u0000\u0000\u0052\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0048\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0054\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0002\u0000\u0000\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0002\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0051\u0000\u0000\u0000\u0062\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0050\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u006c\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u006e\u0061\u006d\u0065\u0000\u0000\u0000\u0000" + "\u000c\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000c\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0063\u006f\u0064\u0065\u004f\u0072\u0064\u0065" + "\u0072\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0007\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0007\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0061\u006e\u006e\u006f\u0074\u0061\u0074\u0069" + "\u006f\u006e\u0073\u0000\u0000\u0000\u0000\u0000" + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0042\u0075\u0025\u00ab\r\u0095\u00c8\u00f1" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "")
    val b_a9962a9ed0a4d7f8: SegmentReader = org.capnproto.GeneratedClassSupport.decodeRawBytes("\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u00f8\u00d7\u00a4\u00d0\u009e\u002a\u0096\u00a9" + "\r\u0000\u0000\u0000\u0001\u0000\u0001\u0000" + "\u00d9\u0072\u004c\u0062\u0009\u00c5\u003f\u00a9" + "\u0001\u0000\u0007\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u00c2\u0000\u0000\u0000" + "\u001d\u0000\u0000\u0000\u0007\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0019\u0000\u0000\u0000\u0077\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0063\u0068\u0065\u006d\u0061\u002e\u0063" + "\u0061\u0070\u006e\u0070\u003a\u0053\u0075\u0070" + "\u0065\u0072\u0063\u006c\u0061\u0073\u0073\u0000" + "\u0000\u0000\u0000\u0000\u0001\u0000\u0001\u0000" + "\u0008\u0000\u0000\u0000\u0003\u0000\u0004\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0029\u0000\u0000\u0000\u001a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0024\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0030\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u002d\u0000\u0000\u0000\u0032\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0028\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0034\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0069\u0064\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0009\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0009\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0062\u0072\u0061\u006e\u0064\u0000\u0000\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u002b\u0042\u0065\u0060\u00f0\u0055\u0034\u0090" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "")
    val b_9500cce23b334d80: SegmentReader = org.capnproto.GeneratedClassSupport.decodeRawBytes("\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u0080\u004d\u0033\u003b\u00e2\u00cc\u0000\u0095" + "\r\u0000\u0000\u0000\u0001\u0000\u0003\u0000" + "\u00d9\u0072\u004c\u0062\u0009\u00c5\u003f\u00a9" + "\u0005\u0000\u0007\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u00a2\u0000\u0000\u0000" + "\u001d\u0000\u0000\u0000\u0007\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0019\u0000\u0000\u0000\u00c7\u0001\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0063\u0068\u0065\u006d\u0061\u002e\u0063" + "\u0061\u0070\u006e\u0070\u003a\u004d\u0065\u0074" + "\u0068\u006f\u0064\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0001\u0000\u0001\u0000" + "\u0020\u0000\u0000\u0000\u0003\u0000\u0004\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00d1\u0000\u0000\u0000\u002a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00cc\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u00d8\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00d5\u0000\u0000\u0000\u0052\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00d4\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u00e0\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0003\u0000\u0000\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0002\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00dd\u0000\u0000\u0000\u0082\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00dc\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u00e8\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0005\u0000\u0000\u0000\u0002\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0003\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00e5\u0000\u0000\u0000\u008a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00e8\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u00f4\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0007\u0000\u0000\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0004\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00f1\u0000\u0000\u0000\u0062\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00f0\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u000c\u0001\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0004\u0000\u0000\u0000\u0002\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0005\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0009\u0001\u0000\u0000\u005a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0008\u0001\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0014\u0001\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0006\u0000\u0000\u0000\u0003\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0006\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0011\u0001\u0000\u0000\u0062\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0010\u0001\u0000\u0000\u0003\u0000\u0001\u0000" + "\u001c\u0001\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0002\u0000\u0000\u0000\u0004\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0007\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0019\u0001\u0000\u0000\u009a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u001c\u0001\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0038\u0001\u0000\u0000\u0002\u0000\u0001\u0000" + "\u006e\u0061\u006d\u0065\u0000\u0000\u0000\u0000" + "\u000c\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000c\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0063\u006f\u0064\u0065\u004f\u0072\u0064\u0065" + "\u0072\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0007\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0007\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0070\u0061\u0072\u0061\u006d\u0053\u0074\u0072" + "\u0075\u0063\u0074\u0054\u0079\u0070\u0065\u0000" + "\u0009\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0009\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0072\u0065\u0073\u0075\u006c\u0074\u0053\u0074" + "\u0072\u0075\u0063\u0074\u0054\u0079\u0070\u0065" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0009\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0009\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0061\u006e\u006e\u006f\u0074\u0061\u0074\u0069" + "\u006f\u006e\u0073\u0000\u0000\u0000\u0000\u0000" + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0042\u0075\u0025\u00ab\r\u0095\u00c8\u00f1" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0070\u0061\u0072\u0061\u006d\u0042\u0072\u0061" + "\u006e\u0064\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u002b\u0042\u0065\u0060\u00f0\u0055\u0034\u0090" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0072\u0065\u0073\u0075\u006c\u0074\u0042\u0072" + "\u0061\u006e\u0064\u0000\u0000\u0000\u0000\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u002b\u0042\u0065\u0060\u00f0\u0055\u0034\u0090" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0069\u006d\u0070\u006c\u0069\u0063\u0069\u0074" + "\u0050\u0061\u0072\u0061\u006d\u0065\u0074\u0065" + "\u0072\u0073\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00b1\u00a3\u000f\u00f1\u00cc\u001b\u0052\u00b9" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "")
    val b_d07378ede1f9cc60: SegmentReader = org.capnproto.GeneratedClassSupport.decodeRawBytes("\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u0060\u00cc\u00f9\u00e1\u00ed\u0078\u0073\u00d0" + "\r\u0000\u0000\u0000\u0001\u0000\u0002\u0000" + "\u00d9\u0072\u004c\u0062\u0009\u00c5\u003f\u00a9" + "\u0001\u0000\u0007\u0000\u0000\u0000\u0013\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u0092\u0000\u0000\u0000" + "\u001d\u0000\u0000\u0000\u0007\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0019\u0000\u0000\u0000\u002f\u0004\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0063\u0068\u0065\u006d\u0061\u002e\u0063" + "\u0061\u0070\u006e\u0070\u003a\u0054\u0079\u0070" + "\u0065\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0001\u0000\u0001\u0000" + "\u004c\u0000\u0000\u0000\u0003\u0000\u0004\u0000" + "\u0000\u0000\u00ff\u00ff\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0005\u0002\u0000\u0000\u002a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0002\u0000\u0000\u0003\u0000\u0001\u0000" + "\u000c\u0002\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0001\u0000\u00fe\u00ff\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0009\u0002\u0000\u0000\u002a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0004\u0002\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0010\u0002\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0002\u0000\u00fd\u00ff\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0002\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\r\u0002\u0000\u0000\u002a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0008\u0002\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0014\u0002\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0003\u0000\u00fc\u00ff\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0003\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0011\u0002\u0000\u0000\u0032\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000c\u0002\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0018\u0002\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0004\u0000\u00fb\u00ff\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0004\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0002\u0000\u0000\u0032\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0010\u0002\u0000\u0000\u0003\u0000\u0001\u0000" + "\u001c\u0002\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0005\u0000\u00fa\u00ff\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0005\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0019\u0002\u0000\u0000\u0032\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0014\u0002\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0020\u0002\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0006\u0000\u00f9\u00ff\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0006\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u001d\u0002\u0000\u0000\u0032\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0018\u0002\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0024\u0002\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0007\u0000\u00f8\u00ff\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0007\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0021\u0002\u0000\u0000\u003a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u001c\u0002\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0028\u0002\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0008\u0000\u00f7\u00ff\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0008\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0025\u0002\u0000\u0000\u003a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0020\u0002\u0000\u0000\u0003\u0000\u0001\u0000" + "\u002c\u0002\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0009\u0000\u00f6\u00ff\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0009\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0029\u0002\u0000\u0000\u003a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0024\u0002\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0030\u0002\u0000\u0000\u0002\u0000\u0001\u0000" + "\n\u0000\u00f5\u00ff\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\n\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u002d\u0002\u0000\u0000\u0042\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0028\u0002\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0034\u0002\u0000\u0000\u0002\u0000\u0001\u0000" + "\u000b\u0000\u00f4\u00ff\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u000b\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0031\u0002\u0000\u0000\u0042\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u002c\u0002\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0038\u0002\u0000\u0000\u0002\u0000\u0001\u0000" + "\u000c\u0000\u00f3\u00ff\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u000c\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0035\u0002\u0000\u0000\u002a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0030\u0002\u0000\u0000\u0003\u0000\u0001\u0000" + "\u003c\u0002\u0000\u0000\u0002\u0000\u0001\u0000" + "\r\u0000\u00f2\u00ff\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\r\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0039\u0002\u0000\u0000\u002a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0034\u0002\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0040\u0002\u0000\u0000\u0002\u0000\u0001\u0000" + "\u000e\u0000\u00f1\u00ff\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0097\u00ea\u0060\n\u0025\u0039\u00e7\u0087" + "\u003d\u0002\u0000\u0000\u002a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000f\u0000\u00f0\u00ff\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00a9\u0087\u007f\u001a\u0071\u0078\u000e\u009e" + "\u0025\u0002\u0000\u0000\u002a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0010\u0000\u00ef\u00ff\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00d3\u00c6\u004c\u00ef\u0060\u006f\u003a\u00ac" + "\r\u0002\u0000\u0000\u003a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0011\u0000\u00ee\u00ff\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00bf\u000c\u00fb\u00f7\u0069\u00ca\u008b\u00ed" + "\u00f5\u0001\u0000\u0000\u0052\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0012\u0000\u00ed\u00ff\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00f1\u0049\u003e\u00a2\u00e8\u003f\u0057\u00c2" + "\u00e1\u0001\u0000\u0000\u005a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0076\u006f\u0069\u0064\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0062\u006f\u006f\u006c\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0069\u006e\u0074\u0038\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0069\u006e\u0074\u0031\u0036\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0069\u006e\u0074\u0033\u0032\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0069\u006e\u0074\u0036\u0034\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0075\u0069\u006e\u0074\u0038\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0075\u0069\u006e\u0074\u0031\u0036\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0075\u0069\u006e\u0074\u0033\u0032\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0075\u0069\u006e\u0074\u0036\u0034\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0066\u006c\u006f\u0061\u0074\u0033\u0032\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0066\u006c\u006f\u0061\u0074\u0036\u0034\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0074\u0065\u0078\u0074\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0064\u0061\u0074\u0061\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u006c\u0069\u0073\u0074\u0000\u0000\u0000\u0000" + "\u0065\u006e\u0075\u006d\u0000\u0000\u0000\u0000" + "\u0073\u0074\u0072\u0075\u0063\u0074\u0000\u0000" + "\u0069\u006e\u0074\u0065\u0072\u0066\u0061\u0063" + "\u0065\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0061\u006e\u0079\u0050\u006f\u0069\u006e\u0074" + "\u0065\u0072\u0000\u0000\u0000\u0000\u0000\u0000" + "")
    val b_87e739250a60ea97: SegmentReader = org.capnproto.GeneratedClassSupport.decodeRawBytes("\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u0097\u00ea\u0060\n\u0025\u0039\u00e7\u0087" + "\u0012\u0000\u0000\u0000\u0001\u0000\u0002\u0000" + "\u0060\u00cc\u00f9\u00e1\u00ed\u0078\u0073\u00d0" + "\u0001\u0000\u0007\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u00ba\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u003f\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0063\u0068\u0065\u006d\u0061\u002e\u0063" + "\u0061\u0070\u006e\u0070\u003a\u0054\u0079\u0070" + "\u0065\u002e\u006c\u0069\u0073\u0074\u0000\u0000" + "\u0004\u0000\u0000\u0000\u0003\u0000\u0004\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u000e\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\r\u0000\u0000\u0000\u0062\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000c\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0018\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0065\u006c\u0065\u006d\u0065\u006e\u0074\u0054" + "\u0079\u0070\u0065\u0000\u0000\u0000\u0000\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0060\u00cc\u00f9\u00e1\u00ed\u0078\u0073\u00d0" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "")
    val b_9e0e78711a7f87a9: SegmentReader = org.capnproto.GeneratedClassSupport.decodeRawBytes("\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u00a9\u0087\u007f\u001a\u0071\u0078\u000e\u009e" + "\u0012\u0000\u0000\u0000\u0001\u0000\u0002\u0000" + "\u0060\u00cc\u00f9\u00e1\u00ed\u0078\u0073\u00d0" + "\u0001\u0000\u0007\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u00ba\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u0077\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0063\u0068\u0065\u006d\u0061\u002e\u0063" + "\u0061\u0070\u006e\u0070\u003a\u0054\u0079\u0070" + "\u0065\u002e\u0065\u006e\u0075\u006d\u0000\u0000" + "\u0008\u0000\u0000\u0000\u0003\u0000\u0004\u0000" + "\u0000\u0000\u0000\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u000f\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0029\u0000\u0000\u0000\u003a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0024\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0030\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0015\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u002d\u0000\u0000\u0000\u0032\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0028\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0034\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0074\u0079\u0070\u0065\u0049\u0064\u0000\u0000" + "\u0009\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0009\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0062\u0072\u0061\u006e\u0064\u0000\u0000\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u002b\u0042\u0065\u0060\u00f0\u0055\u0034\u0090" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "")
    val b_ac3a6f60ef4cc6d3: SegmentReader = org.capnproto.GeneratedClassSupport.decodeRawBytes("\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u00d3\u00c6\u004c\u00ef\u0060\u006f\u003a\u00ac" + "\u0012\u0000\u0000\u0000\u0001\u0000\u0002\u0000" + "\u0060\u00cc\u00f9\u00e1\u00ed\u0078\u0073\u00d0" + "\u0001\u0000\u0007\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u00ca\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0019\u0000\u0000\u0000\u0077\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0063\u0068\u0065\u006d\u0061\u002e\u0063" + "\u0061\u0070\u006e\u0070\u003a\u0054\u0079\u0070" + "\u0065\u002e\u0073\u0074\u0072\u0075\u0063\u0074" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0008\u0000\u0000\u0000\u0003\u0000\u0004\u0000" + "\u0000\u0000\u0000\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0010\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0029\u0000\u0000\u0000\u003a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0024\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0030\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0016\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u002d\u0000\u0000\u0000\u0032\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0028\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0034\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0074\u0079\u0070\u0065\u0049\u0064\u0000\u0000" + "\u0009\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0009\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0062\u0072\u0061\u006e\u0064\u0000\u0000\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u002b\u0042\u0065\u0060\u00f0\u0055\u0034\u0090" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "")
    val b_ed8bca69f7fb0cbf: SegmentReader = org.capnproto.GeneratedClassSupport.decodeRawBytes("\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u00bf\u000c\u00fb\u00f7\u0069\u00ca\u008b\u00ed" + "\u0012\u0000\u0000\u0000\u0001\u0000\u0002\u0000" + "\u0060\u00cc\u00f9\u00e1\u00ed\u0078\u0073\u00d0" + "\u0001\u0000\u0007\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u00e2\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0019\u0000\u0000\u0000\u0077\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0063\u0068\u0065\u006d\u0061\u002e\u0063" + "\u0061\u0070\u006e\u0070\u003a\u0054\u0079\u0070" + "\u0065\u002e\u0069\u006e\u0074\u0065\u0072\u0066" + "\u0061\u0063\u0065\u0000\u0000\u0000\u0000\u0000" + "\u0008\u0000\u0000\u0000\u0003\u0000\u0004\u0000" + "\u0000\u0000\u0000\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0011\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0029\u0000\u0000\u0000\u003a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0024\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0030\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0017\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u002d\u0000\u0000\u0000\u0032\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0028\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0034\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0074\u0079\u0070\u0065\u0049\u0064\u0000\u0000" + "\u0009\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0009\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0062\u0072\u0061\u006e\u0064\u0000\u0000\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u002b\u0042\u0065\u0060\u00f0\u0055\u0034\u0090" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "")
    val b_c2573fe8a23e49f1: SegmentReader = org.capnproto.GeneratedClassSupport.decodeRawBytes("\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u00f1\u0049\u003e\u00a2\u00e8\u003f\u0057\u00c2" + "\u0012\u0000\u0000\u0000\u0001\u0000\u0002\u0000" + "\u0060\u00cc\u00f9\u00e1\u00ed\u0078\u0073\u00d0" + "\u0001\u0000\u0007\u0000\u0001\u0000\u0003\u0000" + "\u0002\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u00ea\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0019\u0000\u0000\u0000\u00af\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0063\u0068\u0065\u006d\u0061\u002e\u0063" + "\u0061\u0070\u006e\u0070\u003a\u0054\u0079\u0070" + "\u0065\u002e\u0061\u006e\u0079\u0050\u006f\u0069" + "\u006e\u0074\u0065\u0072\u0000\u0000\u0000\u0000" + "\u000c\u0000\u0000\u0000\u0003\u0000\u0004\u0000" + "\u0000\u0000\u00ff\u00ff\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0056\u0036\u0059\u00fe\u0079\u005f\u003b\u008e" + "\u0045\u0000\u0000\u0000\u0072\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0001\u0000\u00fe\u00ff\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0085\u004a\u0061\u00f4\u0024\u00f7\u00d1\u009d" + "\u0031\u0000\u0000\u0000\u0052\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0002\u0000\u00fd\u00ff\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0074\u00e2\u0056\u000c\u0012\u00c9\u00ef\u00ba" + "\u001d\u0000\u0000\u0000\u00c2\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0075\u006e\u0063\u006f\u006e\u0073\u0074\u0072" + "\u0061\u0069\u006e\u0065\u0064\u0000\u0000\u0000" + "\u0070\u0061\u0072\u0061\u006d\u0065\u0074\u0065" + "\u0072\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0069\u006d\u0070\u006c\u0069\u0063\u0069\u0074" + "\u004d\u0065\u0074\u0068\u006f\u0064\u0050\u0061" + "\u0072\u0061\u006d\u0065\u0074\u0065\u0072\u0000" + "")
    val b_8e3b5f79fe593656: SegmentReader = org.capnproto.GeneratedClassSupport.decodeRawBytes("\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u0056\u0036\u0059\u00fe\u0079\u005f\u003b\u008e" + "\u001d\u0000\u0000\u0000\u0001\u0000\u0002\u0000" + "\u00f1\u0049\u003e\u00a2\u00e8\u003f\u0057\u00c2" + "\u0001\u0000\u0007\u0000\u0001\u0000\u0004\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u005a\u0001\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0021\u0000\u0000\u0000\u00e7\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0063\u0068\u0065\u006d\u0061\u002e\u0063" + "\u0061\u0070\u006e\u0070\u003a\u0054\u0079\u0070" + "\u0065\u002e\u0061\u006e\u0079\u0050\u006f\u0069" + "\u006e\u0074\u0065\u0072\u002e\u0075\u006e\u0063" + "\u006f\u006e\u0073\u0074\u0072\u0061\u0069\u006e" + "\u0065\u0064\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0010\u0000\u0000\u0000\u0003\u0000\u0004\u0000" + "\u0000\u0000\u00ff\u00ff\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0012\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0061\u0000\u0000\u0000\u0042\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\\\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0068\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0001\u0000\u00fe\u00ff\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0019\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0065\u0000\u0000\u0000\u003a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0060\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u006c\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0002\u0000\u00fd\u00ff\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u001a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0069\u0000\u0000\u0000\u002a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0064\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0070\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0003\u0000\u00fc\u00ff\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u001b\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u006d\u0000\u0000\u0000\u005a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u006c\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0078\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0061\u006e\u0079\u004b\u0069\u006e\u0064\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0074\u0072\u0075\u0063\u0074\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u006c\u0069\u0073\u0074\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0063\u0061\u0070\u0061\u0062\u0069\u006c\u0069" + "\u0074\u0079\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "")
    val b_9dd1f724f4614a85: SegmentReader = org.capnproto.GeneratedClassSupport.decodeRawBytes("\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u0085\u004a\u0061\u00f4\u0024\u00f7\u00d1\u009d" + "\u001d\u0000\u0000\u0000\u0001\u0000\u0002\u0000" + "\u00f1\u0049\u003e\u00a2\u00e8\u003f\u0057\u00c2" + "\u0001\u0000\u0007\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u003a\u0001\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u001d\u0000\u0000\u0000\u0077\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0063\u0068\u0065\u006d\u0061\u002e\u0063" + "\u0061\u0070\u006e\u0070\u003a\u0054\u0079\u0070" + "\u0065\u002e\u0061\u006e\u0079\u0050\u006f\u0069" + "\u006e\u0074\u0065\u0072\u002e\u0070\u0061\u0072" + "\u0061\u006d\u0065\u0074\u0065\u0072\u0000\u0000" + "\u0008\u0000\u0000\u0000\u0003\u0000\u0004\u0000" + "\u0000\u0000\u0000\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0013\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0029\u0000\u0000\u0000\u0042\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0024\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0030\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0001\u0000\u0000\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0014\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u002d\u0000\u0000\u0000\u007a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u002c\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0038\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0073\u0063\u006f\u0070\u0065\u0049\u0064\u0000" + "\u0009\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0009\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0070\u0061\u0072\u0061\u006d\u0065\u0074\u0065" + "\u0072\u0049\u006e\u0064\u0065\u0078\u0000\u0000" + "\u0007\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0007\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "")
    val b_baefc9120c56e274: SegmentReader = org.capnproto.GeneratedClassSupport.decodeRawBytes("\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u0074\u00e2\u0056\u000c\u0012\u00c9\u00ef\u00ba" + "\u001d\u0000\u0000\u0000\u0001\u0000\u0002\u0000" + "\u00f1\u0049\u003e\u00a2\u00e8\u003f\u0057\u00c2" + "\u0001\u0000\u0007\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u00aa\u0001\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0025\u0000\u0000\u0000\u003f\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0063\u0068\u0065\u006d\u0061\u002e\u0063" + "\u0061\u0070\u006e\u0070\u003a\u0054\u0079\u0070" + "\u0065\u002e\u0061\u006e\u0079\u0050\u006f\u0069" + "\u006e\u0074\u0065\u0072\u002e\u0069\u006d\u0070" + "\u006c\u0069\u0063\u0069\u0074\u004d\u0065\u0074" + "\u0068\u006f\u0064\u0050\u0061\u0072\u0061\u006d" + "\u0065\u0074\u0065\u0072\u0000\u0000\u0000\u0000" + "\u0004\u0000\u0000\u0000\u0003\u0000\u0004\u0000" + "\u0000\u0000\u0000\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0018\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\r\u0000\u0000\u0000\u007a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000c\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0018\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0070\u0061\u0072\u0061\u006d\u0065\u0074\u0065" + "\u0072\u0049\u006e\u0064\u0065\u0078\u0000\u0000" + "\u0007\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0007\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "")
    val b_903455f06065422b: SegmentReader = org.capnproto.GeneratedClassSupport.decodeRawBytes("\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u002b\u0042\u0065\u0060\u00f0\u0055\u0034\u0090" + "\r\u0000\u0000\u0000\u0001\u0000\u0000\u0000" + "\u00d9\u0072\u004c\u0062\u0009\u00c5\u003f\u00a9" + "\u0001\u0000\u0007\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u009a\u0000\u0000\u0000" + "\u001d\u0000\u0000\u0000\u0027\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0031\u0000\u0000\u0000\u003f\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0063\u0068\u0065\u006d\u0061\u002e\u0063" + "\u0061\u0070\u006e\u0070\u003a\u0042\u0072\u0061" + "\u006e\u0064\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0008\u0000\u0000\u0000\u0001\u0000\u0001\u0000" + "\u00c9\u006b\u0063\u00a9\u0085\u0034\u00d7\u00ab" + "\u0009\u0000\u0000\u0000\u0032\u0000\u0000\u0000" + "\u00fc\u00e7\u009e\u0096\u0016\u00cd\u0063\u00c8" + "\u0005\u0000\u0000\u0000\u0042\u0000\u0000\u0000" + "\u0053\u0063\u006f\u0070\u0065\u0000\u0000\u0000" + "\u0042\u0069\u006e\u0064\u0069\u006e\u0067\u0000" + "\u0004\u0000\u0000\u0000\u0003\u0000\u0004\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\r\u0000\u0000\u0000\u003a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0008\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0024\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0073\u0063\u006f\u0070\u0065\u0073\u0000\u0000" + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00c9\u006b\u0063\u00a9\u0085\u0034\u00d7\u00ab" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "")
    val b_abd73485a9636bc9: SegmentReader = org.capnproto.GeneratedClassSupport.decodeRawBytes("\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u00c9\u006b\u0063\u00a9\u0085\u0034\u00d7\u00ab" + "\u0013\u0000\u0000\u0000\u0001\u0000\u0002\u0000" + "\u002b\u0042\u0065\u0060\u00f0\u0055\u0034\u0090" + "\u0001\u0000\u0007\u0000\u0000\u0000\u0002\u0000" + "\u0004\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u00ca\u0000\u0000\u0000" + "\u0021\u0000\u0000\u0000\u0007\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u001d\u0000\u0000\u0000\u00af\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0063\u0068\u0065\u006d\u0061\u002e\u0063" + "\u0061\u0070\u006e\u0070\u003a\u0042\u0072\u0061" + "\u006e\u0064\u002e\u0053\u0063\u006f\u0070\u0065" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0001\u0000\u0001\u0000" + "\u000c\u0000\u0000\u0000\u0003\u0000\u0004\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0045\u0000\u0000\u0000\u0042\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0040\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u004c\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0001\u0000\u00ff\u00ff\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0049\u0000\u0000\u0000\u002a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0044\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0060\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0002\u0000\u00fe\u00ff\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0002\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u005d\u0000\u0000\u0000\u0042\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0058\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0064\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0073\u0063\u006f\u0070\u0065\u0049\u0064\u0000" + "\u0009\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0009\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0062\u0069\u006e\u0064\u0000\u0000\u0000\u0000" + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00fc\u00e7\u009e\u0096\u0016\u00cd\u0063\u00c8" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0069\u006e\u0068\u0065\u0072\u0069\u0074\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "")
    val b_c863cd16969ee7fc: SegmentReader = org.capnproto.GeneratedClassSupport.decodeRawBytes("\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u00fc\u00e7\u009e\u0096\u0016\u00cd\u0063\u00c8" + "\u0013\u0000\u0000\u0000\u0001\u0000\u0001\u0000" + "\u002b\u0042\u0065\u0060\u00f0\u0055\u0034\u0090" + "\u0001\u0000\u0007\u0000\u0000\u0000\u0002\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u00da\u0000\u0000\u0000" + "\u0021\u0000\u0000\u0000\u0007\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u001d\u0000\u0000\u0000\u0077\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0063\u0068\u0065\u006d\u0061\u002e\u0063" + "\u0061\u0070\u006e\u0070\u003a\u0042\u0072\u0061" + "\u006e\u0064\u002e\u0042\u0069\u006e\u0064\u0069" + "\u006e\u0067\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0001\u0000\u0001\u0000" + "\u0008\u0000\u0000\u0000\u0003\u0000\u0004\u0000" + "\u0000\u0000\u00ff\u00ff\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0029\u0000\u0000\u0000\u0042\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0024\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0030\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0001\u0000\u00fe\u00ff\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u002d\u0000\u0000\u0000\u002a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0028\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0034\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0075\u006e\u0062\u006f\u0075\u006e\u0064\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0074\u0079\u0070\u0065\u0000\u0000\u0000\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0060\u00cc\u00f9\u00e1\u00ed\u0078\u0073\u00d0" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "")
    val b_ce23dcd2d7b00c9b: SegmentReader = org.capnproto.GeneratedClassSupport.decodeRawBytes("\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u009b\u000c\u00b0\u00d7\u00d2\u00dc\u0023\u00ce" + "\r\u0000\u0000\u0000\u0001\u0000\u0002\u0000" + "\u00d9\u0072\u004c\u0062\u0009\u00c5\u003f\u00a9" + "\u0001\u0000\u0007\u0000\u0000\u0000\u0013\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u009a\u0000\u0000\u0000" + "\u001d\u0000\u0000\u0000\u0007\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0019\u0000\u0000\u0000\u002f\u0004\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0063\u0068\u0065\u006d\u0061\u002e\u0063" + "\u0061\u0070\u006e\u0070\u003a\u0056\u0061\u006c" + "\u0075\u0065\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0001\u0000\u0001\u0000" + "\u004c\u0000\u0000\u0000\u0003\u0000\u0004\u0000" + "\u0000\u0000\u00ff\u00ff\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0005\u0002\u0000\u0000\u002a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0002\u0000\u0000\u0003\u0000\u0001\u0000" + "\u000c\u0002\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0001\u0000\u00fe\u00ff\u0010\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0009\u0002\u0000\u0000\u002a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0004\u0002\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0010\u0002\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0002\u0000\u00fd\u00ff\u0002\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0002\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\r\u0002\u0000\u0000\u002a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0008\u0002\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0014\u0002\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0003\u0000\u00fc\u00ff\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0003\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0011\u0002\u0000\u0000\u0032\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000c\u0002\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0018\u0002\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0004\u0000\u00fb\u00ff\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0004\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0002\u0000\u0000\u0032\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0010\u0002\u0000\u0000\u0003\u0000\u0001\u0000" + "\u001c\u0002\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0005\u0000\u00fa\u00ff\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0005\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0019\u0002\u0000\u0000\u0032\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0014\u0002\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0020\u0002\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0006\u0000\u00f9\u00ff\u0002\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0006\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u001d\u0002\u0000\u0000\u0032\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0018\u0002\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0024\u0002\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0007\u0000\u00f8\u00ff\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0007\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0021\u0002\u0000\u0000\u003a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u001c\u0002\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0028\u0002\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0008\u0000\u00f7\u00ff\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0008\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0025\u0002\u0000\u0000\u003a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0020\u0002\u0000\u0000\u0003\u0000\u0001\u0000" + "\u002c\u0002\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0009\u0000\u00f6\u00ff\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0009\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0029\u0002\u0000\u0000\u003a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0024\u0002\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0030\u0002\u0000\u0000\u0002\u0000\u0001\u0000" + "\n\u0000\u00f5\u00ff\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\n\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u002d\u0002\u0000\u0000\u0042\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0028\u0002\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0034\u0002\u0000\u0000\u0002\u0000\u0001\u0000" + "\u000b\u0000\u00f4\u00ff\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u000b\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0031\u0002\u0000\u0000\u0042\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u002c\u0002\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0038\u0002\u0000\u0000\u0002\u0000\u0001\u0000" + "\u000c\u0000\u00f3\u00ff\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u000c\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0035\u0002\u0000\u0000\u002a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0030\u0002\u0000\u0000\u0003\u0000\u0001\u0000" + "\u003c\u0002\u0000\u0000\u0002\u0000\u0001\u0000" + "\r\u0000\u00f2\u00ff\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\r\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0039\u0002\u0000\u0000\u002a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0034\u0002\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0040\u0002\u0000\u0000\u0002\u0000\u0001\u0000" + "\u000e\u0000\u00f1\u00ff\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u000e\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u003d\u0002\u0000\u0000\u002a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0038\u0002\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0044\u0002\u0000\u0000\u0002\u0000\u0001\u0000" + "\u000f\u0000\u00f0\u00ff\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u000f\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0041\u0002\u0000\u0000\u002a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u003c\u0002\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0048\u0002\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0010\u0000\u00ef\u00ff\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0010\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0045\u0002\u0000\u0000\u003a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0040\u0002\u0000\u0000\u0003\u0000\u0001\u0000" + "\u004c\u0002\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0011\u0000\u00ee\u00ff\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0011\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0049\u0002\u0000\u0000\u0052\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0048\u0002\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0054\u0002\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0012\u0000\u00ed\u00ff\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0012\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0051\u0002\u0000\u0000\u005a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0050\u0002\u0000\u0000\u0003\u0000\u0001\u0000" + "\\\u0002\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0076\u006f\u0069\u0064\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0062\u006f\u006f\u006c\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0069\u006e\u0074\u0038\u0000\u0000\u0000\u0000" + "\u0002\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0002\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0069\u006e\u0074\u0031\u0036\u0000\u0000\u0000" + "\u0003\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0003\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0069\u006e\u0074\u0033\u0032\u0000\u0000\u0000" + "\u0004\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0004\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0069\u006e\u0074\u0036\u0034\u0000\u0000\u0000" + "\u0005\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0005\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0075\u0069\u006e\u0074\u0038\u0000\u0000\u0000" + "\u0006\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0006\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0075\u0069\u006e\u0074\u0031\u0036\u0000\u0000" + "\u0007\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0007\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0075\u0069\u006e\u0074\u0033\u0032\u0000\u0000" + "\u0008\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0008\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0075\u0069\u006e\u0074\u0036\u0034\u0000\u0000" + "\u0009\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0009\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0066\u006c\u006f\u0061\u0074\u0033\u0032\u0000" + "\n\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\n\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0066\u006c\u006f\u0061\u0074\u0036\u0034\u0000" + "\u000b\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000b\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0074\u0065\u0078\u0074\u0000\u0000\u0000\u0000" + "\u000c\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000c\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0064\u0061\u0074\u0061\u0000\u0000\u0000\u0000" + "\r\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\r\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u006c\u0069\u0073\u0074\u0000\u0000\u0000\u0000" + "\u0012\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0012\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0065\u006e\u0075\u006d\u0000\u0000\u0000\u0000" + "\u0007\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0007\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0074\u0072\u0075\u0063\u0074\u0000\u0000" + "\u0012\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0012\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0069\u006e\u0074\u0065\u0072\u0066\u0061\u0063" + "\u0065\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0061\u006e\u0079\u0050\u006f\u0069\u006e\u0074" + "\u0065\u0072\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0012\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0012\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "")
    val b_f1c8950dab257542: SegmentReader = org.capnproto.GeneratedClassSupport.decodeRawBytes("\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u0042\u0075\u0025\u00ab\r\u0095\u00c8\u00f1" + "\r\u0000\u0000\u0000\u0001\u0000\u0001\u0000" + "\u00d9\u0072\u004c\u0062\u0009\u00c5\u003f\u00a9" + "\u0002\u0000\u0007\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u00c2\u0000\u0000\u0000" + "\u001d\u0000\u0000\u0000\u0007\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0019\u0000\u0000\u0000\u00af\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0063\u0068\u0065\u006d\u0061\u002e\u0063" + "\u0061\u0070\u006e\u0070\u003a\u0041\u006e\u006e" + "\u006f\u0074\u0061\u0074\u0069\u006f\u006e\u0000" + "\u0000\u0000\u0000\u0000\u0001\u0000\u0001\u0000" + "\u000c\u0000\u0000\u0000\u0003\u0000\u0004\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0045\u0000\u0000\u0000\u001a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0040\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u004c\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0002\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0049\u0000\u0000\u0000\u0032\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0044\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0050\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0001\u0000\u0000\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0002\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u004d\u0000\u0000\u0000\u0032\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0048\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0054\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0069\u0064\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0009\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0009\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0076\u0061\u006c\u0075\u0065\u0000\u0000\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u009b\u000c\u00b0\u00d7\u00d2\u00dc\u0023\u00ce" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0062\u0072\u0061\u006e\u0064\u0000\u0000\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u002b\u0042\u0065\u0060\u00f0\u0055\u0034\u0090" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "")
    val b_d1958f7dba521926: SegmentReader = org.capnproto.GeneratedClassSupport.decodeRawBytes("\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u0026\u0019\u0052\u00ba\u007d\u008f\u0095\u00d1" + "\r\u0000\u0000\u0000\u0002\u0000\u0000\u0000" + "\u00d9\u0072\u004c\u0062\u0009\u00c5\u003f\u00a9" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u00ca\u0000\u0000\u0000" + "\u0021\u0000\u0000\u0000\u0007\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u001d\u0000\u0000\u0000\u00c7\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0063\u0068\u0065\u006d\u0061\u002e\u0063" + "\u0061\u0070\u006e\u0070\u003a\u0045\u006c\u0065" + "\u006d\u0065\u006e\u0074\u0053\u0069\u007a\u0065" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0001\u0000\u0001\u0000" + "\u0020\u0000\u0000\u0000\u0001\u0000\u0002\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0059\u0000\u0000\u0000\u0032\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0051\u0000\u0000\u0000\"\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0002\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0049\u0000\u0000\u0000\u002a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0003\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0041\u0000\u0000\u0000\u004a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0004\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u003d\u0000\u0000\u0000\u0052\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0005\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0039\u0000\u0000\u0000\u005a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0006\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0035\u0000\u0000\u0000\u0042\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0007\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u002d\u0000\u0000\u0000\u0082\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0065\u006d\u0070\u0074\u0079\u0000\u0000\u0000" + "\u0062\u0069\u0074\u0000\u0000\u0000\u0000\u0000" + "\u0062\u0079\u0074\u0065\u0000\u0000\u0000\u0000" + "\u0074\u0077\u006f\u0042\u0079\u0074\u0065\u0073" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0066\u006f\u0075\u0072\u0042\u0079\u0074\u0065" + "\u0073\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0065\u0069\u0067\u0068\u0074\u0042\u0079\u0074" + "\u0065\u0073\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0070\u006f\u0069\u006e\u0074\u0065\u0072\u0000" + "\u0069\u006e\u006c\u0069\u006e\u0065\u0043\u006f" + "\u006d\u0070\u006f\u0073\u0069\u0074\u0065\u0000" + "")
    val b_bfc546f6210ad7ce: SegmentReader = org.capnproto.GeneratedClassSupport.decodeRawBytes("\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u00ce\u00d7\n\u0021\u00f6\u0046\u00c5\u00bf" + "\r\u0000\u0000\u0000\u0001\u0000\u0000\u0000" + "\u00d9\u0072\u004c\u0062\u0009\u00c5\u003f\u00a9" + "\u0002\u0000\u0007\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u0012\u0001\u0000\u0000" + "\u0025\u0000\u0000\u0000\u0017\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0031\u0000\u0000\u0000\u0077\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0063\u0068\u0065\u006d\u0061\u002e\u0063" + "\u0061\u0070\u006e\u0070\u003a\u0043\u006f\u0064" + "\u0065\u0047\u0065\u006e\u0065\u0072\u0061\u0074" + "\u006f\u0072\u0052\u0065\u0071\u0075\u0065\u0073" + "\u0074\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0004\u0000\u0000\u0000\u0001\u0000\u0001\u0000" + "\u0062\u0000\u0081\u002e\u00b0\u000e\u00ea\u00cf" + "\u0001\u0000\u0000\u0000\u0072\u0000\u0000\u0000" + "\u0052\u0065\u0071\u0075\u0065\u0073\u0074\u0065" + "\u0064\u0046\u0069\u006c\u0065\u0000\u0000\u0000" + "\u0008\u0000\u0000\u0000\u0003\u0000\u0004\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0029\u0000\u0000\u0000\u0032\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0024\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0040\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0001\u0000\u0000\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u003d\u0000\u0000\u0000\u007a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u003c\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0058\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u006e\u006f\u0064\u0065\u0073\u0000\u0000\u0000" + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0017\u00a4\u0023\u00f9\u004c\u00ab\u0082\u00e6" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0072\u0065\u0071\u0075\u0065\u0073\u0074\u0065" + "\u0064\u0046\u0069\u006c\u0065\u0073\u0000\u0000" + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0062\u0000\u0081\u002e\u00b0\u000e\u00ea\u00cf" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "")
    val b_cfea0eb02e810062: SegmentReader = org.capnproto.GeneratedClassSupport.decodeRawBytes("\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u0062\u0000\u0081\u002e\u00b0\u000e\u00ea\u00cf" + "\"\u0000\u0000\u0000\u0001\u0000\u0001\u0000" + "\u00ce\u00d7\n\u0021\u00f6\u0046\u00c5\u00bf" + "\u0002\u0000\u0007\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u0082\u0001\u0000\u0000" + "\u0029\u0000\u0000\u0000\u0017\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0031\u0000\u0000\u0000\u00af\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0063\u0068\u0065\u006d\u0061\u002e\u0063" + "\u0061\u0070\u006e\u0070\u003a\u0043\u006f\u0064" + "\u0065\u0047\u0065\u006e\u0065\u0072\u0061\u0074" + "\u006f\u0072\u0052\u0065\u0071\u0075\u0065\u0073" + "\u0074\u002e\u0052\u0065\u0071\u0075\u0065\u0073" + "\u0074\u0065\u0064\u0046\u0069\u006c\u0065\u0000" + "\u0004\u0000\u0000\u0000\u0001\u0000\u0001\u0000" + "\u00e5\u0057\u0023\u0012\u0093\u0041\u0050\u00ae" + "\u0001\u0000\u0000\u0000\u003a\u0000\u0000\u0000" + "\u0049\u006d\u0070\u006f\u0072\u0074\u0000\u0000" + "\u000c\u0000\u0000\u0000\u0003\u0000\u0004\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0045\u0000\u0000\u0000\u001a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0040\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u004c\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0049\u0000\u0000\u0000\u004a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0048\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0054\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0002\u0000\u0000\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0002\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0051\u0000\u0000\u0000\u0042\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u004c\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0068\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0069\u0064\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0009\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0009\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0066\u0069\u006c\u0065\u006e\u0061\u006d\u0065" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000c\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000c\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0069\u006d\u0070\u006f\u0072\u0074\u0073\u0000" + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00e5\u0057\u0023\u0012\u0093\u0041\u0050\u00ae" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "")
    val b_ae504193122357e5: SegmentReader = org.capnproto.GeneratedClassSupport.decodeRawBytes("\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u00e5\u0057\u0023\u0012\u0093\u0041\u0050\u00ae" + "\u0030\u0000\u0000\u0000\u0001\u0000\u0001\u0000" + "\u0062\u0000\u0081\u002e\u00b0\u000e\u00ea\u00cf" + "\u0001\u0000\u0007\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0015\u0000\u0000\u0000\u00ba\u0001\u0000\u0000" + "\u002d\u0000\u0000\u0000\u0007\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0029\u0000\u0000\u0000\u0077\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0073\u0063\u0068\u0065\u006d\u0061\u002e\u0063" + "\u0061\u0070\u006e\u0070\u003a\u0043\u006f\u0064" + "\u0065\u0047\u0065\u006e\u0065\u0072\u0061\u0074" + "\u006f\u0072\u0052\u0065\u0071\u0075\u0065\u0073" + "\u0074\u002e\u0052\u0065\u0071\u0075\u0065\u0073" + "\u0074\u0065\u0064\u0046\u0069\u006c\u0065\u002e" + "\u0049\u006d\u0070\u006f\u0072\u0074\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0001\u0000\u0001\u0000" + "\u0008\u0000\u0000\u0000\u0003\u0000\u0004\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0029\u0000\u0000\u0000\u001a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0024\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0030\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0001\u0000\u0001\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u002d\u0000\u0000\u0000\u002a\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0028\u0000\u0000\u0000\u0003\u0000\u0001\u0000" + "\u0034\u0000\u0000\u0000\u0002\u0000\u0001\u0000" + "\u0069\u0064\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0009\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0009\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u006e\u0061\u006d\u0065\u0000\u0000\u0000\u0000" + "\u000c\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u000c\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "")
  }

}
