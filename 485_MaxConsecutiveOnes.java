class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int point = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                point++;
            } else {
                point = 0;
            }
            max = Math.max(max, point);
        }

        return max;
    }
}