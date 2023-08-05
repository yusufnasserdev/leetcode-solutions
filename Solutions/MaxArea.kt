class Solution {
    private var rows: Int = 0
    private var cols: Int = 0
    private lateinit var tempGrid: Array<IntArray>
    private lateinit var visited: Array<BooleanArray>
    private val addPoints = listOf(
        Point(1, 0),
        Point(-1, 0),
        Point(0, 1),
        Point(0, -1)
    )

    inner class Point(val x: Int, val y: Int) {

        private fun isValidX(): Boolean {
            return x in 0 until rows
        }

        private fun isValidY(): Boolean {
            return y in 0 until cols
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

    private fun dfs(point: Point): Int {
        var area = 1

        visited[point.x][point.y] = true
        point.getNeighbours().forEach {
            if (tempGrid[it.x][it.y] == 1 && !visited[it.x][it.y])
                area += dfs(it)
        }

        return area
    }


    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        rows = grid.size
        cols = grid[0].size

        tempGrid = grid
        visited = Array(rows) { BooleanArray(cols) }

        var maxArea = 0

        grid.forEachIndexed { x, subGrid ->
            subGrid.forEachIndexed { y, type ->
                if (type == 1 && !visited[x][y]) {
                    maxArea = maxOf(maxArea, dfs(Point(x, y)))
                }
            }
        }

        return maxArea
    }
}