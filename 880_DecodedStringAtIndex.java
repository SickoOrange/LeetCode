import java.util.Stack;


//ac version
class Solution {
    public String decodeAtIndex(String S, int K) {
        long size = 0;
        int N = S.length();

        // Find size = length of decoded string
        for (int i = 0; i < N; ++i) {
            char c = S.charAt(i);
            if (Character.isDigit(c))
                size *= c - '0';
            else
                size++;
        }

        for (int i = N-1; i >= 0; --i) {
            char c = S.charAt(i);
            K %= size;
            if (K == 0 && Character.isLetter(c))
                return Character.toString(c);

            if (Character.isDigit(c))
                size /= c - '0';
            else
                size--;
        }

        throw null;
    }
}
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
