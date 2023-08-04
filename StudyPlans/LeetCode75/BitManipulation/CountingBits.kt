class Solution {
    private fun Int.calcOnes(): Int {
        var ones = 0
        var x: Int = this

        while (x > 0) {
            if (x.rem(2) == 0) ones++
            x /= 2
        }

        return ones
    }

    fun countBits(n: Int): IntArray {
        val bits = IntArray(n + 1)
        for (i in 0..n) bits[i] = i.calcOnes()
        return bits
    }
}