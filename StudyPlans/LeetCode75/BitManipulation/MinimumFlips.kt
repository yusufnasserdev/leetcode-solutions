class Solution {
    private fun Int.toBinary(): BooleanArray {
        val bits = BooleanArray(32)
        var x = this
        var iterator = 0

        while (x > 0) {
            bits[iterator++] = (1 == x.rem(2))
            x /= 2
        }
        
        return bits
    }

    fun minFlips(a: Int, b: Int, c: Int): Int {
        var flips = 0

        val aBits = a.toBinary()
        val bBits = b.toBinary()
        val cBits = c.toBinary()

        for (i in 0..31) {
            if (aBits[i] or bBits[i] != cBits[i]) {
                if (cBits[i]) {
                    flips++
                } else {
                    if (aBits[i]) flips++
                    if (bBits[i]) flips++
                }
            }
        }

        return flips
    }

}