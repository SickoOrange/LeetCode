
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null && sum-root.val == 0) return true;
        if(hasPathSum(root.left,sum-root.val)) return true;
        if(hasPathSum(root.right, sum-root.val)) return true;
        return false;
    }
}



//solution 2: with  dfs recuresive method
class Solution {
    boolean hasPath=false;
    public boolean hasPathSum(TreeNode root, int sum) {
        dfs(root,sum);
        return hasPath;
    }
    
    public void dfs(TreeNode root, int sum){
        if(root == null) return;
        
        if(root.left == null && root.right == null && sum - root.val == 0) hasPath=true;
        
        dfs(root.left,sum-root.val);
        dfs(root.right,sum-root.val);
    }
}