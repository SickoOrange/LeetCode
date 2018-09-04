import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; i < matrix[i].length; j++) {
                if (!map.containsKey(j - i)) {
                    map.put(j - i, matrix[i][j]);
                } else {
                    if (map.get(j - i) != matrix[i][j]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}