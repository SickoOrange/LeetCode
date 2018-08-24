import java.util.Stack;

class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                if (!sStack.isEmpty()) {
                    sStack.pop();
                }
            } else {
                sStack.push(S.charAt(i));
            }
        }

        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '#') {
                if (!tStack.isEmpty()) {
                    tStack.pop();
                }
            } else {
                tStack.push(T.charAt(i));
            }
        }

        StringBuffer sBuf = new StringBuffer();
        StringBuffer tBuf = new StringBuffer();

        while (!sStack.isEmpty()) {
            sBuf.append(sStack.pop());
        }

        while (!tStack.isEmpty()) {
            tBuf.append(tStack.pop());
        }

        return sBuf.toString().equals(tBuf.toString());
    }
}