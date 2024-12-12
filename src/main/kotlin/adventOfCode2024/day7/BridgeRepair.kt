package adventOfCode2024.day7

class BridgeRepair {
    companion object {
        fun parseInput(input: String): CalibrationEquations {
            val operations = input.split("\r\n").associate { line ->
                val total = line.split(":")[0].toInt()
                val values = line.split(":")[1].trim().split(" ").map { it.toInt() }.toList()
                Pair(total, values)
            }
            return CalibrationEquations(operations)
        }

        class CalibrationEquations(val operations: Map<Int, List<Int>>) {

        }
    }
}
