/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null && l2==null) return null;
        if(l1==null) return l2;
        if(l2==null) return l2;

        ListNode addRes=calculate(l1,l2);
     return addRes;
    }
    public ListNode calculate(ListNode head1,ListNode head2){
        ListNode res=new ListNode(0);
        ListNode node=res;
        int bit=0;
        while(!(head1==null && head2==null)){
            int v1=head1==null?0:head1.val;
            int v2=head2==null?0:head2.val;
            node.next=new ListNode((v1+v2+bit)%10);
            bit=(v1+v2+bit)>=10?1:0;
            node=node.next;
            head1=head1==null?null:head1.next;
            head2=head2==null?null:head2.next;
        }
        if(bit==1) node.next=new ListNode(1);

        return res.next;
    }
}