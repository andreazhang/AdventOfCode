package adventOfCode2024.day

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.fail

class TestTest {

    @Test
    fun `test`() {
        val input = this::class.java.getResource("/adventOfCode2024/day/basic.txt")?.readText() ?: fail()

        val result = TestClass.test(input)

        assertEquals(0, result)
    }
}