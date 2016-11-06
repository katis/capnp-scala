package org.murtsi.capnproto.runtime

import java.nio.ByteBuffer
//remove if not needed

object WirePointer {

  val STRUCT = 0.toByte

  val LIST = 1.toByte

  val FAR = 2.toByte

  val OTHER = 3.toByte

  def isNull(wirePointer: Long): Boolean = wirePointer == 0

  def offsetAndKind(wirePointer: Long): Int = (wirePointer & 0xffffffff).toInt

  def kind(wirePointer: Long): Byte = (offsetAndKind(wirePointer) & 3).toByte

  def target(offset: Int, wirePointer: Long): Int = {
    offset + 1 + (offsetAndKind(wirePointer) >>> 2)
  }

  def setKindAndTarget(buffer: ByteBuffer, 
      offset: Int, 
      kind: Byte, 
      targetOffset: Int) {
    buffer.putInt(offset * 8, (((targetOffset - offset) - 1) << 2) | kind)
  }

  def setKindWithZeroOffset(buffer: ByteBuffer, offset: Int, kind: Byte) {
    buffer.putInt(offset * Constants.BYTES_PER_WORD, kind)
  }

  def setKindAndTargetForEmptyStruct(buffer: ByteBuffer, offset: Int) {
    buffer.putInt(offset * 8, 0xfffffffc)
  }

  def setOffsetAndKind(buffer: ByteBuffer, offset: Int, offsetAndKind: Int) {
    buffer.putInt(offset * 8, offsetAndKind)
  }

  def inlineCompositeListElementCount(wirePointer: Long): Int = offsetAndKind(wirePointer) >>> 2

  def setKindAndInlineCompositeListElementCount(buffer: ByteBuffer, 
      offset: Int, 
      kind: Byte, 
      elementCount: Int) {
    buffer.putInt(offset * 8, (elementCount << 2) | kind)
  }

  def upper32Bits(wirePointer: Long): Int = (wirePointer >>> 32).toInt
}
