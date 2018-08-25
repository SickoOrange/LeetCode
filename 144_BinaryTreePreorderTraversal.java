import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            if (stack.peek() != null) {
                TreeNode cur = stack.pop();
                list.add(cur.val);
                stack.push(cur.right);
                stack.push(cur.left);
            } else {
                stack.pop();
            }

        }

        return list;
    }
}