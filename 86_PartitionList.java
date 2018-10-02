/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        
        ListNode left=new ListNode(-1);
        ListNode leftP=left;
        ListNode right=new ListNode(-1);
        ListNode rightP=right;
        while(head!=null){
            if(head.val<x){
                left.next=new ListNode(head.val);
                left=left.next;
            }else{
                right.next=new ListNode(head.val);
                right=right.next;
            }
            head=head.next;
        }
        
        if(leftP.next==null){
            return rightP.next;
        }else if(rightP.next==null){
            return leftP.next;
        }else{
            left.next=rightP.next;
            return leftP.next;
        }
        
    }
}