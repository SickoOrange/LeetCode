/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        //head.next==null return head will lead to error!!!!!!!!!!!!!!!
        if (head == null) return head;

        Node curr = head;
        while (curr != null) {
            if (curr.child != null) {
                
                Node node = flatten(curr.child);
                Node nextNode = curr.next;

                node.prev = curr;
                curr.next = node;
                curr.child = null;

                Node last = node;
                while (last.next != null) {
                    last = last.next;
                }
                last.next = nextNode;
                
               if(nextNode!=null){
                    nextNode.prev = last;
                }

                curr = nextNode;
            } else {
                curr = curr.next;
            }
        }
        return head;

    }
}