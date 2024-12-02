package org.example.adventOfCode2023.day3

class GearRation {
    companion object {
        fun calculateGearRatio(matrix: Array<Array<Char>>): Int {
            val maxRow = matrix.size - 1
            val maxCol = matrix[0].size - 1
            var starCoordinate: Pair<Int, Int> = Pair(0, 0)
            val gearNextToStar: MutableMap<Pair<Int, Int>, List<Int>> = mutableMapOf()
            var ratio = 0

            var number = 0
            var isGear = false

            matrix.forEachIndexed { r, row ->
                row.forEachIndexed { c, _ ->
                    val isDigit = matrix[r][c].isDigit()
                    if (isDigit) {
                        when {
                            isStar(matrix[r][(c + 1).coerceAtMost(maxCol)]) -> {
                                isGear = true
                                starCoordinate = Pair(r, (c + 1).coerceAtMost(maxCol))
                            }
                            isStar(matrix[r][(c - 1).coerceAtLeast(0)]) -> {
                                isGear = true
                                starCoordinate = Pair(r, (c - 1).coerceAtLeast(0))
                            }
                            isStar(matrix[(r + 1).coerceAtMost(maxRow)][c]) -> {
                                isGear = true
                                starCoordinate = Pair((r + 1).coerceAtMost(maxRow), c)
                            }
                            isStar(matrix[(r - 1).coerceAtLeast(0)][c]) -> {
                                isGear = true
                                starCoordinate = Pair((r - 1).coerceAtLeast(0), c)
                            }
                            isStar(matrix[(r - 1).coerceAtLeast(0)][(c - 1).coerceAtLeast(0)]) -> {
                                isGear = true
                                starCoordinate = Pair((r - 1).coerceAtLeast(0), (c - 1).coerceAtLeast(0))
                            }
                            isStar(matrix[(r - 1).coerceAtLeast(0)][(c + 1).coerceAtMost(maxCol)]) -> {
                                isGear = true
                                starCoordinate = Pair((r - 1).coerceAtLeast(0), (c + 1).coerceAtLeast(0))
                            }
                            isStar(matrix[(r + 1).coerceAtMost(maxRow)][(c - 1).coerceAtLeast(0)]) -> {
                                isGear = true
                                starCoordinate = Pair((r + 1).coerceAtMost(maxRow), (c - 1).coerceAtLeast(0))
                            }
                            isStar(matrix[(r + 1).coerceAtMost(maxRow)][(c + 1).coerceAtMost(maxCol)]) -> {
                                isGear = true
                                starCoordinate = Pair((r + 1).coerceAtMost(maxRow), (c + 1).coerceAtMost(maxCol))
                            }
                        }
                    }
                    if (isDigit) {
                        number = (number * 10) + matrix[r][c].digitToInt()
                    }
                    if (!isDigit || c == maxCol) {
                        if (isGear) {
                            gearNextToStar[starCoordinate] =
                                gearNextToStar.getOrDefault(starCoordinate, mutableListOf()).plus(number)
                            isGear = false
                        }
                        //                        println("$number $isGear $starCoordinate $gearNextToStar")
                        starCoordinate = Pair(0, 0)
                        number = 0
                    }
                }
            }

            return gearNextToStar.filter { it.value.size == 2 }.map { it.value[0] * it.value[1] }.sum()
        }

        fun getGearsNextToSymbol(matrix: Array<Array<Char>>): List<Int> {
            val gears = mutableListOf<Int>()
            val maxRow = matrix.size - 1
            val maxCol = matrix[0].size - 1

            var number = 0
            var isGear = false

            matrix.forEachIndexed { r, row ->
                row.forEachIndexed { c, _ ->
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

        private fun isStar(char: Char): Boolean = '*' == char
    }
}
