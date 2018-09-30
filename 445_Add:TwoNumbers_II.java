class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode p1 = l1;
        ListNode p2 = l2;


        int len1 = 0;
        int len2 = 0;

        while (p1 != null) {
            p1 = p1.next;
            len1++;
        }

        while (p2 != null) {
            p2 = p2.next;
            len2++;
        }

        ListNode res;
        if (len1 > len2) {
            int diff = len1 - len2;
            ListNode node = new ListNode(0);
            ListNode p = node;
            while (diff > 1) {
                p.next = new ListNode(0);
                p = p.next;
                diff--;
            }
            p.next = l2;

            res = add(l1, node);


        } else if (len1 < len2) {
            int diff = len2 - len1;
            ListNode node = new ListNode(0);
            ListNode p = node;
            while (diff > 1) {
                p.next = new ListNode(0);
                p = p.next;
                diff--;
            }
            p.next = l1;
            res = add(node, l2);
        } else {
            res = add(l1, l2);

        }


        if (res.val >= 10) {
            ListNode head = new ListNode(1);
            res.val = res.val - 10;
            head.next = res;
            return head;
        }
        
        return res;

    }

    private ListNode add(ListNode p1, ListNode p2) {
        if (p1 == null && p2 == null) return null;

        ListNode node = add(p1.next, p2.next);
        int bit = 0;

        if (node != null) {
            bit = node.val - 10 >= 0 ? 1 : 0;
            node.val = node.val - 10 >= 0 ? node.val - 10 : node.val;
        }


        int a = p1.val;
        int b = p2.val;

        ListNode res = new ListNode(a + b + bit);
        res.next = node;
        return res;

    }
}