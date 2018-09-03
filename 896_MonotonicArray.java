class Solution {
    public boolean isMonotonic(int[] A) {

        int lastValue = 0;
        for (int i = 0; i < A.length - 1; i++) {
            int cur = A[i] - A[i + 1] == 0 ? 0 : A[i] - A[i + 1] > 0 ? 1 : -1;
            if (cur != 0) {
                if (lastValue != 0 && lastValue != cur) {
                    return false;
                } else {
                    lastValue = cur;
                }
            }
        }
        return true;
    }
}