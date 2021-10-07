package org.suggs.codewars.kata

import io.kotest.assertions.assertSoftly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.suggs.codewars.kata.Xbonacci.xbonacci

class XbonacciTest {

    @Test
    fun `calculates tribonacci for a sensible set of values`() {
        assertSoftly {
            xbonacci(doubleArrayOf(0.0, 1.0), 10) shouldBe doubleArrayOf(0.0, 1.0, 1.0, 2.0, 3.0, 5.0, 8.0, 13.0, 21.0, 34.0)
            xbonacci(doubleArrayOf(1.0, 1.0), 10) shouldBe doubleArrayOf(1.0, 1.0, 2.0, 3.0, 5.0, 8.0, 13.0, 21.0, 34.0, 55.0)
            xbonacci(doubleArrayOf(0.0, 0.0, 0.0, 0.0, 1.0), 10) shouldBe doubleArrayOf(0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 2.0, 4.0, 8.0, 16.0)
            xbonacci(doubleArrayOf(1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0), 10) shouldBe doubleArrayOf(1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 2.0, 3.0, 6.0)
        }
    }
}