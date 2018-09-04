import java.util.Stack;

class Solution {
    public void moveZeroes(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for (int n : nums) {
            if (n == 0) {
                count++;
            } else {
                stack.push(n);
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i >= nums.length - count) {
                nums[i] = 0;
            } else {
                nums[i] = stack.pop();
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}