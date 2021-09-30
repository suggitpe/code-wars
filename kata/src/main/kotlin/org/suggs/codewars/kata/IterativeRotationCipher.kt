package org.suggs.codewars.kata

/**
Encoding and decoding are done by performing a series of character and substring rotations on a string input.

Encoding: The number of rotations is determined by the value of n. The sequence of rotations is applied in the following order:
Step 1: remove all spaces in the string (but remember their positions)
Step 2: shift the order of characters in the new string to the right by n characters
Step 3: put the spaces back in their original positions
Step 4: shift the characters of each substring (separated by one or more consecutive spaces) to the right by n
Repeat this process until it has been completed n times in total.
The value n is then prepended to the resulting string with a space.

Decoding: Decoding simply reverses the encoding process.
 */
object IterativeRotationCipher {
    fun encode(rotations: Int, text: String): String {
        fun performManyRotationsOn(times: Int, text: String): String {
            return when (times) {
                0 -> text
                else -> performManyRotationsOn(times - 1, performSingleRotationOn(rotations, text))
            }
        }
        return rotations.toString() + " " + performManyRotationsOn(rotations, text)
    }

    fun decode(cipher: String): String {
        val splitOfRotationsAndTest = cipher.split(" ", limit = 2)

        fun performManyRotationsOn(times: Int, text: String): String {
            return when (times) {
                0 -> text
                else -> performManyRotationsOn(times - 1, unwindSingleRotationOn(splitOfRotationsAndTest.first().toInt(), text))
            }
        }

        return performManyRotationsOn(splitOfRotationsAndTest.first().toInt(), splitOfRotationsAndTest.last())
    }

    fun unwindSingleRotationOn(rotations: Int, text: String): String {
        val spaces = createIndexOfSpaceCharsFrom(text)
        return text.split(" ")
            .map { shiftCharacterOrderLeftBy(it, rotations) }
            .joinToString("")
            .let { shiftCharacterOrderLeftBy(it, rotations) }
            .let { insertSpacesInto(it, spaces) }
    }

    fun shiftCharacterOrderLeftBy(textToShift: String, number: Int): String {
        if (textToShift.length < 2) return textToShift
        return when (number) {
            0 -> textToShift
            else -> shiftCharacterOrderLeftBy(textToShift.drop(1) + textToShift.first(), number - 1)
        }
    }

    fun performSingleRotationOn(rotations: Int, text: String): String {
        val spaces = createIndexOfSpaceCharsFrom(text)
        return text.filterNot { it == ' ' }
            .let { shiftCharacterOrderRightBy(it, rotations) }
            .let { insertSpacesInto(it, spaces) }
            .split(' ')
            .map { shiftCharacterOrderRightBy(it, rotations) }
            .joinToString(separator = " ")
    }

    fun shiftCharacterOrderRightBy(textToShift: String, number: Int): String {
        if (textToShift.length < 2) return textToShift
        return when (number) {
            0 -> textToShift
            else -> shiftCharacterOrderRightBy(textToShift.last() + textToShift.dropLast(1), number - 1)
        }
    }

    fun createIndexOfSpaceCharsFrom(text: String) = text.mapIndexed { index, char -> Pair(index, char) }.toMap().filter { it.value == ' ' }.keys

    fun insertSpacesInto(text: String, indexOfSpaces: Set<Int>): String {
        fun insertSpacesInto(text: StringBuilder, indexOfSpaces: Set<Int>): StringBuilder {
            return when (indexOfSpaces.size) {
                0 -> text
                else -> insertSpacesInto(text.insert(indexOfSpaces.first(), ' '), indexOfSpaces.drop(1).toSet())
            }
        }
        return insertSpacesInto(StringBuilder(text), indexOfSpaces).toString()
    }
}
