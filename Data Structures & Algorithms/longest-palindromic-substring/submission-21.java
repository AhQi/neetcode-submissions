class Solution {
    public String longestPalindrome(String s) {
        int resLen = 0;
        int resIdx = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for(int l = n - 1; l >= 0; l--) {
            for (int r = l; r < n; r++) {
                if (s.charAt(r) == s.charAt(l) &&
                    (r - l < 2 || dp[l+1][r-1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > resLen) {
                        resIdx = l;
                        resLen = r -l +1;
                    }
                }
            }
        }

        return s.substring(resIdx, resIdx + resLen);
    }
}
