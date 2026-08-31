class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastIndex =
            new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            lastIndex.put(ch, i);
        }

        int cnt = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt++;
            end = Math.max(end, lastIndex.get(s.charAt(i)));

            if (i == end) {
                ans.add(cnt);
                cnt = 0;
            }
        }

        return ans;
    }
}
