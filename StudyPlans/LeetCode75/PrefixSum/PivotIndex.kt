class Solution {
    fun pivotIndex(nums: IntArray): Int {
        val accSum = IntArray(nums.size)

        nums.forEachIndexed { index, i ->
            accSum[index] = i + (if (index > 0) accSum[index - 1] else 0)
        }

        accSum.forEachIndexed { index, _ ->
            val left = if (index > 0) accSum[index - 1] else 0
            val right = accSum[accSum.lastIndex] - accSum[index]

            if (left == right) return index
        }


        return -1
    }
}