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
        assertEquals(listOf(11, 6, 16, 20), calibrationEquations.operations.values.last())
    }

    @Test
    fun `filter operations that are possible by just adding or multiplying`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day7/basic.txt")?.readText() ?: fail()
        val calibrationEquations = BridgeRepair.parseInput(input)

        val operations = calibrationEquations.getOperationsPossibleByAdditionOrMultiplication()

        assertEquals(5, operations.size)
    }
}
