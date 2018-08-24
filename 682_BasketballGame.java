class Solution {
    public int calPoints(String[] ops) {
       Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (String s : ops) {

            switch (s) {
            case "+":
                int last = stack.pop();
                int lastLast = stack.pop();

                stack.push(lastLast);
                stack.push(last);
                stack.push(lastLast + last);
                break;
            case "D":
                stack.push(stack.peek() * 2);
                break;
            case "C":
                stack.pop();
                break;
            default:
                stack.push(Integer.valueOf(s));
                break;
            }
        }

        int sum = 0;
        while (!stack.isEmpty())
            sum += stack.pop();
        return sum;
    }
}