import sbt.Keys._

lazy val pomSettings = Seq(
  publishMavenStyle := true,
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases"  at nexus + "service/local/staging/deploy/maven2")
  },
  publishArtifact in Test := false,
  licenses := Seq("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt")),
  pomExtra :=
    <url>https://github.com/bdkent/sbt-ghdocver</url>
    <licenses>
      <license>
        <name>Apache-2.0</name>
        <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:bdkent/sbt-ghdocver.git</url>
      <connection>scm:git:git@github.com:bdkent/sbt-ghdocver.git</connection>
    </scm>
    <developers>
      <developer>
        <id>bdkent</id>
        <name>Brian Kent</name>
        <url>https://github.com/bdkent</url>
      </developer>
    </developers>
)

lazy val root = (project in file(".")).
  settings(
    name := "sbt-ghdocver",
    version := "0.1.0",
    organization := "com.github.bdkent",
    scalaVersion := "2.12.6",
    mainClass in (Compile, run) := Some("bdkent.sbtghdocver.Main"),
    sbtPlugin := true,
    sbtVersion := "1.1.6"
  ).
  settings(pomSettings)


