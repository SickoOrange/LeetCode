class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'U':
                    x--;
                    break;
                case 'D':
                    x++;
                    break;
                case 'L':
                    y--;
                    break;
                case 'R':
                    y++;
                    break;

            }
        }
        return x == 0 && y == 0;
    }
}

class Solution {
    public boolean judgeCircle(String moves) {
        int[] count = new int[90];
        for(char ch:moves.toCharArray())
            count[ch]++;
        if(count['U']!=count['D'])
            return false;
        if(count['R']!=count['L'])
            return false;
        return true;
    }
}
