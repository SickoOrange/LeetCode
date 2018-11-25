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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return builder(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    
    public TreeNode builder(int[] inorder, int il,int ir,int[] postorder,int pl,int pr){
        if(pl>pr) return null;
        TreeNode root=new TreeNode(postorder[pr]);
        int index=il;
        while(inorder[index]!=postorder[pr]) index++;
        root.left=builder(inorder,il,index-1,postorder,pl,pl+index-il-1);
        root.right=builder(inorder,index+1,ir,postorder,pl+index-il,pr-1);
        return root;
    }
}