package adventOfCode2024.day2

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
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
}
