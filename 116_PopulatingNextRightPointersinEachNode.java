/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    TreeLinkNode[] pres=new TreeLinkNode[100];
    public void connect(TreeLinkNode root) {
        dfs(root,0);
        for(TreeLinkNode node:pres){
            if(node!=null) node.next=null;
        }
    }
    
    public void dfs(TreeLinkNode root, int depth){
        if(root == null) return;
        if(pres[depth]!=null) pres[depth].next=root;
        pres[depth]=root;
        dfs(root.left,depth+1);
        dfs(root.right,depth+1);
    }
}