class Solution {
    public int[] sortArrayByParity(int[] A) {
        
        int i=0;
        for(int j=0;j<A.length;j++){
            if(A[j] % 2 == 0){
                int temp=A[i];
                A[i++]=A[j];
                A[j]=temp;
            }
        }
        return A;
        
    }
}


//has a better performance!
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int j=A.length;
        int[] arr=new int[j--];
        int i=0;
        for(int k=0;k<A.length;k++){
            if(A[k]%2==0){
                arr[i++]=A[k];
            }else{
                arr[j--]=A[k];
            }
        }
        return arr;
    }
}