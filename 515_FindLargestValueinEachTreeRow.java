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
    int[] values=new int[1000];
    int maxDepth = Integer.MIN_VALUE;
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null ) return list;
        if(root.left == null && root.right == null){
            list.add(root.val);
            return list;
        }
        Arrays.fill(values,Integer.MIN_VALUE);
        dfs(root,0);
        for(int i =0; i<=maxDepth; i++) list.add(values[i]);
        return list;
        
    }
    
    public void dfs(TreeNode root,int depth){
        if(root == null) return;
        if(values[depth] < root.val) values[depth] = root.val;
        if(maxDepth < depth) maxDepth=depth;
        dfs(root.left,depth+1);
        dfs(root.right, depth+1);
    }
}