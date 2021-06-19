package aoc2020

import common.{SolutionRunnable, Util}

class Day2(filename: String) extends SolutionRunnable {
  private var lines = Util.loadFileLines(filename)

  def runSolution: String = {
    val ruleSet = lines.map { line =>
      val rule = parseRule(line)
      val password = parsePassword(line)

      (password, rule)
    }

    def partOne: String = {
      val validPasswords = ruleSet.filter { passwordRuleset =>
        val password = passwordRuleset._1
        val ruleset = passwordRuleset._2

        val appearing = password.count(char => char == ruleset._1(0))
        appearing >= ruleset._2 && appearing <= ruleset._3
      }

      validPasswords.length.toString
    }

    def partTwo: String = {
      val validPasswords = ruleSet.filter { passwordRuleset =>
        val password = passwordRuleset._1
        val ruleset = passwordRuleset._2

        val char = ruleset._1(0)
        val upper = ruleset._2 - 1
        val lower = ruleset._3 - 1
        val appearsAtFirst = password(upper) == char
        val appearsAtSecond = password(lower) == char
        appearsAtFirst != appearsAtSecond
      }

      validPasswords.length.toString
    }

    s"part1: $partOne\npart2: $partTwo"
  }

  private def parsePassword(line: String): String = {
    val split = line.split(": ")
    split(1)
  }

  private def parseRule(line: String): (String, Int, Int) = {
    val split = line.split(": ")
    val rangeLetter = split(0).split(" ")
    val letter = rangeLetter(1)
    val range = rangeLetter(0).split("-")
    val lower = range(0)
    val upper = range(1)

    (letter, lower.toInt, upper.toInt)
  }
}
