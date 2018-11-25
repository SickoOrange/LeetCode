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
    List<TreeNode> list=new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String,TreeNode> map=new HashMap<>();
        dfs(root,map);
        return list;
    }
    
    public String dfs(TreeNode root,Map<String,TreeNode> map){
        StringBuilder builder=new StringBuilder();
        if(root == null){
            builder.append("#");
            return new String(builder); 
        }
        
        builder.append(root.val);
        builder.append(dfs(root.left,map));
        builder.append(dfs(root.right,map));
        
        String curr=new String(builder);
        
        if(map.containsKey(curr)){
            TreeNode node=map.get(curr);
            if(!list.contains(node)) list.add(node);
        }else{
            map.put(curr,root);
        }
        
        return curr;
        
    }
}