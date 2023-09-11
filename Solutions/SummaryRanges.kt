class Solution {
    fun summaryRanges(nums: IntArray): List<String> {
        if (nums.isEmpty()) return emptyList()

        val dq = ArrayDeque<Int>()
        val list = mutableListOf<String>()
        nums.forEach { i ->
            if (dq.isEmpty()) dq.add(i)
            else if (i - dq.last() == 1) dq.add(i)
            else {
                if (dq.first() == dq.last()) {
                    list.add("${dq.first()}")
                } else {
                    list.add("${dq.first()}->${dq.last()}")
                }
                dq.clear()
                dq.add(i)
            }
        }


        if (dq.first() == dq.last()) {
            list.add("${dq.first()}")
        } else {
            list.add("${dq.first()}->${dq.last()}")
        }

        return list
    }
}