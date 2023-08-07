/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 */

class Solution {

    fun oddEvenList(head: ListNode?): ListNode? {
        if (head?.next == null || head.next?.next == null)
            return head

        var odds = head
        var evens = head.next
        val reference = head.next

        while (odds?.next != null && evens?.next != null) {
            odds.next = evens.next
            evens.next = odds.next?.next

            odds = odds.next
            evens = evens.next
        }

        odds?.next = reference

        return head
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

