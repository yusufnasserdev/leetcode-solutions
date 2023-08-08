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

    private val sequence = mutableListOf<Int>()

    private fun dfs(root: TreeNode?) {
        if (root == null) return
        if (root.left == null && root.right == null) {
            sequence.add(root.`val`)
            return
        }

        dfs(root.left)
        dfs(root.right)
    }

    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        dfs(root1)
        val sequence1 = sequence.toList()

        sequence.clear()
        dfs(root2)
        
        return sequence1 == sequence
    }

}