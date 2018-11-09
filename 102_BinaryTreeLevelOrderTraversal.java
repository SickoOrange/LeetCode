//深度搜索优先 100%
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null)
            return list;
        dfs(root, list, 0);
        return list;
    }

    public void dfs(TreeNode root, List<List<Integer>> list, int depth) {
        if (root == null)
            return;

        if (list.size() - 1 < depth)
            list.add(new ArrayList<Integer>());
        list.get(depth).add(root.val);
        dfs(root.left, list, depth + 1);
        dfs(root.right, list, depth + 1);
    }
}

// 广度搜索优先 99.2%
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null)
            return list;
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int cnt = queue.size();
            List<Integer> subList = new ArrayList<>();
            while (cnt-- > 0) {
                TreeNode node = queue.poll();
                subList.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            list.add(subList);
        }
        return list;
    }
}
