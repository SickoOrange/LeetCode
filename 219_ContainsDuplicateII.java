class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int end = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            end = i + 1;
            while (end < nums.length && nums[end] != nums[i]) {
                end++;
            }
            if (end >= nums.length) continue;
            if (nums[end] == nums[i] && end - i <= k) {
                return true;
            }
        }
        return false;
    }
}
