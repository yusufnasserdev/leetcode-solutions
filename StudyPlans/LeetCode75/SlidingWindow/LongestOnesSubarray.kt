class Solution {

    fun longestSubarray(nums: IntArray): Int {
        var maxSeq = 0
        var deleted = -1
        var window = 0

        nums.forEachIndexed { index, i ->
            if (i == 1) window++
            else {
                if (deleted != -1) window =  (index - deleted) - 1
                deleted = index
            }

            maxSeq = maxOf(maxSeq, window)
        }

        return if (deleted != -1) maxSeq else --maxSeq
    }
}
