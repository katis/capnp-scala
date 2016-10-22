name := "capnproto"

scalaVersion in ThisBuild := "2.11.8"

lazy val root = project.in(file(".")).
  aggregate(runtimeJS, runtimeJVM).
  settings(
    publish := {},
    publishLocal := {}
  )

lazy val runtime = crossProject.in(file("./runtime")).
  settings(
    name := "capnproto",
    version := "0.1-SNAPSHOT"
  ).
  jvmSettings().
  jsSettings()

lazy val runtimeJVM = runtime.jvm
lazy val runtimeJS = runtime.js

lazy val capnpcScala = project.in(file("./compiler")).dependsOn(runtimeJVM)
mainClass in capnpcScala := Some("org.murtsi.capnproto.compiler.Compiler")
