package adventOfCode2023.day4

import org.example.adventOfCode2023.day4.Scratchcards
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ScratchcardsTest {

    @Test
    fun `get game from string`() {
        val input = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53"

        val game = Scratchcards.parseGame(input)

        assertEquals(1, game.id)
        assertEquals(listOf(41, 48, 83, 86, 17), game.winningNumbers)
        assertEquals(listOf(83, 86, 6, 31, 17, 9, 48, 53), game.scratchedNumbers)
    }
}