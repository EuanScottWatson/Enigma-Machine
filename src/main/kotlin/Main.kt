fun main(args: Array<String>) {

    val plugboardValues: String
    val rotorValues: String
    val reflectorValue: String
    val ringValues: MutableList<Int>
    val rotorStartValues: MutableList<Int>

    println("Do you want the default settings? y/n")
    val default = readLine()!!
    if (default.toUpperCase() == "Y") {
        plugboardValues = ""
        rotorValues = "I II III"
        reflectorValue = "B"
        ringValues = mutableListOf(0, 0, 0)
        rotorStartValues = mutableListOf(0, 0, 0)

        println("Enigma Machine Configuration:")
        println("--> Plugboard: ${plugboardValues.toUpperCase()}")
        println("--> Rotor Wheels: $rotorValues")
        println("--> Reflector: $reflectorValue")
        println("--> Ring Values: $ringValues")
        println("--> Rotor Start Positions: $rotorStartValues")
    } else {
        println("Enter plugboard settings as space separated pairs:\n---> ")
        plugboardValues = readLine()!!
        println("Enter rotor selection:\n---> ")
        rotorValues = readLine()!!.toUpperCase()
        println("Enter reflector plate:\n---> ")
        reflectorValue = readLine()!!
        println("Enter ring values:\n---> ")
        val rings = readLine()!!.split(" ")
        ringValues = mutableListOf<Int>()
        rings.forEach { ringValues.add(it.toInt()) }
        println("Enter starting positions:\n---> ")
        val start = readLine()!!.split(" ")
        rotorStartValues = mutableListOf<Int>()
        start.forEach { rotorStartValues.add(it.toInt()) }
    }

    val enigmaMachine = EnigmaMachine(plugboardValues.toUpperCase(), rotorValues, reflectorValue, ringValues, rotorStartValues)

    println("\n---\n")

    while (true) {
        print("Enter plaintext: ")
        val plaintext = readLine()!!
        val ciphertext = enigmaMachine.encodeString(plaintext)
        println("Ciphertext:\n---> $ciphertext")
    }

}