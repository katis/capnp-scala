package org.murtsi.capnproto.runtime

import java.nio.{ByteBuffer, ByteOrder}

import scala.annotation.tailrec
import scala.collection.mutable

class MessageStreamParser(options: ReaderOptions = ReaderOptions.DEFAULT_READER_OPTIONS) {
  private val bufs = new ByteBufferList

  def update(buffer: ByteBuffer): Option[MessageReader] = {
    bufs.add(buffer)
    next()
  }

  private var segmentCount = -1
  private var segment0Size = -1
  private var totalWords = -1
  private val firstWord = makeByteBuffer(Constants.BYTES_PER_WORD)
  private val moreSizes = mutable.ArrayBuffer[Integer]()
  private var moreSizesRaw: ByteBuffer = _
  private var allSegments: ByteBuffer = _

  val Init = 0
  val Segments = 1
  val FillExtraSegmentSizes = 2
  val InitAllSegments = 3
  val FillAllSegments = 4
  private var state = Init

  @tailrec
  private def next(): Option[MessageReader] = {
    state match {
      case Init =>
        if (bufs.read(firstWord)) {
          segmentCount = firstWord.getInt(0) + 1
          segment0Size = if (segmentCount > 0) firstWord.getInt(4) else 0
          totalWords = segment0Size
          if (segmentCount > 512) {
            throw new Error("too many segments")
          }
          if (segmentCount > 1) {
            moreSizesRaw = makeByteBuffer(4 * (segmentCount & ~1))
            state = FillExtraSegmentSizes
          } else {
            state = InitAllSegments
          }
          next()
        } else {
          None
        }
      case FillExtraSegmentSizes =>
        if (bufs.read(moreSizesRaw)) {
          var i = 0
          while (i < segmentCount) {
            val size = moreSizesRaw.getInt(i * 4)
            moreSizes += size
            totalWords += size
            i += 1
          }
          state = InitAllSegments
          next()
        } else {
          None
        }
      case InitAllSegments =>
          if (totalWords > options.traversalLimitInWords) {
            throw new DecodeException("Message size exceeds traversal limit.")
          }
          allSegments = makeByteBuffer(totalWords * Constants.BYTES_PER_WORD)
          state = FillAllSegments
          next()
      case FillAllSegments =>
        if (bufs.read(allSegments)) {
          val segmentSlices = Array.ofDim[ByteBuffer](segmentCount)
          allSegments.rewind()
          segmentSlices(0) = allSegments.slice()
          segmentSlices(0).limit(segment0Size * Constants.BYTES_PER_WORD)
          segmentSlices(0).order(ByteOrder.LITTLE_ENDIAN)
          var offset = segment0Size
          var i = 1
          while (i < segmentCount) {
            allSegments.position(offset * Constants.BYTES_PER_WORD)
            segmentSlices(i) = allSegments.slice()
            segmentSlices(i).limit(moreSizes(i - 1) * Constants.BYTES_PER_WORD)
            segmentSlices(i).order(ByteOrder.LITTLE_ENDIAN)
            offset += moreSizes(i - 1)
            i += 1
          }
          reset()
          Some(new MessageReader(segmentSlices, options))
        } else {
          None
        }
    }
  }

  private def reset(): Unit = {
    segmentCount = -1
    segment0Size = -1
    totalWords = -1
    firstWord.clear()
    moreSizes.clear()
    moreSizesRaw = null
    allSegments = null
    state = Init
  }

  private def makeByteBuffer(bytes: Int): ByteBuffer = {
    val result = ByteBuffer.allocate(bytes)
    result.order(ByteOrder.LITTLE_ENDIAN)
    result.mark()
    result
  }
}
