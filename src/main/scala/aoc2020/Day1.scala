package aoc2020

import common.{SolutionRunnable, Util}

import scala.collection.mutable

class Day1(filename: String) extends SolutionRunnable {
  private var lines = Util.loadFileLines(filename)

  override def runSolution: String = {
    val nums = lines.map { ln => ln.toInt }

    val part1 = partOne(nums)
    val part2 = partTwo(nums)

    s"part1: $part1\npart2: $part2"
  }

  private def partOne(nums: Seq[Int]): String = {
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

  private def partTwo(nums: Seq[Int]): String = {
    val sortedNums = nums.sorted
    for (i <- 0 to sortedNums.length) {
      var l = i + 1
      var r = sortedNums.length - 1

      while (l < r) {
        val currSum = sortedNums(i) + sortedNums(l) + sortedNums(r)

        if (currSum == 2020) {
          return (sortedNums(i) * sortedNums(l) * sortedNums(r)).toString
        }
        else if (currSum < 2020) {
          l = l + 1
        }
        else if (currSum > 2020) {
          r = r - 1
        }
      }
    }
    "no answer"
  }
}
