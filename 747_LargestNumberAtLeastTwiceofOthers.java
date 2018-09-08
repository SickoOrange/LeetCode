class Solution {
    public int dominantIndex(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[max] && nums[max] < 2 * nums[i]) {
                return -1;
            }
        }
        return max;
    }
}