class Solution {
    public int countBinarySubstrings(String s) {
        char[] chars = s.toCharArray();
        int num = 0;
        int curr = 1;
        int prev = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                curr++;
            } else {
                num += Math.min(prev, curr);
                prev = curr;
                curr = 1;
            }
        }

        return num + Math.min(prev, curr);
    }
}
