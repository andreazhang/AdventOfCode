import org.example.NumberInString.Companion.findFirstNumberInText
import org.example.NumberInString.Companion.findLastNumberInText
import org.example.NumberInString.Companion.funConvertToNumber
import org.example.NumberInString.Companion.funGetFirstAndLastDigit
import org.example.NumberInString.Companion.funSumFirstAndLastDigit
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class NumberInStringTest {
    @Test
    fun `find first number in text`() {
        val text = "1asdf"

        val number = findFirstNumberInText(text)

        assertEquals(1, number)
    }

    @Test
    fun `find first number in middle of text`() {
        val text = "asd2f"

        val number = findFirstNumberInText(text)

        assertEquals(2, number)
    }

    @Test
    fun `return 0 if no number found in text`() {
        val text = "asdf"

        val number = findFirstNumberInText(text)

        assertEquals(0, number)
    }

    @Test
    fun `find last number in text`() {
        val text = "asdf1"

        val number = findLastNumberInText(text)

        assertEquals(1, number)
    }

    @Test
    fun `find last number in middle of text`() {
        val text = "asd2f"

        val number = findFirstNumberInText(text)

        assertEquals(2, number)
    }

    @Test
    fun `return 0 if no number found in text in reverse`() {
        val text = "asdf"

        val number = findFirstNumberInText(text)

        assertEquals(0, number)
    }

    @Test
    fun `calculate the sum of the first and last number in text return 0`() {
        val text = "asdf"

        val number = funSumFirstAndLastDigit(text)

        assertEquals(0, number)
    }

    @Test
    fun `calculate the sum of the first and last number in text return sum`() {
        val text = "1as2df"

        val number = funSumFirstAndLastDigit(text)

        assertEquals(3, number)
    }

    @Test
    fun `calculate the sum of the first and last number in text single digit`() {
        val text = "asdf4"

        val number = funSumFirstAndLastDigit(text)

        assertEquals(8, number)
    }

    @Test
    fun `get the first and last number in text as a single number`() {
        val text = "1a2sd3f4"

        val number = funGetFirstAndLastDigit(text)

        assertEquals(14, number)
    }

    @Test
    fun `get the first and last number in text as a single number single digit`() {
        val text = "as2df"

        val number = funGetFirstAndLastDigit(text)

        assertEquals(22, number)
    }

    @Test
    fun `get the first and last number in text as a single number no digit`() {
        val text = "asdf"

        val number = funGetFirstAndLastDigit(text)

        assertEquals(0, number)
    }

    @Test
    fun `convert all number as text to number as digit 1`() {
        val text = "one"

        val number = funConvertToNumber(text)

        assertEquals("1", number)
    }

    @Test
    fun `convert all number as text to number as digit 22`() {
        val text = "twotwo"

        val number = funConvertToNumber(text)

        assertEquals("22", number)
    }

    @Test
    fun `convert all number as text to number as digit 345`() {
        val text = "three3four4five5"

        val number = funConvertToNumber(text)

        assertEquals("334455", number)
    }

    @Test
    fun `convert all number as text to number as digit 6789`() {
        val text = "6sixseven7asdf8eight99ninine9"

        val number = funConvertToNumber(text)

        assertEquals("6677asdf8899ni99", number)
    }

    @Test
    fun `convert all number as text to number as digit in order 2`() {
        val text = "twone"

        val number = funConvertToNumber(text)

        assertEquals("2ne", number)
    }

    @Test
    fun `convert all number as text to number as digit in order `() {
        val text = "eighthree"

        val number = funConvertToNumber(text)

        assertEquals("83", number)
    }

    @Test
    fun `convert all number as text to number as digit in order exception`() {
        val text = "eone"

        val number = funConvertToNumber(text)

        assertEquals("e1", number)
    }
}
