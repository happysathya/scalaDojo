name := "scalaDojo"

version := "0.1"

scalaVersion := "2.13.4"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8"
libraryDependencies += "org.typelevel" %% "cats-effect" % "2.3.1"
libraryDependencies += "org.typelevel" %% "cats-core" % "2.3.1"

libraryDependencies += "com.disneystreaming" %% "weaver-framework" % "0.5.1" % Test
testFrameworks += new TestFramework("weaver.framework.TestFramework")