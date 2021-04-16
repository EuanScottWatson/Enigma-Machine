class Plugboard(connections: String) {


    private val wiring: MutableList<Int>

    companion object {
        private const val A = 65
    }

    init {
        wiring = if (connections == "") {
            identityWirings()
        } else {
            val pieces = connections.split(" ")
            pieces.forEach { assert(it.length == 2) }
            decodeWirings(pieces)
        }
    }

    private fun identityWirings(): MutableList<Int> {
        val wires = mutableListOf<Int>()
        for (i in 0..25) {
            wires.add(i)
        }
        return wires
    }

    private fun decodeWirings(connections: List<String>): MutableList<Int> {
        val wires = identityWirings()
        val usedChars = HashSet<Int>()

        for (pair in connections) {
            val c1 = pair[0].toInt() - A
            val c2 = pair[1].toInt() - A

            when {
                c1 == c2 -> throw Error("Cannot plug into oneself")
                usedChars.contains(c1) -> throw Error("Plug ${pair[0]} already plugged in")
                usedChars.contains(c2) -> throw Error("Plug ${pair[1]} already plugged in")
            }

            usedChars.add(c1)
            usedChars.add(c2)

            wires[c1] = c2
            wires[c2] = c1
        }
        return wires
    }

    fun encode(value: Int): Int {
        assert(value in 0..25)
        return wiring[value]
    }

    fun getWiring(): MutableList<Int> {
        return wiring
    }

}