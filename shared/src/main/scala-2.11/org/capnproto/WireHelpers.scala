package org.capnproto

import java.nio.ByteBuffer

object WireHelpers {

  def roundBytesUpToWords(bytes: Int): Int = (bytes + 7) / 8

  def roundBitsUpToBytes(bits: Int): Int = (bits + 7) / Constants.BITS_PER_BYTE

  def roundBitsUpToWords(bits: Long): Int = {
    ((bits + 63) / Constants.BITS_PER_WORD.toLong).toInt
  }

  class AllocateResult(val ptr: Int, val refOffset: Int, val segment: SegmentBuilder)


  def allocate(refOffset: Int,
               segment: SegmentBuilder,
               amount: Int,
               kind: Byte): AllocateResult = {
    val ref = segment.get(refOffset)
    if (!WirePointer.isNull(ref)) {
      zeroObject(segment, refOffset)
    }
    if (amount == 0 && kind == WirePointer.STRUCT) {
      WirePointer.setKindAndTargetForEmptyStruct(segment.buffer, refOffset)
      return new AllocateResult(refOffset, refOffset, segment)
    }
    val ptr = segment.allocate(amount)
    if (ptr == SegmentBuilder.FAILED_ALLOCATION) {
      val amountPlusRef = amount + Constants.POINTER_SIZE_IN_WORDS
      val allocation = segment.arena.allocate(amountPlusRef)
      FarPointer.set(segment.buffer, refOffset, false, allocation.offset)
      FarPointer.setSegmentId(segment.buffer, refOffset, allocation.segment.id)
      val resultRefOffset = allocation.offset
      val ptr1 = allocation.offset + Constants.POINTER_SIZE_IN_WORDS
      WirePointer.setKindAndTarget(allocation.segment.buffer, resultRefOffset, kind, ptr1)
      new AllocateResult(ptr1, resultRefOffset, allocation.segment)
    } else {
      WirePointer.setKindAndTarget(segment.buffer, refOffset, kind, ptr)
      new AllocateResult(ptr, refOffset, segment)
    }
  }

  class FollowBuilderFarsResult(val ptr: Int, val ref: Long, val segment: SegmentBuilder)


  def followBuilderFars(_ref: Long, refTarget: Int, segment: SegmentBuilder): FollowBuilderFarsResult = {
    var ref = _ref
    if (WirePointer.kind(ref) == WirePointer.FAR) {
      var resultSegment = segment.arena.getSegment(FarPointer.getSegmentId(ref))
      val padOffset = FarPointer.positionInSegment(ref)
      val pad = resultSegment.get(padOffset)
      if (!FarPointer.isDoubleFar(ref)) {
        return new FollowBuilderFarsResult(WirePointer.target(padOffset, pad), pad, resultSegment)
      }
      val refOffset = padOffset + 1
      ref = resultSegment.get(refOffset)
      resultSegment = resultSegment.arena.getSegment(FarPointer.getSegmentId(pad))
      new FollowBuilderFarsResult(FarPointer.positionInSegment(pad), ref, resultSegment)
    } else {
      new FollowBuilderFarsResult(refTarget, ref, segment)
    }
  }

  class FollowFarsResult(val ptr: Int, val ref: Long, val segment: SegmentReader)


  def followFars(ref: Long, refTarget: Int, segment: SegmentReader): FollowFarsResult = {
    if (segment != null && WirePointer.kind(ref) == WirePointer.FAR) {
      var resultSegment = segment.arena.tryGetSegment(FarPointer.getSegmentId(ref))
      val padOffset = FarPointer.positionInSegment(ref)
      val pad = resultSegment.get(padOffset)
      val padWords = if (FarPointer.isDoubleFar(ref)) 2 else 1
      if (!FarPointer.isDoubleFar(ref)) {
        new FollowFarsResult(WirePointer.target(padOffset, pad), pad, resultSegment)
      } else {
        val tag = resultSegment.get(padOffset + 1)
        resultSegment = resultSegment.arena.tryGetSegment(FarPointer.getSegmentId(pad))
        new FollowFarsResult(FarPointer.positionInSegment(pad), tag, resultSegment)
      }
    } else {
      new FollowFarsResult(refTarget, ref, segment)
    }
  }

  def zeroObject(_segment: SegmentBuilder, refOffset: Int) {
    var segment = _segment
    if (!segment.isWritable) return
    val ref = segment.get(refOffset)
    WirePointer.kind(ref) match {
      case WirePointer.STRUCT | WirePointer.LIST => zeroObject(segment, ref, WirePointer.target(refOffset,
        ref))
      case WirePointer.FAR =>
        segment = segment.arena.getSegment(FarPointer.getSegmentId(ref))
        if (segment.isWritable) {
          val padOffset = FarPointer.positionInSegment(ref)
          val pad = segment.get(padOffset)
          if (FarPointer.isDoubleFar(ref)) {
            val otherSegment = segment.arena.getSegment(FarPointer.getSegmentId(ref))
            if (otherSegment.isWritable) {
              zeroObject(otherSegment, padOffset + 1, FarPointer.positionInSegment(pad))
            }
            segment.buffer.putLong(padOffset * 8, 0L)
            segment.buffer.putLong((padOffset + 1) * 8, 0L)
          } else {
            zeroObject(segment, padOffset)
            segment.buffer.putLong(padOffset * 8, 0L)
          }
        }
      case WirePointer.OTHER =>
    }
  }

