using Scala = import "../../../../../../../../../scala.capnp";

@0xd965c23221c9c77c;

$Scala.package("org.katis.capnproto.compiler");
$Scala.module("contents");

struct Contents {
  entries @0 :List(List(Text));
}
