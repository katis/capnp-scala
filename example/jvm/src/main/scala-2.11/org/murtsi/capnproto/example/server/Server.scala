package org.murtsi.capnproto.example.server

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.ws.{BinaryMessage, Message}
import akka.http.scaladsl.server.Directives._
import akka.stream.scaladsl.{Flow, Sink, Source}
import akka.stream.{ActorMaterializer, OverflowStrategy}
import akka.util.ByteString
import org.murtsi.capnproto.example.todo._
import org.murtsi.capnproto.example.todo.ServerMessage.{Add, Modify, Remove}
import org.murtsi.capnproto.example.server.CapnProtoExts._
import org.murtsi.capnproto.example.todo.{ClientMessage, ServerMessage}
import org.murtsi.capnproto.runtime.implicits._
import org.murtsi.capnproto.runtime.{MessageBuilder, Serialize}

import scala.collection.mutable
import scala.io.StdIn

sealed trait WsMessage
case class NewSession(actor: ActorRef) extends WsMessage
case class Disconnected(actor: ActorRef) extends WsMessage

object CapnProtoExts {
  implicit class IterableExt[A](val iterable: Traversable[A]) extends AnyVal {
    def zipSameSize[B](makeSizedIterable: (Int) => Traversable[B]): Traversable[(A, B)] = {
      val bs = makeSizedIterable(iterable.size)
      iterable.toVector.zip(bs.toVector)
    }
  }
}

class TodoService(system: ActorSystem) {
  private val todoActor = system.actorOf(Props(new TodoActor), "TodoService")

  def todoFlow(): Flow[ByteString, ByteString, Any] = {
    val sink = Sink.actorRef[ServerMessage#Reader](todoActor, NewSession(todoActor))

    val in = Flow[ByteString]
        .map(_.asByteBuffer)
        .map(Serialize.read)
        .map(_.getRoot[ServerMessage])
        .to(sink)

    val out = Source.actorRef[ByteString](1, OverflowStrategy.fail)
        .mapMaterializedValue(todoActor ! NewSession(_))

    Flow.fromSinkAndSource(in, out)
  }

  case class TodoData(contents: String, created: String)

  private class TodoActor extends Actor {
    private val subscribers = mutable.HashMap[Long, ActorRef]()

    def now = DateTimeFormatter.ofPattern("uuuu-MM-dd HH.mm.ss").format(LocalDateTime.now())

    private val nextId = {
      var i = 0L
      () => { i += 1; i }
    }

    private val nextClientId = {
      var i = 0L
      () => { i += 1; i }
    }

    private val todos = mutable.HashMap[Long, TodoData](
      (nextId(), TodoData("Hello, world", now)),
      (nextId(), TodoData("Mitäs kuuluu?", now))
    )

    override def receive = {
      case msg: WsMessage =>
        msg match {
          case NewSession(actor) =>
            println("New session")
            val clientId = nextClientId()
            subscribers(clientId) = actor
            sendClientMessage(c => {
              val initial = c.init.initial()
              initial.clientId = clientId
              for (((id, data), todo) <- todos.zipSameSize(initial.init.todos _)) {
                todo.id = id
                todo.contents = data.contents
                todo.created = data.created
              }
            }, Seq(actor))
          case Disconnected(actor) =>
            subscribers.find(_._2 == actor) match {
              case Some((key, _)) => subscribers.remove(key)
              case None => println("Could not find subscriber to remove")
            }
        }
      case msg: ServerMessage.Reader =>
        msg match {
          case Add(todo) =>
            val ts = now
            val id = nextId()
            val data = TodoData(todo.contents.toString, ts)
            todos(id) = data
            sendClientMessage(c => {
              val added = c.init.added()
              added.id = id
              added.contents = data.contents
              added.created = ts
            }, subscribers.values)
          case Remove(removal) =>
            todos.remove(removal.id) match {
              case Some(removed) =>
                sendClientMessage(_.init.removed().id = removal.id, subscribers.values)
              case None =>
                sendClientMessage(_.init.removalFailed().id = removal.id, subscribers.get(msg.clientId))
            }
          case Modify(modified) => todos.get(modified.id) match {
            case Some(existing) =>
              todos(modified.id) = existing.copy(
                contents = modified.contents.toString
              )
              sendClientMessage(_.init.modified().id = modified.id, subscribers.values)
            case None =>
              sendClientMessage(_.init.modifyFailed().id = modified.id, subscribers.get(msg.clientId))
          }
        }
    }

    def sendClientMessage(init: (ClientMessage#Builder) => Unit, targets: Iterable[ActorRef] = Seq(sender)): Unit = {
      val messageBuilder = new MessageBuilder()
      val msg: ClientMessage#Builder = messageBuilder.getRoot[ClientMessage]
      init(msg)

      val response = ByteString(Serialize.writeToByteBuffer(messageBuilder))

      targets.foreach(_.tell(response, self))
    }
  }
}

object Server {
  def main(args: Array[String]): Unit = {
    implicit val system = ActorSystem("capnp-example")
    implicit val materializer = ActorMaterializer()
    implicit val executionContext = system.dispatcher

    val service = new TodoService(system)

    val wsMessage = Flow[Message]
        .collect { case BinaryMessage.Strict(binary) => binary }
        .via(service.todoFlow())
        .map(BinaryMessage.Strict)

    val route = get {
      pathSingleSlash {
        getFromFile("index.html")
      } ~ path("ws") {
        handleWebSocketMessages(wsMessage)
      } ~
        path("index.html")(getFromFile("index.html")) ~
        getFromDirectory(".")
    }

    val port = 8087
    val bindingFuture = Http().bindAndHandle(route, "localhost", port)
    println(s"Server online at http://localhost:$port")
    println("Press RETURN to stop")

    StdIn.readLine()
    bindingFuture
        .flatMap(_.unbind())
        .onComplete(_ => system.terminate())
  }
}
