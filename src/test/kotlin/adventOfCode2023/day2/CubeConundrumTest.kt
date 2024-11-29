package adventOfCode2023.day2

import org.example.adventOfCode2023.day2.CubeConundrum.Companion.calculateTotal
import org.example.adventOfCode2023.day2.CubeConundrum.Companion.parseGame
import org.example.adventOfCode2023.day2.CubeConundrum.Companion.parseGames
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.assertAll
import kotlin.test.assertEquals
import kotlin.test.fail

class CubeConundrumTest {

    @Test
    fun `calculate cube quantity given input string`() {
        val input = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"

        val game = parseGame(input)

        assertAll("game has correct properties",
            { assertEquals(1, game.id) },
            { assertEquals(9, game.blueCube) },
            { assertEquals(5, game.redCube) },
            { assertEquals(4, game.greenCube) }
        )
    }

    @Test
    fun `parse multiple games`() {
        val input = this::class.java.getResource("/adventOfCode2023/day2/basic.txt")?.readText() ?: fail()

        val games = parseGames(input)

        assertAll("games has correct properties",
            { assertEquals(5, games.size) },
            { assertEquals(9, games[0].blueCube) },
            { assertEquals(1, games[1].redCube) },
            { assertEquals(26, games[2].greenCube) }
        )
    }

    @Test
    fun `calculate sum of games with restricted number of available cubes`() {
        val input = this::class.java.getResource("/adventOfCode2023/day2/basic.txt")?.readText() ?: fail()
        val games = parseGames(input)

        val total = calculateTotal(games)

        assertEquals(8, total)
    }
}
