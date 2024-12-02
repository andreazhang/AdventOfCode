package adventOfCode2024.day2

class RedNosedReports {
    companion object {
        fun parse(input: String): Array<Array<Int>> {
            val lines = input.split("\r\n").filter { it.isNotEmpty() }.toTypedArray()
            return lines
                .map { line ->
                    line.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }.toTypedArray()
                }
                .toTypedArray()
        }

        fun validateReport(input: Array<Int>): Boolean {
            return true
        }
    }
}
