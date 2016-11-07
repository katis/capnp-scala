using Scala = import "../../../../../../../../../scala.capnp";

@0xb14f277ff320a8c5;

$Scala.package("org.murtsi.capnproto.compiler");
$Scala.module("SimpleGeneric");

struct GenericMap(Key, Value) {
  entries @0 :List(Entry);
  struct Entry {
    key @0 :Key;
    value @1 :Value;
  }
}

struct Message {
  contents @0 :GenericMap(Text, Text);
}