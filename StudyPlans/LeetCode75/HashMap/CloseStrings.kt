class Solution {
    fun closeStrings(word1: String, word2: String): Boolean {
        if (word1.length != word2.length) return false

        if (word1.groupingBy { it }.eachCount().values.sorted()
            != word2.groupingBy { it }.eachCount().values.sorted()
        ) return false

        val word2Set = word2.toHashSet()
        return word1.toHashSet().none { it !in word2Set }
    }
}