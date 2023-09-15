class Solution {
    fun maxProfit(prices: IntArray): Int {
        var profit = 0
        var least = 10001

        prices.forEach {
            least = minOf(it, least)
            profit = maxOf(profit, (it - least))
        }

        return profit
    }
}