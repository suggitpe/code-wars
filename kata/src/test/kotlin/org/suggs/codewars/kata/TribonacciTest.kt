package org.suggs.codewars.kata

import io.kotest.assertions.assertSoftly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.suggs.codewars.kata.Tribonacci.tribonacci

class TribonacciTest {

    @Test
    fun `calculates tribonacci for a sensible set of values`() {
        assertSoftly {
            tribonacci(doubleArrayOf(1.0, 1.0, 1.0), 10) shouldBe doubleArrayOf(1.0, 1.0, 1.0, 3.0, 5.0, 9.0, 17.0, 31.0, 57.0, 105.0)
            tribonacci(doubleArrayOf(0.0, 0.0, 1.0), 10) shouldBe doubleArrayOf(0.0, 0.0, 1.0, 1.0, 2.0, 4.0, 7.0, 13.0, 24.0, 44.0)
            tribonacci(doubleArrayOf(0.0, 1.0, 1.0), 10) shouldBe doubleArrayOf(0.0, 1.0, 1.0, 2.0, 4.0, 7.0, 13.0, 24.0, 44.0, 81.0)
        }
    }

    @Test
    fun `builds tribonacci when return set less than three`() {
        assertSoftly {
            tribonacci(doubleArrayOf(0.0, 1.0, 1.0), 3) shouldBe doubleArrayOf(0.0, 1.0, 1.0)
            tribonacci(doubleArrayOf(0.0, 1.0, 1.0), 2) shouldBe doubleArrayOf(0.0, 1.0)
            tribonacci(doubleArrayOf(0.0, 1.0, 1.0), 1) shouldBe doubleArrayOf(0.0)
        }
    }

}