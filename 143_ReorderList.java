/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
   public void reorderList(ListNode head) {

        if (head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast == head) return;
        if (fast == null) {
            merge(head, slow, slow);
        } else {
            merge(head, slow.next, slow);
            ListNode last = head;
            while (last.next != null) last = last.next;
            slow.next = null;
            last.next = slow;
        }
    }

    public void merge(ListNode head, ListNode mergePart, ListNode mid) {
        ListNode head1 = head;
        ListNode head2 = reverse(mergePart);
        while (head1 != null && head2 != null) {
            ListNode p1 = head1.next == mid ? null : head1.next;
            ListNode p2 = head2.next;
            head1.next = head2;
            head2.next = p1;

            head1 = p1;
            head2 = p2;
        }
    }

    private ListNode reverse(ListNode mergePart) {
        ListNode prev = null;
        ListNode curr = mergePart;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}