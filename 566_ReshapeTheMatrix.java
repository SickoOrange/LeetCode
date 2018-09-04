class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {

        int row = nums.length;
        int column = nums[0].length;
        if (row * column != r * c) {
            return nums;
        }
        int[][] res = new int[r][c];
        int step = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                step++;
                res[(step - 1) / column][(step - 1) % column] = nums[row][column];
            }
        }
        return res;
    }
}