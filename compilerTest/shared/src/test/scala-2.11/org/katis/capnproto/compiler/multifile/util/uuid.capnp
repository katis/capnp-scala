using Scala = import "../../../../../../../../../../../scala.capnp";

@0xd7604d0b8d98ed8a;

$Scala.package("org.katis.capnproto.compiler.multifile.util");
$Scala.module("uuid");

struct UUID {
  lsb @0 :Int64;
  msb @1 :Int64;
}