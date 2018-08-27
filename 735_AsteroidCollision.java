import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            int temp = asteroid;
            while (!stack.isEmpty() && stack.peek() > 0 && temp < 0) {
                int lastAsteroid = stack.pop();

                if (lastAsteroid > Math.abs(temp)) {
                    temp = lastAsteroid;
                } else if (lastAsteroid == Math.abs(temp)) {
                    temp = 0;
                }
            }

            if (temp != 0)
                stack.push(temp);
        }

        int[] res = new int[stack.size()];
        int i = stack.size() - 1;

        while (!stack.isEmpty()) {
            res[i] = stack.pop();
            i--;
        }
        return res;
    }

}