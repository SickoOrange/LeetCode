/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return diameter-2;
        
    }
    
    public int dfs(TreeNode root){
        if(root == null) return 0;
        int left=dfs(root.left)+1;
        int right=dfs(root.right)+1;
        if(left+right>diameter) diameter=left+right;
        return left>=right? left: right;
    }
}