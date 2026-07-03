class Solution {
    public int countSubstrings(String s) {
        int cnt = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int l = n-1; l >= 0; l--) {
            for (int r = l; r < n; r++) {
                if (s.charAt(l) != s.charAt(r)) {
                    continue;
                }
                if (r - l <= 2 || dp[l+1][r-1]) {
                    cnt++;
                    dp[l][r] = true;
                }
            }
        }
        return cnt;
    }
}
