package adventOfCode2024.day6

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.test.assertEquals
import kotlin.test.fail

class GuardGallivantTest {
    @Test
    fun `parse input as matrix`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day6/basic.txt")?.readText() ?: fail()

        val matrix = GuardGallivant.parse(input)

        assertAll(
            { assertEquals('^', matrix[6][6]) },
            { assertEquals('#', matrix[6][1]) }
        )
    }
}
