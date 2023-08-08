/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
 
 */

class Solution {
    private fun dfs(root: TreeNode?): Int {
        if (root == null) return 0

        return 1 + maxOf(
            dfs(root.left),
            dfs(root.right)
        )
    }

    fun maxDepth(root: TreeNode?): Int {
        return dfs(root)
    }
}