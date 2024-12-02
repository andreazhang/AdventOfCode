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
}
