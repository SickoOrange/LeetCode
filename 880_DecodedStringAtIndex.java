import java.util.Stack;


//not AC, memory limit exceeded
class Solution {
    public String decodeAtIndex(String S, int K) {

        StringBuilder builder = new StringBuilder();

        char[] chars = S.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (Character.isDigit(ch)) {
                int cnt = Integer.parseInt(String.valueOf(ch));
                for (int j = 0; j < cnt; j++) {
                    if (K <= builder.length() * 2) {
                        return String.valueOf(builder.charAt(K - builder.length() - 1));
                    }
                    builder.append(builder.toString());
                }

            } else {
                builder.append(ch);
                if (builder.length() >= K) {
                    return String.valueOf(builder.charAt(K - 1));
                }
            }
        }

        return "";

    }
}