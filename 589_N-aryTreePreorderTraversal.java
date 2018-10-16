class Solution {

    List<Integer> list = new ArrayList<>();

    public List<Integer> preorder(Node root) {

        if (root == null)
            return list;

        list.add(root.val);

        for (Node node : root.children) {
            preorder(node);
        }

        return list;

    }
}

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Stack<Node> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            Node ele = stack.pop();
            list.add(ele.val);
            for (int i = ele.children.size() - 1; i >= 0; i--) {
                stack.push(ele.children.get(i));
            }
        }

        return list;

    }
}