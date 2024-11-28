package org.example.adventOfCode2023.Day1

import org.example.NumberInString.Companion.funConvertToNumber
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
        .map(funConvertToNumber)
        .map(funGetFirstAndLastDigit)
        .sum()
    }
  }
}
