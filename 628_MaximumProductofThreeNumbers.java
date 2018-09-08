class Solution {
    public int maximumProduct(int[] nums) {

        // solution 1: brute force time exceeded.
        class Solution {
            public int maximumProduct(int[] nums) {
                // solution 1: brute force
                if(nums.length==3) return nums[0] * nums[1] * nums[2];
                int max=nums[0] * nums[1] * nums[2];
                for (int i = 0; i < nums.length - 2; i++) {
                    for (int j = i + 1; j < nums.length - 1; j++) {
                        for (int k = j + 1; k < nums.length; k++) {
                            if(max<nums[i] * nums[j] * nums[k]){
                                max=nums[i] * nums[j] * nums[k];
                            }
                        }
                    }
                }
                return max;
            }
        }
    }
}