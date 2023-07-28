class Solution {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        val len = flowerbed.size - 1
        var count = 0
        for (i in 0..len) {
            if (flowerbed[i] == 0) {
                val before = (i == 0) || ( flowerbed[i - 1] == 0)
                val after = (i >= len) || (flowerbed[i + 1] == 0)
                
                if (before && after) {
                    flowerbed[i] = 1
                    count++
                }
            }
        }

        return (count >= n)
    }
}