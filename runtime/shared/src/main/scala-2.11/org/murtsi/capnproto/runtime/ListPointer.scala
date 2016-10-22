package org.murtsi.capnproto.runtime

import java.nio.ByteBuffer
//remove if not needed
import scala.collection.JavaConversions._

object ListPointer {

  def elementSize(ref: Long): Byte = {
    (WirePointer.upper32Bits(ref) & 7).toByte
  }

  def elementCount(ref: Long): Int = WirePointer.upper32Bits(ref) >>> 3

  def inlineCompositeWordCount(ref: Long): Int = elementCount(ref)

  def set(buffer: ByteBuffer, 
      offset: Int, 
      elementSize: Byte, 
      elementCount: Int) {
    buffer.putInt(8 * offset + 4, (elementCount << 3) | elementSize)
  }

  def setInlineComposite(buffer: ByteBuffer, offset: Int, wordCount: Int) {
    buffer.putInt(8 * offset + 4, (wordCount << 3) | ElementSize.INLINE_COMPOSITE)
  }
}
