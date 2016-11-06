using Scala = import "../scala.capnp";

@0xeaa6d6619ae9fdd8;

$Scala.package("org.murtsi.capnproto.compiler2");
$Scala.module("generics");

struct Context(Ctx) {
    struct GenericMap(Key, Value) {
      entries @0 :List(Entry);
      struct Entry {
        key @0 :Key;
        value @1 :Value;
      }
    }
}
