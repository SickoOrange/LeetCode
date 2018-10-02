/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // if without dummy, we can recode slow's previous node 
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null || head.next==null) return head;
        if(m==n) return head;
        
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        
        ListNode slow=dummy;
        ListNode fast=dummy;
        int diff=n-m;
        while(diff-->0){
            fast=fast.next;
        }
        
        while(--m > 0 && fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        
       ListNode restNode=fast.next==null? null : fast.next.next ; 
       if(fast.next!=null&&fast.next.next!=null) fast.next.next=null;
        
      
       ListNode reverseNode=reverse(slow.next);
       slow.next=reverseNode;
       while(reverseNode.next!=null) reverseNode=reverseNode.next;
       reverseNode.next=restNode;
       return dummy.next;   
       
       
    }
    
    public ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode node=reverse(head.next);
        head.next.next=head;
        head.next=null;
        return node;
    }
}