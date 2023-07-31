class Solution {
    private val vowels = "aeiou".toSet()

    private fun vowelOrZero(char: Char): Int {
        return if (char in vowels) 1 else 0
    }

    fun maxVowels(s: String, k: Int): Int {
        var maxVowels = 0
        var window = 0

        s.forEachIndexed { index, char ->
            window += vowelOrZero(char)

            if (index - k > -1) window -= vowelOrZero(s[index - k])
            if (index + 1 >= k) maxVowels = maxOf(maxVowels, window)
        }

        return maxVowels
    }
}
