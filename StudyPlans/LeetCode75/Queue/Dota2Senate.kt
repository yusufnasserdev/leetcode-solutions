class Solution {
    fun predictPartyVictory(senate: String): String {
        val dire = ArrayDeque<Int>()
        val radiant = ArrayDeque<Int>()
        val len = senate.length


        senate.forEachIndexed { index, senator ->
            if (senator == 'D') dire.add(index) else radiant.add(index)
        }

        while (dire.isNotEmpty() && radiant.isNotEmpty()) {
            if (radiant.first() < dire.first()) {
                radiant.add(radiant.first() + len)
            } else {
                dire.add(dire.first() + len)
            }

            radiant.removeFirst()
            dire.removeFirst()
        }

        return if (dire.size > radiant.size) "Dire" else "Radiant"

    }
}