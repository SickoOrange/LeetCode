import java.util.HashSet;
import java.util.Set;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return search(root, k, set);
    }

    public boolean search(TreeNode root, int k, Set<Integer> set) {
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return search(root.left, k, set) || search(root.right, k, set);
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(root,list);
        int i = 0;
        int j = list.size()-1;
        while (i < j) {
            int sum = list.get(i) + list.get(j);
            if (sum == k)
                return true;
            if (sum > k)
                j--;
            else
                i++;
        }
        return false;
    }

    public void dfs(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
}