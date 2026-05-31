class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> occurrence = new HashMap<>();
        int lcs = 0;
        for (int num : nums) {
            occurrence.put(num, true);
        }

        for (int num : nums) {
            if (occurrence.containsKey(num - 1)) {
                continue;
            }

            int tmp = 0;
            int cur = num;
            while (occurrence.containsKey(cur)) {
                cur++;
                tmp++;
            }

            lcs = Math.max(lcs, tmp);
        }

        return lcs;
    }
}
