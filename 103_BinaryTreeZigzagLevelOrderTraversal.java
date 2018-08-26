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

            if (res.size() <= depth) {
                res.add(new LinkedList<>());
            }

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

                if (depth % 2 == 0)
                    res.get(depth).add(cur.val);
                else
                    res.get(depth).add(0, cur.val);
            }
        }
        return res;
    
    }
}