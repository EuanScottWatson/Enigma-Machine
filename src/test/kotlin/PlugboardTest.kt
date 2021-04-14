import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PlugboardTest {

    @Test
    fun testCreatingWirings() {
        val plugboard = Plugboard("AB CD EF ZX YW")
        val answer = mutableListOf<Int>(1, 0, 3, 2, 5, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 24, 25, 22, 23)
        assertEquals(plugboard.getWiring(), answer)
    }

    @Test
    fun testEncodeDecode() {
        val plugboard = Plugboard("AL FG WE TR PQ")
        assertEquals(plugboard.encode('A'), 'L')
        assertEquals(plugboard.encode('L'), 'A')
        assertEquals(plugboard.encode('E'), 'W')
        assertEquals(plugboard.encode('W'), 'E')
        assertEquals(plugboard.encode('X'), 'X')
        assertEquals(plugboard.encode('Z'), 'Z')

        assertThrows(Error::class.java) { plugboard.encode(-1) }
        assertThrows(Error::class.java) { plugboard.encode('a') }
        assertThrows(Error::class.java) { plugboard.encode(1000) }
    }

    @Test
    fun testBadPlugs() {
        assertThrows(Error::class.java) {
            val plugboard = Plugboard("AA FG WE TR PQ")
        }
    }

}