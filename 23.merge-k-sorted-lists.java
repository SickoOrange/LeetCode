/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 //优先队列法 高效简洁
 //创建一个优先队列，使其元素从大到小排列，
 //位于队列头部的元素是最小元素，每次poll出 插入到dummy中， 被poll的元素的下一个nextnode
 //不为null时 在插入队列中（重排序）
 //使用匿名内部类大概12s 使用lambda大概22秒 性能差异较大
 class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        Queue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        //should check, null node will not be added into queue
        for (ListNode node : lists) if(node!=null) queue.offer(node);
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            p.next = poll;
            p = p.next;
            if (poll.next != null) queue.offer(poll.next);
        }
        return dummy.next;

    }
}
 // 简单粗暴暴力法
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
                if (lists == null) return null;

        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

        boolean flag = true;
        while (flag) {
            flag = false;
            int minIndex = -1;
            ListNode minNode = new ListNode(Integer.MAX_VALUE);
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (lists[i].val <= minNode.val) {
                        minNode = lists[i];
                        minIndex = i;

                    }
                    flag = true;
                }
            }
            if (!flag) break;
            p.next = new ListNode(minNode.val);
            p = p.next;
            if (minIndex != -1) lists[minIndex] = lists[minIndex].next;
        }
        return dummy.next;
        
    }
}