  def zeroObject(segment: SegmentBuilder, tag: Long, ptr: Int) {
    if (!segment.isWritable) return
    WirePointer.kind(tag) match {
      case WirePointer.STRUCT =>
        val pointerSection = ptr + StructPointer.dataSize(tag)
        val count = StructPointer.ptrCount(tag)
        for (ii <- 0 until count) {
          zeroObject(segment, pointerSection + ii)
        }
        memset(segment.buffer, ptr * Constants.BYTES_PER_WORD, 0.toByte, StructPointer.wordSize(tag) * Constants.BYTES_PER_WORD)
      case WirePointer.LIST =>
        ListPointer.elementSize(tag) match {
          case ElementSize.VOID =>
          case ElementSize.BIT | ElementSize.BYTE | ElementSize.TWO_BYTES | ElementSize.FOUR_BYTES | ElementSize.EIGHT_BYTES =>
            memset(segment.buffer, ptr * Constants.BYTES_PER_WORD, 0.toByte, roundBitsUpToWords(ListPointer.elementCount(tag) *
              ElementSize.dataBitsPerElement(ListPointer.elementSize(tag))) *
              Constants.BYTES_PER_WORD)
          case ElementSize.POINTER =>
            val count = ListPointer.elementCount(tag)
            for (ii <- 0 until count) {
              zeroObject(segment, ptr + ii)
            }
            memset(segment.buffer, ptr * Constants.BYTES_PER_WORD, 0.toByte, count * Constants.BYTES_PER_WORD)
          case ElementSize.INLINE_COMPOSITE =>
            val elementTag = segment.get(ptr)
            if (WirePointer.kind(elementTag) != WirePointer.STRUCT) {
              throw new Error("Don't know how to handle non-STRUCT inline composite.")
            }
            val dataSize = StructPointer.dataSize(elementTag)
            val pointerCount = StructPointer.ptrCount(elementTag)
            var pos = ptr + Constants.POINTER_SIZE_IN_WORDS
            val count = WirePointer.inlineCompositeListElementCount(elementTag)
            for (ii <- 0 until count) {
              pos += dataSize
              for (jj <- 0 until pointerCount) {
                zeroObject(segment, pos)
                pos += Constants.POINTER_SIZE_IN_WORDS
              }
            }
            memset(segment.buffer, ptr * Constants.BYTES_PER_WORD, 0.toByte, (StructPointer.wordSize(elementTag) * count + Constants.POINTER_SIZE_IN_WORDS) *
              Constants.BYTES_PER_WORD)
        }
      case WirePointer.FAR => throw new Error("Unexpected FAR pointer.")
      case WirePointer.OTHER => throw new Error("Unexpected OTHER pointer.")
    }
  }

  def zeroPointerAndFars(segment: SegmentBuilder, refOffset: Int) {
    val ref = segment.get(refOffset)
    if (WirePointer.kind(ref) == WirePointer.FAR) {
      val padSegment = segment.arena.getSegment(FarPointer.getSegmentId(ref))
      if (padSegment.isWritable) {
        val padOffset = FarPointer.positionInSegment(ref)
        padSegment.buffer.putLong(padOffset * Constants.BYTES_PER_WORD, 0L)
        if (FarPointer.isDoubleFar(ref)) {
          padSegment.buffer.putLong(padOffset * Constants.BYTES_PER_WORD + 1, 0L)
        }
      }
    }
    segment.put(refOffset, 0L)
  }

  def transferPointer(dstSegment: SegmentBuilder,
                      dstOffset: Int,
                      srcSegment: SegmentBuilder,
                      srcOffset: Int) {
    val src = srcSegment.get(srcOffset)
    if (WirePointer.isNull(src)) {
      dstSegment.put(dstOffset, 0L)
    } else if (WirePointer.kind(src) == WirePointer.FAR) {
      dstSegment.put(dstOffset, srcSegment.get(srcOffset))
    } else {
      transferPointer(dstSegment, dstOffset, srcSegment, srcOffset, WirePointer.target(srcOffset, src))
    }
  }

  def transferPointer(dstSegment: SegmentBuilder,
                      dstOffset: Int,
                      srcSegment: SegmentBuilder,
                      srcOffset: Int,
                      srcTargetOffset: Int) {
    val src = srcSegment.get(srcOffset)
    val srcTarget = srcSegment.get(srcTargetOffset)
    if (dstSegment == srcSegment) {
      if (WirePointer.kind(src) == WirePointer.STRUCT && StructPointer.wordSize(src) == 0) {
        WirePointer.setKindAndTargetForEmptyStruct(dstSegment.buffer, dstOffset)
      } else {
        WirePointer.setKindAndTarget(dstSegment.buffer, dstOffset, WirePointer.kind(src), srcTargetOffset)
      }
      dstSegment.buffer.putInt(dstOffset * Constants.BYTES_PER_WORD + 4, srcSegment.buffer.getInt(srcOffset * Constants.BYTES_PER_WORD + 4))
    } else {
      var landingPadOffset = srcSegment.allocate(1)
      if (landingPadOffset == SegmentBuilder.FAILED_ALLOCATION) {
        val allocation = srcSegment.arena.allocate(2)
        val farSegment = allocation.segment
        landingPadOffset = allocation.offset
        FarPointer.set(farSegment.buffer, landingPadOffset, false, srcTargetOffset)
        FarPointer.setSegmentId(farSegment.buffer, landingPadOffset, srcSegment.id)
        WirePointer.setKindWithZeroOffset(farSegment.buffer, landingPadOffset + 1, WirePointer.kind(srcTarget))
        farSegment.buffer.putInt((landingPadOffset + 1) * Constants.BYTES_PER_WORD + 4, srcSegment.buffer.getInt(srcOffset * Constants.BYTES_PER_WORD + 4))
        FarPointer.set(dstSegment.buffer, dstOffset, true, landingPadOffset)
        FarPointer.setSegmentId(dstSegment.buffer, dstOffset, farSegment.id)
      } else {
        WirePointer.setKindAndTarget(srcSegment.buffer, landingPadOffset, WirePointer.kind(srcTarget),
          srcTargetOffset)
        srcSegment.buffer.putInt(landingPadOffset * Constants.BYTES_PER_WORD + 4, srcSegment.buffer.getInt(srcOffset * Constants.BYTES_PER_WORD + 4))
        FarPointer.set(dstSegment.buffer, dstOffset, false, landingPadOffset)
        FarPointer.setSegmentId(dstSegment.buffer, dstOffset, srcSegment.id)
      }
    }
  }

