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
    fun `parse game from file`() {
        val input = this::class.java.getResource("/adventOfCode2023/day4/basic.txt")?.readText() ?: fail()

        val games = Scratchcards.parseGames(input)

        assertEquals(1, games[0].id)
        assertEquals(listOf(13, 32, 20, 16, 61), games[1].winningNumbers)
        assertEquals(listOf(69, 82, 63, 72, 16, 21, 14,  1), games[2].scratchedNumbers)
    }
}