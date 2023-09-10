class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        val mp = nums.asSequence().groupingBy { it }.eachCount()
        var ix = 0
        mp.forEach { (t, u) ->
            var reps = 0
            while (reps < u && reps < 2) {
                nums[ix] = t
                ix++
                reps++
            }
        }
        return ix
    }
}