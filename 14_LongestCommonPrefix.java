
//solution 1: horizontal scanning
class Solution {
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) return "";
        String commonPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (commonPrefix.length() >= 1 && strs[i].indexOf(commonPrefix) != 0) {
                commonPrefix = commonPrefix.substring(0, commonPrefix.length() - 1);
            }
        }
        return commonPrefix;
    }
}

//vertical scanning
class Solution {
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        String commonPrefix = strs[0];

        for (int i = 0; i < commonPrefix.length(); i++) {
            char ch = commonPrefix.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                //if i == current string's length or i!= current char
                if (i == strs[j].length() || ch != strs[j].charAt(i)) {
                    //this is max commen prefix
                    commonPrefix = commonPrefix.substring(0, i);
                }
            }
        }
        return commonPrefix;
    }
}

//divide and conquer
class Solution {
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        return divideAndConquer(strs, 0, strs.length - 1);
    }

    private String divideAndConquer(String[] strs, int l, int r) {

        if (l == r) return strs[l];

        int mid = (l + r) / 2;

        String left = divideAndConquer(strs, l, mid);
        String right = divideAndConquer(strs, mid + 1, r);

        while (left.indexOf(right) != 0) {
            right=right.substring(0, right.length() - 1);
        }
        return right;
       
        //int min = Math.min(left.length(), right.length());       
        //for (int i = 0; i < min; i++) {
        //if ( left.charAt(i) != right.charAt(i) )
        //    return left.substring(0, i);
        //}
        //return left.substring(0, min);
        
    }
}
