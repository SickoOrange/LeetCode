class Solution {
    public int[] plusOne(int[] digits) {

        int bit = 0;
        int N = digits.length - 1;
        digits[N] = (digits[N] + 1) % 10;
        bit = (digits[N] + 1) / 10;
        for (int i = digits.length - 2; i >= 0; i--) {
            if (bit != 0) {
                digits[i] = (digits[i] + bit) % 10;
                bit = (digits[i] + bit) / 10;
            }
        }
        if (bit == 0) {
            return digits;
        } else {
            int[] nums = new int[1 + digits.length];
            nums[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                nums[i + 1] = digits[i];
            }
            return nums;
        }
    }
}