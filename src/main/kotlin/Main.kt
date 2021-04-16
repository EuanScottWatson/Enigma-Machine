
fun main(args: Array<String>) {
    val enigmaMachine = EnigmaMachine("bq cr di ej kw mt os px uz gh".toUpperCase(), "I II III", "B", listOf(0, 0, 0), listOf(0, 0, 0))
    println(enigmaMachine.encodeString("HELLOTOMYWORLD"))
}