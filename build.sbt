lazy val root = project
  .in(file("."))
  .settings(
    name := "my_dotty-proj",
    description := "Example sbt project that compiles using Dotty",
    version := "0.1.0",

    scalaVersion := "0.20.0-RC1"
  )
