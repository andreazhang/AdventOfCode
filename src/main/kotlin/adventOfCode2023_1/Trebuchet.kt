package org.example.adventOfCode2023_1

import org.example.NumberInString.Companion.funGetFirstAndLastDigit

class Trebuchet {
  companion object {
    fun calibrateValue(input: String): Int {
      val splitByLine = input.split("\n")
      val splitByFirstAndLastDigit = splitByLine.map(funGetFirstAndLastDigit)
      return splitByFirstAndLastDigit.sum()
    }
  }
}
