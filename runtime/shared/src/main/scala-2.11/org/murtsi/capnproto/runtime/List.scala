package org.murtsi.capnproto.runtime

trait HasElementSize[T] {
  def elementSize: Byte
}

trait ListFromSegment[T <: PointerFamily] extends ListReader.Factory[T#Reader] with ListBuilder.Factory[T#Builder]

abstract class List[ElementBuilder, ElementReader](val elementSize: Byte) extends PointerFamily {

  type Builder <: BuilderBase
  type Reader <: ReaderBase

  abstract class BuilderBase(
      segment: SegmentBuilder,
      ptr: Int,
      elementCount: Int,
      step: Int,
      structDataSize: Int,
      structPointerCount: Short
  ) extends ListBuilder(segment,
                          ptr,
                          elementCount,
                          step,
                          structDataSize,
                          structPointerCount) with Seq[ElementBuilder] with Traversable[ElementBuilder] with IndexedSeq[ElementBuilder] {

    builder =>

    override def length: Int = super[ListBuilder].size()

    override def size: Int = super[ListBuilder].size()

    override def foreach[U](f: (ElementBuilder) => U): Unit = {
      for (i <- 0 until size) {
        f(apply(i))
      }
    }

    override def iterator: Iterator[ElementBuilder] = new Iterator[ElementBuilder] {
      var i = 0
      override def hasNext: Boolean = i < builder.length

      override def next(): ElementBuilder = {
        val v = apply(i)
        i += 1
        v
      }
    }
  }

  abstract class ReaderBase(
      segment: SegmentReader,
      ptr: Int,
      elementCount: Int,
      step: Int,
      structDataSize: Int,
      structPointerCount: Short,
      nestingLimit: Int
  ) extends ListReader(segment,
                         ptr,
                         elementCount,
                         step,
                         structDataSize,
                         structPointerCount,
                         nestingLimit) with Seq[ElementReader] with Traversable[ElementReader] with IndexedSeq[ElementReader] {
    reader =>

    override def length: Int = super[ListReader].size

    override def size: Int = super[ListReader].size

    override def foreach[U](f: (ElementReader) => U): Unit = {
      for (i <- 0 until size) {
        f(apply(i))
      }
    }

    override def iterator: Iterator[ElementReader] = new Iterator[ElementReader] {
      var i = 0
      override def hasNext: Boolean = i < reader.length

      override def next(): ElementReader = {
        val v = apply(i)
        i += 1
        v
      }
    }
  }
}


