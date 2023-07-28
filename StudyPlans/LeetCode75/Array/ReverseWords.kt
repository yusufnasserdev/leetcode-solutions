class Solution {
    fun reverseWords(s: String): String {
        return s.split(Regex(" +")).reversed().joinToString(" ").trim()
    }
}