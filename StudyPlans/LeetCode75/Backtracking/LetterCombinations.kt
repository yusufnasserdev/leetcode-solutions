class Solution {
    private val map = listOf(
        "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    )

    private val out = mutableListOf<String>()
    private lateinit var digs: String

    private fun backtrack(len: Int, comb: String = "") {
        if (len == 0) {
            if (comb.isNotBlank()) out.add(comb)
            return
        }

        for (i in map[digs[digs.length - len].digitToInt() - 2]) {
            backtrack(len - 1, comb + i)
        }
    }

    fun letterCombinations(digits: String): List<String> {
        digs = digits
        backtrack(digits.length)
        return out
    }
}