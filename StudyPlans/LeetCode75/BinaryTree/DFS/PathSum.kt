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
    fun pathSum(root: TreeNode?, sum: Int): Int {
        return pathSumLong(root, sum.toLong()).toInt()
    }

    fun pathSumLong(root: TreeNode?, sum: Long): Long {
        return if (root == null) 0
        else pathSumFrom(root, sum)
            .plus(pathSumLong(root.left, sum))
            .plus(pathSumLong(root.right, sum))
    }

    private fun pathSumFrom(node: TreeNode?, sum: Long): Long {
        if (node == null) return 0
        return (if (node.`val`.toLong() == sum) 1 else 0)
            .plus(pathSumFrom(node.left, sum - node.`val`))
            .plus(pathSumFrom(node.right, sum - node.`val`))

    }
}