package adventOfCode2023.day4

import org.example.adventOfCode2023.day4.Scratchcards
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.fail

class ScratchcardsTest {

    @Test
    fun `get game from string`() {
        val input = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53"

        val game = Scratchcards.parseGame(input)

        assertEquals(1, game.id)
        assertEquals(listOf(41, 48, 83, 86, 17), game.winningNumbers)
        assertEquals(listOf(83, 86, 6, 31, 17, 9, 48, 53), game.scratchedNumbers)
    }

    @Test
    fun `compare scratched numbers against winning numbers`() {
        val input = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53"
        val game = Scratchcards.parseGame(input)

        val myWinningNumbers = game.myWinningNumbers()

        assertEquals(setOf(48, 83, 17, 86), myWinningNumbers)
    }

    @Test
    fun `get game points, 0 points if no winning numbers`() {
        val input = "Card 1: 1 2 3 | 4 5 6"
        val game = Scratchcards.parseGame(input)

        val points = game.points()

        assertEquals(0, points)
    }

    @Test
    fun `get game points, 1 points if 1 winning number`() {
        val input = "Card 1: 1 2 3 | 1 4 5 6"
        val game = Scratchcards.parseGame(input)

        val points = game.points()

        assertEquals(1, points)
    }

    @Test
    fun `get game points, 2 points if 2 winning number`() {
        val input = "Card 1: 1 2 3 | 1 3 5 6"
        val game = Scratchcards.parseGame(input)

        val points = game.points()

        assertEquals(2, points)
    }

    @Test
    fun `get game points, 4 points if 3 winning number`() {
        val input = "Card 1: 1 2 3 | 1 2 3"
        val game = Scratchcards.parseGame(input)

        val points = game.points()

        assertEquals(4, points)
    }

    @Test
    fun `get game points, 8 points if 4 winning number`() {
        val input = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53"
        val game = Scratchcards.parseGame(input)

        val points = game.points()

        assertEquals(8, points)
    }

    @Test
    fun `parse game from file`() {
        val input = this::class.java.getResource("/adventOfCode2023/day4/basic.txt")?.readText() ?: fail()

        val games = Scratchcards.parseGames(input)

        assertEquals(1, games[0].id)
        assertEquals(listOf(13, 32, 20, 16, 61), games[1].winningNumbers)
        assertEquals(listOf(69, 82, 63, 72, 16, 21, 14,  1), games[2].scratchedNumbers)
    }

    @Test
    fun `score points basic`() {
        val input = this::class.java.getResource("/adventOfCode2023/day4/basic.txt")?.readText() ?: fail()
        val games = Scratchcards.parseGames(input)

        val points = games.sumOf { it.points() }

        assertEquals(13, points)
    }

    @Test
    fun `score points full`() {
        val input = this::class.java.getResource("/adventOfCode2023/day4/full.txt")?.readText() ?: fail()
        val games = Scratchcards.parseGames(input)

        val points = games.sumOf { it.points() }

        assertEquals(24733, points)
    }
}