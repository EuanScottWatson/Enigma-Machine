
fun main(args: Array<String>) {
    val enigmaMachine = EnigmaMachine("", "I II III", "A", listOf(1, 1, 1))
    println(enigmaMachine.encodeString("AAAAA"))
}