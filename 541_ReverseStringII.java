class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            int start = i;
            int end = i + k - 1;
            //if (end > s.length()-1) end = s.length() - 1;
            end = Math.min(start + k - 1, chars.length - 1);
            while (start < end) {
                char temp = chars[end];
                chars[end] = chars[start];
                chars[start] = temp;
                start++;
                end--;
            }
        }
        return new String(chars);
    }
}