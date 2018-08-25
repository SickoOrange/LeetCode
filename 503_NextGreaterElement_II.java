import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums.length == 0)
            return new int[0];

        Stack<Integer> stack = new Stack<>();
        int length = nums.length * 2 - 1;

        int[] temp = new int[length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = -1;
        }

        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && nums[stack.peek() % nums.length] < nums[i % nums.length]) {
                temp[stack.pop()] = nums[i % nums.length];
            }
            stack.push(i);
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = temp[i];
        }

        return res;
    }
}
