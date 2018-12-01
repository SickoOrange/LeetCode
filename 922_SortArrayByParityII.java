class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int len=A.length;
        int j=1;
        for(int i =0;i<len-1;i+=2){
            if((A[i]&1)!=0){
                while((A[j]&1)!=0){
                    j+=2;
                }
                swap(A,i,j);
            }
        }
        return A;
    }
    
    public void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}