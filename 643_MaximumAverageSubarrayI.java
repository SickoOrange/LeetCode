class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int[] sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                sum[0] = nums[0];
            } else {
                sum[i] = sum[i - 1] + nums[i];
            }
        }

        double average = sum[k - 1] * 1.0 / k;

        for (int i = k; i < sum.length; i++) {
            average = Math.max(average, (sum[i] - sum[i - k]) * 1.0 / k);
        }
        return average;

    }
}