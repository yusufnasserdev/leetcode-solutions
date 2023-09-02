class Solution {
    fun lengthOfLastWord(s: String): Int {
        return s.trim().split("\\s+". toRegex()).last().length
    }
}