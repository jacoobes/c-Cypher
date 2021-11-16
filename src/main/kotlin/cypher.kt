import java.util.*

class CCypher(private val shift : Int) {
    private val asciiLetters = ('A'..'Z')
    private val otherChars = setOf('.', '?', '!', '*', ' ') to setOf('.', '?', '!', '*', ' ')
    fun encode(value: String) : String {
        val cypher = value.uppercase(Locale.getDefault()).toList()
        return cypher.map { translate(shift, it) }.joinToString("")
    }
    fun decode(value: String) : String {
        val cypher = value.uppercase(Locale.getDefault()).toList()
        return cypher.map {translate(-shift, it) }.joinToString("")
    }
    private fun values(shift: Int): List<Char> {
        val list = asciiLetters.toList()
        Collections.rotate(list, shift)
        return list
    }

    private fun translate(rotate: Int, char: Char) =
        when (char) {
            '.', '?', '!', '*', ' ' -> otherChars[char]!!
            else -> cAlphabet(rotate)[char]!!
        }

    private infix fun <T,V> Iterable<T>.to(other: Iterable<V>) : Map<T, V> {
        return this.zip(other).toMap()
    }

    private fun cAlphabet(rotate: Int) : Map<Char, Char> = values(rotate) to asciiLetters
}

