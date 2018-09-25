/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
       
        ListNode curr=head;
        while(curr!=null&&curr.next!=null){
            if(curr.next.val!=curr.val){
                curr=curr.next;
            }else{
                curr.next=curr.next.next;
            }
        }
        return head;
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
    
        ListNode node = deleteDuplicates(head.next);
        
        if(node != null && head.val == node.val) {
            return node;
        } else {
            head.next = node;
            return head;
        }
    }
}