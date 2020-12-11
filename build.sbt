name := "scalaDojo"

version := "0.1"

scalaVersion := "2.13.3"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8"
libraryDependencies += "org.typelevel" %% "cats-effect" % "2.2.0"
libraryDependencies += "org.typelevel" %% "cats-core" % "2.1.1"

libraryDependencies += "com.disneystreaming" %% "weaver-framework" % "0.5.0" % Test
testFrameworks += new TestFramework("weaver.framework.TestFramework")