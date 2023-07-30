class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        var i = 0

        if (s.isEmpty()) return true

        t.forEach { char ->
            if (s[i] == char) i++
            if (i == s.length) return true
        }

        return false
    }
}