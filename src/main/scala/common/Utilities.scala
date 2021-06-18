package common

import scala.collection.immutable
import scala.io.Source

object Util {
  def loadFileLines(filename: String): immutable.Seq[String] = {
    val file = Source.fromFile(filename)
    var list: Array[String] = Array()
    for (line <- file.getLines) {
      list = list :+ line
    }
    file.close()

    list.to(immutable.Seq)
  }
}
