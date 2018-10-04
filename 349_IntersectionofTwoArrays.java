//   class Solution {
//       public int[] intersection(int[] nums1, int[] nums2) {
//         Arrays.sort(nums1);
//         Arrays.sort(nums2);
//         int i=0;
//         int j=0;
//         Set<Integer> res=new HashSet<>();
//         while(i<nums1.length && j<nums2.length){
//           if(nums1[i]==nums2[j]){
           
//             res.add(nums1[i]);
//                i++;
//             j++;
//           }else if(nums1[i]<nums2[j]){
//             i++;
//           }else{
//             j++;
//           }
//         }

//         int index=0;
//         int[] array=new int[res.size()];
//         for(int a:res){
//           array[index++]=a;
//         }

//         return array;
//       }
//     }

//最优解
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
     	int l1 = nums1.length;
		int l2 = nums2.length;
		if (l1 == 0 || l2 == 0 || nums1 == null || nums2 == null) {
			return new int[0];
		}
		int maxValue = Integer.MIN_VALUE;
		int minValue = Integer.MAX_VALUE;

		for (int i : nums1) {
			if (i < minValue) {
				minValue = i;
			}
			if (i > maxValue) {
				maxValue = i;
			}
		}

		boolean[] track = new boolean[maxValue - minValue + 1];
		for (int i : nums1) {
			track[i - minValue] = true;
		}
		int idx = 0;
		for (int i : nums2) {
			if (i >= minValue && i <= maxValue && track[i - minValue]) {
				track[i - minValue] = false;
				nums1[idx] = i;
				idx++;
			}
		}
		return Arrays.copyOf(nums1, idx);       
    }
}
