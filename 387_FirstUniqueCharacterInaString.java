class Solution {
    public int firstUniqChar(String s) {

        int[] repeatCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            repeatCount[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (repeatCount[c - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}