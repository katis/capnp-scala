package org.capnproto.javascript

import scala.scalajs.js.typedarray._
import org.capnproto.{MessageReader, Serialize}
import org.scalajs.dom.{Event, MessageEvent}
import org.scalajs.dom.raw.WebSocket

import scala.scalajs.js.JSApp

object Main extends JSApp {

  def main(): Unit = {
    val ws = new WebSocket("http://localhost:8083")
    ws.onopen = (ev: Event) => {
      println("Websocket opened")
    }

    ws.onmessage = (ev: MessageEvent) => {
      val data = ev.data.asInstanceOf[ArrayBuffer]

      val reader = messageReader(data)

    }
  }

  def messageReader(arr: ArrayBuffer): MessageReader = {
    Serialize.read(TypedArrayBuffer.wrap(arr))
  }

}
