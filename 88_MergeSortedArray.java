class Solution {

  public void merge(int[] nums1, int m, int[] nums2, int n) {

   for (int i = 0; i < n; i++) {
      int j = m + i - 1;
      int key = nums2[i];
      while (j >= 0 && key < nums1[j]) {
        nums1[j + 1] = nums1[j];
        j--;
      }
      nums1[j + 1] = key;
    }
  }
}
