package org.example.adventOfCode2023.day2

class CubeConundrum {
    companion object {
        fun parseGame(input: String): Game {
            val gameId = input.split(" ")[1].removeSuffix(":").toInt()
            var blueCube = 0
            var redCube = 0
            var greenCube = 0

            input.split(":")[1].replace(";", ",").split(",").forEach {
                when {
                    it.contains("blue") -> blueCube += it.trim().split(" ")[0].toInt()
                    it.contains("red") -> redCube += it.trim().split(" ")[0].toInt()
                    it.contains("green") -> greenCube += it.trim().split(" ")[0].toInt()
                }
            }

            return Game(gameId, blueCube, redCube, greenCube)
        }

        fun parseGames(input: String): List<Game> {
            TODO()
        }
    }
}

class Game(val id: Int, val blueCube: Int, val redCube: Int, val greenCube: Int) {

}