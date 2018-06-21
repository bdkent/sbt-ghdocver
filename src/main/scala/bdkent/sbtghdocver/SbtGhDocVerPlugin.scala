package bdkent.sbtghdocver

import sbt._
import Keys._
import scala.collection.Seq
import com.typesafe.sbt.site.SitePlugin
import com.typesafe.sbt.site.SiteScaladocPlugin

object SbtGhDocVerPlugin extends AutoPlugin {

  override def requires = SitePlugin

  object autoImport extends SbtGhDocVerKeys {

  }

  import autoImport._
  import SitePlugin.autoImport._
  import SiteScaladocPlugin.autoImport._

  lazy val baseGhDocVerSettings = Seq(
    ghdvReadmeName := { "README.md" },

    ghdvDocsDirName := { "docs" },

    ghdvCopyReadme := {
      val src = siteDirectory.value.toPath.resolve(ghdvReadmeName.value)
      val dest = baseDirectory.value.toPath.resolve(ghdvReadmeName.value)
      GhDocVer.copyReadme(src, dest)
    },

    ghdvCopyScaladocs := {
      val srcDir = siteDirectory.value.toPath.resolve((SiteScaladoc / siteSubdirName).value)
      val destDir = baseDirectory.value.toPath.resolve(ghdvDocsDirName.value).resolve((SiteScaladoc / siteSubdirName).value)
      GhDocVer.copyScaladocs(srcDir, destDir)
    }
  )

  override lazy val projectSettings = baseGhDocVerSettings
}
