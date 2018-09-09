//left and right position
class Solution {
    public int maxDistToClosest(int[] seats) {
        class Solution {
            public int maxDistToClosest(int[] seats) {
        
                int[] left = new int[seats.length];
                int[] right = new int[seats.length];
                Arrays.fill(left, seats.length);
                Arrays.fill(right, seats.length);
        
                for (int i = 0; i < seats.length; i++) {
                    if (seats[i] == 1) {
                        left[i] = 0;
                    } else if (i > 0) {
                        left[i] = left[i-1] + 1;
                    }
                }
        
                for (int i = seats.length - 1; i >= 0; i--) {
                    if (seats[i] == 1) {
                        right[i] = 0;
                    } else if (i < seats.length - 1) {
                        right[i] = right[i + 1] + 1;
                    }
                }
        
        
                int maxLen = 0;
                for (int i = 0; i < seats.length; i++) {
                    if (seats[i] == 0) {
                        maxLen = Math.max(Math.min(left[i], right[i]), maxLen);
                    }
                }
                return maxLen;
        
            }
        }
        
    }
}

//double point
class Solution {
    public int maxDistToClosest(int[] seats) {

        int prev = -1;
        int end = 0;
        int maxLen = 0;

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                prev = i;
            } else {
                while (end < seats.length && seats[end] == 0 || end < i)
                    end++;

                int left = prev == -1 ? seats.length : i - prev;
                int right = end == seats.length ? seats.length : end - i;
                maxLen = Math.max(maxLen, Math.min(left, right));
            }
        }
        return maxLen;
    }
}