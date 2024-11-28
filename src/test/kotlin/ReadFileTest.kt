import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ReadFileTest {

    @Test
    fun `read file from resources`() {
        val textFromResources = ReadFileTest::class.java.getResource("test.txt")?.readText()

        assertEquals("Hello K", textFromResources)
    }
}