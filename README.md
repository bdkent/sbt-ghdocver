# sbt-ghdocver
[sbt](https://scala-sbt.org) plugin to copy a readme and scaladocs (using [`sbt-site`](https://github.com/sbt/sbt-site))

## Overview

`sbt-ghdocver` adds two very simple tasks to supplement `sbt-site`:

<dl>
  <dt>ghdvCopyReadme</dt>
  <dd>copies a generated readme to the repo's root</dd>

  <dt>ghdvCopyScaladocs</dt>
  <dd>copies generated scaladocs to the <code>/docs</code> folder</dd>
</dl>

## Installation

![Maven Central](https://img.shields.io/maven-central/v/com.github.bdkent/sbt-ghdocver.svg?style=for-the-badge)

NOTE: requires sbt 1.x

add to `project/plugins.sbt`:

```scala
addSbtPlugin("com.github.bdkent" % "sbt-ghdocver" % "0.1.1")
```
because this project extends `sbt-site`, you should already have:

```scala
addSbtPlugin("com.typesafe.sbt" % "sbt-site" % "1.3.2")
```
enable in `build.sbt`:
```scala
enablePlugins(SbtGhDocVerPlugin)
```
## Usage

### `ghdvCopyReadme`

`sbt-site` supports [preprocessing](https://www.scala-sbt.org/sbt-site/preprocess.html) for variable substitution. This is useful for getting the `version` into the README file. `ghdvCopyReadme` copies the generated README file back into the root of the repo.

Assuming you have the `PreprocessPlugin` enabled, `enablePlugins(PreprocessPlugin)`, and have your README template where `PreprocessPlugin` expects (by default `/src/site-preprocess`) then the `ghdvCopyReadme` task will copy the generated README from `/target/preprocess/README.md` to `/README.md`.

If you have a non-markdown README, you can set the `ghdvReadmeName` setting. For example, `ghdvReadmeName := "README.rst"` for a reStructuredText README.

`sbt-ghdocver` should respect any changes to default paths in `sbt-site`.

### `ghdvCopyScaladocs`

`sbt-site` makes it easy to generate scaladocs. Then `sbt-ghpages` makes it easy to publish to the `gh-pages` branch. You are on your own, however, if you want to keep publish the scaladocs in the `/docs` folder in the same branch (useful for making previous scaladoc versions accessable).

`ghdvCopyScaladocs` does this simple copy.

Assuming you have the `SiteScaladocPlugin` plugin enabled, `enablePlugins(SiteScaladocPlugin)`, and are generating docs by version (such as `siteSubdirName in SiteScaladoc := "scaladocs/api/" + version.value`), then the `ghdvCopyScaladocs` task will copy the current `version`'s generated scaladocs folder from `/target/site/scaladocs/api/@VERSION@` to `/docs/scaladocs/api/@VERSION@`.

You can customize the destination folder by setting `ghdvDocsDirName`.

## Miscellaneous

If all you are using `sbt-site` for is to generate the README and scaladocs, it is useful to make a little custom command in your `build.sbt`:

```scala
commands += Command.command("makeDocs") {
  "makeSite" :: "ghdvCopyReadme" :: "ghdvCopyScaladocs" ::  _
}
```

and then throw that new command as a step in your [`sbt-release`](https://github.com/sbt/sbt-release) process (`releaseStepCommand("makeDocs")`).

