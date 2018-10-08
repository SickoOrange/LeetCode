class Solution {

  public List<Integer> partitionLabels(String S) {
    List<Integer> res = new ArrayList<>();
    if (S == null || S.length() == 0) return res;
    if( S.length() == 1){
        res.add(1);
        return res;
    }  
    int[] last = new int[26];
    //calculate last index for every index
    for (int i = 0; i < S.length(); i++) {
      last[S.charAt(i) - 'a'] = i;
    }

    int max = 0, start = 0;
    for (int i = 0; i < S.length(); i++) {
      max = Math.max(max, last[S.charAt(i)-'a']);
      if (i == max) {
        res.add(max - start + 1);
        start = i + 1;
      }
    }
    return res;
  }
}
