package org.murtsi.capnproto.runtime

import java.nio._

import org.scalatest.{FlatSpec, Matchers}

class ByteBufferListSpec extends FlatSpec with Matchers {
  "A ByteBufferList" should "handle sources larger than sink" in {
    val sink1 = ByteBuffer.allocate(2)
    val sink2 = ByteBuffer.allocate(2)
    val sink3 = ByteBuffer.allocate(3)
    val sink4 = ByteBuffer.allocate(2)

    val bufList = bufferList(
      byteBuffer(1, 2, 3, 4, 5, 6),
      byteBuffer(7, 8, 9, 10)
    )

    assert(bufList.read(sink1))
    assertRelativeBytes(sink1, 1, 2)

    assert(bufList.read(sink2))
    assertRelativeBytes(sink2, 3, 4)

    assert(bufList.read(sink3))
    assertRelativeBytes(sink3, 5, 6, 7)

    assert(bufList.read(sink4))
    assertRelativeBytes(sink4, 8, 9)

    assert(bufList.buffers.size == 1)
    assert(bufList.buffers(0).remaining() == 1)
  }

  it should "handle sources smaller than sink" in {
    val sink = ByteBuffer.allocate(3)
    val source = byteBuffer(1, 2)

    val bufList = bufferList(source)

    assert(!bufList.read(sink))
    assertBytes(sink, 1, 2, 0)
  }

  it should "handle same size buffers" in {
    val sink = ByteBuffer.allocate(2)
    val source = byteBuffer(1, 2)

    val bufList = bufferList(source)

    assert(bufList.read(sink))
    assertRelativeBytes(sink, 1, 2)
  }

  it should "read from multiple buffers when needed" in {
    val sink = ByteBuffer.allocate(3)
    val source1 = byteBuffer(1, 2)
    val source2 = byteBuffer(3, 4)

    val bufList = bufferList(source1, source2)

    assert(bufList.read(sink))
    assertRelativeBytes(sink, 1, 2, 3)

    assert(bufList.buffers.size == 1)
    assert(bufList.buffers(0).remaining() == 1)
  }

  it should "support reading multiple different parts" in {
    val sink1 = ByteBuffer.allocate(4)
    val sink2 = ByteBuffer.allocate(2)
    val sink3 = ByteBuffer.allocate(3)

    val bufList = bufferList(
      byteBuffer(1, 2, 3),
      byteBuffer(4, 5, 6),
      byteBuffer(7, 8, 9)
    )

    assert(bufList.read(sink1))
    assertRelativeBytes(sink1, 1, 2, 3, 4)
    assert(bufList.buffers.size == 2)

    assert(bufList.read(sink2))
    assertBytes(sink2, 5, 6)
    assert(bufList.buffers.size == 1)

    assert(bufList.read(sink3))
    assertBytes(sink3, 7, 8, 9)
    assert(bufList.buffers.isEmpty)
  }

  def byteBuffer(values: Int*): ByteBuffer = {
    val bb = ByteBuffer.allocate(values.size)
    for (v <- values) {
      bb.put(v.toByte)
    }
    bb.flip()
    bb
  }

  def bufferList(buffers: ByteBuffer*): ByteBufferList = {
    val bl = new ByteBufferList
    for (buf <- buffers) {
      bl.add(buf)
    }
    bl
  }

  def assertRelativeBytes(bb: ByteBuffer, values: Int*): Unit = {
    for (v <- values) {
      assert(bb.get() == v.toByte)
    }
  }

  def assertBytes(bb: ByteBuffer, values: Int*): Unit = {
     for ((v, i) <- values.zipWithIndex) {
      assert(bb.get(i) == v.toByte)
    }
  }
}
