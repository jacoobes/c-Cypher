import java.util.*

class CCypher(private val shift : Int) {
    private val asciiLetters = ('A'..'Z')
    fun encode(value: String) : String {
        val cypher = value.uppercase(Locale.getDefault()).toList()
        return cypher.map { cAlphabet(shift)[it] ?: ' ' }.joinToString("")
    }
    fun decode(value: String) : String {
        val cypher = value.uppercase(Locale.getDefault()).toList()
        return cypher.map { cAlphabet(-shift)[it] ?: ' '}.joinToString("")
    }
    private fun values(shift: Int): List<Char> {
        val list = asciiLetters.toList()
        Collections.rotate(list, shift)
        return list
    }
    private fun cAlphabet(rotate: Int) : Map<Char, Char> = values(rotate).zip(asciiLetters).toMap()
}

