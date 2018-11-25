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
    public List<TreeNode> generateTrees(int n) {
        if(n ==0) return new ArrayList<TreeNode>();
        return helper(1,n);
    }
    
    public List<TreeNode> helper(int left, int right){
        
        List<TreeNode> list=new ArrayList<>();
        
        if(left>right){
            list.add(null);
            return list;
        }
        
        for(int i=left; i<=right; i++){
            List<TreeNode> leftList=helper(left,i-1);
            List<TreeNode> rightList=helper(i+1,right);
            
            for(TreeNode l : leftList){
                for(TreeNode r : rightList){
                    TreeNode node=new TreeNode(i);
                    node.left=l;
                    node.right=r;
                    list.add(node);
                }
            }
        }
        
        return list;
    }
}