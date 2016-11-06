package org.murtsi.capnproto.runtime

import java.io.IOException
import java.nio.{ByteBuffer, ByteOrder}
import java.nio.channels.{ReadableByteChannel, WritableByteChannel}
import java.util

object Serialize {

  def makeByteBuffer(bytes: Int): ByteBuffer = {
    val result = ByteBuffer.allocate(bytes)
    result.order(ByteOrder.LITTLE_ENDIAN)
    result.mark()
    result
  }

  def fillBuffer(buffer: ByteBuffer, bc: ReadableByteChannel) {
    while (buffer.hasRemaining) {
      val r = bc.read(buffer)
      if (r < 0) {
        throw new IOException("premature EOF")
      }
    }
  }

  def read(bc: ReadableByteChannel): MessageReader = {
    read(bc, ReaderOptions.DEFAULT_READER_OPTIONS)
  }

  def read(bc: ReadableByteChannel, options: ReaderOptions): MessageReader = {
    val firstWord = makeByteBuffer(Constants.BYTES_PER_WORD)
    fillBuffer(firstWord, bc)
    val segmentCount = 1 + firstWord.getInt(0)
    var segment0Size = 0
    if (segmentCount > 0) {
      segment0Size = firstWord.getInt(4)
    }
    var totalWords = segment0Size
    if (segmentCount > 512) {
      throw new IOException("too many segments")
    }
    val moreSizes = new util.ArrayList[Integer]()
    if (segmentCount > 1) {
      val moreSizesRaw = makeByteBuffer(4 * (segmentCount & ~1))
      fillBuffer(moreSizesRaw, bc)
      for (ii <- 0 until segmentCount - 1) {
        val size = moreSizesRaw.getInt(ii * 4)
        moreSizes.add(size)
        totalWords += size
      }
    }
    if (totalWords > options.traversalLimitInWords) {
      throw new DecodeException("Message size exceeds traversal limit.")
    }
    val allSegments = makeByteBuffer(totalWords * Constants.BYTES_PER_WORD)
    fillBuffer(allSegments, bc)
    val segmentSlices = Array.ofDim[ByteBuffer](segmentCount)
    allSegments.rewind()
    segmentSlices(0) = allSegments.slice()
    segmentSlices(0).limit(segment0Size * Constants.BYTES_PER_WORD)
    segmentSlices(0).order(ByteOrder.LITTLE_ENDIAN)
    var offset = segment0Size
    for (ii <- 1 until segmentCount) {
      allSegments.position(offset * Constants.BYTES_PER_WORD)
      segmentSlices(ii) = allSegments.slice()
      segmentSlices(ii).limit(moreSizes.get(ii - 1) * Constants.BYTES_PER_WORD)
      segmentSlices(ii).order(ByteOrder.LITTLE_ENDIAN)
      offset += moreSizes.get(ii - 1)
    }
    new MessageReader(segmentSlices, options)
  }

  def read(bb: ByteBuffer): MessageReader = {
    read(bb, ReaderOptions.DEFAULT_READER_OPTIONS)
  }

  def read(bb: ByteBuffer, options: ReaderOptions): MessageReader = {
    bb.order(ByteOrder.LITTLE_ENDIAN)
    val segmentCount = 1 + bb.getInt
    if (segmentCount > 512) {
      throw new IOException("too many segments")
    }
    val segmentSlices = Array.ofDim[ByteBuffer](segmentCount)
    val segmentSizesBase = bb.position()
    val segmentSizesSize = segmentCount * 4
    val align = Constants.BYTES_PER_WORD - 1
    val segmentBase = (segmentSizesBase + segmentSizesSize + align) & ~align
    var totalWords = 0
    for (ii <- 0 until segmentCount) {
      val segmentSize = bb.getInt(segmentSizesBase + ii * 4)
      bb.position(segmentBase + totalWords * Constants.BYTES_PER_WORD)
      segmentSlices(ii) = bb.slice()
      segmentSlices(ii).limit(segmentSize * Constants.BYTES_PER_WORD)
      segmentSlices(ii).order(ByteOrder.LITTLE_ENDIAN)
      totalWords += segmentSize
    }
    bb.position(segmentBase + totalWords * Constants.BYTES_PER_WORD)
    if (totalWords > options.traversalLimitInWords) {
      throw new DecodeException("Message size exceeds traversal limit.")
    }
    new MessageReader(segmentSlices, options)
  }

  def computeSerializedSizeInWords(message: MessageBuilder): Long = {
    val segments = message.getSegmentsForOutput()
    var bytes: Long = 0
    bytes += 4
    bytes += segments.length * 4
    if (bytes % 8 != 0) {
      bytes += 4
    }
    for (i <- segments.indices) {
      val s = segments(i)
      bytes += s.limit()
    }
    bytes / Constants.BYTES_PER_WORD
  }

  def writeToByteBuffer(message: MessageBuilder): ByteBuffer = {
    val segments = message.getSegmentsForOutput()
    val segmentsSize = segments.map(_.remaining()).sum
    val tableSize = (segments.length + 2) & (~1)
    val table = ByteBuffer.allocateDirect(4 * tableSize + segmentsSize)
    table.order(ByteOrder.LITTLE_ENDIAN)
    table.putInt(0, segments.length - 1)
    for (i <- segments.indices) {
      table.putInt(4 * (i + 1), segments(i).limit() / 8)
    }
    table.position(tableSize * 4)

    for (buffer <- segments) {
      while (buffer.hasRemaining) {
        table.put(buffer)
      }
    }

    table.flip()
    table
  }

  def write(outputChannel: WritableByteChannel, message: MessageBuilder) {
    val segments = message.getSegmentsForOutput()
    val tableSize = (segments.length + 2) & (~1)
    val table = ByteBuffer.allocate(4 * tableSize)
    table.order(ByteOrder.LITTLE_ENDIAN)
    table.putInt(0, segments.length - 1)
    for (i <- segments.indices) {
      table.putInt(4 * (i + 1), segments(i).limit() / 8)
    }
    while (table.hasRemaining) {
      outputChannel.write(table)
    }
    for (buffer <- segments) {
      while (buffer.hasRemaining) {
        outputChannel.write(buffer)
      }
    }
  }
}
