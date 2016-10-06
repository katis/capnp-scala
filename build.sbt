name := "capnproto"

scalaVersion in ThisBuild := "2.11.8"

lazy val root = project.in(file(".")).
  aggregate(capnProtoJS, capnProtoJVM).
  settings(
    publish := {},
    publishLocal := {}
  )

lazy val capnProto = crossProject.in(file(".")).
  settings(
    name := "capnproto",
    version := "0.1-SNAPSHOT"
  ).
  jvmSettings(
    // Add JVM-specific settings here
    libraryDependencies += "com.eed3si9n" %% "treehugger" % "0.4.1"
  ).
  jsSettings(
    // Add JS-specific settings here
  )

lazy val capnProtoJVM = capnProto.jvm
mainClass in capnProtoJVM := Some("org.capnproto.compiler.package")
lazy val capnProtoJS = capnProto.js