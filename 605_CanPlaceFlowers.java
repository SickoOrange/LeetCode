class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        //if no flower need to be placed always return true;
        if (n == 0) return true;
        int start = -1;
        int end = 0;

        for (int i = 0; i < flowerbed.length; i++) {

            if (flowerbed[i] == 1) {
                start = i;
            } else {

                while (end < flowerbed.length && flowerbed[end] == 0 || end < i)
                    end++;

                int left = start == -1 ? flowerbed.length : i - start;
                int right = end == flowerbed.length ? flowerbed.length : end - i;

                int minDistance = Math.min(left, right);
                //second condition for: [0]:1
                if (minDistance >= 2 || (minDistance == 1 && flowerbed.length == 1)) {
                    //can place a flower
                    flowerbed[i] = 1;
                    start = i;
                    n--;
                    if (n == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
