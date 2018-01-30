import sbt.Keys.libraryDependencies

lazy val geometry = project
lazy val fraction = project
lazy val scaling = project.dependsOn(geometry, fraction)
lazy val manager = project.dependsOn(geometry, fraction, scaling)


lazy val fractionalGeo = (project in file(".")).
  aggregate(geometry, fraction, manager, scaling).
  settings(
  Seq(
    name := "fractional-geo",
    version := "0.1",
    scalaVersion := "2.12.4",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.4" % Test
  )).dependsOn(geometry, fraction)