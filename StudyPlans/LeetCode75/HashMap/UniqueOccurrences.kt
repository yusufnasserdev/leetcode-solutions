class Solution {
    fun uniqueOccurrences(arr: IntArray): Boolean {
        val counts = arr.asSequence().groupingBy { it }.eachCount().values
        return counts.size == counts.toSet().size
    }
}