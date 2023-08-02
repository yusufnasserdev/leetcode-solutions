import java.util.Stack

class Solution {
    private fun Char.digitToInt(): Int {
        return this.toInt() - '0'.toInt()
    }

    fun decodeString(s: String): String {
        val repetitions = Stack<Int>()
        val sequences = Stack<String>()
        var sequence = ""
        var repeat = 0

        s.forEach { char ->
            if (char.isDigit()) {
                repeat = (repeat * 10) + char.digitToInt()
            } else if (char == '[') {
                sequences.add(sequence)
                repetitions.add(repeat)
                repeat = 0
                sequence = ""
            } else if (char == ']') {
                sequence = sequences.pop() + sequence.repeat(repetitions.pop())
            } else {
                sequence += char
            }
        }

        return sequence
    }
}