using Scala = import "../scala.capnp";

@0xdbb9ad1f14bf0b36;

$Scala.package("org.testschema");

struct Person {
  name @0 :Text;
  email @1 :Text;
  birthdate @3 :Date;
  phone @2 :List(PhoneNumber);
  bar @4 :List(Int16);

  struct PhoneNumber {
    number @0 :Text;
    type @1 :List(Type);

    enum Type {
      mobile @0;
      home @1;
      work @2;
    }
  }
}

struct Date {
  year @0 :Int16;
  month @1 :UInt8;
  day @2 :UInt8;
}