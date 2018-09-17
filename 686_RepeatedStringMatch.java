
class Solution {
    public int repeatedStringMatch(String A, String B) {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < B.length() / A.length() + 2; i++) {
            builder.append(A);
            if (builder.toString().contains(B)) return i + 1;
        }

        return -1;
    }
}
