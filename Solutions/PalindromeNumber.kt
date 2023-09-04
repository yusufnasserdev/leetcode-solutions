class Solution {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false

        val s = x.toString()
        for (i in 0..<(s.length / 2)) {
            if (s[i] != s[s.length - i - 1]) return false
        }

        return true
    }
}