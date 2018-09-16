class Solution {
    public boolean checkRecord(String s) {
        int A = 0;
        if (s.startsWith("A")) A++;
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == s.charAt(i - 1)) {
                count++;
                if ((ch == 'L' && count > 2) || (ch == 'A' && count > 1)) return false;
            } else {
                count = 1;
            }

            if (ch == 'A') A++;
        }
        if (A > 1) return false;
        return true;
    }
}