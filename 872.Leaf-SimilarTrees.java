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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        if(root1==null && root2==null) return true;
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        dfs(root1,list1);
        dfs(root2,list2);
        
        int i=0;
        int j=0;
        while(i < list1.size() && j < list2.size()){
            if(list1.get(i) != list2.get(j)) return false;
            i++;
            j++;
        }
        return true;

    }
    
     public void dfs(TreeNode root, List<Integer> list){
        if(root==null) return;
        if(root.left==null&&root.right==null) list.add(root.val);
        if(root.left!=null) dfs(root.left,list);
        if(root.right!=null) dfs(root.right,list); 
    }
}
