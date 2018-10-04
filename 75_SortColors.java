//count algorithm
class Solution {
    public void sortColors(int[] nums) {
        int r=0;
        int w=0;
        int b=0;
        
        for(int i:nums){
            if(i==0) r++;
            if(i==1) w++;
            if(i==2) b++;
        }
        
        for(int i=0;i<nums.length;i++){
            if(r-->0) nums[i]=0;
            else if(w-->0) nums[i]=1;
            else nums[i]=2;
        }    
    }
}
// quick sort algorithm thought selecta pilot as 1, all elements less than pilot
//will be putted into left part and all elements greater than pilot will be putted in right poart
class Solution{
    public void sortColors(int[] nums){
        if(nums==null || nums.length==1) return;
        int i=0;
        int j=0;
        int len=nums.length-1;
        int pilot=1;
        while(j<=len){
            if(nums[j]<pilot){
                //left element only 0 or 1, so we need after swap increment j
                swap(nums,j++,i++);
            }else if(nums[j]>pilot){
                // right elemnet can 1,2,0, we need also check again
                swap(nums,j,len--);
            }else{
                j++;
            }
        }
    }
    
    public void swap(int[] nums, int i,int j){
        int temp=nums[j];
        nums[j]=nums[i];
        nums[i]=temp;
    }
}
