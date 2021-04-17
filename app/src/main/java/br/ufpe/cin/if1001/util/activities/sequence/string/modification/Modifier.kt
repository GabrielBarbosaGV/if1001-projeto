package br.ufpe.cin.if1001.util.activities.sequence.string.modification

class Modifier(private val string: String) {
    fun popHead(): PoppedStringWithRest {
        return PoppedStringWithRest(
                string.substringBefore(','),
                string.substringAfter(',').trim()
        )
    }
}