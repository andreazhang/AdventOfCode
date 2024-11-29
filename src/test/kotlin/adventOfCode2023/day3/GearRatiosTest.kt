package adventOfCode2023.day3

import org.example.adventOfCode2023.day3.GearRation.Companion.isAdjacentToSymbol
import org.example.adventOfCode2023.day3.GearRation.Companion.readMatrix
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import kotlin.test.fail

class GearRatiosTest {
    @Test
    fun `parse 1 line string to matrix`() {
        val input = "12"

        val matrix = readMatrix(input)

        assertEquals('1', matrix[0][0])
        assertEquals('2', matrix[0][1])
    }

    @Test
    fun `parse 2 line string to matrix`() {
        val input = "1\n2"

        val matrix = readMatrix(input)

        assertEquals('1', matrix[0][0])
        assertEquals('2', matrix[1][0])
    }

    @Test
    fun `parse basic string to matrix`() {
        val input = this::class.java.getResource("/adventOfCode2023/day3/basic.txt")?.readText() ?: fail()

        val matrix = readMatrix(input)

        assertAll(
            { assertEquals('4', matrix[0][0]) },
            { assertEquals('*', matrix[4][3]) },
            { assertEquals('.', matrix[9][9]) }
        )
    }

    @Test
    fun `parse full string to matrix`() {
        val input = this::class.java.getResource("/adventOfCode2023/day3/full.txt")?.readText() ?: fail()

        val matrix = readMatrix(input)

        assertAll("matrix",
            { assertEquals('.', matrix[0][0]) },
            { assertEquals('6', matrix[1][3]) },
            { assertEquals('*', matrix[19][23]) }
        )
    }

    @Test
    fun `a number is a gear if it's adjacent to a symbol`() {
        val input = "1*"

        val adjacent = isAdjacentToSymbol(input)

        assertTrue(adjacent)
    }

    @Test
    fun `a number is not a gear if it's not adjacent to a symbol`() {
        val input = "1."

        val adjacent = isAdjacentToSymbol(input)

        assertFalse(adjacent)
    }
}
