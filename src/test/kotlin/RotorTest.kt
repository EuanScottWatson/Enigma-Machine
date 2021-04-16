import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RotorTest {

    companion object {
        private const val A = 65
    }

    @Test
    fun checkForwards() {
        // EKMFLGDQVZNTOWYHXUSPAIBRCJ
        val rotor = Rotor("I", 0, 0)
        assertEquals(rotor.forward('A'.toInt() - A), 'E'.toInt() - A)
        assertEquals(rotor.forward('E'.toInt() - A), 'L'.toInt() - A)
        assertEquals(rotor.forward('Z'.toInt() - A), 'J'.toInt() - A)
    }

    @Test
    fun checkBackwards() {
        // EKMFLGDQVZNTOWYHXUSPAIBRCJ
        val rotor = Rotor("I", 0, 0)
        assertEquals(rotor.backward('E'.toInt() - A), 'A'.toInt() - A)
        assertEquals(rotor.backward('L'.toInt() - A), 'E'.toInt() - A)
        assertEquals(rotor.backward('J'.toInt() - A), 'Z'.toInt() - A)
    }
}