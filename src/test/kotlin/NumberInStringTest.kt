import org.example.NumberInString.Companion.findFirstNumberInText
import org.junit.jupiter.api.Test;
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
}
