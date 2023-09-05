class Solution {
    fun wordPattern(pattern: String, s: String): Boolean {
        val dic1 = mutableMapOf<Char, String>()
        val dic2 = mutableMapOf<String, Char>()
        val list = s.split(' ')

        if (list.size != pattern.length) return false

        list.forEachIndexed { ix, str ->
            if (dic1.getOrPut(pattern[ix]) { str } != str) return false
            if (dic2.getOrPut(str) { pattern[ix] } != pattern[ix]) return false
        }
        return true
    }
}