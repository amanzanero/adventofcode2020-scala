import aoc2020.{Day1, Day2}
import common.SolutionRunnable

object main {
  def main(args: Array[String]): Unit = {
    val day = args(0)

    val runner: SolutionRunnable = day match {
      case "1" => new Day1("day1.txt")
      case "2" => new Day2("day2.txt")
    }

    println(runner.runSolution)
  }
}
