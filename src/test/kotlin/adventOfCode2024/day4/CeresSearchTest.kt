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

        assertEquals('M', matrix[0][0])
        assertEquals('A', matrix[2][0])
    }

    @Test
    fun `find XMAS in horizontal line forward and backwards`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day4/basic.txt")?.readText() ?: fail()
        val matrix = CeresSearch.parseInput(input)
        val directions = listOf(Pair(0, 1), Pair(0, -1))

        val count = CeresSearch.countWordInMatrix(matrix, "XMAS", directions)

        assertEquals(5, count)
    }

    @Test
    fun `find XMAS in vertical line upwards and downwards`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day4/basic.txt")?.readText() ?: fail()
        val matrix = CeresSearch.parseInput(input)
        val directions = listOf(Pair(1, 0), Pair(-1, 0))

        val count = CeresSearch.countWordInMatrix(matrix, "XMAS", directions)

        assertEquals(3, count)
    }

    @Test
    fun `find XMAS in diagonal lines top right and left`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day4/basic.txt")?.readText() ?: fail()
        val matrix = CeresSearch.parseInput(input)
        val directions = listOf(Pair(-1, 1), Pair(-1, -1))

        val count = CeresSearch.countWordInMatrix(matrix, "XMAS", directions)

        assertEquals(8, count)
    }

    @Test
    fun `find XMAS in diagonal lines bottom right and left`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day4/basic.txt")?.readText() ?: fail()
        val matrix = CeresSearch.parseInput(input)
        val directions = listOf(Pair(1, 1), Pair(1, -1))

        val count = CeresSearch.countWordInMatrix(matrix, "XMAS", directions)

        assertEquals(2, count)
    }

    @Test
    fun `count XMAS in all directions basic`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day4/basic.txt")?.readText() ?: fail()
        val matrix = CeresSearch.parseInput(input)
        val directions = listOf(Pair(0, 1), Pair(0, -1), Pair(1, 0), Pair(-1, 0), Pair(-1, 1), Pair(-1, -1), Pair(1, 1), Pair(1, -1))

        val count = CeresSearch.countWordInMatrix(matrix, "XMAS", directions)

        assertEquals(18, count)
    }
}
