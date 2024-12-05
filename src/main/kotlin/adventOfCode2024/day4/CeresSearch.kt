package adventOfCode2024.day4

class CeresSearch {
    companion object {
        fun parseInput(input: String): Array<Array<Char>> =
            input
                .split("\r\n")
                .map { it.toCharArray().toTypedArray() }
                .toTypedArray()

        fun countWordInMatrix(matrix: Array<Array<Char>>, word: String, directions: List<Pair<Int, Int>>): Int {
            var count = 0
            for (row in matrix.indices) {
                for (col in 0..<matrix[0].size) {
                    for (direction in directions) {
                        if (wordInMatrix(matrix, row, col, direction, word)) {
                            count++
                        }
                    }
                }
            }
            return count
        }

        private fun wordInMatrix(
            matrix: Array<Array<Char>>,
            row: Int,
            col: Int,
            direction: Pair<Int, Int>,
            word: String
        ): Boolean {
            var newRow = row
            var newCol = col

            for (char in word) {
                if (matrix[newRow][newCol] != char) {
                    return false
                }

                newRow += direction.first
                newCol += direction.second

                if (newCol < 0 || newCol >= matrix.size) {
                    return false
                }
            }

            return true
        }
    }
}
