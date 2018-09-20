class Solution {
    public int countSegments(String s) {

        int m = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                m++;
            }
        }
        return m;

    }
}
