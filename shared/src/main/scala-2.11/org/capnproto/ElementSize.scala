package org.capnproto

object ElementSize {

  val VOID: Byte = 0

  val BIT: Byte = 1

  val BYTE: Byte = 2

  val TWO_BYTES: Byte = 3

  val FOUR_BYTES: Byte = 4

  val EIGHT_BYTES: Byte = 5

  val POINTER: Byte = 6

  val INLINE_COMPOSITE: Byte = 7

  def dataBitsPerElement(size: Byte): Int = size match {
    case VOID => 0
    case BIT => 1
    case BYTE => 8
    case TWO_BYTES => 16
    case FOUR_BYTES => 32
    case EIGHT_BYTES => 64
    case POINTER => 0
    case INLINE_COMPOSITE => 0
    case _ => throw new Error("impossible field size: " + size)
  }

  def pointersPerElement(size: Byte): Short = size match {
    case POINTER => 1
    case _ => 0
  }
}
