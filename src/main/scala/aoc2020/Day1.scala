package aoc2020

import common.{SolutionRunnable, Util}

import scala.collection.mutable

class Day1 (filename: String) extends SolutionRunnable {
  private var lines = Util.loadFileLines(filename)

  override def runSolution: String = {
    val nums = parseInputToInts(lines)

    val seen: mutable.Set[Int] = mutable.Set()

    for (num <- nums) {
      val comp = 2020 - num
      if (seen.contains(comp)) {
        return (num * comp).toString
      }

      seen.add(num)
    }
    "no answer"
  }

  private def parseInputToInts(lines: Seq[String]): Seq[Int] = {
    lines.map { ln => ln.toInt }
  }
}
