class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            int v1;
            int v2;
            switch (tokens[i]) {
            case "+":
                v1 = stack.pop();
                v2 = stack.pop();
                stack.push(v2 + v1);
                break;
            case "-":
                v1 = stack.pop();
                v2 = stack.pop();
                stack.push(v2 - v1);
                break;
            case "*":
                v1 = stack.pop();
                v2 = stack.pop();
                stack.push(v2 * v1);
                break;
            case "/":
                v1 = stack.pop();
                v2 = stack.pop();
                stack.push(v2 / v1);
                break;
            default:
                stack.push(Integer.valueOf(tokens[i]));
                break;
            }
        }
        return stack.pop();
    }
}
