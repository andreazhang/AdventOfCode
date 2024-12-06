package adventOfCode2024.day6

class GuardGallivant {
    companion object {
        fun parse(input: String): Array<Array<Char>> =
            input
                .split("\r\n")
                .map { it.toCharArray().toTypedArray() }
                .toTypedArray()

        fun calculateNextPosition(matrix: Array<Array<Char>>): Guard {
            val curr = findGuardPosition(matrix).position
            val up = Pair(curr.first - 1, curr.second)
            val right = Pair(curr.first, curr.second + 1)
            val down = Pair(curr.first + 1, curr.second)
            val left = Pair(curr.first, curr.second - 1)
            return when {
                at(matrix, curr) == '^' -> {
                    if (at(matrix, up) == '#') Guard('>', right) else Guard('^', up)
                }
                at(matrix, curr) == 'v' -> {
                    if (at(matrix, down) == '#') Guard('<', left) else Guard('v', down)
                }
                at(matrix, curr) == '>' -> {
                    if (at(matrix, right) == '#') Guard('v', down) else Guard('>', right)
                }
                at(matrix, curr) == '<' -> {
                    if (at(matrix, left) == '#') Guard('^', up) else Guard('<', left)
                }
                else -> Guard('X', Pair(-1, -1))
            }
        }

        private fun at(matrix: Array<Array<Char>>, pos: Pair<Int, Int>) =
            matrix[pos.first][pos.second]

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
