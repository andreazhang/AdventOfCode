package adventOfCode2024.day6

class GuardGallivant {
    companion object {
        fun parse(input: String): Array<Array<Char>> {
            return input
                .split("\r\n")
                .map { it.toCharArray().toTypedArray() }
                .toTypedArray()
        }

        fun calculateNextPosition(matrix: Array<Array<Char>>): Pair<Int, Int> {
            TODO("Not yet implemented")
        }

        fun findGuardPosition(matrix: Array<Array<Char>>): Pair<Int, Int> {
            for (row in matrix.indices) {
                for (col in matrix[0].indices) {
                    if (matrix[row][col] in listOf('^', 'v', '>', '<')) {
                        return Pair(row, col)
                    }
                }
            }
            return Pair(0, 0)
        }
    }
}
