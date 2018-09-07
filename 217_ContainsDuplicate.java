import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {

        // soliution1: native linear scan
        // for (int i = 0; i < nums.length ; i++) {
        // for (int j = i + 1; j < nums.length ; j++) {
        // if (nums[i] == nums[j]) {
        // return true;
        // }
        // }
        // }
        // return false;

        // solution 2: sort, best solution 
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                return true;
        }
        return false;

        // solution 3: set or hashmap
        // Set<Integer> set = new HashSet<>();
        // for (int var : nums) {
        //     if (set.contains(var))
        //         return true;
        //     set.add(var);
        // }
        // return false;
    }
}