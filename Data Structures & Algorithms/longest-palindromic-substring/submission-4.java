class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String longest = "";

        // Base case: single characters are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            if (1 > longest.length()) {
                longest = s.substring(i, i + 1);
            }
        }

        // Length 2 palindromes
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                if (2 > longest.length()) {
                    longest = s.substring(i, i + 2);
                }
            }
        }

        // Length >= 3
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (len > longest.length()) {
                        longest = s.substring(i, j + 1);
                    }
                }
            }
        }

        return longest;
    }
}