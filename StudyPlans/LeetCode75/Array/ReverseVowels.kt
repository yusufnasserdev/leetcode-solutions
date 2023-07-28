class Solution {
    fun reverseVowels(s: String): String {
        val out = s.toCharArray()
        val vowelsIndices = mutableListOf<Int>()
        val vowels = "aeiou"

        s.forEachIndexed { index, c ->
            if (vowels.find { vowel -> vowel.equals(c, ignoreCase = true) } != null) {
                vowelsIndices.add(index)
            }
        }
        
        val len = vowelsIndices.size

        vowelsIndices.forEachIndexed { index, i ->
            if (index >= (len / 2)) return@forEachIndexed
            
            val otherIndex = vowelsIndices[len - index - 1]
            
            out[i] = s[otherIndex]
            out[otherIndex] = s[i]
        }

        return String(out)
    }
}