
fun main(args: Array<String>) {
    val enigmaMachine = EnigmaMachine("AD", "I II III", "B", listOf(0, 0, 0), listOf(0, 0, 0))
    println(enigmaMachine.encodeString("AAAAA"))
}