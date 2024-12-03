package adventOfCode2024.day3

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.fail

class MullItOverTest {
    @Test
    fun `parse input`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day3/basic.txt")?.readText() ?: fail()

        val result = MullItOver.findAllMulOperations(input)

        assertEquals("mul(2,4)", result[0])
        assertEquals("mul(5,5)", result[1])
        assertEquals("mul(11,8)", result[2])
        assertEquals("mul(8,5)", result[3])
    }

    @Test
    fun `extract valid mul operation from text`() {
        val input = "xmul(2,4)%"

        val result = MullItOver.findAllMulOperations(input)

        assertEquals("mul(2,4)", result[0])
    }

    @Test
    fun `extract all valid mul operation from middle text`() {
        val input = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul"

        val result = MullItOver.findAllMulOperations(input)

        assertEquals("mul(2,4)", result[0])
        assertEquals("mul(5,5)", result[1])
    }
}
