class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null ||head.next == null) return head;

        ListNode odd=head;
        ListNode even=new ListNode(0);

        ListNode oddP=odd;
        ListNode evenP=even;

        while(oddP.next!=null){
            evenP.next=oddP.next;
            evenP=evenP.next;
            oddP.next=oddP.next.next;
            if(oddP.next==null){
                break;
            }
            oddP=oddP.next;
        }

        if(evenP.next!=null){
            evenP.next=null;
        }
        oddP.next=even.next;

        return odd;
    }
}