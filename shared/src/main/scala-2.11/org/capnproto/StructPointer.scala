package org.capnproto

import java.nio.ByteBuffer
//remove if not needed
import scala.collection.JavaConversions._

object StructPointer {

  def dataSize(ref: Long): Short = {
    (WirePointer.upper32Bits(ref) & 0xffff).toShort
  }

  def ptrCount(ref: Long): Short = {
    (WirePointer.upper32Bits(ref) >>> 16).toShort
  }

  def wordSize(ref: Long): Int = {
    dataSize(ref).toInt + ptrCount(ref).toInt
  }

  def setFromStructSize(buffer: ByteBuffer, offset: Int, size: StructSize) {
    buffer.putShort(8 * offset + 4, size.data)
    buffer.putShort(8 * offset + 6, size.pointers)
  }

  def set(buffer: ByteBuffer, 
      offset: Int, 
      dataSize: Short, 
      pointerCount: Short) {
    buffer.putShort(8 * offset + 4, dataSize)
    buffer.putShort(8 * offset + 6, pointerCount)
  }
}
