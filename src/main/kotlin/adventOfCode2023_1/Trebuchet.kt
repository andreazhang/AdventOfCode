package org.example.adventOfCode2023_1

import org.example.NumberInString

class Trebuchet {
  companion object {
    fun calibrateValue(input: String): Int {
      return NumberInString.sumFirstAndLastDigit(input)
    }
  }
}
