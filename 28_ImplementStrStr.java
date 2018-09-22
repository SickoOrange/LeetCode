//brute force solution
// 74case 11ms
 class Solution {
        public int strStr(String haystack, String needle) {
            if ("".equals(needle)) {
                return 0;
            }

            int i = 0;
            int j = 0;

            while (i < haystack.length()) {
                if (haystack.charAt(i) == needle.charAt(j)) {
                    i++;
                    j++;
                } else {
                    i = i - j + 1;
                    j = 0;
                }

                if (j == needle.length()) {
                    return i-j;
                }
            }

            return -1;
        }
    }
    
    //java api String.indexOf() solution
    // 74 cases 4ms
       class Solution {
        public int strStr(String haystack, String needle) {
            return haystack.indexOf(needle);
        }
    }
    
    //KMP solution 
    // 74cases 6ms
    class Solution {
    public int strStr(String haystack, String needle) {
        return kmp(haystack, needle);
    }

    private int kmp(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        int[] next = getPatternNext(needle);

        char[] text = haystack.toCharArray();
        char[] pattern = needle.toCharArray();
        int s = text.length;
        int p = pattern.length;

        int i = 0;
        int j = 0;
        while (i < text.length && j < pattern.length) {
            if (j == -1 || text[i] == pattern[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j == pattern.length) return i - j;
        return -1;
    }

    private int[] getPatternNext(String needle) {
        char[] chars = needle.toCharArray();
        int next[] = new int[chars.length];
        int k = -1;
        int j = 0;
        next[0] = -1;

        while (j < next.length - 1) {
            if (k == -1 || chars[j] == chars[k]) {
                j++;
                k++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }

        return next;
    }
}
