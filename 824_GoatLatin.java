class Solution {
    public String toGoatLatin(String S) {
        String[] strings = S.split(" ");
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('A');
        vowels.add('e');
        vowels.add('E');
        vowels.add('i');
        vowels.add('I');
        vowels.add('o');
        vowels.add('O');
        vowels.add('u');
        vowels.add('U');
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            if (vowels.contains(strings[i].charAt(0))) {
                builder.append(strings[i]).append("ma");
            } else {
                String temp = strings[i];
                char c = temp.charAt(0);
                builder.append(new StringBuilder(temp).deleteCharAt(0).append(c).append("ma"));
            }
            for (int j = 0; j <= i; j++) {
                builder.append("a");
            }
            builder.append(" ");
        }

        return builder.deleteCharAt(builder.length() - 1).toString();
    }
}
