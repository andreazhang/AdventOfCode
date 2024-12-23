package adventOfCode2024.day3

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.test.assertEquals
import kotlin.test.fail

class MullItOverTest {
    @Test
    fun `parse input basic`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day3/basic.txt")?.readText() ?: fail()

        val result = MullItOver.findAllMulOperations(input)

        assertAll(
            { assertEquals("mul(2,4)", result[1]) },
            { assertEquals("mul(5,5)", result[29]) },
            { assertEquals("mul(11,8)", result[53]) },
            { assertEquals("mul(8,5)", result[62]) },
        )
    }

    @Test
    fun `extract valid mul operation from text`() {
        val input = "xmul(2,4)%"

        val result = MullItOver.findAllMulOperations(input)

        assertEquals("mul(2,4)", result[1])
    }

    @Test
    fun `extract all valid mul operation from middle text`() {
        val input = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul"

        val result = MullItOver.findAllMulOperations(input)

        assertEquals("mul(2,4)", result[1])
        assertEquals("mul(5,5)", result[29])
    }

    @Test
    fun `calculate total by adding the multiplication of each mul operation basic`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day3/basic.txt")?.readText() ?: fail()
        val mulOperations = MullItOver.findAllMulOperations(input)

        val total = MullItOver.calculateTotal(mulOperations.values.toList())

        assertEquals(161, total)
    }

    @Test
    fun `calculate total by adding the multiplication of each mul operation full`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day3/full.txt")?.readText() ?: fail()
        val mulOperations = MullItOver.findAllMulOperations(input)

        val total = MullItOver.calculateTotal(mulOperations.values.toList())

        assertEquals(183_788_984, total)
    }

    @Test
    fun `get indexes of all don't() operations`() {
        val input = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"

        val result = MullItOver.findAllDontOperations(input)

        assertEquals(20, result.keys.first())
    }

    @Test
    fun `get indexes of all do() operations`() {
        val input = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"

        val result = MullItOver.findAllDoOperations(input)

        assertEquals(59, result.keys.first())
    }

    @Test
    fun `filter all do operations`() {
        val input = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"
        val dontOperations = MullItOver.findAllDontOperations(input)
        val doOperations = MullItOver.findAllDoOperations(input)
        val mulOperations = MullItOver.findAllMulOperations(input)

        val onlyDoOperations =
            MullItOver.filterOnlyDoOperations(
                mulOperations.plus(dontOperations).plus(doOperations).toSortedMap(),
            )

        assertAll(
            { assertEquals("mul(2,4)", onlyDoOperations[0]) },
            { assertEquals("mul(8,5)", onlyDoOperations[1]) },
        )
    }

    @Test
    fun `calculate total for only do operations basic`() {
        val input = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"
        val dontOperations = MullItOver.findAllDontOperations(input)
        val doOperations = MullItOver.findAllDoOperations(input)
        val mulOperations = MullItOver.findAllMulOperations(input)
        val onlyDoOperations =
            MullItOver.filterOnlyDoOperations(
                mulOperations.plus(dontOperations).plus(doOperations).toSortedMap(),
            )

        val total = MullItOver.calculateTotal(onlyDoOperations)

        assertEquals(48, total)
    }

    @Test
    fun `calculate total for only do operations full`() {
        val input =
            this::class.java.getResource("/adventOfCode2024/day3/full.txt")?.readText() ?: fail()
        val dontOperations = MullItOver.findAllDontOperations(input)
        val doOperations = MullItOver.findAllDoOperations(input)
        val mulOperations = MullItOver.findAllMulOperations(input)
        val onlyDoOperations =
            MullItOver.filterOnlyDoOperations(
                mulOperations.plus(dontOperations).plus(doOperations).toSortedMap(),
            )

        val total = MullItOver.calculateTotal(onlyDoOperations)

        assertEquals(62_098_619, total)
    }
}
