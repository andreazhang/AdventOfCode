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

        fun getNumberOfRecursiveScratchcards(games: List<Game>): Int = getNumberOfRecursiveScratchcards(games, games)

        fun getNumberOfRecursiveScratchcards(games: List<Game>, gamesToCheck: List<Game>): Int {
            if (gamesToCheck.isEmpty()) {
                return 0
            }
            var scorecards = 0

            println("------------------------")
            println("check #${gamesToCheck[0].id} - S${gamesToCheck.map { it.id }} - W${gamesToCheck[0].myWinningNumbers().size}")

            gamesToCheck.forEach { game ->
                scorecards++
                println(" checking ${game.id} - $scorecards")

                if (game.myWinningNumbers().isNotEmpty()) {
                    val newGamesToCheck = games.subList(game.id, game.id + game.myWinningNumbers().size)
                    println("  new recursion = ${newGamesToCheck.map { it.id }}")
                    scorecards += getNumberOfRecursiveScratchcards(games, newGamesToCheck)
                    println("     -> score = $scorecards")
                }
            }
            println("done ----")

            return scorecards
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
