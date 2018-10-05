//手撕归并排序
//二分查找求H，定义查找，还有一种最优解发 利用类似桶排序 见note！！！
class Solution {
    public int hIndex(int[] citations) {
    if (citations == null || citations.length == 0) {
      return 0;
    }

    //sort array
    mergeSort(citations, 0, citations.length - 1);

    //first solution use definition of h-index.
    //at least h papers have h citations
    // 维基百科 定义
    // for (int i = citations.length - 1; i >= 0; i--) {
    //   if (citations[i] < citations.length - i) {
    //     return citations.length - i - 1;
    //   }
    //   if(i==0) return citations.length;
    // }
    // return 0;
        
    //二分查找
    int i = 0, j = citations.length - 1;
    while (i <= j) {
      int mid = (i + j) / 2;
      if (citations[mid] >= citations.length - mid) {
        j = mid - 1;
      } else {
        i = mid + 1;
      }
    }
    return citations.length - i;
  }
     public void mergeSort(int[] arr, int low, int high) {
    //if array has only one element, the recursive should be stopped
    if (low < high) {
      int mid = (low + high) / 2;
      mergeSort(arr, low, mid);
      mergeSort(arr, mid + 1, high);
      merge(arr, low, mid, high);
    }
  }

  private void merge(int[] arr, int low, int mid, int high) {

    //calculate two sub arrays's length and build two sub arrays which are needed to be merged
    int left = mid - low + 1;
    int right = high - mid;
    int[] arr1 = new int[left];
    int[] arr2 = new int[right];

    //build left sub array
    for (int i = 0; i < left; i++) {
      arr1[i] = arr[low + i];
    }

    //build right sub array
    for (int i = 0; i < right; i++) {
      arr2[i] = arr[mid + 1 + i];
    }

    //merge two array
    int i = 0;
    int j = 0;
    int k = low;
    while (i < left && j < right) {
      if (arr1[i] <= arr2[j]) {
        arr[k++] = arr1[i++];

      } else {
        arr[k++] = arr2[j++];
      }
    }

    //at the end, left or right sub array may has remain elements
    while (i < left) {
      arr[k++] = arr1[i++];
    }
    while (j < right) {
      arr[k++] = arr2[j++];
    }
  }
}
