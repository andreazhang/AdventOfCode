package adventOfCode2023.day1

import adventOfCode2023.day1.Trebuchet.Companion.calibrateAdvancedValue
import adventOfCode2023.day1.Trebuchet.Companion.calibrateValue
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.fail

class TrebuchetTest {
    @Test
    fun `get calibration value from single line`() {
        val input =
            TrebuchetTest::class.java.getResource("/adventOfCode2023/day1/oneline.txt")?.readText()
                ?: fail("No oneline_with_letter.txt file found")

        val sum = calibrateValue(input)

        assertEquals(12, sum)
    }

    @Test
    fun `get calibration value from basic file with 4 lines`() {
        val input =
            TrebuchetTest::class.java.getResource("/adventOfCode2023/day1/basic.txt")?.readText()
                ?: fail("No file found")

        val sum = calibrateValue(input)

        assertEquals(142, sum)
    }

    @Test
    fun `get calibration value from basic file with full input`() {
        val input =
            TrebuchetTest::class.java.getResource("/adventOfCode2023/day1/full.txt")?.readText()
                ?: fail("No file found")

        val sum = calibrateValue(input)

        assertEquals(55_208, sum)
    }

    @Test
    fun `get calibration value from advanced file with one line`() {
        val input =
            TrebuchetTest::class
                .java
                .getResource("/adventOfCode2023/day1/oneline_with_letter.txt")
                ?.readText() ?: fail("No file found")

        val sum = calibrateAdvancedValue(input)

        assertEquals(29, sum)
    }

    @Test
    fun `get calibration value from advanced file with a few line`() {
        val input =
            TrebuchetTest::class
                .java
                .getResource("/adventOfCode2023/day1/basic_with_letter.txt")
                ?.readText() ?: fail("No file found")

        val sum = calibrateAdvancedValue(input)

        assertEquals(281, sum)
    }

    @Test
    fun `get calibration value from advanced file with full lines`() {
        val input =
            TrebuchetTest::class.java.getResource("/adventOfCode2023/day1/full.txt")?.readText()
                ?: fail("No file found")

        val sum = calibrateAdvancedValue(input)

        assertEquals(54_578, sum)
    }
}
