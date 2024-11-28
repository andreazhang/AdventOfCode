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
            var newText = ""
            var i = 0
            while (i < text.length) {
                try {
                    when {
                        text[i] == 'o' && text[i+1] == 'n' && text[i+2] == 'e' -> {
                            newText += "1"
                            i +=3
                        }
                        text[i] == 't' && text[i+1] == 'w' && text[i+2] == 'o' -> {
                            newText += "2"
                            i +=3
                        }
                        text[i] == 't' && text[i+1] == 'h' && text[i+2] == 'r' && text[i+3] == 'e' && text[i+4] == 'e' -> {
                            newText += "3"
                            i +=5
                        }
                        text[i] == 'f' && text[i+1] == 'o' && text[i+2] == 'u' && text[i+3] == 'r' -> {
                            newText += "4"
                            i +=4
                        }
                        text[i] == 'f' && text[i+1] == 'i' && text[i+2] == 'v' && text[i+3] == 'e' -> {
                            newText += "5"
                            i +=4
                        }
                        text[i] == 's' && text[i+1] == 'i' && text[i+2] == 'x' -> {
                            newText += "6"
                            i +=3
                        }
                        text[i] == 's' && text[i+1] == 'e' && text[i+2] == 'v' && text[i+3] == 'e' && text[i+4] == 'n' -> {
                            newText += "7"
                            i +=5
                        }
                        text[i] == 'e' && text[i+1] == 'i' && text[i+2] == 'g' && text[i+3] == 'h' && text[i+4] == 't' -> {
                            newText += "8"
                            i +=5
                        }
                        text[i] == 'n' && text[i+1] == 'i' && text[i+2] == 'n' && text[i+3] == 'e' -> {
                            newText += "9"
                            i +=4
                        }
                        else -> {
                            newText += text[i]
                            i++
                        }
                    }
                } catch (e: StringIndexOutOfBoundsException) {
                    newText += text[i]
                    i++
                }

            }
            newText
        }
    }
}
