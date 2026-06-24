class Solution {
    Map<String, Boolean> map;
    public boolean wordBreak(String s, List<String> wordDict) {
        map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (String ss : wordDict) {
            set.add(ss);
            map.put(ss, true);
        }

        return breakWord(s, set);
    }

    private boolean breakWord(String s, Set<String> set) {
        if (s.length() == 0 || set.contains(s)) {
            return true;
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }
        boolean canBreak = false;

        for (String word : set) {
            
            if (s.length() >= word.length()) {
                String subString = s.substring(0, word.length());
                if (!subString.equals(word)) {
                    continue;
                }
                canBreak |=
                    breakWord(s.substring(word.length(), s.length()), set);
            }
        }

        map.put(s, canBreak);
        
        return canBreak;
    }
}
