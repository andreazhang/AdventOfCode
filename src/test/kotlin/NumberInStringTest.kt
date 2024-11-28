import org.example.NumberInString
import org.junit.jupiter.api.Test;
import kotlin.test.assertEquals

class NumberInStringTest {

    @Test
    fun `find first number in text`() {
        val text = "1asdf"

        val number = NumberInString.findFirstNumberInText(text)

        assertEquals(number, 1)
    }
}
