import kotlin.math.absoluteValue
import kotlin.math.sign

class Solution {
    private val st = ArrayDeque<Int>()

    private fun collide(asteroid: Int) {
        while (st.isNotEmpty()) {
            if (st.last().sign == asteroid.sign) {
                st.add(asteroid)
                break
            } else if (st.last().absoluteValue == asteroid.absoluteValue) {
                st.removeLast()
                break
            } else if (st.last().absoluteValue < asteroid.absoluteValue) {
                st.removeLast()
                if (st.isEmpty()) {
                    st.add(asteroid)
                    break
                }
            } else {
                break
            }
        }
    }

    fun asteroidCollision(asteroids: IntArray): IntArray {

        asteroids.forEach { asteroid ->
            if (st.isEmpty()) {
                st.add(asteroid)
            } else {
                if (st.last().sign > asteroid.sign) {
                    collide(asteroid)
                } else {
                    st.add(asteroid)
                }
            }
        }

        return st.toIntArray()
    }
}