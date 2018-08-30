import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
            if (num.length() == k)
            return "0";
        Stack<Character> stack = new Stack<>();

        char[] chars = (num + "0").toCharArray();

        for (int i = 0; i < chars.length; i++) {
            while (!stack.isEmpty() && stack.peek() > chars[i] && k > 0) {
                stack.pop();
                k--;
            }
            if (i < chars.length - 1)
                stack.push(chars[i]);
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        
        StringBuilder res = builder.reverse();
        while (res.length() != 1 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }
        return res.toString();

    }
}