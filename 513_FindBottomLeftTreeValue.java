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
    
    public int maxDepth=Integer.MIN_VALUE;
    public int leftMost=0;
    public int findBottomLeftValue(TreeNode root) {
        int depth=0;
        dfs(root,depth);
        return leftMost;
    }
    
    public void dfs(TreeNode root, int depth){
        if(root == null) return;
        //if a new max depth is found, then we update the maxDepth and the leftMost value
        if(depth>maxDepth){
            maxDepth=depth;
            leftMost=root.val;
        }
        dfs(root.left, depth+1);
        dfs(root.right,depth+1);
    }
}