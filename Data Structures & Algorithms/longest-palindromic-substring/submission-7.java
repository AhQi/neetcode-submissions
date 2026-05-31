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

        for (int len = 2; len <= s.length(); len++) {
            for (int start = 0; start + len <= s.length(); start++) {
                if (len == 2 && s.charAt(start) == s.charAt(start + len - 1)) {
                    dp[start][start + len - 1] = true;
                    longest = s.substring(start, start + len);
                    continue;
                }

                if (s.charAt(start) == s.charAt(start + len - 1) && dp[start + 1][start+len-2]) {
                    dp[start][start + len - 1] = true;
                    longest = s.substring(start, start + len);
                }
            }
        }

        return longest;
    }
}