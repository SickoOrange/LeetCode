/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
       public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0) return head;
        int len=1;
        ListNode curr=head;
        while(curr.next!=null){
            curr=curr.next;
            len++;
        }
        k = k % (len);
        if(k==0) return head;   
        int step=(len)-k;
        ListNode p=head;
        while(step-->1){
            p=p.next;
        }
        curr.next=head;
        head=p.next;
        p.next=null;
        return head;
    }
}