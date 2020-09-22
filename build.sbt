name := "scalaDojo"

version := "0.1"

scalaVersion := "2.13.3"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8"
libraryDependencies += "io.monix" %% "monix" % "3.2.2"
libraryDependencies += "org.typelevel" %% "cats-effect" % "2.1.4"

libraryDependencies += "com.disneystreaming" %% "weaver-framework" % "0.5.0-RC1" % Test
testFrameworks += new TestFramework("weaver.framework.TestFramework")