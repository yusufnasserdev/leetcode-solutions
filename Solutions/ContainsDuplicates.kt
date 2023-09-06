class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val dict = mutableMapOf<Int, Int>()
        nums.forEachIndexed { ix, i ->
            val lastAppearance = dict.getOrPut(i) { ix }
            if (lastAppearance != ix && (ix - lastAppearance <= k)) return true
            dict[i] = ix
        }
        return false
    }
}