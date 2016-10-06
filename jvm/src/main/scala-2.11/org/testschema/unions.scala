package org.testschema

import org.capnproto._

/*
object unions {

  object Date {

    class Reader(segment: SegmentReader, data: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int)
      extends StructReader(segment, data, pointers, dataSize, pointerCount, nestingLimit) {

      def year: Short = _getShortField(0)

      def month: Byte = _getByteField(1)

      def which[T](fn: PartialFunction[Which.Reader, T]): T = _getShortField(3) match {
        case 0 => fn(new Which.Shape.Reader(segment))
        case 1 => fn(new Which.Color.Reader(segment))
      }
    }

    class Builder(segment: SegmentBuilder, data: Int, pointers: Int, dataSize: Int, pointerCount: Short)
      extends StructBuilder(segment, data, pointers, dataSize, pointerCount) {

      def year: Short = _getShortField(0)

      def year_=(value: Short): Unit = _setShortField(0, value)

      def month: Byte = _getByteField(1)

      def month_=(value: Byte): Unit = _setByteField(1, value)

      def which[T](fn: PartialFunction[Which.Builder, T]): T = _getShortField(3) match {
        case 0 => fn(new Which.Shape.Builder(segment))
        case 1 => fn(new Which.Color.Builder(segment))
      }

      object which {
        def initShape(): Which.Shape.Builder = _

        def initColor(): Which.Shape.Builder = _
      }

    }

    object Which {

      sealed trait Reader

      sealed class Builder(segment: SegmentBuilder) extends StructBuilder(segment, 0, 0, 0, 0) {

      }

      object Shape {

        class Builder(segment: SegmentBuilder) extends Which.Builder(segment) {
          def width: Short = 2

          def width_=(value: Short) = ()

          def height: Short = 3

          def height_=(value: Short) = ()
        }

        class Reader(segment: SegmentReader) extends Which.Reader {
          def width: Short = 2

          def height: Short = 2
        }

        def unapply(reader: Which.Reader): Option[Reader] =
          reader match {
            case r: Reader => Some(r)
            case _ => None
          }

        def unapply(builder: Which.Builder): Option[Builder] =
          builder match {
            case b: Builder => Some(b)
            case _ => None
          }
      }

      object Color {
        def unapply(reader: Which.Reader): Option[Reader] = reader match {
          case reader: Reader => Some(reader)
          case _ => None
        }

        def unapply(builder: Which.Builder): Option[Builder] = builder match {
          case builder: Builder => Some(builder)
          case _ => None
        }

        class Builder(segment: SegmentBuilder) extends StructBuilder(segment, 0, 0, 0, 0) with Which.Builder {
          def color: Int = 3

          def color_=(value: Int) = _setIntField(0, value)
        }

        class Reader(segment: SegmentReader) extends StructReader(segment, 0, 0, 0, 0, 0) with Which.Reader {
          def color: Int = 3
        }

      }

    }

  }

  def foo(date: Date.Reader): Unit = {
    date.which {
      case Date.Which.Shape(s) => s.height
      case Date.Which.Color(s) => s.color
    }
  }

  def bar(date: Date.Builder): Unit = {
    val color = date.which.initColor()
    color.height = 32
    date.which {
      case Date.Which.Shape(s) => s.height = 32
      case Date.Which.Color(s) => s.color = 32
    }
  }
}
*/
