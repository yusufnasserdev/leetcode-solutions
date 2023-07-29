class Solution {

    var len: Int = 0
    private fun IntArray.moveZerosBack(index: Int) {
        for (i in index.until(this.lastIndex))
            this[i] = this[i + 1]

        this[this.lastIndex] = 0

        if (index < len && this[index] == 0) {
            len--
            this.moveZerosBack(index)
        }
    }

    fun moveZeroes(nums: IntArray): Unit {
        len = nums.size
        var iterator = 0
        while (iterator < len) {
            if (nums[iterator] == 0) {
                nums.moveZerosBack(index = iterator)
                len--
            }
            iterator++
        }

        nums.forEach { println(it) }
    }

    /**
     * Another implementation using other data structures besides the array itself
     */

    fun moveZeroesDS(nums: IntArray): Unit {
        val list = nums.filterNot { i -> i == 0 }
        for (i in 0.until(list.size)) nums[i] = list[i]
        for (i in list.size.until(nums.size)) nums[i] = 0
    }
}







