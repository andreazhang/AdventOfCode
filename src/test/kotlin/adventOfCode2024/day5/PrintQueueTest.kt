package adventOfCode2024.day5

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.fail

class PrintQueueTest {
    @Test
    fun `test`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day5/basic.txt")?.readText() ?: fail()

        val result = PrintQueue.test(input)

        assertEquals(0, result)
    }
}
