package org.capnproto

import java.nio.ByteBuffer
import java.nio.channels.WritableByteChannel

trait BufferedOutputStream extends WritableByteChannel {

  def writeBuffer: ByteBuffer

  def flush(): Unit
}
