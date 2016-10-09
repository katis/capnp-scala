package org.capnproto.runtime

object StructBuilder {

  trait Factory[T] {

    def constructBuilder(segment: SegmentBuilder,
        data: Int,
        pointers: Int,
        dataSize: Int,
        pointerCount: Short): T

    def structSize: StructSize
  }

  trait FactoryTF {
    type Builder

    def Builder: (SegmentBuilder, Int, Int, Int, Short) => Builder

    def structSize: StructSize
  }
}

class StructBuilder(
                     private[runtime] val segment: SegmentBuilder,
                     private[runtime] val dataOffset: Int,
                     private[runtime] val pointers: Int,
                     private[runtime] val dataSize: Int,
                     private[runtime] val pointerCount: Short) {

  protected def _getBooleanField(offset: Int): Boolean = {
    val bitOffset = offset
    val position = this.dataOffset + (bitOffset / 8)
    (this.segment.buffer.get(position) & (1 << (bitOffset % 8))) !=
      0
  }

  protected def _getBooleanField(offset: Int, mask: Boolean): Boolean = this._getBooleanField(offset) ^ mask

  protected def _setBooleanField(offset: Int, value: Boolean) {
    val bitOffset = offset
    val bitnum = (bitOffset % 8).toByte
    val position = this.dataOffset + (bitOffset / 8)
    val oldValue = this.segment.buffer.get(position)
    this.segment.buffer.put(position, ((oldValue & (~(1 << bitnum))) | ((if (value) 1 else 0) << bitnum)).toByte)
  }

  protected def _setBooleanField(offset: Int, value: Boolean, mask: Boolean) {
    this._setBooleanField(offset, value ^ mask)
  }

  protected def _getByteField(offset: Int): Byte = {
    this.segment.buffer.get(this.dataOffset + offset)
  }

  protected def _getByteField(offset: Int, mask: Byte): Byte = {
    (this._getByteField(offset) ^ mask).toByte
  }

  protected def _setByteField(offset: Int, value: Byte) {
    this.segment.buffer.put(this.dataOffset + offset, value)
  }

  protected def _setByteField(offset: Int, value: Byte, mask: Byte) {
    this._setByteField(offset, (value ^ mask).toByte)
  }

  protected def _getShortField(offset: Int): Short = {
    this.segment.buffer.getShort(this.dataOffset + offset * 2)
  }

  protected def _getShortField(offset: Int, mask: Short): Short = {
    (this._getShortField(offset) ^ mask).toShort
  }

  protected def _setShortField(offset: Int, value: Short) {
    this.segment.buffer.putShort(this.dataOffset + offset * 2, value)
  }

  protected def _setShortField(offset: Int, value: Short, mask: Short) {
    this._setShortField(offset, (value ^ mask).toShort)
  }

  protected def _getIntField(offset: Int): Int = {
    this.segment.buffer.getInt(this.dataOffset + offset * 4)
  }

  protected def _getIntField(offset: Int, mask: Int): Int = this._getIntField(offset) ^ mask

  protected def _setIntField(offset: Int, value: Int) {
    this.segment.buffer.putInt(this.dataOffset + offset * 4, value)
  }

  protected def _setIntField(offset: Int, value: Int, mask: Int) {
    this._setIntField(offset, value ^ mask)
  }

  protected def _getLongField(offset: Int): Long = {
    this.segment.buffer.getLong(this.dataOffset + offset * 8)
  }

  protected def _getLongField(offset: Int, mask: Long): Long = this._getLongField(offset) ^ mask

  protected def _setLongField(offset: Int, value: Long) {
    this.segment.buffer.putLong(this.dataOffset + offset * 8, value)
  }

  protected def _setLongField(offset: Int, value: Long, mask: Long) {
    this._setLongField(offset, value ^ mask)
  }

  protected def _getFloatField(offset: Int): Float = {
    this.segment.buffer.getFloat(this.dataOffset + offset * 4)
  }

  protected def _getFloatField(offset: Int, mask: Int): Float = {
    java.lang.Float.intBitsToFloat(this.segment.buffer.getInt(this.dataOffset + offset * 4) ^ mask)
  }

  protected def _setFloatField(offset: Int, value: Float) {
    this.segment.buffer.putFloat(this.dataOffset + offset * 4, value)
  }

  protected def _setFloatField(offset: Int, value: Float, mask: Int) {
    this.segment.buffer.putInt(this.dataOffset + offset * 4, java.lang.Float.floatToIntBits(value) ^ mask)
  }

  protected def _getDoubleField(offset: Int): Double = {
    this.segment.buffer.getDouble(this.dataOffset + offset * 8)
  }

  protected def _getDoubleField(offset: Int, mask: Long): Double = {
    java.lang.Double.longBitsToDouble(this.segment.buffer.getLong(this.dataOffset + offset * 8) ^
      mask)
  }

  protected def _setDoubleField(offset: Int, value: Double) {
    this.segment.buffer.putDouble(this.dataOffset + offset * 8, value)
  }

  protected def _setDoubleField(offset: Int, value: Double, mask: Long) {
    this.segment.buffer.putLong(this.dataOffset + offset * 8, java.lang.Double.doubleToLongBits(value) ^ mask)
  }

  protected def _pointerFieldIsNull(ptrIndex: Int): Boolean = {
    this.segment.buffer.getLong((this.pointers + ptrIndex) * Constants.BYTES_PER_WORD) ==
      0
  }

  protected def _clearPointerField(ptrIndex: Int) {
    val pointer = this.pointers + ptrIndex
    WireHelpers.zeroObject(this.segment, pointer)
    this.segment.buffer.putLong(pointer * 8, 0L)
  }

  protected def _getPointerField(factory: FromPointerBuilderTF, index: Int): factory.Builder = {
    factory.fromPointerBuilder(this.segment, this.pointers + index)
  }

  protected def _getPointerField(factory: FromPointerBuilderRefDefaultTF,
      index: Int,
      defaultSegment: SegmentReader,
      defaultOffset: Int): factory.Builder = {
    factory.fromPointerBuilderRefDefault(this.segment, this.pointers + index, defaultSegment, defaultOffset)
  }

  protected def _getPointerField(factory: FromPointerBuilderBlobDefault,
      index: Int,
      defaultBuffer: java.nio.ByteBuffer,
      defaultOffset: Int,
      defaultSize: Int): factory.Builder = {
    factory.fromPointerBuilderBlobDefault(this.segment, this.pointers + index, defaultBuffer, defaultOffset,
      defaultSize)
  }

  protected def _initPointerField(factory: FromPointerBuilderTF, index: Int, elementCount: Int): factory.Builder = {
    factory.initFromPointerBuilder(this.segment, this.pointers + index, elementCount)
  }

  protected def _setPointerField(factory: SetPointerBuilderTF)(index: Int, value: factory.Reader) {
    factory.setPointerBuilder(this.segment, this.pointers + index, value)
  }
}
