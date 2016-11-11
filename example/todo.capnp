using Scala = import "../scala.capnp";

@0xbba67e30383fe749;
$Scala.package("org.katis.capnproto.example");
$Scala.module("todo");

struct ClientMessage {
  union {
    initial :group {
      clientId @0 :UInt64;
      todos @1 :List(Todo);
    }
    added @2 :Todo;
    removed @3 :Todo;
    modified @4 :Todo;

    addFailed @5 :Todo;
    removalFailed @6 :Todo;
    modifyFailed @7 :Todo;
  }
}

struct ServerMessage {
  clientId @0 :UInt64;
  union {
    add @1 :Todo;
    remove @2 :Todo;
    modify @3 :Todo;
  }
}

struct Todo {
  id @0 :UInt64;
  contents @1 :Text;
  created @2 :Text;
}
