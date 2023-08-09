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
    private var longest = 0

    private fun dfs(node: TreeNode?, right: Boolean, steps: Int) {
        if (node == null) return

        longest = maxOf(longest, steps)

        return if (right) {
            dfs(node.right, false, steps + 1)
            dfs(node.left, true, 1)
        } else {
            dfs(node.left, true, steps + 1)
            dfs(node.right, false, 1)
        }
    }

    fun longestZigZag(root: TreeNode?): Int {
        dfs(root, true, 0)
        dfs(root, false, 0)
        return longest
    }
}