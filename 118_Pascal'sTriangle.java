import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> list = new ArrayList<>();
        if (numRows == 0) return list;

        list.add(Arrays.asList(1));
        if (numRows == 1) return list;

        list.add(Arrays.asList(1, 1));
        if (numRows == 2) return list;

        for (int i = 2; i < numRows; i++) {
            List<Integer> subList = new ArrayList<>();
            subList.add(1);
            for (int j = 1; j < i; j++) {
                subList.add(list.get(i - 1).get(j) + list.get(i - 1).get(j - 1));
            }
            subList.add(1);
            list.add(subList);
        }

        return list;
    }
}
