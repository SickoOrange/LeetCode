/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode p=root;
        int len=0;
        while(p!=null){
            p=p.next;
            len++;
        }
        int part=len/k;
        int rest=len%k;
        
        ListNode nodes[]=new ListNode[k];
        
        p=root;
        
        for(int i=0;i<k;i++){        
            ListNode node=new ListNode(0),curr=node;
            
            for(int j=0;j<part+(i<rest?1:0);j++){
                curr.next=new ListNode(p.val);
                curr=curr.next;
                p=p.next;
            }
            nodes[i]=node.next;
            
        }
        return nodes;
    }
}