  def initStructPointer(factory: Struct,
                           refOffset: Int,
                           segment: SegmentBuilder,
                           size: StructSize): factory.Builder = {
    val allocation = allocate(refOffset, segment, size.total(), WirePointer.STRUCT.toByte)
    StructPointer.setFromStructSize(allocation.segment.buffer, allocation.refOffset, size)
    factory.Builder(allocation.segment, allocation.ptr * Constants.BYTES_PER_WORD, allocation.ptr + size.data,
      size.data * 64, size.pointers)
  }

  def getWritableStructPointer(factory: Struct,
                                  refOffset: Int,
                                  segment: SegmentBuilder,
                                  size: StructSize,
                                  defaultSegment: SegmentReader,
                                  defaultOffset: Int): factory.Builder = {
    val ref = segment.get(refOffset)
    val target = WirePointer.target(refOffset, ref)
    if (WirePointer.isNull(ref)) {
      if (defaultSegment == null) {
        return initStructPointer(factory, refOffset, segment, size).asInstanceOf[factory.Builder]
      } else {
        throw new Error("unimplemented")
      }
    }
    val resolved = followBuilderFars(ref, target, segment)
    val oldDataSize = StructPointer.dataSize(resolved.ref)
    val oldPointerCount = StructPointer.ptrCount(resolved.ref)
    val oldPointerSection = resolved.ptr + oldDataSize
    if (oldDataSize < size.data || oldPointerCount < size.pointers) {
      val newDataSize = Math.max(oldDataSize, size.data).toShort
      val newPointerCount = Math.max(oldPointerCount, size.pointers).toShort
      val totalSize = newDataSize + newPointerCount * Constants.WORDS_PER_POINTER
      zeroPointerAndFars(segment, refOffset)
      val allocation = allocate(refOffset, segment, totalSize, WirePointer.STRUCT)
      StructPointer.set(allocation.segment.buffer, allocation.refOffset, newDataSize, newPointerCount)
      memcpy(allocation.segment.buffer, allocation.ptr * Constants.BYTES_PER_WORD, resolved.segment.buffer,
        resolved.ptr * Constants.BYTES_PER_WORD, oldDataSize * Constants.BYTES_PER_WORD)
      val newPointerSection = allocation.ptr + newDataSize
      for (ii <- 0 until oldPointerCount) {
        transferPointer(allocation.segment, newPointerSection + ii, resolved.segment, oldPointerSection + ii)
      }
      memset(resolved.segment.buffer, resolved.ptr * Constants.BYTES_PER_WORD, 0.toByte, (oldDataSize + oldPointerCount * Constants.WORDS_PER_POINTER) *
        Constants.BYTES_PER_WORD)
      factory.Builder(allocation.segment, allocation.ptr * Constants.BYTES_PER_WORD, newPointerSection,
        newDataSize * Constants.BITS_PER_WORD, newPointerCount)
    } else {
      factory.Builder(resolved.segment, resolved.ptr * Constants.BYTES_PER_WORD, oldPointerSection,
        oldDataSize * Constants.BITS_PER_WORD, oldPointerCount)
    }
  }

  def initListPointer(factory: ListBuilder.Factory,
                         refOffset: Int,
                         segment: SegmentBuilder,
                         elementCount: Int,
                         elementSize: Byte): factory.Builder = {
    assert(elementSize != ElementSize.INLINE_COMPOSITE, "Should have called initStructListPointer instead")
    val dataSize = ElementSize.dataBitsPerElement(elementSize)
    val pointerCount = ElementSize.pointersPerElement(elementSize)
    val step = dataSize + pointerCount * Constants.BITS_PER_POINTER
    val wordCount = roundBitsUpToWords(elementCount.toLong * step.toLong)
    val allocation = allocate(refOffset, segment, wordCount, WirePointer.LIST)
    ListPointer.set(allocation.segment.buffer, allocation.refOffset, elementSize, elementCount)
    factory.Builder(allocation.segment, allocation.ptr * Constants.BYTES_PER_WORD, elementCount,
      step, dataSize, pointerCount.toShort)
  }

  def initStructListPointer(factory: ListBuilder.Factory,
                               refOffset: Int,
                               segment: SegmentBuilder,
                               elementCount: Int,
                               elementSize: StructSize): factory.Builder = {
    val wordsPerElement = elementSize.total()
    val wordCount = elementCount * wordsPerElement
    val allocation = allocate(refOffset, segment, Constants.POINTER_SIZE_IN_WORDS + wordCount, WirePointer.LIST)
    ListPointer.setInlineComposite(allocation.segment.buffer, allocation.refOffset, wordCount)
    WirePointer.setKindAndInlineCompositeListElementCount(allocation.segment.buffer, allocation.ptr,
      WirePointer.STRUCT, elementCount)
    StructPointer.setFromStructSize(allocation.segment.buffer, allocation.ptr, elementSize)
    factory.Builder(allocation.segment, (allocation.ptr + 1) * Constants.BYTES_PER_WORD, elementCount,
      wordsPerElement * Constants.BITS_PER_WORD, elementSize.data * Constants.BITS_PER_WORD, elementSize.pointers)
  }

