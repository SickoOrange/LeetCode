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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return builder(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    
    public TreeNode builder(int[] preorder, int pl,int pr,int[] inorder,int il,int ir){
        if(pl>pr) return null;
        TreeNode root= new TreeNode(preorder[pl]);
        int index=il;
        while(inorder[index]!=preorder[pl]) index++; 
        root.left=builder(preorder,pl+1,pl+index-il,inorder,il,index-1);
        root.right=builder(preorder,pl+index-il+1,pr,inorder,index+1,ir);
        return root;
        
    }
}