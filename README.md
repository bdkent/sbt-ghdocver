# sbt-ghdocver
[sbt](https://scala-sbt.org) plugin to copy a readme and scaladocs (using [`sbt-site`](https://github.com/sbt/sbt-site))

## Overview

`sbt-ghdocver` adds two very simple tasks to supplement `sbt-site`:

<dl>
  <dt>ghdvCopyReadme</dt>
  <dd>copies a generated readme to the repo's root</dd>

  <dt>ghdvCopyScaladocs</dt>
  <dd>copies generated scaladocs to the `/docs` folder</dd>
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
