class Solution {
    // 最傻逼的做法：首先创建一个temp数组保存排序过后的数组
    //然后求出temp数组的left 和right部分，分别从left 和right的末端开始取值填充到原数组中
    public void wiggleSort(int[] nums) {
            if (nums == null || nums.length == 1) return;
            int[] temp = Arrays.copyOf(nums, nums.length);
            Arrays.sort(temp);
//            int mid = (temp.length - 1) / 2;
//            int k = mid;
//            for (int i = 0; i < nums.length; i += 2) {
//                if (k >= 0) nums[i] = temp[k--];
//            }
//
//            int m = temp.length - 1;
//            for (int i = 1; i < nums.length; i += 2) {
//                if (m > mid) nums[i] = temp[m--];
//            }
//          only one for loop
            int m = (temp.length - 1) / 2, n = temp.length - 1;
            for (int i = 0; i < nums.length; i++) {
                nums[i] = (i % 2) == 0 ? temp[m--] : temp[n--];
            }
        
    }
}
