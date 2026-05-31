class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> occurrence = new HashMap<>();

        for (char ch : s.toCharArray()) {
            if (occurrence.containsKey(ch)) {
                occurrence.put(ch, occurrence.get(ch)+1);
            } else {
                occurrence.put(ch, 1);
            }
        }

        for (char ch : t.toCharArray()) {
            if (occurrence.containsKey(ch)) {
                int cnt = occurrence.get(ch) - 1;
                if (cnt == 0) {
                   occurrence.remove(ch);
                   continue;
                }

                occurrence.put(ch, cnt);
            }
        }

        return occurrence.isEmpty();
    }

}
