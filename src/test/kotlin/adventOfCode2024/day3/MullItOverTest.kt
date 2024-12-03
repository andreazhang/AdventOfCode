package adventOfCode2024.day3

import adventOfCode2024.day.MullItOver
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.fail

class MullItOverTest {
    @Test
    fun `parse input`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day3/basic.txt")?.readText() ?: fail()

        val result = MullItOver.parse(input)

        assertEquals(0, result)
    }
}
