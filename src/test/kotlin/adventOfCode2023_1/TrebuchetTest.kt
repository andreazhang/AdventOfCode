package adventOfCode2023_1

import org.example.adventOfCode2023_1.Trebuchet
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.fail

class TrebuchetTest {

    @Test
    fun `get calibration value from single line`() {
        val input = TrebuchetTest::class.java.getResource("numberInString/oneline.txt")?.readText() ?: fail("No oneline.txt file found")

        val sum = Trebuchet.calibrateValue(input)

        assertEquals(3, sum)
    }
}