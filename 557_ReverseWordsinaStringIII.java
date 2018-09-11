class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int point = 0;
        for (int i = 0; i < chars.length; i = point + 1) {
            point = i;
            while (point < chars.length && !Character.isSpaceChar(chars[point]))
                point++;

            int prev = i;
            int next = point - 1;

            while (next > prev) {
                char temp = chars[next];
                chars[next] = chars[prev];
                chars[prev] = temp;
                prev++;
                next--;
            }
        }
        return new String(chars);
    }
}
