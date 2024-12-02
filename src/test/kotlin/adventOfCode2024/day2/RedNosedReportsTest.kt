package adventOfCode2024.day2

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import kotlin.test.fail

class RedNosedReportsTest {
    @Test
    fun `parse input reports`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day2/basic.txt")?.readText() ?: fail()

        val matrix = RedNosedReports.parse(input)

        assertEquals(7, matrix[0][0])
        assertEquals(2, matrix[1][1])
        assertEquals(9, matrix[5][4])
    }

    @Test
    fun `check report is valid if all numbers are increasing`() {
        val input = arrayOf(1, 2, 3)

        val valid = RedNosedReports.validateReport(input)

        assertTrue(valid)
    }

    @Test
    fun `check report is invalid if some numbers are not increasing`() {
        val input = arrayOf(1, 2, 2)

        val valid = RedNosedReports.validateReport(input)

        assertFalse(valid)
    }

    @Test
    fun `check report is invalid if some numbers increasing and some decreasing`() {
        val input = arrayOf(1, 2, 3, 2, 1)

        val valid = RedNosedReports.validateReport(input)

        assertFalse(valid)
    }

    @Test
    fun `check report is valid if all numbers are decreasing`() {
        val input = arrayOf(3, 2, 1)

        val valid = RedNosedReports.validateReport(input)

        assertTrue(valid)
    }

    @Test
    fun `check report is invalid if some numbers are not decreasing and some are`() {
        val input = arrayOf(3, 2, 2)

        val valid = RedNosedReports.validateReport(input)

        assertFalse(valid)
    }
}
