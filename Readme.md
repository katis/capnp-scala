# Cap'n Proto serialization for Scala & Scala.js

See [Cap'n Proto homepage](https://capnproto.org/index.html) for more details about the data format.

## Compiler

The compiler requires the [capnp tool](https://capnproto.org/install.html) in your PATH.

It can be run with:

    java -jar capnp-scala.jar file1.capnp file2.capnp

You need to add the package and module annotations from scala.capnp to your schema.
