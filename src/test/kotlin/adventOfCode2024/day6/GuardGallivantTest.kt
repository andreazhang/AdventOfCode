package adventOfCode2024.day6

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
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
            { assertEquals('#', matrix[6][1]) },
        )
    }

    @ParameterizedTest
    @ValueSource(chars = ['^', 'v', '>', '<'])
    fun `find position of guard`(guardDirection: Char) {
        val input = ".\r\n$guardDirection"
        val matrix = GuardGallivant.parse(input)

        val guard = GuardGallivant.findGuardPosition(matrix)

        assertEquals(guardDirection, guard.direction)
        assertEquals(Pair(1, 0), guard.position)
    }

    @Test
    fun `calculate guard next position move up`() {
        val input = ".\r\n^"
        val matrix = GuardGallivant.parse(input)

        val nextPosition = GuardGallivant.calculateNextPosition(matrix)

        assertEquals(Pair(0, 0), nextPosition)
    }

    @Test
    fun `calculate guard next position move down`() {
        val input = ".\r\nv\r\n."
        val matrix = GuardGallivant.parse(input)

        val nextPosition = GuardGallivant.calculateNextPosition(matrix)

        assertEquals(Pair(2, 0), nextPosition)
    }

    @Test
    fun `calculate guard next position move right`() {
        val input = "..\r\n>.\r\n.."
        val matrix = GuardGallivant.parse(input)

        val nextPosition = GuardGallivant.calculateNextPosition(matrix)

        assertEquals(Pair(1, 1), nextPosition)
    }

    @Test
    fun `calculate guard next position move left`() {
        val input = "..\r\n.<\r\n.."
        val matrix = GuardGallivant.parse(input)

        val nextPosition = GuardGallivant.calculateNextPosition(matrix)

        assertEquals(Pair(1, 0), nextPosition)
    }
}
