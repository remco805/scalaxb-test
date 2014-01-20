import ScalaxbKeys._

name := "scalaxb-test"

version := "1.0"

scalaVersion := "2.10.3"

libraryDependencies ++= Seq(
  "org.scalacheck" %% "scalacheck" % "1.11.1" % "test",
  "org.specs2" %% "specs2" % "2.3.6" % "test",
  "net.databinder.dispatch" %% "dispatch-core" % "0.10.1"
)

scalaxbSettings

packageName in scalaxb in Compile := "mypackage"

sourceGenerators in Compile <+= scalaxb in Compile
