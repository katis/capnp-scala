package org.capnproto.runtime

object StructReader {

  trait Factory[T] {

    def constructReader(segment: SegmentReader,
                        data: Int,
                        pointers: Int,
                        dataSize: Int,
                        pointerCount: Short,
                        nestingLimit: Int): T
  }

  trait FactoryTF {
    type Reader

    def Reader: (SegmentReader,
                        Int,
                        Int,
                        Int,
                        Short,
                        Int) => Reader
  }
}

class StructReader(private[runtime] val segment: SegmentReader = SegmentReader.EMPTY,
                   private[runtime] val dataOffset: Int = 0,
                   private[runtime] val pointers: Int = 0,
                   private[runtime] val dataSize: Int = 0,
                   private[runtime] val pointerCount: Short = 1,
                   private[runtime] val nestingLimit: Int = 0x80000000) {

  protected def _getBooleanField(offset: Int): Boolean = {
    if (offset < this.dataSize) {
      val b = this.segment.buffer.get(this.dataOffset + offset / 8)
      (b & (1 << (offset % 8))) != 0
    } else {
      false
    }
  }

  protected def _getBooleanField(offset: Int, mask: Boolean): Boolean = this._getBooleanField(offset) ^ mask

  protected def _getByteField(offset: Int): Byte = {
    if ((offset + 1) * 8 <= this.dataSize) {
      this.segment.buffer.get(this.dataOffset + offset)
    } else {
      0
    }
  }

  protected def _getByteField(offset: Int, mask: Byte): Byte = {
    (this._getByteField(offset) ^ mask).toByte
  }

  protected def _getShortField(offset: Int): Short = {
    if ((offset + 1) * 16 <= this.dataSize) {
      this.segment.buffer.getShort(this.dataOffset + offset * 2)
    } else {
      0
    }
  }

  protected def _getShortField(offset: Int, mask: Short): Short = {
    (this._getShortField(offset) ^ mask).toShort
  }

  protected def _getIntField(offset: Int): Int = {
    if ((offset + 1) * 32 <= this.dataSize) {
      this.segment.buffer.getInt(this.dataOffset + offset * 4)
    } else {
      0
    }
  }

  protected def _getIntField(offset: Int, mask: Int): Int = this._getIntField(offset) ^ mask

  protected def _getLongField(offset: Int): Long = {
    if ((offset + 1) * 64 <= this.dataSize) {
      this.segment.buffer.getLong(this.dataOffset + offset * 8)
    } else {
      0
    }
  }

  protected def _getLongField(offset: Int, mask: Long): Long = this._getLongField(offset) ^ mask

  protected def _getFloatField(offset: Int): Float = {
    if ((offset + 1) * 32 <= this.dataSize) {
      this.segment.buffer.getFloat(this.dataOffset + offset * 4)
    } else {
      0
    }
  }

  protected def _getFloatField(offset: Int, mask: Int): Float = {
    if ((offset + 1) * 32 <= this.dataSize) {
      java.lang.Float.intBitsToFloat(this.segment.buffer.getInt(this.dataOffset + offset * 4) ^ mask)
    } else {
      java.lang.Float.intBitsToFloat(mask)
    }
  }

  protected def _getDoubleField(offset: Int): Double = {
    if ((offset + 1) * 64 <= this.dataSize) {
      this.segment.buffer.getDouble(this.dataOffset + offset * 8)
    } else {
      0
    }
  }

  protected def _getDoubleField(offset: Int, mask: Long): Double = {
    if ((offset + 1) * 64 <= this.dataSize) {
      java.lang.Double.longBitsToDouble(this.segment.buffer.getLong(this.dataOffset + offset * 8) ^
        mask)
    } else {
      java.lang.Double.longBitsToDouble(mask)
    }
  }

  protected def _pointerFieldIsNull(ptrIndex: Int): Boolean = {
    this.segment.buffer.getLong((this.pointers + ptrIndex) * Constants.BYTES_PER_WORD) ==
      0
  }

  protected def _getPointerFieldOption(factory: FromPointerReaderTF, ptrIndex: Int): Option[factory.Reader] = {
    if (_pointerFieldIsNull(ptrIndex)) {
      None
    } else if (ptrIndex < this.pointerCount) {
      Some(factory.fromPointerReader(this.segment, this.pointers + ptrIndex, this.nestingLimit))
    } else {
      Some(factory.fromPointerReader(SegmentReader.EMPTY, 0, this.nestingLimit))
    }
  }

  protected def _getPointerField(factory: FromPointerReaderTF, ptrIndex: Int): factory.Reader = {
    if (ptrIndex < this.pointerCount) {
      factory.fromPointerReader(this.segment, this.pointers + ptrIndex, this.nestingLimit)
    } else {
      factory.fromPointerReader(SegmentReader.EMPTY, 0, this.nestingLimit)
    }
  }

  protected def _getPointerField(factory: FromPointerReaderRefDefaultTF,
                                    ptrIndex: Int,
                                    defaultSegment: SegmentReader,
                                    defaultOffset: Int): factory.Reader = {
    if (ptrIndex < this.pointerCount) {
      factory.fromPointerReaderRefDefault(this.segment, this.pointers + ptrIndex, defaultSegment, defaultOffset,
        this.nestingLimit)
    } else {
      factory.fromPointerReaderRefDefault(SegmentReader.EMPTY, 0, defaultSegment, defaultOffset, this.nestingLimit)
    }
  }

  protected def _getPointerField(factory: FromPointerReaderBlobDefault,
                                    ptrIndex: Int,
                                    defaultBuffer: java.nio.ByteBuffer,
                                    defaultOffset: Int,
                                    defaultSize: Int): factory.Reader = {
    if (ptrIndex < this.pointerCount) {
      factory.fromPointerReaderBlobDefault(this.segment, this.pointers + ptrIndex, defaultBuffer, defaultOffset,
        defaultSize)
    } else {
      factory.fromPointerReaderBlobDefault(SegmentReader.EMPTY, 0, defaultBuffer, defaultOffset, defaultSize)
    }
  }
}
