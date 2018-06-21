package bdkent.sbtghdocver

import sbt._

trait SbtGhDocVerKeys {

  val ghdvReadmeName = settingKey[String]("name of readme file (default README.md)")

  val ghdvDocsDirName = settingKey[String]("name of docs destination directory (default /docs)")

  val ghdvCopyReadme = taskKey[Unit]("copies preprocessed readme")

  val ghdvCopyScaladocs = taskKey[Unit]("copies scaladocs")
}
