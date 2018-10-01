/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode pe = head;
        int n=k;
        while (n > 1 && pe != null) {
            pe = pe.next;
            n--;
        }

        if (pe == null) return head;

        ListNode node = reverseKGroup(pe.next, k);
        pe.next = null;
        ListNode currNode = reverseNodes(head);
        head.next = node;
        return currNode;

    }

    public ListNode reverseNodes(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = reverseNodes(head.next);
        head.next.next = head;
        head.next = null;
        return node;

    }
}