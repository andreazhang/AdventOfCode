package adventOfCode2024.day1

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.fail

class HistorianHysteriaTest {
    @Test
    fun `parse basic input`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day1/basic.txt")?.readText() ?: fail()

        val locations = HistorianHysteria.parseInput(input)

        assertEquals(listOf(3, 4, 2, 1, 3, 3), locations.left)
        assertEquals(listOf(4, 3, 5, 3, 9, 3), locations.right)
    }

    @Test
    fun `calculate different between sorted left and sorted right`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day1/basic.txt")?.readText() ?: fail()
        val locations = HistorianHysteria.parseInput(input)

        val differences = HistorianHysteria.calculateDifferenceBetweenLeftAndRight(locations)

        assertEquals(listOf(2, 1, 0, 1, 2, 5), differences)
    }

    @Test
    fun `calculate total distance for basic scenario`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day1/basic.txt")?.readText() ?: fail()
        val locations = HistorianHysteria.parseInput(input)
        val differences = HistorianHysteria.calculateDifferenceBetweenLeftAndRight(locations)

        val total = differences.sum()

        assertEquals(11, total)
    }

    @Test
    fun `calculate total distance for full scenario`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day1/full.txt")?.readText() ?: fail()
        val locations = HistorianHysteria.parseInput(input)
        val differences = HistorianHysteria.calculateDifferenceBetweenLeftAndRight(locations)

        val total = differences.sum()

        assertEquals(1_223_326, total)
    }

    @Test
    fun `calculate occurrences of left locations on right locations with occurrences greater than 0`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day1/basic.txt")?.readText() ?: fail()
        val locations = HistorianHysteria.parseInput(input)

        val occurrences = HistorianHysteria.calculateOccurrences(locations)

        assertEquals(mapOf(Pair(3, 3), Pair(4, 1)), occurrences)
    }

    @Test
    fun `calculate total occurrences basic`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day1/basic.txt")?.readText() ?: fail()
        val locations = HistorianHysteria.parseInput(input)
        val occurrences = HistorianHysteria.calculateOccurrences(locations)

        val total = HistorianHysteria.calculateOccurrencesTotal(locations.left, occurrences)

        assertEquals(31, total)
    }

    @Test
    fun `calculate total occurrences full`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day1/full.txt")?.readText() ?: fail()
        val locations = HistorianHysteria.parseInput(input)
        val occurrences = HistorianHysteria.calculateOccurrences(locations)

        val total = HistorianHysteria.calculateOccurrencesTotal(locations.left, occurrences)

        assertEquals(21_070_419, total)
    }
}
