package adventOfCode2024.day4

class CeresSearch {
    companion object {
        fun parseInput(input: String): Array<Array<Char>> =
            input
                .split("\r\n")
                .map { it.toCharArray().toTypedArray() }
                .toTypedArray()
    }
}
