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
     Map<Integer,Integer> map = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        
        //find most frequent sum
        List<Integer> list=new ArrayList<>();
        
        int most=Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue()>most){
                most=entry.getValue();
                list.clear();
                list.add(entry.getKey());
            }else if(entry.getValue()==most){
                list.add(entry.getKey());
            }
        }
        
        int[] res=new int[list.size()];
        for(int i=0; i<list.size(); i++){
            res[i]=list.get(i);
        }
        
        return res;
    }
    
    public void dfs(TreeNode root){
        if(root == null) return ;
        int sum=getSum(root);
        if(!map.containsKey(sum)) map.put(sum,1);
        else map.put(sum,map.get(sum)+1);
        dfs(root.left);
        dfs(root.right);
    }
    
    public int getSum(TreeNode root){
        if(root==null) return 0;
        return root.val+getSum(root.left)+getSum(root.right);
    }
}