class Solution {
    public int[][] flipAndInvertImage(int[][] A) {

        int len = A[0].length;

        for (int[] a : A) {
            for (int i = 0; i < (len + 1) / 2; i++) {
                int temp = a[len - i - 1] ^ 1;
                a[len - i - 1] = a[i] ^ 1;
                a[i] = temp;
            }
        }
        return A;
    }
}