class Solution {
    Integer[][] memo;
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        memo = new Integer[m+1][n+1];
        return dfs(word1, word2, 0, 0);
    }

    private int dfs(String word1, String word2, int i, int j) {
        int m = word1.length();
        int n = word2.length();
        if (i >= m) {
            return n - j;
        }
        if (j >= n) {
            return m - i;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        int ans = Integer.MAX_VALUE;

        if (word1.charAt(i) == word2.charAt(j)) {
            ans = Math.min(ans, dfs(word1, word2, i+1, j+1));
        } else {
            ans = Math.min(ans,
                Math.min(1+dfs(word1, word2, i+1, j+1), 1+dfs(word1, word2, i, j+1))
            );

            ans = Math.min(ans, 1+dfs(word1, word2, i+1, j));
        }

        
        memo[i][j] = ans;
        return ans;
    }
}
