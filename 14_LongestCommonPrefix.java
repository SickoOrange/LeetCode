
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
