class Solution {
    fun majorityElement(nums: IntArray): Int {
        return nums.toList().groupingBy { it }.eachCount().maxBy { it.value }.key
    }
}