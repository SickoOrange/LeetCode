import java.util.ArrayList;
import java.util.List;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {

    List<Integer> list = new ArrayList<>();

    public List<Integer> postorder(Node root) {

        if (root == null)
            return list;

        for (Node node : root.children) {
            postorder(node);
        }

        list.add(root.val);

        return list;

    }
}

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node ele = stack.pop();
            list.add(ele.val);
            for (Node node : ele.children) {
                stack.push(node);
            }
        }
        Collections.reverse(list);
        return list;

    }
}