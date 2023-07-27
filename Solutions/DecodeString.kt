class Solution {
    
    private fun Char.digitToInt() : Int {
        return this.toInt() - '0'.toInt()
    }
    
    fun decodeString(s: String): String {
        val stRep: ArrayDeque<Int> = ArrayDeque()
        val stSeq: ArrayDeque<String> = ArrayDeque()

        var seq = ""
        var rep = 0

        s.forEach { char ->
            if (char.isDigit()) {
                rep = rep * 10 + char.digitToInt()
            } else if (char == '[') {
                stSeq.add(seq)
                stRep.add(rep)
                seq = ""
                rep = 0
            } else if (char == ']') {
                seq = stSeq.removeLast() + seq.repeat(stRep.removeLast())
            } else {
                seq += char
            }
        }

        return seq
    }
}
