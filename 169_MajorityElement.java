class Solution {
    //solution 1: hashmap
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }
        return 0;
    }

    //solution 2:  majority voting algorithm
    public int majorityElement2(int[] nums) {

        int count = 0;
        int value = 0;
        for (int i = 0; i < nums.length; i++) {

            if (count == 0) {
                value = nums[i];
            } else if (value == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return value;
    }

}
