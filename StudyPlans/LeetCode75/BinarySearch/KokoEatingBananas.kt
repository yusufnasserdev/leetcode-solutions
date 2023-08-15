import kotlin.math.ceil

class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var start = 1
        var end = piles.max()!!
        var mid = 0

        fun remains(trial: Double): Int {
            var remaining = h
            piles.forEach { i ->
                remaining -= ceil(i / trial).toInt()
            }
            return remaining
        }

        while (start <= end) {
            mid = start + (end - start) / 2

            if (remains(mid.toDouble()) >= 0) end = mid - 1
            else start = mid + 1
        }

        return if (remains(mid.toDouble()) >= 0) mid else mid + 1
    }
}