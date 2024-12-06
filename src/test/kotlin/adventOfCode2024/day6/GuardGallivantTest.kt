package adventOfCode2024.day6

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.test.assertEquals
import kotlin.test.fail

class GuardGallivantTest {
    @Test
    fun `parse input as matrix`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day6/basic.txt")?.readText() ?: fail()

        val matrix = GuardGallivant.parse(input)

        assertAll(
            { assertEquals('^', matrix[6][4]) },
            { assertEquals('#', matrix[6][1]) }
        )
    }

    @Test
    fun `find position of guard`() {
        val input = ".\r\n^"
        val matrix = GuardGallivant.parse(input)

        val nextPosition = GuardGallivant.findGuardPosition(matrix)

        assertEquals(Pair(1, 0), nextPosition)
    }

    @Test
    fun `calculate guard next position move up`() {
        val input = ".\r\n^"
        val matrix = GuardGallivant.parse(input)

        val nextPosition = GuardGallivant.calculateNextPosition(matrix)

        assertEquals(Pair(0, 0), nextPosition)
    }
}
