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

lazy val sample = project.in(file("./example"))
    .aggregate(exampleJS, exampleJVM)

lazy val example = crossProject.in(file("./example"))
  .settings(
    name := "Cap'n Proto example",
    version := "0.1-SNAPSHOT"
  ).jvmSettings(
    libraryDependencies += "com.typesafe.akka" %% "akka-http-experimental" % "2.4.11"
  )
  .jsSettings(
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.0",
    libraryDependencies += "io.monix" %%% "monix" % "2.0.3"
  )

lazy val exampleJS = example.js.dependsOn(runtimeJS)
lazy val exampleJVM = example.jvm.dependsOn(runtimeJVM)
