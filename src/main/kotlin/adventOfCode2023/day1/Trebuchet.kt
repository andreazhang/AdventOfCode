package adventOfCode2023.day1

import org.example.adventOfCode2023.NumberInString.Companion.funAddDigitBeforeNumber
import org.example.adventOfCode2023.NumberInString.Companion.funGetFirstAndLastDigit

class Trebuchet {
    companion object {
        fun calibrateValue(input: String): Int = input.split("\n").map(funGetFirstAndLastDigit).sum()

        fun calibrateAdvancedValue(input: String): Int = input.split("\n").map(funAddDigitBeforeNumber).map(funGetFirstAndLastDigit).sum()
    }
}
