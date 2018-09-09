class Solution {
    public int removeDuplicates(int[] nums) {
        int point = 0;
        int duplicate = 1;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1]) {
                duplicate++;
                if (duplicate <= 2) {
                    point++;
                    nums[point] = nums[i];
                }

            } else if (nums[i] != nums[i - 1]) {
                duplicate = 1;
                point++;
                nums[point] = nums[i];
            }
        }
        return point + 1;
    }
}