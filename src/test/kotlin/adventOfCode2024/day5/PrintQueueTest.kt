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
        val rules = mapOf(61 to listOf(29), 47 to listOf(53, 13, 61, 29))
        val update = listOf(75, 47, 61, 53, 29)

        val valid = PrintQueue.validateUpdate(rules, update)

        assertTrue(valid)
    }

    @Test
    fun `update is not valid if page in is after any other page under that rule`() {
        val rules = mapOf(61 to listOf(53), 47 to listOf(53, 13, 61, 29))
        val update = listOf(29, 75, 47, 61, 53)

        val valid = PrintQueue.validateUpdate(rules, update)

        assertFalse(valid)
    }

    @Test
    fun `get all valid updates from safety manual`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day5/basic.txt")?.readText() ?: fail()
        val safetyManual = PrintQueue.parse(input)

        val validUpdates = safetyManual.getAllValidUpdates()

        assertEquals(3, validUpdates.size)
        assertEquals(listOf(75, 47, 61, 53, 29), validUpdates.first())
    }

    @Test
    fun `sum middle pages of all valid rules basic`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day5/basic.txt")?.readText() ?: fail()
        val safetyManual = PrintQueue.parse(input)
        val validUpdates = safetyManual.getAllValidUpdates()

        val sum = PrintQueue.sumMiddlePages(validUpdates)

        assertEquals(143, sum)
    }

    @Test
    fun `sum middle pages of all valid rules full`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day5/full.txt")?.readText() ?: fail()
        val safetyManual = PrintQueue.parse(input)
        val validUpdates = safetyManual.getAllValidUpdates()

        val sum = PrintQueue.sumMiddlePages(validUpdates)

        assertEquals(5964, sum)
    }

    @Test
    fun `get all invalid updates from safety manual`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day5/basic.txt")?.readText() ?: fail()
        val safetyManual = PrintQueue.parse(input)

        val invalidUpdates = safetyManual.getAllInvalidUpdates()

        assertEquals(3, invalidUpdates.size)
        assertEquals(listOf(75, 97, 47, 61, 53), invalidUpdates.first())
    }

    @Test
    fun `fix incorrect update`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day5/basic.txt")?.readText() ?: fail()
        val safetyManual = PrintQueue.parse(input)
        val incorrectUpdate = listOf(75, 97, 47, 61, 53)

        val fixedUpdate = PrintQueue.fixIncorrectUpdate(safetyManual.rules, incorrectUpdate)

        assertEquals(listOf(97, 75, 47, 61, 53), fixedUpdate)
    }

    @Test
    fun `fix all incorrect updates`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day5/basic.txt")?.readText() ?: fail()
        val safetyManual = PrintQueue.parse(input)
        val invalidUpdates = safetyManual.getAllInvalidUpdates()

        val fixedUpdates = PrintQueue.fixIncorrectUpdates(safetyManual.rules, invalidUpdates)

        assertEquals(listOf(97, 75, 47, 61, 53), fixedUpdates.first())
        assertEquals(listOf(61, 29, 13), fixedUpdates[1])
        assertEquals(listOf(97, 75, 47, 29, 13), fixedUpdates[2])
    }

    @Test
    fun `sum middle pages of all fixed incorrect updates basic`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day5/basic.txt")?.readText() ?: fail()
        val safetyManual = PrintQueue.parse(input)
        val invalidUpdates = safetyManual.getAllInvalidUpdates()
        val fixedUpdates = PrintQueue.fixIncorrectUpdates(safetyManual.rules, invalidUpdates)

        val sum = PrintQueue.sumMiddlePages(fixedUpdates)

        assertEquals(123, sum)
    }

    @Test
    fun `sum middle pages of all fixed incorrect updates full`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day5/full.txt")?.readText() ?: fail()
        val safetyManual = PrintQueue.parse(input)
        val invalidUpdates = safetyManual.getAllInvalidUpdates()
        val fixedUpdates = PrintQueue.fixIncorrectUpdates(safetyManual.rules, invalidUpdates)

        val sum = PrintQueue.sumMiddlePages(fixedUpdates)

        assertEquals(4719, sum)
    }
}
