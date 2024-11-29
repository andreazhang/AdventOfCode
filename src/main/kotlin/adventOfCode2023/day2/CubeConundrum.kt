package org.example.adventOfCode2023.day2

class CubeConundrum {
    companion object {
        private const val MAX_BLUE_CUBES = 14
        private const val MAX_RED_CUBES = 12
        private const val MAX_GREEN_CUBES = 13

        fun calculateGameWithMaxSeenOfEachCube(input: String): Game {
            val gameId = input.split(" ")[1].removeSuffix(":").toInt()
            var blueCube = 0
            var redCube = 0
            var greenCube = 0

            input.split(":")[1].replace(";", ",").split(",").forEach {
                when {
                    it.contains("blue") -> blueCube = blueCube.coerceAtLeast(it.trim().split(" ")[0].toInt())
                    it.contains("red") -> redCube = redCube.coerceAtLeast(it.trim().split(" ")[0].toInt())
                    it.contains("green") ->
                        greenCube = greenCube.coerceAtLeast(it.trim().split(" ")[0].toInt())
                }
            }

            return Game(gameId, blueCube, redCube, greenCube)
        }

        fun parseGames(input: String): List<Game> =
            input
                .split("\n")
                .filter { it.isNotEmpty() }
                .map { calculateGameWithMaxSeenOfEachCube(it) }
                .toList()

        fun calculateTotal(games: List<Game>): Int =
            games
                .filter {
                    it.blueCube <= MAX_BLUE_CUBES &&
                        it.redCube <= MAX_RED_CUBES &&
                        it.greenCube <= MAX_GREEN_CUBES
                }.sumOf { it.id }

        fun calculateSumOfPower(games: List<Game>): Int = games.sumOf { it.blueCube * it.redCube * it.greenCube }
    }
}

data class Game(
    val id: Int,
    val blueCube: Int,
    val redCube: Int,
    val greenCube: Int,
)
