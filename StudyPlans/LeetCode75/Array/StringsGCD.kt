class Solution {
    fun gcdOfStrings(str1: String, str2: String): String {
        return if (str1.length < str2.length) { gcdOfStrings(str2, str1) }
        else if (str1 == str2) { str1 } 
        else {
            if (str1.startsWith(str2)) { gcdOfStrings(str1.removePrefix(str2), str2) } 
            else { "" }
        }
    }
}