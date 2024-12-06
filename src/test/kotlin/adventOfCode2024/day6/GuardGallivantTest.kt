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

        val guard = GuardGallivant.calculateNextPosition(matrix, GuardGallivant.findGuardPosition(matrix))

        assertEquals(Pair(0, 0), guard.position)
    }

    @Test
    fun `calculate guard next position move down`() {
        val input = ".\r\nv\r\n."
        val matrix = GuardGallivant.parse(input)

        val guard = GuardGallivant.calculateNextPosition(matrix, GuardGallivant.findGuardPosition(matrix))

        assertEquals(Pair(2, 0), guard.position)
    }

    @Test
    fun `calculate guard next position move right`() {
        val input = "..\r\n>.\r\n.."
        val matrix = GuardGallivant.parse(input)

        val guard = GuardGallivant.calculateNextPosition(matrix, GuardGallivant.findGuardPosition(matrix))

        assertEquals(Pair(1, 1), guard.position)
    }

    @Test
    fun `calculate guard next position move left`() {
        val input = "..\r\n.<\r\n.."
        val matrix = GuardGallivant.parse(input)

        val guard = GuardGallivant.calculateNextPosition(matrix, GuardGallivant.findGuardPosition(matrix))

        assertEquals(Pair(1, 0), guard.position)
    }

    @Test
    fun `rotate guard 90 degrees clockwise if next position is occupied up`() {
        val input = "#.\r\n^."
        val matrix = GuardGallivant.parse(input)

        val guard = GuardGallivant.calculateNextPosition(matrix, GuardGallivant.findGuardPosition(matrix))

        assertAll(
            { assertEquals('>', guard.direction) },
            { assertEquals(Pair(1, 1), guard.position) }
        )
    }

    @Test
    fun `rotate guard 90 degrees clockwise if next position is occupied down`() {
        val input = "..\r\n.v\r\n##"
        val matrix = GuardGallivant.parse(input)

        val guard = GuardGallivant.calculateNextPosition(matrix, GuardGallivant.findGuardPosition(matrix))

        assertAll(
            { assertEquals('<', guard.direction) },
            { assertEquals(Pair(1, 0), guard.position) }
        )
    }

    @Test
    fun `rotate guard 90 degrees clockwise if next position is occupied right`() {
        val input = "..\r\n>#\r\n.."
        val matrix = GuardGallivant.parse(input)

        val guard = GuardGallivant.calculateNextPosition(matrix, GuardGallivant.findGuardPosition(matrix))

        assertAll(
            { assertEquals('v', guard.direction) },
            { assertEquals(Pair(2, 0), guard.position) }
        )
    }

    @Test
    fun `rotate guard 90 degrees clockwise if next position is occupied left`() {
        val input = "..\r\n#<\r\n.."
        val matrix = GuardGallivant.parse(input)

        val guard = GuardGallivant.calculateNextPosition(matrix, GuardGallivant.findGuardPosition(matrix))

        assertAll(
            { assertEquals('^', guard.direction) },
            { assertEquals(Pair(0, 1), guard.position) }
        )
    }

    @Test
    fun `calculate distinct position guard has been`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day6/basic.txt")?.readText() ?: fail()
        val matrix = GuardGallivant.parse(input)
        val guard = GuardGallivant.findGuardPosition(matrix)

        val positions = GuardGallivant.calculateDistinctPositions(matrix, guard)

        assertEquals(41, positions.size)
    }
}
