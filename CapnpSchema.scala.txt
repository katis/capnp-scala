package org.capnproto.schema;

object CapnpSchema {

  object Node {
    val STRUCT_SIZE: StructSize = new StructSize(5.toShort, 6.toShort)

    final class Factory() extends org.capnproto.StructFactory[CapnpSchema.Node.Builder, CapnpSchema.Node.Reader] {
      def constructReader(segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): CapnpSchema.Node.Reader = {
        new CapnpSchema.Node.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
      }

      def constructBuilder(segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short): CapnpSchema.Node.Builder = {
        new CapnpSchema.Node.Builder(segment, data, pointers, dataSize, pointerCount)
      }

      def structSize: StructSize = {
        Node.STRUCT_SIZE
      }

      def asReader(builder: CapnpSchema.Node.Builder): CapnpSchema.Node.Reader = {
        builder.asReader
      }
    }

    val factory: CapnpSchema.Node.Factory = new CapnpSchema.Node.Factory
    val listFactory: StructList.Factory[CapnpSchema.Node.Builder, CapnpSchema.Node.Reader] = new StructList.Factory[CapnpSchema.Node.Builder, CapnpSchema.Node.Reader](factory)

    final class Builder private[schema](segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends org.capnproto.StructBuilder(segment, data, pointers, dataSize, pointerCount) {
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

      def asReader: CapnpSchema.Node.Reader = {
        new CapnpSchema.Node.Reader(segment, data, pointers, dataSize, pointerCount, 0x7fffffff)
      }

      def getId: Long = {
        _getLongField(0)
      }

      def setId(value: Long) {
        _setLongField(0, value)
      }

      def hasDisplayName: Boolean = {
        !_pointerFieldIsNull(0)
      }

      def getDisplayName: Text.Builder = {
        _getPointerField(org.capnproto.Text.factory, 0, null, 0, 0)
      }

      def setDisplayName(value: Text.Reader) {
        _setPointerField(org.capnproto.Text.factory, 0, value)
      }

      def setDisplayName(value: String) {
        _setPointerField(org.capnproto.Text.factory, 0, new Text.Reader(value))
      }

      def initDisplayName(size: Int): Text.Builder = {
        _initPointerField(org.capnproto.Text.factory, 0, size)
      }

      def getDisplayNamePrefixLength: Int = {
        _getIntField(2)
      }

      def setDisplayNamePrefixLength(value: Int) {
        _setIntField(2, value)
      }

      def getScopeId: Long = {
        _getLongField(2)
      }

      def setScopeId(value: Long) {
        _setLongField(2, value)
      }

      def hasNestedNodes: Boolean = {
        !_pointerFieldIsNull(1)
      }

      def getNestedNodes: StructList.Builder[CapnpSchema.Node.NestedNode.Builder] = {
        _getPointerField(CapnpSchema.Node.NestedNode.listFactory, 1, null, 0)
      }

      def setNestedNodes(value: StructList.Reader[CapnpSchema.Node.NestedNode.Reader]) {
        _setPointerField(CapnpSchema.Node.NestedNode.listFactory, 1, value)
      }

      def initNestedNodes(size: Int): StructList.Builder[CapnpSchema.Node.NestedNode.Builder] = {
        _initPointerField(CapnpSchema.Node.NestedNode.listFactory, 1, size)
      }

      def hasAnnotations: Boolean = {
        !_pointerFieldIsNull(2)
      }

      def getAnnotations: StructList.Builder[CapnpSchema.Annotation.Builder] = {
        _getPointerField(CapnpSchema.Annotation.listFactory, 2, null, 0)
      }

      def setAnnotations(value: StructList.Reader[CapnpSchema.Annotation.Reader]) {
        _setPointerField(CapnpSchema.Annotation.listFactory, 2, value)
      }

      def initAnnotations(size: Int): StructList.Builder[CapnpSchema.Annotation.Builder] = {
        _initPointerField(CapnpSchema.Annotation.listFactory, 2, size)
      }

      def isFile: Boolean = {
        which == Node.Which.FILE
      }

      def getFile: Void.type = {
        assert(which == Node.Which.FILE, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def setFile(value: Void.type) {
        _setShortField(6, Node.Which.FILE.id.toShort)
      }

      def isStruct: Boolean = {
        which == Node.Which.STRUCT
      }

      def getStruct: CapnpSchema.Node.Struct.Builder = {
        new CapnpSchema.Node.Struct.Builder(segment, data, pointers, dataSize, pointerCount)
      }

      def initStruct: CapnpSchema.Node.Struct.Builder = {
        _setShortField(6, Node.Which.STRUCT.id.toShort)
        _setShortField(7, 0.toShort)
        _setShortField(12, 0.toShort)
        _setShortField(13, 0.toShort)
        _setBooleanField(224, false)
        _setShortField(15, 0.toShort)
        _setIntField(8, 0)
        _clearPointerField(3)
        new CapnpSchema.Node.Struct.Builder(segment, data, pointers, dataSize, pointerCount)
      }

      def isEnum: Boolean = {
        which == Node.Which.ENUM
      }

      def getEnum: CapnpSchema.Node.Enum.Builder = {
        new CapnpSchema.Node.Enum.Builder(segment, data, pointers, dataSize, pointerCount)
      }

      def initEnum: CapnpSchema.Node.Enum.Builder = {
        _setShortField(6, Node.Which.ENUM.id.toShort)
        _clearPointerField(3)
        new CapnpSchema.Node.Enum.Builder(segment, data, pointers, dataSize, pointerCount)
      }

      def isInterface: Boolean = {
        which == Node.Which.INTERFACE
      }

      def getInterface: CapnpSchema.Node.Interface.Builder = {
        new CapnpSchema.Node.Interface.Builder(segment, data, pointers, dataSize, pointerCount)
      }

      def initInterface: CapnpSchema.Node.Interface.Builder = {
        _setShortField(6, Node.Which.INTERFACE.id.toShort)
        _clearPointerField(3)
        _clearPointerField(4)
        new CapnpSchema.Node.Interface.Builder(segment, data, pointers, dataSize, pointerCount)
      }

      def isConst: Boolean = {
        which == Node.Which.CONST
      }

      def getConst: CapnpSchema.Node.Const.Builder = {
        new CapnpSchema.Node.Const.Builder(segment, data, pointers, dataSize, pointerCount)
      }

      def initConst: CapnpSchema.Node.Const.Builder = {
        _setShortField(6, Node.Which.CONST.id.toShort)
        _clearPointerField(3)
        _clearPointerField(4)
        new CapnpSchema.Node.Const.Builder(segment, data, pointers, dataSize, pointerCount)
      }

      def isAnnotation: Boolean = {
        which == Node.Which.ANNOTATION
      }

      def getAnnotation: CapnpSchema.Node.Annotation.Builder = {
        new CapnpSchema.Node.Annotation.Builder(segment, data, pointers, dataSize, pointerCount)
      }

      def initAnnotation: CapnpSchema.Node.Annotation.Builder = {
        _setShortField(6, Node.Which.ANNOTATION.id.toShort)
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
        _clearPointerField(3)
        new CapnpSchema.Node.Annotation.Builder(segment, data, pointers, dataSize, pointerCount)
      }

      def hasParameters: Boolean = {
        !_pointerFieldIsNull(5)
      }

      def getParameters: StructList.Builder[CapnpSchema.Node.Parameter.Builder] = {
        _getPointerField(CapnpSchema.Node.Parameter.listFactory, 5, null, 0)
      }

      def setParameters(value: StructList.Reader[CapnpSchema.Node.Parameter.Reader]) {
        _setPointerField(CapnpSchema.Node.Parameter.listFactory, 5, value)
      }

      def initParameters(size: Int): StructList.Builder[CapnpSchema.Node.Parameter.Builder] = {
        _initPointerField(CapnpSchema.Node.Parameter.listFactory, 5, size)
      }

      def getIsGeneric: Boolean = {
        _getBooleanField(288)
      }

      def setIsGeneric(value: Boolean) {
        _setBooleanField(288, value)
      }
    }

    final class Reader private[schema](segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends org.capnproto.StructReader(segment, data, pointers, dataSize, pointerCount, nestingLimit) {
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

      def getId: Long = {
        _getLongField(0)
      }

      def hasDisplayName: Boolean = {
        !_pointerFieldIsNull(0)
      }

      def getDisplayName: Text.Reader = {
        _getPointerField(org.capnproto.Text.factory, 0, null, 0, 0)
      }

      def getDisplayNamePrefixLength: Int = {
        _getIntField(2)
      }

      def getScopeId: Long = {
        _getLongField(2)
      }

      def hasNestedNodes: Boolean = {
        !_pointerFieldIsNull(1)
      }

      def getNestedNodes: StructList.Reader[CapnpSchema.Node.NestedNode.Reader] = {
        _getPointerField(CapnpSchema.Node.NestedNode.listFactory, 1, null, 0)
      }

      def hasAnnotations: Boolean = {
        !_pointerFieldIsNull(2)
      }

      def getAnnotations: StructList.Reader[CapnpSchema.Annotation.Reader] = {
        _getPointerField(CapnpSchema.Annotation.listFactory, 2, null, 0)
      }

      def isFile: Boolean = {
        which == Node.Which.FILE
      }

      def getFile: Void.type = {
        assert(which == Node.Which.FILE, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def isStruct: Boolean = {
        which == Node.Which.STRUCT
      }

      def getStruct: CapnpSchema.Node.Struct.Reader = {
        new CapnpSchema.Node.Struct.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
      }

      def isEnum: Boolean = {
        which == Node.Which.ENUM
      }

      def getEnum: CapnpSchema.Node.Enum.Reader = {
        new CapnpSchema.Node.Enum.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
      }

      def isInterface: Boolean = {
        which == Node.Which.INTERFACE
      }

      def getInterface: CapnpSchema.Node.Interface.Reader = {
        new CapnpSchema.Node.Interface.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
      }

      def isConst: Boolean = {
        which == Node.Which.CONST
      }

      def getConst: CapnpSchema.Node.Const.Reader = {
        new CapnpSchema.Node.Const.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
      }

      def isAnnotation: Boolean = {
        which == Node.Which.ANNOTATION
      }

      def getAnnotation: CapnpSchema.Node.Annotation.Reader = {
        new CapnpSchema.Node.Annotation.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
      }

      def hasParameters: Boolean = {
        !_pointerFieldIsNull(5)
      }

      def getParameters: StructList.Reader[CapnpSchema.Node.Parameter.Reader] = {
        _getPointerField(CapnpSchema.Node.Parameter.listFactory, 5, null, 0)
      }

      def getIsGeneric: Boolean = {
        _getBooleanField(288)
      }
    }

    object Which extends Enumeration {
      type Which = Value
      val FILE, STRUCT, ENUM, INTERFACE, CONST, ANNOTATION, _NOT_IN_SCHEMA = Value
    }

    object Parameter {
      val STRUCT_SIZE: StructSize = new StructSize(0.toShort, 1.toShort)

      final class Factory() extends org.capnproto.StructFactory[CapnpSchema.Node.Parameter.Builder, CapnpSchema.Node.Parameter.Reader] {
        def constructReader(segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): CapnpSchema.Node.Parameter.Reader = {
          new CapnpSchema.Node.Parameter.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
        }

        def constructBuilder(segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short): CapnpSchema.Node.Parameter.Builder = {
          new CapnpSchema.Node.Parameter.Builder(segment, data, pointers, dataSize, pointerCount)
        }

        def structSize: StructSize = {
          Node.Parameter.STRUCT_SIZE
        }

        def asReader(builder: CapnpSchema.Node.Parameter.Builder): CapnpSchema.Node.Parameter.Reader = {
          builder.asReader
        }
      }

      val factory: CapnpSchema.Node.Parameter.Factory = new CapnpSchema.Node.Parameter.Factory
      val listFactory: StructList.Factory[CapnpSchema.Node.Parameter.Builder, CapnpSchema.Node.Parameter.Reader] = new StructList.Factory[CapnpSchema.Node.Parameter.Builder, CapnpSchema.Node.Parameter.Reader](factory)

      final class Builder private[schema](segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends org.capnproto.StructBuilder(segment, data, pointers, dataSize, pointerCount) {
        def asReader: CapnpSchema.Node.Parameter.Reader = {
          new CapnpSchema.Node.Parameter.Reader(segment, data, pointers, dataSize, pointerCount, 0x7fffffff)
        }

        def hasName: Boolean = {
          !_pointerFieldIsNull(0)
        }

        def getName: Text.Builder = {
          _getPointerField(org.capnproto.Text.factory, 0, null, 0, 0)
        }

        def setName(value: Text.Reader) {
          _setPointerField(org.capnproto.Text.factory, 0, value)
        }

        def setName(value: String) {
          _setPointerField(org.capnproto.Text.factory, 0, new Text.Reader(value))
        }

        def initName(size: Int): Text.Builder = {
          _initPointerField(org.capnproto.Text.factory, 0, size)
        }
      }

      final class Reader private[schema](segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends org.capnproto.StructReader(segment, data, pointers, dataSize, pointerCount, nestingLimit) {
        def hasName: Boolean = {
          !_pointerFieldIsNull(0)
        }

        def getName: Text.Reader = {
          _getPointerField(org.capnproto.Text.factory, 0, null, 0, 0)
        }
      }

    }

    object NestedNode {
      val STRUCT_SIZE: StructSize = new StructSize(1.toShort, 1.toShort)

      final class Factory() extends org.capnproto.StructFactory[CapnpSchema.Node.NestedNode.Builder, CapnpSchema.Node.NestedNode.Reader] {
        def constructReader(segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): CapnpSchema.Node.NestedNode.Reader = {
          new CapnpSchema.Node.NestedNode.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
        }

        def constructBuilder(segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short): CapnpSchema.Node.NestedNode.Builder = {
          new CapnpSchema.Node.NestedNode.Builder(segment, data, pointers, dataSize, pointerCount)
        }

        def structSize: StructSize = {
          Node.NestedNode.STRUCT_SIZE
        }

        def asReader(builder: CapnpSchema.Node.NestedNode.Builder): CapnpSchema.Node.NestedNode.Reader = {
          builder.asReader
        }
      }

      val factory: CapnpSchema.Node.NestedNode.Factory = new CapnpSchema.Node.NestedNode.Factory
      val listFactory: StructList.Factory[CapnpSchema.Node.NestedNode.Builder, CapnpSchema.Node.NestedNode.Reader] = new StructList.Factory[CapnpSchema.Node.NestedNode.Builder, CapnpSchema.Node.NestedNode.Reader](factory)

      final class Builder private[schema](segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends org.capnproto.StructBuilder(segment, data, pointers, dataSize, pointerCount) {
        def asReader: CapnpSchema.Node.NestedNode.Reader = {
          new CapnpSchema.Node.NestedNode.Reader(segment, data, pointers, dataSize, pointerCount, 0x7fffffff)
        }

        def hasName: Boolean = {
          !_pointerFieldIsNull(0)
        }

        def getName: Text.Builder = {
          _getPointerField(org.capnproto.Text.factory, 0, null, 0, 0)
        }

        def setName(value: Text.Reader) {
          _setPointerField(org.capnproto.Text.factory, 0, value)
        }

        def setName(value: String) {
          _setPointerField(org.capnproto.Text.factory, 0, new Text.Reader(value))
        }

        def initName(size: Int): Text.Builder = {
          _initPointerField(org.capnproto.Text.factory, 0, size)
        }

        def getId: Long = {
          _getLongField(0)
        }

        def setId(value: Long) {
          _setLongField(0, value)
        }
      }

      final class Reader private[schema](segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends org.capnproto.StructReader(segment, data, pointers, dataSize, pointerCount, nestingLimit) {
        def hasName: Boolean = {
          !_pointerFieldIsNull(0)
        }

        def getName: Text.Reader = {
          _getPointerField(org.capnproto.Text.factory, 0, null, 0, 0)
        }

        def getId: Long = {
          _getLongField(0)
        }
      }

    }

    object Struct {
      val STRUCT_SIZE: StructSize = new StructSize(5.toShort, 6.toShort)

      final class Factory() extends org.capnproto.StructFactory[CapnpSchema.Node.Struct.Builder, CapnpSchema.Node.Struct.Reader] {
        def constructReader(segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): CapnpSchema.Node.Struct.Reader = {
          new CapnpSchema.Node.Struct.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
        }

        def constructBuilder(segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short): CapnpSchema.Node.Struct.Builder = {
          new CapnpSchema.Node.Struct.Builder(segment, data, pointers, dataSize, pointerCount)
        }

        def structSize: StructSize = {
          Node.Struct.STRUCT_SIZE
        }

        def asReader(builder: CapnpSchema.Node.Struct.Builder): CapnpSchema.Node.Struct.Reader = {
          builder.asReader
        }
      }

      val factory: CapnpSchema.Node.Struct.Factory = new CapnpSchema.Node.Struct.Factory
      val listFactory: StructList.Factory[CapnpSchema.Node.Struct.Builder, CapnpSchema.Node.Struct.Reader] = new StructList.Factory[CapnpSchema.Node.Struct.Builder, CapnpSchema.Node.Struct.Reader](factory)

      final class Builder private[schema](segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends org.capnproto.StructBuilder(segment, data, pointers, dataSize, pointerCount) {
        def asReader: CapnpSchema.Node.Struct.Reader = {
          new CapnpSchema.Node.Struct.Reader(segment, data, pointers, dataSize, pointerCount, 0x7fffffff)
        }

        def getDataWordCount: Short = {
          _getShortField(7)
        }

        def setDataWordCount(value: Short) {
          _setShortField(7, value)
        }

        def getPointerCount: Short = {
          _getShortField(12)
        }

        def setPointerCount(value: Short) {
          _setShortField(12, value)
        }

        def getPreferredListEncoding: CapnpSchema.ElementSize.ElementSize = {
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

        def setPreferredListEncoding(value: CapnpSchema.ElementSize.ElementSize) {
          _setShortField(13, value.id.toShort)
        }

        def getIsGroup: Boolean = {
          _getBooleanField(224)
        }

        def setIsGroup(value: Boolean) {
          _setBooleanField(224, value)
        }

        def getDiscriminantCount: Short = {
          _getShortField(15)
        }

        def setDiscriminantCount(value: Short) {
          _setShortField(15, value)
        }

        def getDiscriminantOffset: Int = {
          _getIntField(8)
        }

        def setDiscriminantOffset(value: Int) {
          _setIntField(8, value)
        }

        def hasFields: Boolean = {
          !_pointerFieldIsNull(3)
        }

        def getFields: StructList.Builder[CapnpSchema.Field.Builder] = {
          _getPointerField(CapnpSchema.Field.listFactory, 3, null, 0)
        }

        def setFields(value: StructList.Reader[CapnpSchema.Field.Reader]) {
          _setPointerField(CapnpSchema.Field.listFactory, 3, value)
        }

        def initFields(size: Int): StructList.Builder[CapnpSchema.Field.Builder] = {
          _initPointerField(CapnpSchema.Field.listFactory, 3, size)
        }
      }

      final class Reader private[schema](segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends org.capnproto.StructReader(segment, data, pointers, dataSize, pointerCount, nestingLimit) {
        def getDataWordCount: Short = {
          _getShortField(7)
        }

        def getPointerCount: Short = {
          _getShortField(12)
        }

        def getPreferredListEncoding: CapnpSchema.ElementSize.ElementSize = {
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

        def getIsGroup: Boolean = {
          _getBooleanField(224)
        }

        def getDiscriminantCount: Short = {
          _getShortField(15)
        }

        def getDiscriminantOffset: Int = {
          _getIntField(8)
        }

        def hasFields: Boolean = {
          !_pointerFieldIsNull(3)
        }

        def getFields: StructList.Reader[CapnpSchema.Field.Reader] = {
          _getPointerField(CapnpSchema.Field.listFactory, 3, null, 0)
        }
      }

    }

    object Enum {
      val STRUCT_SIZE: StructSize = new StructSize(5.toShort, 6.toShort)

      final class Factory() extends org.capnproto.StructFactory[CapnpSchema.Node.Enum.Builder, CapnpSchema.Node.Enum.Reader] {
        def constructReader(segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): CapnpSchema.Node.Enum.Reader = {
          new CapnpSchema.Node.Enum.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
        }

        def constructBuilder(segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short): CapnpSchema.Node.Enum.Builder = {
          new CapnpSchema.Node.Enum.Builder(segment, data, pointers, dataSize, pointerCount)
        }

        def structSize: StructSize = {
          Node.Enum.STRUCT_SIZE
        }

        def asReader(builder: CapnpSchema.Node.Enum.Builder): CapnpSchema.Node.Enum.Reader = {
          builder.asReader
        }
      }

      val factory: CapnpSchema.Node.Enum.Factory = new CapnpSchema.Node.Enum.Factory
      val listFactory: StructList.Factory[CapnpSchema.Node.Enum.Builder, CapnpSchema.Node.Enum.Reader] = new StructList.Factory[CapnpSchema.Node.Enum.Builder, CapnpSchema.Node.Enum.Reader](factory)

      final class Builder private[schema](segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends org.capnproto.StructBuilder(segment, data, pointers, dataSize, pointerCount) {
        def asReader: CapnpSchema.Node.Enum.Reader = {
          new CapnpSchema.Node.Enum.Reader(segment, data, pointers, dataSize, pointerCount, 0x7fffffff)
        }

        def hasEnumerants: Boolean = {
          !_pointerFieldIsNull(3)
        }

        def getEnumerants: StructList.Builder[CapnpSchema.Enumerant.Builder] = {
          _getPointerField(CapnpSchema.Enumerant.listFactory, 3, null, 0)
        }

        def setEnumerants(value: StructList.Reader[CapnpSchema.Enumerant.Reader]) {
          _setPointerField(CapnpSchema.Enumerant.listFactory, 3, value)
        }

        def initEnumerants(size: Int): StructList.Builder[CapnpSchema.Enumerant.Builder] = {
          _initPointerField(CapnpSchema.Enumerant.listFactory, 3, size)
        }
      }

      final class Reader private[schema](segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends org.capnproto.StructReader(segment, data, pointers, dataSize, pointerCount, nestingLimit) {
        def hasEnumerants: Boolean = {
          !_pointerFieldIsNull(3)
        }

        def getEnumerants: StructList.Reader[CapnpSchema.Enumerant.Reader] = {
          _getPointerField(CapnpSchema.Enumerant.listFactory, 3, null, 0)
        }
      }

    }

    object Interface {
      val STRUCT_SIZE: StructSize = new StructSize(5.toShort, 6.toShort)

      final class Factory() extends org.capnproto.StructFactory[CapnpSchema.Node.Interface.Builder, CapnpSchema.Node.Interface.Reader] {
        def constructReader(segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): CapnpSchema.Node.Interface.Reader = {
          new CapnpSchema.Node.Interface.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
        }

        def constructBuilder(segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short): CapnpSchema.Node.Interface.Builder = {
          new CapnpSchema.Node.Interface.Builder(segment, data, pointers, dataSize, pointerCount)
        }

        def structSize: StructSize = {
          Node.Interface.STRUCT_SIZE
        }

        def asReader(builder: CapnpSchema.Node.Interface.Builder): CapnpSchema.Node.Interface.Reader = {
          builder.asReader
        }
      }

      val factory: CapnpSchema.Node.Interface.Factory = new CapnpSchema.Node.Interface.Factory
      val listFactory: StructList.Factory[CapnpSchema.Node.Interface.Builder, CapnpSchema.Node.Interface.Reader] = new StructList.Factory[CapnpSchema.Node.Interface.Builder, CapnpSchema.Node.Interface.Reader](factory)

      final class Builder private[schema](segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends org.capnproto.StructBuilder(segment, data, pointers, dataSize, pointerCount) {
        def asReader: CapnpSchema.Node.Interface.Reader = {
          new CapnpSchema.Node.Interface.Reader(segment, data, pointers, dataSize, pointerCount, 0x7fffffff)
        }

        def hasMethods: Boolean = {
          !_pointerFieldIsNull(3)
        }

        def getMethods: StructList.Builder[CapnpSchema.Method.Builder] = {
          _getPointerField(CapnpSchema.Method.listFactory, 3, null, 0)
        }

        def setMethods(value: StructList.Reader[CapnpSchema.Method.Reader]) {
          _setPointerField(CapnpSchema.Method.listFactory, 3, value)
        }

        def initMethods(size: Int): StructList.Builder[CapnpSchema.Method.Builder] = {
          _initPointerField(CapnpSchema.Method.listFactory, 3, size)
        }

        def hasSuperclasses: Boolean = {
          !_pointerFieldIsNull(4)
        }

        def getSuperclasses: StructList.Builder[CapnpSchema.Superclass.Builder] = {
          _getPointerField(CapnpSchema.Superclass.listFactory, 4, null, 0)
        }

        def setSuperclasses(value: StructList.Reader[CapnpSchema.Superclass.Reader]) {
          _setPointerField(CapnpSchema.Superclass.listFactory, 4, value)
        }

        def initSuperclasses(size: Int): StructList.Builder[CapnpSchema.Superclass.Builder] = {
          _initPointerField(CapnpSchema.Superclass.listFactory, 4, size)
        }
      }

      final class Reader private[schema](segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends org.capnproto.StructReader(segment, data, pointers, dataSize, pointerCount, nestingLimit) {
        def hasMethods: Boolean = {
          !_pointerFieldIsNull(3)
        }

        def getMethods: StructList.Reader[CapnpSchema.Method.Reader] = {
          _getPointerField(CapnpSchema.Method.listFactory, 3, null, 0)
        }

        def hasSuperclasses: Boolean = {
          !_pointerFieldIsNull(4)
        }

        def getSuperclasses: StructList.Reader[CapnpSchema.Superclass.Reader] = {
          _getPointerField(CapnpSchema.Superclass.listFactory, 4, null, 0)
        }
      }

    }

    object Const {
      val STRUCT_SIZE: StructSize = new StructSize(5.toShort, 6.toShort)

      final class Factory() extends org.capnproto.StructFactory[CapnpSchema.Node.Const.Builder, CapnpSchema.Node.Const.Reader] {
        def constructReader(segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): CapnpSchema.Node.Const.Reader = {
          new CapnpSchema.Node.Const.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
        }

        def constructBuilder(segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short): CapnpSchema.Node.Const.Builder = {
          new CapnpSchema.Node.Const.Builder(segment, data, pointers, dataSize, pointerCount)
        }

        def structSize: StructSize = {
          Node.Const.STRUCT_SIZE
        }

        def asReader(builder: CapnpSchema.Node.Const.Builder): CapnpSchema.Node.Const.Reader = {
          builder.asReader
        }
      }

      val factory: CapnpSchema.Node.Const.Factory = new CapnpSchema.Node.Const.Factory
      val listFactory: StructList.Factory[CapnpSchema.Node.Const.Builder, CapnpSchema.Node.Const.Reader] = new StructList.Factory[CapnpSchema.Node.Const.Builder, CapnpSchema.Node.Const.Reader](factory)

      final class Builder private[schema](segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends org.capnproto.StructBuilder(segment, data, pointers, dataSize, pointerCount) {
        def asReader: CapnpSchema.Node.Const.Reader = {
          new CapnpSchema.Node.Const.Reader(segment, data, pointers, dataSize, pointerCount, 0x7fffffff)
        }

        def getType: CapnpSchema.Type.Builder = {
          _getPointerField(CapnpSchema.Type.factory, 3, null, 0)
        }

        def setType(value: CapnpSchema.Type.Reader) {
          _setPointerField(CapnpSchema.Type.factory, 3, value)
        }

        def initType: CapnpSchema.Type.Builder = {
          _initPointerField(CapnpSchema.Type.factory, 3, 0)
        }

        def getValue: CapnpSchema.Value.Builder = {
          _getPointerField(CapnpSchema.Value.factory, 4, null, 0)
        }

        def setValue(value: CapnpSchema.Value.Reader) {
          _setPointerField(CapnpSchema.Value.factory, 4, value)
        }

        def initValue: CapnpSchema.Value.Builder = {
          _initPointerField(CapnpSchema.Value.factory, 4, 0)
        }
      }

      final class Reader private[schema](segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends org.capnproto.StructReader(segment, data, pointers, dataSize, pointerCount, nestingLimit) {
        def hasType: Boolean = {
          !_pointerFieldIsNull(3)
        }

        def getType: CapnpSchema.Type.Reader = {
          _getPointerField(CapnpSchema.Type.factory, 3, null, 0)
        }

        def hasValue: Boolean = {
          !_pointerFieldIsNull(4)
        }

        def getValue: CapnpSchema.Value.Reader = {
          _getPointerField(CapnpSchema.Value.factory, 4, null, 0)
        }
      }

    }

    object Annotation {
      val STRUCT_SIZE: StructSize = new StructSize(5.toShort, 6.toShort)

      final class Factory() extends org.capnproto.StructFactory[CapnpSchema.Node.Annotation.Builder, CapnpSchema.Node.Annotation.Reader] {
        def constructReader(segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): CapnpSchema.Node.Annotation.Reader = {
          new CapnpSchema.Node.Annotation.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
        }

        def constructBuilder(segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short): CapnpSchema.Node.Annotation.Builder = {
          new CapnpSchema.Node.Annotation.Builder(segment, data, pointers, dataSize, pointerCount)
        }

        def structSize: StructSize = {
          Node.Annotation.STRUCT_SIZE
        }

        def asReader(builder: CapnpSchema.Node.Annotation.Builder): CapnpSchema.Node.Annotation.Reader = {
          builder.asReader
        }
      }

      val factory: CapnpSchema.Node.Annotation.Factory = new CapnpSchema.Node.Annotation.Factory
      val listFactory: StructList.Factory[CapnpSchema.Node.Annotation.Builder, CapnpSchema.Node.Annotation.Reader] = new StructList.Factory[CapnpSchema.Node.Annotation.Builder, CapnpSchema.Node.Annotation.Reader](factory)

      final class Builder private[schema](segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends org.capnproto.StructBuilder(segment, data, pointers, dataSize, pointerCount) {
        def asReader: CapnpSchema.Node.Annotation.Reader = {
          new CapnpSchema.Node.Annotation.Reader(segment, data, pointers, dataSize, pointerCount, 0x7fffffff)
        }

        def getType: CapnpSchema.Type.Builder = {
          _getPointerField(CapnpSchema.Type.factory, 3, null, 0)
        }

        def setType(value: CapnpSchema.Type.Reader) {
          _setPointerField(CapnpSchema.Type.factory, 3, value)
        }

        def initType: CapnpSchema.Type.Builder = {
          _initPointerField(CapnpSchema.Type.factory, 3, 0)
        }

        def getTargetsFile: Boolean = {
          _getBooleanField(112)
        }

        def setTargetsFile(value: Boolean) {
          _setBooleanField(112, value)
        }

        def getTargetsConst: Boolean = {
          _getBooleanField(113)
        }

        def setTargetsConst(value: Boolean) {
          _setBooleanField(113, value)
        }

        def getTargetsEnum: Boolean = {
          _getBooleanField(114)
        }

        def setTargetsEnum(value: Boolean) {
          _setBooleanField(114, value)
        }

        def getTargetsEnumerant: Boolean = {
          _getBooleanField(115)
        }

        def setTargetsEnumerant(value: Boolean) {
          _setBooleanField(115, value)
        }

        def getTargetsStruct: Boolean = {
          _getBooleanField(116)
        }

        def setTargetsStruct(value: Boolean) {
          _setBooleanField(116, value)
        }

        def getTargetsField: Boolean = {
          _getBooleanField(117)
        }

        def setTargetsField(value: Boolean) {
          _setBooleanField(117, value)
        }

        def getTargetsUnion: Boolean = {
          _getBooleanField(118)
        }

        def setTargetsUnion(value: Boolean) {
          _setBooleanField(118, value)
        }

        def getTargetsGroup: Boolean = {
          _getBooleanField(119)
        }

        def setTargetsGroup(value: Boolean) {
          _setBooleanField(119, value)
        }

        def getTargetsInterface: Boolean = {
          _getBooleanField(120)
        }

        def setTargetsInterface(value: Boolean) {
          _setBooleanField(120, value)
        }

        def getTargetsMethod: Boolean = {
          _getBooleanField(121)
        }

        def setTargetsMethod(value: Boolean) {
          _setBooleanField(121, value)
        }

        def getTargetsParam: Boolean = {
          _getBooleanField(122)
        }

        def setTargetsParam(value: Boolean) {
          _setBooleanField(122, value)
        }

        def getTargetsAnnotation: Boolean = {
          _getBooleanField(123)
        }

        def setTargetsAnnotation(value: Boolean) {
          _setBooleanField(123, value)
        }
      }

      final class Reader private[schema](segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends org.capnproto.StructReader(segment, data, pointers, dataSize, pointerCount, nestingLimit) {
        def hasType: Boolean = {
          !_pointerFieldIsNull(3)
        }

        def getType: CapnpSchema.Type.Reader = {
          _getPointerField(CapnpSchema.Type.factory, 3, null, 0)
        }

        def getTargetsFile: Boolean = {
          _getBooleanField(112)
        }

        def getTargetsConst: Boolean = {
          _getBooleanField(113)
        }

        def getTargetsEnum: Boolean = {
          _getBooleanField(114)
        }

        def getTargetsEnumerant: Boolean = {
          _getBooleanField(115)
        }

        def getTargetsStruct: Boolean = {
          _getBooleanField(116)
        }

        def getTargetsField: Boolean = {
          _getBooleanField(117)
        }

        def getTargetsUnion: Boolean = {
          _getBooleanField(118)
        }

        def getTargetsGroup: Boolean = {
          _getBooleanField(119)
        }

        def getTargetsInterface: Boolean = {
          _getBooleanField(120)
        }

        def getTargetsMethod: Boolean = {
          _getBooleanField(121)
        }

        def getTargetsParam: Boolean = {
          _getBooleanField(122)
        }

        def getTargetsAnnotation: Boolean = {
          _getBooleanField(123)
        }
      }

    }

  }

  object Field {
    val STRUCT_SIZE: StructSize = new StructSize(3.toShort, 4.toShort)

    final class Factory() extends org.capnproto.StructFactory[CapnpSchema.Field.Builder, CapnpSchema.Field.Reader] {
      def constructReader(segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): CapnpSchema.Field.Reader = {
        new CapnpSchema.Field.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
      }

      def constructBuilder(segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short): CapnpSchema.Field.Builder = {
        new CapnpSchema.Field.Builder(segment, data, pointers, dataSize, pointerCount)
      }

      def structSize: StructSize = {
        Field.STRUCT_SIZE
      }

      def asReader(builder: CapnpSchema.Field.Builder): CapnpSchema.Field.Reader = {
        builder.asReader
      }
    }

    val factory: CapnpSchema.Field.Factory = new CapnpSchema.Field.Factory
    val listFactory: StructList.Factory[CapnpSchema.Field.Builder, CapnpSchema.Field.Reader] = new StructList.Factory[CapnpSchema.Field.Builder, CapnpSchema.Field.Reader](factory)

    final class Builder private[schema](segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends org.capnproto.StructBuilder(segment, data, pointers, dataSize, pointerCount) {
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

      def asReader: CapnpSchema.Field.Reader = {
        new CapnpSchema.Field.Reader(segment, data, pointers, dataSize, pointerCount, 0x7fffffff)
      }

      def hasName: Boolean = {
        !_pointerFieldIsNull(0)
      }

      def getName: Text.Builder = {
        _getPointerField(org.capnproto.Text.factory, 0, null, 0, 0)
      }

      def setName(value: Text.Reader) {
        _setPointerField(org.capnproto.Text.factory, 0, value)
      }

      def setName(value: String) {
        _setPointerField(org.capnproto.Text.factory, 0, new Text.Reader(value))
      }

      def initName(size: Int): Text.Builder = {
        _initPointerField(org.capnproto.Text.factory, 0, size)
      }

      def getCodeOrder: Short = {
        _getShortField(0)
      }

      def setCodeOrder(value: Short) {
        _setShortField(0, value)
      }

      def hasAnnotations: Boolean = {
        !_pointerFieldIsNull(1)
      }

      def getAnnotations: StructList.Builder[CapnpSchema.Annotation.Builder] = {
        _getPointerField(CapnpSchema.Annotation.listFactory, 1, null, 0)
      }

      def setAnnotations(value: StructList.Reader[CapnpSchema.Annotation.Reader]) {
        _setPointerField(CapnpSchema.Annotation.listFactory, 1, value)
      }

      def initAnnotations(size: Int): StructList.Builder[CapnpSchema.Annotation.Builder] = {
        _initPointerField(CapnpSchema.Annotation.listFactory, 1, size)
      }

      def getDiscriminantValue: Short = {
        _getShortField(1, (-1).toShort)
      }

      def setDiscriminantValue(value: Short) {
        _setShortField(1, value, (-1).toShort)
      }

      def isSlot: Boolean = {
        which == Field.Which.SLOT
      }

      def getSlot: CapnpSchema.Field.Slot.Builder = {
        new CapnpSchema.Field.Slot.Builder(segment, data, pointers, dataSize, pointerCount)
      }

      def initSlot: CapnpSchema.Field.Slot.Builder = {
        _setShortField(4, Field.Which.SLOT.id.toShort)
        _setIntField(1, 0)
        _setBooleanField(128, value = false)
        _clearPointerField(2)
        _clearPointerField(3)
        new CapnpSchema.Field.Slot.Builder(segment, data, pointers, dataSize, pointerCount)
      }

      def isGroup: Boolean = {
        which == Field.Which.GROUP
      }

      def getGroup: CapnpSchema.Field.Group.Builder = {
        new CapnpSchema.Field.Group.Builder(segment, data, pointers, dataSize, pointerCount)
      }

      def initGroup: CapnpSchema.Field.Group.Builder = {
        _setShortField(4, Field.Which.GROUP.id.toShort)
        _setLongField(2, 0L)
        new CapnpSchema.Field.Group.Builder(segment, data, pointers, dataSize, pointerCount)
      }

      def getOrdinal: CapnpSchema.Field.Ordinal.Builder = {
        new CapnpSchema.Field.Ordinal.Builder(segment, data, pointers, dataSize, pointerCount)
      }

      def initOrdinal: CapnpSchema.Field.Ordinal.Builder = {
        _setShortField(5, 0.toShort)
        _setShortField(6, 0.toShort)
        new CapnpSchema.Field.Ordinal.Builder(segment, data, pointers, dataSize, pointerCount)
      }
    }

    final class Reader private[schema](segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends org.capnproto.StructReader(segment, data, pointers, dataSize, pointerCount, nestingLimit) {
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

      def getName: Text.Reader = {
        _getPointerField(org.capnproto.Text.factory, 0, null, 0, 0)
      }

      def getCodeOrder: Short = {
        _getShortField(0)
      }

      def hasAnnotations: Boolean = {
        !_pointerFieldIsNull(1)
      }

      def getAnnotations: StructList.Reader[CapnpSchema.Annotation.Reader] = {
        _getPointerField(CapnpSchema.Annotation.listFactory, 1, null, 0)
      }

      def getDiscriminantValue: Short = {
        _getShortField(1, (-1).toShort)
      }

      def isSlot: Boolean = {
        which == Field.Which.SLOT
      }

      def getSlot: CapnpSchema.Field.Slot.Reader = {
        new CapnpSchema.Field.Slot.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
      }

      def isGroup: Boolean = {
        which == Field.Which.GROUP
      }

      def getGroup: CapnpSchema.Field.Group.Reader = {
        new CapnpSchema.Field.Group.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
      }

      def getOrdinal: CapnpSchema.Field.Ordinal.Reader = {
        new CapnpSchema.Field.Ordinal.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
      }
    }

    object Which extends Enumeration {
      type Which = Value
      val SLOT, GROUP, _NOT_IN_SCHEMA = Value
    }

    val NO_DISCRIMINANT: Short = -1

    object Slot {
      val STRUCT_SIZE: StructSize = new StructSize(3.toShort, 4.toShort)

      final class Factory() extends org.capnproto.StructFactory[CapnpSchema.Field.Slot.Builder, CapnpSchema.Field.Slot.Reader] {
        def constructReader(segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): CapnpSchema.Field.Slot.Reader = {
          new CapnpSchema.Field.Slot.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
        }

        def constructBuilder(segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short): CapnpSchema.Field.Slot.Builder = {
          new CapnpSchema.Field.Slot.Builder(segment, data, pointers, dataSize, pointerCount)
        }

        def structSize: StructSize = {
          Field.Slot.STRUCT_SIZE
        }

        def asReader(builder: CapnpSchema.Field.Slot.Builder): CapnpSchema.Field.Slot.Reader = {
          builder.asReader
        }
      }

      val factory: CapnpSchema.Field.Slot.Factory = new CapnpSchema.Field.Slot.Factory
      val listFactory: StructList.Factory[CapnpSchema.Field.Slot.Builder, CapnpSchema.Field.Slot.Reader] = new StructList.Factory[CapnpSchema.Field.Slot.Builder, CapnpSchema.Field.Slot.Reader](factory)

      final class Builder private[schema](segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends org.capnproto.StructBuilder(segment, data, pointers, dataSize, pointerCount) {
        def asReader: CapnpSchema.Field.Slot.Reader = {
          new CapnpSchema.Field.Slot.Reader(segment, data, pointers, dataSize, pointerCount, 0x7fffffff)
        }

        def getOffset: Int = {
          _getIntField(1)
        }

        def setOffset(value: Int) {
          _setIntField(1, value)
        }

        def getType: CapnpSchema.Type.Builder = {
          _getPointerField(CapnpSchema.Type.factory, 2, null, 0)
        }

        def setType(value: CapnpSchema.Type.Reader) {
          _setPointerField(CapnpSchema.Type.factory, 2, value)
        }

        def initType: CapnpSchema.Type.Builder = {
          _initPointerField(CapnpSchema.Type.factory, 2, 0)
        }

        def getDefaultValue: CapnpSchema.Value.Builder = {
          _getPointerField(CapnpSchema.Value.factory, 3, null, 0)
        }

        def setDefaultValue(value: CapnpSchema.Value.Reader) {
          _setPointerField(CapnpSchema.Value.factory, 3, value)
        }

        def initDefaultValue: CapnpSchema.Value.Builder = {
          _initPointerField(CapnpSchema.Value.factory, 3, 0)
        }

        def getHadExplicitDefault: Boolean = {
          _getBooleanField(128)
        }

        def setHadExplicitDefault(value: Boolean) {
          _setBooleanField(128, value)
        }
      }

      final class Reader private[schema](segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends org.capnproto.StructReader(segment, data, pointers, dataSize, pointerCount, nestingLimit) {
        def getOffset: Int = {
          _getIntField(1)
        }

        def hasType: Boolean = {
          !_pointerFieldIsNull(2)
        }

        def getType: CapnpSchema.Type.Reader = {
          _getPointerField(CapnpSchema.Type.factory, 2, null, 0)
        }

        def hasDefaultValue: Boolean = {
          !_pointerFieldIsNull(3)
        }

        def getDefaultValue: CapnpSchema.Value.Reader = {
          _getPointerField(CapnpSchema.Value.factory, 3, null, 0)
        }

        def getHadExplicitDefault: Boolean = {
          _getBooleanField(128)
        }
      }

    }

    object Group {
      val STRUCT_SIZE: StructSize = new StructSize(3.toShort, 4.toShort)

      final class Factory() extends org.capnproto.StructFactory[CapnpSchema.Field.Group.Builder, CapnpSchema.Field.Group.Reader] {
        def constructReader(segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): CapnpSchema.Field.Group.Reader = {
          new CapnpSchema.Field.Group.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
        }

        def constructBuilder(segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short): CapnpSchema.Field.Group.Builder = {
          new CapnpSchema.Field.Group.Builder(segment, data, pointers, dataSize, pointerCount)
        }

        def structSize: StructSize = {
          Field.Group.STRUCT_SIZE
        }

        def asReader(builder: CapnpSchema.Field.Group.Builder): CapnpSchema.Field.Group.Reader = {
          builder.asReader
        }
      }

      val factory: CapnpSchema.Field.Group.Factory = new CapnpSchema.Field.Group.Factory
      val listFactory: StructList.Factory[CapnpSchema.Field.Group.Builder, CapnpSchema.Field.Group.Reader] = new StructList.Factory[CapnpSchema.Field.Group.Builder, CapnpSchema.Field.Group.Reader](factory)

      final class Builder private[schema](segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends org.capnproto.StructBuilder(segment, data, pointers, dataSize, pointerCount) {
        def asReader: CapnpSchema.Field.Group.Reader = {
          new CapnpSchema.Field.Group.Reader(segment, data, pointers, dataSize, pointerCount, 0x7fffffff)
        }

        def getTypeId: Long = {
          _getLongField(2)
        }

        def setTypeId(value: Long) {
          _setLongField(2, value)
        }
      }

      final class Reader private[schema](segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends org.capnproto.StructReader(segment, data, pointers, dataSize, pointerCount, nestingLimit) {
        def getTypeId: Long = {
          _getLongField(2)
        }
      }

    }

    object Ordinal {
      val STRUCT_SIZE: StructSize = new StructSize(3.toShort, 4.toShort)

      final class Factory() extends org.capnproto.StructFactory[CapnpSchema.Field.Ordinal.Builder, CapnpSchema.Field.Ordinal.Reader] {
        def constructReader(segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): CapnpSchema.Field.Ordinal.Reader = {
          new CapnpSchema.Field.Ordinal.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
        }

        def constructBuilder(segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short): CapnpSchema.Field.Ordinal.Builder = {
          new CapnpSchema.Field.Ordinal.Builder(segment, data, pointers, dataSize, pointerCount)
        }

        def structSize: StructSize = {
          Field.Ordinal.STRUCT_SIZE
        }

        def asReader(builder: CapnpSchema.Field.Ordinal.Builder): CapnpSchema.Field.Ordinal.Reader = {
          builder.asReader
        }
      }

      val factory: CapnpSchema.Field.Ordinal.Factory = new CapnpSchema.Field.Ordinal.Factory
      val listFactory: StructList.Factory[CapnpSchema.Field.Ordinal.Builder, CapnpSchema.Field.Ordinal.Reader] = new StructList.Factory[CapnpSchema.Field.Ordinal.Builder, CapnpSchema.Field.Ordinal.Reader](factory)

      final class Builder private[schema](segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends org.capnproto.StructBuilder(segment, data, pointers, dataSize, pointerCount) {
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

        def asReader: CapnpSchema.Field.Ordinal.Reader = {
          new CapnpSchema.Field.Ordinal.Reader(segment, data, pointers, dataSize, pointerCount, 0x7fffffff)
        }

        def isImplicit: Boolean = {
          which == Field.Ordinal.Which.IMPLICIT
        }

        def getImplicit: Void.type = {
          assert(which == Field.Ordinal.Which.IMPLICIT, "Must check which() before get()ing a union member.")
          org.capnproto.Void.VOID
        }

        def setImplicit(value: Void.type) {
          _setShortField(5, Field.Ordinal.Which.IMPLICIT.id.toShort)
        }

        def isExplicit: Boolean = {
          which == Field.Ordinal.Which.EXPLICIT
        }

        def getExplicit: Short = {
          assert(which == Field.Ordinal.Which.EXPLICIT, "Must check which() before get()ing a union member.")
          _getShortField(6)
        }

        def setExplicit(value: Short) {
          _setShortField(5, Field.Ordinal.Which.EXPLICIT.id.toShort)
          _setShortField(6, value)
        }
      }

      final class Reader private[schema](segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends org.capnproto.StructReader(segment, data, pointers, dataSize, pointerCount, nestingLimit) {
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

        def isImplicit: Boolean = {
          which == Field.Ordinal.Which.IMPLICIT
        }

        def getImplicit: Void.type = {
          assert(which == Field.Ordinal.Which.IMPLICIT, "Must check which() before get()ing a union member.")
          org.capnproto.Void.VOID
        }

        def isExplicit: Boolean = {
          which == Field.Ordinal.Which.EXPLICIT
        }

        def getExplicit: Short = {
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

  object Enumerant {
    val STRUCT_SIZE: StructSize = new StructSize(1.toShort, 2.toShort)

    final class Factory() extends org.capnproto.StructFactory[CapnpSchema.Enumerant.Builder, CapnpSchema.Enumerant.Reader] {
      def constructReader(segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): CapnpSchema.Enumerant.Reader = {
        new CapnpSchema.Enumerant.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
      }

      def constructBuilder(segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short): CapnpSchema.Enumerant.Builder = {
        new CapnpSchema.Enumerant.Builder(segment, data, pointers, dataSize, pointerCount)
      }

      def structSize: StructSize = {
        Enumerant.STRUCT_SIZE
      }

      def asReader(builder: CapnpSchema.Enumerant.Builder): CapnpSchema.Enumerant.Reader = {
        builder.asReader
      }
    }

    val factory: CapnpSchema.Enumerant.Factory = new CapnpSchema.Enumerant.Factory
    val listFactory: StructList.Factory[CapnpSchema.Enumerant.Builder, CapnpSchema.Enumerant.Reader] = new StructList.Factory[CapnpSchema.Enumerant.Builder, CapnpSchema.Enumerant.Reader](factory)

    final class Builder private[schema](segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends org.capnproto.StructBuilder(segment, data, pointers, dataSize, pointerCount) {
      def asReader: CapnpSchema.Enumerant.Reader = {
        new CapnpSchema.Enumerant.Reader(segment, data, pointers, dataSize, pointerCount, 0x7fffffff)
      }

      def hasName: Boolean = {
        !_pointerFieldIsNull(0)
      }

      def getName: Text.Builder = {
        _getPointerField(org.capnproto.Text.factory, 0, null, 0, 0)
      }

      def setName(value: Text.Reader) {
        _setPointerField(org.capnproto.Text.factory, 0, value)
      }

      def setName(value: String) {
        _setPointerField(org.capnproto.Text.factory, 0, new Text.Reader(value))
      }

      def initName(size: Int): Text.Builder = {
        _initPointerField(org.capnproto.Text.factory, 0, size)
      }

      def getCodeOrder: Short = {
        _getShortField(0)
      }

      def setCodeOrder(value: Short) {
        _setShortField(0, value)
      }

      def hasAnnotations: Boolean = {
        !_pointerFieldIsNull(1)
      }

      def getAnnotations: StructList.Builder[CapnpSchema.Annotation.Builder] = {
        _getPointerField(CapnpSchema.Annotation.listFactory, 1, null, 0)
      }

      def setAnnotations(value: StructList.Reader[CapnpSchema.Annotation.Reader]) {
        _setPointerField(CapnpSchema.Annotation.listFactory, 1, value)
      }

      def initAnnotations(size: Int): StructList.Builder[CapnpSchema.Annotation.Builder] = {
        _initPointerField(CapnpSchema.Annotation.listFactory, 1, size)
      }
    }

    final class Reader private[schema](segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends org.capnproto.StructReader(segment, data, pointers, dataSize, pointerCount, nestingLimit) {
      def hasName: Boolean = {
        !_pointerFieldIsNull(0)
      }

      def getName: Text.Reader = {
        _getPointerField(org.capnproto.Text.factory, 0, null, 0, 0)
      }

      def getCodeOrder: Short = {
        _getShortField(0)
      }

      def hasAnnotations: Boolean = {
        !_pointerFieldIsNull(1)
      }

      def getAnnotations: StructList.Reader[CapnpSchema.Annotation.Reader] = {
        _getPointerField(CapnpSchema.Annotation.listFactory, 1, null, 0)
      }
    }

  }

  object Superclass {
    val STRUCT_SIZE: StructSize = new StructSize(1.toShort, 1.toShort)

    final class Factory() extends org.capnproto.StructFactory[CapnpSchema.Superclass.Builder, CapnpSchema.Superclass.Reader] {
      def constructReader(segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): CapnpSchema.Superclass.Reader = {
        new CapnpSchema.Superclass.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
      }

      def constructBuilder(segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short): CapnpSchema.Superclass.Builder = {
        new CapnpSchema.Superclass.Builder(segment, data, pointers, dataSize, pointerCount)
      }

      def structSize: StructSize = {
        Superclass.STRUCT_SIZE
      }

      def asReader(builder: CapnpSchema.Superclass.Builder): CapnpSchema.Superclass.Reader = {
        builder.asReader
      }
    }

    val factory: CapnpSchema.Superclass.Factory = new CapnpSchema.Superclass.Factory
    val listFactory: StructList.Factory[CapnpSchema.Superclass.Builder, CapnpSchema.Superclass.Reader] = new StructList.Factory[CapnpSchema.Superclass.Builder, CapnpSchema.Superclass.Reader](factory)

    final class Builder private[schema](segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends org.capnproto.StructBuilder(segment, data, pointers, dataSize, pointerCount) {
      def asReader: CapnpSchema.Superclass.Reader = {
        new CapnpSchema.Superclass.Reader(segment, data, pointers, dataSize, pointerCount, 0x7fffffff)
      }

      def getId: Long = {
        _getLongField(0)
      }

      def setId(value: Long) {
        _setLongField(0, value)
      }

      def getBrand: CapnpSchema.Brand.Builder = {
        _getPointerField(CapnpSchema.Brand.factory, 0, null, 0)
      }

      def setBrand(value: CapnpSchema.Brand.Reader) {
        _setPointerField(CapnpSchema.Brand.factory, 0, value)
      }

      def initBrand: CapnpSchema.Brand.Builder = {
        _initPointerField(CapnpSchema.Brand.factory, 0, 0)
      }
    }

    final class Reader private[schema](segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends org.capnproto.StructReader(segment, data, pointers, dataSize, pointerCount, nestingLimit) {
      def getId: Long = {
        _getLongField(0)
      }

      def hasBrand: Boolean = {
        !_pointerFieldIsNull(0)
      }

      def getBrand: CapnpSchema.Brand.Reader = {
        _getPointerField(CapnpSchema.Brand.factory, 0, null, 0)
      }
    }

  }

  object Method {
    val STRUCT_SIZE: StructSize = new StructSize(3.toShort, 5.toShort)

    final class Factory() extends org.capnproto.StructFactory[CapnpSchema.Method.Builder, CapnpSchema.Method.Reader] {
      def constructReader(segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): CapnpSchema.Method.Reader = {
        new CapnpSchema.Method.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
      }

      def constructBuilder(segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short): CapnpSchema.Method.Builder = {
        new CapnpSchema.Method.Builder(segment, data, pointers, dataSize, pointerCount)
      }

      def structSize: StructSize = {
        Method.STRUCT_SIZE
      }

      def asReader(builder: CapnpSchema.Method.Builder): CapnpSchema.Method.Reader = {
        builder.asReader
      }
    }

    val factory: CapnpSchema.Method.Factory = new CapnpSchema.Method.Factory
    val listFactory: StructList.Factory[CapnpSchema.Method.Builder, CapnpSchema.Method.Reader] = new StructList.Factory[CapnpSchema.Method.Builder, CapnpSchema.Method.Reader](factory)

    final class Builder private[schema](segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends org.capnproto.StructBuilder(segment, data, pointers, dataSize, pointerCount) {
      def asReader: CapnpSchema.Method.Reader = {
        new CapnpSchema.Method.Reader(segment, data, pointers, dataSize, pointerCount, 0x7fffffff)
      }

      def hasName: Boolean = {
        !_pointerFieldIsNull(0)
      }

      def getName: Text.Builder = {
        _getPointerField(org.capnproto.Text.factory, 0, null, 0, 0)
      }

      def setName(value: Text.Reader) {
        _setPointerField(org.capnproto.Text.factory, 0, value)
      }

      def setName(value: String) {
        _setPointerField(org.capnproto.Text.factory, 0, new Text.Reader(value))
      }

      def initName(size: Int): Text.Builder = {
        _initPointerField(org.capnproto.Text.factory, 0, size)
      }

      def getCodeOrder: Short = {
        _getShortField(0)
      }

      def setCodeOrder(value: Short) {
        _setShortField(0, value)
      }

      def getParamStructType: Long = {
        _getLongField(1)
      }

      def setParamStructType(value: Long) {
        _setLongField(1, value)
      }

      def getResultStructType: Long = {
        _getLongField(2)
      }

      def setResultStructType(value: Long) {
        _setLongField(2, value)
      }

      def hasAnnotations: Boolean = {
        !_pointerFieldIsNull(1)
      }

      def getAnnotations: StructList.Builder[CapnpSchema.Annotation.Builder] = {
        _getPointerField(CapnpSchema.Annotation.listFactory, 1, null, 0)
      }

      def setAnnotations(value: StructList.Reader[CapnpSchema.Annotation.Reader]) {
        _setPointerField(CapnpSchema.Annotation.listFactory, 1, value)
      }

      def initAnnotations(size: Int): StructList.Builder[CapnpSchema.Annotation.Builder] = {
        _initPointerField(CapnpSchema.Annotation.listFactory, 1, size)
      }

      def getParamBrand: CapnpSchema.Brand.Builder = {
        _getPointerField(CapnpSchema.Brand.factory, 2, null, 0)
      }

      def setParamBrand(value: CapnpSchema.Brand.Reader) {
        _setPointerField(CapnpSchema.Brand.factory, 2, value)
      }

      def initParamBrand: CapnpSchema.Brand.Builder = {
        _initPointerField(CapnpSchema.Brand.factory, 2, 0)
      }

      def getResultBrand: CapnpSchema.Brand.Builder = {
        _getPointerField(CapnpSchema.Brand.factory, 3, null, 0)
      }

      def setResultBrand(value: CapnpSchema.Brand.Reader) {
        _setPointerField(CapnpSchema.Brand.factory, 3, value)
      }

      def initResultBrand: CapnpSchema.Brand.Builder = {
        _initPointerField(CapnpSchema.Brand.factory, 3, 0)
      }

      def hasImplicitParameters: Boolean = {
        !_pointerFieldIsNull(4)
      }

      def getImplicitParameters: StructList.Builder[CapnpSchema.Node.Parameter.Builder] = {
        _getPointerField(CapnpSchema.Node.Parameter.listFactory, 4, null, 0)
      }

      def setImplicitParameters(value: StructList.Reader[CapnpSchema.Node.Parameter.Reader]) {
        _setPointerField(CapnpSchema.Node.Parameter.listFactory, 4, value)
      }

      def initImplicitParameters(size: Int): StructList.Builder[CapnpSchema.Node.Parameter.Builder] = {
        _initPointerField(CapnpSchema.Node.Parameter.listFactory, 4, size)
      }
    }

    final class Reader private[schema](segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends org.capnproto.StructReader(segment, data, pointers, dataSize, pointerCount, nestingLimit) {
      def hasName: Boolean = {
        !_pointerFieldIsNull(0)
      }

      def getName: Text.Reader = {
        _getPointerField(org.capnproto.Text.factory, 0, null, 0, 0)
      }

      def getCodeOrder: Short = {
        _getShortField(0)
      }

      def getParamStructType: Long = {
        _getLongField(1)
      }

      def getResultStructType: Long = {
        _getLongField(2)
      }

      def hasAnnotations: Boolean = {
        !_pointerFieldIsNull(1)
      }

      def getAnnotations: StructList.Reader[CapnpSchema.Annotation.Reader] = {
        _getPointerField(CapnpSchema.Annotation.listFactory, 1, null, 0)
      }

      def hasParamBrand: Boolean = {
        !_pointerFieldIsNull(2)
      }

      def getParamBrand: CapnpSchema.Brand.Reader = {
        _getPointerField(CapnpSchema.Brand.factory, 2, null, 0)
      }

      def hasResultBrand: Boolean = {
        !_pointerFieldIsNull(3)
      }

      def getResultBrand: CapnpSchema.Brand.Reader = {
        _getPointerField(CapnpSchema.Brand.factory, 3, null, 0)
      }

      def hasImplicitParameters: Boolean = {
        !_pointerFieldIsNull(4)
      }

      def getImplicitParameters: StructList.Reader[CapnpSchema.Node.Parameter.Reader] = {
        _getPointerField(CapnpSchema.Node.Parameter.listFactory, 4, null, 0)
      }
    }

  }

  object Type {
    val STRUCT_SIZE: StructSize = new StructSize(2.toShort, 1.toShort)

    final class Factory() extends org.capnproto.StructFactory[CapnpSchema.Type.Builder, CapnpSchema.Type.Reader] {
      def constructReader(segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): CapnpSchema.Type.Reader = {
        new CapnpSchema.Type.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
      }

      def constructBuilder(segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short): CapnpSchema.Type.Builder = {
        new CapnpSchema.Type.Builder(segment, data, pointers, dataSize, pointerCount)
      }

      def structSize: StructSize = {
        Type.STRUCT_SIZE
      }

      def asReader(builder: CapnpSchema.Type.Builder): CapnpSchema.Type.Reader = {
        builder.asReader
      }
    }

    val factory: CapnpSchema.Type.Factory = new CapnpSchema.Type.Factory
    val listFactory: StructList.Factory[CapnpSchema.Type.Builder, CapnpSchema.Type.Reader] = new StructList.Factory[CapnpSchema.Type.Builder, CapnpSchema.Type.Reader](factory)

    final class Builder private[schema](segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends org.capnproto.StructBuilder(segment, data, pointers, dataSize, pointerCount) {
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

      def asReader: CapnpSchema.Type.Reader = {
        new CapnpSchema.Type.Reader(segment, data, pointers, dataSize, pointerCount, 0x7fffffff)
      }

      def isVoid: Boolean = {
        which == Type.Which.VOID
      }

      def getVoid: Void.type = {
        assert(which == Type.Which.VOID, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def setVoid(value: Void.type) {
        _setShortField(0, Type.Which.VOID.id.toShort)
      }

      def isBool: Boolean = {
        which == Type.Which.BOOL
      }

      def getBool: Void.type = {
        assert(which == Type.Which.BOOL, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def setBool(value: Void.type) {
        _setShortField(0, Type.Which.BOOL.id.toShort)
      }

      def isInt8: Boolean = {
        which == Type.Which.INT8
      }

      def getInt8: Void.type = {
        assert(which == Type.Which.INT8, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def setInt8(value: Void.type) {
        _setShortField(0, Type.Which.INT8.id.toShort)
      }

      def isInt16: Boolean = {
        which == Type.Which.INT16
      }

      def getInt16: Void.type = {
        assert(which == Type.Which.INT16, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def setInt16(value: Void.type) {
        _setShortField(0, Type.Which.INT16.id.toShort)
      }

      def isInt32: Boolean = {
        which == Type.Which.INT32
      }

      def getInt32: Void.type = {
        assert(which == Type.Which.INT32, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def setInt32(value: Void.type) {
        _setShortField(0, Type.Which.INT32.id.toShort)
      }

      def isInt64: Boolean = {
        which == Type.Which.INT64
      }

      def getInt64: Void.type = {
        assert(which == Type.Which.INT64, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def setInt64(value: Void.type) {
        _setShortField(0, Type.Which.INT64.id.toShort)
      }

      def isUint8: Boolean = {
        which == Type.Which.UINT8
      }

      def getUint8: Void.type = {
        assert(which == Type.Which.UINT8, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def setUint8(value: Void.type) {
        _setShortField(0, Type.Which.UINT8.id.toShort)
      }

      def isUint16: Boolean = {
        which == Type.Which.UINT16
      }

      def getUint16: Void.type = {
        assert(which == Type.Which.UINT16, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def setUint16(value: Void.type) {
        _setShortField(0, Type.Which.UINT16.id.toShort)
      }

      def isUint32: Boolean = {
        which == Type.Which.UINT32
      }

      def getUint32: Void.type = {
        assert(which == Type.Which.UINT32, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def setUint32(value: Void.type) {
        _setShortField(0, Type.Which.UINT32.id.toShort)
      }

      def isUint64: Boolean = {
        which == Type.Which.UINT64
      }

      def getUint64: Void.type = {
        assert(which == Type.Which.UINT64, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def setUint64(value: Void.type) {
        _setShortField(0, Type.Which.UINT64.id.toShort)
      }

      def isFloat32: Boolean = {
        which == Type.Which.FLOAT32
      }

      def getFloat32: Void.type = {
        assert(which == Type.Which.FLOAT32, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def setFloat32(value: Void.type) {
        _setShortField(0, Type.Which.FLOAT32.id.toShort)
      }

      def isFloat64: Boolean = {
        which == Type.Which.FLOAT64
      }

      def getFloat64: Void.type = {
        assert(which == Type.Which.FLOAT64, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def setFloat64(value: Void.type) {
        _setShortField(0, Type.Which.FLOAT64.id.toShort)
      }

      def isText: Boolean = {
        which == Type.Which.TEXT
      }

      def getText: Void.type = {
        assert(which == Type.Which.TEXT, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def setText(value: Void.type) {
        _setShortField(0, Type.Which.TEXT.id.toShort)
      }

      def isData: Boolean = {
        which == Type.Which.DATA
      }

      def getData: Void.type = {
        assert(which == Type.Which.DATA, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def setData(value: Void.type) {
        _setShortField(0, Type.Which.DATA.id.toShort)
      }

      def isList: Boolean = {
        which == Type.Which.LIST
      }

      def getList: CapnpSchema.Type.List.Builder = {
        new CapnpSchema.Type.List.Builder(segment, data, pointers, dataSize, pointerCount)
      }

      def initList: CapnpSchema.Type.List.Builder = {
        _setShortField(0, Type.Which.LIST.id.toShort)
        _clearPointerField(0)
        new CapnpSchema.Type.List.Builder(segment, data, pointers, dataSize, pointerCount)
      }

      def isEnum: Boolean = {
        which == Type.Which.ENUM
      }

      def getEnum: CapnpSchema.Type.Enum.Builder = {
        new CapnpSchema.Type.Enum.Builder(segment, data, pointers, dataSize, pointerCount)
      }

      def initEnum: CapnpSchema.Type.Enum.Builder = {
        _setShortField(0, Type.Which.ENUM.id.toShort)
        _setLongField(1, 0L)
        _clearPointerField(0)
        new CapnpSchema.Type.Enum.Builder(segment, data, pointers, dataSize, pointerCount)
      }

      def isStruct: Boolean = {
        which == Type.Which.STRUCT
      }

      def getStruct: CapnpSchema.Type.Struct.Builder = {
        new CapnpSchema.Type.Struct.Builder(segment, data, pointers, dataSize, pointerCount)
      }

      def initStruct: CapnpSchema.Type.Struct.Builder = {
        _setShortField(0, Type.Which.STRUCT.id.toShort)
        _setLongField(1, 0L)
        _clearPointerField(0)
        new CapnpSchema.Type.Struct.Builder(segment, data, pointers, dataSize, pointerCount)
      }

      def isInterface: Boolean = {
        which == Type.Which.INTERFACE
      }

      def getInterface: CapnpSchema.Type.Interface.Builder = {
        new CapnpSchema.Type.Interface.Builder(segment, data, pointers, dataSize, pointerCount)
      }

      def initInterface: CapnpSchema.Type.Interface.Builder = {
        _setShortField(0, Type.Which.INTERFACE.id.toShort)
        _setLongField(1, 0L)
        _clearPointerField(0)
        new CapnpSchema.Type.Interface.Builder(segment, data, pointers, dataSize, pointerCount)
      }

      def isAnyPointer: Boolean = {
        which == Type.Which.ANY_POINTER
      }

      def getAnyPointer: CapnpSchema.Type.AnyPointer.Builder = {
        new CapnpSchema.Type.AnyPointer.Builder(segment, data, pointers, dataSize, pointerCount)
      }

      def initAnyPointer: CapnpSchema.Type.AnyPointer.Builder = {
        _setShortField(0, Type.Which.ANY_POINTER.id.toShort)
        _setShortField(1, 0.toShort)
        _setShortField(2, 0.toShort)
        _setLongField(1, 0L)
        new CapnpSchema.Type.AnyPointer.Builder(segment, data, pointers, dataSize, pointerCount)
      }
    }

    final class Reader private[schema](segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends org.capnproto.StructReader(segment, data, pointers, dataSize, pointerCount, nestingLimit) {
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

      def getVoid: Void.type = {
        assert(which == Type.Which.VOID, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def isBool: Boolean = {
        which == Type.Which.BOOL
      }

      def getBool: Void.type = {
        assert(which == Type.Which.BOOL, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def isInt8: Boolean = {
        which == Type.Which.INT8
      }

      def getInt8: Void.type = {
        assert(which == Type.Which.INT8, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def isInt16: Boolean = {
        which == Type.Which.INT16
      }

      def getInt16: Void.type = {
        assert(which == Type.Which.INT16, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def isInt32: Boolean = {
        which == Type.Which.INT32
      }

      def getInt32: Void.type = {
        assert(which == Type.Which.INT32, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def isInt64: Boolean = {
        which == Type.Which.INT64
      }

      def getInt64: Void.type = {
        assert(which == Type.Which.INT64, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def isUint8: Boolean = {
        which == Type.Which.UINT8
      }

      def getUint8: Void.type = {
        assert(which == Type.Which.UINT8, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def isUint16: Boolean = {
        which == Type.Which.UINT16
      }

      def getUint16: Void.type = {
        assert(which == Type.Which.UINT16, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def isUint32: Boolean = {
        which == Type.Which.UINT32
      }

      def getUint32: Void.type = {
        assert(which == Type.Which.UINT32, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def isUint64: Boolean = {
        which == Type.Which.UINT64
      }

      def getUint64: Void.type = {
        assert(which == Type.Which.UINT64, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def isFloat32: Boolean = {
        which == Type.Which.FLOAT32
      }

      def getFloat32: Void.type = {
        assert(which == Type.Which.FLOAT32, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def isFloat64: Boolean = {
        which == Type.Which.FLOAT64
      }

      def getFloat64: Void.type = {
        assert(which == Type.Which.FLOAT64, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def isText: Boolean = {
        which == Type.Which.TEXT
      }

      def getText: Void.type = {
        assert(which == Type.Which.TEXT, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def isData: Boolean = {
        which == Type.Which.DATA
      }

      def getData: Void.type = {
        assert(which == Type.Which.DATA, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def isList: Boolean = {
        which == Type.Which.LIST
      }

      def getList: CapnpSchema.Type.List.Reader = {
        new CapnpSchema.Type.List.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
      }

      def isEnum: Boolean = {
        which == Type.Which.ENUM
      }

      def getEnum: CapnpSchema.Type.Enum.Reader = {
        new CapnpSchema.Type.Enum.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
      }

      def isStruct: Boolean = {
        which == Type.Which.STRUCT
      }

      def getStruct: CapnpSchema.Type.Struct.Reader = {
        new CapnpSchema.Type.Struct.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
      }

      def isInterface: Boolean = {
        which == Type.Which.INTERFACE
      }

      def getInterface: CapnpSchema.Type.Interface.Reader = {
        new CapnpSchema.Type.Interface.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
      }

      def isAnyPointer: Boolean = {
        which == Type.Which.ANY_POINTER
      }

      def getAnyPointer: CapnpSchema.Type.AnyPointer.Reader = {
        new CapnpSchema.Type.AnyPointer.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
      }
    }

    object Which extends Enumeration {
      type Which = Value
      val VOID, BOOL, INT8, INT16, INT32, INT64, UINT8, UINT16, UINT32, UINT64, FLOAT32, FLOAT64, TEXT, DATA, LIST, ENUM, STRUCT, INTERFACE, ANY_POINTER, _NOT_IN_SCHEMA = Value
    }

    object List {
      val STRUCT_SIZE: StructSize = new StructSize(2.toShort, 1.toShort)

      final class Factory() extends org.capnproto.StructFactory[CapnpSchema.Type.List.Builder, CapnpSchema.Type.List.Reader] {
        def constructReader(segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): CapnpSchema.Type.List.Reader = {
          new CapnpSchema.Type.List.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
        }

        def constructBuilder(segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short): CapnpSchema.Type.List.Builder = {
          new CapnpSchema.Type.List.Builder(segment, data, pointers, dataSize, pointerCount)
        }

        def structSize: StructSize = {
          Type.List.STRUCT_SIZE
        }

        def asReader(builder: CapnpSchema.Type.List.Builder): CapnpSchema.Type.List.Reader = {
          builder.asReader
        }
      }

      val factory: CapnpSchema.Type.List.Factory = new CapnpSchema.Type.List.Factory
      val listFactory: StructList.Factory[CapnpSchema.Type.List.Builder, CapnpSchema.Type.List.Reader] = new StructList.Factory[CapnpSchema.Type.List.Builder, CapnpSchema.Type.List.Reader](factory)

      final class Builder private[schema](segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends org.capnproto.StructBuilder(segment, data, pointers, dataSize, pointerCount) {
        def asReader: CapnpSchema.Type.List.Reader = {
          new CapnpSchema.Type.List.Reader(segment, data, pointers, dataSize, pointerCount, 0x7fffffff)
        }

        def getElementType: CapnpSchema.Type.Builder = {
          _getPointerField(CapnpSchema.Type.factory, 0, null, 0)
        }

        def setElementType(value: CapnpSchema.Type.Reader) {
          _setPointerField(CapnpSchema.Type.factory, 0, value)
        }

        def initElementType: CapnpSchema.Type.Builder = {
          _initPointerField(CapnpSchema.Type.factory, 0, 0)
        }
      }

      final class Reader private[schema](segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends org.capnproto.StructReader(segment, data, pointers, dataSize, pointerCount, nestingLimit) {
        def hasElementType: Boolean = {
          !_pointerFieldIsNull(0)
        }

        def getElementType: CapnpSchema.Type.Reader = {
          _getPointerField(CapnpSchema.Type.factory, 0, null, 0)
        }
      }

    }

    object Enum {
      val STRUCT_SIZE: StructSize = new StructSize(2.toShort, 1.toShort)

      final class Factory() extends org.capnproto.StructFactory[CapnpSchema.Type.Enum.Builder, CapnpSchema.Type.Enum.Reader] {
        def constructReader(segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): CapnpSchema.Type.Enum.Reader = {
          new CapnpSchema.Type.Enum.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
        }

        def constructBuilder(segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short): CapnpSchema.Type.Enum.Builder = {
          new CapnpSchema.Type.Enum.Builder(segment, data, pointers, dataSize, pointerCount)
        }

        def structSize: StructSize = {
          Type.Enum.STRUCT_SIZE
        }

        def asReader(builder: CapnpSchema.Type.Enum.Builder): CapnpSchema.Type.Enum.Reader = {
          builder.asReader
        }
      }

      val factory: CapnpSchema.Type.Enum.Factory = new CapnpSchema.Type.Enum.Factory
      val listFactory: StructList.Factory[CapnpSchema.Type.Enum.Builder, CapnpSchema.Type.Enum.Reader] = new StructList.Factory[CapnpSchema.Type.Enum.Builder, CapnpSchema.Type.Enum.Reader](factory)

      final class Builder private[schema](segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends org.capnproto.StructBuilder(segment, data, pointers, dataSize, pointerCount) {
        def asReader: CapnpSchema.Type.Enum.Reader = {
          new CapnpSchema.Type.Enum.Reader(segment, data, pointers, dataSize, pointerCount, 0x7fffffff)
        }

        def getTypeId: Long = {
          _getLongField(1)
        }

        def setTypeId(value: Long) {
          _setLongField(1, value)
        }

        def getBrand: CapnpSchema.Brand.Builder = {
          _getPointerField(CapnpSchema.Brand.factory, 0, null, 0)
        }

        def setBrand(value: CapnpSchema.Brand.Reader) {
          _setPointerField(CapnpSchema.Brand.factory, 0, value)
        }

        def initBrand: CapnpSchema.Brand.Builder = {
          _initPointerField(CapnpSchema.Brand.factory, 0, 0)
        }
      }

      final class Reader private[schema](segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends org.capnproto.StructReader(segment, data, pointers, dataSize, pointerCount, nestingLimit) {
        def getTypeId: Long = {
          _getLongField(1)
        }

        def hasBrand: Boolean = {
          !_pointerFieldIsNull(0)
        }

        def getBrand: CapnpSchema.Brand.Reader = {
          _getPointerField(CapnpSchema.Brand.factory, 0, null, 0)
        }
      }

    }

    object Struct {
      val STRUCT_SIZE: StructSize = new StructSize(2.toShort, 1.toShort)

      final class Factory() extends org.capnproto.StructFactory[CapnpSchema.Type.Struct.Builder, CapnpSchema.Type.Struct.Reader] {
        def constructReader(segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): CapnpSchema.Type.Struct.Reader = {
          new CapnpSchema.Type.Struct.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
        }

        def constructBuilder(segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short): CapnpSchema.Type.Struct.Builder = {
          new CapnpSchema.Type.Struct.Builder(segment, data, pointers, dataSize, pointerCount)
        }

        def structSize: StructSize = {
          Type.Struct.STRUCT_SIZE
        }

        def asReader(builder: CapnpSchema.Type.Struct.Builder): CapnpSchema.Type.Struct.Reader = {
          builder.asReader
        }
      }

      val factory: CapnpSchema.Type.Struct.Factory = new CapnpSchema.Type.Struct.Factory
      val listFactory: StructList.Factory[CapnpSchema.Type.Struct.Builder, CapnpSchema.Type.Struct.Reader] = new StructList.Factory[CapnpSchema.Type.Struct.Builder, CapnpSchema.Type.Struct.Reader](factory)

      final class Builder private[schema](segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends org.capnproto.StructBuilder(segment, data, pointers, dataSize, pointerCount) {
        def asReader: CapnpSchema.Type.Struct.Reader = {
          new CapnpSchema.Type.Struct.Reader(segment, data, pointers, dataSize, pointerCount, 0x7fffffff)
        }

        def getTypeId: Long = {
          _getLongField(1)
        }

        def setTypeId(value: Long) {
          _setLongField(1, value)
        }

        def getBrand: CapnpSchema.Brand.Builder = {
          _getPointerField(CapnpSchema.Brand.factory, 0, null, 0)
        }

        def setBrand(value: CapnpSchema.Brand.Reader) {
          _setPointerField(CapnpSchema.Brand.factory, 0, value)
        }

        def initBrand: CapnpSchema.Brand.Builder = {
          _initPointerField(CapnpSchema.Brand.factory, 0, 0)
        }
      }

      final class Reader private[schema](segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends org.capnproto.StructReader(segment, data, pointers, dataSize, pointerCount, nestingLimit) {
        def getTypeId: Long = {
          _getLongField(1)
        }

        def hasBrand: Boolean = {
          !_pointerFieldIsNull(0)
        }

        def getBrand: CapnpSchema.Brand.Reader = {
          _getPointerField(CapnpSchema.Brand.factory, 0, null, 0)
        }
      }

    }

    object Interface {
      val STRUCT_SIZE: StructSize = new StructSize(2.toShort, 1.toShort)

      final class Factory() extends org.capnproto.StructFactory[CapnpSchema.Type.Interface.Builder, CapnpSchema.Type.Interface.Reader] {
        def constructReader(segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): CapnpSchema.Type.Interface.Reader = {
          new CapnpSchema.Type.Interface.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
        }

        def constructBuilder(segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short): CapnpSchema.Type.Interface.Builder = {
          new CapnpSchema.Type.Interface.Builder(segment, data, pointers, dataSize, pointerCount)
        }

        def structSize: StructSize = {
          Type.Interface.STRUCT_SIZE
        }

        def asReader(builder: CapnpSchema.Type.Interface.Builder): CapnpSchema.Type.Interface.Reader = {
          builder.asReader
        }
      }

      val factory: CapnpSchema.Type.Interface.Factory = new CapnpSchema.Type.Interface.Factory
      val listFactory: StructList.Factory[CapnpSchema.Type.Interface.Builder, CapnpSchema.Type.Interface.Reader] = new StructList.Factory[CapnpSchema.Type.Interface.Builder, CapnpSchema.Type.Interface.Reader](factory)

      final class Builder private[schema](segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends org.capnproto.StructBuilder(segment, data, pointers, dataSize, pointerCount) {
        def asReader: CapnpSchema.Type.Interface.Reader = {
          new CapnpSchema.Type.Interface.Reader(segment, data, pointers, dataSize, pointerCount, 0x7fffffff)
        }

        def getTypeId: Long = {
          _getLongField(1)
        }

        def setTypeId(value: Long) {
          _setLongField(1, value)
        }

        def getBrand: CapnpSchema.Brand.Builder = {
          _getPointerField(CapnpSchema.Brand.factory, 0, null, 0)
        }

        def setBrand(value: CapnpSchema.Brand.Reader) {
          _setPointerField(CapnpSchema.Brand.factory, 0, value)
        }

        def initBrand: CapnpSchema.Brand.Builder = {
          _initPointerField(CapnpSchema.Brand.factory, 0, 0)
        }
      }

      final class Reader private[schema](segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends org.capnproto.StructReader(segment, data, pointers, dataSize, pointerCount, nestingLimit) {
        def getTypeId: Long = {
          _getLongField(1)
        }

        def hasBrand: Boolean = {
          !_pointerFieldIsNull(0)
        }

        def getBrand: CapnpSchema.Brand.Reader = {
          _getPointerField(CapnpSchema.Brand.factory, 0, null, 0)
        }
      }

    }

    object AnyPointer {
      val STRUCT_SIZE: StructSize = new StructSize(2.toShort, 1.toShort)

      final class Factory() extends org.capnproto.StructFactory[CapnpSchema.Type.AnyPointer.Builder, CapnpSchema.Type.AnyPointer.Reader] {
        def constructReader(segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): CapnpSchema.Type.AnyPointer.Reader = {
          new CapnpSchema.Type.AnyPointer.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
        }

        def constructBuilder(segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short): CapnpSchema.Type.AnyPointer.Builder = {
          new CapnpSchema.Type.AnyPointer.Builder(segment, data, pointers, dataSize, pointerCount)
        }

        def structSize: StructSize = {
          Type.AnyPointer.STRUCT_SIZE
        }

        def asReader(builder: CapnpSchema.Type.AnyPointer.Builder): CapnpSchema.Type.AnyPointer.Reader = {
          builder.asReader
        }
      }

      val factory: CapnpSchema.Type.AnyPointer.Factory = new CapnpSchema.Type.AnyPointer.Factory
      val listFactory: StructList.Factory[CapnpSchema.Type.AnyPointer.Builder, CapnpSchema.Type.AnyPointer.Reader] = new StructList.Factory[CapnpSchema.Type.AnyPointer.Builder, CapnpSchema.Type.AnyPointer.Reader](factory)

      final class Builder private[schema](segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends org.capnproto.StructBuilder(segment, data, pointers, dataSize, pointerCount) {
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

        def asReader: CapnpSchema.Type.AnyPointer.Reader = {
          new CapnpSchema.Type.AnyPointer.Reader(segment, data, pointers, dataSize, pointerCount, 0x7fffffff)
        }

        def isUnconstrained: Boolean = {
          which == Type.AnyPointer.Which.UNCONSTRAINED
        }

        def getUnconstrained: CapnpSchema.Type.AnyPointer.Unconstrained.Builder = {
          new CapnpSchema.Type.AnyPointer.Unconstrained.Builder(segment, data, pointers, dataSize, pointerCount)
        }

        def initUnconstrained: CapnpSchema.Type.AnyPointer.Unconstrained.Builder = {
          _setShortField(2, Type.AnyPointer.Which.UNCONSTRAINED.id.toShort)
          _setShortField(1, 0.toShort)
          new CapnpSchema.Type.AnyPointer.Unconstrained.Builder(segment, data, pointers, dataSize, pointerCount)
        }

        def isParameter: Boolean = {
          which == Type.AnyPointer.Which.PARAMETER
        }

        def getParameter: CapnpSchema.Type.AnyPointer.Parameter.Builder = {
          new CapnpSchema.Type.AnyPointer.Parameter.Builder(segment, data, pointers, dataSize, pointerCount)
        }

        def initParameter: CapnpSchema.Type.AnyPointer.Parameter.Builder = {
          _setShortField(2, Type.AnyPointer.Which.PARAMETER.id.toShort)
          _setShortField(1, 0.toShort)
          _setLongField(1, 0L)
          new CapnpSchema.Type.AnyPointer.Parameter.Builder(segment, data, pointers, dataSize, pointerCount)
        }

        def isImplicitMethodParameter: Boolean = {
          which == Type.AnyPointer.Which.IMPLICIT_METHOD_PARAMETER
        }

        def getImplicitMethodParameter: CapnpSchema.Type.AnyPointer.ImplicitMethodParameter.Builder = {
          new CapnpSchema.Type.AnyPointer.ImplicitMethodParameter.Builder(segment, data, pointers, dataSize, pointerCount)
        }

        def initImplicitMethodParameter: CapnpSchema.Type.AnyPointer.ImplicitMethodParameter.Builder = {
          _setShortField(2, Type.AnyPointer.Which.IMPLICIT_METHOD_PARAMETER.id.toShort)
          _setShortField(1, 0.toShort)
          new CapnpSchema.Type.AnyPointer.ImplicitMethodParameter.Builder(segment, data, pointers, dataSize, pointerCount)
        }
      }

      final class Reader private[schema](segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends org.capnproto.StructReader(segment, data, pointers, dataSize, pointerCount, nestingLimit) {
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

        def getUnconstrained: CapnpSchema.Type.AnyPointer.Unconstrained.Reader = {
          new CapnpSchema.Type.AnyPointer.Unconstrained.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
        }

        def isParameter: Boolean = {
          which == Type.AnyPointer.Which.PARAMETER
        }

        def getParameter: CapnpSchema.Type.AnyPointer.Parameter.Reader = {
          new CapnpSchema.Type.AnyPointer.Parameter.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
        }

        def isImplicitMethodParameter: Boolean = {
          which == Type.AnyPointer.Which.IMPLICIT_METHOD_PARAMETER
        }

        def getImplicitMethodParameter: CapnpSchema.Type.AnyPointer.ImplicitMethodParameter.Reader = {
          new CapnpSchema.Type.AnyPointer.ImplicitMethodParameter.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
        }
      }

      object Which extends Enumeration {
        type Which = Value
        val UNCONSTRAINED, PARAMETER, IMPLICIT_METHOD_PARAMETER, _NOT_IN_SCHEMA = Value
      }

      object Unconstrained {
        val STRUCT_SIZE: StructSize = new StructSize(2.toShort, 1.toShort)

        final class Factory() extends org.capnproto.StructFactory[CapnpSchema.Type.AnyPointer.Unconstrained.Builder, CapnpSchema.Type.AnyPointer.Unconstrained.Reader] {
          def constructReader(segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): CapnpSchema.Type.AnyPointer.Unconstrained.Reader = {
            new CapnpSchema.Type.AnyPointer.Unconstrained.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
          }

          def constructBuilder(segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short): CapnpSchema.Type.AnyPointer.Unconstrained.Builder = {
            new CapnpSchema.Type.AnyPointer.Unconstrained.Builder(segment, data, pointers, dataSize, pointerCount)
          }

          def structSize: StructSize = {
            Type.AnyPointer.Unconstrained.STRUCT_SIZE
          }

          def asReader(builder: CapnpSchema.Type.AnyPointer.Unconstrained.Builder): CapnpSchema.Type.AnyPointer.Unconstrained.Reader = {
            builder.asReader
          }
        }

        val factory: CapnpSchema.Type.AnyPointer.Unconstrained.Factory = new CapnpSchema.Type.AnyPointer.Unconstrained.Factory
        val listFactory: StructList.Factory[CapnpSchema.Type.AnyPointer.Unconstrained.Builder, CapnpSchema.Type.AnyPointer.Unconstrained.Reader] = new StructList.Factory[CapnpSchema.Type.AnyPointer.Unconstrained.Builder, CapnpSchema.Type.AnyPointer.Unconstrained.Reader](factory)

        final class Builder private[schema](segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends org.capnproto.StructBuilder(segment, data, pointers, dataSize, pointerCount) {
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

          def asReader: CapnpSchema.Type.AnyPointer.Unconstrained.Reader = {
            new CapnpSchema.Type.AnyPointer.Unconstrained.Reader(segment, data, pointers, dataSize, pointerCount, 0x7fffffff)
          }

          def isAnyKind: Boolean = {
            which == Type.AnyPointer.Unconstrained.Which.ANY_KIND
          }

          def getAnyKind: Void.type = {
            assert(which == Type.AnyPointer.Unconstrained.Which.ANY_KIND, "Must check which() before get()ing a union member.")
            org.capnproto.Void.VOID
          }

          def setAnyKind(value: Void.type) {
            _setShortField(1, Type.AnyPointer.Unconstrained.Which.ANY_KIND.id.toShort)
          }

          def isStruct: Boolean = {
            which == Type.AnyPointer.Unconstrained.Which.STRUCT
          }

          def getStruct: Void.type = {
            assert(which == Type.AnyPointer.Unconstrained.Which.STRUCT, "Must check which() before get()ing a union member.")
            org.capnproto.Void.VOID
          }

          def setStruct(value: Void.type) {
            _setShortField(1, Type.AnyPointer.Unconstrained.Which.STRUCT.id.toShort)
          }

          def isList: Boolean = {
            which == Type.AnyPointer.Unconstrained.Which.LIST
          }

          def getList: Void.type = {
            assert(which == Type.AnyPointer.Unconstrained.Which.LIST, "Must check which() before get()ing a union member.")
            org.capnproto.Void.VOID
          }

          def setList(value: Void.type) {
            _setShortField(1, Type.AnyPointer.Unconstrained.Which.LIST.id.toShort)
          }

          def isCapability: Boolean = {
            which == Type.AnyPointer.Unconstrained.Which.CAPABILITY
          }

          def getCapability: Void.type = {
            assert(which == Type.AnyPointer.Unconstrained.Which.CAPABILITY, "Must check which() before get()ing a union member.")
            org.capnproto.Void.VOID
          }

          def setCapability(value: Void.type) {
            _setShortField(1, Type.AnyPointer.Unconstrained.Which.CAPABILITY.id.toShort)
          }
        }

        final class Reader private[schema](segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends org.capnproto.StructReader(segment, data, pointers, dataSize, pointerCount, nestingLimit) {
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

          def getAnyKind: Void.type = {
            assert(which == Type.AnyPointer.Unconstrained.Which.ANY_KIND, "Must check which() before get()ing a union member.")
            org.capnproto.Void.VOID
          }

          def isStruct: Boolean = {
            which == Type.AnyPointer.Unconstrained.Which.STRUCT
          }

          def getStruct: Void.type = {
            assert(which == Type.AnyPointer.Unconstrained.Which.STRUCT, "Must check which() before get()ing a union member.")
            org.capnproto.Void.VOID
          }

          def isList: Boolean = {
            which == Type.AnyPointer.Unconstrained.Which.LIST
          }

          def getList: Void.type = {
            assert(which == Type.AnyPointer.Unconstrained.Which.LIST, "Must check which() before get()ing a union member.")
            org.capnproto.Void.VOID
          }

          def isCapability: Boolean = {
            which == Type.AnyPointer.Unconstrained.Which.CAPABILITY
          }

          def getCapability: Void.type = {
            assert(which == Type.AnyPointer.Unconstrained.Which.CAPABILITY, "Must check which() before get()ing a union member.")
            org.capnproto.Void.VOID
          }
        }

        object Which extends Enumeration {
          type Which = Value
          val ANY_KIND, STRUCT, LIST, CAPABILITY, _NOT_IN_SCHEMA = Value
        }

      }

      object Parameter {
        val STRUCT_SIZE: StructSize = new StructSize(2.toShort, 1.toShort)

        final class Factory() extends org.capnproto.StructFactory[CapnpSchema.Type.AnyPointer.Parameter.Builder, CapnpSchema.Type.AnyPointer.Parameter.Reader] {
          def constructReader(segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): CapnpSchema.Type.AnyPointer.Parameter.Reader = {
            new CapnpSchema.Type.AnyPointer.Parameter.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
          }

          def constructBuilder(segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short): CapnpSchema.Type.AnyPointer.Parameter.Builder = {
            new CapnpSchema.Type.AnyPointer.Parameter.Builder(segment, data, pointers, dataSize, pointerCount)
          }

          def structSize: StructSize = {
            Type.AnyPointer.Parameter.STRUCT_SIZE
          }

          def asReader(builder: CapnpSchema.Type.AnyPointer.Parameter.Builder): CapnpSchema.Type.AnyPointer.Parameter.Reader = {
            builder.asReader
          }
        }

        val factory: CapnpSchema.Type.AnyPointer.Parameter.Factory = new CapnpSchema.Type.AnyPointer.Parameter.Factory
        val listFactory: StructList.Factory[CapnpSchema.Type.AnyPointer.Parameter.Builder, CapnpSchema.Type.AnyPointer.Parameter.Reader] = new StructList.Factory[CapnpSchema.Type.AnyPointer.Parameter.Builder, CapnpSchema.Type.AnyPointer.Parameter.Reader](factory)

        final class Builder private[schema](segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends org.capnproto.StructBuilder(segment, data, pointers, dataSize, pointerCount) {
          def asReader: CapnpSchema.Type.AnyPointer.Parameter.Reader = {
            new CapnpSchema.Type.AnyPointer.Parameter.Reader(segment, data, pointers, dataSize, pointerCount, 0x7fffffff)
          }

          def getScopeId: Long = {
            _getLongField(1)
          }

          def setScopeId(value: Long) {
            _setLongField(1, value)
          }

          def getParameterIndex: Short = {
            _getShortField(1)
          }

          def setParameterIndex(value: Short) {
            _setShortField(1, value)
          }
        }

        final class Reader private[schema](segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends org.capnproto.StructReader(segment, data, pointers, dataSize, pointerCount, nestingLimit) {
          def getScopeId: Long = {
            _getLongField(1)
          }

          def getParameterIndex: Short = {
            _getShortField(1)
          }
        }

      }

      object ImplicitMethodParameter {
        val STRUCT_SIZE: StructSize = new StructSize(2.toShort, 1.toShort)

        final class Factory() extends org.capnproto.StructFactory[CapnpSchema.Type.AnyPointer.ImplicitMethodParameter.Builder, CapnpSchema.Type.AnyPointer.ImplicitMethodParameter.Reader] {
          def constructReader(segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): CapnpSchema.Type.AnyPointer.ImplicitMethodParameter.Reader = {
            new CapnpSchema.Type.AnyPointer.ImplicitMethodParameter.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
          }

          def constructBuilder(segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short): CapnpSchema.Type.AnyPointer.ImplicitMethodParameter.Builder = {
            new CapnpSchema.Type.AnyPointer.ImplicitMethodParameter.Builder(segment, data, pointers, dataSize, pointerCount)
          }

          def structSize: StructSize = {
            Type.AnyPointer.ImplicitMethodParameter.STRUCT_SIZE
          }

          def asReader(builder: CapnpSchema.Type.AnyPointer.ImplicitMethodParameter.Builder): CapnpSchema.Type.AnyPointer.ImplicitMethodParameter.Reader = {
            builder.asReader
          }
        }

        val factory: CapnpSchema.Type.AnyPointer.ImplicitMethodParameter.Factory = new CapnpSchema.Type.AnyPointer.ImplicitMethodParameter.Factory
        val listFactory: StructList.Factory[CapnpSchema.Type.AnyPointer.ImplicitMethodParameter.Builder, CapnpSchema.Type.AnyPointer.ImplicitMethodParameter.Reader] = new StructList.Factory[CapnpSchema.Type.AnyPointer.ImplicitMethodParameter.Builder, CapnpSchema.Type.AnyPointer.ImplicitMethodParameter.Reader](factory)

        final class Builder private[schema](segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends org.capnproto.StructBuilder(segment, data, pointers, dataSize, pointerCount) {
          def asReader: CapnpSchema.Type.AnyPointer.ImplicitMethodParameter.Reader = {
            new CapnpSchema.Type.AnyPointer.ImplicitMethodParameter.Reader(segment, data, pointers, dataSize, pointerCount, 0x7fffffff)
          }

          def getParameterIndex: Short = {
            _getShortField(1)
          }

          def setParameterIndex(value: Short) {
            _setShortField(1, value)
          }
        }

        final class Reader private[schema](segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends org.capnproto.StructReader(segment, data, pointers, dataSize, pointerCount, nestingLimit) {
          def getParameterIndex: Short = {
            _getShortField(1)
          }
        }

      }

    }

  }

  object Brand {
    val STRUCT_SIZE: StructSize = new StructSize(0.toShort, 1.toShort)

    final class Factory() extends org.capnproto.StructFactory[CapnpSchema.Brand.Builder, CapnpSchema.Brand.Reader] {
      def constructReader(segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): CapnpSchema.Brand.Reader = {
        new CapnpSchema.Brand.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
      }

      def constructBuilder(segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short): CapnpSchema.Brand.Builder = {
        new CapnpSchema.Brand.Builder(segment, data, pointers, dataSize, pointerCount)
      }

      def structSize: StructSize = {
        Brand.STRUCT_SIZE
      }

      def asReader(builder: CapnpSchema.Brand.Builder): CapnpSchema.Brand.Reader = {
        builder.asReader
      }
    }

    val factory: CapnpSchema.Brand.Factory = new CapnpSchema.Brand.Factory
    val listFactory: StructList.Factory[CapnpSchema.Brand.Builder, CapnpSchema.Brand.Reader] = new StructList.Factory[CapnpSchema.Brand.Builder, CapnpSchema.Brand.Reader](factory)

    final class Builder private[schema](segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends org.capnproto.StructBuilder(segment, data, pointers, dataSize, pointerCount) {
      def asReader: CapnpSchema.Brand.Reader = {
        new CapnpSchema.Brand.Reader(segment, data, pointers, dataSize, pointerCount, 0x7fffffff)
      }

      def hasScopes: Boolean = {
        !_pointerFieldIsNull(0)
      }

      def getScopes: StructList.Builder[CapnpSchema.Brand.Scope.Builder] = {
        _getPointerField(CapnpSchema.Brand.Scope.listFactory, 0, null, 0)
      }

      def setScopes(value: StructList.Reader[CapnpSchema.Brand.Scope.Reader]) {
        _setPointerField(CapnpSchema.Brand.Scope.listFactory, 0, value)
      }

      def initScopes(size: Int): StructList.Builder[CapnpSchema.Brand.Scope.Builder] = {
        _initPointerField(CapnpSchema.Brand.Scope.listFactory, 0, size)
      }
    }

    final class Reader private[schema](segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends org.capnproto.StructReader(segment, data, pointers, dataSize, pointerCount, nestingLimit) {
      def hasScopes: Boolean = {
        !_pointerFieldIsNull(0)
      }

      def getScopes: StructList.Reader[CapnpSchema.Brand.Scope.Reader] = {
        _getPointerField(CapnpSchema.Brand.Scope.listFactory, 0, null, 0)
      }
    }

    object Scope {
      val STRUCT_SIZE: StructSize = new StructSize(2.toShort, 1.toShort)

      final class Factory() extends org.capnproto.StructFactory[CapnpSchema.Brand.Scope.Builder, CapnpSchema.Brand.Scope.Reader] {
        def constructReader(segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): CapnpSchema.Brand.Scope.Reader = {
          new CapnpSchema.Brand.Scope.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
        }

        def constructBuilder(segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short): CapnpSchema.Brand.Scope.Builder = {
          new CapnpSchema.Brand.Scope.Builder(segment, data, pointers, dataSize, pointerCount)
        }

        def structSize: StructSize = {
          Brand.Scope.STRUCT_SIZE
        }

        def asReader(builder: CapnpSchema.Brand.Scope.Builder): CapnpSchema.Brand.Scope.Reader = {
          builder.asReader
        }
      }

      val factory: CapnpSchema.Brand.Scope.Factory = new CapnpSchema.Brand.Scope.Factory
      val listFactory: StructList.Factory[CapnpSchema.Brand.Scope.Builder, CapnpSchema.Brand.Scope.Reader] = new StructList.Factory[CapnpSchema.Brand.Scope.Builder, CapnpSchema.Brand.Scope.Reader](factory)

      final class Builder private[schema](segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends org.capnproto.StructBuilder(segment, data, pointers, dataSize, pointerCount) {
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

        def asReader: CapnpSchema.Brand.Scope.Reader = {
          new CapnpSchema.Brand.Scope.Reader(segment, data, pointers, dataSize, pointerCount, 0x7fffffff)
        }

        def getScopeId: Long = {
          _getLongField(0)
        }

        def setScopeId(value: Long) {
          _setLongField(0, value)
        }

        def isBind: Boolean = {
          which == Brand.Scope.Which.BIND
        }

        def hasBind: Boolean = {
          !_pointerFieldIsNull(0)
        }

        def getBind: StructList.Builder[CapnpSchema.Brand.Binding.Builder] = {
          _getPointerField(CapnpSchema.Brand.Binding.listFactory, 0, null, 0)
        }

        def setBind(value: StructList.Reader[CapnpSchema.Brand.Binding.Reader]) {
          _setPointerField(CapnpSchema.Brand.Binding.listFactory, 0, value)
        }

        def initBind(size: Int): StructList.Builder[CapnpSchema.Brand.Binding.Builder] = {
          _initPointerField(CapnpSchema.Brand.Binding.listFactory, 0, size)
        }

        def isInherit: Boolean = {
          which == Brand.Scope.Which.INHERIT
        }

        def getInherit: Void.type = {
          assert(which == Brand.Scope.Which.INHERIT, "Must check which() before get()ing a union member.")
          org.capnproto.Void.VOID
        }

        def setInherit(value: Void.type) {
          _setShortField(4, Brand.Scope.Which.INHERIT.id.toShort)
        }
      }

      final class Reader private[schema](segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends org.capnproto.StructReader(segment, data, pointers, dataSize, pointerCount, nestingLimit) {
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

        def getScopeId: Long = {
          _getLongField(0)
        }

        def isBind: Boolean = {
          which == Brand.Scope.Which.BIND
        }

        def hasBind: Boolean = {
          !_pointerFieldIsNull(0)
        }

        def getBind: StructList.Reader[CapnpSchema.Brand.Binding.Reader] = {
          _getPointerField(CapnpSchema.Brand.Binding.listFactory, 0, null, 0)
        }

        def isInherit: Boolean = {
          which == Brand.Scope.Which.INHERIT
        }

        def getInherit: Void.type = {
          assert(which == Brand.Scope.Which.INHERIT, "Must check which() before get()ing a union member.")
          org.capnproto.Void.VOID
        }
      }

      object Which extends Enumeration {
        type Which = Value
        val BIND, INHERIT, _NOT_IN_SCHEMA = Value
      }

    }

    object Binding {
      val STRUCT_SIZE: StructSize = new StructSize(1.toShort, 1.toShort)

      final class Factory() extends org.capnproto.StructFactory[CapnpSchema.Brand.Binding.Builder, CapnpSchema.Brand.Binding.Reader] {
        def constructReader(segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): CapnpSchema.Brand.Binding.Reader = {
          new CapnpSchema.Brand.Binding.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
        }

        def constructBuilder(segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short): CapnpSchema.Brand.Binding.Builder = {
          new CapnpSchema.Brand.Binding.Builder(segment, data, pointers, dataSize, pointerCount)
        }

        def structSize: StructSize = {
          Brand.Binding.STRUCT_SIZE
        }

        def asReader(builder: CapnpSchema.Brand.Binding.Builder): CapnpSchema.Brand.Binding.Reader = {
          builder.asReader
        }
      }

      val factory: CapnpSchema.Brand.Binding.Factory = new CapnpSchema.Brand.Binding.Factory
      val listFactory: StructList.Factory[CapnpSchema.Brand.Binding.Builder, CapnpSchema.Brand.Binding.Reader] = new StructList.Factory[CapnpSchema.Brand.Binding.Builder, CapnpSchema.Brand.Binding.Reader](factory)

      final class Builder private[schema](segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends org.capnproto.StructBuilder(segment, data, pointers, dataSize, pointerCount) {
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

        def asReader: CapnpSchema.Brand.Binding.Reader = {
          new CapnpSchema.Brand.Binding.Reader(segment, data, pointers, dataSize, pointerCount, 0x7fffffff)
        }

        def isUnbound: Boolean = {
          which == Brand.Binding.Which.UNBOUND
        }

        def getUnbound: Void.type = {
          assert(which == Brand.Binding.Which.UNBOUND, "Must check which() before get()ing a union member.")
          org.capnproto.Void.VOID
        }

        def setUnbound(value: Void.type) {
          _setShortField(0, Brand.Binding.Which.UNBOUND.id.toShort)
        }

        def isType: Boolean = {
          which == Brand.Binding.Which.TYPE
        }

        def getType: CapnpSchema.Type.Builder = {
          assert(which == Brand.Binding.Which.TYPE, "Must check which() before get()ing a union member.")
          _getPointerField(CapnpSchema.Type.factory, 0, null, 0)
        }

        def setType(value: CapnpSchema.Type.Reader) {
          _setShortField(0, Brand.Binding.Which.TYPE.id.toShort)
          _setPointerField(CapnpSchema.Type.factory, 0, value)
        }

        def initType: CapnpSchema.Type.Builder = {
          _setShortField(0, Brand.Binding.Which.TYPE.id.toShort)
          _initPointerField(CapnpSchema.Type.factory, 0, 0)
        }
      }

      final class Reader private[schema](segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends org.capnproto.StructReader(segment, data, pointers, dataSize, pointerCount, nestingLimit) {
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

        def getUnbound: Void.type = {
          assert(which == Brand.Binding.Which.UNBOUND, "Must check which() before get()ing a union member.")
          org.capnproto.Void.VOID
        }

        def isType: Boolean = {
          which == Brand.Binding.Which.TYPE
        }

        def hasType: Boolean = {
          !_pointerFieldIsNull(0)
        }

        def getType: CapnpSchema.Type.Reader = {
          assert(which == Brand.Binding.Which.TYPE, "Must check which() before get()ing a union member.")
          _getPointerField(CapnpSchema.Type.factory, 0, null, 0)
        }
      }

      object Which extends Enumeration {
        type Which = Value
        val UNBOUND, TYPE, _NOT_IN_SCHEMA = Value
      }

    }

  }

  object Value {
    val STRUCT_SIZE: StructSize = new StructSize(2.toShort, 1.toShort)

    final class Factory() extends org.capnproto.StructFactory[CapnpSchema.Value.Builder, CapnpSchema.Value.Reader] {
      def constructReader(segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): CapnpSchema.Value.Reader = {
        new CapnpSchema.Value.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
      }

      def constructBuilder(segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short): CapnpSchema.Value.Builder = {
        new CapnpSchema.Value.Builder(segment, data, pointers, dataSize, pointerCount)
      }

      def structSize: StructSize = {
        Value.STRUCT_SIZE
      }

      def asReader(builder: CapnpSchema.Value.Builder): CapnpSchema.Value.Reader = {
        builder.asReader
      }
    }

    val factory: CapnpSchema.Value.Factory = new CapnpSchema.Value.Factory
    val listFactory: StructList.Factory[CapnpSchema.Value.Builder, CapnpSchema.Value.Reader] = new StructList.Factory[CapnpSchema.Value.Builder, CapnpSchema.Value.Reader](factory)

    final class Builder private[schema](segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends org.capnproto.StructBuilder(segment, data, pointers, dataSize, pointerCount) {
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

      def asReader: CapnpSchema.Value.Reader = {
        new CapnpSchema.Value.Reader(segment, data, pointers, dataSize, pointerCount, 0x7fffffff)
      }

      def isVoid: Boolean = {
        which == Value.Which.VOID
      }

      def getVoid: Void.type = {
        assert(which == Value.Which.VOID, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def setVoid(value: Void.type) {
        _setShortField(0, Value.Which.VOID.id.toShort)
      }

      def isBool: Boolean = {
        which == Value.Which.BOOL
      }

      def getBool: Boolean = {
        assert(which == Value.Which.BOOL, "Must check which() before get()ing a union member.")
        _getBooleanField(16)
      }

      def setBool(value: Boolean) {
        _setShortField(0, Value.Which.BOOL.id.toShort)
        _setBooleanField(16, value)
      }

      def isInt8: Boolean = {
        which == Value.Which.INT8
      }

      def getInt8: Byte = {
        assert(which == Value.Which.INT8, "Must check which() before get()ing a union member.")
        _getByteField(2)
      }

      def setInt8(value: Byte) {
        _setShortField(0, Value.Which.INT8.id.toShort)
        _setByteField(2, value)
      }

      def isInt16: Boolean = {
        which == Value.Which.INT16
      }

      def getInt16: Short = {
        assert(which == Value.Which.INT16, "Must check which() before get()ing a union member.")
        _getShortField(1)
      }

      def setInt16(value: Short) {
        _setShortField(0, Value.Which.INT16.id.toShort)
        _setShortField(1, value)
      }

      def isInt32: Boolean = {
        which == Value.Which.INT32
      }

      def getInt32: Int = {
        assert(which == Value.Which.INT32, "Must check which() before get()ing a union member.")
        _getIntField(1)
      }

      def setInt32(value: Int) {
        _setShortField(0, Value.Which.INT32.id.toShort)
        _setIntField(1, value)
      }

      def isInt64: Boolean = {
        which == Value.Which.INT64
      }

      def getInt64: Long = {
        assert(which == Value.Which.INT64, "Must check which() before get()ing a union member.")
        _getLongField(1)
      }

      def setInt64(value: Long) {
        _setShortField(0, Value.Which.INT64.id.toShort)
        _setLongField(1, value)
      }

      def isUint8: Boolean = {
        which == Value.Which.UINT8
      }

      def getUint8: Byte = {
        assert(which == Value.Which.UINT8, "Must check which() before get()ing a union member.")
        _getByteField(2)
      }

      def setUint8(value: Byte) {
        _setShortField(0, Value.Which.UINT8.id.toShort)
        _setByteField(2, value)
      }

      def isUint16: Boolean = {
        which == Value.Which.UINT16
      }

      def getUint16: Short = {
        assert(which == Value.Which.UINT16, "Must check which() before get()ing a union member.")
        _getShortField(1)
      }

      def setUint16(value: Short) {
        _setShortField(0, Value.Which.UINT16.id.toShort)
        _setShortField(1, value)
      }

      def isUint32: Boolean = {
        which == Value.Which.UINT32
      }

      def getUint32: Int = {
        assert(which == Value.Which.UINT32, "Must check which() before get()ing a union member.")
        _getIntField(1)
      }

      def setUint32(value: Int) {
        _setShortField(0, Value.Which.UINT32.id.toShort)
        _setIntField(1, value)
      }

      def isUint64: Boolean = {
        which == Value.Which.UINT64
      }

      def getUint64: Long = {
        assert(which == Value.Which.UINT64, "Must check which() before get()ing a union member.")
        _getLongField(1)
      }

      def setUint64(value: Long) {
        _setShortField(0, Value.Which.UINT64.id.toShort)
        _setLongField(1, value)
      }

      def isFloat32: Boolean = {
        which == Value.Which.FLOAT32
      }

      def getFloat32: Float = {
        assert(which == Value.Which.FLOAT32, "Must check which() before get()ing a union member.")
        _getFloatField(1)
      }

      def setFloat32(value: Float) {
        _setShortField(0, Value.Which.FLOAT32.id.toShort)
        _setFloatField(1, value)
      }

      def isFloat64: Boolean = {
        which == Value.Which.FLOAT64
      }

      def getFloat64: Double = {
        assert(which == Value.Which.FLOAT64, "Must check which() before get()ing a union member.")
        _getDoubleField(1)
      }

      def setFloat64(value: Double) {
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

      def getText: Text.Builder = {
        _getPointerField(org.capnproto.Text.factory, 0, null, 0, 0)
      }

      def setText(value: Text.Reader) {
        _setShortField(0, Value.Which.TEXT.id.toShort)
        _setPointerField(org.capnproto.Text.factory, 0, value)
      }

      def setText(value: String) {
        _setShortField(0, Value.Which.TEXT.id.toShort)
        _setPointerField(org.capnproto.Text.factory, 0, new Text.Reader(value))
      }

      def initText(size: Int): Text.Builder = {
        _initPointerField(org.capnproto.Text.factory, 0, size)
      }

      def isData: Boolean = {
        which == Value.Which.DATA
      }

      def hasData: Boolean = {
        if (which != Value.Which.DATA) return false
        !_pointerFieldIsNull(0)
      }

      def getData: Data.Builder = {
        _getPointerField(org.capnproto.Data.factory, 0, null, 0, 0)
      }

      def setData(value: Data.Reader) {
        _setShortField(0, Value.Which.DATA.id.toShort)
        _setPointerField(org.capnproto.Data.factory, 0, value)
      }

      def setData(value: Array[Byte]) {
        _setShortField(0, Value.Which.DATA.id.toShort)
        _setPointerField(org.capnproto.Data.factory, 0, new Data.Reader(value))
      }

      def initData(size: Int): Data.Builder = {
        _initPointerField(org.capnproto.Data.factory, 0, size)
      }

      def isList: Boolean = {
        which == Value.Which.LIST
      }

      def hasList: Boolean = {
        !_pointerFieldIsNull(0)
      }

      def getList: AnyPointer.Builder = {
        assert(which == Value.Which.LIST, "Must check which() before get()ing a union member.")
        _getPointerField(org.capnproto.AnyPointer.factory, 0)
      }

      def initList: AnyPointer.Builder = {
        _setShortField(0, Value.Which.LIST.id.toShort)
        _initPointerField(org.capnproto.AnyPointer.factory, 0, 0)
      }

      def initList(size: Int): AnyPointer.Builder = {
        _setShortField(0, Value.Which.LIST.id.toShort)
        _initPointerField(org.capnproto.AnyPointer.factory, 0, size)
      }

      def isEnum: Boolean = {
        which == Value.Which.ENUM
      }

      def getEnum: Short = {
        assert(which == Value.Which.ENUM, "Must check which() before get()ing a union member.")
        _getShortField(1)
      }

      def setEnum(value: Short) {
        _setShortField(0, Value.Which.ENUM.id.toShort)
        _setShortField(1, value)
      }

      def isStruct: Boolean = {
        which == Value.Which.STRUCT
      }

      def hasStruct: Boolean = {
        !_pointerFieldIsNull(0)
      }

      def getStruct: AnyPointer.Builder = {
        assert(which == Value.Which.STRUCT, "Must check which() before get()ing a union member.")
        _getPointerField(org.capnproto.AnyPointer.factory, 0)
      }

      def initStruct: AnyPointer.Builder = {
        _setShortField(0, Value.Which.STRUCT.id.toShort)
        _initPointerField(org.capnproto.AnyPointer.factory, 0, 0)
      }

      def initStruct(size: Int): AnyPointer.Builder = {
        _setShortField(0, Value.Which.STRUCT.id.toShort)
        _initPointerField(org.capnproto.AnyPointer.factory, 0, size)
      }

      def isInterface: Boolean = {
        which == Value.Which.INTERFACE
      }

      def getInterface: Void.type = {
        assert(which == Value.Which.INTERFACE, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def setInterface(value: Void.type) {
        _setShortField(0, Value.Which.INTERFACE.id.toShort)
      }

      def isAnyPointer: Boolean = {
        which == Value.Which.ANY_POINTER
      }

      def hasAnyPointer: Boolean = {
        !_pointerFieldIsNull(0)
      }

      def getAnyPointer: AnyPointer.Builder = {
        assert(which == Value.Which.ANY_POINTER, "Must check which() before get()ing a union member.")
        _getPointerField(org.capnproto.AnyPointer.factory, 0)
      }

      def initAnyPointer: AnyPointer.Builder = {
        _setShortField(0, Value.Which.ANY_POINTER.id.toShort)
        _initPointerField(org.capnproto.AnyPointer.factory, 0, 0)
      }

      def initAnyPointer(size: Int): AnyPointer.Builder = {
        _setShortField(0, Value.Which.ANY_POINTER.id.toShort)
        _initPointerField(org.capnproto.AnyPointer.factory, 0, size)
      }
    }

    final class Reader private[schema](segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends org.capnproto.StructReader(segment, data, pointers, dataSize, pointerCount, nestingLimit) {
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

      def getVoid: Void.type = {
        assert(which == Value.Which.VOID, "Must check which() before get()ing a union member.")
        org.capnproto.Void.VOID
      }

      def isBool: Boolean = {
        which == Value.Which.BOOL
      }

      def getBool: Boolean = {
        assert(which == Value.Which.BOOL, "Must check which() before get()ing a union member.")
        _getBooleanField(16)
      }

      def isInt8: Boolean = {
        which == Value.Which.INT8
      }

      def getInt8: Byte = {
        assert(which == Value.Which.INT8, "Must check which() before get()ing a union member.")
        _getByteField(2)
      }

      def isInt16: Boolean = {
        which == Value.Which.INT16
      }

      def getInt16: Short = {
        assert(which == Value.Which.INT16, "Must check which() before get()ing a union member.")
        _getShortField(1)
      }

      def isInt32: Boolean = {
        which == Value.Which.INT32
      }

      def getInt32: Int = {
        assert(which == Value.Which.INT32, "Must check which() before get()ing a union member.")
        _getIntField(1)
      }

      def isInt64: Boolean = {
        which == Value.Which.INT64
      }

      def getInt64: Long = {
        assert(which == Value.Which.INT64, "Must check which() before get()ing a union member.")
        _getLongField(1)
      }

      def isUint8: Boolean = {
        which == Value.Which.UINT8
      }

      def getUint8: Byte = {
        assert(which == Value.Which.UINT8, "Must check which() before get()ing a union member.")
        _getByteField(2)
      }

      def isUint16: Boolean = {
        which == Value.Which.UINT16
      }

      def getUint16: Short = {
        assert(which == Value.Which.UINT16, "Must check which() before get()ing a union member.")
        _getShortField(1)
      }

      def isUint32: Boolean = {
        which == Value.Which.UINT32
      }

      def getUint32: Int = {
        assert(which == Value.Which.UINT32, "Must check which() before get()ing a union member.")
        _getIntField(1)
      }

      def isUint64: Boolean = {
        which == Value.Which.UINT64
      }

      def getUint64: Long = {
        assert(which == Value.Which.UINT64, "Must check which() before get()ing a union member.")
        _getLongField(1)
      }

      def isFloat32: Boolean = {
        which == Value.Which.FLOAT32
      }

      def getFloat32: Float = {
        assert(which == Value.Which.FLOAT32, "Must check which() before get()ing a union member.")
        _getFloatField(1)
      }

      def isFloat64: Boolean = {
        which == Value.Which.FLOAT64
      }

      def getFloat64: Double = {
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

      def getText: Text.Reader = {
        _getPointerField(org.capnproto.Text.factory, 0, null, 0, 0)
      }

      def isData: Boolean = {
        which == Value.Which.DATA
      }

      def hasData: Boolean = {
        if (which != Value.Which.DATA) return false
        !_pointerFieldIsNull(0)
      }

      def getData: Data.Reader = {
        _getPointerField(org.capnproto.Data.factory, 0, null, 0, 0)
      }

      def isList: Boolean = {
        which == Value.Which.LIST
      }

      def hasList: Boolean = {
        if (which != Value.Which.LIST) return false
        !_pointerFieldIsNull(0)
      }

      def getList: AnyPointer.Reader = {
        assert(which == Value.Which.LIST, "Must check which() before get()ing a union member.")
        _getPointerField(org.capnproto.AnyPointer.factory, 0)
      }

      def isEnum: Boolean = {
        which == Value.Which.ENUM
      }

      def getEnum: Short = {
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

      def getStruct: AnyPointer.Reader = {
        assert(which == Value.Which.STRUCT, "Must check which() before get()ing a union member.")
        _getPointerField(org.capnproto.AnyPointer.factory, 0)
      }

      def isInterface: Boolean = {
        which == Value.Which.INTERFACE
      }

      def getInterface: Void.type = {
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

      def getAnyPointer: AnyPointer.Reader = {
        assert(which == Value.Which.ANY_POINTER, "Must check which() before get()ing a union member.")
        _getPointerField(org.capnproto.AnyPointer.factory, 0)
      }
    }

    object Which extends Enumeration {
      type Which = Value
      val VOID, BOOL, INT8, INT16, INT32, INT64, UINT8, UINT16, UINT32, UINT64, FLOAT32, FLOAT64, TEXT, DATA, LIST, ENUM, STRUCT, INTERFACE, ANY_POINTER, _NOT_IN_SCHEMA = Value
    }

  }

  object Annotation {
    val STRUCT_SIZE: StructSize = new StructSize(1.toShort, 2.toShort)

    final class Factory() extends org.capnproto.StructFactory[CapnpSchema.Annotation.Builder, CapnpSchema.Annotation.Reader] {
      def constructReader(segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): CapnpSchema.Annotation.Reader = {
        new CapnpSchema.Annotation.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
      }

      def constructBuilder(segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short): CapnpSchema.Annotation.Builder = {
        new CapnpSchema.Annotation.Builder(segment, data, pointers, dataSize, pointerCount)
      }

      def structSize: StructSize = {
        Annotation.STRUCT_SIZE
      }

      def asReader(builder: CapnpSchema.Annotation.Builder): CapnpSchema.Annotation.Reader = {
        builder.asReader
      }
    }

    val factory: CapnpSchema.Annotation.Factory = new CapnpSchema.Annotation.Factory
    val listFactory: StructList.Factory[CapnpSchema.Annotation.Builder, CapnpSchema.Annotation.Reader] = new StructList.Factory[CapnpSchema.Annotation.Builder, CapnpSchema.Annotation.Reader](factory)

    final class Builder private[schema](segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends org.capnproto.StructBuilder(segment, data, pointers, dataSize, pointerCount) {
      def asReader: CapnpSchema.Annotation.Reader = {
        new CapnpSchema.Annotation.Reader(segment, data, pointers, dataSize, pointerCount, 0x7fffffff)
      }

      def getId: Long = {
        _getLongField(0)
      }

      def setId(value: Long) {
        _setLongField(0, value)
      }

      def getValue: CapnpSchema.Value.Builder = {
        _getPointerField(CapnpSchema.Value.factory, 0, null, 0)
      }

      def setValue(value: CapnpSchema.Value.Reader) {
        _setPointerField(CapnpSchema.Value.factory, 0, value)
      }

      def initValue: CapnpSchema.Value.Builder = {
        _initPointerField(CapnpSchema.Value.factory, 0, 0)
      }

      def getBrand: CapnpSchema.Brand.Builder = {
        _getPointerField(CapnpSchema.Brand.factory, 1, null, 0)
      }

      def setBrand(value: CapnpSchema.Brand.Reader) {
        _setPointerField(CapnpSchema.Brand.factory, 1, value)
      }

      def initBrand: CapnpSchema.Brand.Builder = {
        _initPointerField(CapnpSchema.Brand.factory, 1, 0)
      }
    }

    final class Reader private[schema](segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends org.capnproto.StructReader(segment, data, pointers, dataSize, pointerCount, nestingLimit) {
      def getId: Long = {
        _getLongField(0)
      }

      def hasValue: Boolean = {
        !_pointerFieldIsNull(0)
      }

      def getValue: CapnpSchema.Value.Reader = {
        _getPointerField(CapnpSchema.Value.factory, 0, null, 0)
      }

      def hasBrand: Boolean = {
        !_pointerFieldIsNull(1)
      }

      def getBrand: CapnpSchema.Brand.Reader = {
        _getPointerField(CapnpSchema.Brand.factory, 1, null, 0)
      }
    }

  }

  object ElementSize extends Enumeration {
    type ElementSize = Value
    val EMPTY, BIT, BYTE, TWO_BYTES, FOUR_BYTES, EIGHT_BYTES, POINTER, INLINE_COMPOSITE, _NOT_IN_SCHEMA = Value
  }

  object CodeGeneratorRequest {
    val STRUCT_SIZE: StructSize = new StructSize(0.toShort, 2.toShort)

    final class Factory() extends org.capnproto.StructFactory[CapnpSchema.CodeGeneratorRequest.Builder, CapnpSchema.CodeGeneratorRequest.Reader] {
      def constructReader(segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): CapnpSchema.CodeGeneratorRequest.Reader = {
        new CapnpSchema.CodeGeneratorRequest.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
      }

      def constructBuilder(segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short): CapnpSchema.CodeGeneratorRequest.Builder = {
        new CapnpSchema.CodeGeneratorRequest.Builder(segment, data, pointers, dataSize, pointerCount)
      }

      def structSize: StructSize = {
        CodeGeneratorRequest.STRUCT_SIZE
      }

      def asReader(builder: CapnpSchema.CodeGeneratorRequest.Builder): CapnpSchema.CodeGeneratorRequest.Reader = {
        builder.asReader
      }
    }

    val factory: CapnpSchema.CodeGeneratorRequest.Factory = new CapnpSchema.CodeGeneratorRequest.Factory
    val listFactory: StructList.Factory[CapnpSchema.CodeGeneratorRequest.Builder, CapnpSchema.CodeGeneratorRequest.Reader] = new StructList.Factory[CapnpSchema.CodeGeneratorRequest.Builder, CapnpSchema.CodeGeneratorRequest.Reader](factory)

    final class Builder private[schema](segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends org.capnproto.StructBuilder(segment, data, pointers, dataSize, pointerCount) {
      def asReader: CapnpSchema.CodeGeneratorRequest.Reader = {
        new CapnpSchema.CodeGeneratorRequest.Reader(segment, data, pointers, dataSize, pointerCount, 0x7fffffff)
      }

      def hasNodes: Boolean = {
        !_pointerFieldIsNull(0)
      }

      def getNodes: StructList.Builder[CapnpSchema.Node.Builder] = {
        _getPointerField(CapnpSchema.Node.listFactory, 0, null, 0)
      }

      def setNodes(value: StructList.Reader[CapnpSchema.Node.Reader]) {
        _setPointerField(CapnpSchema.Node.listFactory, 0, value)
      }

      def initNodes(size: Int): StructList.Builder[CapnpSchema.Node.Builder] = {
        _initPointerField(CapnpSchema.Node.listFactory, 0, size)
      }

      def hasRequestedFiles: Boolean = {
        !_pointerFieldIsNull(1)
      }

      def getRequestedFiles: StructList.Builder[CapnpSchema.CodeGeneratorRequest.RequestedFile.Builder] = {
        _getPointerField(CapnpSchema.CodeGeneratorRequest.RequestedFile.listFactory, 1, null, 0)
      }

      def setRequestedFiles(value: StructList.Reader[CapnpSchema.CodeGeneratorRequest.RequestedFile.Reader]) {
        _setPointerField(CapnpSchema.CodeGeneratorRequest.RequestedFile.listFactory, 1, value)
      }

      def initRequestedFiles(size: Int): StructList.Builder[CapnpSchema.CodeGeneratorRequest.RequestedFile.Builder] = {
        _initPointerField(CapnpSchema.CodeGeneratorRequest.RequestedFile.listFactory, 1, size)
      }
    }

    final class Reader private[schema](segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends org.capnproto.StructReader(segment, data, pointers, dataSize, pointerCount, nestingLimit) {
      def hasNodes: Boolean = {
        !_pointerFieldIsNull(0)
      }

      def getNodes: StructList.Reader[CapnpSchema.Node.Reader] = {
        _getPointerField(CapnpSchema.Node.listFactory, 0, null, 0)
      }

      def hasRequestedFiles: Boolean = {
        !_pointerFieldIsNull(1)
      }

      def getRequestedFiles: StructList.Reader[CapnpSchema.CodeGeneratorRequest.RequestedFile.Reader] = {
        _getPointerField(CapnpSchema.CodeGeneratorRequest.RequestedFile.listFactory, 1, null, 0)
      }
    }

    object RequestedFile {
      val STRUCT_SIZE: StructSize = new StructSize(1.toShort, 2.toShort)

      final class Factory() extends org.capnproto.StructFactory[CapnpSchema.CodeGeneratorRequest.RequestedFile.Builder, CapnpSchema.CodeGeneratorRequest.RequestedFile.Reader] {
        def constructReader(segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): CapnpSchema.CodeGeneratorRequest.RequestedFile.Reader = {
          new CapnpSchema.CodeGeneratorRequest.RequestedFile.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
        }

        def constructBuilder(segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short): CapnpSchema.CodeGeneratorRequest.RequestedFile.Builder = {
          new CapnpSchema.CodeGeneratorRequest.RequestedFile.Builder(segment, data, pointers, dataSize, pointerCount)
        }

        def structSize: StructSize = {
          CodeGeneratorRequest.RequestedFile.STRUCT_SIZE
        }

        def asReader(builder: CapnpSchema.CodeGeneratorRequest.RequestedFile.Builder): CapnpSchema.CodeGeneratorRequest.RequestedFile.Reader = {
          builder.asReader
        }
      }

      val factory: CapnpSchema.CodeGeneratorRequest.RequestedFile.Factory = new CapnpSchema.CodeGeneratorRequest.RequestedFile.Factory
      val listFactory: StructList.Factory[CapnpSchema.CodeGeneratorRequest.RequestedFile.Builder, CapnpSchema.CodeGeneratorRequest.RequestedFile.Reader] = new StructList.Factory[CapnpSchema.CodeGeneratorRequest.RequestedFile.Builder, CapnpSchema.CodeGeneratorRequest.RequestedFile.Reader](factory)

      final class Builder private[schema](segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends org.capnproto.StructBuilder(segment, data, pointers, dataSize, pointerCount) {
        def asReader: CapnpSchema.CodeGeneratorRequest.RequestedFile.Reader = {
          new CapnpSchema.CodeGeneratorRequest.RequestedFile.Reader(segment, data, pointers, dataSize, pointerCount, 0x7fffffff)
        }

        def getId: Long = {
          _getLongField(0)
        }

        def setId(value: Long) {
          _setLongField(0, value)
        }

        def hasFilename: Boolean = {
          !_pointerFieldIsNull(0)
        }

        def getFilename: Text.Builder = {
          _getPointerField(org.capnproto.Text.factory, 0, null, 0, 0)
        }

        def setFilename(value: Text.Reader) {
          _setPointerField(org.capnproto.Text.factory, 0, value)
        }

        def setFilename(value: String) {
          _setPointerField(org.capnproto.Text.factory, 0, new Text.Reader(value))
        }

        def initFilename(size: Int): Text.Builder = {
          _initPointerField(org.capnproto.Text.factory, 0, size)
        }

        def hasImports: Boolean = {
          !_pointerFieldIsNull(1)
        }

        def getImports: StructList.Builder[CapnpSchema.CodeGeneratorRequest.RequestedFile.Import.Builder] = {
          _getPointerField(CapnpSchema.CodeGeneratorRequest.RequestedFile.Import.listFactory, 1, null, 0)
        }

        def setImports(value: StructList.Reader[CapnpSchema.CodeGeneratorRequest.RequestedFile.Import.Reader]) {
          _setPointerField(CapnpSchema.CodeGeneratorRequest.RequestedFile.Import.listFactory, 1, value)
        }

        def initImports(size: Int): StructList.Builder[CapnpSchema.CodeGeneratorRequest.RequestedFile.Import.Builder] = {
          _initPointerField(CapnpSchema.CodeGeneratorRequest.RequestedFile.Import.listFactory, 1, size)
        }
      }

      final class Reader private[schema](segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends org.capnproto.StructReader(segment, data, pointers, dataSize, pointerCount, nestingLimit) {
        def getId: Long = {
          _getLongField(0)
        }

        def hasFilename: Boolean = {
          !_pointerFieldIsNull(0)
        }

        def getFilename: Text.Reader = {
          _getPointerField(org.capnproto.Text.factory, 0, null, 0, 0)
        }

        def hasImports: Boolean = {
          !_pointerFieldIsNull(1)
        }

        def getImports: StructList.Reader[CapnpSchema.CodeGeneratorRequest.RequestedFile.Import.Reader] = {
          _getPointerField(CapnpSchema.CodeGeneratorRequest.RequestedFile.Import.listFactory, 1, null, 0)
        }
      }

      object Import {
        val STRUCT_SIZE: StructSize = new StructSize(1.toShort, 1.toShort)

        final class Factory() extends org.capnproto.StructFactory[CapnpSchema.CodeGeneratorRequest.RequestedFile.Import.Builder, CapnpSchema.CodeGeneratorRequest.RequestedFile.Import.Reader] {
          def constructReader(segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): CapnpSchema.CodeGeneratorRequest.RequestedFile.Import.Reader = {
            new CapnpSchema.CodeGeneratorRequest.RequestedFile.Import.Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit)
          }

          def constructBuilder(segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short): CapnpSchema.CodeGeneratorRequest.RequestedFile.Import.Builder = {
            new CapnpSchema.CodeGeneratorRequest.RequestedFile.Import.Builder(segment, data, pointers, dataSize, pointerCount)
          }

          def structSize: StructSize = {
            CodeGeneratorRequest.RequestedFile.Import.STRUCT_SIZE
          }

          def asReader(builder: CapnpSchema.CodeGeneratorRequest.RequestedFile.Import.Builder): CapnpSchema.CodeGeneratorRequest.RequestedFile.Import.Reader = {
            builder.asReader
          }
        }

        val factory: CapnpSchema.CodeGeneratorRequest.RequestedFile.Import.Factory = new CapnpSchema.CodeGeneratorRequest.RequestedFile.Import.Factory
        val listFactory: StructList.Factory[CapnpSchema.CodeGeneratorRequest.RequestedFile.Import.Builder, CapnpSchema.CodeGeneratorRequest.RequestedFile.Import.Reader] = new StructList.Factory[CapnpSchema.CodeGeneratorRequest.RequestedFile.Import.Builder, CapnpSchema.CodeGeneratorRequest.RequestedFile.Import.Reader](factory)

        final class Builder private[schema](segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short) extends org.capnproto.StructBuilder(segment, data, pointers, dataSize, pointerCount) {
          def asReader: CapnpSchema.CodeGeneratorRequest.RequestedFile.Import.Reader = {
            new CapnpSchema.CodeGeneratorRequest.RequestedFile.Import.Reader(segment, data, pointers, dataSize, pointerCount, 0x7fffffff)
          }

          def getId: Long = {
            _getLongField(0)
          }

          def setId(value: Long) {
            _setLongField(0, value)
          }

          def hasName: Boolean = {
            !_pointerFieldIsNull(0)
          }

          def getName: Text.Builder = {
            _getPointerField(org.capnproto.Text.factory, 0, null, 0, 0)
          }

          def setName(value: Text.Reader) {
            _setPointerField(org.capnproto.Text.factory, 0, value)
          }

          def setName(value: String) {
            _setPointerField(org.capnproto.Text.factory, 0, new Text.Reader(value))
          }

          def initName(size: Int): Text.Builder = {
            _initPointerField(org.capnproto.Text.factory, 0, size)
          }
        }

        final class Reader private[schema](segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int) extends org.capnproto.StructReader(segment, data, pointers, dataSize, pointerCount, nestingLimit) {
          def getId: Long = {
            _getLongField(0)
          }

          def hasName: Boolean = {
            !_pointerFieldIsNull(0)
          }

          def getName: Text.Reader = {
            _getPointerField(org.capnproto.Text.factory, 0, null, 0, 0)
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
