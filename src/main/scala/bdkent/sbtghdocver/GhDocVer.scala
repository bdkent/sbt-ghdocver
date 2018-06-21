package bdkent.sbtghdocver

import java.nio.file.FileVisitResult
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.SimpleFileVisitor
import java.nio.file.StandardCopyOption
import java.nio.file.attribute.BasicFileAttributes

object GhDocVer {

  def copyScaladocs(srcDir: Path, destDir: Path): Unit = {
    if (Files.exists(destDir)) {
      Files.walkFileTree(destDir, new SimpleFileVisitor[Path]() {
        override def visitFile(file: Path, attrs: BasicFileAttributes) = {
          Files.delete(file)
          FileVisitResult.CONTINUE
        }

        override def postVisitDirectory(dir: Path, exc: java.io.IOException) = {
          Files.delete(dir)
          FileVisitResult.CONTINUE
        }
      })
    }

    Files.createDirectories(destDir)

    Files.walk(srcDir).forEach({ src =>
      val dest = destDir.resolve(srcDir.relativize(src))
      Files.copy(src, dest, StandardCopyOption.REPLACE_EXISTING)
    })
  }

  def copyReadme(src: Path, dest: Path): Unit = {
    Files.copy(src, dest, StandardCopyOption.REPLACE_EXISTING)
  }
}
