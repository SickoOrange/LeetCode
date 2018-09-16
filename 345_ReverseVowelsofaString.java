class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int end = chars.length - 1;
        for (int i = 0; i < end; i++) {
            int start = i;
            char ch = chars[i];
            if (isVowels(ch)) {
                while (!isVowels(chars[end])) end--;
                char temp = chars[end];
                chars[end] = chars[start];
                chars[start] = temp;
                end--;
            }
        }
        return new String(chars);
    }

    private boolean isVowels(char ch) {
        return ch == 'a' || ch == 'A'
                || ch == 'e' || ch == 'E'
                || ch == 'i' || ch == 'I'
                || ch == 'o' || ch == 'O'
                || ch == 'u' || ch == 'U';
    }
}