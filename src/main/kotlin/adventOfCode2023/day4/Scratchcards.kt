package org.example.adventOfCode2023.day4

import kotlin.math.pow

class Scratchcards {
    companion object {
        fun parseGame(input: String): Game {
            val gameId = input.split(" ").filter { it.isNotEmpty() }[1].removeSuffix(":")
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

        fun getNumberOfRecursiveScratchcards(games: List<Game>): Int {
            println("start recursion ${games.size} ${games[0].myWinningNumbers()}")
            if (games[0].myWinningNumbers().isEmpty()) {
                return 1
            }

            val maxWinScratchcardWithinAvailable = (games[0].myWinningNumbers().size + 1).coerceAtMost(games.size)
            return games.size + getNumberOfRecursiveScratchcards(games.subList(1, maxWinScratchcardWithinAvailable))
        }

    }

    data class Game (val id: Int, val winningNumbers: List<Int>, val scratchedNumbers: List<Int>) {
        fun myWinningNumbers(): Set<Int> = winningNumbers.intersect(scratchedNumbers.toSet())
        fun points(): Int {
            if (myWinningNumbers().isEmpty()) {
                return 0
            }
            return 2.0.pow((myWinningNumbers().size - 1).toDouble()).toInt()
        }
    }

}
