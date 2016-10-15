using Scala = import "../scala.capnp";

@0xdbb9ad1f14bf0b36;

$Scala.package("org.testschema");

struct User {
  firstName @0 :Text;
  lastName @1 :Text;
  age @2 :UInt8;
}