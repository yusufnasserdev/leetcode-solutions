class Solution {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
        val out = mutableListOf<Boolean>()
        val mx = candies.max()!! // !! is justified as candies lower limit is 2 ( > 0 ) 

        candies.forEach { kid ->
            out.add (kid + extraCandies >= mx)
        }

        return out
    }
}