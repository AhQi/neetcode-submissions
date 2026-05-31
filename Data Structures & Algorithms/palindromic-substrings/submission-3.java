class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;
        for (int l = 1; l <= s.length(); l++) {
            for (int i = 0; i+l <= s.length(); i++) {

                if (s.charAt(i) == s.charAt(i+l-1) &&
                   (l <= 2 || dp[i+1][i+l-2])) {
                    count++;
                    dp[i][i+l-1] = true;
                }
            }
        }

        return count;
    }
}
