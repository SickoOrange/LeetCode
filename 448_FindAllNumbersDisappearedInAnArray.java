class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] bitMap=new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            bitMap[nums[i]-1]++;
        }

        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < bitMap.length; i++) {
                if(bitMap[i]==0){
                    list.add(i+1);
                }
        }

        return list;
    }
}
