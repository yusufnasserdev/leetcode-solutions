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

// TreeNode(101) is used instead of null as `val` constraints are -100, 100

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()

        val list = mutableListOf<Int>()
        val deque = ArrayDeque<TreeNode>()

        deque.add(root)
        deque.add(TreeNode(101))

        while (deque.isNotEmpty()) {
            val current = deque.removeFirst()

            if (current.`val` == 101) {
                deque.add(TreeNode(101))
                if (deque.first().`val` == 101) break
            }

            if (deque.isNotEmpty() && deque.first().`val` == 101) {
                list.add(current.`val`)
            }

            if (current.left != null) deque.add(current.left!!)
            if (current.right != null) deque.add(current.right!!)
        }

        return list
    }
}