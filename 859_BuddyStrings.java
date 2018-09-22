class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }

        if (!A.equals(B)) {
            int a = -1;
            int b = -1;
            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) != B.charAt(i)) {
                    if (a == -1) {
                        a = i;
                    } else if (b == -1) {
                        b = i;
                    } else {
                        //diff number >2, direct return false;
                        return false;
                    }
                }
                //only one diff
            }
            if (b == -1) return false;
            return A.charAt(a) == B.charAt(b) && A.charAt(b) == B.charAt(a);
        } else {
            // when two strings is identical,so
            // so at least, for a character must appear twice
            int[] chs = new int[26];
            for (int i = 0; i < A.length(); i++) {
                int index = A.charAt(i) - 'a';
                if (chs[index] == 1) return true;
                else chs[index]++;
            }
            return false;

        }
    }
}
