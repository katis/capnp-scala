package org.murtsi.capnproto.compiler

import org.murtsi.capnproto.runtime.implicits._
import org.murtsi.capnproto.runtime.{MessageBuilder, Text}
import org.scalatest._

import SimpleGeneric._

class SimpleGenericSpec extends FlatSpec with Matchers {
  "A Message" should "have initializable generic contents" in {
    val builder = new MessageBuilder()
    val message = builder.getRoot[Message]

    val contents = message.initContents()

    var i = 1
    for (entry <- contents.initEntries(2)) {
      entry.key = Text.Reader(s"key $i")
      entry.value = Text.Reader(s"value $i")
      i += 1
    }

    val reader = message.asReader
    val entries = reader.contents.get.entries.get

    assert(entries(0).key.get.toString == "key 1")
    assert(entries(0).value.get.toString == "value 1")

    assert(entries(1).key.get.toString == "key 2")
    assert(entries(1).value.get.toString == "value 2")
  }
}
