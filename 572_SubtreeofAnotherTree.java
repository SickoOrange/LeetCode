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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return dfs(s,t);
    }
    public boolean dfs(TreeNode s, TreeNode t){
       return s!=null && (isSame(s,t) || dfs(s.left,t) || dfs(s.right, t));
    }
    
    public boolean isSame(TreeNode s, TreeNode t){
        if(s==null && t==null) return true;
        if(s==null || t== null) return false;
        return s.val== t.val && isSame(s.left,t.left) &&                                                         isSame(s.right,t.right);
    }
}