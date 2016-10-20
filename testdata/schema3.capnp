using Scala = import "../scala.capnp";

@0xdbb9ad1f14bf0b36;

$Scala.package("org.testschema");

struct Person {
  name @0 :Text;
  email @1 :Text;
  birthdate @3 :Date;
  phone @2 :List(PhoneNumber);
  bar @4 :List(Int16);

  employment :union {
    unemployed @5 :Void;
    employer @6 :Text;
  }

  shape :union {
    circle :group {
      radius @7 :Float64;
    }
    rectangle :group {
      width @8 :Float64;
      height @9 :Float64;
      foo :union {
        bar :group {
          bar1 @12 :Text;
          bar2 @13 :Text;
        }
        baz @14 :Float64;
      }
    }
    path @10 :Text;
    point @11: Void;
  }

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