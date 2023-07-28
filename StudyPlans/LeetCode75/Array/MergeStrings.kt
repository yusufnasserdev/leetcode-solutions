import kotlin.math.max

class Solution {
    fun mergeAlternately(word1: String, word2: String): String {
        var result = ""
        val len = max(word1.length, word2.length) - 1
        for (i in 0..len) {
            result += if (word1.length > i) word1[i] else ""
            result += if (word2.length > i) word2[i] else ""
        }

        return result
    }
}