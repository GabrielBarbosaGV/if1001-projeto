package br.ufpe.cin.if1001.util.activities.sequence.string.generation.random

fun List<String>.withLastAs(name: String): List<String> {
    return this + listOf(name)
}

fun List<String>.commaJoin(): String {
    return this.joinToString(", ")
}

class Generator(private val possibleActivityNames: List<String>) {

    companion object {
        private const val amountBelowOneErrorMessage = "Número de quantidade menor do que um fornecido," +
                " quando maior ou igual a um é necessário"

        private const val emptyPossibilityListErrorMessage = "Lista com possíveis nomes de activities" +
                " não pode estar vazia"
    }

    init {
        if (possibleActivityNames.isEmpty())
            throw IllegalArgumentException(emptyPossibilityListErrorMessage)
    }

    fun generateForAmount(amount: Int): List<String> {
        if (amount < 1) throw IllegalArgumentException(amountBelowOneErrorMessage)

        return (1..amount).map { possibleActivityNames.random() }
    }
}