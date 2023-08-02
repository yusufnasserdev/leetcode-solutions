class Solution {
    fun removeStars(s: String): String {
        val st = ArrayDeque<Char>()

        s.forEach { char ->
            if (char == '*' && st.isNotEmpty())
                st.removeLast()
            else st.add(char)
        }

        return st.joinToString("")
    }
}