  def getWritableListPointer(factory: ListBuilder.Factory,
                                origRefOffset: Int,
                                origSegment: SegmentBuilder,
                                elementSize: Byte,
                                defaultSegment: SegmentReader,
                                defaultOffset: Int): factory.Builder = {
    assert(elementSize != ElementSize.INLINE_COMPOSITE, "Use getStructList{Element,Field} for structs")
    val origRef = origSegment.get(origRefOffset)
    val origRefTarget = WirePointer.target(origRefOffset, origRef)
    if (WirePointer.isNull(origRef)) {
      throw new Error("unimplemented")
    }
    val resolved = followBuilderFars(origRef, origRefTarget, origSegment)
    if (WirePointer.kind(resolved.ref) != WirePointer.LIST) {
      throw new DecodeException("Called getList{Field,Element}() but existing pointer is not a list")
    }
    val oldSize = ListPointer.elementSize(resolved.ref)
    if (oldSize == ElementSize.INLINE_COMPOSITE) {
      throw new Error("unimplemented")
    } else {
      val dataSize = ElementSize.dataBitsPerElement(oldSize)
      val pointerCount = ElementSize.pointersPerElement(oldSize)
      if (dataSize < ElementSize.dataBitsPerElement(elementSize)) {
        throw new DecodeException("Existing list value is incompatible with expected type.")
      }
      if (pointerCount < ElementSize.pointersPerElement(elementSize)) {
        throw new DecodeException("Existing list value is incompatible with expected type.")
      }
      val step = dataSize + pointerCount * Constants.BITS_PER_POINTER
      factory.Builder(resolved.segment, resolved.ptr * Constants.BYTES_PER_WORD, ListPointer.elementCount(resolved.ref),
        step, dataSize, pointerCount.toShort)
    }
  }

  def getWritableStructListPointer(factory: ListBuilder.Factory,
                                      origRefOffset: Int,
                                      origSegment: SegmentBuilder,
                                      elementSize: StructSize,
                                      defaultSegment: SegmentReader,
                                      defaultOffset: Int): factory.Builder = {
    val origRef = origSegment.get(origRefOffset)
    val origRefTarget = WirePointer.target(origRefOffset, origRef)
    if (WirePointer.isNull(origRef)) {
      throw new Error("unimplemented")
    }
    val resolved = followBuilderFars(origRef, origRefTarget, origSegment)
    if (WirePointer.kind(resolved.ref) != WirePointer.LIST) {
      throw new DecodeException("Called getList{Field,Element}() but existing pointer is not a list")
    }
    val oldSize = ListPointer.elementSize(resolved.ref)
    if (oldSize == ElementSize.INLINE_COMPOSITE) {
      val oldTag = resolved.segment.get(resolved.ptr)
      val oldPtr = resolved.ptr + Constants.POINTER_SIZE_IN_WORDS
      if (WirePointer.kind(oldTag) != WirePointer.STRUCT) {
        throw new DecodeException("INLINE_COMPOSITE list with non-STRUCT elements not supported.")
      }
      val oldDataSize = StructPointer.dataSize(oldTag)
      val oldPointerCount = StructPointer.ptrCount(oldTag)
      val oldStep = (oldDataSize + oldPointerCount * Constants.POINTER_SIZE_IN_WORDS)
      val elementCount = WirePointer.inlineCompositeListElementCount(oldTag)
      if (oldDataSize >= elementSize.data && oldPointerCount >= elementSize.pointers) {
        return factory.Builder(resolved.segment, oldPtr * Constants.BYTES_PER_WORD, elementCount,
          oldStep * Constants.BITS_PER_WORD, oldDataSize * Constants.BITS_PER_WORD, oldPointerCount)
      }
      val newDataSize = Math.max(oldDataSize, elementSize.data).toShort
      val newPointerCount = Math.max(oldPointerCount, elementSize.pointers).toShort
      val newStep = newDataSize + newPointerCount * Constants.WORDS_PER_POINTER
      val totalSize = newStep * elementCount
      zeroPointerAndFars(origSegment, origRefOffset)
      val allocation = allocate(origRefOffset, origSegment, totalSize + Constants.POINTER_SIZE_IN_WORDS,
        WirePointer.LIST)
      ListPointer.setInlineComposite(allocation.segment.buffer, allocation.refOffset, totalSize)
      val tag = allocation.segment.get(allocation.ptr)
      WirePointer.setKindAndInlineCompositeListElementCount(allocation.segment.buffer, allocation.ptr,
        WirePointer.STRUCT, elementCount)
      StructPointer.set(allocation.segment.buffer, allocation.ptr, newDataSize, newPointerCount)
      val newPtr = allocation.ptr + Constants.POINTER_SIZE_IN_WORDS
      var src = oldPtr
      var dst = newPtr
      for (ii <- 0 until elementCount) {
        memcpy(allocation.segment.buffer, dst * Constants.BYTES_PER_WORD, resolved.segment.buffer, src * Constants.BYTES_PER_WORD,
          oldDataSize * Constants.BYTES_PER_WORD)
        val newPointerSection = dst + newDataSize
        val oldPointerSection = src + oldDataSize
        for (jj <- 0 until oldPointerCount) {
          transferPointer(allocation.segment, newPointerSection + jj, resolved.segment, oldPointerSection + jj)
        }
        dst += newStep
        src += oldStep
      }
      memset(resolved.segment.buffer, resolved.ptr * Constants.BYTES_PER_WORD, 0.toByte, oldStep * elementCount * Constants.BYTES_PER_WORD)
      factory.Builder(allocation.segment, newPtr * Constants.BYTES_PER_WORD, elementCount, newStep * Constants.BITS_PER_WORD,
        newDataSize * Constants.BITS_PER_WORD, newPointerCount)
    } else {
      val oldDataSize = ElementSize.dataBitsPerElement(oldSize)
      val oldPointerCount = ElementSize.pointersPerElement(oldSize)
      val oldStep = oldDataSize + oldPointerCount * Constants.BITS_PER_POINTER
      val elementCount = ListPointer.elementCount(origRef)
      if (oldSize == ElementSize.VOID) {
          initStructListPointer(factory, origRefOffset, origSegment, elementCount, elementSize).asInstanceOf[factory.Builder]
      } else {
        if (oldSize == ElementSize.BIT) {
          throw new Error("Found bit list where struct list was expected; " +
            "upgrading boolean lists to struct is no longer supported.")
        }
        var newDataSize = elementSize.data
        var newPointerCount = elementSize.pointers
        if (oldSize == ElementSize.POINTER) {
          newPointerCount = Math.max(newPointerCount, 1).toShort
        } else {
          newDataSize = Math.max(newDataSize, 1).toShort
        }
        val newStep = (newDataSize + newPointerCount * Constants.WORDS_PER_POINTER)
        val totalWords = elementCount * newStep
        zeroPointerAndFars(origSegment, origRefOffset)
        val allocation = allocate(origRefOffset, origSegment, totalWords + Constants.POINTER_SIZE_IN_WORDS,
          WirePointer.LIST)
        ListPointer.setInlineComposite(allocation.segment.buffer, allocation.refOffset, totalWords)
        val tag = allocation.segment.get(allocation.ptr)
        WirePointer.setKindAndInlineCompositeListElementCount(allocation.segment.buffer, allocation.ptr,
          WirePointer.STRUCT, elementCount)
        StructPointer.set(allocation.segment.buffer, allocation.ptr, newDataSize, newPointerCount)
        val newPtr = allocation.ptr + Constants.POINTER_SIZE_IN_WORDS
        if (oldSize == ElementSize.POINTER) {
          var dst = newPtr + newDataSize
          var src = resolved.ptr
          for (ii <- 0 until elementCount) {
            transferPointer(origSegment, dst, resolved.segment, src)
            dst += newStep / Constants.WORDS_PER_POINTER
            src += 1
          }
        } else {
          var dst = newPtr
          var srcByteOffset = resolved.ptr * Constants.BYTES_PER_WORD
          val oldByteStep = oldDataSize / Constants.BITS_PER_BYTE
          for (ii <- 0 until elementCount) {
            memcpy(allocation.segment.buffer, dst * Constants.BYTES_PER_WORD, resolved.segment.buffer,
              srcByteOffset, oldByteStep)
            srcByteOffset += oldByteStep
            dst += newStep
          }
        }
        memset(resolved.segment.buffer, resolved.ptr * Constants.BYTES_PER_WORD, 0.toByte, roundBitsUpToBytes(oldStep * elementCount))
        factory.Builder(allocation.segment, newPtr * Constants.BYTES_PER_WORD, elementCount,
          newStep * Constants.BITS_PER_WORD, newDataSize * Constants.BITS_PER_WORD, newPointerCount)
      }
    }
  }

