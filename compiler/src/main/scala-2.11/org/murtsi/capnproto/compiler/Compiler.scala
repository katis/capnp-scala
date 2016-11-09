package org.murtsi.capnproto.compiler

import java.lang.ProcessBuilder
import java.nio.channels.{Channels, ReadableByteChannel}
import java.nio.file.{Files, Path, Paths}

import org.murtsi.capnproto.runtime.Serialize

import scala.collection.JavaConverters._
import scala.language.postfixOps
import scala.sys.process._

object Compiler {

  def main(args: Array[String]): Unit = {
    val outDir = Paths.get(System.getenv().getOrDefault("OUT_DIR", "."))

    if (args.length > 0) {
      val params = Seq("capnp", "compile", "-o", "-") ++ args
      val capnpc = new ProcessBuilder(params:_*)
      capnpc.redirectError(ProcessBuilder.Redirect.INHERIT)
      val proc = capnpc.start()
      val input = Channels.newChannel(proc.getInputStream)
      run(input, outDir)
      input.close()
    } else {
      val input = Channels.newChannel(stdin)
      run(input, outDir)
    }
  }

  def run(chan: ReadableByteChannel, outputDirectory: Path): Unit = {
      val messageReader = Serialize.read(chan)

      val generator = new Generator(messageReader)

      for (requestedFile <- generator.request.requestedFiles) {
        val filePath = outputDirectory.resolve(requestedFile.filename.toString + ".scala")
        val output = generator.generateOutput(requestedFile.id)

        Files.write(filePath, output.asJava)
      }
  }
}
