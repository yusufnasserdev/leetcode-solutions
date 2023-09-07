class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        val list = mutableListOf<Int>()
        for (num in nums) {
            if (num != `val`) list.add(num)
        }

        list.forEachIndexed { ix, i ->
            nums[ix] = i
        }

        return list.size
    }
}