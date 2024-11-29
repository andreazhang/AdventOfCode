package org.example.adventOfCode2023.day3

class GearRation {
    companion object {
        fun isAdjacentToSymbol(matrix: Array<Array<Char>>): List<Int> {
            val gears = mutableListOf<Int>()
            val maxRow = matrix.size - 1
            val maxCol = matrix[0].size - 1

            matrix.forEachIndexed { r, row ->
                row.forEachIndexed { c, col ->
                    if (matrix[r][c].isDigit() && isSurroundedBySymbol(matrix, r, c, maxCol)) {
                        gears.add(matrix[r][c].digitToInt())
                    }
                }
            }

            return gears
        }

        private fun isSurroundedBySymbol(
            matrix: Array<Array<Char>>,
            r: Int,
            c: Int,
            maxCol: Int,
        ) = isSymbol(matrix[r][(c + 1).coerceAtMost(maxCol)]) ||
            // check on right
            isSymbol(matrix[r][(c - 1).coerceAtLeast(0)]) // check on left

        fun readMatrix(input: String): Array<Array<Char>> {
            val splitInput = input.split("\n").filter { it.isNotEmpty() }.map { it.trim() }
            //            println(splitInput)
            //            println(splitInput.size)
            //            println(splitInput[0].length)
            val matrix = Array(splitInput.size) { Array(splitInput[0].length) { '.' } }
            //            matrix.forEach { it.forEach { print("$it") } }
            //            println("x ${matrix.indices}")
            //            println("y ${matrix[0].indices}")
            for (row in matrix.indices) {
                for (col in matrix[row].indices) {
                    //                    println("xy $col-$line")
                    matrix[row][col] = splitInput[row][col]
                }
            }
            //            matrix.forEach { it.forEach { print("$it") }; println()  }
            return matrix
        }

        fun isSymbol(char: Char): Boolean = "£$%&*/=".contains(char)
    }
}
