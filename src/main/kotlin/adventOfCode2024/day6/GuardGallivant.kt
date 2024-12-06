package adventOfCode2024.day6

class GuardGallivant {
    companion object {
        fun parse(input: String): Array<Array<Char>> =
            input
                .split("\r\n")
                .map { it.toCharArray().toTypedArray() }
                .toTypedArray()

        fun calculateNextPosition(matrix: Array<Array<Char>>, guard: Guard): Guard {
            val curr = guard.position
            val up = Pair(curr.first - 1, curr.second)
            val right = Pair(curr.first, curr.second + 1)
            val down = Pair(curr.first + 1, curr.second)
            val left = Pair(curr.first, curr.second - 1)
            return try {
                when (guard.direction) {
                    '^' -> if (at(matrix, up) == '#') Guard('>', right) else Guard('^', up)
                    'v' -> if (at(matrix, down) == '#') Guard('<', left) else Guard('v', down)
                    '>' -> if (at(matrix, right) == '#') Guard('v', down) else Guard('>', right)
                    '<' -> if (at(matrix, left) == '#') Guard('^', up) else Guard('<', left)
                    else -> throw Exception("Unclear guard direction ${guard.direction}")
                }
            } catch (e: IndexOutOfBoundsException) {
                Guard('X', Pair(curr.first, curr.second))
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

        fun calculateDistinctPositions(matrix: Array<Array<Char>>, guard: Guard): Set<Pair<Int, Int>> {
            var positions = setOf<Pair<Int, Int>>()
            var tmpGuard = guard

            while (tmpGuard.direction != 'X') {
                val next = calculateNextPosition(matrix, tmpGuard)
                positions = positions.plus(next.position)
                tmpGuard = next
            }

            return positions
        }
    }

    class Guard(
        val direction: Char,
        val position: Pair<Int, Int>,
    )
}
