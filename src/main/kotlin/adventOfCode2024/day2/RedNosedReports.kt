package adventOfCode2024.day2

class RedNosedReports {
    companion object {
        private const val MIN_DIFF: Int = 1
        private const val MAX_DIFF: Int = 3

        fun parse(input: String): Array<Array<Int>> {
            val lines = input.split("\r\n").filter { it.isNotEmpty() }.toTypedArray()
            return lines
                .map { line ->
                    line.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }.toTypedArray()
                }
                .toTypedArray()
        }

        fun validateReport(input: Array<Int>): Boolean {
            return allNumbersAreIncreasingBetweenBoundaries(input) || allNumbersAreDecreasingBetweenBoundaries(input)
        }

        private fun allNumbersAreIncreasingBetweenBoundaries(input: Array<Int>): Boolean {
            for (i in 0..input.size - 2) {
                val diff = input[i] - input[i + 1]
                if (diff > -MIN_DIFF || diff < -MAX_DIFF) {
                    return false
                }
            }

            return true
        }

        private fun allNumbersAreDecreasingBetweenBoundaries(input: Array<Int>): Boolean {
            for (i in 0..input.size - 2) {
                val diff = input[i] - input[i + 1]
                if (diff < MIN_DIFF || diff > MAX_DIFF) {
                    return false
                }
            }

            return true
        }
    }
}
