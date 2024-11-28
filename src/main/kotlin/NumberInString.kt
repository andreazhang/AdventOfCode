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

        fun findLastNumberInText(text: String): Int {
            for (char in text.reversed()) {
                if (char.isDigit()) {
                    return char.digitToInt()
                }
            }
            return 0
        }

        fun sumFirstAndLastDigit(text: String): Int {
            return findFirstNumberInText(text) + findLastNumberInText(text)
        }
    }
}