name := "scalaDojo"

version := "0.1"

scalaVersion := "3.7.2"

scalacOptions ++= Seq(
  "-deprecation",
  "-feature",
  "-unchecked",
  "-Wunused:all"
)

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.19"
libraryDependencies += "org.typelevel" %% "cats-effect" % "3.7.0-RC1"
libraryDependencies += "org.typelevel" %% "cats-core" % "2.13.0"

libraryDependencies +=  "com.disneystreaming" %% "weaver-cats" % "0.8.4" % Test
testFrameworks += new TestFramework("weaver.framework.CatsEffect")

addCommandAlias(name = "validate", value = "clean; test:test")
