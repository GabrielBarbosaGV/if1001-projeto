package br.ufpe.cin.if1001.util.activities.sequence.string.generation.random

class Generator(private val possibleActivityNames: List<String>) {

    companion object {
        private val amountBelowOneErrorMessage = "Número de quantidade menor do que um fornecido," +
                " quando maior ou igual a um é necessário"

        private val emptyPossibilityListErrorMessage = "Lista com possíveis nomes de activities" +
                " não pode estar vazia"
    }

    init {
        if (possibleActivityNames.isEmpty())
            throw IllegalArgumentException(emptyPossibilityListErrorMessage)
    }

    fun generateForAmount(amount: Int): String {
        if (amount < 1) throw IllegalArgumentException(amountBelowOneErrorMessage)

        return (1..amount).joinToString {
            possibleActivityNames.random()
        }
    }
}