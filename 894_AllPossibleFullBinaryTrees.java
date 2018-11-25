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
    public List<TreeNode> allPossibleFBT(int N) {
        
        List<TreeNode> list=new ArrayList<>();
        if(N==1){
            TreeNode node=new TreeNode(0);
            list.add(node);
            return list;
        }
        
        for(int i=1;i<N;i+=2){
            List<TreeNode> left=allPossibleFBT(i);
            List<TreeNode> right=allPossibleFBT(N-i-1);
            for(TreeNode l: left){
                for(TreeNode r: right){
                    TreeNode node=new TreeNode(0);
                    node.left=l;
                    node.right=r;
                    list.add(node);
                }
            }
        }        
        return list;     
    }
}