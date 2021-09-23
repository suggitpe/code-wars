package org.suggs.codewars.kata;

import io.kotest.assertions.assertSoftly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test;
import org.suggs.codewars.kata.StockList.countBooksFrom
import org.suggs.codewars.kata.StockList.extractCategoryAndCountFrom
import org.suggs.codewars.kata.StockList.stockSummary

class StockListTest {

    @Test
    fun `counts books in a category list`() {
        assertSoftly {
            stockSummary(arrayOf("BBAR 150", "CDXE 515", "BKWR 250", "BTSQ 890", "DRTY 600"), arrayOf("A", "B", "C", "D")) shouldBe "(A : 0) - (B : 1290) - (C : 515) - (D : 600)"
            stockSummary(arrayOf("ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"), arrayOf("A", "B")) shouldBe "(A : 200) - (B : 1140)"
        }
    }

    @Test
    fun `counts books into categories`() {
        assertSoftly {
            countBooksFrom(arrayOf("ADXE 75"), arrayOf("A")) shouldBe mapOf("A" to 75)
            countBooksFrom(arrayOf("BBAR 150", "ADXE 75"), arrayOf("A", "B")) shouldBe mapOf("A" to 75, "B" to 150)
            countBooksFrom(arrayOf("BBAR 150", "CDXE 515", "BKWR 250", "BTSQ 890", "DRTY 600"), arrayOf("B", "C", "D")) shouldBe mapOf("B" to 1290, "C" to 515, "D" to 600)
        }
    }

    @Test
    fun `extracts book category and number from string`() {
        assertSoftly {
            extractCategoryAndCountFrom("BBAR 150") shouldBe Pair("B", 150)
            extractCategoryAndCountFrom("CDXE 56") shouldBe Pair("C", 56)
        }
    }

    @Test
    fun `orders output based on the categories defined`() {
        assertSoftly{
            stockSummary(arrayOf("ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"), arrayOf("A", "B")) shouldBe "(A : 200) - (B : 1140)"
            stockSummary(arrayOf("ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"), arrayOf("B", "A")) shouldBe "(B : 1140) - (A : 200)"
        }

    }

}
