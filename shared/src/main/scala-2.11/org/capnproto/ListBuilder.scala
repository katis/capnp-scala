package org.capnproto

object ListBuilder {

  trait Factory {
    type Builder

    def Builder(segment: SegmentBuilder,
        ptr: Int,
        elementCount: Int, 
        step: Int, 
        structDataSize: Int, 
        structPointerCount: Short): Builder
  }
}

class ListBuilder(val segment: SegmentBuilder, 
    val ptr: Int, 
    val elementCount: Int, 
    val step: Int, 
    val structDataSize: Int, 
    val structPointerCount: Short) {

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

  protected def _setBooleanElement(index: Int, value: Boolean) {
    val bitOffset = index * this.step
    val bitnum = (bitOffset % 8).toByte
    val position = (this.ptr + (bitOffset / 8)).toInt
    val oldValue = this.segment.buffer.get(position)
    this.segment.buffer.put(position, ((oldValue & (~(1 << bitnum))) | ((if (value) 1 else 0) << bitnum)).toByte)
  }

  protected def _setByteElement(index: Int, value: Byte) {
    this.segment.buffer.put(this.ptr + 
      (index.toLong * this.step / Constants.BITS_PER_BYTE).toInt, value)
  }

  protected def _setShortElement(index: Int, value: Short) {
    this.segment.buffer.putShort(this.ptr + 
      (index.toLong * this.step / Constants.BITS_PER_BYTE).toInt, value)
  }

  protected def _setIntElement(index: Int, value: Int) {
    this.segment.buffer.putInt(this.ptr + 
      (index.toLong * this.step / Constants.BITS_PER_BYTE).toInt, value)
  }

  protected def _setLongElement(index: Int, value: Long) {
    this.segment.buffer.putLong(this.ptr + 
      (index.toLong * this.step / Constants.BITS_PER_BYTE).toInt, value)
  }

  protected def _setFloatElement(index: Int, value: Float) {
    this.segment.buffer.putFloat(this.ptr + 
      (index.toLong * this.step / Constants.BITS_PER_BYTE).toInt, value)
  }

  protected def _setDoubleElement(index: Int, value: Double) {
    this.segment.buffer.putDouble(this.ptr + 
      (index.toLong * this.step / Constants.BITS_PER_BYTE).toInt, value)
  }

  protected def _getStructElement(factory: Struct, index: Int): factory.Builder = {
    val indexBit = index.toLong * this.step
    val structData = this.ptr + (indexBit / Constants.BITS_PER_BYTE).toInt
    val structPointers = (structData + (this.structDataSize / 8)) / 8
    factory.Builder(this.segment, structData, structPointers, this.structDataSize, this.structPointerCount)
  }

  protected def _getPointerElement(factory: FromPointerBuilderTF, index: Int): factory.Builder = {
    factory.fromPointerBuilder(this.segment, (this.ptr + 
      (index.toLong * this.step / Constants.BITS_PER_BYTE).toInt) / 
      Constants.BYTES_PER_WORD)
  }

  protected def _initPointerElement(factory: FromPointerBuilderTF, index: Int, elementCount: Int): factory.Builder = {
    factory.initFromPointerBuilder(this.segment, (this.ptr + 
      (index.toLong * this.step / Constants.BITS_PER_BYTE).toInt) / 
      Constants.BYTES_PER_WORD, elementCount)
  }

  protected def _setPointerElement(factory: SetPointerBuilderTF)(index: Int, value: factory.Reader) {
    factory.setPointerBuilder(this.segment, (this.ptr + 
      (index.toLong * this.step / Constants.BITS_PER_BYTE).toInt) / 
      Constants.BYTES_PER_WORD, value)
  }
}
