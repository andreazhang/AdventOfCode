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

        val funSumFirstAndLastDigit: (text: String) -> Int = { text: String ->
            findFirstNumberInText(text) + findLastNumberInText(text)
        }

        val funGetFirstAndLastDigit: (text: String) -> Int = { text: String ->
            findFirstNumberInText(text) * 10 + findLastNumberInText(text)
        }

        val funConvertToNumber: (text: String) -> String = { text: String ->
            text.replace("one", "1")
                .replace("two", "2")
                .replace("three", "3")
                .replace("four", "4")
                .replace("five", "5")
                .replace("six", "6")
                .replace("seven", "7")
                .replace("eight", "8")
                .replace("nine", "9")
        }
    }
}
