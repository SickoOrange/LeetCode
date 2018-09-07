import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        // solution 1: while loop
        // List<List<Integer>> list = new ArrayList<>();
        // int i = 0;
        // while (i < S.length()) {
        // char ch = S.charAt(i);
        // int start = i;
        // while (i < S.length() - 1 && S.charAt(i + 1) == ch) {
        // i++;
        // }
        // if (i - start >= 2) {
        // List<Integer> subGroup = new ArrayList<>();
        // subGroup.add(start);
        // subGroup.add(i);
        // list.add(subGroup);
        // }
        // i++;
        // }
        // return list;

        // solution 2: for loop
       List<List<Integer>> list = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < S.length(); i++) {
            if (i == S.length() - 1 || S.charAt(i) != S.charAt(i + 1)) {
                if (i - start >= 2) {
                    list.add(Arrays.asList(start, i));
                }
                start = i + 1;
            }
        }
        return list;

    }
}