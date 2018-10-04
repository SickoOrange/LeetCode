class Solution {
    public String findLongestWord(String s, List<String> d) {
            if (s.length() == 0 || d.size() == 0 || s == null || d == null) {
                return "";
            }
        Queue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o2.length() - o1.length();
                } else {
                    return o1.compareTo(o2);
                }
            }
        });

        for (String sub : d) {
            if (isSubSet(s, sub)) {
                queue.offer(sub);
            }
        }
        return queue.peek()==null?"":queue.peek();

    }

        private boolean isSubSet(String s, String dic) {
            int index = -1;
            for (int i = 0; i < dic.length(); i++) {
                index = s.indexOf(dic.charAt(i), index + 1);
                if (index < 0) {
                    return false;
                }
            }
            return true;
        }
}

