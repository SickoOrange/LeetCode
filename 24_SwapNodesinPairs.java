class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode curr=head;
        ListNode realHead=curr.next;
        ListNode prev=null;

        while(curr!=null&&curr.next!=null){

            ListNode next=curr.next.next;
            curr.next.next=curr;
            if(prev!=null){
                prev.next=curr.next;
               
            }
             curr.next=null;
            prev=curr;
            curr=next;
        }
        if(curr!=null) prev.next=curr;
        return realHead;
    }
}