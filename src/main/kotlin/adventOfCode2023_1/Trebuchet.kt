package org.example.adventOfCode2023_1

import org.example.NumberInString.Companion.funSumFirstAndLastDigit

class Trebuchet {
  companion object {
    fun calibrateValue(input: String): Int {
      println("input $input")
      val map = input.split("\n")
      println("map")
      println(map[0])
      val b = map.map(funSumFirstAndLastDigit)
      println(b)
      val c = b.sum()
      println(c)
      return c
    }
  }
}
