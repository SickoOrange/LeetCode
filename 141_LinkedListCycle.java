/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
   public boolean hasCycle(ListNode head) {

    Set<ListNode> visitedNode = new HashSet<>();
    visitedNode.add(head);
    while (head != null) {
      head = head.next;
        if (visitedNode.contains(head)) {
        return true;
      }
      visitedNode.add(head);

    }
    return false;
  }
}

//better solution
public class Solution {
   public boolean hasCycle(ListNode head) {

        if(head==null) return false;
        ListNode faster=head;
        ListNode slower=head;
        while(faster.next!=null && faster.next.next!=null){
            faster=faster.next.next;
            slower=slower.next;
            if(slower==faster) return true;
        }
       return false;
       
     
  }
}
