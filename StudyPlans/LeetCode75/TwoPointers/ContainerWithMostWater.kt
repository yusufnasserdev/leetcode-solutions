import kotlin.math.max
import kotlin.math.min

class Solution {
    fun maxArea(height: IntArray): Int {
        var lp = 0
        var rp = height.lastIndex
        var maxWater = 0
        var currWater: Int


        while (lp < rp) {
            currWater = min(height[lp], height[rp]) * (rp - lp)
            maxWater = max(maxWater, currWater)

            if (height[rp] > height[lp]) lp++
            else if (height[rp] < height[lp]) rp--
            else {
                lp++
                rp--
            }
        }

        return maxWater
    }
}