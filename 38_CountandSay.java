class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";

        String lastStr = countAndSay(n - 1);

        StringBuilder builder = new StringBuilder();
        char ch = lastStr.charAt(0);
        int count = 1;
        for (int i = 1; i < lastStr.length(); i++) {
            if (lastStr.charAt(i) == lastStr.charAt(i - 1)) {
                count++;
            } else {
                builder.append(count).append(ch);
                ch=lastStr.charAt(i);
                count = 1;
            }
        }
        builder.append(count).append(ch);
        return builder.toString();
    }
}
