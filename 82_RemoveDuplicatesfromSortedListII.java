/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

// recursive solution
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        int temp = head.val;
        if (head.val == head.next.val) {
            while (head != null && head.val == temp)
                head = head.next;
            return deleteDuplicates(head);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }

    }
}

// iteration solution