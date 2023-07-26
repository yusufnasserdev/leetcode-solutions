class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        var otherValue: Int
        var otherIndex: Int

        nums.forEachIndexed { index, value ->
            otherValue = target - value
            otherIndex = map.getOrDefault(otherValue, -1)

            if (otherIndex != -1) return intArrayOf(index, otherIndex)
            else map[value] = index
        }

        return intArrayOf()
    }
}