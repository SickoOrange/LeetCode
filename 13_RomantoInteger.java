class Solution {

  public int romanToInt(String s) {

    char[] chars = s.toCharArray();
    int[] value = new int[chars.length];

    for (int i = 0; i < chars.length; i++) {
      value[i] = getIngeter(chars[i]);
    }

    int sum = 0;
    for (int i = 0; i < value.length; i++) {

      if (i + 1 < value.length) {
        if (value[i + 1] > value[i]) {
          sum += value[i + 1] - value[i];
          i++;
        } else {
          sum += value[i];
        }
      } else {
        sum += value[i];
      }

    }
    return sum;
  }

  public int getIngeter(char c) {
    switch (c) {
      case 'I':
        return 1;
      case 'V':
        return 5;
      case 'X':
        return 10;
      case 'L':
        return 50;
      case 'C':
        return 100;
      case 'D':
        return 500;
      case 'M':
        return 1000;
    }
    return 0;
  }
}
