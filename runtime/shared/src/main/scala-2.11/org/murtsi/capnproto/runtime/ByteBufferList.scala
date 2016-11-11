package org.murtsi.capnproto.runtime

import java.nio.ByteBuffer

import scala.annotation.tailrec
import scala.collection.mutable

class ByteBufferList() {
  private[runtime] val buffers = mutable.ArrayBuffer[ByteBuffer]()

  def add(bb: ByteBuffer): Unit = {
    buffers += bb
  }

  @tailrec
  final def read(sink: ByteBuffer): Boolean = {
    if (buffers.isEmpty) return false

    val bb = buffers(0)
    val bs = if (bb.remaining() > sink.remaining()) {
      val slice = bb.slice()
      slice.limit(sink.remaining())
      bb.position(bb.position() + sink.remaining())
      slice
    } else {
      bb
    }

    sink.put(bs)
    if (!bb.hasRemaining) {
      buffers.remove(0)
    }

    if (sink.hasRemaining) {
      read(sink)
    } else {
      sink.flip()
      true
    }
  }
}

