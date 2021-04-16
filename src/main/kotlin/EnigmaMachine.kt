class EnigmaMachine(plugboardSettings: String, rotorWheels: String, reflector: String, ring: List<Int>, rotorStart: List<Int>) {

    private val rotorNames = mutableListOf<String>("I", "II", "III", "IV", "V", "VI", "VII", "VIII")

    private val plugboard: Plugboard = Plugboard(plugboardSettings)

    private val rightRotor: Rotor
    private val middleRotor: Rotor
    private val leftRotor: Rotor

    private val reflector: Reflector = Reflector(reflector)

    companion object {
        private const val A = 65
    }

    init {

        val names = rotorWheels.split(" ")
        assert(names.size == 3)
        names.forEach { assert(rotorNames.contains(it)) }

        rightRotor = Rotor(names[0], rotorStart[0],  ring[0])
        middleRotor = Rotor(names[1], rotorStart[1],  ring[1])
        leftRotor = Rotor(names[2], rotorStart[2],  ring[2])

    }

    private fun rotateRotors() {
        // Work left to right to make sure notches aren't missed
        if (middleRotor.atNotch()) {
            leftRotor.turn()
        }
        if (rightRotor.atNotch()) {
            middleRotor.turn()
        }
        rightRotor.turn()
    }

    private fun forward(c: Int): Int {
        rotateRotors()
        val cP = plugboard.encode(c)

        val cR1 = rightRotor.forward(cP)
        val cR2 = middleRotor.forward(cR1)
        val cR3 = leftRotor.forward(cR2)

        val cRR = reflector.reflect(cR3)

        val cR4 = leftRotor.forward(cRR)
        val cR5 = middleRotor.forward(cR4)
        val cR6 = rightRotor.forward(cR5)

        val cFinal = plugboard.encode(cR6)

        return cFinal
    }

    fun encodeString(string: String): String {
        val encrypted: MutableList<Char> = mutableListOf()
        for (letter in string) {
            encrypted.add((forward(letter.toInt() - A) + A).toChar())
        }
        return encrypted.joinToString(separator = "")
    }

}