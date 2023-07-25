import java.util.ArrayDeque

class Solution {
    private var imgX: Int = 0
    private var imgY: Int = 0
    private var originalColor: Int = 0
    private val addPoints = listOf(
        Point(0, 1),
        Point(0, -1),
        Point(1, 0),
        Point(-1, 0)
    )

    inner class Point(val x: Int, val y: Int) {

        operator fun component1() = x
        operator fun component2() = y

        private fun isValidX(): Boolean {
            return x in 0 until imgX
        }

        private fun isValidY(): Boolean {
            return y in 0 until imgY
        }

        private fun isValid(): Boolean {
            return isValidX() && isValidY()
        }

        fun getNeighbours(): List<Point> {
            val neighbours = mutableListOf<Point>()

            for (add in addPoints) {
                val potentialNeighbour = Point(x + add.x, y + add.y)
                if (potentialNeighbour.isValid())
                    neighbours.add(potentialNeighbour)
            }

            return neighbours
        }
    }

    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        imgX = image.size
        imgY = image[0].size
        originalColor = image[sr][sc]

        if (originalColor == color) return image

        val dq: ArrayDeque<Point> = ArrayDeque()
        dq.push(Point(sr, sc))

        while (dq.isNotEmpty()) {
            val p = dq.pop()
            image[p.x][p.y] = color

            p.getNeighbours().forEach { (x, y) ->
                if (image[x][y] == originalColor) {
                    dq.push(Point(x, y))
                }
            }

        }

        return image
    }
}
