package org.suggs.codewars.kata

object Multiples {

    fun findMultiplesFromARangeEndingWith(rangeMax: Int): Int {
        return (1 until rangeMax).filter { i -> i % 5 == 0 || i % 3 == 0 }.sum()
    }
}