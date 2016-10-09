using Scala = import "scala.capnp";

@0xdbb9ad1f14bf0b36;

$Scala.package("org.testschema");

struct Date {
  year @0 :Int16;
  month @1 :UInt8;
  day @2 :UInt8;
  week @3 :UInt8;
}