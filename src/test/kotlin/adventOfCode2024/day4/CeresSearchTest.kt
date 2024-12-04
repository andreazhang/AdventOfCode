package adventOfCode2024.day4

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.fail

class CeresSearchTest {
    @Test
    fun `test`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day4/basic.txt")?.readText() ?: fail()

        val result = CeresSearch.test(input)

        assertEquals(0, result)
    }
}
