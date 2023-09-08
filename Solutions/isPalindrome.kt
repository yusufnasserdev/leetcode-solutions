class Solution {
    fun isPalindrome(s: String): Boolean {
        var lp = 0
        var rp = s.lastIndex

        while (rp > lp) {
            if (s[rp].isLetterOrDigit() && s[lp].isLetterOrDigit()) {
                if (s[rp].lowercaseChar() != s[lp].lowercaseChar()) return false
                lp++
                rp--
            } else {
                if (!s[lp].isLetterOrDigit()) lp++
                if (!s[rp].isLetterOrDigit()) rp--
            }

        }

        return true
    }
}