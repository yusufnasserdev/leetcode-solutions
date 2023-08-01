class Solution {
    fun largestAltitude(gain: IntArray): Int {
        var highestAlt = 0
        var currentAlt = 0

        gain.forEach { i ->
            currentAlt += i
            highestAlt = maxOf(highestAlt, currentAlt)
        }

        return highestAlt
    }
}