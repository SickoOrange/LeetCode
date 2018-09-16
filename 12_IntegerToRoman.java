
class Solution {
    public String intToRoman(int num) {

        Map<Integer, String> map = new TreeMap<>();
        StringBuilder builder = new StringBuilder();

        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < nums.length; i++) {
            while (num >= nums[i]) {
                num -= nums[i];
                builder.append(romans[i]);
            }
        }

        return builder.toString();

    }

}

