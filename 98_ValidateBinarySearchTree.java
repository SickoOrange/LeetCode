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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        ArrayList<Integer> list= new ArrayList<>();
        dfs(root,list);
        
       for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) return false;
        }
        return true;

        
    }
    public void dfs(TreeNode root, ArrayList<Integer> list){
        if(root == null) return;
        dfs(root.left,list);
        list.add(root.val);
        dfs(root.right,list);
    }
}