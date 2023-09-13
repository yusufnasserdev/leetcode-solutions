class Solution {
    fun romanToInt(s: String): Int {
        val map = mapOf('I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000)

        var num = 0
        val rev = s.reversed()
        rev.forEachIndexed { ix, c ->
            if (ix == 0) num += map.getOrDefault(c, 0)
            else {
                if (map.getOrDefault(rev[ix - 1], 0) > map.getOrDefault(c, 0)) {
                    num -= map.getOrDefault(c, 0)
                } else {
                    num += map.getOrDefault(c, 0)
                }
            }
        }
        return num
    }
}