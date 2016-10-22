package org.murtsi.capnproto.example.client

import monix.execution.Cancelable
import monix.execution.Scheduler.Implicits.global
import monix.reactive.Observable
import monix.reactive.observers.Subscriber
import org.murtsi.capnproto.example.ClientMessage._
import org.murtsi.capnproto.example.{ClientMessage, ServerMessage, Todo}
import org.murtsi.capnproto.runtime.{MessageBuilder, Serialize}
import org.scalajs.dom._
import org.scalajs.dom.raw.{HTMLButtonElement, HTMLInputElement, WebSocket}

import scala.collection.mutable
import scala.scalajs.js.JSApp
import scala.scalajs.js.typedarray.TypedArrayBufferOps._
import scala.scalajs.js.typedarray.{ArrayBuffer, TypedArrayBuffer}

object Client extends JSApp {
  implicit class ElementExt(val el: Element) extends AnyVal {
    def removeChildren(): Unit = {
      while (el.lastChild != null) {
        el.removeChild(el.lastChild)
      }
    }
  }

  override def main(): Unit = {
    val todoService = new TodoService(s"ws://${window.location.host}/ws")

    var todoText = ""
    val input = document.getElementById("todoText").asInstanceOf[HTMLInputElement]
    input.oninput = (ev: Event) => {
      todoText = input.value
      println(todoText)
    }

    val btn = document.getElementById("send").asInstanceOf[HTMLButtonElement]
    btn.textContent = "Add"
    btn.onclick = (ev: MouseEvent) => {
      todoService.send(msg => {
        msg.initAdd().contents = todoText
      })
    }

    var clientId = 0L
    var todos = mutable.ArrayBuffer[Todo.Reader]()

    def redrawTodos(): Unit = {
      val todoContainer = document.getElementById("todos")
      todoContainer.removeChildren()

      for (todo <- todos) {
        val contents = todo.contents.map(_.toString).getOrElse("")
        val li = document.createElement("li")
        li.appendChild(document.createTextNode(contents))
        todoContainer.appendChild(li)
      }
    }

    todoService.messages.foreach {
      case Initial(init) =>
        println("Initial message")
        clientId = init.clientId
        todos.clear()
        init.todos.get.foreach(todo => {
          todos += todo
        })
        redrawTodos()
      case Added(todo) =>
        println(s"Added message ${todo.contents}")
        todos += todo
        redrawTodos()
      case Removed(todo) =>
        println("Removed message")
        todos.indexWhere(t => t.id == todo.id) match {
          case -1 =>
          case n => todos.remove(n)
        }
        redrawTodos()
      case Modified(todo) =>
        println("Modified message")
        todos.lastIndexWhere(_.id == todo.id) match {
          case -1 =>
          case n => todos(n) = todo
        }
        redrawTodos()
      case AddFailed(todo) =>
        println(s"Failed to add todo")
      case RemovalFailed(todo) =>
        println(s"Failed to remove todo ${todo.id}")
      case ModifyFailed(todo) =>
        println(s"Failed to modify todo ${todo.id}")
    }
  }
}

class TodoService(address: String) {
  private val subscribers = mutable.ArrayBuffer[Subscriber[ClientMessage.Reader]]()

  val messages = Observable.unsafeCreate[ClientMessage.Reader](subscriber => {
    subscribers += subscriber

    new Cancelable {
      override def cancel(): Unit = {
        subscribers.indexOf(subscriber) match {
          case -1 =>
          case i => subscribers.remove(i)
        }
      }
    }
  })

  private val ws = new WebSocket(address)
  ws.binaryType = "arraybuffer"

  ws.onopen = (ev: Event) => {
    println("WS opened")
  }

  ws.onerror = (ev: ErrorEvent) => {
    println(s"WS error: ${ev.message}")
  }

  ws.onclose = (ev: CloseEvent) => {
    println("WS closed")
  }

  ws.onmessage = (ev: MessageEvent) => {
    println(s"Got a message")
    window.console.log("", ev)
    val data = ev.data.asInstanceOf[ArrayBuffer]
    println(s"  size: ${data.byteLength}")
    val bb = TypedArrayBuffer.wrap(data)
    val reader = Serialize.read(bb)
    val msg = reader.getRoot(ClientMessage)
    subscribers.foreach(_.onNext(msg))
  }

  def send(messageInit: (ServerMessage.Builder) => Unit): Unit = {
    val builder = new MessageBuilder()
    val msg = builder.getRoot(ServerMessage)
    messageInit(msg)
    val response = Serialize.writeToByteBuffer(builder)
    ws.send(response.arrayBuffer())
  }
}