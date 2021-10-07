package org.suggs.codewars.kata

object Tribonacci {

    fun tribonacci(signature: DoubleArray, n: Int): DoubleArray {
        return if (n <= signature.size) {
            signature.take(n).toDoubleArray()
        } else
            recurseTribonacci(signature, n)
    }

    private fun recurseTribonacci(signature: DoubleArray, n: Int): DoubleArray {
        return if (signature.size >= n) {
            signature
        } else
            recurseTribonacci(signature + signature.takeLast(3).sum(), n)
    }

}