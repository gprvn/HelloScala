ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.2.2"

lazy val root = (project in file("."))
  .settings(
    name := "HelloScala",
    libraryDependencies += "net.sf.ucanaccess" % "ucanaccess" % "5.0.1"
  )
