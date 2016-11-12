package org.katis.capnproto.compiler

import java.lang.ProcessBuilder
import java.nio.channels.{Channels, ReadableByteChannel}
import java.nio.file.{Files, Path, Paths}

import org.katis.capnproto.compiler.schema._
import org.katis.capnproto.runtime.implicits._
import org.katis.capnproto.runtime.Serialize

import scala.collection.JavaConverters._
import scala.language.postfixOps
import scala.sys.process._

object Compiler {

  def main(args: Array[String]): Unit = {
    val outDir = Paths.get(System.getenv().getOrDefault("OUT_DIR", "."))

    if (args.length > 0) {
      val capnpc = compiler(args:_*)
      val proc = capnpc.start()
      val input = Channels.newChannel(proc.getInputStream)
      run(input, outDir)
      input.close()
    } else {
      println("Running as a plugin, waiting for input.")
      val input = Channels.newChannel(stdin)
      run(input, outDir)
    }
  }

  def compiler(files: String*): ProcessBuilder = {
    val params = Seq("capnp", "compile", "-o", "-") ++ files
    val capnpc = new ProcessBuilder(params:_*)
    capnpc.redirectError(ProcessBuilder.Redirect.INHERIT)
    capnpc
  }

  def fileGenerator(file: String): Generator = {
    val capnpc = compiler(file)
    val proc = capnpc.start()
    val input = Channels.newChannel(proc.getInputStream)

    val messageReader = Serialize.read(input)
    val request = messageReader.getRoot[CodeGeneratorRequest]
    new Generator(request)
  }

  def run(chan: ReadableByteChannel, outputDirectory: Path): Unit = {
      val messageReader = Serialize.read(chan)

      val request = messageReader.getRoot[CodeGeneratorRequest]
      val generator = new Generator(request)

      for (requestedFile <- request.requestedFiles) {
        val filePath = outputDirectory.resolve(requestedFile.filename.toString + ".scala")
        val output = generator.generateOutput(requestedFile.id)

        Files.write(filePath, output.asJava)
      }
  }
}
