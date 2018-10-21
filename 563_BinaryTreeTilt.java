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
    int sum=0;
    public int findTilt(TreeNode root) {
        dfs(root);
        return sum;
    }
    
    public int dfs(TreeNode root){
        if(root == null) return 0;
        int left=dfs(root.left);
        int right=dfs(root.right);
        sum += Math.abs(left-right);
        return root.val+left+right;
    }
}