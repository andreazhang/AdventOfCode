package adventOfCode2024.day7

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.fail

class BridgeRepairTest {
    @Test
    fun `parse input`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day7/basic.txt")?.readText() ?: fail()

        val calibrationEquations = BridgeRepair.parseInput(input)

        assertEquals(9, calibrationEquations.operations.size)
        assertEquals(190, calibrationEquations.operations.keys.first())
    }
}
