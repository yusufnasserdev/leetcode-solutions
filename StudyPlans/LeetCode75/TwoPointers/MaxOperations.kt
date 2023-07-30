import kotlin.math.min

class Solution {
    fun maxOperations(nums: IntArray, k: Int): Int {
        val map = nums.asSequence().groupingBy { it }.eachCount().toMutableMap()
        var ops = 0
        var currOps = 0
        var other = 0
        var otherVal = 0

        map.forEach { (key, value) ->
            if (value > 0) {
                other = k - key

                if (other == key) {
                    ops += (value / 2)
                    return@forEach
                }

                otherVal = map.getOrDefault(other, -1)
                if (otherVal > 0) {
                    currOps = min(value, otherVal)

                    map[key] = value - currOps
                    map[other] = otherVal - currOps

                    ops += currOps
                }
            }
        }

        return ops
    }
}