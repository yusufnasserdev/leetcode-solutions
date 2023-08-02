class Solution {
    private fun prePow(x: Double, n: Long): Double {
        if (x == 0.0) return x
        if (n == 0L) return 1.0
        if (n == 1L) return x

        return if (n.rem(2) == 1L) prePow(x * x, n / 2) * x
        else prePow(x * x, n / 2)

    }

    fun myPow(x: Double, n: Int): Double {
        val pow: Long = n.toLong()
        return if (n < 0) 1.0.div(prePow(x, -pow))
        else prePow(x, pow)
    }
}