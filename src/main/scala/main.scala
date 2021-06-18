import aoc2020.Day1
import common.SolutionRunnable

object main {
  def main(args: Array[String]): Unit = {
    val day = args(0)

    var runner: SolutionRunnable = day match {
      case "1" => {
        new Day1("day1.txt")
      }
    }

    println(runner.runSolution)
  }
}
