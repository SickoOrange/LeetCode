/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//动态规划的思想
//从root出发 最大的价值应该是 max(left+right,val+ll+lr+rl+rr)
//也就是 选择从left跟right开始偷的最大收益 跟left right的四个子节点开始偷的最大收益
class Solution {
    public int rob(TreeNode root) {
        if(root == null) return 0;
        int val=root.val;
        int leftRob=0,rightRob=0;
        if(root.left!=null){
            val+=rob(root.left.left)+rob(root.left.right);
            leftRob=rob(root.left);
        }
        if(root.right!=null){
            val+=rob(root.right.left)+rob(root.right.right);
            rightRob=rob(root.right);
        }
        
        return leftRob+rightRob > val ? leftRob + rightRob : val;
        
    }
    
   
}

//http://www.cnblogs.com/tengdai/p/9282546.html

class Solution {
    public int rob(TreeNode root) {
        int[] res=dfs(root);
        return Math.max(res[0],res[1]);
    }
    
    public int[] dfs(TreeNode root){
        if(root==null) return new int[2];
        int[] left=dfs(root.left);
        int[] right=dfs(root.right);
        int[] money=new int[2];
        money[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        money[1]=root.val+left[0]+right[0];
        return money;
    }
    
 }