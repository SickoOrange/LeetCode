import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int depth = 0;
        LinkedList<TreeNode> searchQueue = new LinkedList<>();

        searchQueue.add(root);
        searchQueue.add(null);

        while (searchQueue.size() > 1) {
            TreeNode cur = searchQueue.poll();
            if (cur == null) {
                searchQueue.add(null);
                depth++;
            } else {

                if (cur.left != null) {
                    searchQueue.add(cur.left);
                }
                if (cur.right != null) {
                    searchQueue.add(cur.right);
                }

                if (map.get(depth) == null) {
                    List<Integer> list = new ArrayList<>();
                    list.add(cur.val);
                    map.put(depth, list);
                } else {
                    map.get(depth).add(cur.val);
                }
            }
        }
        map.entrySet().forEach(e -> {
            List<Integer> value = e.getValue();
            if (e.getKey() % 2 != 0) {
                Collections.reverse(value);
            }
            res.add(value);
        });
        return res;

    }
}