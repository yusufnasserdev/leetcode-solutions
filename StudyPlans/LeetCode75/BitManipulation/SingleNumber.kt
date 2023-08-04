class Solution {
    fun singleNumber(nums: IntArray): Int {
        var out = 0
        
        nums.forEach {
            out = out xor it
        }

        return out
    }
}