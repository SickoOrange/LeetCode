class Solution {

  public int findPairs(int[] nums, int k) {
    //blute force
//    Set<Integer> res = new HashSet<>();
//    for (int i = 0; i < nums.length; i++) {
//      int point = i + 1;
//      while (point < nums.length) {
//        if (Math.abs(nums[i] - nums[point]) == k) {
//          res.add(nums[i]  + nums[point]);
//        }
//        point++;
//      }
//    }
    //return res.size();

    //better performance
    Arrays.sort(nums);
    int cnt = 0;
    for (int i = 0, j = 0; i < nums.length - 1; i++) {
      j = i + 1;
      while (j < nums.length - 1 && nums[j] - nums[i] < k) {
        j++;
      }

      if (nums[j] - nums[i] == k) {
        cnt++;
      }
      //filter duplicate indices
      while (i < nums.length - 1 && nums[i + 1] == nums[i]) {
        i++;
      }
    }
    return cnt;
  }
}
