class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> leafPaths = new ArrayList<>();
        if (root == null) return leafPaths;
        dfs(root, leafPaths, new StringBuilder());
        return leafPaths;
    }

    public void dfs(TreeNode root, List<String> leafPaths, StringBuilder singlePath) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            //its leaf node
            singlePath.append(root.val);
            leafPaths.add(singlePath.toString());
        } else {
            singlePath.append(root.val).append("->");
        }
        dfs(root.left, leafPaths, new StringBuilder(singlePath));
        dfs(root.right, leafPaths, new StringBuilder(singlePath));
    }
}