import java.util.Stack

class Solution {
    private fun writeString(str: String): String {
        val st = Stack<Char>()

        str.forEach { char ->
            if (char == '#') {
                if (st.isNotEmpty()) st.pop()
            } else st.push(char)
        }

        return st.toString()
    }


    fun backspaceCompare(s: String, t: String): Boolean {
        return writeString(s) == writeString(t)
    }
}