package org.murtsi.capnproto.compiler

import java.nio.channels.{Channels, ReadableByteChannel}

import org.murtsi.capnproto.runtime.Serialize

import scala.language.postfixOps
import sys.process._

object Compiler {
  def main(args: Array[String]): Unit = {
    val outDir = System.getenv().getOrDefault("OUT_DIR", "")

    if (args.length > 0) {
      val capnpc = Runtime.getRuntime.exec(s"capnp compile -o - ${args.mkString(" ")}")
      val input = capnpc.getInputStream
      run(Channels.newChannel(input), outDir)
      input.close()
    } else {
      val input = Channels.newChannel(stdin)
      run(input, outDir)
    }
  }

  def run(chan: ReadableByteChannel, outputDirectory: String): Unit = {
      val messageReader = Serialize.read(chan)

      val generator = new Generator(messageReader)

      for (requestedFile <- generator.request.requestedFiles.get) {
        val id = requestedFile.id
        val lines = generator.generateNode(id, "rootName")
        println(s"package ${generator.packageName}")
        println("")
        println(lines.stringify())
      }
  }
}
