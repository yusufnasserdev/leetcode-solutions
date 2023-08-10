class Solution {
    fun maxLevelSum(root: TreeNode?): Int {
        if (root == null) return 0

        var highestSum = root.`val`
        var sum = 0
        var maxLevel = 1
        var level = 1

        val deque = ArrayDeque<TreeNode>()

        deque.add(root)
        deque.add(TreeNode(100005))

        while (deque.isNotEmpty()) {
            val current = deque.removeFirst()

            if (current.`val` == 100005) {
                deque.add(TreeNode(100005))
                if (deque.first().`val` == 100005) break
                continue
            }

            sum += current.`val`

            if (deque.isNotEmpty() && deque.first().`val` == 100005) {
                if (sum > highestSum) {
                    highestSum = sum
                    maxLevel = level
                }

                highestSum = maxOf(highestSum, sum)
                sum = 0
                level++
            }

            if (current.left != null) deque.add(current.left!!)
            if (current.right != null) deque.add(current.right!!)
        }

        return maxLevel
    }
}