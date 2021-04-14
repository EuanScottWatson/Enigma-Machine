class EnigmaMachine(plugboardSettings: String, rotorWheels: String) {

    private val rotorNames = mutableListOf<String>("I", "II", "III", "IV", "V", "VI", "VII", "VIII")

    private val plugboard: Plugboard = Plugboard(plugboardSettings)
    private val rightRotor: Rotor
    private val middleRotor: Rotor
    private val leftRotor: Rotor

    init {

        val names = rotorWheels.split(" ")
        assert(names.size == 3)
        names.forEach { assert(rotorNames.contains(it)) }

        rightRotor = Rotor(names[0])
        middleRotor = Rotor(names[1])
        leftRotor = Rotor(names[2])

    }

}