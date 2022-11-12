name := "scalaDojo"

version := "0.1"

scalaVersion := "3.2.0"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.14"
libraryDependencies += "org.typelevel" %% "cats-effect" % "3.3.14"
libraryDependencies += "org.typelevel" %% "cats-core" % "2.8.0"

libraryDependencies +=  "com.disneystreaming" %% "weaver-cats" % "0.8.0" % Test
testFrameworks += new TestFramework("weaver.framework.CatsEffect")

addCommandAlias(name = "validate", value = "clean; test:test")
