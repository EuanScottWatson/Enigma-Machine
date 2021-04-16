class Reflector(choice: String) {

    companion object {
        private const val A = 65
    }

    private val wiring: MutableList<Int> = when (choice) {
        "A" -> decodeReflector("EJMZALYXVBWFCRQUONTSPIKHGD")
        "B" -> decodeReflector("YRUHQSLDPXNGOKMIEBFZCWVJAT")
        "C" -> decodeReflector("FVPJIAOYEDRZXWGCTKUQSBNMHL")
        else -> decodeReflector("ABCDEFGHIJKLMNOPQRSTUVWXYZ".reversed())
    }

    private fun decodeReflector(string: String): MutableList<Int> {
        val wiring = mutableListOf<Int>()
        for (letter in string) {
            wiring.add(letter.toInt() - A)
        }

        return wiring
    }

    private fun reflect(c: Int): Int {
        return this.wiring[c]
    }

    fun getWiring(): MutableList<Int> {
        return wiring
    }

}