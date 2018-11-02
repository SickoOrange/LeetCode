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
    public boolean isBalanced(TreeNode root) {
            if(root == null ) return true;
            if(Math.abs(maxDepth(root.left)-maxDepth(root.right)) > 1 ) return false;
            return isBalanced(root.left) && isBalanced(root.right);      
    }
    
    public int maxDepth(TreeNode root){
        if(root ==null) return 0;
        int left=maxDepth(root.left)+1;
        int right=maxDepth(root.right)+1;
        return left>right ? left++ : right++ ;
        
    }
    

}