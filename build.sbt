name := "scalaDojo"

version := "0.1"

scalaVersion := "2.13.8"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.11"
libraryDependencies += "org.typelevel" %% "cats-effect" % "2.3.1"
libraryDependencies += "org.typelevel" %% "cats-core" % "2.3.1"

libraryDependencies +=  "com.disneystreaming" %% "weaver-cats" % "0.6.11" % Test
testFrameworks += new TestFramework("weaver.framework.CatsEffect")
