
//not AC
class Solution {
    int path = Integer.MIN_VALUE;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        path = Math.max(path, find(root));
        longestUnivaluePath(root.left);
        longestUnivaluePath(root.right);
        return path;
    }

    public int find(TreeNode root) {
        if (root == null) return 0;
        int left = 0;
        if (root.left != null && root.left.val == root.val) {
            left = find(root.left)+1;
        }

        int right = 0;
        if (root.right != null && root.right.val == root.val) {
            right = find(root.right)+1;
        }

        return left + right;
    }