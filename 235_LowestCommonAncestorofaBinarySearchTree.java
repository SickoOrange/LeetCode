class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        if(root.val > Math.max(p,q)){
            //search left sub tree
            return lowestCommonAncestor(root.left,p,q);
        }else if(root.val < Math.min(p,q)){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;

        //迭代
        // TreeNode node = root;
        // while(node != null){
        //     if(p.val < node.val && q.val < node.val){
        //         node = node.left;
        //     }else if(p.val > node.val && q.val > node.val){
        //         node = node.right;
        //     }else{
        //         return node;
        //     }
        // }
        // return null;//?
        
    }
}