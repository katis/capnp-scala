package org.capnproto

object ListReader {

  trait Factory[T] {

    def constructReader(segment: SegmentReader, 
        ptr: Int, 
        elementCount: Int, 
        step: Int, 
        structDataSize: Int, 
        structPointerCount: Short, 
        nestingLimit: Int): T
  }
}

class ListReader(
      val segment: SegmentReader = null,
      val ptr: Int = 0,
      val elementCount: Int = 0,
      val step: Int = 0,
      val structDataSize: Int = 0,
      val structPointerCount: Short = 0,
      val nestingLimit: Int = 0x7fffffff) {

  def size(): Int = this.elementCount

  protected def _getBooleanElement(index: Int): Boolean = {
    val bindex = index.toLong * this.step
    val b = this.segment.buffer.get(this.ptr + (bindex / Constants.BITS_PER_BYTE).toInt)
    (b & (1 << (bindex % 8))) != 0
  }

  protected def _getByteElement(index: Int): Byte = {
    this.segment.buffer.get(this.ptr + 
      (index.toLong * this.step / Constants.BITS_PER_BYTE).toInt)
  }

  protected def _getShortElement(index: Int): Short = {
    this.segment.buffer.getShort(this.ptr + 
      (index.toLong * this.step / Constants.BITS_PER_BYTE).toInt)
  }

  protected def _getIntElement(index: Int): Int = {
    this.segment.buffer.getInt(this.ptr + 
      (index.toLong * this.step / Constants.BITS_PER_BYTE).toInt)
  }

  protected def _getLongElement(index: Int): Long = {
    this.segment.buffer.getLong(this.ptr + 
      (index.toLong * this.step / Constants.BITS_PER_BYTE).toInt)
  }

  protected def _getFloatElement(index: Int): Float = {
    this.segment.buffer.getFloat(this.ptr + 
      (index.toLong * this.step / Constants.BITS_PER_BYTE).toInt)
  }

  protected def _getDoubleElement(index: Int): Double = {
    this.segment.buffer.getDouble(this.ptr + 
      (index.toLong * this.step / Constants.BITS_PER_BYTE).toInt)
  }

  protected def _getStructElement[T](factory: StructReader.Factory[T], index: Int): T = {
    val indexBit = index.toLong * this.step
    val structData = this.ptr + (indexBit / Constants.BITS_PER_BYTE).toInt
    val structPointers = structData + (this.structDataSize / Constants.BITS_PER_BYTE)
    factory.constructReader(this.segment, structData, structPointers / 8, this.structDataSize, this.structPointerCount, 
      this.nestingLimit - 1)
  }

  protected def _getPointerElement[T](factory: FromPointerReader[T], index: Int): T = {
    factory.fromPointerReader(this.segment, (this.ptr + 
      (index.toLong * this.step / Constants.BITS_PER_BYTE).toInt) / 
      Constants.BYTES_PER_WORD, this.nestingLimit)
  }

  protected def _getPointerElement[T](factory: FromPointerReaderBlobDefault[T], 
      index: Int, 
      defaultBuffer: java.nio.ByteBuffer, 
      defaultOffset: Int, 
      defaultSize: Int): T = {
    factory.fromPointerReaderBlobDefault(this.segment, (this.ptr + 
      (index.toLong * this.step / Constants.BITS_PER_BYTE).toInt) / 
      Constants.BYTES_PER_WORD, defaultBuffer, defaultOffset, defaultSize)
  }
}
