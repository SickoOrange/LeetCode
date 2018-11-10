
//深度搜索优先 效率比较低
class Solution {
    int path = Integer.MIN_VALUE;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        find(root);
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
        
        path = path >= left+right ? path : left+right;
        return left>right? left: right;
    }
}

//最优解
class Solution {
    int path = 0;

    public int longestUnivaluePath(TreeNode root) {
        find(root,0);
        return path;
    }

    public int find(TreeNode root,int val) {
        if (root == null) return 0;
        int left=find(root.left,root.val);
        int right=find(root.right,root.val);
        path=Math.max(path, left + right);
        return root.val==val? Math.max(left, right) + 1 : 0;
    }
}