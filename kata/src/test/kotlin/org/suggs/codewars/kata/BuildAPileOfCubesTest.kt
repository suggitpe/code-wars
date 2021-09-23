package org.suggs.codewars.kata

import io.kotest.assertions.assertSoftly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.suggs.codewars.kata.BuildAPileOfCubes.findNb

class BuildAPileOfCubesTest {

    @Test
    fun `counts the number of cube layers in a cube pile`(){
        assertSoftly {
            findNb(1) shouldBe 1
            findNb(9) shouldBe 2
            findNb(36) shouldBe 3
            findNb(1071225) shouldBe 45
            findNb(6132680780625) shouldBe 2225
        }
    }

    @Test
    fun `identifies when the number of cubes does not match a valid number of levels`(){
        assertSoftly {
            findNb(2) shouldBe -1
            findNb(56396345062501) shouldBe -1
            findNb(28080884739601) shouldBe -1
            findNb(91716553919377) shouldBe -1
        }
    }
}