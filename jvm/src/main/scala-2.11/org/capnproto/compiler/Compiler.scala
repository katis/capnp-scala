package org.capnproto.compiler

import java.nio.channels.Channels

import org.capnproto.Serialize
import org.capnproto.compiler.CapnpSchema.CodeGeneratorRequest

object Compiler {
  def main(args: Array[String]): Unit = {
    val chan = Channels.newChannel(System.in)
    val messageReader = Serialize.read(chan)

    val request = messageReader.getRoot(CodeGeneratorRequest)


  }
}
