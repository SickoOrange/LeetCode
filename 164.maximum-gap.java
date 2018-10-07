import java.util.Arrays;

/*
 * [164] Maximum Gap
 *
 * https://leetcode.com/problems/maximum-gap/description/
 *
 * algorithms
 * Hard (30.92%)
 * Total Accepted:    61K
 * Total Submissions: 197.3K
 * Testcase Example:  '[3,6,9,1]'
 *
 * Given an unsorted array, find the maximum difference between the successive
 * elements in its sorted form.
 * 
 * Return 0 if the array contains less than 2 elements.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,6,9,1]
 * Output: 3
 * Explanation: The sorted form of the array is [1,3,6,9], either
 * (3,6) or (6,9) has the maximum difference 3.
 * 
 * Example 2:
 * 
 * 
 * Input: [10]
 * Output: 0
 * Explanation: The array contains less than 2 elements, therefore return 0.
 * 
 * Note:
 * 
 * 
 * You may assume all elements in the array are non-negative integers and fit
 * in the 32-bit signed integer range.
 * Try to solve it in linear time/space.
 * 
 * 
 */
class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        // sort array
        // Arrays.sort(nums);

        radixSort(nums);

        int maximum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length - 1; i++) {
            maximum = Math.max(maximum, nums[i + 1] - nums[i]);
        }

        return maximum;
    }

    public void radixSort(int[] nums) {
        int max = findMax(nums);
        for (int i = 1; max / i > 0; i *= 10) {
            subCountingSort(nums, i);
        }
    }

    private void subCountingSort(int[] nums, int digit) {
        int[] output = new int[nums.length];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (int i = 0; i < nums.length; i++) {
            int temp = (nums[i] / digit) % 10;
            count[temp]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Build the output character array
        // To make it stable we are operating in reverse order.
        for (int i = nums.length - 1; i >= 0; i--) {
            int temp = (nums[i] / digit) % 10;
            output[count[temp] - 1] = nums[i];
            count[temp]--;
        }

        for (int i = 0; i < output.length; i++) {
            nums[i] = output[i];
        }
    }

    private int findMax(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max)
                max = nums[i];
        }
        return max;
    }
}
