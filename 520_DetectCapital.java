class Solution {
    public boolean detectCapitalUse(String word) {
        char[] chars = word.toCharArray();
        int counter = 0;
        for (char c : chars) {
            if (c >= 'A' && c <= 'Z') {
                counter++;
            }
        }

        return counter == chars.length || counter == 0 || (counter == 1 && chars[0] >= 'A' && chars[0] <= 'Z');
    }
}