  def initTextPointer(refOffset: Int, segment: SegmentBuilder, size: Int): Text.Builder = {
    val byteSize = size + 1
    val allocation = allocate(refOffset, segment, roundBytesUpToWords(byteSize), WirePointer.LIST)
    ListPointer.set(allocation.segment.buffer, allocation.refOffset, ElementSize.BYTE, byteSize)
    new Text.Builder(allocation.segment.buffer, allocation.ptr * Constants.BYTES_PER_WORD, size)
  }

  def setTextPointer(refOffset: Int, segment: SegmentBuilder, value: Text.Reader): Text.Builder = {
    val builder = initTextPointer(refOffset, segment, value.size)
    val slice = value.buffer.duplicate()
    slice.position(value.offset)
    slice.limit(value.offset + value.size)
    builder.buffer.position(builder.offset)
    builder.buffer.put(slice)
    builder
  }

  def getWritableTextPointer(refOffset: Int,
                             segment: SegmentBuilder,
                             defaultBuffer: ByteBuffer,
                             defaultOffset: Int,
                             defaultSize: Int): Text.Builder = {
    val ref = segment.get(refOffset)
    if (WirePointer.isNull(ref)) {
      if (defaultBuffer == null) {
        return new Text.Builder()
      } else {
        val builder = initTextPointer(refOffset, segment, defaultSize)
        for (i <- 0 until builder.size) {
          builder.buffer.put(builder.offset + i, defaultBuffer.get(defaultOffset * 8 + i))
        }
        return builder
      }
    }
    val refTarget = WirePointer.target(refOffset, ref)
    val resolved = followBuilderFars(ref, refTarget, segment)
    if (WirePointer.kind(resolved.ref) != WirePointer.LIST) {
      throw new DecodeException("Called getText{Field,Element} but existing pointer is not a list.")
    }
    if (ListPointer.elementSize(resolved.ref) != ElementSize.BYTE) {
      throw new DecodeException("Called getText{Field,Element} but existing list pointer is not byte-sized.")
    }
    val size = ListPointer.elementCount(resolved.ref)
    if (size == 0 ||
      resolved.segment.buffer.get(resolved.ptr * Constants.BYTES_PER_WORD + size - 1) !=
        0) {
      throw new DecodeException("Text blob missing NUL terminator.")
    }
    new Text.Builder(resolved.segment.buffer, resolved.ptr * Constants.BYTES_PER_WORD, size - 1)
  }

  def initDataPointer(refOffset: Int, segment: SegmentBuilder, size: Int): Data.Builder = {
    val allocation = allocate(refOffset, segment, roundBytesUpToWords(size), WirePointer.LIST)
    ListPointer.set(allocation.segment.buffer, allocation.refOffset, ElementSize.BYTE, size)
    new Data.Builder(allocation.segment.buffer, allocation.ptr * Constants.BYTES_PER_WORD, size)
  }

  def setDataPointer(refOffset: Int, segment: SegmentBuilder, value: Data.Reader): Data.Builder = {
    val builder = initDataPointer(refOffset, segment, value.size)
    for (i <- 0 until builder.size) {
      builder.buffer.put(builder.offset + i, value.buffer.get(value.offset + i))
    }
    builder
  }

  def getWritableDataPointer(refOffset: Int,
                             segment: SegmentBuilder,
                             defaultBuffer: ByteBuffer,
                             defaultOffset: Int,
                             defaultSize: Int): Data.Builder = {
    val ref = segment.get(refOffset)
    if (WirePointer.isNull(ref)) {
      if (defaultBuffer == null) {
        return new Data.Builder()
      } else {
        val builder = initDataPointer(refOffset, segment, defaultSize)
        for (i <- 0 until builder.size) {
          builder.buffer.put(builder.offset + i, defaultBuffer.get(defaultOffset * 8 + i))
        }
        return builder
      }
    }
    val refTarget = WirePointer.target(refOffset, ref)
    val resolved = followBuilderFars(ref, refTarget, segment)
    if (WirePointer.kind(resolved.ref) != WirePointer.LIST) {
      throw new DecodeException("Called getData{Field,Element} but existing pointer is not a list.")
    }
    if (ListPointer.elementSize(resolved.ref) != ElementSize.BYTE) {
      throw new DecodeException("Called getData{Field,Element} but existing list pointer is not byte-sized.")
    }
    new Data.Builder(resolved.segment.buffer, resolved.ptr * Constants.BYTES_PER_WORD, ListPointer.elementCount(resolved.ref))
  }

