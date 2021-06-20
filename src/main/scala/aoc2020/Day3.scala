package aoc2020

import common.{SolutionRunnable, Util}

class Day3(filename: String) extends SolutionRunnable {
  private var lines = Util.loadFileLines(filename)

  def runSolution: String = {
    s"part1: $partOne\npart2: $partTwo"
  }

  def partOne: String = {
    val filtered = lines.view.zipWithIndex.count { case (row, i) =>
      val col = (i * 3) % row.length
      row(col) == '#'
    }
    filtered.toString
  }

  def partTwo: String = {
    val slopes = Array(1, 3, 5, 7)
    val counts = slopes.map { slope =>
      lines.zipWithIndex.count { case(row, i) =>
        row((i * slope) % row.length) == '#'
      }
    }

    val lastCount = lines.view.zipWithIndex.count { case(row, i) =>
      i % 2 == 0 && row((i / 2) % row.length) == '#'
    }
    val prod: Long = counts.product
    (prod * lastCount).toString
  }
}
