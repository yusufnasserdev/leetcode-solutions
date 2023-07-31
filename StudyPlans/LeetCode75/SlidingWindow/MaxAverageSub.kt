class Solution {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        var maxAvg = Double.NEGATIVE_INFINITY
        var window = 0

        nums.forEachIndexed { index, i ->
            window += i
            
            if (index - k > -1) window -= nums[index - k]
            if (index + 1 >= k) maxAvg = maxOf(maxAvg, (window.toDouble() / k))
        }
    
        return maxAvg
    }
}