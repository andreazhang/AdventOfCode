package org.example.adventOfCode2023.day4

class Scratchcards {
    companion object {
        fun parseGame(input: String): Game {
            val gameId = input.split(" ")[1].removeSuffix(":")
            val winningNumbers = input.substring(input.indexOf(":")+1, input.indexOf("|"))
            val scratchedNumbers = input.substring(input.indexOf("|")+1, input.length)

            return Game(gameId.toInt(),
                convertToListOfNumbers(winningNumbers),
                convertToListOfNumbers(scratchedNumbers)
            )
        }

        private fun convertToListOfNumbers(numbers: String) =
            numbers.split(" ").map { it.trim() }.filter { it.isNotEmpty() }.map { it.toInt() }.toList()

        fun parseGames(input: String): List<Game> =
            input.split("\n").map { parseGame(it) }.toList()

    }

    data class Game (val id: Int, val winningNumbers: List<Int>, val scratchedNumbers: List<Int>) {
        fun myWinningNumbers(): Set<Int> = winningNumbers.intersect(scratchedNumbers.toSet())
    }

}
