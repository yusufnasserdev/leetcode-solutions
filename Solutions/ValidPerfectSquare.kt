class Solution {
    fun isPerfectSquare(num: Int): Boolean {
        for (i in 1..46340) {
            if (i * i == num) return true
            else if (i * i > num) return false
        }

        return false
    }
}