class Solution {
    fun increasingTriplet(nums: IntArray): Boolean {
        val arr = IntArray(2) { Int.MAX_VALUE }

        nums.forEach { i ->
            if (i <= arr[0]) arr[0] = i
            else if (i <= arr[1]) arr[1] = i
            else return true
        }

        return false
    }
}