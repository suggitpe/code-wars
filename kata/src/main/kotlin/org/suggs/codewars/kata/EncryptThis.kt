package org.suggs.codewars.kata

object EncryptThis {

    fun encryptThis(text: String): String {
        fun swapSecondAndLastCharacters(text: String): String {
            return if (text.length < 3)
                text
            else {
                text.first() + text.last().toString() + text.substring(2, text.length - 1) + text.toCharArray()[1]
            }
        }

        fun encrypt(wordToEncrypt: String) = swapSecondAndLastCharacters(wordToEncrypt).replaceFirstChar { it.code.toInt().toString() }

        return text.split(" ").map { encrypt(it) }.joinToString(separator = " ")
    }

    fun decryptThis(text: String): String {

        fun decrypt(encryptedText: String): String {

            fun extractFirstCharacterFrom(encryptedWord: String): Char = encryptedWord.filter { it.isDigit() }.toInt().toChar()

            fun removeDigitsFrom(encryptedText: String) = encryptedText.filter { !it.isDigit() }

            fun swapFirstAndLastCharactersFrom(text: String) = text.drop(1).takeLast(1) + text.drop(1).dropLast(1) + text.take(1)

            return extractFirstCharacterFrom(encryptedText) + swapFirstAndLastCharactersFrom(removeDigitsFrom(encryptedText))
        }

        return text.split(" ").map { decrypt(it) }.joinToString(separator = " ")
    }


}