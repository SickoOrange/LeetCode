class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] code = {
                ".-", "-...", "-.-.", "-..", ".", "..-.",
                "--.", "....", "..", ".---", "-.-",
                ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...",
                "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
        };
        Set<String> res = new HashSet<>();
        for (String string : words) {
            StringBuilder builder = new StringBuilder();
            for (char c : string.toCharArray()) {
                builder.append(code[c - 'a']);
            }
            res.add(builder.toString());
        }
        return res.size();
    }

}
