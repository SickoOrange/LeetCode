class Solution {

  public boolean validPalindrome(String s) {

    for (int i = 0; i < s.length() / 2; i++) {
      if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
        return isValid(s, i, s.length() - i - 2) || isValid(s, i + 1, s.length() - i - 1);
      }
    }

    return true;

  }

  private boolean isValid(String s, int i, int j) {
    for (int m = i; m <= i + (j - i) / 2; m++) {
      if (s.charAt(m) != s.charAt(j - (m-i))) {
        return false;
      }
    }
    return true;
  }
}
