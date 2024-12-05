package adventOfCode2024.day5

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.fail

class PrintQueueTest {
    @Test
    fun `parse input`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day5/basic.txt")?.readText() ?: fail()

        val safetyManual = PrintQueue.parse(input)

        assertEquals(listOf(53, 13, 61, 29), safetyManual.rules[47])
        assertEquals(listOf(75, 47, 61, 53, 29), safetyManual.updates.first())
    }
}
