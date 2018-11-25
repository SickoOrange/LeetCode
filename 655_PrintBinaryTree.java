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
    int width;
       public List<List<String>> printTree(TreeNode root) {
           int height=getMaxHeight(root);
           width=(int)Math.pow(2,height)-1;
           List<List<String>> list=new ArrayList<>();
           dfs(root,list,0,0,width-1);
           return list;
       }

       public void dfs(TreeNode root,List<List<String>> list,int depth,int l, int r){
           if(root == null) return ;
           int mid=(l+r)/2;

           if(depth>=list.size()){
               List<String> sub=new ArrayList<>();
               for(int i=0;i<width;i++){
                   if(i==mid) sub.add(i,String.valueOf(root.val));
                   else sub.add(i,"");
               }
               list.add(depth,sub);
           }else{
               list.get(depth).set(mid,String.valueOf(root.val));
           }

           dfs(root.left,list,depth+1,l,mid-1);
           dfs(root.right,list,depth+1,mid+1,r);
       }

       public int getMaxHeight(TreeNode root){
           if(root == null ) return 0;
           int left=getMaxHeight(root.left);
           int right=getMaxHeight(root.right);
           return Math.max(left,right)+1;
       }
}