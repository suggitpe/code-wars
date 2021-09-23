package org.suggs.codewars.kata

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.suggs.codewars.kata.Multiples.findMultiplesFromARangeEndingWith

class MultiplesTest {

    @Test
    fun `finds all multiples of 3 and 5 in number and add them`() {
        findMultiplesFromARangeEndingWith(10) shouldBe 23
    }
}