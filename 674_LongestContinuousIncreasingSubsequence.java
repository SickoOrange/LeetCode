class Solution {
    public int findLengthOfLCIS(int[] nums) {

        int start = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i=start) {

            while (i != nums.length - 1 || nums[i + 1] > nums[i])
                i++;

            if (maxLen < i - start + 1)
                maxLen = i - start + 1;

            start = i + 1;
        }

        return maxLen;

    }
}