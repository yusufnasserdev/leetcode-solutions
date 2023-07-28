class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        var mul = 1
        var zeroIndex = -1
        val out = IntArray(nums.size)
        
        nums.forEachIndexed { index, i ->
            if (i == 0) {
                if (zeroIndex == -1) zeroIndex = index
                else return out
            } else mul *= i
        }

        nums.forEachIndexed { index, i ->
            if (zeroIndex != -1 && index != zeroIndex) out[index] = 0
            else {
                out[index] = if (i == 0) mul else (mul / i)
            }
        }

        return out
    }
}