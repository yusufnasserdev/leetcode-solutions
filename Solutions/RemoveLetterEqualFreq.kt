import kotlin.math.abs

/**
 * This problem is classified as easy by LeetCode, smh.
 *
 * To be fair, it looks easy on the outside, you just need to
 * check if it is possible to remove exactly one character from
 * the word entered, and have the same frequency for all characters afterwords.
 */


class Solution {
    fun equalFrequency(word: String): Boolean {
        var freq = IntArray(26)

        // Starting off, just get the frequency for each character to see what are we working with here.
        word.forEach {
            freq[it - 'a']++
        }

        // Some characters have no frequencies, filtering  them.
        freq = freq.filter { it != 0 }.toIntArray()

        // If it's just one character, no need to check anything, it works regardless.
        if (freq.size == 1) return true

        // To get to one frequency, we need to know which one.
        // My approach was to see which frequency occurs the most and see if the rest can reach it.
        val mostFreq = freq.groupBy { it }
            .maxBy { it.value.size }.key

        // This wasn't in my plan when I started coding, this is a few corner cases that had to be handled.

        /**
         * if only 2 characters occurred in the word, then there are a few scenarios here
         *  1 - either one equals 1, it can be removed, it works
         *  2 - the difference between both frequencies is 1, the extra letter can be removed, it works.
         *  3 - WASTED, 'Don't save her, she don't wanna be saved'
         */

        if (freq.size == 2) {
            return if (freq[0] == 1 || freq[1] == 1) true
            else if (abs(freq[0] - freq[1]) == 1) true
            else false
        }

        // The general case - other than a few corner cases (easy, ha?) - see what needs to be adjusted and add it.

        var adjust = 0

        freq.forEach {
            /**
             * The most frequent frequency, if the current frequency is
             *  1 - lower, and it doesn't equal 1.
             *  2 - higher, and the difference is bigger than 1.
             *
             * In both cases, it can't be helped, we can only remove one.
             * Other than that, we add to adjust.
             */
            
            if (it < mostFreq && it != 1) return false
            if (it > mostFreq && ((it - mostFreq) > 1)) return false
            if (it != mostFreq) adjust++
        }

        // The last corner case that if we have more than one character with frequency one,
        // any of them can be removed, only if no other adjustments had been done already.

        return adjust == 1 || (mostFreq == 1 && adjust == 0)
    }
}