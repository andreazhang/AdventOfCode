package adventOfCode2024.day7

class BridgeRepair {
    companion object {
        fun parseInput(input: String): CalibrationEquations {
            val operations = input.split("\r\n").associate { line ->
                val total = line.split(":")[0].toDouble()
                val values = line.split(":")[1].trim().split(" ").map { it.toInt() }.toList()
                Pair(total, values)
            }
            return CalibrationEquations(operations)
        }

        fun isValidOperation(total: Double, values: List<Int>): Boolean {
            if (values.isEmpty()) {
                return false
            }
            if (values.size == 1 && values[0].toDouble() == total) {
                return true
            }

            return isValidOperation(total - values.last(), values.dropLast(1)) ||
                    isValidOperation(total / values.last(), values.dropLast(1))
        }

        fun calculateTotalCalibrationResult(operations: Map<Double, List<Int>>): Double {
            return operations.filter { isValidOperation(it.key, it.value) }.map { it.key }.sum()
        }

        class CalibrationEquations(val operations: Map<Double, List<Int>>) {

        }
    }
}
