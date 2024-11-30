package adventOfCode2023.day3

import org.example.adventOfCode2023.day3.GearRation.Companion.calculateGearRatio
import org.example.adventOfCode2023.day3.GearRation.Companion.getGearsNextToSymbol
import org.example.adventOfCode2023.day3.GearRation.Companion.readMatrix
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.test.assertEquals
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
        val input =
            this::class.java.getResource("/adventOfCode2023/day3/basic.txt")?.readText() ?: fail()

        val matrix = readMatrix(input)

        assertAll({ assertEquals('4', matrix[0][0]) },
            { assertEquals('*', matrix[4][3]) },
            { assertEquals('.', matrix[9][9]) },
        )
    }

    @Test
    fun `parse full string to matrix`() {
        val input =
            this::class.java.getResource("/adventOfCode2023/day3/full.txt")?.readText() ?: fail()

        val matrix = readMatrix(input)

        assertAll(
            "matrix",
            { assertEquals('.', matrix[0][0]) },
            { assertEquals('6', matrix[1][3]) },
            { assertEquals('*', matrix[19][23]) },
        )
    }

    @Test
    fun `a number is a gear if it's left of a symbol`() {
        val input = "1*"
        val matrix = readMatrix(input)

        val gears = getGearsNextToSymbol(matrix)

        assertEquals(listOf(1), gears)
    }

    @Test
    fun `a number is a gear if it's right of a symbol`() {
        val input = "/2"
        val matrix = readMatrix(input)

        val gears = getGearsNextToSymbol(matrix)

        assertEquals(listOf(2), gears)
    }

    @Test
    fun `a number is a gear if it's above a symbol`() {
        val input = ".4\n.#"
        val matrix = readMatrix(input)

        val gears = getGearsNextToSymbol(matrix)

        assertEquals(listOf(4), gears)
    }

    @Test
    fun `a number is a gear if it's below a symbol`() {
        val input = ".@\n.5"
        val matrix = readMatrix(input)

        val gears = getGearsNextToSymbol(matrix)

        assertEquals(listOf(5), gears)
    }

    @Test
    fun `a number is a gear if it's above left a symbol`() {
        val input = "%..\n.6."
        val matrix = readMatrix(input)

        val gears = getGearsNextToSymbol(matrix)

        assertEquals(listOf(6), gears)
    }

    @Test
    fun `a number is a gear if it's above right a symbol`() {
        val input = "..=\n.7."
        val matrix = readMatrix(input)

        val gears = getGearsNextToSymbol(matrix)

        assertEquals(listOf(7), gears)
    }

    @Test
    fun `a number is a gear if it's below left a symbol`() {
        val input = ".8.\n&.."
        val matrix = readMatrix(input)

        val gears = getGearsNextToSymbol(matrix)

        assertEquals(listOf(8), gears)
    }

    @Test
    fun `a number is a gear if it's below right a symbol`() {
        val input = ".9.\n..$"
        val matrix = readMatrix(input)

        val gears = getGearsNextToSymbol(matrix)

        assertEquals(listOf(9), gears)
    }

    @Test
    fun `multiple digit next to each other count together as gear`() {
        val input = "+123-"
        val matrix = readMatrix(input)

        val gears = getGearsNextToSymbol(matrix)

        assertEquals(listOf(123), gears)
    }

    @Test
    fun `handle gear and no gear`() {
        val input = "467..114..\n...*......\n..35..633."
        val matrix = readMatrix(input)

        val gears = getGearsNextToSymbol(matrix)

        assertEquals(listOf(467, 35), gears)
    }

    @Test
    fun `a number is not a gear if it's not adjacent to a symbol`() {
        val input = "1.$"
        val matrix = readMatrix(input)

        val gears = getGearsNextToSymbol(matrix)

        assertEquals(listOf(), gears)
    }

    @Test
    fun `sum gears basic`() {
        val input =
            this::class.java.getResource("/adventOfCode2023/day3/basic.txt")?.readText() ?: fail()
        val matrix = readMatrix(input)
        val gears = getGearsNextToSymbol(matrix)

        val sum = gears.sum()

        assertEquals(4_361, sum)
    }

    @Test
    fun `sum gears full`() {
        val input =
            this::class.java.getResource("/adventOfCode2023/day3/full.txt")?.readText() ?: fail()
        val matrix = readMatrix(input)
        val gears = getGearsNextToSymbol(matrix)

        val sum = gears.sum()

        assertEquals(512_794, sum)
    }

    @Test
    fun `calculate start gear ratio return 0 if only one gear is found`() {
        val input = "3*."
        val matrix = readMatrix(input)

        val ratio = calculateGearRatio(matrix)

        assertEquals(0, ratio)
    }

    @Test
    fun `calculate start gear ratio left and right`() {
        val input = "3*2"
        val matrix = readMatrix(input)

        val ratio = calculateGearRatio(matrix)

        assertEquals(6, ratio)
    }

    @Test
    fun `calculate start gear ratio up and down`() {
        val input = "3\n*\n3"
        val matrix = readMatrix(input)

        val ratio = calculateGearRatio(matrix)

        assertEquals(9, ratio)
    }

    @Test
    fun `calculate start gear ratio right and down left`() {
        val input = "...\n" +
                ".*5\n" +
                "2.."
        val matrix = readMatrix(input)

        val ratio = calculateGearRatio(matrix)

        assertEquals(10, ratio)
    }

    @Test
    fun `calculate start gear ratio basic`() {
        val input = this::class.java.getResource("/adventOfCode2023/day3/basic.txt")?.readText() ?: fail()
        val matrix = readMatrix(input)

        val ratio = calculateGearRatio(matrix)

        assertEquals(467835, ratio)
    }

    @Test
    fun `calculate start gear ratio full`() {
        val input = this::class.java.getResource("/adventOfCode2023/day3/full.txt")?.readText() ?: fail()
        val matrix = readMatrix(input)

        val ratio = calculateGearRatio(matrix)

        assertEquals(67779080, ratio)
    }
}
