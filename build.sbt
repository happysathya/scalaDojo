name := "scalaDojo"

version := "0.1"

scalaVersion := "3.3.1"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15"
libraryDependencies += "org.typelevel" %% "cats-effect" % "3.5.0"
libraryDependencies += "org.typelevel" %% "cats-core" % "2.9.0"

libraryDependencies +=  "com.disneystreaming" %% "weaver-cats" % "0.8.3" % Test
testFrameworks += new TestFramework("weaver.framework.CatsEffect")

addCommandAlias(name = "validate", value = "clean; test:test")
