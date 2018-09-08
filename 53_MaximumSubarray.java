class Solution {
    public int maxSubArray(int[] nums) {
        // solution 1: brute force time exceeded!
        // int max = Integer.MIN_VALUE;
        // for (int i = 1; i <= nums.length; i++) {
        // for (int j = 0; j < nums.length; j++) {
        // if (j + i <= nums.length) {
        // int sum = 0;
        // for (int k = j; k < i + j; k++) {
        // sum += nums[k];
        // }
        // max = Math.max(max, sum);
        // }
        // }
        // }
        // return max;

        // solution 2: dynamic programming!
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[1] : nums[1];
            max = Math.max(max, dp[i]);
        }
        return max;

        //solution 3: divide and conqure!

        //solution 4: kadane algorithm
        // int maxSubArray(vector<int>& nums) {
        //     if(nums.empty()) return 0;
        //     int sum=nums[0];
        //     int max=sum;
        //     for(int i=1;i<nums.size();++i){
        //         sum=(sum+nums[i])>nums[i]?(sum+nums[i]):nums[i];
        //         max=sum>max?sum:max;
        //     }
        //     return max;
        }
    }
}