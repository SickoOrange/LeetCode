class Solution {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            } else {

                if (nums[i] > target) {
                    return i - 1 >= 0 ? i - 1 : 0;
                } else {
                    if (i + 1 >= nums.length || (nums[i] < target && nums[i + 1] > target)) {
                        return i + 1;
                    } else {
                        continue;
                    }
                }
            }
        }
        return -1;
    }
}