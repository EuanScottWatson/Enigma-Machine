class Rotor(private val rotorName: String, private val rotorPos: Int = 0) {

    private val rotorMapping = createRotorMap()

    private val wiring: MutableList<Int> = decodeRotor(rotorName)

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

    fun getWiring(): MutableList<Int> {
        return wiring
    }

}