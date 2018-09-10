class Solution {

  public int findUnsortedSubarray(int[] nums) {
    int[] clone = nums.clone();
    Arrays.sort(clone);

    int start = nums.length - 1;
    int end = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != clone[i]) {
        start = Math.min(start, i);
        end = Math.max(end, i);
      }
    }
    return end - start + 1 > 1 ? end - start + 1 : 0;
  }
}
