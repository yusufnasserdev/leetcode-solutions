class Solution {
    fun isValid(s: String): Boolean {
        val dq = ArrayDeque<Char>()

        s.forEach {
            when (it) {
                '[' -> dq.add(']')
                '(' -> dq.add(')')
                '{' -> dq.add('}')
                else -> if (dq.isEmpty() || dq.removeLast() != it) return false
            }
        }

        return dq.isEmpty()
    }
}