package adventOfCode2024.day7

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import kotlin.test.fail

class BridgeRepairTest {
    @Test
    fun `parse input`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day7/basic.txt")?.readText() ?: fail()

        val calibrationEquations = BridgeRepair.parseInput(input)

        assertEquals(9, calibrationEquations.operations.size)
        assertEquals(190.0, calibrationEquations.operations.keys.first())
        assertEquals(listOf(11, 6, 16, 20), calibrationEquations.operations.values.last())
    }

    @Test
    fun `operation is valid if it's the sum of the values`() {
        val total = 29.0
        val values = listOf(10, 19)

        val isValid = BridgeRepair.isValidOperation(total, values)

        assertTrue(isValid)
    }

    @Test
    fun `operation is valid if it's the multiplication of the values`() {
        val total = 190.0
        val values = listOf(10, 19)

        val isValid = BridgeRepair.isValidOperation(total, values)

        assertTrue(isValid)
    }

    @Test
    fun `operation is valid if it's the mixture of sum and multiplication of the values`() {
        val total = 191.0
        val values = listOf(10, 19, 1)

        val isValid = BridgeRepair.isValidOperation(total, values)

        assertTrue(isValid)
    }

    @Test
    fun `operation is not valid if it's not the mixture of sum and multiplication of the values`() {
        val total = 192.0
        val values = listOf(10, 19, 1)

        val isValid = BridgeRepair.isValidOperation(total, values)

        assertFalse(isValid)
    }

    @Test
    fun `calculate total calibration result by sum of all valid operations basic`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day7/basic.txt")?.readText() ?: fail()
        val calibrationEquations = BridgeRepair.parseInput(input)

        val total = BridgeRepair.calculateTotalCalibrationResult(calibrationEquations.operations)

        assertEquals(3749, total.toLong())
    }

    @Test
    fun `calculate total calibration result by sum of all valid operations full`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day7/full.txt")?.readText() ?: fail()
        val calibrationEquations = BridgeRepair.parseInput(input)

        val total = BridgeRepair.calculateTotalCalibrationResult(calibrationEquations.operations)

        assertEquals(21572148763543, total.toLong())
    }
}
