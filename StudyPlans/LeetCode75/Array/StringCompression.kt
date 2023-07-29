class Solution {
    fun compress(chars: CharArray): Int {
        var first = 0
        var iterator = 0
        var last = chars.first()

        chars.forEachIndexed { index, c ->
            if (index > 0) {
                if (c != last) {
                    chars[iterator++] = last
                    val len = (index - first)
                    if (len > 1) len.toString().forEach { chars[iterator++] = it }
                    first = index
                }

                last = c
            }
        }

        chars[iterator++] = last
        val len = (chars.size - first)
        if (len > 1) len.toString().forEach { chars[iterator++] = it }

        return iterator
    }
}