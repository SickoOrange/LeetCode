import java.util.Stack;

class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int temp = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < temp) {
                return true;
            } else {
                while (!stack.isEmpty() && nums[i] > stack.peek()) {
                    temp = stack.peek();
                    stack.pop();
                }
            }
            stack.push(nums[i]);
        }

        return false;
    }
}