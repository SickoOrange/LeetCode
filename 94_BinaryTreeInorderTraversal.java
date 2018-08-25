import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

//user inorder traversal with stack

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;

        while (!Objects.isNull(currentNode) || !stack.isEmpty()) {
            while (!Objects.isNull(currentNode)) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            list.add(currentNode.val);
            currentNode = currentNode.right;
        }
        return list;
    }
}