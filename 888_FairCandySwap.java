class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {

        int sumA = 0;
        int sumB = 0;
        for (int a : A) {
            sumA += a;
        }

        for (int b : B) {
            sumB += b;
        }

        int[] res = new int[2];
        for (int a : A) {
            int b = a - (sumA - sumB) / 2;
            if (isArrayContainsElement(b, B)) {
                res[0] = a;
                res[1] = b;
            }
        }

        return res;

    };

    public boolean isArrayContainsElement(int e, int[] array) {
        for (int a : array) {
            if (a == e)
                return true;
        }
        return false;
    }
}