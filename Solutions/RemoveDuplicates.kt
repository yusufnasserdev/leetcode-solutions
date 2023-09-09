class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        val st = nums.toSortedSet()
        st.forEachIndexed { ix, i -> nums[ix] = i }
        return st.size
    }
}