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
    public TreeNode sortedArrayToBST(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        return helper(nums,l,r);
    }
    
    private TreeNode helper(int nums[], int left, int right){
        if(left>right)
            return null;
        
        int mid = (left + right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums,left, mid-1);
        root.right = helper(nums,mid+1, right);
        
        return root;
    }
}