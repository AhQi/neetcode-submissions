class Solution {
    public String longestPalindrome(String s) {
        int resIdx = 0;
        int resLen = 0;
        int n = s.length();
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int r = 0; r < n; r++) {
            for (int l = r; l >= 0; l--) {
                if (s.charAt(r) == s.charAt(l) && (r - l <= 2 || dp[l+1][r-1])) {
                    dp[l][r] = true;

                    if (resLen < (r - l + 1)) {
                        resIdx = l;
                        resLen = r - l + 1;
                    }
                }
            }
        } 

        return s.substring(resIdx, resIdx + resLen);
    }
}
