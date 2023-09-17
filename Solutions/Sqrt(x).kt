import kotlin.math.abs
import kotlin.math.pow

class Solution {
    fun mySqrt(x: Int): Int {
        var lp = 0
        var rp = x
        var mid = 0
        var mid2: Double

        while (lp <= rp) {
            mid = lp + (rp - lp) / 2
            mid2 = mid.toDouble().pow(2)

            if (mid2 == x.toDouble()) return mid
            else if (mid2 < x) lp = mid + 1
            else rp = mid - 1
        }

        return if (mid.toDouble().pow(2) > x) --mid else mid
    }
}