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

        fun isValidOperation(total: Int, values: List<Int>): Boolean {
            if (values.sum() == total || values.reduce { acc, i -> acc * i } == total) {
                return true
            }

            return false
        }

        class CalibrationEquations(val operations: Map<Int, List<Int>>) {
            fun getOperationsPossibleByAdditionOrMultiplication(): Map<Int, List<Int>> {
                return operations.filter {
                    val sumTotal = it.value.sum()
                    val mulTotal = it.value.reduce { acc, i -> acc * i }
                    it.key in sumTotal..mulTotal
                }
            }

        }
    }
}
