class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int len=A.length;
        int res=0;
        for(int i =0; i< len; i++){
            if(A[i]>A[i+1]){
                res=i;
                break;
            }
        }
        return res;
    }
}