/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        
        if(head==null || head.next==null) return head;
        //point to last value of sorted list
        ListNode sort=head;
        //pooint to first value of unsorted list
        ListNode unSort=head.next;
        
        while(unSort!=null){
            //pay attention for equation! (if two element are equal, there is no need to switch them)
            if(sort.val <= unSort.val){
                unSort=unSort.next;
                sort=sort.next;;
            }else{
                //check whether the first unSort node < head of node?
                //if yes we need put this node at the first position and update the head node
                
                // record the unsort node which will be inserted into sort list in the next round
                ListNode temp=unSort.next; 
                
                if(unSort.val < head.val){                    
                    //switch the unSort node and head node
                    unSort.next=head;
                    sort.next=temp;
                    //now unSort will be our new head
                    head=unSort;
                    //update the unSort point
                    unSort=temp;
                    
                }else{
                    // if go to this condition, we know that the unSort Node should be in the somewhere
                    // bewteen head node and sort node, so we need to try to find this position, record prev and succ node of                         // this postion and insert the unSort into this position
                    
                    ListNode prev=head;
                    ListNode succ=head.next;
                    while(unSort.val>succ.val){
                        prev=prev.next;
                        succ=succ.next;
                    }
                    // after this while loopm, we have already found the right position 
                    // in which the unSort node should be inserted
                                   
                    sort.next=temp;
                    unSort.next=succ;
                    prev.next=unSort;
                    
                    //update unSort to next position 
                    unSort=temp;
                    
                }
            }
        }
        
        //the node list should be sorted and just return the head node
        return head;
        
    }
}