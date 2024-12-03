package adventOfCode2024.day3

class MullItOver {
    companion object {
        private val pattern = """mul\(\d{1,3},\d{1,3}\)""".toRegex()

        fun findAllMulOperations(input: String): List<String> {
            return pattern.findAll(input).map { it.value }.toList()
        }

        fun calculateTotal(mulOperations: List<String>): Int {
            return mulOperations
                .map { it.substring(4, it.length - 1) }
                .map { it.split(",") }
                .map { it.map { num -> num.toInt() } }
                .sumOf { it[0] * it[1] }
        }
    }
}
