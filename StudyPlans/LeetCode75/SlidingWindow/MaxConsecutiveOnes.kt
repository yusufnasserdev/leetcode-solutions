class Solution {

    fun longestOnes(nums: IntArray, k: Int): Int {
        var maxSeq = 0
        val dequeFlips = ArrayDeque<Int>()
        var flips = k
        var window = 0

        nums.forEachIndexed { index, i ->
            // if i equals 1, just increase the window's size
            if (i == 1) window++
            else if (flips > 0) {
                // i equals 0, can only be counted if there still are flips to spend
                dequeFlips.add(index)
                flips--
                window++
            } else if (dequeFlips.isNotEmpty()) {
                // if all flips are already spent on previous zero occurrences,
                // remove the first one and add the current one
                window = index - dequeFlips.removeFirst()
                dequeFlips.add(index)
            } else {
                // if flips < 0 and the queue is empty,
                // means no flips and a zero occurrence,
                // window is interrupted and back to size zero
                window = 0
            }

            maxSeq = maxOf(maxSeq, window)
        }

        return maxSeq
    }
}
