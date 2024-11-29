package org.example.adventOfCode2023.day3

class GearRation {
    companion object {
        fun calculateGearRatio(matrix: Array<Array<Char>>): Int {
            matrix.forEachIndexed { r, row ->
                row.forEachIndexed { c, col -> if (matrix[r][c] == '*') {} }
            }

            return 0
        }

        fun getGearsNextToSymbol(matrix: Array<Array<Char>>): List<Int> {
            val gears = mutableListOf<Int>()
            val maxRow = matrix.size - 1
            val maxCol = matrix[0].size - 1

            var number = 0
            var isGear = false

            matrix.forEachIndexed { r, row ->
                row.forEachIndexed { c, col ->
                    val isDigit = matrix[r][c].isDigit()
                    if (isDigit && isSurroundedBySymbol(matrix, r, c, maxRow, maxCol)) {
                        isGear = true
                    }
                    if (isDigit) {
                        number = (number * 10) + matrix[r][c].digitToInt()
                    }
                    if (!isDigit || c == maxCol) {
                        // println("$number $isGear")
                        if (isGear) {
                            gears.add(number)
                            isGear = false
                        }
                        number = 0
                    }
                }
            }

            return gears
        }

        private fun isSurroundedBySymbol(
            matrix: Array<Array<Char>>,
            r: Int,
            c: Int,
            maxRow: Int,
            maxCol: Int,
        ): Boolean {
            val right = matrix[r][(c + 1).coerceAtMost(maxCol)]
            val left = matrix[r][(c - 1).coerceAtLeast(0)]
            val down = matrix[(r + 1).coerceAtMost(maxRow)][c]
            val up = matrix[(r - 1).coerceAtLeast(0)][c]
            val upLeft = matrix[(r - 1).coerceAtLeast(0)][(c - 1).coerceAtLeast(0)]
            val upRight = matrix[(r - 1).coerceAtLeast(0)][(c + 1).coerceAtMost(maxCol)]
            val downLeft = matrix[(r + 1).coerceAtMost(maxRow)][(c - 1).coerceAtLeast(0)]
            val downRight = matrix[(r + 1).coerceAtMost(maxRow)][(c + 1).coerceAtMost(maxCol)]
            return isSymbol(right) ||
                isSymbol(left) ||
                isSymbol(down) ||
                isSymbol(up) ||
                isSymbol(upLeft) ||
                isSymbol(upRight) ||
                isSymbol(downLeft) ||
                isSymbol(downRight)
        }

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
            // matrix.forEach { it.forEach { print("$it") }; println()  }
            return matrix
        }

        private fun isSymbol(char: Char): Boolean = "$%&*/=#@-+".contains(char)
    }
}
