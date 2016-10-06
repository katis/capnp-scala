package org.capnproto

object SerializePacked {

  def read(input: BufferedInputStream): MessageReader = {
    read(input, ReaderOptions.DEFAULT_READER_OPTIONS)
  }

  def read(input: BufferedInputStream, options: ReaderOptions): MessageReader = {
    val packedInput = new PackedInputStream(input)
    Serialize.read(packedInput, options)
  }

  def readFromUnbuffered(input: java.nio.channels.ReadableByteChannel): MessageReader = {
    readFromUnbuffered(input, ReaderOptions.DEFAULT_READER_OPTIONS)
  }

  def readFromUnbuffered(input: java.nio.channels.ReadableByteChannel, options: ReaderOptions): MessageReader = {
    val packedInput = new PackedInputStream(new BufferedInputStreamWrapper(input))
    Serialize.read(packedInput, options)
  }

  def write(output: BufferedOutputStream, message: MessageBuilder) {
    val packedOutputStream = new PackedOutputStream(output)
    Serialize.write(packedOutputStream, message)
  }

  def writeToUnbuffered(output: java.nio.channels.WritableByteChannel, message: MessageBuilder) {
    val buffered = new BufferedOutputStreamWrapper(output)
    write(buffered, message)
    buffered.flush()
  }
}
