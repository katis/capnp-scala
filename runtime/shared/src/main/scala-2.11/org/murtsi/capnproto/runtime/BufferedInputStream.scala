package org.murtsi.capnproto.runtime

import java.nio.ByteBuffer
import java.nio.channels.ReadableByteChannel

trait BufferedInputStream extends ReadableByteChannel {

  def getReadBuffer(): ByteBuffer
}
