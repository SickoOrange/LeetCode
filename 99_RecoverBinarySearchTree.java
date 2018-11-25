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
    TreeNode pre;
    TreeNode m1;
    TreeNode m2;
    public void recoverTree(TreeNode root) {
        dfs(root);
        int temp=m1.val;
        m1.val=m2.val;
        m2.val=temp;
    }
    
    public void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        if(pre!=null && pre.val>root.val){
            if(m1==null){
                m1=pre;
                m2=root;
            }else{
                m2=root;
            }
        }
        pre=root;
        dfs(root.right);
    }
}