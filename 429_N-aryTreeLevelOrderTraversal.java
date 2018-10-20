/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root == null) return list;
        dfs(root,list,0);
        return list;
    }
    
    public void dfs(Node root,List<List<Integer>> list, int i){
        if(root == null) return ;
        if(i<list.size()){
            list.get(i).add(root.val);
        }else{
            List<Integer> leaves=new ArrayList<>();
            leaves.add(root.val);
            list.add(i,leaves);
        }
        for(Node node:root.children){
            dfs(node,list,i+1);
        }
    }
}