import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] numbers, int target) {


        //solution1: traditional 
        // Map<Integer, Integer> map = new HashMap<>();
        // int[] res = new int[2];
        // for (int i = 0; i < numbers.length; i++) {
        //     if (map.containsKey(numbers[i])) {
        //         res[0] = map.get(numbers[i]);
        //         res[1] = i;
        //         return res;
        //     } else {

        //         map.put(target - numbers[i], i);
        //     }
        // }

        //return res;

        //solution 2: two point
        int i = 0;
        int j = numbers.length-1;
        while (i < j) {
            if (numbers[i]+numbers[j] == target) {
                return new int[]{i+1,j+1};
            }
            else if (numbers[i]+numbers[j] < target) i++;
            else j--;
        }
        return new int[2];
    }
}