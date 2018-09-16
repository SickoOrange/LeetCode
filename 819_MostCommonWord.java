class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] graphs = paragraph.split(" ");
        Map<String, Integer> map = new TreeMap<>();
        for (String graph : graphs) {
            String check = graph.toLowerCase();
            if (check.length() > 1 && !Character.isAlphabetic(check.charAt(check.length() - 1))) {
                check = check.substring(0, check.length() - 1);
            }
            if (map.containsKey(check)) {
                map.put(check, map.get(check) + 1);
            } else {
                map.put(check, 1);
            }
        }

        String mostFrequentString = "";
        int mostFrequent = 0;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            String string = e.getKey();
            int count = e.getValue();
            if (count > mostFrequent && isNotBanned(string, banned)) {
                mostFrequent = count;
                mostFrequentString = string;
            }
        }

        return mostFrequentString;
    }

    private boolean isNotBanned(String string, String[] banned) {

        for (String s : banned) {
            if (s.equals(string)) return false;
        }
        return true;
    }
}