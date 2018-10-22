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
    int secondMin=Integer.MAX_VALUE;
    int min;
    public int findSecondMinimumValue(TreeNode root) {
        min=root.val;
        dfs(root);
        return secondMin==Integer.MAX_VALUE?-1:secondMin;
    }
    
    public void dfs(TreeNode root){
        if(root == null ) return ;
        if(root.val>min && root.val< secondMin){
            secondMin=root.val;
        }
        dfs(root.left);
        dfs(root.right);
        
    }
}