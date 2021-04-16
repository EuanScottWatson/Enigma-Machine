import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ReflectorTest {

    companion object {
        private const val A = 65
    }

    @Test
    fun checkDefaultCreation() {
        val reflector = Reflector("")
        val wiring = reflector.getWiring()
        for (i in 0..25) {
            assertEquals(wiring[i], 25-i)
        }
    }

    @Test
    fun checkRotorA() {
        // EJMZALYXVBWFCRQUONTSPIKHGD
        val reflector = Reflector("A")
        val wiring = reflector.getWiring()
        assertEquals(wiring[0], 'E'.toInt() - A)
        assertEquals(wiring[3], 'Z'.toInt() - A)
        assertEquals(wiring[25], 'D'.toInt() - A)
    }

    @Test
    fun checkRotorB() {
        // YRUHQSLDPXNGOKMIEBFZCWVJAT
        val reflector = Reflector("B")
        val wiring = reflector.getWiring()
        assertEquals(wiring[0], 'Y'.toInt() - A)
        assertEquals(wiring[3], 'H'.toInt() - A)
        assertEquals(wiring[25], 'T'.toInt() - A)
    }

    @Test
    fun checkRotorC() {
        // FVPJIAOYEDRZXWGCTKUQSBNMHL
        val reflector = Reflector("C")
        val wiring = reflector.getWiring()
        assertEquals(wiring[0], 'F'.toInt() - A)
        assertEquals(wiring[3], 'J'.toInt() - A)
        assertEquals(wiring[25], 'L'.toInt() - A)
    }
}