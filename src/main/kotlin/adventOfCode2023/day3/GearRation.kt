package org.example.adventOfCode2023.day3

class GearRation {
    companion object {
        fun isAdjacentToSymbol(input: String): Boolean {
            for (i in 1..input.length) {
                if (input[i].isDigit() && input[i+1] == '*') {
                    return true
                }
            }
            return false
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
            for (line in matrix.indices) {
                for (col in matrix[line].indices) {
//                    println("xy $col-$line")
                    matrix[line][col] = splitInput[line][col]
                }
            }
//            matrix.forEach { it.forEach { print("$it") }; println()  }
            return matrix
        }
    }

}
