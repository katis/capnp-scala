// GENERATED CAP'N PROTO FILE, DO NOT EDIT
package org.katis.capnproto.compiler.multifile.util

import org.katis.capnproto.runtime.implicits._

object uuid {
  // START UUID implicits
  implicit val UUID$$HasTypeId = new org.katis.capnproto.runtime.HasTypeId[UUID] {
    def typeId: Long = -5078097983031366160L
  }
  implicit val UUID$$HasStructSize = new org.katis.capnproto.runtime.HasStructSize[UUID] {
    val structSize = new org.katis.capnproto.runtime.StructSize(2, 0)
  }
  implicit val UUID$$StructFromSegment = new org.katis.capnproto.runtime.StructFromSegment[UUID] {
    def readerFromSegment(segment: org.katis.capnproto.runtime.SegmentReader, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short, nestingLimit: Int): UUID#Reader = {
      UUID.Reader(segment, dataOffset, pointers, dataSize, pointerCount, nestingLimit)
    }
    def builderFromSegment(segment: org.katis.capnproto.runtime.SegmentBuilder, dataOffset: Int, pointers: Int, dataSize: Int, pointerCount: Short): UUID#Builder = {
      UUID.Builder(segment, dataOffset, pointers, dataSize, pointerCount)
    }
  }
  // END UUID implicits

  object UUID extends UUID
  sealed class UUID private() extends org.katis.capnproto.runtime.Struct { 
    val typeId: Long = -5078097983031366160L
    override val structSize: org.katis.capnproto.runtime.StructSize = new org.katis.capnproto.runtime.StructSize(2, 0)

    override type Reader = ReaderImpl
    override type Builder = BuilderImpl

    override val Builder: (org.katis.capnproto.runtime.SegmentBuilder, Int, Int, Int, Short) => Builder = new BuilderImpl(_, _, _, _, _)
    override val Reader: (org.katis.capnproto.runtime.SegmentReader, Int, Int, Int, Short, Int) => Reader = new ReaderImpl(_, _, _, _, _, _)

    class ReaderImpl(_segment: org.katis.capnproto.runtime.SegmentReader, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short, _nestingLimit: Int) extends super.ReaderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount, _nestingLimit) {
      def lsb: Long = {
        this._getLongField(0)
      }
      def msb: Long = {
        this._getLongField(1)
      }
    }
    class BuilderImpl(_segment: org.katis.capnproto.runtime.SegmentBuilder, _dataOffset: Int, _pointers: Int, _dataSize: Int, _pointerCount: Short) extends super.BuilderBase(_segment, _dataOffset, _pointers, _dataSize, _pointerCount) {
      def lsb: Long = {
        this._getLongField(0)
      }
      def lsb_=(value: Long): Unit = {
        _setLongField(0, value)
      }
      def msb: Long = {
        this._getLongField(1)
      }
      def msb_=(value: Long): Unit = {
        _setLongField(1, value)
      }
    }
  }
}