  def readStructPointerTF(factory: StructReader.FactoryTF,
                           _segment: SegmentReader,
                           _refOffset: Int,
                           defaultSegment: SegmentReader,
                           defaultOffset: Int,
                           nestingLimit: Int): factory.Reader = {
    var segment = _segment
    var refOffset = _refOffset

    var ref = segment.get(refOffset)
    if (WirePointer.isNull(ref)) {
      if (defaultSegment == null) {
        return factory.Reader(SegmentReader.EMPTY, 0, 0, 0, 0.toShort, 0x7fffffff)
      } else {
        segment = defaultSegment
        refOffset = defaultOffset
        ref = segment.get(refOffset)
      }
    }
    if (nestingLimit <= 0) {
      throw new DecodeException("Message is too deeply nested or contains cycles.")
    }
    val refTarget = WirePointer.target(refOffset, ref)
    val resolved = followFars(ref, refTarget, segment)
    val dataSizeWords = StructPointer.dataSize(resolved.ref)
    if (WirePointer.kind(resolved.ref) != WirePointer.STRUCT) {
      throw new DecodeException("Message contains non-struct pointer where struct pointer was expected.")
    }
    resolved.segment.arena.checkReadLimit(StructPointer.wordSize(resolved.ref))
    factory.Reader(resolved.segment, resolved.ptr * Constants.BYTES_PER_WORD, resolved.ptr + dataSizeWords,
      dataSizeWords * Constants.BITS_PER_WORD, StructPointer.ptrCount(resolved.ref), nestingLimit - 1)
  }


  def readStructPointer[T](factory: StructReader.Factory[T],
                           _segment: SegmentReader,
                           _refOffset: Int,
                           defaultSegment: SegmentReader,
                           defaultOffset: Int,
                           nestingLimit: Int): T = {
    var segment = _segment
    var refOffset = _refOffset

    var ref = segment.get(refOffset)
    if (WirePointer.isNull(ref)) {
      if (defaultSegment == null) {
        return factory.constructReader(SegmentReader.EMPTY, 0, 0, 0, 0.toShort, 0x7fffffff)
      } else {
        segment = defaultSegment
        refOffset = defaultOffset
        ref = segment.get(refOffset)
      }
    }
    if (nestingLimit <= 0) {
      throw new DecodeException("Message is too deeply nested or contains cycles.")
    }
    val refTarget = WirePointer.target(refOffset, ref)
    val resolved = followFars(ref, refTarget, segment)
    val dataSizeWords = StructPointer.dataSize(resolved.ref)
    if (WirePointer.kind(resolved.ref) != WirePointer.STRUCT) {
      throw new DecodeException("Message contains non-struct pointer where struct pointer was expected.")
    }
    resolved.segment.arena.checkReadLimit(StructPointer.wordSize(resolved.ref))
    factory.constructReader(resolved.segment, resolved.ptr * Constants.BYTES_PER_WORD, (resolved.ptr + dataSizeWords),
      dataSizeWords * Constants.BITS_PER_WORD, StructPointer.ptrCount(resolved.ref), nestingLimit - 1)
  }

  def setStructPointer(segment: SegmentBuilder, refOffset: Int, value: StructReader): SegmentBuilder = {
    val dataSize = roundBitsUpToWords(value.dataSize).toShort
    val totalSize = dataSize +
      value.pointerCount * Constants.POINTER_SIZE_IN_WORDS
    val allocation = allocate(refOffset, segment, totalSize, WirePointer.STRUCT)
    StructPointer.set(allocation.segment.buffer, allocation.refOffset, dataSize, value.pointerCount)
    if (value.dataSize == 1) {
      throw new Error("single bit case not handled")
    } else {
      memcpy(allocation.segment.buffer, allocation.ptr * Constants.BYTES_PER_WORD, value.segment.buffer,
        value.dataOffset, value.dataSize / Constants.BITS_PER_BYTE)
    }
    val pointerSection = allocation.ptr + dataSize
    for (i <- 0 until value.pointerCount) {
      copyPointer(allocation.segment, pointerSection + i, value.segment, value.pointers + i, value.nestingLimit)
    }
    allocation.segment
  }

