package adventOfCode2024.day5

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
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

    @Test
    fun `update is valid if page in rule is before all other pages under that rule`() {
        val rule = mapOf(47 to listOf(53, 13, 61, 29))
        val update = listOf(75, 47, 61, 53, 29)

        val valid = PrintQueue.validateRule(rule, update)

        assertTrue(valid)
    }

    @Test
    fun `update is not valid if page in is after any other page under that rule`() {
        val rule = mapOf(47 to listOf(53, 13, 61, 29))
        val update = listOf(29, 75, 47, 61, 53)

        val valid = PrintQueue.validateRule(rule, update)

        assertFalse(valid)
    }
}
