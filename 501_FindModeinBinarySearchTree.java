class Solution {
   private int count = -1;
	private int lastVal = Integer.MAX_VALUE;
	private int maxCount = 0;
 
	private List<Integer> list = new LinkedList<Integer>();
 
	public int[] findMode(TreeNode root) {
		find(root);
		//check last part
		if (count > maxCount) {
			list.clear();
			list.add(lastVal);
		} else if (count == maxCount) {
			list.add(lastVal);
		}
 
		int[] results = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			results[i] = list.get(i);
		}
		return results;
 
	}
 
	private void find(TreeNode root) {
		if (root == null) {
			return;
		}
		find(root.left);
		if (root.val != lastVal) {
			if (count > maxCount) {
				maxCount = count;
				list.clear();
				list.add(lastVal);
			} else if (count == maxCount) {
				list.add(lastVal);
			}
			count = 1;
			lastVal = root.val;
		} else {
			count++;
		}
		find(root.right);
    }
}

