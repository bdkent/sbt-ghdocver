package bdkent.sbtghdocver

import sbt._
import Keys._
import scala.collection.Seq

object SbtGhDocVerPlugin extends AutoPlugin {

  override lazy val projectSettings = Seq(commands += ghDocVerMakeCommand)

  override def requires = SitePlugin

  lazy val ghDocVerMakeCommand = {
    Command.command("hello") { (state: State) =>
      println("Hi!")
      state
    }
  }
}
