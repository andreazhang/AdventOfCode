package adventOfCode2024.day1

class HistorianHysteria {
    companion object {
        fun parseInput(input: String): Locations {
            val lines = input.split("\r\n").filter { it.isNotEmpty() }
            val linesSplitToNumberArray = lines.map { line -> line.split(" ").filter { it.isNotEmpty() } }
            val leftLocations = linesSplitToNumberArray.map { it[0].toInt() }.toList()
            val rightLocations = linesSplitToNumberArray.map { it[1].toInt() }.toList()

            return Locations(leftLocations, rightLocations)
        }
    }

    class Locations(val left: List<Int>, val right: List<Int>)
}
