class Solution {

  public boolean isPalindrome(String s) {

    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i))) {
        builder.append(s.charAt(i));
      }
    }

    if ("".equals(builder.toString())) {
      return true;
    }

    for (int i = 0; i <= (builder.length() - 1) / 2; i++) {
      char left = builder.charAt(i);
      char right = builder.charAt(builder.length() - 1 - i);
      if (left != right && Character.toLowerCase(left) - Character.toLowerCase(right) != 0) {
        return false;
      }
    }
    return true;
  }
}

//优化版本 一遍loop即可

class Solution {

  public boolean isPalindrome(String s) {

    int i = 0;
    int j = s.length() - 1;

    while (i < j) {
      while (i < s.length() - 1 && !isValid(s.charAt(i))) {
        i++;
      }

      while (j >= 1 && !isValid(s.charAt(j))) {
        j--;
      }
      if (i > j) {
        return true;
      }
      if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
        return false;
      } else {
        i++;
        j--;
      }
    }
    return true;
  }

  private boolean isValid(int i) {
    boolean a = i >= 'A' && i <= 'Z';
    boolean b = i >= 'a' && i <= 'z';
    boolean c = i >= '0' && i <= '9';
    return a || b || c;
  }
}

//在优化版本
class Solution {

  public boolean isPalindrome(String s) {

    int i = 0;
    int j = s.length() - 1;

    while (i < j) {
      if (!isValid(s.charAt(i))) {
        i++;
      } else if (!isValid(s.charAt(j))) {
        j--;
      } else {
        if (Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--))) {
          return false;
        }
      }

    }
    return true;
  }

  private boolean isValid(int i) {
    boolean a = i >= 'A' && i <= 'Z';
    boolean b = i >= 'a' && i <= 'z';
    boolean c = i >= '0' && i <= '9';
    return a || b || c;
  }
}
