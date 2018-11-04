class Solution {
    public int minDepth(TreeNode root) {
        // 10.31.2018
        
        if (root == null) return 0;
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}

//my Solution
class Solution {
    
    public int minDepth(TreeNode root) {
        if(root == null ) return 0;
        int left=minDepth(root.left)+1;
        int right=minDepth(root.right)+1;
        return (left ==1 || right ==1) ? left==1? right : left : Math.min(left,right);
        
    }
}