class Solution {
    public int pivotIndex(int[] nums) {
        if (nums.length <= 2) return -1;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            for (int l = 0; l < i; l++) left += nums[l];
            int diff = sum - nums[i];
            if (diff % 2 == 0 && diff / 2 == left) return i;
        }
        return -1;
    }
}

//optimazation
class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int curSum = 0;
        for(int num:nums){
            sum += num;
        }
        for(int i = 0; i < nums.length; i++){
            if(sum - nums[i] == 2 * curSum) return i;
            curSum += nums[i];
        }
        return -1;
    }
}