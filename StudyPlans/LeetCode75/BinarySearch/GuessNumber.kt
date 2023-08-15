/** 
 * The API guess is defined in the parent class.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * fun guess(num:Int):Int {}
 */


class Solution : GuessGame() {
    override fun guessNumber(n: Int): Int {
        var start = 1
        var end = n
        var mid = 1

        while (start <= end) {
            mid = start + (end - start) / 2
            val g = guess(mid)
            if (g == 0) return mid
            else if (g == -1) end = mid - 1
            else start = mid + 1
        }

        return mid
    }
}