class Rotor(private val rotorName: String, private var rotorPos: Int, private var notchPos: Int, private var ringPos: Int) {

    private val rotorMapping = createRotorMap()

    private val forward: MutableList<Int> = decodeRotor(rotorName)
    private val backward = forward.reversed() as MutableList<Int>

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

    private fun decodeRotor(name: String): MutableList<Int> {
        val wiring = mutableListOf<Int>()
        val string = rotorMapping[name]
        assert(string != null)
        for (letter in string!!) {
            wiring.add(letter.toInt() - A)
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