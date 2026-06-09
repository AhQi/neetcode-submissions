class Solution {
    public String longestPalindrome(String s) {
        int resIdx = 0;
        int resLen = 0;
        int n = s.length();
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = s.length() - 1;i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;

                    if (resLen < (j - i + 1)) {
                        resIdx = i;
                        resLen = j - i + 1;
                    }
                }
            }
        } 

        return s.substring(resIdx, resIdx + resLen);
    }
}
