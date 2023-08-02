class Solution {
    fun equalPairs(grid: Array<IntArray>): Int {
        var pairs = 0
        val columns = Array(grid.size) { IntArray(grid.size) }

        for (i in 0..grid.lastIndex) {
            for (j in 0..grid.lastIndex) {
                columns[i][j] = grid[j][i]
            }
        }

        for (row in grid) {
            for (column in columns) {
                if (row.contentEquals(column)) pairs++
            }
        }

        return pairs
    }
}