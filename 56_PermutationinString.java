https://leetcode.com/problems/permutation-in-string/solution/

/**
 * solution 1 TLE, brute force list all the permutation of s1 and comparison with s2, whether one
 * possible permutation is the sublist of s2
 */
class Solution {

  boolean isSubString = false;


  public boolean checkInclusion(String s1, String s2) {

    createPermutations(s1, s2, 0);
    return isSubString;
  }


  private void createPermutations(String s1, String s2, int index) {

    //stop condition
    if (index == s1.length()) {
      if (s2.contains(s1)) {
        isSubString = true;
      }
    }

    for (int i = index; i < s1.length(); i++) {
      s1 = swap(s1, index, i);
      createPermutations(s1, s2, index + 1);
      //after first swap, we need to swap s1 to original s1 in order to satisfy the consistent
      s1 = swap(s1, index, i);
    }
  }

  private String swap(String s1, int index, int i) {
    char[] chars = s1.toCharArray();
    char c = chars[i];
    chars[i] = chars[index];
    chars[index] = c;
    return new String(chars);
  }
}

/**
 * solution 2 AC, sort string 1. the characters in string1 must also be contained in s2 and the
 * characters appearances time must also be equals 2. the characters in string1 must also be
 * consecutive : s1=ab, s2=eeaob, so s1 isn't substring of s2 so we can sort the s1 by alphabet and
 * the result of s1 must be the substring of s2! such as: a1=abc s2=bbbca
 *
 */
class Solution {

  public boolean checkInclusion(String s1, String s2) {
    s1 = sortString(s1);
    for (int i = 0; i <= s2.length() - s1.length(); i++) {
      if (s1.equals(sortString(s2.substring(i, i + s1.length())))) {
        return true;
      }
    }
    return false;
  }

  public String sortString(String s1) {
    char[] chars = s1.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }
}

/**
 * solution 3 AC, consider use hashmap to store the frequency of characters in s1. find all possible subString in
 * s2 which has same length as s1 and comparison: for every subString in s2 must habe same frequecy
 * with s1
 */
class Solution {

  public boolean checkInclusion(String s1, String s2) {
    Map<Character, Integer> mapS1 = new HashMap<>();
    for (char c : s1.toCharArray()) {
      mapS1.put(c, mapS1.getOrDefault(c, 0) + 1);
    }

    //for every sub String in S2 which has same length as s1
    for (int i = 0; i <= s2.length() - s1.length(); i++) {
      Map<Character, Integer> mapS2 = new HashMap<>();
      for (int j = 0; j < s1.length(); j++) {
        if (!mapS1.containsKey(s2.charAt(i + j))) {
         break;
        }
        mapS2.put(s2.charAt(i + j), mapS2.getOrDefault(s2.charAt(i + j), 0) + 1);
      }
      if (isMapEqual(mapS1, mapS2)) {
        return true;
      }

    }
    return false;
  }

  private boolean isMapEqual(Map<Character, Integer> mapS1, Map<Character, Integer> mapS2) {

    if (mapS1.keySet().size() != mapS2.keySet().size()) {
      return false;
    }

    for (Character c : mapS1.keySet()) {
      if (!mapS1.get(c).equals(mapS2.get(c))) {
        return false;
      }
    }
    return true;
  }
}

/**
 * solution 4 AC, sliding windows and use only only two array replace by generating new map or array
 * for every window
 */
class Solution {

  public boolean checkInclusion(String s1, String s2) {

    if (s1.length() > s2.length()) {
      return false;
    }
    int[] map1 = new int[26];
    int[] map2 = new int[26];

    for (int i = 0; i < s1.length(); i++) {
      map1[s1.charAt(i) - 'a']++;
      map2[s2.charAt(i) - 'a']++;
    }

    for (int i = 0; i < s2.length() - s1.length(); i++) {
      if (isArrayEqual(map1, map2)) {
        return true;
      }
      map2[s2.charAt(i) - 'a']--;
      map2[s2.charAt(i + s1.length()) - 'a']++;
    }
    return isArrayEqual(map1, map2);
  }

  private boolean isArrayEqual(int[] map1, int[] map2) {

    for (int i = 0; i < map1.length; i++) {
      if (map1[i] != map2[i]) {
        return false;
      }
    }
    return true;
  }
}
