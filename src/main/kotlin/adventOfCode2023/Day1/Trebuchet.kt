package org.example.adventOfCode2023.Day1

import org.example.NumberInString.Companion.funAddDigitBeforeNumber
import org.example.NumberInString.Companion.funGetFirstAndLastDigit

class Trebuchet {
  companion object {
    fun calibrateValue(input: String): Int {
      return input
        .split("\n")
        .map(funGetFirstAndLastDigit)
        .sum()
    }
    fun calibrateAdvancedValue(input: String): Int {
      return input
        .split("\n")
        .map(funAddDigitBeforeNumber)
        .map(funGetFirstAndLastDigit)
        .sum()
    }
  }
}
