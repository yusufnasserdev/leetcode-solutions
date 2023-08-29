class Solution {

    fun minOperations(s: String): Int {
        var ops = 0
        
        s.forEachIndexed { index, c ->
            if (c - '0' != index % 2) ops++
        }

        return minOf(ops, s.length - ops)
    }
}