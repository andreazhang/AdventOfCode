package adventOfCode2024.day6

class GuardGallivant {
    companion object {
        fun parse(input: String): Array<Array<Char>> =
            input
                .split("\r\n")
                .map { it.toCharArray().toTypedArray() }
                .toTypedArray()

        fun calculateNextPosition(matrix: Array<Array<Char>>): Pair<Int, Int> {
            val currentPosition = findGuardPosition(matrix)
            return when {
                matrix[currentPosition.first][currentPosition.second] == '^' -> Pair(currentPosition.first - 1, currentPosition.second)
                matrix[currentPosition.first][currentPosition.second] == 'v' -> Pair(currentPosition.first + 1, currentPosition.second)
                matrix[currentPosition.first][currentPosition.second] == '>' -> Pair(currentPosition.first, currentPosition.second + 1)
                matrix[currentPosition.first][currentPosition.second] == '<' -> Pair(currentPosition.first, currentPosition.second - 1)
                else -> Pair(0, 0)
            }
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
