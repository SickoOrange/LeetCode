/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

// recursive solution
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return head;

        ListNode node = removeElements(head.next, val);
        if (head.val == val) {
            return node;
        } else {
            head.next = node;
            return head;
        }
    }
}

// iteration solusion
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return head;
        ListNode curr = head;

        while (head != null && head.val == val)
            head = head.next;

        if (head == null)
            return head;

        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
// 1,3,4,6,6
