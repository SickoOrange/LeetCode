/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {

        List<Integer> counts = new ArrayList<>();
        List<Double> sums = new ArrayList<>();

        dfs(root, 0, counts, sums);
        for (int i = 0; i < counts.size(); i++) {
            sums.set(i, sums.get(i) / counts.get(i));
        }
        return sums;

    }

    public void dfs(TreeNode root, int i, List<Integer> counts, List<Double> sums) {
        if (root == null)
            return;
        if (i < counts.size()) {
            counts.set(i, counts.get(i) + 1);
            sums.set(i, sums.get(i) + root.val);
        } else {
            counts.add(1);
            sums.add(1.0 * root.val);
        }
        dfs(root.left, i + 1, counts, sums);
        dfs(root.right, i + 1, counts, sums);

    }
}