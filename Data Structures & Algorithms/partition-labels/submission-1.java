class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> occurrence =
            new HashMap<>();
        Map<Character, Integer> visited = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            occurrence.put(ch, occurrence.getOrDefault(ch, 0) + 1);
        }

        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt++;
            Character ch = s.charAt(i);
            visited.put(ch, visited.getOrDefault(ch, 0) + 1);

            if (visited.get(ch) == occurrence.get(ch)) {
                visited.remove(ch);
                if (visited.size() == 0) {
                    ans.add(cnt);
                    cnt = 0;
                }
            }
        }

        return ans;
    }
}
