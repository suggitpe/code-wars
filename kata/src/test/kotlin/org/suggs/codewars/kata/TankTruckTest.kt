package org.suggs.codewars.kata

import io.kotest.assertions.assertSoftly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.suggs.codewars.kata.TankTruck.tankVol

class TankTruckTest {

    @Test
    fun `calculates zero volume when height of liquid is zero`() {
        tankVol(0, 100, 3500) shouldBe 0
    }

    @Test
    fun `calculates full when height matches diameter`() {
        tankVol(100, 100, 3500) shouldBe 3500
    }

    @Test
    fun `calculates volume of liquid in the tank`() {
        assertSoftly {
            tankVol(5, 7, 3848) shouldBe 2940
            tankVol(1, 4, 1256) shouldBe 245
            tankVol(40, 120, 3500) shouldBe 1021
            tankVol(60, 120, 3500) shouldBe 1750
            tankVol(80, 120, 3500) shouldBe 2478
        }
    }
}