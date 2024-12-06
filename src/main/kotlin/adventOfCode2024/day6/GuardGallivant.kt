package adventOfCode2024.day6

class GuardGallivant {
    companion object {
        fun parse(input: String): Array<Array<Char>> =
            input
                .split("\r\n")
                .map { it.toCharArray().toTypedArray() }
                .toTypedArray()

        fun calculateNextPosition(matrix: Array<Array<Char>>): Guard {
            val currentPosition = findGuardPosition(matrix).position
            return when {
                matrix[currentPosition.first][currentPosition.second] == '^' -> Guard('^', Pair(currentPosition.first - 1, currentPosition.second))
                matrix[currentPosition.first][currentPosition.second] == 'v' -> Guard('v', Pair(currentPosition.first + 1, currentPosition.second))
                matrix[currentPosition.first][currentPosition.second] == '>' -> Guard('>', Pair(currentPosition.first, currentPosition.second + 1))
                matrix[currentPosition.first][currentPosition.second] == '<' -> Guard('<', Pair(currentPosition.first, currentPosition.second - 1))
                else -> Guard('X', Pair(-1, -1))
            }
        }

        fun findGuardPosition(matrix: Array<Array<Char>>): Guard {
            for (row in matrix.indices) {
                for (col in matrix[0].indices) {
                    if (matrix[row][col] in listOf('^', 'v', '>', '<')) {
                        return Guard(matrix[row][col], Pair(row, col))
                    }
                }
            }
            throw Exception("Cannot find new guard position")
        }
    }

    class Guard(
        val direction: Char,
        val position: Pair<Int, Int>,
    )
}
