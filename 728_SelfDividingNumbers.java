class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list=new ArrayList<>();
        for(int i= left;i<=right;i++)
            if(isSelfDivide(i)) list.add(i);
        
        return list;
    }
    
    public boolean isSelfDivide(int i){
        int temp=i;
        while(temp != 0){
            if(temp % 10 ==0 || i % (temp % 10) !=0) return false;
            temp/=10;
        }
        return true;
    }
}