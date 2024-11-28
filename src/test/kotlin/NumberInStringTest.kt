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

        assertEquals(number, 1)
    }

    @Test
    fun `find first number in middle of text`() {
        val text = "asd2f"

        val number = findFirstNumberInText(text)

        assertEquals(number, 2)
    }

    @Test
    fun `return 0 if no number found in text`() {
        val text = "asdf"

        val number = findFirstNumberInText(text)

        assertEquals(number, 0)
    }

    @Test
    fun `find last number in text`() {
        val text = "asdf1"

        val number = findLastNumberInText(text)

        assertEquals(number, 1)
    }

    @Test
    fun `find last number in middle of text`() {
        val text = "asd2f"

        val number = findFirstNumberInText(text)

        assertEquals(number, 2)
    }

    @Test
    fun `return 0 if no number found in text in reverse`() {
        val text = "asdf"

        val number = findFirstNumberInText(text)

        assertEquals(number, 0)
    }

    @Test
    fun `calculate the sum of the first and last number in text return 0`() {
        val text = "asdf"

        val number = funSumFirstAndLastDigit(text)

        assertEquals(number, 0)
    }

    @Test
    fun `calculate the sum of the first and last number in text return sum`() {
        val text = "1as2df"

        val number = funSumFirstAndLastDigit(text)

        assertEquals(number, 3)
    }

    @Test
    fun `calculate the sum of the first and last number in text single digit`() {
        val text = "asdf4"

        val number = funSumFirstAndLastDigit(text)

        assertEquals(number, 8)
    }

    @Test
    fun `get the first and last number in text as a single number`() {
        val text = "1a2sd3f4"

        val number = funGetFirstAndLastDigit(text)

        assertEquals(number, 14)
    }

    @Test
    fun `get the first and last number in text as a single number single digit`() {
        val text = "as2df"

        val number = funGetFirstAndLastDigit(text)

        assertEquals(number, 22)
    }

    @Test
    fun `get the first and last number in text as a single number no digit`() {
        val text = "asdf"

        val number = funGetFirstAndLastDigit(text)

        assertEquals(number, 0)
    }

    @Test
    fun `convert all number as text to number as digit`() {
        val text = "one"

        val number = funConvertToNumber(text)

        assertEquals(number, "1")
    }

    @Test
    fun `convert all number as text to number as digit 22`() {
        val text = "twotwo"

        val number = funConvertToNumber(text)

        assertEquals(number, "22")
    }

    @Test
    fun `convert all number as text to number as digit 345`() {
        val text = "three3four4five5"

        val number = funConvertToNumber(text)

        assertEquals(number, "334455")
    }

    @Test
    fun `convert all number as text to number as digit 6789`() {
        val text = "6sixseven7asdf8eight99ninine9"

        val number = funConvertToNumber(text)

        assertEquals(number, "6677asdf8899ni99")
    }
}
