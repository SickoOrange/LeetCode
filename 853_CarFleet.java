import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if (position == null || speed == null || position.length == 0 || speed.length == 0
                || position.length != speed.length)
            return 0;
        Map<Integer, Integer> speedMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= position.length - 1; i++) {
            speedMap.put(position[i], speed[i]);
        }

        Arrays.sort(position);
        stack.push(position[position.length - 1]);
        for (int i = position.length - 2; i >= 0; i--) {
            if ((target - position[i]) / (double) speedMap.get(position[i]) > (target - stack.peek())
                    / (double) speedMap.get(stack.peek())) {
                stack.push(position[i]);
            }
        }

        return stack.size();
    }
}