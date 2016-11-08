// GENERATED CAP'N PROTO FILE, DO NOT EDIT
package org.murtsi.capnproto.compiler

import org.murtsi.capnproto.runtime.implicits._

object schema {
  // START Node#Parameter implicits
  implicit val Node$Parameter$$HasTypeId = new org.murtsi.capnproto.runtime.HasTypeId[Node#Parameter] {
    def typeId: Long = -5092977661570997327L
  }
  implicit val Node$Parameter$$HasStructSize = new org.murtsi.capnproto.runtime.HasStructSize[Node#Parameter] {
    val structSize = new org.murtsi.capnproto.runtime.StructSize(0, 1)
  }
  implicit val Node$Parameter$$StructFromSegment = new org.murtsi.capnproto.runtime.StructFromSegment[Node#Parameter] {
    def readerFromSegment(segment: org.murtsi.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): Node#Parameter#Reader = {
      Node.Parameter.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.murtsi.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): Node#Parameter#Builder = {
      Node.Parameter.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END Node#Parameter implicits
  // START Node#NestedNode implicits
  implicit val Node$NestedNode$$HasTypeId = new org.murtsi.capnproto.runtime.HasTypeId[Node#NestedNode] {
    def typeId: Long = -2396102210895232446L
  }
  implicit val Node$NestedNode$$HasStructSize = new org.murtsi.capnproto.runtime.HasStructSize[Node#NestedNode] {
    val structSize = new org.murtsi.capnproto.runtime.StructSize(1, 1)
  }
  implicit val Node$NestedNode$$StructFromSegment = new org.murtsi.capnproto.runtime.StructFromSegment[Node#NestedNode] {
    def readerFromSegment(segment: org.murtsi.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): Node#NestedNode#Reader = {
      Node.NestedNode.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.murtsi.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): Node#NestedNode#Builder = {
      Node.NestedNode.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END Node#NestedNode implicits
  // START Node implicits
  implicit val Node$$HasTypeId = new org.murtsi.capnproto.runtime.HasTypeId[Node] {
    def typeId: Long = -1836717350928014313L
  }
  implicit val Node$$HasStructSize = new org.murtsi.capnproto.runtime.HasStructSize[Node] {
    val structSize = new org.murtsi.capnproto.runtime.StructSize(5, 6)
  }
  implicit val Node$$StructFromSegment = new org.murtsi.capnproto.runtime.StructFromSegment[Node] {
    def readerFromSegment(segment: org.murtsi.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): Node#Reader = {
      Node.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.murtsi.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): Node#Builder = {
      Node.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END Node implicits
  // START Node#Struct implicits
  implicit val Node$Struct$$HasTypeId = new org.murtsi.capnproto.runtime.HasTypeId[Node#Struct] {
    def typeId: Long = -7016412939225971659L
  }
  implicit val Node$Struct$$HasStructSize = new org.murtsi.capnproto.runtime.HasStructSize[Node#Struct] {
    val structSize = new org.murtsi.capnproto.runtime.StructSize(5, 6)
  }
  implicit val Node$Struct$$StructFromSegment = new org.murtsi.capnproto.runtime.StructFromSegment[Node#Struct] {
    def readerFromSegment(segment: org.murtsi.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): Node#Struct#Reader = {
      Node.Struct.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.murtsi.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): Node#Struct#Builder = {
      Node.Struct.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END Node#Struct implicits
  // START Node#Enum implicits
  implicit val Node$Enum$$HasTypeId = new org.murtsi.capnproto.runtime.HasTypeId[Node#Enum] {
    def typeId: Long = -5383293358930922088L
  }
  implicit val Node$Enum$$HasStructSize = new org.murtsi.capnproto.runtime.HasStructSize[Node#Enum] {
    val structSize = new org.murtsi.capnproto.runtime.StructSize(5, 6)
  }
  implicit val Node$Enum$$StructFromSegment = new org.murtsi.capnproto.runtime.StructFromSegment[Node#Enum] {
    def readerFromSegment(segment: org.murtsi.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): Node#Enum#Reader = {
      Node.Enum.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.murtsi.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): Node#Enum#Builder = {
      Node.Enum.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END Node#Enum implicits
  // START Node#Interface implicits
  implicit val Node$Interface$$HasTypeId = new org.murtsi.capnproto.runtime.HasTypeId[Node#Interface] {
    def typeId: Long = -1718312580255964785L
  }
  implicit val Node$Interface$$HasStructSize = new org.murtsi.capnproto.runtime.HasStructSize[Node#Interface] {
    val structSize = new org.murtsi.capnproto.runtime.StructSize(5, 6)
  }
  implicit val Node$Interface$$StructFromSegment = new org.murtsi.capnproto.runtime.StructFromSegment[Node#Interface] {
    def readerFromSegment(segment: org.murtsi.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): Node#Interface#Reader = {
      Node.Interface.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.murtsi.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): Node#Interface#Builder = {
      Node.Interface.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END Node#Interface implicits
  // START Node#Const implicits
  implicit val Node$Const$$HasTypeId = new org.murtsi.capnproto.runtime.HasTypeId[Node#Const] {
    def typeId: Long = -5653524222009568224L
  }
  implicit val Node$Const$$HasStructSize = new org.murtsi.capnproto.runtime.HasStructSize[Node#Const] {
    val structSize = new org.murtsi.capnproto.runtime.StructSize(5, 6)
  }
  implicit val Node$Const$$StructFromSegment = new org.murtsi.capnproto.runtime.StructFromSegment[Node#Const] {
    def readerFromSegment(segment: org.murtsi.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): Node#Const#Reader = {
      Node.Const.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.murtsi.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): Node#Const#Builder = {
      Node.Const.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END Node#Const implicits
  // START Node#Annotation implicits
  implicit val Node$Annotation$$HasTypeId = new org.murtsi.capnproto.runtime.HasTypeId[Node#Annotation] {
    def typeId: Long = -1434931031872765296L
  }
  implicit val Node$Annotation$$HasStructSize = new org.murtsi.capnproto.runtime.HasStructSize[Node#Annotation] {
    val structSize = new org.murtsi.capnproto.runtime.StructSize(5, 6)
  }
  implicit val Node$Annotation$$StructFromSegment = new org.murtsi.capnproto.runtime.StructFromSegment[Node#Annotation] {
    def readerFromSegment(segment: org.murtsi.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): Node#Annotation#Reader = {
      Node.Annotation.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.murtsi.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): Node#Annotation#Builder = {
      Node.Annotation.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END Node#Annotation implicits
  // START Field implicits
  implicit val Field$$HasTypeId = new org.murtsi.capnproto.runtime.HasTypeId[Field] {
    def typeId: Long = -7301090755067841441L
  }
  implicit val Field$$HasStructSize = new org.murtsi.capnproto.runtime.HasStructSize[Field] {
    val structSize = new org.murtsi.capnproto.runtime.StructSize(3, 4)
  }
  implicit val Field$$StructFromSegment = new org.murtsi.capnproto.runtime.StructFromSegment[Field] {
    def readerFromSegment(segment: org.murtsi.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): Field#Reader = {
      Field.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.murtsi.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): Field#Builder = {
      Field.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END Field implicits
  // START Field#Slot implicits
  implicit val Field$Slot$$HasTypeId = new org.murtsi.capnproto.runtime.HasTypeId[Field#Slot] {
    def typeId: Long = -4313598213782997905L
  }
  implicit val Field$Slot$$HasStructSize = new org.murtsi.capnproto.runtime.HasStructSize[Field#Slot] {
    val structSize = new org.murtsi.capnproto.runtime.StructSize(3, 4)
  }
  implicit val Field$Slot$$StructFromSegment = new org.murtsi.capnproto.runtime.StructFromSegment[Field#Slot] {
    def readerFromSegment(segment: org.murtsi.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): Field#Slot#Reader = {
      Field.Slot.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.murtsi.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): Field#Slot#Builder = {
      Field.Slot.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END Field#Slot implicits
  // START Field#Group implicits
  implicit val Field$Group$$HasTypeId = new org.murtsi.capnproto.runtime.HasTypeId[Field#Group] {
    def typeId: Long = -3819952041676301039L
  }
  implicit val Field$Group$$HasStructSize = new org.murtsi.capnproto.runtime.HasStructSize[Field#Group] {
    val structSize = new org.murtsi.capnproto.runtime.StructSize(3, 4)
  }
  implicit val Field$Group$$StructFromSegment = new org.murtsi.capnproto.runtime.StructFromSegment[Field#Group] {
    def readerFromSegment(segment: org.murtsi.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): Field#Group#Reader = {
      Field.Group.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.murtsi.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): Field#Group#Builder = {
      Field.Group.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END Field#Group implicits
  // START Field#Ordinal implicits
  implicit val Field$Ordinal$$HasTypeId = new org.murtsi.capnproto.runtime.HasTypeId[Field#Ordinal] {
    def typeId: Long = -4931206560496546842L
  }
  implicit val Field$Ordinal$$HasStructSize = new org.murtsi.capnproto.runtime.HasStructSize[Field#Ordinal] {
    val structSize = new org.murtsi.capnproto.runtime.StructSize(3, 4)
  }
  implicit val Field$Ordinal$$StructFromSegment = new org.murtsi.capnproto.runtime.StructFromSegment[Field#Ordinal] {
    def readerFromSegment(segment: org.murtsi.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): Field#Ordinal#Reader = {
      Field.Ordinal.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.murtsi.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): Field#Ordinal#Builder = {
      Field.Ordinal.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END Field#Ordinal implicits
  // START Enumerant implicits
  implicit val Enumerant$$HasTypeId = new org.murtsi.capnproto.runtime.HasTypeId[Enumerant] {
    def typeId: Long = -7527066474740671923L
  }
  implicit val Enumerant$$HasStructSize = new org.murtsi.capnproto.runtime.HasStructSize[Enumerant] {
    val structSize = new org.murtsi.capnproto.runtime.StructSize(1, 2)
  }
  implicit val Enumerant$$StructFromSegment = new org.murtsi.capnproto.runtime.StructFromSegment[Enumerant] {
    def readerFromSegment(segment: org.murtsi.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): Enumerant#Reader = {
      Enumerant.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.murtsi.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): Enumerant#Builder = {
      Enumerant.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END Enumerant implicits
  // START Superclass implicits
  implicit val Superclass$$HasTypeId = new org.murtsi.capnproto.runtime.HasTypeId[Superclass] {
    def typeId: Long = -6226742573199468552L
  }
  implicit val Superclass$$HasStructSize = new org.murtsi.capnproto.runtime.HasStructSize[Superclass] {
    val structSize = new org.murtsi.capnproto.runtime.StructSize(1, 1)
  }
  implicit val Superclass$$StructFromSegment = new org.murtsi.capnproto.runtime.StructFromSegment[Superclass] {
    def readerFromSegment(segment: org.murtsi.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): Superclass#Reader = {
      Superclass.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.murtsi.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): Superclass#Builder = {
      Superclass.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END Superclass implicits
  // START Method implicits
  implicit val Method$$HasTypeId = new org.murtsi.capnproto.runtime.HasTypeId[Method] {
    def typeId: Long = -7709937290030396032L
  }
  implicit val Method$$HasStructSize = new org.murtsi.capnproto.runtime.HasStructSize[Method] {
    val structSize = new org.murtsi.capnproto.runtime.StructSize(3, 5)
  }
  implicit val Method$$StructFromSegment = new org.murtsi.capnproto.runtime.StructFromSegment[Method] {
    def readerFromSegment(segment: org.murtsi.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): Method#Reader = {
      Method.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.murtsi.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): Method#Builder = {
      Method.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END Method implicits
  // START Type implicits
  implicit val Type$$HasTypeId = new org.murtsi.capnproto.runtime.HasTypeId[Type] {
    def typeId: Long = -3426261928404988832L
  }
  implicit val Type$$HasStructSize = new org.murtsi.capnproto.runtime.HasStructSize[Type] {
    val structSize = new org.murtsi.capnproto.runtime.StructSize(3, 1)
  }
  implicit val Type$$StructFromSegment = new org.murtsi.capnproto.runtime.StructFromSegment[Type] {
    def readerFromSegment(segment: org.murtsi.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): Type#Reader = {
      Type.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.murtsi.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): Type#Builder = {
      Type.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END Type implicits
  // START Type#_List implicits
  implicit val Type$_List$$HasTypeId = new org.murtsi.capnproto.runtime.HasTypeId[Type#_List] {
    def typeId: Long = -8653885327718421865L
  }
  implicit val Type$_List$$HasStructSize = new org.murtsi.capnproto.runtime.HasStructSize[Type#_List] {
    val structSize = new org.murtsi.capnproto.runtime.StructSize(3, 1)
  }
  implicit val Type$_List$$StructFromSegment = new org.murtsi.capnproto.runtime.StructFromSegment[Type#_List] {
    def readerFromSegment(segment: org.murtsi.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): Type#_List#Reader = {
      Type._List.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.murtsi.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): Type#_List#Builder = {
      Type._List.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END Type#_List implicits
  // START Type#Enum implicits
  implicit val Type$Enum$$HasTypeId = new org.murtsi.capnproto.runtime.HasTypeId[Type#Enum] {
    def typeId: Long = -7057571138871785559L
  }
  implicit val Type$Enum$$HasStructSize = new org.murtsi.capnproto.runtime.HasStructSize[Type#Enum] {
    val structSize = new org.murtsi.capnproto.runtime.StructSize(3, 1)
  }
  implicit val Type$Enum$$StructFromSegment = new org.murtsi.capnproto.runtime.StructFromSegment[Type#Enum] {
    def readerFromSegment(segment: org.murtsi.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): Type#Enum#Reader = {
      Type.Enum.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.murtsi.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): Type#Enum#Builder = {
      Type.Enum.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END Type#Enum implicits
  // START Type#Struct implicits
  implicit val Type$Struct$$HasTypeId = new org.murtsi.capnproto.runtime.HasTypeId[Type#Struct] {
    def typeId: Long = -6036389888414398765L
  }
  implicit val Type$Struct$$HasStructSize = new org.murtsi.capnproto.runtime.HasStructSize[Type#Struct] {
    val structSize = new org.murtsi.capnproto.runtime.StructSize(3, 1)
  }
  implicit val Type$Struct$$StructFromSegment = new org.murtsi.capnproto.runtime.StructFromSegment[Type#Struct] {
    def readerFromSegment(segment: org.murtsi.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): Type#Struct#Reader = {
      Type.Struct.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.murtsi.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): Type#Struct#Builder = {
      Type.Struct.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END Type#Struct implicits
  // START Type#Interface implicits
  implicit val Type$Interface$$HasTypeId = new org.murtsi.capnproto.runtime.HasTypeId[Type#Interface] {
    def typeId: Long = -1329746708477047617L
  }
  implicit val Type$Interface$$HasStructSize = new org.murtsi.capnproto.runtime.HasStructSize[Type#Interface] {
    val structSize = new org.murtsi.capnproto.runtime.StructSize(3, 1)
  }
  implicit val Type$Interface$$StructFromSegment = new org.murtsi.capnproto.runtime.StructFromSegment[Type#Interface] {
    def readerFromSegment(segment: org.murtsi.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): Type#Interface#Reader = {
      Type.Interface.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.murtsi.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): Type#Interface#Builder = {
      Type.Interface.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END Type#Interface implicits
  // START Type#AnyPointer implicits
  implicit val Type$AnyPointer$$HasTypeId = new org.murtsi.capnproto.runtime.HasTypeId[Type#AnyPointer] {
    def typeId: Long = -4443012238990751247L
  }
  implicit val Type$AnyPointer$$HasStructSize = new org.murtsi.capnproto.runtime.HasStructSize[Type#AnyPointer] {
    val structSize = new org.murtsi.capnproto.runtime.StructSize(3, 1)
  }
  implicit val Type$AnyPointer$$StructFromSegment = new org.murtsi.capnproto.runtime.StructFromSegment[Type#AnyPointer] {
    def readerFromSegment(segment: org.murtsi.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): Type#AnyPointer#Reader = {
      Type.AnyPointer.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.murtsi.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): Type#AnyPointer#Builder = {
      Type.AnyPointer.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END Type#AnyPointer implicits
  // START Type#AnyPointer#Parameter implicits
  implicit val Type$AnyPointer$Parameter$$HasTypeId = new org.murtsi.capnproto.runtime.HasTypeId[Type#AnyPointer#Parameter] {
    def typeId: Long = -7074601801531438459L
  }
  implicit val Type$AnyPointer$Parameter$$HasStructSize = new org.murtsi.capnproto.runtime.HasStructSize[Type#AnyPointer#Parameter] {
    val structSize = new org.murtsi.capnproto.runtime.StructSize(3, 1)
  }
  implicit val Type$AnyPointer$Parameter$$StructFromSegment = new org.murtsi.capnproto.runtime.StructFromSegment[Type#AnyPointer#Parameter] {
    def readerFromSegment(segment: org.murtsi.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): Type#AnyPointer#Parameter#Reader = {
      Type.AnyPointer.Parameter.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.murtsi.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): Type#AnyPointer#Parameter#Builder = {
      Type.AnyPointer.Parameter.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END Type#AnyPointer#Parameter implicits
  // START Type#AnyPointer#ImplicitMethodParameter implicits
  implicit val Type$AnyPointer$ImplicitMethodParameter$$HasTypeId = new org.murtsi.capnproto.runtime.HasTypeId[Type#AnyPointer#ImplicitMethodParameter] {
    def typeId: Long = -4976537983867493772L
  }
  implicit val Type$AnyPointer$ImplicitMethodParameter$$HasStructSize = new org.murtsi.capnproto.runtime.HasStructSize[Type#AnyPointer#ImplicitMethodParameter] {
    val structSize = new org.murtsi.capnproto.runtime.StructSize(3, 1)
  }
  implicit val Type$AnyPointer$ImplicitMethodParameter$$StructFromSegment = new org.murtsi.capnproto.runtime.StructFromSegment[Type#AnyPointer#ImplicitMethodParameter] {
    def readerFromSegment(segment: org.murtsi.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): Type#AnyPointer#ImplicitMethodParameter#Reader = {
      Type.AnyPointer.ImplicitMethodParameter.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.murtsi.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): Type#AnyPointer#ImplicitMethodParameter#Builder = {
      Type.AnyPointer.ImplicitMethodParameter.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END Type#AnyPointer#ImplicitMethodParameter implicits
  // START Brand#Scope implicits
  implicit val Brand$Scope$$HasTypeId = new org.murtsi.capnproto.runtime.HasTypeId[Brand#Scope] {
    def typeId: Long = -6064320624553923639L
  }
  implicit val Brand$Scope$$HasStructSize = new org.murtsi.capnproto.runtime.HasStructSize[Brand#Scope] {
    val structSize = new org.murtsi.capnproto.runtime.StructSize(2, 1)
  }
  implicit val Brand$Scope$$StructFromSegment = new org.murtsi.capnproto.runtime.StructFromSegment[Brand#Scope] {
    def readerFromSegment(segment: org.murtsi.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): Brand#Scope#Reader = {
      Brand.Scope.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.murtsi.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): Brand#Scope#Builder = {
      Brand.Scope.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END Brand#Scope implicits
  // START Brand#Binding implicits
  implicit val Brand$Binding$$HasTypeId = new org.murtsi.capnproto.runtime.HasTypeId[Brand#Binding] {
    def typeId: Long = -4007133746529638404L
  }
  implicit val Brand$Binding$$HasStructSize = new org.murtsi.capnproto.runtime.HasStructSize[Brand#Binding] {
    val structSize = new org.murtsi.capnproto.runtime.StructSize(1, 1)
  }
  implicit val Brand$Binding$$StructFromSegment = new org.murtsi.capnproto.runtime.StructFromSegment[Brand#Binding] {
    def readerFromSegment(segment: org.murtsi.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): Brand#Binding#Reader = {
      Brand.Binding.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.murtsi.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): Brand#Binding#Builder = {
      Brand.Binding.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END Brand#Binding implicits
  // START Brand implicits
  implicit val Brand$$HasTypeId = new org.murtsi.capnproto.runtime.HasTypeId[Brand] {
    def typeId: Long = -8055719342561213909L
  }
  implicit val Brand$$HasStructSize = new org.murtsi.capnproto.runtime.HasStructSize[Brand] {
    val structSize = new org.murtsi.capnproto.runtime.StructSize(0, 1)
  }
  implicit val Brand$$StructFromSegment = new org.murtsi.capnproto.runtime.StructFromSegment[Brand] {
    def readerFromSegment(segment: org.murtsi.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): Brand#Reader = {
      Brand.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.murtsi.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): Brand#Builder = {
      Brand.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END Brand implicits
  // START Value implicits
  implicit val Value$$HasTypeId = new org.murtsi.capnproto.runtime.HasTypeId[Value] {
    def typeId: Long = -3592785279591641957L
  }
  implicit val Value$$HasStructSize = new org.murtsi.capnproto.runtime.HasStructSize[Value] {
    val structSize = new org.murtsi.capnproto.runtime.StructSize(2, 1)
  }
  implicit val Value$$StructFromSegment = new org.murtsi.capnproto.runtime.StructFromSegment[Value] {
    def readerFromSegment(segment: org.murtsi.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): Value#Reader = {
      Value.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.murtsi.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): Value#Builder = {
      Value.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END Value implicits
  // START Annotation implicits
  implicit val Annotation$$HasTypeId = new org.murtsi.capnproto.runtime.HasTypeId[Annotation] {
    def typeId: Long = -1024405029288315582L
  }
  implicit val Annotation$$HasStructSize = new org.murtsi.capnproto.runtime.HasStructSize[Annotation] {
    val structSize = new org.murtsi.capnproto.runtime.StructSize(1, 2)
  }
  implicit val Annotation$$StructFromSegment = new org.murtsi.capnproto.runtime.StructFromSegment[Annotation] {
    def readerFromSegment(segment: org.murtsi.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): Annotation#Reader = {
      Annotation.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.murtsi.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): Annotation#Builder = {
      Annotation.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END Annotation implicits
  // START ElementSize implicits
  implicit val ElementSize$$EnumValues = new org.murtsi.capnproto.runtime.HasEnumValues[ElementSize] {
    val enumValues = ElementSize.enumValues
  }
  implicit val ElementSize$$FromShort = new org.murtsi.capnproto.runtime.FromShort[ElementSize] {
    def fromShort(short: Short) = ElementSize(short)
  }
  // END ElementSize implicits
  // START CodeGeneratorRequest#RequestedFile#Import implicits
  implicit val CodeGeneratorRequest$RequestedFile$Import$$HasTypeId = new org.murtsi.capnproto.runtime.HasTypeId[CodeGeneratorRequest#RequestedFile#Import] {
    def typeId: Long = -5886132613052934171L
  }
  implicit val CodeGeneratorRequest$RequestedFile$Import$$HasStructSize = new org.murtsi.capnproto.runtime.HasStructSize[CodeGeneratorRequest#RequestedFile#Import] {
    val structSize = new org.murtsi.capnproto.runtime.StructSize(1, 1)
  }
  implicit val CodeGeneratorRequest$RequestedFile$Import$$StructFromSegment = new org.murtsi.capnproto.runtime.StructFromSegment[CodeGeneratorRequest#RequestedFile#Import] {
    def readerFromSegment(segment: org.murtsi.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): CodeGeneratorRequest#RequestedFile#Import#Reader = {
      CodeGeneratorRequest.RequestedFile.Import.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.murtsi.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): CodeGeneratorRequest#RequestedFile#Import#Builder = {
      CodeGeneratorRequest.RequestedFile.Import.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END CodeGeneratorRequest#RequestedFile#Import implicits
  // START CodeGeneratorRequest#RequestedFile implicits
  implicit val CodeGeneratorRequest$RequestedFile$$HasTypeId = new org.murtsi.capnproto.runtime.HasTypeId[CodeGeneratorRequest#RequestedFile] {
    def typeId: Long = -3464940813450936222L
  }
  implicit val CodeGeneratorRequest$RequestedFile$$HasStructSize = new org.murtsi.capnproto.runtime.HasStructSize[CodeGeneratorRequest#RequestedFile] {
    val structSize = new org.murtsi.capnproto.runtime.StructSize(1, 2)
  }
  implicit val CodeGeneratorRequest$RequestedFile$$StructFromSegment = new org.murtsi.capnproto.runtime.StructFromSegment[CodeGeneratorRequest#RequestedFile] {
    def readerFromSegment(segment: org.murtsi.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): CodeGeneratorRequest#RequestedFile#Reader = {
      CodeGeneratorRequest.RequestedFile.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.murtsi.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): CodeGeneratorRequest#RequestedFile#Builder = {
      CodeGeneratorRequest.RequestedFile.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END CodeGeneratorRequest#RequestedFile implicits
  // START CodeGeneratorRequest implicits
  implicit val CodeGeneratorRequest$$HasTypeId = new org.murtsi.capnproto.runtime.HasTypeId[CodeGeneratorRequest] {
    def typeId: Long = -4628215019123058738L
  }
  implicit val CodeGeneratorRequest$$HasStructSize = new org.murtsi.capnproto.runtime.HasStructSize[CodeGeneratorRequest] {
    val structSize = new org.murtsi.capnproto.runtime.StructSize(0, 2)
  }
  implicit val CodeGeneratorRequest$$StructFromSegment = new org.murtsi.capnproto.runtime.StructFromSegment[CodeGeneratorRequest] {
    def readerFromSegment(segment: org.murtsi.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): CodeGeneratorRequest#Reader = {
      CodeGeneratorRequest.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.murtsi.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): CodeGeneratorRequest#Builder = {
      CodeGeneratorRequest.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END CodeGeneratorRequest implicits

