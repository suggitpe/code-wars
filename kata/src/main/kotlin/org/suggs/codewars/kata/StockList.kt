package org.suggs.codewars.kata

object StockList {

    fun stockSummary(lstOfArt: Array<String>, lstOfCat: Array<String>): String {
        if (lstOfArt.isEmpty() || lstOfCat.isEmpty()) return ""
        val countOfBooks = countBooksFrom(lstOfArt, lstOfCat)
        return lstOfCat.map { it to countOfBooks[it] }
            .map { createStringFrom(it) }
            .joinToString(separator = " - ")
    }

    fun countBooksFrom(lstOfArt: Array<String>, lstOfCat: Array<String>): Map<String, Int> {
        return lstOfArt.map { extractCategoryAndCountFrom(it) }
            .union(createZeroMapFrom(lstOfCat))
            .groupBy { it.first }
            .mapValues { it.value.sumOf { pair -> pair.second } }
            .filter { it.key in lstOfCat }
    }

    fun extractCategoryAndCountFrom(bookCode: String) = bookCode.first().toString() to bookCode.split(" ").last().toInt()

    private fun createZeroMapFrom(lstOfCat: Array<String>) = lstOfCat.map { it to 0 }

    private fun createStringFrom(entry: Pair<String, Int?>) = "(" + entry.first + " : " + entry.second + ")"

}