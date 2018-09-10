class Solution {

  public int thirdMax(int[] nums) {
    Arrays.sort(nums);
    int valuePoint = nums.length-1;
    int counter = 2;
    for (int i = nums.length - 1; i > 0; i--) {
      if (nums[i] > nums[i - 1]) {
        valuePoint--;
        counter--;
        if (counter == 0) {
          return nums[valuePoint];
        }
      } else if (nums[i] >= nums[i - 1]) {
        valuePoint--;
      }
    }
    return nums[nums.length-1];
  }
}
