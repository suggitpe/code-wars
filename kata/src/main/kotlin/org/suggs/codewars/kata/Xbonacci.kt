package org.suggs.codewars.kata

object Xbonacci {

    fun xbonacci(signature: DoubleArray, n: Int): DoubleArray {
        return if (n <= signature.size) {
            signature.take(n).toDoubleArray()
        } else
            recurseXbonacci(signature, n, signature.size)
    }

    private fun recurseXbonacci(signature: DoubleArray, n: Int, factor: Int): DoubleArray {
        return if (signature.size >= n) {
            signature
        } else
            recurseXbonacci(signature + signature.takeLast(factor).sum(), n, factor)
    }

}