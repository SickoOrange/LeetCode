/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // if p and q are on two side
        if (left != null && right != null)
            return root;

        // if p and q are on the left side
        // then left will be the highest node of p and q , right will be null

        // if p and q are on the right side
        // then left will be null and the right will be the the highest node of p and q
        return left == null ? right : left;

    }
}