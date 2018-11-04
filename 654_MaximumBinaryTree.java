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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums,0,nums.length);
    }
    
    public TreeNode construct(int[] nums, int left, int right){
        if(left==right) return null;
        
        int max=left;
        for(int i=left;i<right;i++){
            if(nums[max]<nums[i]) max=i;
        }
             
        TreeNode node=new TreeNode(nums[max]);
        node.left=construct(nums, left,max);
        node.right=construct(nums,max+1,right);
        return node;
        
    }
}

