/**
 * // This is the interface that allows for creating nested lists. // You should
 * not implement it, or speculate about its implementation public interface
 * NestedInteger { // Constructor initializes an empty nested list. public
 * NestedInteger();
 *
 * // Constructor initializes a single integer. public NestedInteger(int value);
 *
 * // @return true if this NestedInteger holds a single integer, rather than a
 * nested list. public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a
 * single integer // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // Set this NestedInteger to hold a single integer. public void
 * setInteger(int value);
 *
 * // Set this NestedInteger to hold a nested list and adds a nested integer to
 * it. public void add(NestedInteger ni);
 *
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList(); }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        if (!s.startsWith("[")) {
            return new NestedInteger(Integer.valueOf(s));
        }
         int i = 0;
        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger currentNI = null;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch == '[') {
                NestedInteger nestedInteger = new NestedInteger();
                stack.push(nestedInteger);
                currentNI = nestedInteger;
                i++;
            } else if (ch == ']') {
                NestedInteger pop = stack.pop();
                if (stack.isEmpty()) {
                    currentNI = pop;
                    break;
                }
                stack.peek().add(pop);
                currentNI = stack.peek();
                i++;
            } else {
                 if (s.charAt(i) == ',') {
                    i++;
                } else {
                    StringBuffer buf = new StringBuffer();
                    while (i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == '-')) {
                        buf.append(s.charAt(i));
                        i++;
                    }
                    currentNI.add(buf.toString().equals("") ? new NestedInteger()
                            : new NestedInteger(Integer.valueOf(buf.toString())));
                    if (s.charAt(i) == ',') {
                        i++;
                    }
                }
             }
        }
        return currentNI;
    }
 }