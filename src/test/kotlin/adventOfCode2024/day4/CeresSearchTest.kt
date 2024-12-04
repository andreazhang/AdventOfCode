package adventOfCode2024.day4

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.fail

class CeresSearchTest {
    @Test
    fun `parse input as matrix`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day4/basic.txt")?.readText() ?: fail()

        val matrix = CeresSearch.parseInput(input)

        assertEquals("M", matrix[0][0])
    }
}
