import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public String decodeString(String s) {

        Stack<Integer> counterStack = new Stack<>();
        Stack<Character> letterStack = new Stack<>();
        char[] chars = s.toCharArray();
        int m = 0;
        while (m < chars.length) {
            char ch = chars[m];
            if (Character.isDigit(ch)) {
                // handle digits
                StringBuilder bu = new StringBuilder();
                while (m < chars.length && Character.isDigit(chars[m])) {
                    bu.append(chars[m]);
                    m++;
                }
                counterStack.push(Integer.valueOf(bu.toString()));
            } else if (ch == '[' || Character.isLetter(ch)) {
                letterStack.push(ch);
                m++;
            } else if (ch == ']') {
                int counter = counterStack.pop();

                List<Character> list = new ArrayList<>();

                while (!letterStack.isEmpty() && letterStack.peek() != '[') {
                    list.add(letterStack.pop());
                }

                letterStack.pop();

                for (int i = 0; i < counter; i++) {
                    for (int k = list.size() - 1; k >= 0; k--) {
                        letterStack.push(list.get(k));
                    }
                }
                m++;
            }
        }

        StringBuilder builder = new StringBuilder();
        while (!letterStack.isEmpty()) {
            builder.append(letterStack.pop());
        }

        return builder.reverse().toString();
    }
}