using Scala = import "../../../../../../../../../../scala.capnp";

using import "util/uuid.capnp".UUID;

@0xb9bea4c26be48feb;

$Scala.package("org.katis.capnproto.compiler.multifile");
$Scala.module("customer");

struct Customer {
  id @0 :UUID;
  name @1 :Text;
}

