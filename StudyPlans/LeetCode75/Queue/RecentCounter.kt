// list and binary search approach
class RecentCounter() {
    private val pings = mutableListOf<Int>()

    fun ping(t: Int): Int {
        pings.add(t)
        var elementOrHigher = pings.binarySearch(t - 3000)

        elementOrHigher = if (elementOrHigher >= 0) elementOrHigher else
            (elementOrHigher + 1) * -1

        return pings.size - elementOrHigher
    }
}

// queue approach
   
class RecentCounter() {
    private val pings = ArrayDeque<Int>()

    fun ping(t: Int): Int {
        pings.add(t)
        while (pings.first() < (t - 3000)) pings.removeFirst()
        return pings.size
    }

}
