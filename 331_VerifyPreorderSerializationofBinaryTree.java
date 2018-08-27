class Solution {

    public boolean isValidSerialization(String preorder) {
  
      int counter = 0;
      String[] strings = preorder.split(",");
      for (int i = 0; i < strings.length - 1; i++) {
        if (counter < 0) {
          return false;
        }
        if (strings[i].equals("#")) {
          if (i == 0) {
            return false;
          }
          counter--;
        } else {
          counter++;
        }
      }
  
      return counter == 0 && strings[strings.length - 1].equals("#");
    }
  }