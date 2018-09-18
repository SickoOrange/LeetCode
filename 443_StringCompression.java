class Solution {

  public int compress(char[] chars) {
    int position = 0;
    int point = 0;

    while (point < chars.length) {
      int count = 0;
      char ch = chars[point];
      while (point < chars.length && chars[point] == ch) {
        point++;
        count++;
      }
      chars[position++] = ch;
      if (count > 1) {
        for (char c : String.valueOf(count).toCharArray()) {
          chars[position++] = c;
        }
      }
    }
    return position;
  }
}
