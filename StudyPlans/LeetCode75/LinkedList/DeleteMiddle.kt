/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

 */


class Solution {
    private fun getListLength(head: ListNode?): Int {
        var len = 0
        var list = head

        while (list?.`val` != null) {
            len++
            list = list.next
        }

        return len
    }

    fun deleteMiddle(head: ListNode?): ListNode? {
        val len = (getListLength(head) / 2)
        
        if (len == 0) return null
        
        var list = head
        val modified = ListNode(1)
        modified.next = head

        for (i in 1 until len) {
            list = list?.next
        }

        val next: ListNode? = list?.next?.next
        list?.next = next

        return modified.next
    }
}