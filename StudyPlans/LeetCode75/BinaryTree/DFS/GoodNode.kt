/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    private fun dfs(root: TreeNode?, mx: Int): Int {
        if (root == null) return 0

        return dfs(root.left, maxOf(mx, root.`val`))
            .plus(dfs(root.right, maxOf(mx, root.`val`)))
            .plus(if (root.`val` >= mx) 1 else 0)
    }


    fun goodNodes(root: TreeNode?): Int {
        if (root == null) return 0
        return dfs(root, root.`val`)
    }
}