/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode doublePoint = head;
        ListNode singlePoint = head;

        while (doublePoint != null && doublePoint.next != null && doublePoint.next.next != null) {
            doublePoint = doublePoint.next.next;
            singlePoint = singlePoint.next;
        }

        if (doublePoint.next != null && doublePoint.next.next == null) {
            //there are two middle nodes in the list
            singlePoint = singlePoint.next;
        }
        return singlePoint;
    }
}


class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
