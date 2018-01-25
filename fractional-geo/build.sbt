lazy val geometry = project
lazy val fraction = project

lazy val fractionalGeo = (project in file(".")).settings(
  Seq(
    name := "fractional-geo",
    version := "0.1",
    scalaVersion := "2.12.4"
  )).dependsOn(geometry, fraction)