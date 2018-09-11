class Solution {
    public String reverseString(String s) {
         char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length - 1;

        while (end > start) {
            char temp = chars[end];
            chars[end] = chars[start];
            chars[start] = temp;
            start++;
            end--;
        }
        return new String(chars);
    }
}
