package org.example

class NumberInString {

    companion object {
        fun findFirstNumberInText(text: String): Int {
            for (char in text) {
                if (char.isDigit()) {
                    return char.digitToInt()
                }
            }
            return 0
        }
    }
}