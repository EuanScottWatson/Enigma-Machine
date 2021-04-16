class Rotor(private val rotorName: String, private var rotorPos: Int, private var ringPos: Int) {

    private val rotorMapping = createRotorMap()
    private val notchMapping = createNotchMap()

    private val forward: MutableList<Int> = decodeRotor(rotorName)
    private val backward = backwardsRotor()

    private var notchPos: Int = notchMapping[rotorName] ?: error("Rotor does not exist")

    companion object {
        private const val A = 65
    }

    private fun createRotorMap(): Map<String, String> {
        val map = mutableMapOf<String, String>()

        map["I"] = "EKMFLGDQVZNTOWYHXUSPAIBRCJ"
        map["II"] = "AJDKSIRUXBLHWTMCQGZNPYFVOE"
        map["III"] = "BDFHJLCPRTXVZNYEIWGAKMUSQO"
        map["IV"] = "ESOVPZJAYQUIRHXLNFTGKDCMWB"
        map["V"] = "VZBRGITYUPSDNHLXAWMJQOFECK"
        map["VI"] = "JPGVOUMFYQBENHZRDKASXLICTW"
        map["VII"] = "NZJHGRCXMYSWBOUFAIVLPEKQDT"
        map["VIII"] = "FKQHTLXOCBJSPDZRAMEWNIUYGV"

        return map
    }

    private fun createNotchMap(): Map<String, Int> {
        val map = mutableMapOf<String, Int>()

        map["I"] = 16
        map["II"] = 4
        map["III"] = 21
        map["IV"] = 9
        map["V"] = 25
        map["VI"] = 0
        map["VII"] = 0
        map["VIII"] = 0

        return map
    }

    private fun decodeRotor(name: String): MutableList<Int> {
        val wiring = mutableListOf<Int>()
        val string = rotorMapping[name]
        assert(string != null)
        for (letter in string!!) {
            wiring.add(letter.toInt() - A)
        }

        return wiring
    }

    private fun backwardsRotor(): MutableList<Int> {
        val wiring = mutableListOf<Int>(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
        for (i in 0..25) {
            wiring[forward[i]] = i
        }

        return wiring
    }

    fun encode(input: Int, map: List<Int>): Int {
        val difference = rotorPos - ringPos
        return (map[(input + difference + 26) % 26] - difference + 26) % 26
    }

    fun forward(value: Int): Int {
        return encode(value, forward)
    }

    fun backward(value: Int): Int {
        return encode(value, backward)
    }

    fun turn() {
        this.rotorPos = (this.rotorPos + 1) % 26
    }

    fun atNotch(): Boolean {
        return this.rotorPos == this.notchPos
    }

    fun getWiring(): MutableList<Int> {
        return forward
    }

}