package org.katis.capnproto.compiler.multifile

import java.util.{UUID => JavaUUID}

import order._
import org.katis.capnproto.runtime.MessageBuilder
import org.katis.capnproto.runtime.implicits._
import org.scalatest.{FlatSpec, Matchers}
import util.uuid._

class MultifileSpec extends FlatSpec with Matchers {
  "A multi-file schema" should "work normally" in {
    val builder = new MessageBuilder()
    val order = builder.getRoot[Order]
    val orderId = JavaUUID.randomUUID()
    order.init.id().put(orderId)

    val customerId = JavaUUID.randomUUID()
    val customer = order.init.customer()
    customer.init.id().put(customerId)
    customer.name = "Vin Diesel"

    val items = Vector(
      ("Carrots", JavaUUID.randomUUID()),
      ("Milk", JavaUUID.randomUUID()),
      ("Dogfood", JavaUUID.randomUUID())
    )
    for ((item, (name, id)) <- order.init.items(items.size).zip(items)) {
      item.init.id().put(id)
      item.name = name
    }

    val reader = order.asReader

    reader.id.toJava == orderId
    assert(reader.customer.id.toJava == customerId)
    assert(reader.customer.name.toString == "Vin Diesel")

    for ((item, (name, id)) <- reader.items.zip(items)) {
      assert(item.id.toJava == id)
      assert(item.name.toString == name)
    }
  }

  implicit class UUIDBuilderExt(val uuid: UUID#Builder) {
    def put(id: JavaUUID) = {
      uuid.lsb = id.getLeastSignificantBits
      uuid.msb = id.getMostSignificantBits
    }
  }

  implicit class UUIDExt(val uuid: UUID#Reader) {
    def toJava: JavaUUID = new JavaUUID(uuid.msb, uuid.lsb)
  }
}
