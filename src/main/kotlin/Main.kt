
fun main(args: Array<String>) {
    val plugboard = Plugboard("AB CD EF ZX YW")
    val rotor1 = Rotor("I", 0)
    println(plugboard.getWiring())
    println(rotor1.getWiring())
}