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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
       List<List<Integer>> list=new ArrayList<>();
        dfs(root,list,0);
        Collections.reverse(list);
        return list;
        
    }
    
    public void dfs(TreeNode root, List<List<Integer>> list, int depth){
        if(root == null ) return;
        if(depth<list.size()){
            list.get(depth).add(root.val);
        }else{
            List<Integer> sub=new ArrayList<>();
            sub.add(root.val);
            list.add(depth,sub);
        }
        dfs(root.left,list,depth+1);
        dfs(root.right,list,depth+1);
    }
}