class Solution {
    public int lengthOfLastWord(String s) {
        if(s.length() == 0) return 0;
        s=s.trim();
        int c = 0;
        for(int i = s.length()-1; i>=0; i--) {
            if(s.charAt(i) != ' ') c++;
            else break;
        }
        return c;
    }
}

class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) return 0;

        int j = s.length() - 1;
        int cnt = 0;
        while (j >= 0) {
            if (s.charAt(j) == ' ') {
                if (cnt != 0) break;
            } else {
                cnt++;
            }
            j--;
        }

        return cnt;
    }
}
