class Solution {
    public String[] findWords(String[] words) {
        String first = "qwertyuiop";
        String second = "asdfghjkl";
        String third = "zxcvbnm";
        List<String> list = new ArrayList<>();
        for (String word : words) {
            char[] chars = word.toLowerCase().toCharArray();
            int a = 0;
            int b = 0;
            int c = 0;
            for (char ch : chars) {
                if (first.contains(Character.toString(ch))) {
                    a = 1;
                } else if (second.contains(Character.toString(ch))) {
                    b = 1;
                } else if (third.contains(Character.toString(ch))) {
                    c = 1;
                }
                if (a + b + c > 1) break;
            }
            if (a + b + c == 1) list.add(word);

        }
        String[] res=new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i]=list.get(i);
        }
        return res;
    }
}