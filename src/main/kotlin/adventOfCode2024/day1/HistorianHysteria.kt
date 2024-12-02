package adventOfCode2024.day1

import kotlin.math.abs

class HistorianHysteria {
    companion object {
        fun parseInput(input: String): Locations {
            val lines = input.split("\r\n").filter { it.isNotEmpty() }
            val linesSplitToNumberArray = lines.map { line -> line.split(" ").filter { it.isNotEmpty() } }
            val leftLocations = linesSplitToNumberArray.map { it[0].toInt() }.toList()
            val rightLocations = linesSplitToNumberArray.map { it[1].toInt() }.toList()

            return Locations(leftLocations, rightLocations)
        }

        fun calculateDifferenceBetweenLeftAndRight(locations: Locations): List<Int> {
            val sortedLeft = locations.left.sorted()
            val sortedRight = locations.right.sorted()

            return sortedLeft.mapIndexed { index, left -> abs(left - sortedRight[index]) }.toList()
        }
    }

    class Locations(val left: List<Int>, val right: List<Int>)
}