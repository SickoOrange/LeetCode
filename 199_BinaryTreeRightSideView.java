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
    List<Integer> list=new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return list;
        dfs(root,0);
        return list;
    }
    
    public void dfs(TreeNode root,int depth){
        if(root == null) return ;
        if(depth==list.size()) list.add(root.val);
        dfs(root.right,depth+1);
        dfs(root.left,depth+1);
    }
}