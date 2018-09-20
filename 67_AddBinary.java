class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder builder = new StringBuilder();

        int pa = a.length() - 1;
        int pb = b.length() - 1;

        while (pa >= 0 || pb >= 0) {
            int bita = pa < 0 ? 0 : a.charAt(pa) - '0';
            int bitb = pb < 0 ? 0 : b.charAt(pb) - '0';
            builder.append((bitb + bita + carry) % 2);
            carry = bita + bitb + carry >= 2 ? 1 : 0;
            pa--;
            pb--;
        }

        if (carry == 1) {
            return builder.append(1).reverse().toString();
        }
        return builder.reverse().toString();
    }
}
