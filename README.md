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
