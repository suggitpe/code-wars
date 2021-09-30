package org.suggs.codewars.kata

import io.kotest.assertions.assertSoftly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.suggs.codewars.kata.IterativeRotationCipher.createIndexOfSpaceCharsFrom
import org.suggs.codewars.kata.IterativeRotationCipher.decode
import org.suggs.codewars.kata.IterativeRotationCipher.encode
import org.suggs.codewars.kata.IterativeRotationCipher.insertSpacesInto
import org.suggs.codewars.kata.IterativeRotationCipher.performSingleRotationOn
import org.suggs.codewars.kata.IterativeRotationCipher.shiftCharacterOrderLeftBy
import org.suggs.codewars.kata.IterativeRotationCipher.shiftCharacterOrderRightBy
import org.suggs.codewars.kata.IterativeRotationCipher.unwindSingleRotationOn

class IterativeRotationCipherTest {

    private val encodeExamples = arrayOf(
        Pair(10, "If you wish to make an apple pie from scratch, you must first invent the universe."),
        Pair(14, "True evil is a mundane bureaucracy."),
        Pair(22, "There is nothing more atrociously cruel than an adored child."),
        Pair(36, "As I was going up the stair\nI met a man who wasn't there!\nHe wasn't there again today,\nOh how I wish he'd go away!"),
        Pair(
            29,
            "I avoid that bleak first hour of the working day during which my still sluggish senses and body make every chore a penance.\nI find that in arriving later, the work which I do perform is of a much higher quality."
        )
    )

    private val decodeExamples = arrayOf(
        "10 hu fmo a,ys vi utie mr snehn rni tvte .ysushou teI fwea pmapi apfrok rei tnocsclet",
        "14 daue ilev is a munbune Traurecracy.",
        "22 tareu oo iucnaTr dled oldthser.hg hiarm nhcn se rliyet oincoa",
        "36 ws h weA dgIaa ug owh n!asrit git \n msm phw teaI'e tanantwhe reos\ns ther! aHeae 'gwadin\nt haw n htoo ,I'i sy aohOy",
        "29 a r.lht niou gwryd aoshg gIsi mk lei adwhfci isd seensn rdohy mo kleie oltbyhes a\naneu p.n rndr tehh irnne yifav t eo,raclhtc frpw IIti im gwkaidhv aicufh ima doea eruhi y io qshhcoa kr ef l btah gtrrse otnvugrt"
    )

    @Test
    fun `can encode a string using rotation cipher`() {
        assertSoftly {
            encodeExamples.forEachIndexed { i, (rotations, text) -> encode(rotations, text) shouldBe decodeExamples[i] }
        }
    }

    @Test
    fun `can decode a cipher using a rotation cipher`() {
        assertSoftly {
            decodeExamples.forEachIndexed { i, cipher -> decode(cipher) shouldBe encodeExamples[i].second }
        }
    }

    @Test
    fun `perform single rotation on text`() {
        performSingleRotationOn(
            10,
            "If you wish to make an apple pie from scratch, you must first invent the  universe."
        ) shouldBe "eu vni seer .I oufy wi shtom eak apan frplepie som atcr ch,yo ustfum sir  htinventt"
    }

    @Test
    fun `perform single rotation unwind on encrypted text`() {
        unwindSingleRotationOn(
            10,
            "eu vni seer .I oufy wi shtom eak apan frplepie som atcr ch,yo ustfum sir htinventt"
        ) shouldBe "If you wish to make an apple pie from scratch, you must first invent the universe."
    }

    @Test
    fun `shifts character order right by a defined amount`() {
        assertSoftly {
            shiftCharacterOrderRightBy("abcde", 1) shouldBe "eabcd"
            shiftCharacterOrderRightBy("abcde", 2) shouldBe "deabc"
            shiftCharacterOrderRightBy("abcde", 5) shouldBe "abcde"
            shiftCharacterOrderRightBy("abcde", 7) shouldBe "deabc"
        }
    }

    @Test
    fun `shifts character order left by a defined amount`() {
        assertSoftly {
            shiftCharacterOrderLeftBy("abcde", 1) shouldBe "bcdea"
            shiftCharacterOrderLeftBy("abcde", 2) shouldBe "cdeab"
            shiftCharacterOrderLeftBy("abcde", 5) shouldBe "abcde"
            shiftCharacterOrderLeftBy("abcde", 7) shouldBe "cdeab"
        }
    }

    @Test
    fun `inserts spaces based on an index`() {
        assertSoftly {
            insertSpacesInto("", setOf<Int>()) shouldBe ""
            insertSpacesInto("hi", setOf<Int>()) shouldBe "hi"
            insertSpacesInto("hihihi", setOf(2)) shouldBe "hi hihi"
            insertSpacesInto("hihihihihihi", setOf(2, 7)) shouldBe "hi hihi hihihi"
            insertSpacesInto("hihihihihihihihihihi", setOf(2, 7, 14)) shouldBe "hi hihi hihihi hihihihi"

        }
    }

    @Test
    fun `creates an index of spaces from a string`() {
        assertSoftly {
            createIndexOfSpaceCharsFrom("") shouldBe setOf()
            createIndexOfSpaceCharsFrom("hi") shouldBe setOf()
            createIndexOfSpaceCharsFrom("hi hihi") shouldBe setOf(2)
            createIndexOfSpaceCharsFrom("hi hihi hihihi") shouldBe setOf(2, 7)
            createIndexOfSpaceCharsFrom("hi hihi hihihi hihihihi") shouldBe setOf(2, 7, 14)
            createIndexOfSpaceCharsFrom("hi hihi hihihi hihihihi hihihi") shouldBe setOf(2, 7, 14, 23)
        }
    }
}