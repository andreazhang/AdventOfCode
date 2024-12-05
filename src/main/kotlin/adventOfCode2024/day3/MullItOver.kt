package adventOfCode2024.day3

class MullItOver {
    companion object {
        private val pattern = """mul\(\d{1,3},\d{1,3}\)""".toRegex()

        fun findAllMulOperations(input: String): Map<Int, String> = pattern.findAll(input).map { Pair(it.range.first, it.value) }.toMap()

        fun calculateTotal(mulOperations: List<String>): Int =
            mulOperations
                .map { it.substring(4, it.length - 1) }
                .map { it.split(",") }
                .map { it.map { num -> num.toInt() } }
                .sumOf { it[0] * it[1] }

        fun findAllDontOperations(input: String): Map<Int, String> {
            val dontPattern = """don't\(\)""".toRegex()
            return dontPattern.findAll(input).map { Pair(it.range.first, it.value) }.toMap()
        }

        fun findAllDoOperations(input: String): Map<Int, String> {
            val doPattern = """do\(\)""".toRegex()
            return doPattern.findAll(input).map { Pair(it.range.first, it.value) }.toMap()
        }

        fun filterOnlyDoOperations(operations: Map<Int, String>): List<String> {
            var add = true

            val onlyDoOperations = mutableListOf<String>()
            operations.forEach { (_, operation) ->
                when (operation) {
                    "don't()" -> add = false
                    "do()" -> add = true
                    else ->
                        if (add) {
                            onlyDoOperations.add(operation)
                        }
                }
            }

            return onlyDoOperations
        }
    }
}
