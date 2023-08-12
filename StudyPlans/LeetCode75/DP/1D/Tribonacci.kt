class Solution {
    private val cache = IntArray(40)
    fun tribonacci(n: Int): Int {
        if (n < 1) return 0
        else if (n < 3) return 1

        if (cache[n] != 0) return cache[n]
        cache[n] = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3)

        return cache[n]
    }
}