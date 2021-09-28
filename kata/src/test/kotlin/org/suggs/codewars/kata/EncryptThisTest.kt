package org.suggs.codewars.kata

import io.kotest.assertions.assertSoftly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.suggs.codewars.kata.EncryptThis.decryptThis
import org.suggs.codewars.kata.EncryptThis.encryptThis

class EncryptThisTest {

    @Test
    fun `encrypts strings `() {
        assertSoftly {
            encryptThis("A wise old owl lived in an oak") shouldBe "65 119esi 111dl 111lw 108dvei 105n 97n 111ka"
            encryptThis("The more he saw the less he spoke") shouldBe "84eh 109ero 104e 115wa 116eh 108sse 104e 115eokp"
            encryptThis("The less he spoke the more he heard") shouldBe "84eh 108sse 104e 115eokp 116eh 109ero 104e 104dare"
            encryptThis("Why can we not all be like that wise old bird") shouldBe "87yh 99na 119e 110to 97ll 98e 108eki 116tah 119esi 111dl 98dri"
            encryptThis("Thank you Piotr for all your help") shouldBe "84kanh 121uo 80roti 102ro 97ll 121ruo 104ple"
        }
    }

    @Test
    fun `decrypts encrypted strings`(){
        assertSoftly {
            decryptThis("65 119esi 111dl 111lw 108dvei 105n 97n 111ka") shouldBe "A wise old owl lived in an oak"
            decryptThis("84eh 109ero 104e 115wa 116eh 108sse 104e 115eokp") shouldBe "The more he saw the less he spoke"
            decryptThis("84eh 108sse 104e 115eokp 116eh 109ero 104e 104dare") shouldBe "The less he spoke the more he heard"
            decryptThis("87yh 99na 119e 110to 97ll 98e 108eki 116tah 119esi 111dl 98dri") shouldBe "Why can we not all be like that wise old bird"
            decryptThis("84kanh 121uo 80roti 102ro 97ll 121ruo 104ple") shouldBe "Thank you Piotr for all your help"
        }
    }

}