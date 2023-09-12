class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        var ix = 0
        var com = ""

        while (true) {
            if (ix > strs[0].lastIndex) break
            val ch = strs[0][ix]

            for (str in strs) {
                if (ix > str.lastIndex || str[ix] != ch) return com
            }

            com += ch
            ix++
        }

        return com
    }
}