  def setListPointer(segment: SegmentBuilder, refOffset: Int, value: ListReader): SegmentBuilder = {
    val totalSize = roundBitsUpToWords(value.elementCount * value.step)
    if (value.step <= Constants.BITS_PER_WORD) {
      val allocation = allocate(refOffset, segment, totalSize, WirePointer.LIST)
      if (value.structPointerCount == 1) {
        ListPointer.set(allocation.segment.buffer, allocation.refOffset, ElementSize.POINTER, value.elementCount)
        for (i <- 0 until value.elementCount) {
          copyPointer(allocation.segment, allocation.ptr + i, value.segment, value.ptr / Constants.BYTES_PER_WORD + i,
            value.nestingLimit)
        }
      } else {
        var elementSize = ElementSize.VOID
        value.step match {
          case 0 => elementSize = ElementSize.VOID
          case 1 => elementSize = ElementSize.BIT
          case 8 => elementSize = ElementSize.BYTE
          case 16 => elementSize = ElementSize.TWO_BYTES
          case 32 => elementSize = ElementSize.FOUR_BYTES
          case 64 => elementSize = ElementSize.EIGHT_BYTES
          case _ => throw new Error("invalid list step size: " + value.step)
        }
        ListPointer.set(allocation.segment.buffer, allocation.refOffset, elementSize, value.elementCount)
        memcpy(allocation.segment.buffer, allocation.ptr * Constants.BYTES_PER_WORD, value.segment.buffer,
          value.ptr, totalSize * Constants.BYTES_PER_WORD)
      }
      allocation.segment
    } else {
      val allocation = allocate(refOffset, segment, totalSize + Constants.POINTER_SIZE_IN_WORDS, WirePointer.LIST)
      ListPointer.setInlineComposite(allocation.segment.buffer, allocation.refOffset, totalSize)
      val dataSize = roundBitsUpToWords(value.structDataSize).toShort
      val pointerCount = value.structPointerCount
      WirePointer.setKindAndInlineCompositeListElementCount(allocation.segment.buffer, allocation.ptr,
        WirePointer.STRUCT, value.elementCount)
      StructPointer.set(allocation.segment.buffer, allocation.ptr, dataSize, pointerCount)
      var dstOffset = allocation.ptr + Constants.POINTER_SIZE_IN_WORDS
      var srcOffset = value.ptr / Constants.BYTES_PER_WORD
      for (i <- 0 until value.elementCount) {
        memcpy(allocation.segment.buffer, dstOffset * Constants.BYTES_PER_WORD, value.segment.buffer,
          srcOffset * Constants.BYTES_PER_WORD, value.structDataSize / Constants.BITS_PER_BYTE)
        dstOffset += dataSize
        srcOffset += dataSize
        for (j <- 0 until pointerCount) {
          copyPointer(allocation.segment, dstOffset, value.segment, srcOffset, value.nestingLimit)
          dstOffset += Constants.POINTER_SIZE_IN_WORDS
          srcOffset += Constants.POINTER_SIZE_IN_WORDS
        }
      }
      allocation.segment
    }
  }

  def memset(dstBuffer: ByteBuffer,
             dstByteOffset: Int,
             value: Byte,
             length: Int) {
    for (ii <- dstByteOffset until dstByteOffset + length) {
      dstBuffer.put(ii, value)
    }
  }

  def memcpy(dstBuffer: ByteBuffer,
             dstByteOffset: Int,
             srcBuffer: ByteBuffer,
             srcByteOffset: Int,
             length: Int) {
    val dstDup = dstBuffer.duplicate()
    dstDup.position(dstByteOffset)
    dstDup.limit(dstByteOffset + length)
    val srcDup = srcBuffer.duplicate()
    srcDup.position(srcByteOffset)
    srcDup.limit(srcByteOffset + length)
    dstDup.put(srcDup)
  }

  def copyPointer(dstSegment: SegmentBuilder,
                  dstOffset: Int,
                  srcSegment: SegmentReader,
                  srcOffset: Int,
                  nestingLimit: Int): SegmentBuilder = {
    val srcRef = srcSegment.get(srcOffset)
    if (WirePointer.isNull(srcRef)) {
      dstSegment.buffer.putLong(dstOffset * 8, 0L)
      return dstSegment
    }
    val srcTarget = WirePointer.target(srcOffset, srcRef)
    val resolved = followFars(srcRef, srcTarget, srcSegment)
    WirePointer.kind(resolved.ref) match {
      case WirePointer.STRUCT =>
        if (nestingLimit <= 0) {
          throw new DecodeException("Message is too deeply nested or contains cycles. See org.capnproto.ReaderOptions.")
        }
        resolved.segment.arena.checkReadLimit(StructPointer.wordSize(resolved.ref))
        return setStructPointer(dstSegment, dstOffset, new StructReader(resolved.segment, resolved.ptr * Constants.BYTES_PER_WORD,
          resolved.ptr + StructPointer.dataSize(resolved.ref), StructPointer.dataSize(resolved.ref) * Constants.BITS_PER_WORD,
          StructPointer.ptrCount(resolved.ref), nestingLimit - 1))

      case WirePointer.LIST =>
        var elementSize = ListPointer.elementSize(resolved.ref)
        if (nestingLimit <= 0) {
          throw new DecodeException("Message is too deeply nested or contains cycles. See org.capnproto.ReaderOptions.")
        }
        if (elementSize == ElementSize.INLINE_COMPOSITE) {
          val wordCount = ListPointer.inlineCompositeWordCount(resolved.ref)
          val tag = resolved.segment.get(resolved.ptr)
          val ptr = resolved.ptr + 1
          resolved.segment.arena.checkReadLimit(wordCount + 1)
          if (WirePointer.kind(tag) != WirePointer.STRUCT) {
            throw new DecodeException("INLINE_COMPOSITE lists of non-STRUCT type are not supported.")
          }
          val elementCount = WirePointer.inlineCompositeListElementCount(tag)
          val wordsPerElement = StructPointer.wordSize(tag)
          if (wordsPerElement.toLong * elementCount > wordCount) {
            throw new DecodeException("INLINE_COMPOSITE list's elements overrun its word count.")
          }
          if (wordsPerElement == 0) {
            resolved.segment.arena.checkReadLimit(elementCount)
          }
          return setListPointer(dstSegment, dstOffset, new ListReader(resolved.segment, ptr * Constants.BYTES_PER_WORD,
            elementCount, wordsPerElement * Constants.BITS_PER_WORD, StructPointer.dataSize(tag) * Constants.BITS_PER_WORD,
            StructPointer.ptrCount(tag), nestingLimit - 1))
        } else {
          val dataSize = ElementSize.dataBitsPerElement(elementSize)
          val pointerCount = ElementSize.pointersPerElement(elementSize)
          val step = dataSize + pointerCount * Constants.BITS_PER_POINTER
          val elementCount = ListPointer.elementCount(resolved.ref)
          val wordCount = roundBitsUpToWords(elementCount.toLong * step)
          resolved.segment.arena.checkReadLimit(wordCount)
          if (elementSize == ElementSize.VOID) {
            resolved.segment.arena.checkReadLimit(elementCount)
          }
          return setListPointer(dstSegment, dstOffset, new ListReader(resolved.segment, resolved.ptr * Constants.BYTES_PER_WORD,
            elementCount, step, dataSize, pointerCount, nestingLimit - 1))
        }

      case WirePointer.FAR => throw new Error("Far pointer should have been handled above.")
      case WirePointer.OTHER => throw new Error("copyPointer is unimplemented")
    }
    throw new Error("unreachable")
  }

