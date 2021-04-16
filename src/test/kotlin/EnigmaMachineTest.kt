import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EnigmaMachineTest {

    @Test
    fun testGoogleExample() {
        val enigmaMachine = EnigmaMachine("", "I II III", "B", listOf(0, 0, 0), listOf(0, 0, 0))
        assertEquals(enigmaMachine.encodeString("AAAAA"), "BDZGO")
    }

    @Test
    fun testGoogleDecode() {
        val enigmaMachine = EnigmaMachine("", "I II III", "B", listOf(0, 0, 0), listOf(0, 0, 0))
        assertEquals(enigmaMachine.encodeString("BDZGO"), "AAAAA")
    }

    @Test
    fun testLargeExample() {
        val plaintext = "The Enigma machine is a cipher device developed and used in the early to mid twentieth century to protect commercial diplomatic and military communication"
        var enigmaMachine = EnigmaMachine("AS FE QW JO UL", "IV I III", "B", listOf(0, 0, 0), listOf(0, 0, 0))
        val ciphertext = enigmaMachine.encodeString(plaintext)
        enigmaMachine = EnigmaMachine("AS FE QW JO UL", "IV I III", "B", listOf(0, 0, 0), listOf(0, 0, 0))
        val decodedtext = enigmaMachine.encodeString(ciphertext)
        assertEquals(plaintext.replace(" ", "").toUpperCase(), decodedtext)
    }
}