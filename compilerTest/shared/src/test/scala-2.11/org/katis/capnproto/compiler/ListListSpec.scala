package org.katis.capnproto.compiler

import org.scalatest.{FlatSpec, Matchers}
import contents._
import org.katis.capnproto.runtime.implicits._
import org.katis.capnproto.runtime.MessageBuilder

class ListListSpec extends FlatSpec with Matchers {
  "A ListList" should "allow reading and writing" in {
    val builder = new MessageBuilder()
    val msg = builder.getRoot[Contents]

    val entries = msg.init.entries(2)
    val texts0 = entries.init(0, 4)
    val texts1 = entries.init(1, 5)

    texts0(0) = "World"
    texts0(1) = "Hello"
    texts1(0) = "Bar"
    texts1(1) = "Foo"

    val reader = msg.asReader

    val rEntries = reader.entries
    val rEntries0 = rEntries(0)
    val rEntries1 = rEntries(1)
    assert(rEntries0(0).toString == "World")
    assert(rEntries0(1).toString == "Hello")
    assert(rEntries1(0).toString == "Bar")
    assert(rEntries1(1).toString == "Foo")
  }
}
