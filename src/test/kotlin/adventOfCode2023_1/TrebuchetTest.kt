package adventOfCode2023_1

import org.example.adventOfCode2023_1.Trebuchet.Companion.calibrateValue
import org.junit.jupiter.api.Test

import kotlin.test.assertEquals
import kotlin.test.fail

class TrebuchetTest {
    @Test
    fun `get calibration value from single line`() {
        val input =
            TrebuchetTest::class.java.getResource("/adventOfCode2023_1/oneline.txt")?.readText()
                ?: fail("No oneline.txt file found")

        val sum = calibrateValue(input)

        assertEquals(12, sum)
    }

    @Test
    fun `get calibration value from basic file with 4 lines`() {
        val input =
            TrebuchetTest::class.java.getResource("/adventOfCode2023_1/basic.txt")?.readText()
                ?: fail("No basic.txt file found")

        val sum = calibrateValue(input)

        assertEquals(142, sum)
    }

    @Test
    fun `get calibration value from basic file with full input`() {
        val input =
            TrebuchetTest::class.java.getResource("/adventOfCode2023_1/full.txt")?.readText()
                ?: fail("No basic.txt file found")

        val sum = calibrateValue(input)

        assertEquals(55208, sum)
    }
}
