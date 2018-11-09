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
   int sum=0;
    public int sumNumbers(TreeNode root) {
        dfs(root,new StringBuilder());
        return sum;
    }
    
    public void dfs(TreeNode root,StringBuilder builder){
        if(root == null) return ;
        //its a leaf we calculate the sum with each node
        builder.append(root.val);
        if(root.left==null && root.right == null){
            System.out.println(builder.toString());
            sum+=Integer.valueOf(builder.toString());
        }
        if(root.left!=null ) dfs(root.left,new StringBuilder(builder));
        if(root.right!=null) dfs(root.right,new StringBuilder(builder));
    }
}

//best solution
class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }
    
    public int dfs(TreeNode root,int sum){
        if(root == null) return 0;
        //its a leaf we calculate the sum with each node
        if(root.left==null && root.right == null){
            return sum*10+root.val;
        }
        int res =0;
        if(root.left!=null ) res+=dfs(root.left,sum*10+root.val);
        if(root.right!=null) res+=dfs(root.right,sum*10+root.val);
        return res;
    }
}