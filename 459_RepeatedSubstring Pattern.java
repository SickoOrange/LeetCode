class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();

        for (int i = 1; i <= length / 2; i++) {

            if (length % i == 0) {
                String pattern = s.substring(0, i);
                int j;
                for (j = 1; j < length / i; j++) {
                    System.out.println(i * j + " " + (i * j + i));
                    if (!pattern.equals(s.substring(i * j, i * j + i))) {
                        break;
                    }
                }
                if (j == length / i) return true;
            }
        }
        return false;
    }
}
