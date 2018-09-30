class MyLinkedList {

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private Node head;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (head == null) return -1;
        Node tmp = head;
        while (index > 0) {
            index--;
            tmp = tmp.next;
            if (tmp == null) return -1;
        }
        return tmp.val;

    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        if (head == null) head = new Node(val);
        else {
            Node node = new Node(val);
            node.next = head;
            head = node;
        }
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (head == null) head = new Node(val);
        else {
            Node node = new Node(val);
            Node tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = node;
        }
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        Node node = new Node(val);
        if (index == 0 && head == null) {
            head = node;
            return;
        }

        if (index > 0 && head == null) return;

        Node p = head;

        while (index > 1) {
            index--;
            p = p.next;
            if (p == null) return;
        }

        node.next = p.next;
        p.next = node;


    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (head == null) return;
        Node p = head;
        while (index > 1) {
            index--;
            p = p.next;
            if (p == null) return;
        }

        if (p.next != null) {
            p.next = p.next.next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */