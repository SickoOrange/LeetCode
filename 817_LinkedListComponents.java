class Solution {
    public int numComponents(ListNode head, int[] G) {
        // set is better than arraylist
        // because arraylist is better for elements add and delete but very bad at elements search
        Set<Integer> subSet = new HashSet<>();
        for (int e : G) {
            subSet.add(e);
        }

        ListNode p = head;
        int cnt = 0;
        while (p != null) {
            if (subSet.contains(p.val) && (p.next == null || !subSet.contains(p.next.val))) {
                cnt++;
            }
            p = p.next;
        }
        return cnt;

    }
}