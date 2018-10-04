class Solution {
    public boolean isAnagram(String s, String t) {
        
        int[] trace=new int[26];
        for(char c: s.toCharArray()){
            trace[c-'a']++;
        }
        for(char c: t.toCharArray()){
            trace[c-'a']--;
        }
        
        for(int i=0;i<trace.length;i++){
            if(trace[i]!=0) return false;
        }
        return true;
        
    }
}
