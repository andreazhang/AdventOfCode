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
        val input = arrayOf(1, 2, 5)

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
        val input = arrayOf(8, 7, 4)

        val valid = RedNosedReports.validateReport(input)

        assertTrue(valid)
    }

    @Test
    fun `check report is invalid if some numbers are not decreasing and some are`() {
        val input = arrayOf(3, 2, 2)

        val valid = RedNosedReports.validateReport(input)

        assertFalse(valid)
    }

    @Test
    fun `check report is invalid if some numbers are increasing by more than 3`() {
        val input = arrayOf(1, 2, 6)

        val valid = RedNosedReports.validateReport(input)

        assertFalse(valid)
    }

    @Test
    fun `check report is invalid if some numbers are decreasing by more than 3`() {
        val input = arrayOf(9, 8, 4)

        val valid = RedNosedReports.validateReport(input)

        assertFalse(valid)
    }

    @Test
    fun `validate basic reports`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day2/basic.txt")?.readText() ?: fail()
        val reports = RedNosedReports.parse(input)

        val validReportCount = RedNosedReports.validateReports(reports).count { it }

        assertEquals(2, validReportCount)
    }

    @Test
    fun `validate full reports`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day2/full.txt")?.readText() ?: fail()
        val reports = RedNosedReports.parse(input)

        val validReportCount = RedNosedReports.validateReports(reports).count { it }

        assertEquals(526, validReportCount)
    }

    @Test
    fun `Problem Dampener - report is valid if removing a level makes it safe`() {
        val input = arrayOf(1, 3, 2, 4, 5)

        val valid = RedNosedReports.validateReportWithDampener(input)

        assertTrue(valid)
    }

    @Test
    fun `Problem Dampener - report is valid if removing a level makes it safe 2`() {
        val input = arrayOf(8, 6, 4, 4, 1)

        val valid = RedNosedReports.validateReportWithDampener(input)

        assertTrue(valid)
    }

    @Test
    fun `Problem Dampener - report is invalid if removing a level does not make it safe`() {
        val input = arrayOf(1, 2, 7, 8, 9)

        val valid = RedNosedReports.validateReportWithDampener(input)

        assertFalse(valid)
    }

    @Test
    fun `Problem Dampener - validate full reports`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day2/full.txt")?.readText() ?: fail()
        val reports = RedNosedReports.parse(input)

        val validReportCount = RedNosedReports.validateReportsDampener(reports).count { it }

        assertEquals(526, validReportCount)
    }
}
