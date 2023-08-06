/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun reverseList(head: ListNode?): ListNode? {

        var tempHead = head
        var prevNode : ListNode? = null
        var nextNode : ListNode?

        while (tempHead != null) {
            nextNode = tempHead.next
            tempHead.next = prevNode

            prevNode = tempHead
            tempHead = nextNode
        }

        return prevNode
    }
}