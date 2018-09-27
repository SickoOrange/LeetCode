/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        int len=0;
        ListNode p=head;
        while(p!=null){
            len++;
            p=p.next;
        }
        
        p=head;
        int cnt=len/2;
        
        if(len%2!=0){
            cnt++;
        }
        
        while(cnt>0){
            cnt--;
            p=p.next;
        }
        
        ListNode right=recursiveReverse(p);
        
        while(right!=null){
            if(right.val!=head.val){
                return false;
            }
            right=right.next;
            head=head.next;
           
        }
        return true;
        
    }
    
    public ListNode recursiveReverse(ListNode head){
         if(head==null||head.next==null) return head;
        ListNode node=recursiveReverse(head.next);
        head.next.next=head;
        head.next=null;
        return node;
    }
}
