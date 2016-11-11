name := "capnproto"

scalaVersion in ThisBuild := "2.11.8"

lazy val root = project.in(file(".")).
  aggregate(runtimeJS, runtimeJVM, capnpcScala, compilerTestJS, compilerTestJVM).
  settings(
    publish := {},
    publishLocal := {}
  )

lazy val runtime = crossProject.in(file("./runtime")).
  settings(
    name := "capnproto",
    version := "0.1-SNAPSHOT",
    libraryDependencies += "org.scalactic" %%% "scalactic" % "3.0.0",
    libraryDependencies += "org.scalatest" %%% "scalatest" % "3.0.0" % "test"
  ).
  jvmSettings().
  jsSettings()

lazy val runtimeJVM = runtime.jvm
lazy val runtimeJS = runtime.js

lazy val capnpcScala = project.in(file("./compiler")).dependsOn(runtimeJVM)
mainClass in capnpcScala := Some("org.murtsi.capnproto.compiler.Compiler")

lazy val sample = project.in(file("./example"))
    .aggregate(exampleJS, exampleJVM)

lazy val compilerTest = crossProject.in(file("./compilerTest"))
    .settings(
      libraryDependencies += "org.scalactic" %%% "scalactic" % "3.0.0",
      libraryDependencies += "org.scalatest" %%% "scalatest" % "3.0.0" % "test"
    )

lazy val compilerTestJS = compilerTest.js.dependsOn(runtimeJS)
lazy val compilerTestJVM = compilerTest.jvm.dependsOn(runtimeJVM)

lazy val example = crossProject.in(file("./example"))
  .settings(
    name := "Cap'n Proto example",
    version := "0.1-SNAPSHOT",
    libraryDependencies += "org.scala-lang.modules" %% "scala-async" % "0.9.6"
  ).jvmSettings(
    libraryDependencies += "com.typesafe.akka" %% "akka-http-experimental" % "2.4.11"
  )
  .jsSettings(
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.0",
    libraryDependencies += "io.monix" %%% "monix" % "2.0.3"
  )

lazy val exampleJS = example.js.dependsOn(runtimeJS)
lazy val exampleJVM = example.jvm.dependsOn(runtimeJVM)

lazy val testschemas = taskKey[Unit]("Compiles test cap'n proto files")

testschemas := {
  val v = (assembly in capnpcScala).value

  val d = new File("compilerTest/shared/src/test/scala-2.11/org/murtsi/capnproto/compiler")
  if (d.exists() && d.isDirectory) {
    val files = d.listFiles().filter(_.isFile).map(_.getAbsolutePath).filter(_.endsWith(".capnp"))
    val args = Seq("java", "-jar", v.getAbsolutePath) ++ files
    val compiler = new java.lang.ProcessBuilder(args:_*)
    compiler.redirectOutput(ProcessBuilder.Redirect.INHERIT)
    compiler.redirectError(ProcessBuilder.Redirect.INHERIT)
    val p = compiler.start()
    p.waitFor()
  }
}