  def readListPointer(factory: ListReader.Factory,
                         _segment: SegmentReader,
                         _refOffset: Int,
                         defaultSegment: SegmentReader,
                         defaultOffset: Int,
                         expectedElementSize: Byte,
                         nestingLimit: Int): factory.Reader = {
    var segment = _segment
    var refOffset = _refOffset
    var ref = segment.get(refOffset)
    if (WirePointer.isNull(ref)) {
      if (defaultSegment == null) {
        return factory.Reader(SegmentReader.EMPTY, 0, 0, 0, 0, 0.toShort, 0x7fffffff)
      } else {
        segment = defaultSegment
        refOffset = defaultOffset
        ref = segment.get(refOffset)
      }
    }
    if (nestingLimit <= 0) {
      throw new Error("nesting limit exceeded")
    }
    val refTarget = WirePointer.target(refOffset, ref)
    val resolved = followFars(ref, refTarget, segment)
    val elementSize = ListPointer.elementSize(resolved.ref)
    elementSize match {
      case ElementSize.INLINE_COMPOSITE => {
        val wordCount = ListPointer.inlineCompositeWordCount(resolved.ref)
        val tag = resolved.segment.get(resolved.ptr)
        val ptr = resolved.ptr + 1
        resolved.segment.arena.checkReadLimit(wordCount + 1)
        val size = WirePointer.inlineCompositeListElementCount(tag)
        val wordsPerElement = StructPointer.wordSize(tag)
        if (size.toLong * wordsPerElement > wordCount) {
          throw new DecodeException("INLINE_COMPOSITE list's elements overrun its word count.")
        }
        if (wordsPerElement == 0) {
          resolved.segment.arena.checkReadLimit(size)
        }
        factory.Reader(resolved.segment, ptr * Constants.BYTES_PER_WORD, size, wordsPerElement * Constants.BITS_PER_WORD,
          StructPointer.dataSize(tag) * Constants.BITS_PER_WORD, StructPointer.ptrCount(tag), nestingLimit - 1)
      }
      case _ => {
        val dataSize = ElementSize.dataBitsPerElement(ListPointer.elementSize(resolved.ref))
        val pointerCount = ElementSize.pointersPerElement(ListPointer.elementSize(resolved.ref))
        val elementCount = ListPointer.elementCount(resolved.ref)
        val step = dataSize + pointerCount * Constants.BITS_PER_POINTER
        resolved.segment.arena.checkReadLimit(roundBitsUpToWords(elementCount * step))
        if (elementSize == ElementSize.VOID) {
          resolved.segment.arena.checkReadLimit(elementCount)
        }
        val expectedDataBitsPerElement = ElementSize.dataBitsPerElement(expectedElementSize)
        val expectedPointersPerElement = ElementSize.pointersPerElement(expectedElementSize)
        if (expectedDataBitsPerElement > dataSize) {
          throw new DecodeException("Message contains list with incompatible element type.")
        }
        if (expectedPointersPerElement > pointerCount) {
          throw new DecodeException("Message contains list with incompatible element type.")
        }
        factory.Reader(resolved.segment, resolved.ptr * Constants.BYTES_PER_WORD, ListPointer.elementCount(resolved.ref),
          step, dataSize, pointerCount.toShort, nestingLimit - 1)
      }
    }
  }

  def readTextPointer(segment: SegmentReader,
                      refOffset: Int,
                      defaultBuffer: ByteBuffer,
                      defaultOffset: Int,
                      defaultSize: Int): Text.Reader = {
    val ref = segment.get(refOffset)
    if (WirePointer.isNull(ref)) {
      if (defaultBuffer == null) {
        return new Text.Reader()
      } else {
        return new Text.Reader(defaultBuffer, defaultOffset, defaultSize)
      }
    }
    val refTarget = WirePointer.target(refOffset, ref)
    val resolved = followFars(ref, refTarget, segment)
    val size = ListPointer.elementCount(resolved.ref)
    if (WirePointer.kind(resolved.ref) != WirePointer.LIST) {
      throw new DecodeException("Message contains non-list pointer where text was expected.")
    }
    if (ListPointer.elementSize(resolved.ref) != ElementSize.BYTE) {
      throw new DecodeException("Message contains list pointer of non-bytes where text was expected.")
    }
    resolved.segment.arena.checkReadLimit(roundBytesUpToWords(size))
    if (size == 0 ||
      resolved.segment.buffer.get(8 * resolved.ptr + size - 1) !=
        0) {
      throw new DecodeException("Message contains text that is not NUL-terminated.")
    }
    new Text.Reader(resolved.segment.buffer, resolved.ptr, size - 1)
  }

  def readDataPointer(segment: SegmentReader,
                      refOffset: Int,
                      defaultBuffer: ByteBuffer,
                      defaultOffset: Int,
                      defaultSize: Int): Data.Reader = {
    val ref = segment.get(refOffset)
    if (WirePointer.isNull(ref)) {
      if (defaultBuffer == null) {
        return new Data.Reader()
      } else {
        return new Data.Reader(defaultBuffer, defaultOffset, defaultSize)
      }
    }
    val refTarget = WirePointer.target(refOffset, ref)
    val resolved = followFars(ref, refTarget, segment)
    val size = ListPointer.elementCount(resolved.ref)
    if (WirePointer.kind(resolved.ref) != WirePointer.LIST) {
      throw new DecodeException("Message contains non-list pointer where data was expected.")
    }
    if (ListPointer.elementSize(resolved.ref) != ElementSize.BYTE) {
      throw new DecodeException("Message contains list pointer of non-bytes where data was expected.")
    }
    resolved.segment.arena.checkReadLimit(roundBytesUpToWords(size))
    new Data.Reader(resolved.segment.buffer, resolved.ptr, size)
  }
}

