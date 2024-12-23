package adventOfCode2024.day4

class CeresSearch {
    companion object {
        fun parseInput(input: String): Array<Array<Char>> =
            input
                .split("\r\n")
                .map { it.toCharArray().toTypedArray() }
                .toTypedArray()

        fun countWordInMatrix(
            matrix: Array<Array<Char>>,
            word: String,
            directions: List<Pair<Int, Int>>,
        ): Int {
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
            word: String,
        ): Boolean {
            var newRow = row
            var newCol = col

            for (char in word) {
                if (outsideMatrixBoundary(newCol, matrix) || outsideMatrixBoundary(newRow, matrix)) {
                    return false
                }

                if (matrix[newRow][newCol] != char) {
                    return false
                }

                newRow += direction.first
                newCol += direction.second
            }

            return true
        }

        private fun outsideMatrixBoundary(
            newDimension: Int,
            matrix: Array<Array<Char>>,
        ) = newDimension < 0 || newDimension >= matrix.size

        fun countMasInXShapeInMatrix(matrix: Array<Array<Char>>): Int {
            var count = 0

            for (row in 1..<matrix.size - 1) {
                for (col in 1..<matrix[0].size - 1) {
                    if (matrix[row][col] == 'A') {
                        if (setOf(matrix[row - 1][col - 1], matrix[row + 1][col + 1]).containsAll(listOf('M', 'S')) &&
                            setOf(matrix[row + 1][col - 1], matrix[row - 1][col + 1]).containsAll(listOf('M', 'S'))
                        ) {
                            count++
                        }
                    }
                }
            }

            return count
        }
    }
}
