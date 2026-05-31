class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;
        for (int l = 1; l <= s.length(); l++) {
            for (int i = 0; i < s.length(); i++) {
                if (l == 1) {
                    count++;
                    dp[i][i] = true;
                    continue;
                }

                if (l == 2 && i+l <= s.length() && s.charAt(i) == s.charAt(i+1)) {
                    count++;
                    dp[i][i+1] = true;
                    continue;
                }

                if (i+l <= s.length() && s.charAt(i) == s.charAt(i+l-1) && dp[i+1][i+l-2]) {
                    count++;
                    dp[i][i+l-1] = true;
                }
            }
            // int l = i, r = i;
            // while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            //     count++;
            //     l--;
            //     r++;
            // }

            // l = i;
            // r = i+1;
            // while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            //     count++;
            //     l--;
            //     r++;
            // }
        }

        return count;
    }
}
