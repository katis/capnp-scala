package org.murtsi.capnproto.runtime

object StructBuilder {
  trait Factory {
    type Builder

    def Builder: (SegmentBuilder, Int, Int, Int, Short) => Builder

    def structSize: StructSize
  }
}

class StructBuilder(private val _segment: SegmentBuilder,
                    private val _dataOffset: Int,
                    private val _pointers: Int,
                    private val _dataSize: Int,
                    private val _pointerCount: Short) {

  protected def _getBooleanField(offset: Int): Boolean = {
    val bitOffset = offset
    val position = this._dataOffset + (bitOffset / 8)
    (this._segment.buffer.get(position) & (1 << (bitOffset % 8))) !=
      0
  }

  protected def _getBooleanField(offset: Int, mask: Boolean): Boolean = this._getBooleanField(offset) ^ mask

  protected def _setBooleanField(offset: Int, value: Boolean) {
    val bitOffset = offset
    val bitnum = (bitOffset % 8).toByte
    val position = this._dataOffset + (bitOffset / 8)
    val oldValue = this._segment.buffer.get(position)
    this._segment.buffer.put(position, ((oldValue & (~(1 << bitnum))) | ((if (value) 1 else 0) << bitnum)).toByte)
  }

  protected def _setBooleanField(offset: Int, value: Boolean, mask: Boolean) {
    this._setBooleanField(offset, value ^ mask)
  }

  protected def _getByteField(offset: Int): Byte = {
    this._segment.buffer.get(this._dataOffset + offset)
  }

  protected def _getByteField(offset: Int, mask: Byte): Byte = {
    (this._getByteField(offset) ^ mask).toByte
  }

  protected def _setByteField(offset: Int, value: Byte) {
    this._segment.buffer.put(this._dataOffset + offset, value)
  }

  protected def _setByteField(offset: Int, value: Byte, mask: Byte) {
    this._setByteField(offset, (value ^ mask).toByte)
  }

  protected def _getShortField(offset: Int): Short = {
    this._segment.buffer.getShort(this._dataOffset + offset * 2)
  }

  protected def _getShortField(offset: Int, mask: Short): Short = {
    (this._getShortField(offset) ^ mask).toShort
  }

  protected def _setShortField(offset: Int, value: Short) {
    this._segment.buffer.putShort(this._dataOffset + offset * 2, value)
  }

  protected def _setShortField(offset: Int, value: Short, mask: Short) {
    this._setShortField(offset, (value ^ mask).toShort)
  }

  protected def _getIntField(offset: Int): Int = {
    this._segment.buffer.getInt(this._dataOffset + offset * 4)
  }

  protected def _getIntField(offset: Int, mask: Int): Int = this._getIntField(offset) ^ mask

  protected def _setIntField(offset: Int, value: Int) {
    this._segment.buffer.putInt(this._dataOffset + offset * 4, value)
  }

  protected def _setIntField(offset: Int, value: Int, mask: Int) {
    this._setIntField(offset, value ^ mask)
  }

  protected def _getLongField(offset: Int): Long = {
    this._segment.buffer.getLong(this._dataOffset + offset * 8)
  }

  protected def _getLongField(offset: Int, mask: Long): Long = this._getLongField(offset) ^ mask

  protected def _setLongField(offset: Int, value: Long) {
    this._segment.buffer.putLong(this._dataOffset + offset * 8, value)
  }

  protected def _setLongField(offset: Int, value: Long, mask: Long) {
    this._setLongField(offset, value ^ mask)
  }

  protected def _getFloatField(offset: Int): Float = {
    this._segment.buffer.getFloat(this._dataOffset + offset * 4)
  }

  protected def _getFloatField(offset: Int, mask: Int): Float = {
    java.lang.Float.intBitsToFloat(this._segment.buffer.getInt(this._dataOffset + offset * 4) ^ mask)
  }

  protected def _setFloatField(offset: Int, value: Float) {
    this._segment.buffer.putFloat(this._dataOffset + offset * 4, value)
  }

  protected def _setFloatField(offset: Int, value: Float, mask: Int) {
    this._segment.buffer.putInt(this._dataOffset + offset * 4, java.lang.Float.floatToIntBits(value) ^ mask)
  }

  protected def _getDoubleField(offset: Int): Double = {
    this._segment.buffer.getDouble(this._dataOffset + offset * 8)
  }

  protected def _getDoubleField(offset: Int, mask: Long): Double = {
    java.lang.Double.longBitsToDouble(this._segment.buffer.getLong(this._dataOffset + offset * 8) ^
      mask)
  }

  protected def _setDoubleField(offset: Int, value: Double) {
    this._segment.buffer.putDouble(this._dataOffset + offset * 8, value)
  }

  protected def _setDoubleField(offset: Int, value: Double, mask: Long) {
    this._segment.buffer.putLong(this._dataOffset + offset * 8, java.lang.Double.doubleToLongBits(value) ^ mask)
  }

  protected def _pointerFieldIsNull(ptrIndex: Int): Boolean = {
    this._segment.buffer.getLong((this._pointers + ptrIndex) * Constants.BYTES_PER_WORD) ==
      0
  }

  protected def _clearPointerField(ptrIndex: Int) {
    val pointer = this._pointers + ptrIndex
    WireHelpers.zeroObject(this._segment, pointer)
    this._segment.buffer.putLong(pointer * 8, 0L)
  }

  protected def _getPointerField(factory: FromPointerBuilder, index: Int): factory.Builder = {
    factory.fromPointerBuilder(this._segment, this._pointers + index)
  }

  protected def _getPointerField(factory: FromPointerBuilderRefDefault,
                                 index: Int,
                                 defaultSegment: SegmentReader,
                                 defaultOffset: Int): factory.Builder = {
    factory.fromPointerBuilderRefDefault(this._segment, this._pointers + index, defaultSegment, defaultOffset)
  }

  protected def _getPointerField(factory: FromPointerBuilderBlobDefault,
      index: Int,
      defaultBuffer: java.nio.ByteBuffer,
      defaultOffset: Int,
      defaultSize: Int): factory.Builder = {
    factory.fromPointerBuilderBlobDefault(this._segment, this._pointers + index, defaultBuffer, defaultOffset,
      defaultSize)
  }

  protected def _getPointerFieldOption(factory: FromPointerBuilder, index: Int): Option[factory.Builder] = {
    val ptr = this._pointers + index
    if (_pointerFieldIsNull(ptr)) None
    else Some(factory.fromPointerBuilder(this._segment, this._pointers + index))
  }

  protected def _getPointerFieldOption(factory: FromPointerBuilderRefDefault,
                                       index: Int,
                                       defaultSegment: SegmentReader,
                                       defaultOffset: Int): Option[factory.Builder] = {

    val ptr = this._pointers + index
    if (_pointerFieldIsNull(ptr)) None
    else Some(factory.fromPointerBuilderRefDefault(this._segment, ptr, defaultSegment, defaultOffset))
  }

  protected def _getPointerFieldOption(factory: FromPointerBuilderBlobDefault,
      index: Int,
      defaultBuffer: java.nio.ByteBuffer,
      defaultOffset: Int,
      defaultSize: Int): Option[factory.Builder] = {
    val ptr = this._pointers + index
    if (_pointerFieldIsNull(ptr)) None
    else Some(factory.fromPointerBuilderBlobDefault(this._segment, this._pointers + index, defaultBuffer, defaultOffset,
      defaultSize))
  }

  protected def _initPointerField(factory: FromPointerBuilder, index: Int, elementCount: Int): factory.Builder = {
    factory.initFromPointerBuilder(this._segment, this._pointers + index, elementCount)
  }

  protected def _setPointerField(factory: SetPointerBuilder)(index: Int, value: factory.Reader) {
    factory.setPointerBuilder(this._segment, this._pointers + index, value)
  }
}
