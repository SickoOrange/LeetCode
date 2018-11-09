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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list=new ArrayList<>();
        if(root == null) return list;
        
        List<Integer> path=new ArrayList<>();
        dfs(root,sum,list,path);
        return list;
    }
    
    public void dfs(TreeNode root, int sum, List<List<Integer>> list, List<Integer> path){
        if(root == null) return ;
        path.add(root.val);
        if(root.left==null && root.right==null && sum-root.val==0) list.add(path);
        
        dfs(root.left,sum-root.val,list,new ArrayList<>(path));
        dfs(root.right,sum-root.val,list,new ArrayList<>(path));
    }
}

//这一次最优解应该是使用中序遍历