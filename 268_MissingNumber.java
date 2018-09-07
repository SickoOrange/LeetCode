import java.util.Arrays;

class Solution {
    public int missingNumber(int[] nums) {

        // solution 1: bitmap
        int[] bitmap = new int[nums.length + 1];
        for (int var : nums) {
            bitmap[var] = 1;
        }
        for (int i = 0; i < bitmap.length; i++) {
            if (bitmap[i] == 0) {
                return i;
            }
        }

        return 0;

        // solution 2: sort array
        // Arrays.sort(nums);
        // if (nums.length == 1)
        // return nums[0] ^ 1;

        // if (nums[nums.length - 1] != nums.length)
        // return nums.length;

        // for (int i = 0; i < nums.length - 1; i++) {
        // if (nums[i + 1] - nums[i] != 1) {
        // return nums[i] + 1;
        // }
        // }
        // return 0;
    }
}