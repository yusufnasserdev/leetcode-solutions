class Solution {
    fun findBestValue(arr: IntArray, target: Int): Int {
        arr.sort()
        var tgt = target
        val n = arr.size
        var i = 0
        
        while (i < n && tgt > arr[i] * (n - i)) {
            tgt -= arr[i++]
        }

        if (i == n) return arr[n - 1]
        var res = tgt / (n - i)
        if (tgt - res * (n - i) > (res + 1) * (n - i) - tgt) res++
        return res
    }
}