package org.example.adventOfCode2023.day3

class GearRation {
    companion object {
        fun isAdjacentToSymbol(matrix: Array<Array<Char>>): List<Int> {
            var gears = mutableListOf<Int>()

            matrix.forEachIndexed { r, row ->
                row.forEachIndexed { c, col ->
                    if (matrix[r][c].isDigit()) {
                        gears.add(matrix[r][c].digitToInt())
                    }
                }
            }

            return gears
        }

        fun readMatrix(input: String): Array<Array<Char>> {
            val splitInput = input.split("\n").filter { it.isNotEmpty() }.map { it.trim() }
//            println(splitInput)
//            println(splitInput.size)
//            println(splitInput[0].length)
            val matrix = Array(splitInput.size) {Array(splitInput[0].length){'.'} }
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
    }

}
