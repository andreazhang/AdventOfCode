package adventOfCode2024.day5

class PrintQueue {
    companion object {
        fun parse(input: String): SafetyManual {
            val rules =
                input
                    .split("\r\n\r\n")[0]
                    .split("\r\n")
                    .map { it.split("|") }
                    .map { Pair(it[0].toInt(), it[1].toInt()) }
                    .groupBy({ it.first }, { it.second })
            val updates =
                input
                    .split("\r\n\r\n")[1]
                    .split("\r\n")
                    .map { update -> update.split(",").map { it.toInt() } }

            return SafetyManual(rules, updates)
        }

        fun validateRule(rules: Map<Int, List<Int>>, update: List<Int>): Boolean {
            for ((index, page) in update.withIndex()) {
                update.subList(0, index).forEach {
                    if (rules[page]?.contains(it) == true) {
                        return false
                    }
                }
            }

            return true
        }
    }

    class SafetyManual(
        val rules: Map<Int, List<Int>>,
        val updates: List<List<Int>>,
    ) {
        fun getAllValidUpdates(): List<List<Int>> {
            return updates.filter { validateRule(rules, it) }
        }
    }
}
