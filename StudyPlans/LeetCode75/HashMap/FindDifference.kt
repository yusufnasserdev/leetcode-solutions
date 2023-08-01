class Solution {
    fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {

        val arr1 = nums1.toSet()
        val arr2 = nums2.toSet()

        return listOf(
            arr1.filter { item -> item !in arr2 },
            arr2.filter { item -> item !in arr1 }
        )
    }
}