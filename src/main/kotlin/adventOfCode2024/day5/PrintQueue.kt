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

        fun validateUpdate(rules: Map<Int, List<Int>>, update: List<Int>): Boolean {
            for ((index, page) in update.withIndex()) {
                update.subList(0, index).forEach {
                    if (rules[page]?.contains(it) == true) {
                        return false
                    }
                }
            }

            return true
        }

        fun sumMiddlePages(validUpdates: List<List<Int>>): Int {
            return validUpdates.sumOf { it[it.size / 2] }
        }

        fun fixIncorrectUpdate(rules: Map<Int, List<Int>>, incorrectUpdate: List<Int>): List<Int> {
            //            47=[53, 13, 61, 29],
            //            97=[13, 61, 47, 29, 53, 75],
            //            75=[29, 53, 47, 61, 13],
            //            61=[13, 53, 29],
            //            29=[13],
            //            53=[29, 13]
            // from 75,97,47,61,53
            var update = incorrectUpdate.toMutableList()
            while (!validateUpdate(rules, update)) {
                val pair = findNumbersToSwap(update, rules)
                update.remove(pair.first)
                update.add(update.indexOf(pair.second)+1, pair.first)

            }
            return update
        }

        private fun findNumbersToSwap(
            update: List<Int>,
            rules: Map<Int, List<Int>>
        ): Pair<Int, Int> {
            for ((index, page) in update.withIndex()) {
                update.subList(0, index).forEach { updatePage ->
                    rules[page]?.forEach {
                        if (it == updatePage) {
                            return Pair(it, page)
                        }
                    }
                }
            }
            return Pair(0, 0)
        }
    }

    class SafetyManual(
        val rules: Map<Int, List<Int>>,
        val updates: List<List<Int>>,
    ) {
        fun getAllValidUpdates(): List<List<Int>> {
            return updates.filter { validateUpdate(rules, it) }
        }

        fun getAllInvalidUpdates(): List<List<Int>> {
            return updates.filter { !validateUpdate(rules, it) }
        }
    }
}