  object Node extends Node
  sealed class Node private() extends org.murtsi.capnproto.runtime.Struct { 
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
      def displayName: org.murtsi.capnproto.runtime.Text#Reader = {
        _getPointerField[org.murtsi.capnproto.runtime.Text](0)
      }
      def displayNamePrefixLength: Int = {
        this._getIntField(2)
      }
      def scopeId: Long = {
        this._getLongField(2)
      }
      def nestedNodes: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Node#NestedNode]#Reader = {
        _getPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Node#NestedNode]](1)
      }
      def annotations: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Annotation]#Reader = {
        _getPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Annotation]](2)
      }
      private[Node] def struct: Node#Struct#Reader = {
        Node.Struct.Reader(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit)
      }
      private[Node] def enum: Node#Enum#Reader = {
        Node.Enum.Reader(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit)
      }
      private[Node] def interface: Node#Interface#Reader = {
        Node.Interface.Reader(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit)
      }
      private[Node] def const: Node#Const#Reader = {
        Node.Const.Reader(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit)
      }
      private[Node] def annotation: Node#Annotation#Reader = {
        Node.Annotation.Reader(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit)
      }
      def parameters: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Node#Parameter]#Reader = {
        _getPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Node#Parameter]](5)
      }
      def isGeneric: Boolean = {
        _getBooleanField(288)
      }
      private[Node] def _whichIndex: Short = _getShortField(6)
      object has {
        def displayName: Boolean = {
          _pointerFieldIsNull(0)
        }
        def nestedNodes: Boolean = {
          _pointerFieldIsNull(1)
        }
        def annotations: Boolean = {
          _pointerFieldIsNull(2)
        }
        def parameters: Boolean = {
          _pointerFieldIsNull(5)
        }
      }
    }
    class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
      def id: Long = {
        this._getLongField(0)
      }
      def id_=(value: Long): Unit = {
        _setLongField(0, value)
      }
      def displayName: org.murtsi.capnproto.runtime.Text#Builder = {
        _getPointerField[org.murtsi.capnproto.runtime.Text](0)
      }
      def displayName_=(value: org.murtsi.capnproto.runtime.Text#Reader): Unit = {
        _setPointerField[org.murtsi.capnproto.runtime.Text](0, value)
      }
      def displayName_=(value: String): Unit = {
        _setPointerField[org.murtsi.capnproto.runtime.Text](0, org.murtsi.capnproto.runtime.Text.Reader(value))
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
      def nestedNodes: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Node#NestedNode]#Builder = {
        _getPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Node#NestedNode]](1)
      }
      def nestedNodes_=(value: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Node#NestedNode]#Reader): Unit = {
        _setPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Node#NestedNode]](1, value)
      }
      def annotations: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Annotation]#Builder = {
        _getPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Annotation]](2)
      }
      def annotations_=(value: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Annotation]#Reader): Unit = {
        _setPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Annotation]](2, value)
      }
      def file_=(_value: Unit): Unit = {
        _setShortField(6, 0)
      }
      private[Node] def struct: Node#Struct#Builder = {
        Node.Struct.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }
      private[Node] def enum: Node#Enum#Builder = {
        Node.Enum.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }
      private[Node] def interface: Node#Interface#Builder = {
        Node.Interface.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }
      private[Node] def const: Node#Const#Builder = {
        Node.Const.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }
      private[Node] def annotation: Node#Annotation#Builder = {
        Node.Annotation.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }
      def parameters: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Node#Parameter]#Builder = {
        _getPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Node#Parameter]](5)
      }
      def parameters_=(value: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Node#Parameter]#Reader): Unit = {
        _setPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Node#Parameter]](5, value)
      }
      def isGeneric: Boolean = {
        _getBooleanField(288)
      }
      def isGeneric_=(value: Boolean): Unit = {
        _setBooleanField(288, value)
      }
      private[Node] def _whichIndex: Short = _getShortField(6)
      object has {
        def displayName: Boolean = {
          _pointerFieldIsNull(0)
        }
        def nestedNodes: Boolean = {
          _pointerFieldIsNull(1)
        }
        def annotations: Boolean = {
          _pointerFieldIsNull(2)
        }
        def parameters: Boolean = {
          _pointerFieldIsNull(5)
        }
      }
      object init {
        def displayName(size: Int): org.murtsi.capnproto.runtime.Text#Builder = {
          _initPointerField[org.murtsi.capnproto.runtime.Text](0, size)
        }
        def nestedNodes(size: Int): org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Node#NestedNode]#Builder = {
          _initPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Node#NestedNode]](1, size)
        }
        def annotations(size: Int): org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Annotation]#Builder = {
          _initPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Annotation]](2, size)
        }
        def struct(): org.murtsi.capnproto.compiler.schema.Node.Struct#Builder = {
          _setShortField(6, 1)
          _setShortField(7, 0)
          _setShortField(12, 0)
          _setShortField(13, 0)
          _setBooleanField(224, false)
          _setShortField(15, 0)
          _setIntField(8, 0)
          _clearPointerField(3)
          org.murtsi.capnproto.compiler.schema.Node.Struct.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
        }
        def enum(): org.murtsi.capnproto.compiler.schema.Node.Enum#Builder = {
          _setShortField(6, 2)
          _clearPointerField(3)
          org.murtsi.capnproto.compiler.schema.Node.Enum.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
        }
        def interface(): org.murtsi.capnproto.compiler.schema.Node.Interface#Builder = {
          _setShortField(6, 3)
          _clearPointerField(3)
          _clearPointerField(4)
          org.murtsi.capnproto.compiler.schema.Node.Interface.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
        }
        def const(): org.murtsi.capnproto.compiler.schema.Node.Const#Builder = {
          _setShortField(6, 4)
          _clearPointerField(3)
          _clearPointerField(4)
          org.murtsi.capnproto.compiler.schema.Node.Const.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
        }
        def annotation(): org.murtsi.capnproto.compiler.schema.Node.Annotation#Builder = {
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
          org.murtsi.capnproto.compiler.schema.Node.Annotation.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
        }
        def parameters(size: Int): org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Node#Parameter]#Builder = {
          _initPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Node#Parameter]](5, size)
        }
      }
    }
    object File {
      def unapply(value: Node#Reader): Boolean = value._whichIndex == 0
      def unapply(value: Node#Builder): Boolean = value._whichIndex == 0
    }

    object Parameter extends Parameter
    sealed class Parameter private() extends org.murtsi.capnproto.runtime.Struct { 
      val typeId: Long = -5092977661570997327L
      override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(0, 1)

      override type Reader = ReaderImpl
      override type Builder = BuilderImpl

      override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
        def name: org.murtsi.capnproto.runtime.Text#Reader = {
          _getPointerField[org.murtsi.capnproto.runtime.Text](0)
        }
        object has {
          def name: Boolean = {
            _pointerFieldIsNull(0)
          }
        }
      }
      class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        def name: org.murtsi.capnproto.runtime.Text#Builder = {
          _getPointerField[org.murtsi.capnproto.runtime.Text](0)
        }
        def name_=(value: org.murtsi.capnproto.runtime.Text#Reader): Unit = {
          _setPointerField[org.murtsi.capnproto.runtime.Text](0, value)
        }
        def name_=(value: String): Unit = {
          _setPointerField[org.murtsi.capnproto.runtime.Text](0, org.murtsi.capnproto.runtime.Text.Reader(value))
        }
        object has {
          def name: Boolean = {
            _pointerFieldIsNull(0)
          }
        }
        object init {
          def name(size: Int): org.murtsi.capnproto.runtime.Text#Builder = {
            _initPointerField[org.murtsi.capnproto.runtime.Text](0, size)
          }
        }
      }
    }

    object NestedNode extends NestedNode
    sealed class NestedNode private() extends org.murtsi.capnproto.runtime.Struct { 
      val typeId: Long = -2396102210895232446L
      override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(1, 1)

      override type Reader = ReaderImpl
      override type Builder = BuilderImpl

      override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
        def name: org.murtsi.capnproto.runtime.Text#Reader = {
          _getPointerField[org.murtsi.capnproto.runtime.Text](0)
        }
        def id: Long = {
          this._getLongField(0)
        }
        object has {
          def name: Boolean = {
            _pointerFieldIsNull(0)
          }
        }
      }
      class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        def name: org.murtsi.capnproto.runtime.Text#Builder = {
          _getPointerField[org.murtsi.capnproto.runtime.Text](0)
        }
        def name_=(value: org.murtsi.capnproto.runtime.Text#Reader): Unit = {
          _setPointerField[org.murtsi.capnproto.runtime.Text](0, value)
        }
        def name_=(value: String): Unit = {
          _setPointerField[org.murtsi.capnproto.runtime.Text](0, org.murtsi.capnproto.runtime.Text.Reader(value))
        }
        def id: Long = {
          this._getLongField(0)
        }
        def id_=(value: Long): Unit = {
          _setLongField(0, value)
        }
        object has {
          def name: Boolean = {
            _pointerFieldIsNull(0)
          }
        }
        object init {
          def name(size: Int): org.murtsi.capnproto.runtime.Text#Builder = {
            _initPointerField[org.murtsi.capnproto.runtime.Text](0, size)
          }
        }
      }
    }

    object Struct extends Struct
    sealed class Struct private() extends org.murtsi.capnproto.runtime.Struct { 
      val typeId: Long = -7016412939225971659L
      override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(5, 6)

      override type Reader = ReaderImpl
      override type Builder = BuilderImpl

      override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def unapply(value: Node#Reader): Option[Node#Struct#Reader] = {
        if (value._whichIndex == 1) Some(value.struct) else None
      }
      def unapply(value: Node#Builder): Option[Node#Struct#Builder] = {
        if (value._whichIndex == 1) Some(value.struct) else None
      }
      class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
        def dataWordCount: Short = {
          this._getShortField(7)
        }
        def pointerCount: Short = {
          this._getShortField(12)
        }
        def preferredListEncoding: ElementSize = {
          ElementSize.enumValues(_getShortField(13))
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
        def fields: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Field]#Reader = {
          _getPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Field]](3)
        }
        object has {
          def fields: Boolean = {
            _pointerFieldIsNull(3)
          }
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
        def preferredListEncoding: ElementSize = {
          ElementSize.enumValues(_getShortField(13))
        }
        def preferredListEncoding_=(value: ElementSize): Unit = {
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
        def fields: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Field]#Builder = {
          _getPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Field]](3)
        }
        def fields_=(value: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Field]#Reader): Unit = {
          _setPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Field]](3, value)
        }
        object has {
          def fields: Boolean = {
            _pointerFieldIsNull(3)
          }
        }
        object init {
          def fields(size: Int): org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Field]#Builder = {
            _initPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Field]](3, size)
          }
        }
      }
    }

    object Enum extends Enum
    sealed class Enum private() extends org.murtsi.capnproto.runtime.Struct { 
      val typeId: Long = -5383293358930922088L
      override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(5, 6)

      override type Reader = ReaderImpl
      override type Builder = BuilderImpl

      override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def unapply(value: Node#Reader): Option[Node#Enum#Reader] = {
        if (value._whichIndex == 2) Some(value.enum) else None
      }
      def unapply(value: Node#Builder): Option[Node#Enum#Builder] = {
        if (value._whichIndex == 2) Some(value.enum) else None
      }
      class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
        def enumerants: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Enumerant]#Reader = {
          _getPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Enumerant]](3)
        }
        object has {
          def enumerants: Boolean = {
            _pointerFieldIsNull(3)
          }
        }
      }
      class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        def enumerants: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Enumerant]#Builder = {
          _getPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Enumerant]](3)
        }
        def enumerants_=(value: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Enumerant]#Reader): Unit = {
          _setPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Enumerant]](3, value)
        }
        object has {
          def enumerants: Boolean = {
            _pointerFieldIsNull(3)
          }
        }
        object init {
          def enumerants(size: Int): org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Enumerant]#Builder = {
            _initPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Enumerant]](3, size)
          }
        }
      }
    }

    object Interface extends Interface
    sealed class Interface private() extends org.murtsi.capnproto.runtime.Struct { 
      val typeId: Long = -1718312580255964785L
      override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(5, 6)

      override type Reader = ReaderImpl
      override type Builder = BuilderImpl

      override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def unapply(value: Node#Reader): Option[Node#Interface#Reader] = {
        if (value._whichIndex == 3) Some(value.interface) else None
      }
      def unapply(value: Node#Builder): Option[Node#Interface#Builder] = {
        if (value._whichIndex == 3) Some(value.interface) else None
      }
      class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
        def methods: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Method]#Reader = {
          _getPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Method]](3)
        }
        def superclasses: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Superclass]#Reader = {
          _getPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Superclass]](4)
        }
        object has {
          def methods: Boolean = {
            _pointerFieldIsNull(3)
          }
          def superclasses: Boolean = {
            _pointerFieldIsNull(4)
          }
        }
      }
      class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        def methods: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Method]#Builder = {
          _getPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Method]](3)
        }
        def methods_=(value: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Method]#Reader): Unit = {
          _setPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Method]](3, value)
        }
        def superclasses: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Superclass]#Builder = {
          _getPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Superclass]](4)
        }
        def superclasses_=(value: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Superclass]#Reader): Unit = {
          _setPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Superclass]](4, value)
        }
        object has {
          def methods: Boolean = {
            _pointerFieldIsNull(3)
          }
          def superclasses: Boolean = {
            _pointerFieldIsNull(4)
          }
        }
        object init {
          def methods(size: Int): org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Method]#Builder = {
            _initPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Method]](3, size)
          }
          def superclasses(size: Int): org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Superclass]#Builder = {
            _initPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Superclass]](4, size)
          }
        }
      }
    }

    object Const extends Const
    sealed class Const private() extends org.murtsi.capnproto.runtime.Struct { 
      val typeId: Long = -5653524222009568224L
      override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(5, 6)

      override type Reader = ReaderImpl
      override type Builder = BuilderImpl

      override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def unapply(value: Node#Reader): Option[Node#Const#Reader] = {
        if (value._whichIndex == 4) Some(value.const) else None
      }
      def unapply(value: Node#Builder): Option[Node#Const#Builder] = {
        if (value._whichIndex == 4) Some(value.const) else None
      }
      class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
        def `type`: org.murtsi.capnproto.compiler.schema.Type#Reader = {
          _getPointerField[org.murtsi.capnproto.compiler.schema.Type](3)
        }
        def value: org.murtsi.capnproto.compiler.schema.Value#Reader = {
          _getPointerField[org.murtsi.capnproto.compiler.schema.Value](4)
        }
        object has {
          def `type`: Boolean = {
            _pointerFieldIsNull(3)
          }
          def value: Boolean = {
            _pointerFieldIsNull(4)
          }
        }
      }
      class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        def `type`: org.murtsi.capnproto.compiler.schema.Type#Builder = {
          _getPointerField[org.murtsi.capnproto.compiler.schema.Type](3)
        }
        def type_=(value: org.murtsi.capnproto.compiler.schema.Type#Reader): Unit = {
          _setPointerField[org.murtsi.capnproto.compiler.schema.Type](3, value)
        }
        def value: org.murtsi.capnproto.compiler.schema.Value#Builder = {
          _getPointerField[org.murtsi.capnproto.compiler.schema.Value](4)
        }
        def value_=(value: org.murtsi.capnproto.compiler.schema.Value#Reader): Unit = {
          _setPointerField[org.murtsi.capnproto.compiler.schema.Value](4, value)
        }
        object has {
          def `type`: Boolean = {
            _pointerFieldIsNull(3)
          }
          def value: Boolean = {
            _pointerFieldIsNull(4)
          }
        }
        object init {
          def `type`(): org.murtsi.capnproto.compiler.schema.Type#Builder = {
            _initPointerField[org.murtsi.capnproto.compiler.schema.Type](3, 0)
          }
          def value(): org.murtsi.capnproto.compiler.schema.Value#Builder = {
            _initPointerField[org.murtsi.capnproto.compiler.schema.Value](4, 0)
          }
        }
      }
    }

    object Annotation extends Annotation
    sealed class Annotation private() extends org.murtsi.capnproto.runtime.Struct { 
      val typeId: Long = -1434931031872765296L
      override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(5, 6)

      override type Reader = ReaderImpl
      override type Builder = BuilderImpl

      override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def unapply(value: Node#Reader): Option[Node#Annotation#Reader] = {
        if (value._whichIndex == 5) Some(value.annotation) else None
      }
      def unapply(value: Node#Builder): Option[Node#Annotation#Builder] = {
        if (value._whichIndex == 5) Some(value.annotation) else None
      }
      class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
        def `type`: org.murtsi.capnproto.compiler.schema.Type#Reader = {
          _getPointerField[org.murtsi.capnproto.compiler.schema.Type](3)
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
        object has {
          def `type`: Boolean = {
            _pointerFieldIsNull(3)
          }
        }
      }
      class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        def `type`: org.murtsi.capnproto.compiler.schema.Type#Builder = {
          _getPointerField[org.murtsi.capnproto.compiler.schema.Type](3)
        }
        def type_=(value: org.murtsi.capnproto.compiler.schema.Type#Reader): Unit = {
          _setPointerField[org.murtsi.capnproto.compiler.schema.Type](3, value)
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
        object has {
          def `type`: Boolean = {
            _pointerFieldIsNull(3)
          }
        }
        object init {
          def `type`(): org.murtsi.capnproto.compiler.schema.Type#Builder = {
            _initPointerField[org.murtsi.capnproto.compiler.schema.Type](3, 0)
          }
        }
      }
    }
  }

  object Field extends Field
  sealed class Field private() extends org.murtsi.capnproto.runtime.Struct { 
    val typeId: Long = -7301090755067841441L
    override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(3, 4)

    override type Reader = ReaderImpl
    override type Builder = BuilderImpl

    override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
      def name: org.murtsi.capnproto.runtime.Text#Reader = {
        _getPointerField[org.murtsi.capnproto.runtime.Text](0)
      }
      def codeOrder: Short = {
        this._getShortField(0)
      }
      def annotations: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Annotation]#Reader = {
        _getPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Annotation]](1)
      }
      def discriminantValue: Short = {
        this._getShortField(1, -1)
      }
      private[Field] def slot: Field#Slot#Reader = {
        Field.Slot.Reader(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit)
      }
      private[Field] def group: Field#Group#Reader = {
        Field.Group.Reader(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit)
      }
      def ordinal: Field#Ordinal#Reader = {
        Field.Ordinal.Reader(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit)
      }
      private[Field] def _whichIndex: Short = _getShortField(4)
      object has {
        def name: Boolean = {
          _pointerFieldIsNull(0)
        }
        def annotations: Boolean = {
          _pointerFieldIsNull(1)
        }
      }
    }
    class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
      def name: org.murtsi.capnproto.runtime.Text#Builder = {
        _getPointerField[org.murtsi.capnproto.runtime.Text](0)
      }
      def name_=(value: org.murtsi.capnproto.runtime.Text#Reader): Unit = {
        _setPointerField[org.murtsi.capnproto.runtime.Text](0, value)
      }
      def name_=(value: String): Unit = {
        _setPointerField[org.murtsi.capnproto.runtime.Text](0, org.murtsi.capnproto.runtime.Text.Reader(value))
      }
      def codeOrder: Short = {
        this._getShortField(0)
      }
      def codeOrder_=(value: Short): Unit = {
        _setShortField(0, value)
      }
      def annotations: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Annotation]#Builder = {
        _getPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Annotation]](1)
      }
      def annotations_=(value: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Annotation]#Reader): Unit = {
        _setPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Annotation]](1, value)
      }
      def discriminantValue: Short = {
        this._getShortField(1, -1)
      }
      def discriminantValue_=(value: Short): Unit = {
        _setShortField(1, value, -1)
      }
      private[Field] def slot: Field#Slot#Builder = {
        Field.Slot.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }
      private[Field] def group: Field#Group#Builder = {
        Field.Group.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }
      def ordinal: Field#Ordinal#Builder = {
        Field.Ordinal.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }
      private[Field] def _whichIndex: Short = _getShortField(4)
      object has {
        def name: Boolean = {
          _pointerFieldIsNull(0)
        }
        def annotations: Boolean = {
          _pointerFieldIsNull(1)
        }
      }
      object init {
        def name(size: Int): org.murtsi.capnproto.runtime.Text#Builder = {
          _initPointerField[org.murtsi.capnproto.runtime.Text](0, size)
        }
        def annotations(size: Int): org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Annotation]#Builder = {
          _initPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Annotation]](1, size)
        }
        def slot(): org.murtsi.capnproto.compiler.schema.Field.Slot#Builder = {
          _setShortField(4, 0)
          _setIntField(1, 0)
          _clearPointerField(2)
          _clearPointerField(3)
          _setBooleanField(128, false)
          org.murtsi.capnproto.compiler.schema.Field.Slot.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
        }
        def group(): org.murtsi.capnproto.compiler.schema.Field.Group#Builder = {
          _setShortField(4, 1)
          _setLongField(2, 0)
          org.murtsi.capnproto.compiler.schema.Field.Group.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
        }
        def ordinal(): org.murtsi.capnproto.compiler.schema.Field.Ordinal#Builder = {
          _setShortField(5, 0)
          _setShortField(6, 0)
          org.murtsi.capnproto.compiler.schema.Field.Ordinal.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
        }
      }
    }
    val NoDiscriminant: Short = -1

    object Slot extends Slot
    sealed class Slot private() extends org.murtsi.capnproto.runtime.Struct { 
      val typeId: Long = -4313598213782997905L
      override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(3, 4)

      override type Reader = ReaderImpl
      override type Builder = BuilderImpl

      override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def unapply(value: Field#Reader): Option[Field#Slot#Reader] = {
        if (value._whichIndex == 0) Some(value.slot) else None
      }
      def unapply(value: Field#Builder): Option[Field#Slot#Builder] = {
        if (value._whichIndex == 0) Some(value.slot) else None
      }
      class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
        def offset: Int = {
          this._getIntField(1)
        }
        def `type`: org.murtsi.capnproto.compiler.schema.Type#Reader = {
          _getPointerField[org.murtsi.capnproto.compiler.schema.Type](2)
        }
        def defaultValue: org.murtsi.capnproto.compiler.schema.Value#Reader = {
          _getPointerField[org.murtsi.capnproto.compiler.schema.Value](3)
        }
        def hadExplicitDefault: Boolean = {
          _getBooleanField(128)
        }
        object has {
          def `type`: Boolean = {
            _pointerFieldIsNull(2)
          }
          def defaultValue: Boolean = {
            _pointerFieldIsNull(3)
          }
        }
      }
      class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        def offset: Int = {
          this._getIntField(1)
        }
        def offset_=(value: Int): Unit = {
          _setIntField(1, value)
        }
        def `type`: org.murtsi.capnproto.compiler.schema.Type#Builder = {
          _getPointerField[org.murtsi.capnproto.compiler.schema.Type](2)
        }
        def type_=(value: org.murtsi.capnproto.compiler.schema.Type#Reader): Unit = {
          _setPointerField[org.murtsi.capnproto.compiler.schema.Type](2, value)
        }
        def defaultValue: org.murtsi.capnproto.compiler.schema.Value#Builder = {
          _getPointerField[org.murtsi.capnproto.compiler.schema.Value](3)
        }
        def defaultValue_=(value: org.murtsi.capnproto.compiler.schema.Value#Reader): Unit = {
          _setPointerField[org.murtsi.capnproto.compiler.schema.Value](3, value)
        }
        def hadExplicitDefault: Boolean = {
          _getBooleanField(128)
        }
        def hadExplicitDefault_=(value: Boolean): Unit = {
          _setBooleanField(128, value)
        }
        object has {
          def `type`: Boolean = {
            _pointerFieldIsNull(2)
          }
          def defaultValue: Boolean = {
            _pointerFieldIsNull(3)
          }
        }
        object init {
          def `type`(): org.murtsi.capnproto.compiler.schema.Type#Builder = {
            _initPointerField[org.murtsi.capnproto.compiler.schema.Type](2, 0)
          }
          def defaultValue(): org.murtsi.capnproto.compiler.schema.Value#Builder = {
            _initPointerField[org.murtsi.capnproto.compiler.schema.Value](3, 0)
          }
        }
      }
    }

    object Group extends Group
    sealed class Group private() extends org.murtsi.capnproto.runtime.Struct { 
      val typeId: Long = -3819952041676301039L
      override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(3, 4)

      override type Reader = ReaderImpl
      override type Builder = BuilderImpl

      override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def unapply(value: Field#Reader): Option[Field#Group#Reader] = {
        if (value._whichIndex == 1) Some(value.group) else None
      }
      def unapply(value: Field#Builder): Option[Field#Group#Builder] = {
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

    object Ordinal extends Ordinal
    sealed class Ordinal private() extends org.murtsi.capnproto.runtime.Struct { 
      val typeId: Long = -4931206560496546842L
      override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(3, 4)

      override type Reader = ReaderImpl
      override type Builder = BuilderImpl

      override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def unapply(value: Field#Reader): Option[Field#Ordinal#Reader] = {
        if (value._whichIndex == -1) Some(value.ordinal) else None
      }
      def unapply(value: Field#Builder): Option[Field#Ordinal#Builder] = {
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
        def unapply(value: Field#Ordinal#Reader): Boolean = value._whichIndex == 0
        def unapply(value: Field#Ordinal#Builder): Boolean = value._whichIndex == 0
      }
      object Explicit {
        def unapply(value: Field#Ordinal#Reader): Option[Short] = {
          if (value._whichIndex == 1) Some(value.explicit) else None
        }
        def unapply(value: Field#Ordinal#Builder): Option[Short] = {
          if (value._whichIndex == 1) Some(value.explicit) else None
        }
      }
    }
  }

  object Enumerant extends Enumerant
  sealed class Enumerant private() extends org.murtsi.capnproto.runtime.Struct { 
    val typeId: Long = -7527066474740671923L
    override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(1, 2)

    override type Reader = ReaderImpl
    override type Builder = BuilderImpl

    override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
      def name: org.murtsi.capnproto.runtime.Text#Reader = {
        _getPointerField[org.murtsi.capnproto.runtime.Text](0)
      }
      def codeOrder: Short = {
        this._getShortField(0)
      }
      def annotations: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Annotation]#Reader = {
        _getPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Annotation]](1)
      }
      object has {
        def name: Boolean = {
          _pointerFieldIsNull(0)
        }
        def annotations: Boolean = {
          _pointerFieldIsNull(1)
        }
      }
    }
    class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
      def name: org.murtsi.capnproto.runtime.Text#Builder = {
        _getPointerField[org.murtsi.capnproto.runtime.Text](0)
      }
      def name_=(value: org.murtsi.capnproto.runtime.Text#Reader): Unit = {
        _setPointerField[org.murtsi.capnproto.runtime.Text](0, value)
      }
      def name_=(value: String): Unit = {
        _setPointerField[org.murtsi.capnproto.runtime.Text](0, org.murtsi.capnproto.runtime.Text.Reader(value))
      }
      def codeOrder: Short = {
        this._getShortField(0)
      }
      def codeOrder_=(value: Short): Unit = {
        _setShortField(0, value)
      }
      def annotations: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Annotation]#Builder = {
        _getPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Annotation]](1)
      }
      def annotations_=(value: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Annotation]#Reader): Unit = {
        _setPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Annotation]](1, value)
      }
      object has {
        def name: Boolean = {
          _pointerFieldIsNull(0)
        }
        def annotations: Boolean = {
          _pointerFieldIsNull(1)
        }
      }
      object init {
        def name(size: Int): org.murtsi.capnproto.runtime.Text#Builder = {
          _initPointerField[org.murtsi.capnproto.runtime.Text](0, size)
        }
        def annotations(size: Int): org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Annotation]#Builder = {
          _initPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Annotation]](1, size)
        }
      }
    }
  }

  object Superclass extends Superclass
  sealed class Superclass private() extends org.murtsi.capnproto.runtime.Struct { 
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
      def brand: org.murtsi.capnproto.compiler.schema.Brand#Reader = {
        _getPointerField[org.murtsi.capnproto.compiler.schema.Brand](0)
      }
      object has {
        def brand: Boolean = {
          _pointerFieldIsNull(0)
        }
      }
    }
    class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
      def id: Long = {
        this._getLongField(0)
      }
      def id_=(value: Long): Unit = {
        _setLongField(0, value)
      }
      def brand: org.murtsi.capnproto.compiler.schema.Brand#Builder = {
        _getPointerField[org.murtsi.capnproto.compiler.schema.Brand](0)
      }
      def brand_=(value: org.murtsi.capnproto.compiler.schema.Brand#Reader): Unit = {
        _setPointerField[org.murtsi.capnproto.compiler.schema.Brand](0, value)
      }
      object has {
        def brand: Boolean = {
          _pointerFieldIsNull(0)
        }
      }
      object init {
        def brand(): org.murtsi.capnproto.compiler.schema.Brand#Builder = {
          _initPointerField[org.murtsi.capnproto.compiler.schema.Brand](0, 0)
        }
      }
    }
  }

  object Method extends Method
  sealed class Method private() extends org.murtsi.capnproto.runtime.Struct { 
    val typeId: Long = -7709937290030396032L
    override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(3, 5)

    override type Reader = ReaderImpl
    override type Builder = BuilderImpl

    override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
      def name: org.murtsi.capnproto.runtime.Text#Reader = {
        _getPointerField[org.murtsi.capnproto.runtime.Text](0)
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
      def annotations: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Annotation]#Reader = {
        _getPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Annotation]](1)
      }
      def paramBrand: org.murtsi.capnproto.compiler.schema.Brand#Reader = {
        _getPointerField[org.murtsi.capnproto.compiler.schema.Brand](2)
      }
      def resultBrand: org.murtsi.capnproto.compiler.schema.Brand#Reader = {
        _getPointerField[org.murtsi.capnproto.compiler.schema.Brand](3)
      }
      def implicitParameters: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Node#Parameter]#Reader = {
        _getPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Node#Parameter]](4)
      }
      object has {
        def name: Boolean = {
          _pointerFieldIsNull(0)
        }
        def annotations: Boolean = {
          _pointerFieldIsNull(1)
        }
        def paramBrand: Boolean = {
          _pointerFieldIsNull(2)
        }
        def resultBrand: Boolean = {
          _pointerFieldIsNull(3)
        }
        def implicitParameters: Boolean = {
          _pointerFieldIsNull(4)
        }
      }
    }
    class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
      def name: org.murtsi.capnproto.runtime.Text#Builder = {
        _getPointerField[org.murtsi.capnproto.runtime.Text](0)
      }
      def name_=(value: org.murtsi.capnproto.runtime.Text#Reader): Unit = {
        _setPointerField[org.murtsi.capnproto.runtime.Text](0, value)
      }
      def name_=(value: String): Unit = {
        _setPointerField[org.murtsi.capnproto.runtime.Text](0, org.murtsi.capnproto.runtime.Text.Reader(value))
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
      def annotations: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Annotation]#Builder = {
        _getPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Annotation]](1)
      }
      def annotations_=(value: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Annotation]#Reader): Unit = {
        _setPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Annotation]](1, value)
      }
      def paramBrand: org.murtsi.capnproto.compiler.schema.Brand#Builder = {
        _getPointerField[org.murtsi.capnproto.compiler.schema.Brand](2)
      }
      def paramBrand_=(value: org.murtsi.capnproto.compiler.schema.Brand#Reader): Unit = {
        _setPointerField[org.murtsi.capnproto.compiler.schema.Brand](2, value)
      }
      def resultBrand: org.murtsi.capnproto.compiler.schema.Brand#Builder = {
        _getPointerField[org.murtsi.capnproto.compiler.schema.Brand](3)
      }
      def resultBrand_=(value: org.murtsi.capnproto.compiler.schema.Brand#Reader): Unit = {
        _setPointerField[org.murtsi.capnproto.compiler.schema.Brand](3, value)
      }
      def implicitParameters: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Node#Parameter]#Builder = {
        _getPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Node#Parameter]](4)
      }
      def implicitParameters_=(value: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Node#Parameter]#Reader): Unit = {
        _setPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Node#Parameter]](4, value)
      }
      object has {
        def name: Boolean = {
          _pointerFieldIsNull(0)
        }
        def annotations: Boolean = {
          _pointerFieldIsNull(1)
        }
        def paramBrand: Boolean = {
          _pointerFieldIsNull(2)
        }
        def resultBrand: Boolean = {
          _pointerFieldIsNull(3)
        }
        def implicitParameters: Boolean = {
          _pointerFieldIsNull(4)
        }
      }
      object init {
        def name(size: Int): org.murtsi.capnproto.runtime.Text#Builder = {
          _initPointerField[org.murtsi.capnproto.runtime.Text](0, size)
        }
        def annotations(size: Int): org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Annotation]#Builder = {
          _initPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Annotation]](1, size)
        }
        def paramBrand(): org.murtsi.capnproto.compiler.schema.Brand#Builder = {
          _initPointerField[org.murtsi.capnproto.compiler.schema.Brand](2, 0)
        }
        def resultBrand(): org.murtsi.capnproto.compiler.schema.Brand#Builder = {
          _initPointerField[org.murtsi.capnproto.compiler.schema.Brand](3, 0)
        }
        def implicitParameters(size: Int): org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Node#Parameter]#Builder = {
          _initPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Node#Parameter]](4, size)
        }
      }
    }
  }

  object Type extends Type
  sealed class Type private() extends org.murtsi.capnproto.runtime.Struct { 
    val typeId: Long = -3426261928404988832L
    override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(3, 1)

    override type Reader = ReaderImpl
    override type Builder = BuilderImpl

    override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
      private[Type] def list: Type#_List#Reader = {
        Type._List.Reader(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit)
      }
      private[Type] def enum: Type#Enum#Reader = {
        Type.Enum.Reader(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit)
      }
      private[Type] def struct: Type#Struct#Reader = {
        Type.Struct.Reader(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit)
      }
      private[Type] def interface: Type#Interface#Reader = {
        Type.Interface.Reader(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit)
      }
      private[Type] def anyPointer: Type#AnyPointer#Reader = {
        Type.AnyPointer.Reader(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit)
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
      private[Type] def list: Type#_List#Builder = {
        Type._List.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }
      private[Type] def enum: Type#Enum#Builder = {
        Type.Enum.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }
      private[Type] def struct: Type#Struct#Builder = {
        Type.Struct.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }
      private[Type] def interface: Type#Interface#Builder = {
        Type.Interface.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }
      private[Type] def anyPointer: Type#AnyPointer#Builder = {
        Type.AnyPointer.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
      }
      private[Type] def _whichIndex: Short = _getShortField(0)
      object init {
        def list(): org.murtsi.capnproto.compiler.schema.Type._List#Builder = {
          _setShortField(0, 14)
          _clearPointerField(0)
          org.murtsi.capnproto.compiler.schema.Type._List.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
        }
        def enum(): org.murtsi.capnproto.compiler.schema.Type.Enum#Builder = {
          _setShortField(0, 15)
          _setLongField(1, 0)
          _clearPointerField(0)
          org.murtsi.capnproto.compiler.schema.Type.Enum.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
        }
        def struct(): org.murtsi.capnproto.compiler.schema.Type.Struct#Builder = {
          _setShortField(0, 16)
          _setLongField(1, 0)
          _clearPointerField(0)
          org.murtsi.capnproto.compiler.schema.Type.Struct.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
        }
        def interface(): org.murtsi.capnproto.compiler.schema.Type.Interface#Builder = {
          _setShortField(0, 17)
          _setLongField(1, 0)
          _clearPointerField(0)
          org.murtsi.capnproto.compiler.schema.Type.Interface.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
        }
        def anyPointer(): org.murtsi.capnproto.compiler.schema.Type.AnyPointer#Builder = {
          _setShortField(0, 18)
          _setShortField(4, 0)
          _setLongField(2, 0)
          _setShortField(5, 0)
          _setShortField(5, 0)
          org.murtsi.capnproto.compiler.schema.Type.AnyPointer.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
        }
      }
    }
    object Void {
      def unapply(value: Type#Reader): Boolean = value._whichIndex == 0
      def unapply(value: Type#Builder): Boolean = value._whichIndex == 0
    }
    object Bool {
      def unapply(value: Type#Reader): Boolean = value._whichIndex == 1
      def unapply(value: Type#Builder): Boolean = value._whichIndex == 1
    }
    object Int8 {
      def unapply(value: Type#Reader): Boolean = value._whichIndex == 2
      def unapply(value: Type#Builder): Boolean = value._whichIndex == 2
    }
    object Int16 {
      def unapply(value: Type#Reader): Boolean = value._whichIndex == 3
      def unapply(value: Type#Builder): Boolean = value._whichIndex == 3
    }
    object Int32 {
      def unapply(value: Type#Reader): Boolean = value._whichIndex == 4
      def unapply(value: Type#Builder): Boolean = value._whichIndex == 4
    }
    object Int64 {
      def unapply(value: Type#Reader): Boolean = value._whichIndex == 5
      def unapply(value: Type#Builder): Boolean = value._whichIndex == 5
    }
    object Uint8 {
      def unapply(value: Type#Reader): Boolean = value._whichIndex == 6
      def unapply(value: Type#Builder): Boolean = value._whichIndex == 6
    }
    object Uint16 {
      def unapply(value: Type#Reader): Boolean = value._whichIndex == 7
      def unapply(value: Type#Builder): Boolean = value._whichIndex == 7
    }
    object Uint32 {
      def unapply(value: Type#Reader): Boolean = value._whichIndex == 8
      def unapply(value: Type#Builder): Boolean = value._whichIndex == 8
    }
    object Uint64 {
      def unapply(value: Type#Reader): Boolean = value._whichIndex == 9
      def unapply(value: Type#Builder): Boolean = value._whichIndex == 9
    }
    object Float32 {
      def unapply(value: Type#Reader): Boolean = value._whichIndex == 10
      def unapply(value: Type#Builder): Boolean = value._whichIndex == 10
    }
    object Float64 {
      def unapply(value: Type#Reader): Boolean = value._whichIndex == 11
      def unapply(value: Type#Builder): Boolean = value._whichIndex == 11
    }
    object Text {
      def unapply(value: Type#Reader): Boolean = value._whichIndex == 12
      def unapply(value: Type#Builder): Boolean = value._whichIndex == 12
    }
    object Data {
      def unapply(value: Type#Reader): Boolean = value._whichIndex == 13
      def unapply(value: Type#Builder): Boolean = value._whichIndex == 13
    }

    object _List extends _List
    sealed class _List private() extends org.murtsi.capnproto.runtime.Struct { 
      val typeId: Long = -8653885327718421865L
      override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(3, 1)

      override type Reader = ReaderImpl
      override type Builder = BuilderImpl

      override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def unapply(value: Type#Reader): Option[Type#_List#Reader] = {
        if (value._whichIndex == 14) Some(value.list) else None
      }
      def unapply(value: Type#Builder): Option[Type#_List#Builder] = {
        if (value._whichIndex == 14) Some(value.list) else None
      }
      class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
        def elementType: org.murtsi.capnproto.compiler.schema.Type#Reader = {
          _getPointerField[org.murtsi.capnproto.compiler.schema.Type](0)
        }
        object has {
          def elementType: Boolean = {
            _pointerFieldIsNull(0)
          }
        }
      }
      class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        def elementType: org.murtsi.capnproto.compiler.schema.Type#Builder = {
          _getPointerField[org.murtsi.capnproto.compiler.schema.Type](0)
        }
        def elementType_=(value: org.murtsi.capnproto.compiler.schema.Type#Reader): Unit = {
          _setPointerField[org.murtsi.capnproto.compiler.schema.Type](0, value)
        }
        object has {
          def elementType: Boolean = {
            _pointerFieldIsNull(0)
          }
        }
        object init {
          def elementType(): org.murtsi.capnproto.compiler.schema.Type#Builder = {
            _initPointerField[org.murtsi.capnproto.compiler.schema.Type](0, 0)
          }
        }
      }
    }

    object Enum extends Enum
    sealed class Enum private() extends org.murtsi.capnproto.runtime.Struct { 
      val typeId: Long = -7057571138871785559L
      override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(3, 1)

      override type Reader = ReaderImpl
      override type Builder = BuilderImpl

      override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def unapply(value: Type#Reader): Option[Type#Enum#Reader] = {
        if (value._whichIndex == 15) Some(value.enum) else None
      }
      def unapply(value: Type#Builder): Option[Type#Enum#Builder] = {
        if (value._whichIndex == 15) Some(value.enum) else None
      }
      class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
        def typeId: Long = {
          this._getLongField(1)
        }
        def brand: org.murtsi.capnproto.compiler.schema.Brand#Reader = {
          _getPointerField[org.murtsi.capnproto.compiler.schema.Brand](0)
        }
        object has {
          def brand: Boolean = {
            _pointerFieldIsNull(0)
          }
        }
      }
      class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        def typeId: Long = {
          this._getLongField(1)
        }
        def typeId_=(value: Long): Unit = {
          _setLongField(1, value)
        }
        def brand: org.murtsi.capnproto.compiler.schema.Brand#Builder = {
          _getPointerField[org.murtsi.capnproto.compiler.schema.Brand](0)
        }
        def brand_=(value: org.murtsi.capnproto.compiler.schema.Brand#Reader): Unit = {
          _setPointerField[org.murtsi.capnproto.compiler.schema.Brand](0, value)
        }
        object has {
          def brand: Boolean = {
            _pointerFieldIsNull(0)
          }
        }
        object init {
          def brand(): org.murtsi.capnproto.compiler.schema.Brand#Builder = {
            _initPointerField[org.murtsi.capnproto.compiler.schema.Brand](0, 0)
          }
        }
      }
    }

    object Struct extends Struct
    sealed class Struct private() extends org.murtsi.capnproto.runtime.Struct { 
      val typeId: Long = -6036389888414398765L
      override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(3, 1)

      override type Reader = ReaderImpl
      override type Builder = BuilderImpl

      override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def unapply(value: Type#Reader): Option[Type#Struct#Reader] = {
        if (value._whichIndex == 16) Some(value.struct) else None
      }
      def unapply(value: Type#Builder): Option[Type#Struct#Builder] = {
        if (value._whichIndex == 16) Some(value.struct) else None
      }
      class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
        def typeId: Long = {
          this._getLongField(1)
        }
        def brand: org.murtsi.capnproto.compiler.schema.Brand#Reader = {
          _getPointerField[org.murtsi.capnproto.compiler.schema.Brand](0)
        }
        object has {
          def brand: Boolean = {
            _pointerFieldIsNull(0)
          }
        }
      }
      class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        def typeId: Long = {
          this._getLongField(1)
        }
        def typeId_=(value: Long): Unit = {
          _setLongField(1, value)
        }
        def brand: org.murtsi.capnproto.compiler.schema.Brand#Builder = {
          _getPointerField[org.murtsi.capnproto.compiler.schema.Brand](0)
        }
        def brand_=(value: org.murtsi.capnproto.compiler.schema.Brand#Reader): Unit = {
          _setPointerField[org.murtsi.capnproto.compiler.schema.Brand](0, value)
        }
        object has {
          def brand: Boolean = {
            _pointerFieldIsNull(0)
          }
        }
        object init {
          def brand(): org.murtsi.capnproto.compiler.schema.Brand#Builder = {
            _initPointerField[org.murtsi.capnproto.compiler.schema.Brand](0, 0)
          }
        }
      }
    }

    object Interface extends Interface
    sealed class Interface private() extends org.murtsi.capnproto.runtime.Struct { 
      val typeId: Long = -1329746708477047617L
      override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(3, 1)

      override type Reader = ReaderImpl
      override type Builder = BuilderImpl

      override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def unapply(value: Type#Reader): Option[Type#Interface#Reader] = {
        if (value._whichIndex == 17) Some(value.interface) else None
      }
      def unapply(value: Type#Builder): Option[Type#Interface#Builder] = {
        if (value._whichIndex == 17) Some(value.interface) else None
      }
      class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
        def typeId: Long = {
          this._getLongField(1)
        }
        def brand: org.murtsi.capnproto.compiler.schema.Brand#Reader = {
          _getPointerField[org.murtsi.capnproto.compiler.schema.Brand](0)
        }
        object has {
          def brand: Boolean = {
            _pointerFieldIsNull(0)
          }
        }
      }
      class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        def typeId: Long = {
          this._getLongField(1)
        }
        def typeId_=(value: Long): Unit = {
          _setLongField(1, value)
        }
        def brand: org.murtsi.capnproto.compiler.schema.Brand#Builder = {
          _getPointerField[org.murtsi.capnproto.compiler.schema.Brand](0)
        }
        def brand_=(value: org.murtsi.capnproto.compiler.schema.Brand#Reader): Unit = {
          _setPointerField[org.murtsi.capnproto.compiler.schema.Brand](0, value)
        }
        object has {
          def brand: Boolean = {
            _pointerFieldIsNull(0)
          }
        }
        object init {
          def brand(): org.murtsi.capnproto.compiler.schema.Brand#Builder = {
            _initPointerField[org.murtsi.capnproto.compiler.schema.Brand](0, 0)
          }
        }
      }
    }

    object AnyPointer extends AnyPointer
    sealed class AnyPointer private() extends org.murtsi.capnproto.runtime.Struct { 
      val typeId: Long = -4443012238990751247L
      override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(3, 1)

      override type Reader = ReaderImpl
      override type Builder = BuilderImpl

      override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      def unapply(value: Type#Reader): Option[Type#AnyPointer#Reader] = {
        if (value._whichIndex == 18) Some(value.anyPointer) else None
      }
      def unapply(value: Type#Builder): Option[Type#AnyPointer#Builder] = {
        if (value._whichIndex == 18) Some(value.anyPointer) else None
      }
      class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
        private[AnyPointer] def parameter: Type#AnyPointer#Parameter#Reader = {
          Type.AnyPointer.Parameter.Reader(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit)
        }
        private[AnyPointer] def implicitMethodParameter: Type#AnyPointer#ImplicitMethodParameter#Reader = {
          Type.AnyPointer.ImplicitMethodParameter.Reader(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit)
        }
        private[AnyPointer] def _whichIndex: Short = _getShortField(4)
      }
      class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        def unconstrained_=(_value: Unit): Unit = {
          _setShortField(4, 0)
        }
        private[AnyPointer] def parameter: Type#AnyPointer#Parameter#Builder = {
          Type.AnyPointer.Parameter.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
        }
        private[AnyPointer] def implicitMethodParameter: Type#AnyPointer#ImplicitMethodParameter#Builder = {
          Type.AnyPointer.ImplicitMethodParameter.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
        }
        private[AnyPointer] def _whichIndex: Short = _getShortField(4)
        object init {
          def parameter(): org.murtsi.capnproto.compiler.schema.Type.AnyPointer.Parameter#Builder = {
            _setShortField(4, 1)
            _setLongField(2, 0)
            _setShortField(5, 0)
            org.murtsi.capnproto.compiler.schema.Type.AnyPointer.Parameter.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
          }
          def implicitMethodParameter(): org.murtsi.capnproto.compiler.schema.Type.AnyPointer.ImplicitMethodParameter#Builder = {
            _setShortField(4, 2)
            _setShortField(5, 0)
            org.murtsi.capnproto.compiler.schema.Type.AnyPointer.ImplicitMethodParameter.Builder(_segment, _dataOffset, _pointers, _dataSize, _pointerCount)
          }
        }
      }
      object Unconstrained {
        def unapply(value: Type#AnyPointer#Reader): Boolean = value._whichIndex == 0
        def unapply(value: Type#AnyPointer#Builder): Boolean = value._whichIndex == 0
      }

      object Parameter extends Parameter
      sealed class Parameter private() extends org.murtsi.capnproto.runtime.Struct { 
        val typeId: Long = -7074601801531438459L
        override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(3, 1)

        override type Reader = ReaderImpl
        override type Builder = BuilderImpl

        override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
        override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

        def unapply(value: Type#AnyPointer#Reader): Option[Type#AnyPointer#Parameter#Reader] = {
          if (value._whichIndex == 1) Some(value.parameter) else None
        }
        def unapply(value: Type#AnyPointer#Builder): Option[Type#AnyPointer#Parameter#Builder] = {
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

      object ImplicitMethodParameter extends ImplicitMethodParameter
      sealed class ImplicitMethodParameter private() extends org.murtsi.capnproto.runtime.Struct { 
        val typeId: Long = -4976537983867493772L
        override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(3, 1)

        override type Reader = ReaderImpl
        override type Builder = BuilderImpl

        override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
        override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

        def unapply(value: Type#AnyPointer#Reader): Option[Type#AnyPointer#ImplicitMethodParameter#Reader] = {
          if (value._whichIndex == 2) Some(value.implicitMethodParameter) else None
        }
        def unapply(value: Type#AnyPointer#Builder): Option[Type#AnyPointer#ImplicitMethodParameter#Builder] = {
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

  object Brand extends Brand
  sealed class Brand private() extends org.murtsi.capnproto.runtime.Struct { 
    val typeId: Long = -8055719342561213909L
    override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(0, 1)

    override type Reader = ReaderImpl
    override type Builder = BuilderImpl

    override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
      def scopes: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Brand#Scope]#Reader = {
        _getPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Brand#Scope]](0)
      }
      object has {
        def scopes: Boolean = {
          _pointerFieldIsNull(0)
        }
      }
    }
    class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
      def scopes: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Brand#Scope]#Builder = {
        _getPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Brand#Scope]](0)
      }
      def scopes_=(value: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Brand#Scope]#Reader): Unit = {
        _setPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Brand#Scope]](0, value)
      }
      object has {
        def scopes: Boolean = {
          _pointerFieldIsNull(0)
        }
      }
      object init {
        def scopes(size: Int): org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Brand#Scope]#Builder = {
          _initPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Brand#Scope]](0, size)
        }
      }
    }

    object Scope extends Scope
    sealed class Scope private() extends org.murtsi.capnproto.runtime.Struct { 
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
        private[Scope] def bind: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Brand#Binding]#Reader = {
          _getPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Brand#Binding]](0)
        }
        private[Scope] def _whichIndex: Short = _getShortField(4)
        object has {
          def bind: Boolean = {
            if (_getShortField(4) != 0) false
            else _pointerFieldIsNull(0)
          }
        }
      }
      class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        def scopeId: Long = {
          this._getLongField(0)
        }
        def scopeId_=(value: Long): Unit = {
          _setLongField(0, value)
        }
        private[Scope] def bind: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Brand#Binding]#Builder = {
          _getPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Brand#Binding]](0)
        }
        def bind_=(value: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Brand#Binding]#Reader): Unit = {
          _setShortField(4, 0)
          _setPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Brand#Binding]](0, value)
        }
        def inherit_=(_value: Unit): Unit = {
          _setShortField(4, 1)
        }
        private[Scope] def _whichIndex: Short = _getShortField(4)
        object has {
          def bind: Boolean = {
            if (_getShortField(4) != 0) false
            else _pointerFieldIsNull(0)
          }
        }
        object init {
          def bind(size: Int): org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Brand#Binding]#Builder = {
            _setShortField(4, 0)
            _initPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Brand#Binding]](0, size)
          }
        }
      }
      object Bind {
        def unapply(value: Brand#Scope#Reader): Option[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Brand#Binding]#Reader] = {
          if (value._whichIndex == 0) Some(value.bind) else None
        }
        def unapply(value: Brand#Scope#Builder): Option[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Brand#Binding]#Builder] = {
          if (value._whichIndex == 0) Some(value.bind) else None
        }
      }
      object Inherit {
        def unapply(value: Brand#Scope#Reader): Boolean = value._whichIndex == 1
        def unapply(value: Brand#Scope#Builder): Boolean = value._whichIndex == 1
      }
    }

    object Binding extends Binding
    sealed class Binding private() extends org.murtsi.capnproto.runtime.Struct { 
      val typeId: Long = -4007133746529638404L
      override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(1, 1)

      override type Reader = ReaderImpl
      override type Builder = BuilderImpl

      override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
      override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

      class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
        private[Binding] def `type`: org.murtsi.capnproto.compiler.schema.Type#Reader = {
          _getPointerField[org.murtsi.capnproto.compiler.schema.Type](0)
        }
        private[Binding] def _whichIndex: Short = _getShortField(0)
        object has {
          def `type`: Boolean = {
            if (_getShortField(0) != 1) false
            else _pointerFieldIsNull(0)
          }
        }
      }
      class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        def unbound_=(_value: Unit): Unit = {
          _setShortField(0, 0)
        }
        private[Binding] def `type`: org.murtsi.capnproto.compiler.schema.Type#Builder = {
          _getPointerField[org.murtsi.capnproto.compiler.schema.Type](0)
        }
        def type_=(value: org.murtsi.capnproto.compiler.schema.Type#Reader): Unit = {
          _setShortField(0, 1)
          _setPointerField[org.murtsi.capnproto.compiler.schema.Type](0, value)
        }
        private[Binding] def _whichIndex: Short = _getShortField(0)
        object has {
          def `type`: Boolean = {
            if (_getShortField(0) != 1) false
            else _pointerFieldIsNull(0)
          }
        }
        object init {
          def `type`(): org.murtsi.capnproto.compiler.schema.Type#Builder = {
            _setShortField(0, 1)
            _initPointerField[org.murtsi.capnproto.compiler.schema.Type](0, 0)
          }
        }
      }
      object Unbound {
        def unapply(value: Brand#Binding#Reader): Boolean = value._whichIndex == 0
        def unapply(value: Brand#Binding#Builder): Boolean = value._whichIndex == 0
      }
      object Type {
        def unapply(value: Brand#Binding#Reader): Option[org.murtsi.capnproto.compiler.schema.Type#Reader] = {
          if (value._whichIndex == 1) Some(value.`type`) else None
        }
        def unapply(value: Brand#Binding#Builder): Option[org.murtsi.capnproto.compiler.schema.Type#Builder] = {
          if (value._whichIndex == 1) Some(value.`type`) else None
        }
      }
    }
  }

  object Value extends Value
  sealed class Value private() extends org.murtsi.capnproto.runtime.Struct { 
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
      private[Value] def text: org.murtsi.capnproto.runtime.Text#Reader = {
        _getPointerField[org.murtsi.capnproto.runtime.Text](0)
      }
      private[Value] def data: org.murtsi.capnproto.runtime.Data#Reader = {
        _getPointerField[org.murtsi.capnproto.runtime.Data](0)
      }
      private[Value] def list: org.murtsi.capnproto.runtime.AnyPointer#Reader = {
        _getPointerField[org.murtsi.capnproto.runtime.AnyPointer](0)
      }
      private[Value] def enum: Short = {
        this._getShortField(1)
      }
      private[Value] def struct: org.murtsi.capnproto.runtime.AnyPointer#Reader = {
        _getPointerField[org.murtsi.capnproto.runtime.AnyPointer](0)
      }
      private[Value] def anyPointer: org.murtsi.capnproto.runtime.AnyPointer#Reader = {
        _getPointerField[org.murtsi.capnproto.runtime.AnyPointer](0)
      }
      private[Value] def _whichIndex: Short = _getShortField(0)
      object has {
        def text: Boolean = {
          if (_getShortField(0) != 12) false
          else _pointerFieldIsNull(0)
        }
        def data: Boolean = {
          if (_getShortField(0) != 13) false
          else _pointerFieldIsNull(0)
        }
        def list: Boolean = {
          if (_getShortField(0) != 14) false
          else _pointerFieldIsNull(0)
        }
        def struct: Boolean = {
          if (_getShortField(0) != 16) false
          else _pointerFieldIsNull(0)
        }
        def anyPointer: Boolean = {
          if (_getShortField(0) != 18) false
          else _pointerFieldIsNull(0)
        }
      }
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
      private[Value] def text: org.murtsi.capnproto.runtime.Text#Builder = {
        _getPointerField[org.murtsi.capnproto.runtime.Text](0)
      }
      def text_=(value: org.murtsi.capnproto.runtime.Text#Reader): Unit = {
        _setShortField(0, 12)
        _setPointerField[org.murtsi.capnproto.runtime.Text](0, value)
      }
      def text_=(value: String): Unit = {
        _setPointerField[org.murtsi.capnproto.runtime.Text](0, org.murtsi.capnproto.runtime.Text.Reader(value))
      }
      private[Value] def data: org.murtsi.capnproto.runtime.Data#Builder = {
        _getPointerField[org.murtsi.capnproto.runtime.Data](0)
      }
      def data_=(value: org.murtsi.capnproto.runtime.Data#Reader): Unit = {
        _setShortField(0, 13)
        _setPointerField[org.murtsi.capnproto.runtime.Data](0, value)
      }
      private[Value] def list: org.murtsi.capnproto.runtime.AnyPointer#Builder = {
        _getPointerField[org.murtsi.capnproto.runtime.AnyPointer](0)
      }
      def list_=(value: org.murtsi.capnproto.runtime.AnyPointer#Reader): Unit = {
        _setShortField(0, 14)
      }
      private[Value] def enum: Short = {
        this._getShortField(1)
      }
      def enum_=(value: Short): Unit = {
        _setShortField(0, 15)
        _setShortField(1, value)
      }
      private[Value] def struct: org.murtsi.capnproto.runtime.AnyPointer#Builder = {
        _getPointerField[org.murtsi.capnproto.runtime.AnyPointer](0)
      }
      def struct_=(value: org.murtsi.capnproto.runtime.AnyPointer#Reader): Unit = {
        _setShortField(0, 16)
      }
      def interface_=(_value: Unit): Unit = {
        _setShortField(0, 17)
      }
      private[Value] def anyPointer: org.murtsi.capnproto.runtime.AnyPointer#Builder = {
        _getPointerField[org.murtsi.capnproto.runtime.AnyPointer](0)
      }
      def anyPointer_=(value: org.murtsi.capnproto.runtime.AnyPointer#Reader): Unit = {
        _setShortField(0, 18)
      }
      private[Value] def _whichIndex: Short = _getShortField(0)
      object has {
        def text: Boolean = {
          if (_getShortField(0) != 12) false
          else _pointerFieldIsNull(0)
        }
        def data: Boolean = {
          if (_getShortField(0) != 13) false
          else _pointerFieldIsNull(0)
        }
        def list: Boolean = {
          if (_getShortField(0) != 14) false
          else _pointerFieldIsNull(0)
        }
        def struct: Boolean = {
          if (_getShortField(0) != 16) false
          else _pointerFieldIsNull(0)
        }
        def anyPointer: Boolean = {
          if (_getShortField(0) != 18) false
          else _pointerFieldIsNull(0)
        }
      }
      object init {
        def text(size: Int): org.murtsi.capnproto.runtime.Text#Builder = {
          _setShortField(0, 12)
          _initPointerField[org.murtsi.capnproto.runtime.Text](0, size)
        }
        def data(size: Int): org.murtsi.capnproto.runtime.Data#Builder = {
          _setShortField(0, 13)
          _initPointerField[org.murtsi.capnproto.runtime.Data](0, size)
        }
        def list(size: Int = 0): org.murtsi.capnproto.runtime.AnyPointer#Builder = {
          _setShortField(0, 14)
          _initPointerField[org.murtsi.capnproto.runtime.AnyPointer](0, size)
        }
        def struct(size: Int = 0): org.murtsi.capnproto.runtime.AnyPointer#Builder = {
          _setShortField(0, 16)
          _initPointerField[org.murtsi.capnproto.runtime.AnyPointer](0, size)
        }
        def anyPointer(size: Int = 0): org.murtsi.capnproto.runtime.AnyPointer#Builder = {
          _setShortField(0, 18)
          _initPointerField[org.murtsi.capnproto.runtime.AnyPointer](0, size)
        }
      }
    }
    object Void {
      def unapply(value: Value#Reader): Boolean = value._whichIndex == 0
      def unapply(value: Value#Builder): Boolean = value._whichIndex == 0
    }
    object Bool {
      def unapply(value: Value#Reader): Option[Boolean] = {
        if (value._whichIndex == 1) Some(value.bool) else None
      }
      def unapply(value: Value#Builder): Option[Boolean] = {
        if (value._whichIndex == 1) Some(value.bool) else None
      }
    }
    object Int8 {
      def unapply(value: Value#Reader): Option[Byte] = {
        if (value._whichIndex == 2) Some(value.int8) else None
      }
      def unapply(value: Value#Builder): Option[Byte] = {
        if (value._whichIndex == 2) Some(value.int8) else None
      }
    }
    object Int16 {
      def unapply(value: Value#Reader): Option[Short] = {
        if (value._whichIndex == 3) Some(value.int16) else None
      }
      def unapply(value: Value#Builder): Option[Short] = {
        if (value._whichIndex == 3) Some(value.int16) else None
      }
    }
    object Int32 {
      def unapply(value: Value#Reader): Option[Int] = {
        if (value._whichIndex == 4) Some(value.int32) else None
      }
      def unapply(value: Value#Builder): Option[Int] = {
        if (value._whichIndex == 4) Some(value.int32) else None
      }
    }
    object Int64 {
      def unapply(value: Value#Reader): Option[Long] = {
        if (value._whichIndex == 5) Some(value.int64) else None
      }
      def unapply(value: Value#Builder): Option[Long] = {
        if (value._whichIndex == 5) Some(value.int64) else None
      }
    }
    object Uint8 {
      def unapply(value: Value#Reader): Option[Byte] = {
        if (value._whichIndex == 6) Some(value.uint8) else None
      }
      def unapply(value: Value#Builder): Option[Byte] = {
        if (value._whichIndex == 6) Some(value.uint8) else None
      }
    }
    object Uint16 {
      def unapply(value: Value#Reader): Option[Short] = {
        if (value._whichIndex == 7) Some(value.uint16) else None
      }
      def unapply(value: Value#Builder): Option[Short] = {
        if (value._whichIndex == 7) Some(value.uint16) else None
      }
    }
    object Uint32 {
      def unapply(value: Value#Reader): Option[Int] = {
        if (value._whichIndex == 8) Some(value.uint32) else None
      }
      def unapply(value: Value#Builder): Option[Int] = {
        if (value._whichIndex == 8) Some(value.uint32) else None
      }
    }
    object Uint64 {
      def unapply(value: Value#Reader): Option[Long] = {
        if (value._whichIndex == 9) Some(value.uint64) else None
      }
      def unapply(value: Value#Builder): Option[Long] = {
        if (value._whichIndex == 9) Some(value.uint64) else None
      }
    }
    object Float32 {
      def unapply(value: Value#Reader): Option[Float] = {
        if (value._whichIndex == 10) Some(value.float32) else None
      }
      def unapply(value: Value#Builder): Option[Float] = {
        if (value._whichIndex == 10) Some(value.float32) else None
      }
    }
    object Float64 {
      def unapply(value: Value#Reader): Option[Double] = {
        if (value._whichIndex == 11) Some(value.float64) else None
      }
      def unapply(value: Value#Builder): Option[Double] = {
        if (value._whichIndex == 11) Some(value.float64) else None
      }
    }
    object Text {
      def unapply(value: Value#Reader): Option[org.murtsi.capnproto.runtime.Text#Reader] = {
        if (value._whichIndex == 12) Some(value.text) else None
      }
      def unapply(value: Value#Builder): Option[org.murtsi.capnproto.runtime.Text#Builder] = {
        if (value._whichIndex == 12) Some(value.text) else None
      }
    }
    object Data {
      def unapply(value: Value#Reader): Option[org.murtsi.capnproto.runtime.Data#Reader] = {
        if (value._whichIndex == 13) Some(value.data) else None
      }
      def unapply(value: Value#Builder): Option[org.murtsi.capnproto.runtime.Data#Builder] = {
        if (value._whichIndex == 13) Some(value.data) else None
      }
    }
    object _List {
      def unapply(value: Value#Reader): Option[org.murtsi.capnproto.runtime.AnyPointer#Reader] = {
        if (value._whichIndex == 14) Some(value.list) else None
      }
      def unapply(value: Value#Builder): Option[org.murtsi.capnproto.runtime.AnyPointer#Builder] = {
        if (value._whichIndex == 14) Some(value.list) else None
      }
    }
    object Enum {
      def unapply(value: Value#Reader): Option[Short] = {
        if (value._whichIndex == 15) Some(value.enum) else None
      }
      def unapply(value: Value#Builder): Option[Short] = {
        if (value._whichIndex == 15) Some(value.enum) else None
      }
    }
    object Struct {
      def unapply(value: Value#Reader): Option[org.murtsi.capnproto.runtime.AnyPointer#Reader] = {
        if (value._whichIndex == 16) Some(value.struct) else None
      }
      def unapply(value: Value#Builder): Option[org.murtsi.capnproto.runtime.AnyPointer#Builder] = {
        if (value._whichIndex == 16) Some(value.struct) else None
      }
    }
    object Interface {
      def unapply(value: Value#Reader): Boolean = value._whichIndex == 17
      def unapply(value: Value#Builder): Boolean = value._whichIndex == 17
    }
    object AnyPointer {
      def unapply(value: Value#Reader): Option[org.murtsi.capnproto.runtime.AnyPointer#Reader] = {
        if (value._whichIndex == 18) Some(value.anyPointer) else None
      }
      def unapply(value: Value#Builder): Option[org.murtsi.capnproto.runtime.AnyPointer#Builder] = {
        if (value._whichIndex == 18) Some(value.anyPointer) else None
      }
    }
  }

  object Annotation extends Annotation
  sealed class Annotation private() extends org.murtsi.capnproto.runtime.Struct { 
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
      def value: org.murtsi.capnproto.compiler.schema.Value#Reader = {
        _getPointerField[org.murtsi.capnproto.compiler.schema.Value](0)
      }
      def brand: org.murtsi.capnproto.compiler.schema.Brand#Reader = {
        _getPointerField[org.murtsi.capnproto.compiler.schema.Brand](1)
      }
      object has {
        def value: Boolean = {
          _pointerFieldIsNull(0)
        }
        def brand: Boolean = {
          _pointerFieldIsNull(1)
        }
      }
    }
    class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
      def id: Long = {
        this._getLongField(0)
      }
      def id_=(value: Long): Unit = {
        _setLongField(0, value)
      }
      def value: org.murtsi.capnproto.compiler.schema.Value#Builder = {
        _getPointerField[org.murtsi.capnproto.compiler.schema.Value](0)
      }
      def value_=(value: org.murtsi.capnproto.compiler.schema.Value#Reader): Unit = {
        _setPointerField[org.murtsi.capnproto.compiler.schema.Value](0, value)
      }
      def brand: org.murtsi.capnproto.compiler.schema.Brand#Builder = {
        _getPointerField[org.murtsi.capnproto.compiler.schema.Brand](1)
      }
      def brand_=(value: org.murtsi.capnproto.compiler.schema.Brand#Reader): Unit = {
        _setPointerField[org.murtsi.capnproto.compiler.schema.Brand](1, value)
      }
      object has {
        def value: Boolean = {
          _pointerFieldIsNull(0)
        }
        def brand: Boolean = {
          _pointerFieldIsNull(1)
        }
      }
      object init {
        def value(): org.murtsi.capnproto.compiler.schema.Value#Builder = {
          _initPointerField[org.murtsi.capnproto.compiler.schema.Value](0, 0)
        }
        def brand(): org.murtsi.capnproto.compiler.schema.Brand#Builder = {
          _initPointerField[org.murtsi.capnproto.compiler.schema.Brand](1, 0)
        }
      }
    }
  }

  sealed class ElementSize(index: Short) extends org.murtsi.capnproto.runtime.Enum(index)
  object ElementSize extends org.murtsi.capnproto.runtime.EnumModule[ElementSize] {
    override val enumValues: Seq[ElementSize] = Vector(
      ElementSize.Empty,
      ElementSize.Bit,
      ElementSize.Byte,
      ElementSize.TwoBytes,
      ElementSize.FourBytes,
      ElementSize.EightBytes,
      ElementSize.Pointer,
      ElementSize.InlineComposite
    )
    def apply(value: Short): Option[ElementSize] = enumValues.lift(value)
    object Empty extends ElementSize(0)
    object Bit extends ElementSize(1)
    object Byte extends ElementSize(2)
    object TwoBytes extends ElementSize(3)
    object FourBytes extends ElementSize(4)
    object EightBytes extends ElementSize(5)
    object Pointer extends ElementSize(6)
    object InlineComposite extends ElementSize(7)
  }

  object CodeGeneratorRequest extends CodeGeneratorRequest
  sealed class CodeGeneratorRequest private() extends org.murtsi.capnproto.runtime.Struct { 
    val typeId: Long = -4628215019123058738L
    override val structSize: org.murtsi.capnproto.runtime.StructSize = new org.murtsi.capnproto.runtime.StructSize(0, 2)

    override type Reader = ReaderImpl
    override type Builder = BuilderImpl

    override val Builder: (org.murtsi.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (org.murtsi.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    class ReaderImpl(_segment: org.murtsi.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
      def nodes: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Node]#Reader = {
        _getPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Node]](0)
      }
      def requestedFiles: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.CodeGeneratorRequest#RequestedFile]#Reader = {
        _getPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.CodeGeneratorRequest#RequestedFile]](1)
      }
      object has {
        def nodes: Boolean = {
          _pointerFieldIsNull(0)
        }
        def requestedFiles: Boolean = {
          _pointerFieldIsNull(1)
        }
      }
    }
    class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
      def nodes: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Node]#Builder = {
        _getPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Node]](0)
      }
      def nodes_=(value: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Node]#Reader): Unit = {
        _setPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Node]](0, value)
      }
      def requestedFiles: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.CodeGeneratorRequest#RequestedFile]#Builder = {
        _getPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.CodeGeneratorRequest#RequestedFile]](1)
      }
      def requestedFiles_=(value: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.CodeGeneratorRequest#RequestedFile]#Reader): Unit = {
        _setPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.CodeGeneratorRequest#RequestedFile]](1, value)
      }
      object has {
        def nodes: Boolean = {
          _pointerFieldIsNull(0)
        }
        def requestedFiles: Boolean = {
          _pointerFieldIsNull(1)
        }
      }
      object init {
        def nodes(size: Int): org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Node]#Builder = {
          _initPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.Node]](0, size)
        }
        def requestedFiles(size: Int): org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.CodeGeneratorRequest#RequestedFile]#Builder = {
          _initPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.CodeGeneratorRequest#RequestedFile]](1, size)
        }
      }
    }

    object RequestedFile extends RequestedFile
    sealed class RequestedFile private() extends org.murtsi.capnproto.runtime.Struct { 
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
        def filename: org.murtsi.capnproto.runtime.Text#Reader = {
          _getPointerField[org.murtsi.capnproto.runtime.Text](0)
        }
        def imports: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.CodeGeneratorRequest#RequestedFile#Import]#Reader = {
          _getPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.CodeGeneratorRequest#RequestedFile#Import]](1)
        }
        object has {
          def filename: Boolean = {
            _pointerFieldIsNull(0)
          }
          def imports: Boolean = {
            _pointerFieldIsNull(1)
          }
        }
      }
      class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
        def id: Long = {
          this._getLongField(0)
        }
        def id_=(value: Long): Unit = {
          _setLongField(0, value)
        }
        def filename: org.murtsi.capnproto.runtime.Text#Builder = {
          _getPointerField[org.murtsi.capnproto.runtime.Text](0)
        }
        def filename_=(value: org.murtsi.capnproto.runtime.Text#Reader): Unit = {
          _setPointerField[org.murtsi.capnproto.runtime.Text](0, value)
        }
        def filename_=(value: String): Unit = {
          _setPointerField[org.murtsi.capnproto.runtime.Text](0, org.murtsi.capnproto.runtime.Text.Reader(value))
        }
        def imports: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.CodeGeneratorRequest#RequestedFile#Import]#Builder = {
          _getPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.CodeGeneratorRequest#RequestedFile#Import]](1)
        }
        def imports_=(value: org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.CodeGeneratorRequest#RequestedFile#Import]#Reader): Unit = {
          _setPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.CodeGeneratorRequest#RequestedFile#Import]](1, value)
        }
        object has {
          def filename: Boolean = {
            _pointerFieldIsNull(0)
          }
          def imports: Boolean = {
            _pointerFieldIsNull(1)
          }
        }
        object init {
          def filename(size: Int): org.murtsi.capnproto.runtime.Text#Builder = {
            _initPointerField[org.murtsi.capnproto.runtime.Text](0, size)
          }
          def imports(size: Int): org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.CodeGeneratorRequest#RequestedFile#Import]#Builder = {
            _initPointerField[org.murtsi.capnproto.runtime.StructList[org.murtsi.capnproto.compiler.schema.CodeGeneratorRequest#RequestedFile#Import]](1, size)
          }
        }
      }

      object Import extends Import
      sealed class Import private() extends org.murtsi.capnproto.runtime.Struct { 
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
          def name: org.murtsi.capnproto.runtime.Text#Reader = {
            _getPointerField[org.murtsi.capnproto.runtime.Text](0)
          }
          object has {
            def name: Boolean = {
              _pointerFieldIsNull(0)
            }
          }
        }
        class BuilderImpl(_segment: org.murtsi.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
          def id: Long = {
            this._getLongField(0)
          }
          def id_=(value: Long): Unit = {
            _setLongField(0, value)
          }
          def name: org.murtsi.capnproto.runtime.Text#Builder = {
            _getPointerField[org.murtsi.capnproto.runtime.Text](0)
          }
          def name_=(value: org.murtsi.capnproto.runtime.Text#Reader): Unit = {
            _setPointerField[org.murtsi.capnproto.runtime.Text](0, value)
          }
          def name_=(value: String): Unit = {
            _setPointerField[org.murtsi.capnproto.runtime.Text](0, org.murtsi.capnproto.runtime.Text.Reader(value))
          }
          object has {
            def name: Boolean = {
              _pointerFieldIsNull(0)
            }
          }
          object init {
            def name(size: Int): org.murtsi.capnproto.runtime.Text#Builder = {
              _initPointerField[org.murtsi.capnproto.runtime.Text](0, size)
            }
          }
        }
      }
    }
  }
}
