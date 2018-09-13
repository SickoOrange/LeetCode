class Solution {
    public int rotatedDigits(int N) {
        int cnt = 0;
        for (int i = 0; i <= N; i++) {
            if (isValid(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean isValid(int i) {
        boolean isValid = false;
        while (i > 0) {
            if (i % 10 == 2 || i % 10 == 5 || i % 10 == 6 || i % 10 == 9) isValid = true;
            if (i % 10 == 3 || i % 10 == 4 || i % 10 == 7) return false;
            i /= 10;
        }
        return isValid;
    }
}
