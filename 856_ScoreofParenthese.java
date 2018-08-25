import java.util.Stack;

class Solution {
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        char[] chars = S.toCharArray();
        // hier we use -1 to represent char '('
        for (char ch : chars) {
            if (ch == '(')
                stack.push(-1);
            else {
                // calculate nums sum in the stack
                int sum = 0;
                while (!stack.isEmpty() && stack.peek() != -1) {
                    sum += stack.pop();
                }

                stack.pop();

                if (sum == 0) {
                    stack.push(1);
                } else {
                    stack.push(2 * sum);
                }

            }

        }
        int sum=0;
        while(!stack.isEmpty()){
            sum+=stack.pop();
        }
        return sum;
    }
}