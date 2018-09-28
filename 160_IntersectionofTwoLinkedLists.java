/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        
        int lenA=0;
        int lenB=0;
        
        ListNode pa=headA;
        ListNode pb=headB;
        
        while(pa!=null){
            pa=pa.next;
            lenA++;
        }
        
        while(pb!=null){
            pb=pb.next;
            lenB++;
        }
        
        int diff=Math.abs(lenA-lenB);
        
        pa=headA;
        pb=headB;
        
        if(lenA>lenB){
            while(diff>0){
                diff--;
                pa=pa.next;
                
            }
        }else if(lenA<lenB){
            while(diff>0){
                diff--;
                pb=pb.next;
            }
        }
        
        while(pa!=null && pb!=null){
            if(pa.val==pb.val){
                return pa;
            }
            pa=pa.next;
            pb=pb.next;
        }
        
        return null;
        
    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        ListNode pa=headA;
        ListNode pb=headB;
        
        while(pa!=pb){
            if(pa==pb) return pa;
            pa=pa==null?headB:pa.next;
            pb=pb==null?headA:pb.next;
        }
        
       return pa;
    }
}